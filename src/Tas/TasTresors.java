package Tas;

import Cartes.CarteTresors;
import java.util.ArrayList;

public class TasTresors {

    // attributs
    private ArrayList<CarteTresors> cartesTresors;

    // constructeurs
    public TasTresors() {
        setCartesTresors();
    }

    // setteurs
    public void setCartesTresors() {
        cartesTresors = new ArrayList<>();
    }

    // getteurs
    public ArrayList<CarteTresors> getCartesTresors() {
        return cartesTresors;
    }

    // autres
    public void addCarte(CarteTresors carte) {
        // pour rajouter une carte au DESSUS du paquet
        cartesTresors.add(carte);
    }

    public CarteTresors getPremiereCarte() {
        // pour récupérer la première carte du paquet (donc celle tout au dessus)
        int i = cartesTresors.size() - 1;
        CarteTresors carte = cartesTresors.get(i);
        cartesTresors.remove(i);
        return carte;
    }

}
