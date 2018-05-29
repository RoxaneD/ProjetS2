package Cartes;

import Enumerations.EtatCarte;

public abstract class Carte {

    // attributs
    private EtatCarte etat;
    private String description;

    // setteurs
    public void setEtat(EtatCarte etat) {
        this.etat = etat;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // getteurs

    public EtatCarte getEtat() {
        return etat;
    }

    public String getDescription() {
        return description;
    }
    // autres

}
