package tn.esprit.twin3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin3.Entities.Etudiant;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {

    Etudiant findEtudiantByCin(Long cin);
}
