//
package Controle;

import Cartes.Carte;
import Cartes.CarteInondation;
import Cartes.CarteTresors;
import ElementsJeu.Tuile;
import java.util.ArrayList;

public class Action {

    // attributs
    private TypesActions type;//Types d'action
    private Tuile tuile;//Tuile où s'effectue l'action
    private String nom;
    private Carte carte;
    private ArrayList<String> joueurs = new ArrayList<>();
    private int niveau;

    // constructeurs
    //Crée une action
    public Action(TypesActions type) {
        setType(type);//avec le type fournis en paramètre
    }

    //Crée une action 
    public Action(TypesActions type, Tuile tuile) { // pour de déplacer et assécher
        setType(type);//avec le type fournit en paramètre
        setTuile(tuile);//avec la tuile fournis en paramètre
    }

    public Action(TypesActions type, String nom) {  // pour ???
        setType(type);//avec le type fournit en paramètre
        setNom(nom);
    }

    public Action(TypesActions type, Carte carte) {
        setType(type);
        setCarte(carte);
    }

    public Action(TypesActions type, ArrayList<String> joueurs, int i) { // pour commencer une partie
        setType(type);
        setJoueurs(joueurs);
        setNiveau(i);
    }

    // setteurs
    // Méthode qui met à jour le type d'action
    public void setType(TypesActions type) {
        this.type = type;
    }

    // Méthode qui met à jour le nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    //Méthode qui met a jour la tuile
    public void setTuile(Tuile tuile) {
        this.tuile = tuile;
    }

    public void setCarte(Carte carte) {
        if (carte.getDescription() == "inondation") {
            this.carte = (CarteInondation) (carte);
        } else {
            this.carte = (CarteTresors) (carte);
        }
    }

    public void setJoueurs(ArrayList<String> joueurs) {
        this.joueurs = joueurs;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    // getteurs
    //Méthode qui renvoie le type d'action
    public TypesActions getType() {
        return type;
    }

    //Méthode qui renvioe la tuile 
    public Tuile getTuile() {
        return tuile;
    }

    public String getNom() {
        return nom;
    }

    public Carte getCarte() {
        return carte;
    }

    public ArrayList<String> getJoueurs() {
        return joueurs;
    }

    public int getNiveau() {
        return niveau;
    }

    // autres
}
