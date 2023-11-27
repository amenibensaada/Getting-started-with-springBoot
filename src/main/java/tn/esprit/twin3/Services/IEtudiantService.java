package tn.esprit.twin3.Services;

import tn.esprit.twin3.Entities.Etudiant;

import java.util.List;


public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant b);

    Etudiant updateEtudiant(Etudiant b);

    Etudiant retrieveEtudiant(long idEtudiant);

    List<Etudiant> addEtudiants(List<Etudiant> b);

    void removeEtudiant(long idEtudiant);


}
