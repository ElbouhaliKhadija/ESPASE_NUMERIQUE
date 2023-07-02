package com.projet.web.Controller;
import com.projet.web.Dto.StagiaireDTO;
import com.projet.web.Dto.LoginDTO;
import com.projet.web.Service.StagiaireService;
import com.projet.web.response.LoginMesage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class Stagiaire_Controller {
    @Autowired
    private StagiaireService stagiaireservice;
    @PostMapping(path = "/save")
    public String saveStagiaire(@RequestBody StagiaireDTO stagiaireDTO)
    {
        String id = stagiaireservice.addStagiaire(stagiaireDTO);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginStagiaire(@RequestBody LoginDTO loginDTO)
    {
    	LoginMesage loginMesage = stagiaireservice.loginStagiaire(loginDTO);
        return ResponseEntity.ok(loginMesage);
    }
}