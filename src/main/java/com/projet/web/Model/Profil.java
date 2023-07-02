package com.projet.web.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Profil")
public class Profil {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
    @Column(name="photo")
    private String photo;
    
    @Column(name="nom")
    private String nom;
    
    @Column(name="prenom")
    private String prenom;
    
    @Column(name="cin")
    private String 	cin;
    
    @Column(name="email")
    private String email;
    
    @Column(name="tel")
    private String tel;
    
    @Column(name="site_formation")
    private String site_formation;
    
    
    @Column(name="prenom_arabe")
    private String prenom_arabe;
    
    @Column(name="nom_arabe")
    private String nom_arabe;
    
    @Column(name="ancien_password")
    private String ancien_password;
    
    @Column(name="nouveau_password")
    private String nouveau_password;
    
    @Column(name="etablessement_stage")
    private String etablessement_stage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSite_formation() {
		return site_formation;
	}

	public void setSite_formation(String site_formation) {
		this.site_formation = site_formation;
	}

	public String getPrenom_arabe() {
		return prenom_arabe;
	}

	public void setPrenom_arabe(String prenom_arabe) {
		this.prenom_arabe = prenom_arabe;
	}

	public String getNom_arabe() {
		return nom_arabe;
	}

	public void setNom_arabe(String nom_arabe) {
		this.nom_arabe = nom_arabe;
	}

	public String getAncien_password() {
		return ancien_password;
	}

	public void setAncien_password(String ancien_password) {
		this.ancien_password = ancien_password;
	}

	public String getNouveau_password() {
		return nouveau_password;
	}

	public void setNouveau_password(String nouveau_password) {
		this.nouveau_password = nouveau_password;
	}

	public String getEtablessement_stage() {
		return etablessement_stage;
	}

	public void setEtablessement_stage(String etablessement_stage) {
		this.etablessement_stage = etablessement_stage;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}



	

	}
