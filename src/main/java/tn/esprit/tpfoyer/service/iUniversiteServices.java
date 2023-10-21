package tn.esprit.tpfoyer.service;



import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface iUniversiteServices {
    Universite ajouterUniversite(Universite u);
    void supprimerUniversite(long idUniversite);
    Universite getUniversite(long idUniversite);

    List<Universite> getAllUniversite();
    Universite updateUniversite(Universite u);
}
