package com.projet.web.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.web.Model.Profil;
import com.projet.web.Service.ProfilServices;
import com.projet.web.response.ProfilNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


@RestController
public class ProfilController {
	@Autowired
	 private ProfilServices services;
	 
	 @GetMapping("/getall")
	 public Iterable<Profil>getStudents() 
	 {
		 return services.listAll();     
	 }

	    @PostMapping(value = "/savep", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public ResponseEntity<?> saveProfil(
	            @RequestPart(name = "photo", required = false) MultipartFile file,
	            @RequestPart(name = "profil") String profilJson) {

	        if (file == null || file.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veuillez fournir une photo");
	        }

	        ObjectMapper objectMapper = new ObjectMapper();
	        Profil profil;
	        try {
	            profil = objectMapper.readValue(profilJson, Profil.class);
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la lecture des données du profil");
	        }

	        String fileName = file.getOriginalFilename();
	        try {
	            file.transferTo(new File(fileName));
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de l'enregistrement de la photo");
	        }

	        profil.setPhoto(fileName);
	        services.savee(profil);

	        return ResponseEntity.ok(profil.getId());
	    }

	
	 @RequestMapping("/student/{id}")  
	 private Profil getProfil(@PathVariable(name = "id") int studentid)   
	 {  
	 return services.getStudentById(studentid);  
	 }  
	 
	    
	 @PutMapping(value = "/edit/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	 public ResponseEntity<?> updateProfil(
	         @PathVariable("id") int id,
	         @RequestParam(name = "photo", required = false) MultipartFile file,
	         @RequestParam(name = "profil") String profilJson) {

	     if (file == null || file.isEmpty()) {
	         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veuillez fournir une photo");
	     }

	     ObjectMapper objectMapper = new ObjectMapper();
	     Profil updatedProfil;
	     try {
	         updatedProfil = objectMapper.readValue(profilJson, Profil.class);
	     } catch (IOException e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la lecture des données du profil");
	     }

	     String fileName = file.getOriginalFilename();
	     try {
	         file.transferTo(new File(fileName));
	     } catch (IOException e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de l'enregistrement de la photo");
	     }

	     updatedProfil.setPhoto(fileName);
	     try {
	         services.saveOrUpdate(id, updatedProfil);
	     } catch (ProfilNotFoundException e) {
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	     } catch (Exception e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la mise à jour du profil");
	     }

	     return ResponseEntity.ok(updatedProfil);
	 }


	

	 @DeleteMapping("/delete/{id}")  
	 private void deleteStudent(@PathVariable("id") int id)   
	 {  
		 services.delete(id);  
	 }  
}

