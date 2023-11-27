package tn.esprit.twin3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.twin3.Entities.Bloc;

@Repository
/* always pour jpa param de type generique: id:Long*/
public interface BlocRepo extends JpaRepository<Bloc, Long> {

    Bloc findBlocByNomBloc(String nom); // en utilisant keywords

    @Query("select b from Bloc b where b.nomBloc=:nom")
        // utilisant JPQL
    Bloc findBlocByNomBlocs(@Param("nom") String nom); //


}
