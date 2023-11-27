package tn.esprit.twin3.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.Entities.Bloc;
import tn.esprit.twin3.Services.IBlocService;

import java.util.List;

@RestController

@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService iBlocService;

    @GetMapping("/afficherblocs")
    List<Bloc> retrieveAllBlocs() {
        return iBlocService.retrieveAllBlocs();
    }

    @PostMapping("/ajouterbloc")
    Bloc addBloc(@RequestBody Bloc c) {
        return iBlocService.addBloc(c);
    }

    @PutMapping("/modifierbloc")
    Bloc updateBloc(@RequestBody Bloc c) {
        return iBlocService.updateBloc(c);
    }

    @GetMapping("/afficherbloc/{idbloc}")
    Bloc retrieveBloc(@PathVariable("idbloc") long idBloc) {
        return iBlocService.retrieveBloc(idBloc);
    }

    @DeleteMapping("/supprimerbloc/{idbloc}")
    String deleteBloc(@PathVariable("idbloc") long idBloc) {
        iBlocService.removeBloc(idBloc);
        return ("Bloc est supprimer");
    }

    @PutMapping("/affecterchambreabloc/{numChambre}/{nomBloc}")
    Bloc affecterChambresABloc(@PathVariable("numChambre") List<Long> numChambre, @PathVariable("nomBloc") String nomBloc) {
        return iBlocService.affecterChambresABloc(numChambre, nomBloc);
    }
}
