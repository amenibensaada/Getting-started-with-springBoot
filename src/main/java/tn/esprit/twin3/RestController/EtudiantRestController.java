package tn.esprit.twin3.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.Entities.Etudiant;
import tn.esprit.twin3.Services.IEtudiantService;

import java.util.List;


@RestController

@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    IEtudiantService iEtudiantService;

    @GetMapping("/afficheretudiants")
    List<Etudiant> retrieveAllEtudiants() {
        return iEtudiantService.retrieveAllEtudiants();
    }

    @PostMapping("/ajouteretudiant")
    Etudiant addEtudiant(@RequestBody Etudiant c) {
        return iEtudiantService.addEtudiant(c);
    }

    @PostMapping("/ajouteretudiants")
    List<Etudiant> addEtudiants(@RequestBody List<Etudiant> c) {
        return iEtudiantService.addEtudiants(c);
    }

    @PutMapping("/modifieretudiant")
    Etudiant updateEtudiant(@RequestBody Etudiant c) {
        return iEtudiantService.updateEtudiant(c);
    }

    @GetMapping("/afficheretudiant/{idetudiant}")
    Etudiant retrieveEtudiant(@PathVariable("idetudiant") long idEtudiant) {
        return iEtudiantService.retrieveEtudiant(idEtudiant);
    }

    @GetMapping("/deleteetudiant/{idetudiant}")
    String deleteEtudiant(@PathVariable("idetudiant") long idEtudiant) {
        iEtudiantService.removeEtudiant(idEtudiant);
        return "etudiant supprimer";
    }


}