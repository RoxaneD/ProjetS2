package Tas;

import Cartes.CarteAventurier;
import Enumerations.Couleur;
import Enumerations.NomAventurier;
import java.util.ArrayList;
import java.util.Collections;

public class TasAventuriers{

    // attributs
    private ArrayList<CarteAventurier> cartesAventuriers;

    // constructeurs
    //Crée un tas de carte aventurier
    public TasAventuriers() {
        setCartesAventuriers();
        Collections.shuffle(cartesAventuriers);
    }

    // setteurs
    //Crée un ArrayList de carte aventurier
    public void setCartesAventuriers() {
        cartesAventuriers = new ArrayList<>();
        CarteAventurier carte1 = new CarteAventurier("description", NomAventurier.explorateur, Couleur.vert);
        CarteAventurier carte2 = new CarteAventurier("description", NomAventurier.messager, Couleur.blanc);
        CarteAventurier carte3 = new CarteAventurier("description", NomAventurier.pilote, Couleur.bleu);
        CarteAventurier carte4 = new CarteAventurier("description", NomAventurier.plongeur, Couleur.noir);
        CarteAventurier carte5 = new CarteAventurier("description", NomAventurier.ingenieur, Couleur.rouge);
        CarteAventurier carte6 = new CarteAventurier("description", NomAventurier.navigateur, Couleur.jaune);
        cartesAventuriers.add(carte1);
        cartesAventuriers.add(carte2);
        cartesAventuriers.add(carte3);
        cartesAventuriers.add(carte4);
        cartesAventuriers.add(carte5);
        cartesAventuriers.add(carte6);
    }

    // getteurs
    //Renvoie un ArrayList de carte aventurier
    public ArrayList<CarteAventurier> getCartesAventuriers() {
        return cartesAventuriers;
    }

    // autres
    //Ajouter une carte au tas
    public void addCarte(CarteAventurier carte) {
        // pour rajouter une carte au DESSUS du paquet
        cartesAventuriers.add(carte);
    }

    //Recuperer la premiere carte du tas
    public CarteAventurier getPremiereCarte() {
        // pour récupérer la première carte du paquet (donc celle tout au dessus)
        int i = cartesAventuriers.size() - 1;//décrémenter la taille du tas de 1s
        CarteAventurier carte = cartesAventuriers.get(i);//recuperer la bonne carte
        cartesAventuriers.remove(i);//enlever la carte du tas
        return carte;//renvoie la carte
    }
    
    public ArrayList<CarteAventurier> melangerTas(ArrayList<CarteAventurier> cartes) {
        Collections.shuffle(cartes);
        return cartes;
    }

}
