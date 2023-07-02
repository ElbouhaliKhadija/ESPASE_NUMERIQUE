package com.projet.web.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projet.web.Model.Profil;
import com.projet.web.Repository.ProfilRepository;
import com.projet.web.response.ProfilNotFoundException;

@Service
public class ProfilServices {
	@Autowired
    private ProfilRepository repo;
	
	public Iterable<Profil> listAll() {
        return this.repo.findAll();
    }
	
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(int id, Profil updatedProfil) {
	    Optional<Profil> existingProfilOptional = repo.findById((long) id);

	    if (existingProfilOptional.isPresent()) {
	        Profil existingProfil = existingProfilOptional.get();
	        existingProfil.setPhoto(updatedProfil.getPhoto());
	        existingProfil.setNom(updatedProfil.getNom());
	        existingProfil.setPrenom(updatedProfil.getPrenom());
	        existingProfil.setCin(updatedProfil.getCin());
	        existingProfil.setEmail(updatedProfil.getEmail());
	        existingProfil.setTel(updatedProfil.getTel());
	        existingProfil.setSite_formation(updatedProfil.getSite_formation());
	        existingProfil.setPrenom_arabe(updatedProfil.getPrenom_arabe());
	        existingProfil.setNom_arabe(updatedProfil.getNom_arabe());
	        existingProfil.setAncien_password(updatedProfil.getAncien_password());
	        existingProfil.setNouveau_password(updatedProfil.getNouveau_password());
	        existingProfil.setEtablessement_stage(updatedProfil.getEtablessement_stage());
	        repo.save(existingProfil);
	    } else {
	        throw new ProfilNotFoundException("Profil introuvable avec l'ID : " + id);
	    }
	}

	public void savee(Profil students)   
	{  
		repo.save(students);  
	} 
	
	public Profil getStudentById(long id)   
	{  
		return repo.findById(id).get();  
	}
		 
		 
	public void update(Profil students, int id)   
	{  
		repo.save(students);  
	}  	

	public void delete(long id)   
	{  
		repo.deleteById(id);  
	}  
}