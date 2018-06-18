package Tas;

import Cartes.CarteAventurier;
import java.util.ArrayList;

public class TasAventuriers extends Tas{

    // attributs
    private ArrayList<CarteAventurier> cartesAventuriers;

    // constructeurs
    //Crée un tas de carte aventurier
    public TasAventuriers() {
        setCartesAventuriers();
    }

    // setteurs
    //Crée un ArrayList de carte aventurier
    public void setCartesAventuriers() {
        cartesAventuriers = new ArrayList<>();
    }

    // getteurs
    //Renvoie un ArrayList de carte aventurier
    public ArrayList<CarteAventurier> getCartesAventuriers() {
        return cartesAventuriers;
    }

    // autres
    //Ajouter une carte au tas
    public void addCarte(CarteAventurier carte) {
        // pour rajouter une carte au DESSUS du paquet
        cartesAventuriers.add(carte);
    }

    //Recuperer la premiere carte du tas
    public CarteAventurier getPremiereCarte() {
        // pour récupérer la première carte du paquet (donc celle tout au dessus)
        int i = cartesAventuriers.size() - 1;//décrémenter la taille du tas de 1s
        CarteAventurier carte = cartesAventuriers.get(i);//recuperer la bonne carte
        cartesAventuriers.remove(i);//enlever la carte du tas
        return carte;//renvoie la carte
    }

}
