package tn.esprit.tpfoyer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.iUniversiteRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UniversiteServices implements iUniversiteServices {

    final iUniversiteRepository UniversiteRepository;

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
}
