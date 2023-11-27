package tn.esprit.twin3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin3.Entities.Reservation;

import java.util.Date;
import java.util.List;

@Repository

public interface ReservationRepo extends JpaRepository<Reservation, String> {

    // chercher les reservations effectuer durant l'annee universitaire 23-24
    List<Reservation> findReservationsByAnneeUniversitaireBetween(Date debut, Date fin);

    Long countReservationsByAnneeUniversitaireBetween(Date debut, Date fin);

    List<Reservation> findReservationsByEstValideIsTrue();

}
