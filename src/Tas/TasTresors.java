package Tas;

import Cartes.CarteSpeciale;
import Cartes.CarteTresor;
import Cartes.CarteTresors;
import Enumerations.NomTresor;
import java.util.ArrayList;
import java.util.Collections;

public class TasTresors{

    // attributs
    private ArrayList<CarteTresors> cartesTresors;

    // constructeurs
    //Crée un tas tresor
    public TasTresors() {
        setCartesTresors();
        Collections.shuffle(cartesTresors);
    }

    // setteurs
    //Méthode qui crée un ArrayList de carte tresor
    public void setCartesTresors() {
        cartesTresors = new ArrayList<>();
        //création des cartes Tresors
        CarteTresors carteTresor1 = new CarteTresors(NomTresor.Pierre);
        CarteTresors carteTresor2 = new CarteTresors(NomTresor.Pierre);
        CarteTresors carteTresor3 = new CarteTresors(NomTresor.Pierre);
        CarteTresors carteTresor4 = new CarteTresors(NomTresor.Pierre);
        CarteTresors carteTresor5 = new CarteTresors(NomTresor.Pierre);
        CarteTresors carteTresor6 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor7 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor8 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor9 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor10 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor11 = new CarteTresors(NomTresor.Cristal);
        CarteTresors carteTresor12 = new CarteTresors(NomTresor.Cristal);
        CarteTresors carteTresor13 = new CarteTresors(NomTresor.Cristal);
        CarteTresors carteTresor14 = new CarteTresors(NomTresor.Cristal);
        CarteTresors carteTresor15 = new CarteTresors(NomTresor.Cristal);
        CarteTresors carteTresor16 = new CarteTresors(NomTresor.Calice);
        CarteTresors carteTresor17 = new CarteTresors(NomTresor.Calice);
        CarteTresors carteTresor18 = new CarteTresors(NomTresor.Calice);
        CarteTresors carteTresor19 = new CarteTresors(NomTresor.Calice);
        CarteTresors carteTresor20 = new CarteTresors(NomTresor.Calice);
        //création des cartes Speciales
        CarteTresors carteSpeciale1 = new CarteTresors(NomTresor.Helicoptere);
        CarteTresors carteSpeciale2 = new CarteTresors(NomTresor.Helicoptere);
        CarteTresors carteSpeciale3 = new CarteTresors(NomTresor.Helicoptere);
        CarteTresors carteSpeciale4 = new CarteTresors(NomTresor.MonteeDesEaux);
        CarteTresors carteSpeciale5 = new CarteTresors(NomTresor.MonteeDesEaux);
        CarteTresors carteSpeciale7 = new CarteTresors(NomTresor.SacsDeSable);
        CarteTresors carteSpeciale8 = new CarteTresors(NomTresor.SacsDeSable);
        //ajout
        cartesTresors.add(carteTresor1);
        cartesTresors.add(carteTresor2);
        cartesTresors.add(carteTresor3);
        cartesTresors.add(carteTresor4);
        cartesTresors.add(carteTresor5);
        cartesTresors.add(carteTresor6);
        cartesTresors.add(carteTresor7);
        cartesTresors.add(carteTresor8);
        cartesTresors.add(carteTresor9);
        cartesTresors.add(carteTresor10);
        cartesTresors.add(carteTresor11);
        cartesTresors.add(carteTresor12);
        cartesTresors.add(carteTresor13);
        cartesTresors.add(carteTresor14);
        cartesTresors.add(carteTresor15);
        cartesTresors.add(carteTresor16);
        cartesTresors.add(carteTresor17);
        cartesTresors.add(carteTresor18);
        cartesTresors.add(carteTresor19);
        cartesTresors.add(carteTresor20);
        cartesTresors.add(carteSpeciale1);
        cartesTresors.add(carteSpeciale2);
        cartesTresors.add(carteSpeciale3);
        cartesTresors.add(carteSpeciale4);
        cartesTresors.add(carteSpeciale5);
        cartesTresors.add(carteSpeciale7);
        cartesTresors.add(carteSpeciale8);
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
