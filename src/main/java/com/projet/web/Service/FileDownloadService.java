package com.projet.web.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.projet.web.exception.FileNotFoundException;
import com.projet.web.exception.FileStorageException;
import com.projet.web.Model.FileDownloadModel;
import com.projet.web.Repository.DatabaseFileRepository;

@Service
public class FileDownloadService {
    @Autowired
    private DatabaseFileRepository dbFileRepository;

    public FileDownloadModel storeFile(MultipartFile file) {
        
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
          
            if(fileName.contains("..")) {
                throw new FileStorageException("Désolé! Le nom de fichier contient une séquence de chemin non valide " + fileName);
            }

            FileDownloadModel dbFile = new FileDownloadModel(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Impossible de stocker le fichier " + fileName + ". Veuillez réessayer!", ex);
        }
    }

    public FileDownloadModel getFile(String fileName) {
        return dbFileRepository.findByFileName(fileName)
                .orElseThrow(() -> new FileNotFoundException("Fichier introuvable avec le nom " + fileName));
    }

}