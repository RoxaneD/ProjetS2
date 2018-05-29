package Tas;

import Cartes.Carte;
import java.util.ArrayList;

public class TasJoueur {

    // attributs
    private ArrayList<Carte> cartes;

    // constructeurs
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
        // on ajoute une carte à la fin des cartes du tas
        cartes.add(carte);
    }

    public Carte getCarte(int i) {
        // on récupère la carte positionnée à l'emplacement i
        Carte carte = cartes.get(i - 1);
        return carte;
    }
}
