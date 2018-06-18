package Tas;

import Cartes.Carte;
import java.util.ArrayList;
import java.util.Collections;

public class TasPoubelle{

    // attributs
    private ArrayList<Carte> cartes;

    // constructeurs
    //Crée un tas poubelle
    public TasPoubelle() {
        setCartes();
        Collections.shuffle(cartes);
    }

    // setteurs
    //crée un ArrayList de carte
    public void setCartes() {
        cartes = new ArrayList<>();
    }

    // getteurs
    //Renvoie un ArrayList de carte
    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    // autres 
    //Ajoute une carte au tas 
    public void addCarte(Carte carte) {
        cartes.add(carte);
    }
}
