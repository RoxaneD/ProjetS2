package Cartes;

import Enumerations.NomCarteSpeciale;

public class CarteSpeciale extends CarteTresors {

    // attributs
    private NomCarteSpeciale nom;

    // constructeurs
    public CarteSpeciale(NomCarteSpeciale nom) {
        super();
        setNom(nom);
    }

    public CarteSpeciale(String description, NomCarteSpeciale nom) {
        super(description);
        setNom(nom);
    }

    // setteurs
    public void setNom(NomCarteSpeciale nom) {
        this.nom = nom;
    }
    // getteurs

    public NomCarteSpeciale getNom() {
        return nom;
    }

}
