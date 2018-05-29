package Tas;

import Cartes.Carte;
import java.util.ArrayList;

public class TasPoubelle {

    // attributs
    private ArrayList<Carte> cartes;

    // constructeurs
    TasPoubelle() {
        setCartes();
    }

    // setteurs
    public void setCartes() {
        cartes = new ArrayList<>();
    }

    // getteurs
    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    // autres 
    public void addCarte(Carte carte) {
        cartes.add(carte);
    }
}
