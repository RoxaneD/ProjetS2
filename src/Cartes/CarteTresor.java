package Cartes;

import Enumerations.NomTresor;

public class CarteTresor extends CarteTresors {

    // attributs
    private NomTresor nom;

    // constructeurs
    public CarteTresor(NomTresor nom) {
        super();
        setNom(nom);
    }

    public CarteTresor(String description, NomTresor nom) {
        super(description);
        setNom(nom);
    }

    // setteurs
    public void setNom(NomTresor nom) {
        this.nom = nom;
    }
    // getteurs

    public NomTresor getNom() {
        return nom;
    }

}
