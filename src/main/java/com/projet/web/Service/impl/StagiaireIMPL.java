package com.projet.web.Service.impl;
import com.projet.web.Dto.StagiaireDTO;
import com.projet.web.Dto.LoginDTO;
import com.projet.web.Model.Login;
import com.projet.web.Repository.StagiaireRepo;
import com.projet.web.Service.StagiaireService;
import com.projet.web.response.LoginMesage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class StagiaireIMPL implements StagiaireService {
    @Autowired
    private StagiaireRepo stagiaireRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addStagiaire(StagiaireDTO stagiaireDTO) {
        Login login = new Login(
                stagiaireDTO.getStagiaireid(),
                stagiaireDTO.getStagiairename(),
                stagiaireDTO.getEmail(),
               this.passwordEncoder.encode(stagiaireDTO.getPassword())
        );
        stagiaireRepo.save(login);
        return login.getStagiairename();
    }
    StagiaireDTO stagiaireDTO;
    @Override
    public LoginMesage  loginStagiaire(LoginDTO loginDTO) {
        String msg = "";
        Login login1 = stagiaireRepo.findByEmail(loginDTO.getEmail());
        if (login1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = login1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Login> login = stagiaireRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (login.isPresent()) {
                    return new LoginMesage("Login Success", true);
                } else {
                    return new LoginMesage("Login Failed", false);
                }
            } else {
                return new LoginMesage("password Not Match", false);
            }
        }else {
            return new LoginMesage("Email not exits", false);
        }
    }
	
}