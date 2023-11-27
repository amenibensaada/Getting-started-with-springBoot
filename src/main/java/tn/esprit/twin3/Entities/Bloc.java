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
public class Bloc {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blocs", fetch = FetchType.EAGER)
    Set<Chambre> chambres;
    @ManyToOne(cascade = CascadeType.ALL)
    Foyer foyers;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private String capaciteBloc;


}
