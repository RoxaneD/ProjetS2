//
package Controle;

import Cartes.CarteTresors;
import ElementsJeu.Tuile;

public class Action {

    // attributs
    private TypesActions type;//Types d'action
    private Tuile tuile;//Tuile où s'effectue l'action
    private String nom;
    private CarteTresors carteT;

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

    public Action(TypesActions type, String nom) {  // pour ajouter un joueur
        setType(type);//avec le type fournit en paramètre
        setNom(nom);
    }
    
    public Action(TypesActions type, CarteTresors carte, String nom){   // pour jouer une carte Tresor
        setType(type);//avec le type fournit en paramètre
        setNom(nom);
        setCarteT(carte);
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

    public void setCarteT(CarteTresors carteT) {
        this.carteT = carteT;
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

    public CarteTresors getCarteT() {
        return carteT;
    }
    
    // autres

}
