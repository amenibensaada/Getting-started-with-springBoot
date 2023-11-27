package tn.esprit.twin3.Services;

import tn.esprit.twin3.Entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();

    Universite addUniversite(Universite b);

    Universite updateUniversite(Universite b);

    Universite retrieveUniversite(long idUniversite);

    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite);
}
