package Aventuriers;

import Cartes.CarteAventurier;
import ElementsJeu.Tuile;
import Enumerations.EtatAventurier;
import java.util.ArrayList;

public abstract class Aventurier {

    // attributs
    private String nomJoueur;
    private EtatAventurier etat;
    private CarteAventurier carteAventurier;
    private Tuile tuile;

    // getteurs
    public String getNomJoueur() {
        return nomJoueur;
    }

    public EtatAventurier getEtat() {
        return etat;
    }

    public CarteAventurier getCarteAventurier() {
        return carteAventurier;
    }

    public Tuile getTuile() {
        return tuile;
    }

    // setteurs
    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public void setEtat(EtatAventurier etat) {
        this.etat = etat;
    }

    public void setCarteAventurier(CarteAventurier carteAventurier) {
        this.carteAventurier = carteAventurier;
    }

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
