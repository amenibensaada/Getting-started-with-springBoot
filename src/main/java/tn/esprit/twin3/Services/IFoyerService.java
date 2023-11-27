package tn.esprit.twin3.Services;

import tn.esprit.twin3.Entities.Bloc;
import tn.esprit.twin3.Entities.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer(Foyer b);

    Foyer updateFoyer(Foyer b);

    Foyer retrieveFoyer(long idFoyer);

    void removeFoyer(long idFoyer);

    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer);

    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);

}
