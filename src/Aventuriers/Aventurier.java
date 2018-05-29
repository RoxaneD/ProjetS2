package Aventuriers;

import Cartes.CarteAventurier;
import ElementsJeu.Tuile;
import Enumerations.Couleur;
import Enumerations.EtatAventurier;
import java.util.ArrayList;

public abstract class Aventurier {

    // attributs
    private String nomJoueur;
    private EtatAventurier etat;
    private Couleur couleur;
    private CarteAventurier carteAventurier;
    private Tuile tuile;
    
    // getteurs
    public Tuile getTuile() {
        return tuile;
    }

    // setteurs
    public void addTuile(Tuile tuile) {
        this.tuile = tuile;
    }

    // autres 
    public void removeTuile() {
        this.tuile = null;
    }
    
    public abstract ArrayList<Tuile> calculDeplacementPos();

    public abstract ArrayList<Tuile> calculAssechementPos();

}
