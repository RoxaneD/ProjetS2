package Tas;

import Cartes.CarteTresors;
import java.util.ArrayList;

public class DefausseTresors {

    // attributs
    private ArrayList<CarteTresors> cartesTresors;

    // constructeurs
    public DefausseTresors() {
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

    public ArrayList<CarteTresors> recupererCartes() {
        // pour récupérer tout le paquet (le paquet devient alors vide)
        ArrayList<CarteTresors> cartes = cartesTresors;
        cartesTresors = new ArrayList<CarteTresors>();
        return cartes;
    }
}
