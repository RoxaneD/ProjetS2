package Tas;

import Cartes.CarteInondation;
import java.util.ArrayList;

public class TasInondations {

    // attributs
    private ArrayList<CarteInondation> cartesInondations;

    // constructeurs
    TasInondations() {
        setCartesInondations();
    }

    // setteurs
    public void setCartesInondations() {
        cartesInondations = new ArrayList<>();
    }

    // getteurs
    public ArrayList<CarteInondation> getCartesInondations() {
        return cartesInondations;
    }

    // autres
    public void addCarte(CarteInondation carte) {
        // pour rajouter une carte au DESSUS du paquet
        cartesInondations.add(carte);
    }

    public CarteInondation getPremiereCarte() {
        // pour récupérer la première carte du paquet (donc celle tout au dessus)
        int i = cartesInondations.size() - 1;
        CarteInondation carte = cartesInondations.get(i);
        cartesInondations.remove(i);
        return carte;
    }

}
