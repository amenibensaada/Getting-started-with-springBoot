package tn.esprit.twin3.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Reservation {
    // @Temporal(TemporalType.DATE) // pour format date en java17
//   private Date anneeUniversitaire;
    LocalDate anneeUniversitaire;
    @Id

    private String idReservation;
    private boolean estValide;
    @ManyToMany(cascade = CascadeType.ALL)// pr dire que etudiant classe fils (pr ne pas avoir 2 tables
    private Set<Etudiant> etudiants = new HashSet<>();
}
