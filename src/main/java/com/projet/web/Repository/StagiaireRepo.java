package com.projet.web.Repository;

import com.projet.web.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@EnableJpaRepositories
@Repository

public interface StagiaireRepo extends JpaRepository<Login,Integer>
{
      Optional<Login> findOneByEmailAndPassword(String email, String password);
    Login findByEmail(String email);
}