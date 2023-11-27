package tn.esprit.twin3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin3.Entities.Foyer;

@Repository
public interface FoyerRepo extends JpaRepository<Foyer, Long> {
    Foyer findFoyerByNomFoyer(String nom);
}
