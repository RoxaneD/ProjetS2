package Tas;

import Cartes.CarteTresors;
import java.util.ArrayList;
import java.util.Collections;

public class TasJoueur{

    // attributs
    private ArrayList<CarteTresors> cartes;

    // constructeurs
    //Crée un tas de carte pour le joueur
    public TasJoueur(){
        setCartes();
    }
    
    // setteurs
    //Crée un ArrayList de carte
    public void setCartes() {
        cartes = new ArrayList<>();
    }

    // getteurs
    //Renvoie un Arraylist de carte
    public ArrayList<CarteTresors> getCartes() {
        return cartes;
    }

    // autres
    //Ajoute une carte au tas
    public void addCarte(CarteTresors carte) {
        // on ajoute une carte à la fin des cartes du tas
        cartes.add(carte);
    }

    public CarteTresors getCarte(int i) {
        // on récupère la carte positionnée à l'emplacement i
        CarteTresors carte = cartes.get(i - 1);//décrémente la taille du tas de 1
        return carte;//renvoie la carte
    }
}
