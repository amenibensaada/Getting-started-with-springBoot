package tn.esprit.twin3.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFoyer;
    String nomFoyer;
    Long capacite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyers")
    Set<Bloc> blocs;
    @OneToOne(cascade = CascadeType.ALL)
    private Universite universite;
}
