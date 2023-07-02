package com.projet.web.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.web.Model.FileDownloadModel;


@Repository
public interface DatabaseFileRepository extends JpaRepository<FileDownloadModel, String> {
    Optional<FileDownloadModel> findByFileName(String fileName);
}
