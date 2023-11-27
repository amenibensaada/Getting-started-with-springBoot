package tn.esprit.twin3.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.Entities.Reservation;
import tn.esprit.twin3.Services.IreservationService;

import java.util.List;

@RestController

@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    IreservationService ireservationService;

    @GetMapping("/afficherreservation")
    List<Reservation> retrieveAllReservations() {
        return ireservationService.retrieveAllReservation();
    }

    @PutMapping("/modifierreservation")
    Reservation updateReservation(@RequestBody Reservation c) {
        return ireservationService.updateReservation(c);
    }

    @GetMapping("/afficherreservation/{idreservation}")
    Reservation retrieveReservation(@PathVariable("idreservation") String idReservation) {
        return ireservationService.retrieveReservation(idReservation);
    }

    @PostMapping("/ajouterReservation/{idchambre}/{cinetudiant}")
    Reservation ajouterReservation(@RequestBody Reservation r, @PathVariable("idchambre") Long idChambre, @PathVariable("cinetudiant") Long cinEtudiant) {
        return ireservationService.ajouterReservation(r, idChambre, cinEtudiant);
    }
}
