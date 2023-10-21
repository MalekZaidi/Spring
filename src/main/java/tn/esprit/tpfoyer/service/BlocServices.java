package tn.esprit.tpfoyer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.iBlocRepository;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BlocServices implements iBlocServices{

    final iBlocRepository blocRepository;
    @Override
    public Bloc ajouterBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void supprimerBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);

    }

    @Override
    public Bloc getBloc(Long idBloc) {
        return blocRepository.findById(idBloc).orElseGet(null);
    }

    @Override
    public Bloc modifierBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public List<Bloc> getAllBloc() {
        return (List<Bloc>)blocRepository.findAll() ;
    }
}
