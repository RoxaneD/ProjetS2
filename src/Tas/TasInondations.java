package Tas;

import Cartes.CarteInondation;
import java.util.ArrayList;

public class TasInondations extends Tas{

    // attributs
    private ArrayList<CarteInondation> cartesInondations;

    // constructeurs
    //Crée un tas de carte inondation
    public TasInondations() {
        setCartesInondations();
    }

    // setteurs
    //Crée un ArrayList de carte inondation
    public void setCartesInondations() {
        cartesInondations = new ArrayList<>();
    }

    // getteurs
    //Renvoie un ArrayList de carte inondation
    public ArrayList<CarteInondation> getCartesInondations() {
        return cartesInondations;
    }

    // autres
    //Ajouter une carte au tas
    public void addCarte(CarteInondation carte) {
        // pour rajouter une carte au DESSUS du paquet
        cartesInondations.add(carte);
    }

    //Recuperer la premiere carte du tas
    public CarteInondation getPremiereCarte() {
        // pour récupérer la première carte du paquet (donc celle tout au dessus)
        int i = cartesInondations.size() - 1;//décrémenter la taille du tas de 1
        CarteInondation carte = cartesInondations.get(i);//recuperer la bonne carte
        cartesInondations.remove(i);//enlever la carte du tas
        return carte;//renvoie la carte
    }

}
