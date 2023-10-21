package tn.esprit.tpfoyer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.iFoyerRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class FoyerServices implements iFoyerServices {

   //@Autowired
    final iFoyerRepository foyerRepository;

  /*  public FoyerServices(iFoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }*/

    @Override
    public Foyer ajouterFoyer(Foyer f) {

        return foyerRepository.save(f);
    }

    @Override
    public void supprimerFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);

    }

    @Override
    public Foyer getFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public List<Foyer> getAllFoyer() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f) ;
    }
}
