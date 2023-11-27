package tn.esprit.twin3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin3.Entities.Chambre;
import tn.esprit.twin3.Entities.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre, Long> {
    //recupere les chambres dont ils ont ete reserve durant une annee universitaire donner au clavier
    // List<Chambre> findChambresByReservations we can't do this car uniderctionnelle see ChambreServiceImpl for new methods
    // recupere les chambres definis par nom bloc
    List<Chambre> findChambresByBlocs_NomBloc(String nom);

    List<Chambre> findAll();

    Chambre findChambresByNumeroChambre(long num);

    int countChambreByTypeCAndBlocs_IdBloc(TypeChambre type, long id);// _ : pr acceder attribut d'une autre classe by===where
    // we userd query because we can't access var of reservations (liste)
    //  @Query("select chambre from Chambre chambre join chambre.reservations reservation where reservation.anneeUniversitaire >:debut and reservation.anneeUniversitaire<: fin")
    //  List <Chambre> findChambresByReservations(@Param("debut") LocalDate debut, @Param("fin") LocalDate fin);

    List<Chambre> findChambresByBlocs_Foyers_Universite_NomUniversite(String nomUniversite);

    // @Query("select chambre from Chambre chambre join chambre.blocs ")
    // List<Chambre> getByNomUniversite(String nomUniversite);

    List<Chambre> findChambreByBlocs_Foyers_Universite_NomUniversite(String nomUniversite);

    List<Chambre> findChambresByTypeCAndBlocs_IdBloc(TypeChambre typeC, long blocs_idBloc);

    List<Chambre> findByTypeC(TypeChambre type);
}
