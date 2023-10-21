package tn.esprit.tpfoyer.service;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface iUniversiteServices {
    Universite ajouterUniversite(Universite u);
    void supprimerUniversite(long idUniversite);
    Universite getUniversite(long idUniversite);

    List<Universite> getAllUniversite();
    Universite updateUniversite(Universite u);

    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);
}
