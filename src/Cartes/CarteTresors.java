package Cartes;

import Enumerations.NomCarteTresor;

public class CarteTresors extends Carte {

    // attributs
    private NomCarteTresor nom;
    
    // constructeurs
    CarteTresors(String description, NomCarteTresor nom){
        setDescription(description);
        setNom(nom);
    }

    // setteurs
    public void setNom(NomCarteTresor nom) {
        this.nom = nom;
    }

    // getteurs
    public NomCarteTresor getNom() {
        return nom;
    }
    // autres

}
