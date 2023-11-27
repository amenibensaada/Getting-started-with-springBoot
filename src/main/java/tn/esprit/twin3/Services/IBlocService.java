package tn.esprit.twin3.Services;

import tn.esprit.twin3.Entities.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();

    Bloc addBloc(Bloc b);

    Bloc updateBloc(Bloc b);

    Bloc retrieveBloc(long idBloc);

    void removeBloc(long idBloc);

    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);
}
