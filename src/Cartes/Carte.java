package Cartes;

import Enumerations.EtatCarte;

public abstract class Carte {

    // attributs
    private EtatCarte etat;// etat d'une carte enTas,enDefausse,enMain,jetee
    private String description;

    // setteurs
    // Méthode qui met à jour l'etat de la carte
    public void setEtat(EtatCarte etat) {
        this.etat = etat;
    }

    // Méthode qui met à jour la description de la carte
    public void setDescription(String description) {
        this.description = description;
    }
    // getteurs
    
    // Méthode qui renvoie l'etat de la carte
    public EtatCarte getEtat() {
        return etat;
    }

    // Méthode qui renvoie la description de la carte
    public String getDescription() {
        return description;
    }
    // autres

}
