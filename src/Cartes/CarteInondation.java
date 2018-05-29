package Cartes;

import Enumerations.NomTuile;

public class CarteInondation extends Carte {

    // attributs
    private NomTuile nom;

    // constructeurs
    CarteInondation(String description, NomTuile nom){
        setDescription(description);
        setNom(nom);
    }
    // setteurs
    public void setNom(NomTuile nom) {
        this.nom = nom;
    }

    // getteurs
    public NomTuile getNom() {
        return nom;
    }
    // autres

}
