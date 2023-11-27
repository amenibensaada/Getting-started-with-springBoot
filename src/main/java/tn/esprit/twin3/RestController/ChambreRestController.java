package tn.esprit.twin3.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.Entities.Chambre;
import tn.esprit.twin3.Entities.TypeChambre;
import tn.esprit.twin3.Services.IChambreService;

import java.util.List;

@RestController // service rest
//  @Controller if it was SOAP
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService iChambreService;

    @GetMapping("/afficherchambres")
    List<Chambre> retrieveAllChambres() {
        return iChambreService.retrieveAllChambres();
    }

    @PostMapping("/ajouterchambre")
    Chambre addChambre(@RequestBody Chambre c) {
        return iChambreService.addChambre(c);
    }

    @PutMapping("/modifierchambre")
    Chambre updateChambre(@RequestBody Chambre c) {
        return iChambreService.updateChambre(c);
    }

    @GetMapping("/afficherchambre/{idchambre}")
    Chambre retrieveChambre(@PathVariable("idchambre") long idChambre) {
        return iChambreService.retrieveChambre(idChambre);
    }

    @DeleteMapping("/supprimerchambre/{idchambre}")
    String removeChambre(@PathVariable("idchambre") long idChambre) {
        iChambreService.removeChambre(idChambre);
        return ("Chambre est supprimer");
    }

    @GetMapping("/getbynombloc/{nom}")
    public List<Chambre> getChambreByNomBloc(@PathVariable("nom") String nom) {
        return iChambreService.getChambreByNomBloc(nom);
    }

    @GetMapping("/getChambresParNomUniversite/{nomuniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable("nomuniversite") String nomuniversite) {
        return iChambreService.getChambresParNomUniversite(nomuniversite);
    }

    @GetMapping("/getChambresPartype/{type}")
    public List<Chambre> getChambresParNomType(@PathVariable("type") TypeChambre type) {
        return iChambreService.getChambreByType(type);
    }

    @GetMapping("/getChambresParBlocEtType/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable("idBloc") long idBloc, @PathVariable("typeC") TypeChambre typeC) {
        return iChambreService.getChambresParBlocEtType(idBloc, typeC);
    }
}
