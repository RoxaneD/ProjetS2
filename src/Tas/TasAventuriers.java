package Tas;

import Cartes.CarteAventurier;
import java.util.ArrayList;

public class TasAventuriers {

    // attributs
    private ArrayList<CarteAventurier> cartesAventuriers;

    // constructeurs
    TasAventuriers() {
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
        cartesAventuriers.add(carte);
    }

    public CarteAventurier getPremiereCarte() {
        int i = cartesAventuriers.size()-1;
        CarteAventurier carte = cartesAventuriers.get(i);
        cartesAventuriers.remove(i);
        return carte;
    }

}
