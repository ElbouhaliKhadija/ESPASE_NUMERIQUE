package com.projet.web.Service;
import com.projet.web.Dto.StagiaireDTO;
import com.projet.web.Dto.LoginDTO;
import com.projet.web.response.LoginMesage;

public interface StagiaireService {
    String addStagiaire(StagiaireDTO stagiaireDTO);
    LoginMesage loginStagiaire(LoginDTO loginDTO);
}