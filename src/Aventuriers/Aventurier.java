package Aventuriers;

import Cartes.Carte;
import Cartes.CarteAventurier;
import ElementsJeu.Tuile;
import Enumerations.EtatAventurier;
import Tas.TasJoueur;
import java.util.ArrayList;

public abstract class Aventurier {

    // attributs
    private String nomJoueur;
    private EtatAventurier etat;// Si l'aventurier est vivant ou mort
    private CarteAventurier carteAventurier;
    private Tuile tuile; //Tuile assigner comme sa tuile actuelle
    private TasJoueur tasJoueur;
    private ArrayList<Carte> tasTirage = new ArrayList<>();

    // getteurs
    // Méthode qui renvoie le nom du joueur
    public String getNomJoueur() {
        return nomJoueur;
    }

    // Méthode qui renvoie l'état de l'aventurier
    public EtatAventurier getEtat() {
        return etat;
    }

    // Méthode qui renvoie la carte de l'aventurier
    public CarteAventurier getCarteAventurier() {
        return carteAventurier;
    }

    // Méthode qui renvoie la tuile où ce trouve l'aventurier
    public Tuile getTuile() {
        return tuile;
    }

    public TasJoueur getTasJoueur() {
        return tasJoueur;
    }

    public ArrayList<Carte> getTasTirage() {
        return tasTirage;
    }

    // setteurs
    // Méthode qui met à jour nom du joueur avec la chaine de caractères fournit
    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    //Méthode qui met à jour l'etat de l'aventurier avec la valeur fournit
    public void setEtat(EtatAventurier etat) {
        this.etat = etat;
    }

    //Méthode qui met à jour la carte de l'aventurier avec la carte fournit
    public void setCarteAventurier(CarteAventurier carteAventurier) {
        this.carteAventurier = carteAventurier;
    }

    public void setTasJoueur() {
        this.tasJoueur = new TasJoueur();
    }

    //Méthode qui assigne une tuile à un aventurier
    public void addTuile(Tuile tuile) {
        this.tuile = tuile;
    }

    // autres 
    //Méthode qui enlève la tuile assignée 
    public void removeTuile() {
        this.tuile = null;
    }

    //deux méthodes abstraite qui seront créé dans les différents aventurier
    public abstract ArrayList<Tuile> calculDeplacementPos();

    public abstract ArrayList<Tuile> calculAssechementPos();
}
