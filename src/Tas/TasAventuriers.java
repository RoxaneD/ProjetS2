package Tas;

import Cartes.CarteAventurier;
import java.util.ArrayList;

public class TasAventuriers {

    // attributs
    private ArrayList<CarteAventurier> cartesAventuriers;

    // constructeurs
    public TasAventuriers() {
        setCartesAventuriers();
    }

    // setteurs
    public void setCartesAventuriers() {
        cartesAventuriers = new ArrayList<>();
    }

    // getteurs
    public ArrayList<CarteAventurier> getCartesAventuriers() {
        return cartesAventuriers;
    }

    // autres
    public void addCarte(CarteAventurier carte) {
        // pour rajouter une carte au DESSUS du paquet
        cartesAventuriers.add(carte);
    }

    public CarteAventurier getPremiereCarte() {
        // pour récupérer la première carte du paquet (donc celle tout au dessus)
        int i = cartesAventuriers.size() - 1;
        CarteAventurier carte = cartesAventuriers.get(i);
        cartesAventuriers.remove(i);
        return carte;
    }

}
