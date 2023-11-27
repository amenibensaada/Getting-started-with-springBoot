package tn.esprit.twin3.Services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.twin3.Entities.Chambre;
import tn.esprit.twin3.Entities.Etudiant;
import tn.esprit.twin3.Entities.Reservation;
import tn.esprit.twin3.Entities.TypeChambre;
import tn.esprit.twin3.Repositories.ChambreRepo;
import tn.esprit.twin3.Repositories.EtudiantRepo;
import tn.esprit.twin3.Repositories.ReservationRepo;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
@Slf4j
public class ReservationServiceImpl implements IreservationService {
    private final ReservationRepo reservationRepo;
    private final ChambreRepo chambreRepo;
    private final EtudiantRepo etudiantRepo;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepo.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepo.findById(idReservation).orElse(null);
    }

    //  String genererId(long cin,long){
    //    return ;
    //  }
    private boolean capaciteMaxNonAtteinte(Chambre chambre) {
        TypeChambre typeChambre = chambre.getTypeC();
        Set<Reservation> reservations = chambre.getReservations();
        switch (typeChambre) {
            case SIMPLE:
                return reservations.size() < 2;
            case DOUBLE:
                return reservations.size() < 3;
            case TRIPLE:
                return reservations.size() < 4;
            default:
                return false;
        }
    }


    @Override
    public Reservation ajouterReservation(Reservation reservation, long idChambre, long cinEtudiant) {
        Chambre chambre = chambreRepo.findById(idChambre)
                .orElseThrow(() -> new EntityNotFoundException("Chambre not found with id: "));
        Etudiant etudiant = etudiantRepo.findEtudiantByCin(cinEtudiant);
        if (capaciteMaxNonAtteinte(chambre)) {
            String numReservation = chambre.getNumeroChambre() + "-" + chambre.getBlocs().getNomBloc() + "-" + etudiant.getCin();
            log.info("numreservation :" + numReservation);
            reservation.setIdReservation(numReservation);
            reservation.setEstValide(true);
            chambre.getReservations().add(reservation);
            reservation.getEtudiants().add(etudiant);
            reservationRepo.save(reservation);
            return reservation;
        } else return reservation;
    }

}
