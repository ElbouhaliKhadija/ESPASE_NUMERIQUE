package com.projet.web.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projet.web.Model.Profil;

@Repository
public interface ProfilRepository extends CrudRepository<Profil,Long> {

}
