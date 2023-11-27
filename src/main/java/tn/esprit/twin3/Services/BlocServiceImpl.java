package tn.esprit.twin3.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.twin3.Entities.Bloc;
import tn.esprit.twin3.Entities.Chambre;
import tn.esprit.twin3.Repositories.BlocRepo;
import tn.esprit.twin3.Repositories.ChambreRepo;

import java.util.List;


@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    BlocRepo blocRepo;
    ChambreRepo chambreRepo;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepo.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepo.save(b);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepo.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepo.deleteById(idBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc bloc = blocRepo.findBlocByNomBloc(nomBloc);
        Chambre chambre;
        for (long num : numChambre) {
            //     (chambreRepo.findChambresByNumeroChambre(num)).setBlocs(bloc);
            chambre = chambreRepo.findChambresByNumeroChambre(num);
            chambre.setBlocs(bloc); //plus important set moins important(cardinalite)
            chambreRepo.save(chambre);
        }
        // return  blocRepo.save(bloc);
        return blocRepo.findBlocByNomBlocs(nomBloc);
    }
}

