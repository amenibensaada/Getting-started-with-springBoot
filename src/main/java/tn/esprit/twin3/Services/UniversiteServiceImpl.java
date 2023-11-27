package tn.esprit.twin3.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.twin3.Entities.Foyer;
import tn.esprit.twin3.Entities.Universite;
import tn.esprit.twin3.Repositories.FoyerRepo;
import tn.esprit.twin3.Repositories.UniversiteRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    UniversiteRepo universiteRepo;
    FoyerRepo foyerRepo;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite addUniversite(Universite b) {
        return universiteRepo.save(b);
    }

    @Override
    public Universite updateUniversite(Universite b) {
        return universiteRepo.save(b);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepo.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) { //one to one
        Foyer foyer = foyerRepo.findById(idFoyer).orElse(null);
        Universite universite = universiteRepo.findUniversiteByNomUniversite(nomUniversite);
        universite.setFoyer(foyer);
        //universiteRepo.save(universite); not required with java 8
        return universiteRepo.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Foyer foyer = foyerRepo.findById(idFoyer).orElse(null);
        Universite universite = universiteRepo.findUniversiteByIdUniversite(idUniversite);
        universite.setFoyer(null);
        //universiteRepo.save(universite); not required with java 8
        return universiteRepo.save(universite);
    }


}
