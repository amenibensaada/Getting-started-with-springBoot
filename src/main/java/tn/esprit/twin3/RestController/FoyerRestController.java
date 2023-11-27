package tn.esprit.twin3.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.Entities.Bloc;
import tn.esprit.twin3.Entities.Foyer;
import tn.esprit.twin3.Services.IFoyerService;

import java.util.List;


@RestController

@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    IFoyerService iFoyerService;

    @GetMapping("/afficherfoyers")
    List<Foyer> retrieveAllFoyers() {
        return iFoyerService.retrieveAllFoyers();
    }

    @PostMapping("/ajouterfoyer")
    Foyer addFoyer(@RequestBody Foyer c) {
        return iFoyerService.addFoyer(c);
    }

    @PutMapping("/modifierfoyer")
    Foyer updateFoyer(@RequestBody Foyer c) {
        return iFoyerService.updateFoyer(c);
    }

    @GetMapping("/afficherfoyer/{idfoyer}")
    Foyer retrieveFoyer(@PathVariable("idfoyer") long idFoyer) {
        return iFoyerService.retrieveFoyer(idFoyer);
    }

    @DeleteMapping("/supprimerfoyer/{idfoyer}")
    String removeFoyer(@PathVariable("idfoyer") long idFoyer) {
        iFoyerService.removeFoyer(idFoyer);
        return ("Foyer est supprimer");
    }

    @PutMapping("/affecterBlocAFoyer/{nomBloc}/{nomFoyer}")
    Bloc affecterBlocAFoyer(@PathVariable("nomBloc") String nomBloc, @PathVariable("nomFoyer") String nomFoyer) {
        return iFoyerService.affecterBlocAFoyer(nomBloc, nomFoyer);
    }

    @PostMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer f, @PathVariable("idUniversite") Long idUniversite) {
        return iFoyerService.ajouterFoyerEtAffecterAUniversite(f, idUniversite);
    }
}