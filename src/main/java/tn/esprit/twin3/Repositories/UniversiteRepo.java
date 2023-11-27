package tn.esprit.twin3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin3.Entities.Universite;

@Repository
public interface UniversiteRepo extends JpaRepository<Universite, Long> {
    Universite findUniversiteByNomUniversite(String nom);

    Universite findUniversiteByIdUniversite(Long id);
}
