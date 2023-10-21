package tn.esprit.tpfoyer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.iFoyerRepository;
import tn.esprit.tpfoyer.repository.iUniversiteRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UniversiteServices implements iUniversiteServices {

    final iUniversiteRepository UniversiteRepository;
    final iFoyerRepository foyerRepository;

    @Override
    public Universite ajouterUniversite(Universite u) {
        return UniversiteRepository.save(u);
    }

    @Override
    public void supprimerUniversite(long idUniversite) {
        UniversiteRepository.deleteById(idUniversite);

    }

    @Override
    public Universite getUniversite(long idUniversite) {
        return UniversiteRepository.findById(idUniversite).orElseGet(null);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return (List<Universite>)UniversiteRepository.findAll();
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return UniversiteRepository.save(u);
    }


    public Universite findUniversiteByNom(String nomUniversite) {
        return UniversiteRepository.findUniversiteByNom(nomUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        Universite universite = UniversiteRepository.findUniversiteByNom(nomUniversite);

        if (foyer != null && universite != null) {
            universite.setFoyer(foyer);
            UniversiteRepository.save(universite);
        }

        return universite;
    }

    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Universite universite = UniversiteRepository.findById(idUniversite).orElse(null);

        if (universite != null) {
            // Vérifier si le foyer actuellement associé à l'université correspond à l'ID du foyer que vous souhaitez désaffecter.
            if (universite.getFoyer() != null && universite.getFoyer().getIdFoyer() == idFoyer) {
                // Désaffectez le foyer en le supprimant de l'université.
                universite.setFoyer(null);
                UniversiteRepository.save(universite);
            }
        }

        return universite;
    }
}

