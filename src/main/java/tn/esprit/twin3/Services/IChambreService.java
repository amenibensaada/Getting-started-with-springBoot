package tn.esprit.twin3.Services;

import tn.esprit.twin3.Entities.Chambre;
import tn.esprit.twin3.Entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre(Chambre c);

    Chambre retrieveChambre(long idChambre);

    void removeChambre(long idChambre);

    List<Chambre> getChambreByNomBloc(String nom);
    List<Chambre> getChambreByType(TypeChambre type);

    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc);

    public List<Chambre> getChambresParNomUniversite(String nomUniversite);

    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);

    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            String nomUniversite, TypeChambre type);


}
