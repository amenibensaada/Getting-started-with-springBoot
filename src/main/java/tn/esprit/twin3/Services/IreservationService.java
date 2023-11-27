package tn.esprit.twin3.Services;

import tn.esprit.twin3.Entities.Reservation;

import java.util.List;

public interface IreservationService {

    List<Reservation> retrieveAllReservation();

    Reservation updateReservation(Reservation res);

    Reservation retrieveReservation(String idReservation);

    public Reservation ajouterReservation(Reservation reservation, long idChambre, long cinEtudiant);


}
