package tn.esprit.twin3.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.twin3.Entities.Bloc;
import tn.esprit.twin3.Entities.Foyer;
import tn.esprit.twin3.Entities.Universite;
import tn.esprit.twin3.Repositories.BlocRepo;
import tn.esprit.twin3.Repositories.FoyerRepo;
import tn.esprit.twin3.Repositories.UniversiteRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepo foyerRepo;
    BlocRepo blocRepo;
    UniversiteRepo universiteRepo;


    @Override

    public List<Foyer> retrieveAllFoyers() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer b) {
        return foyerRepo.save(b);
    }

    @Override
    public Foyer updateFoyer(Foyer b) {
        return foyerRepo.save(b);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepo.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepo.deleteById(idFoyer);
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc bloc = blocRepo.findBlocByNomBloc(nomBloc);
        Foyer foyer = foyerRepo.findFoyerByNomFoyer(nomFoyer);
        Set<Bloc> blocs = new HashSet<>();
        blocs.add(bloc);
        foyer.setBlocs(blocs);
        foyerRepo.save(foyer);
        return bloc;
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        this.addFoyer(foyer);
        Universite universite = universiteRepo.findUniversiteByIdUniversite(idUniversite);
        foyer.setUniversite(universite);
        foyerRepo.save(foyer);
      universiteRepo.save(universite);
        return foyer;
    }

}
