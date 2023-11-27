package tn.esprit.twin3.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.twin3.Entities.Etudiant;
import tn.esprit.twin3.Repositories.EtudiantRepo;

import java.util.List;


@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    EtudiantRepo etudiantRepo;


    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepo.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant b) {
        return etudiantRepo.save(b);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant b) {
        return etudiantRepo.save(b);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepo.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> b) {
        return etudiantRepo.saveAll(b);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);
    }
}

