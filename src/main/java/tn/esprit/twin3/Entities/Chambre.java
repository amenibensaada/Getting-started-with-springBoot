package tn.esprit.twin3.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Chambre {

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    Bloc blocs;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;


}
