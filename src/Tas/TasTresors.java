package Tas;

import Cartes.CarteTresors;
import java.util.ArrayList;

public class TasTresors extends Tas{

    // attributs
    private ArrayList<CarteTresors> cartesTresors;

    // constructeurs
    //Crée un tas tresor
    public TasTresors() {
        setCartesTresors();
    }

    // setteurs
    //Méthode qui crée un ArrayList de carte tresor
    public void setCartesTresors() {
        cartesTresors = new ArrayList<>();
    }

    // getteurs
    //Méthode qui envoie un ArrayList de carte tresor
    public ArrayList<CarteTresors> getCartesTresors() {
        return cartesTresors;
    }

    // autres
    //Méthode qui rajoute une carte dans le paquet
    public void addCarte(CarteTresors carte) {
        // pour rajouter une carte au DESSUS du paquet
        cartesTresors.add(carte);
    }

    public CarteTresors getPremiereCarte() {
        // pour récupérer la première carte du paquet (donc celle tout au dessus)
        int i = cartesTresors.size() - 1;//On décrémente la taille du paquet de 1
        CarteTresors carte = cartesTresors.get(i);//On recupere la carte du dessus du paquet
        cartesTresors.remove(i);//On enleve la carte du tas
        return carte;//On renvoie la carte
    }

}
