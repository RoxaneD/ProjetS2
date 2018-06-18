package Tas;

import Cartes.Carte;
import java.util.ArrayList;
import java.util.Collections;

public class TasJoueur{

    // attributs
    private ArrayList<Carte> cartes;

    // constructeurs
    //Crée un tas de carte pour le joueur
    public TasJoueur(){
        setCartes();
        Collections.shuffle(cartes);
    }
    
    // setteurs
    //Crée un ArrayList de carte
    public void setCartes() {
        cartes = new ArrayList<>();
    }

    // getteurs
    //Renvoie un Arraylist de carte
    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    // autres
    //Ajoute une carte au tas
    public void addCarte(Carte carte) {
        // on ajoute une carte à la fin des cartes du tas
        cartes.add(carte);
    }

    public Carte getCarte(int i) {
        // on récupère la carte positionnée à l'emplacement i
        Carte carte = cartes.get(i - 1);//décrémente la taille du tas de 1
        return carte;//renvoie la carte
    }
}
