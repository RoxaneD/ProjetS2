package Tas;

import Cartes.CarteInondation;
import Enumerations.NomTuile;
import java.util.ArrayList;
import java.util.Collections;

public class TasInondations{

    // attributs
    private ArrayList<CarteInondation> cartesInondations;

    // constructeurs
    //Crée un tas de carte inondation
    public TasInondations() {
        setCartesInondations();
        Collections.shuffle(cartesInondations);
    }

    // setteurs
    //Crée un ArrayList de carte inondation
    public void setCartesInondations() {
        cartesInondations = new ArrayList<>();
        //création des cartesInondation
        CarteInondation carteInondation1 = new CarteInondation(NomTuile.Le_Pont_Des_Abimes);
        CarteInondation carteInondation2 = new CarteInondation(NomTuile.La_Porte_De_Bronze);
        CarteInondation carteInondation3 = new CarteInondation(NomTuile.La_Caverne_Des_Ombres);
        CarteInondation carteInondation4 = new CarteInondation(NomTuile.La_Porte_De_Fer);
        CarteInondation carteInondation5 = new CarteInondation(NomTuile.La_Porte_d_Or);
        CarteInondation carteInondation6 = new CarteInondation(NomTuile.Les_Falaises_De_L_Oubli);
        CarteInondation carteInondation7 = new CarteInondation(NomTuile.Le_Palais_De_Corail);
        CarteInondation carteInondation8 = new CarteInondation(NomTuile.La_Porte_d_Argent);
        CarteInondation carteInondation9 = new CarteInondation(NomTuile.Les_Dunes_De_L_illusion);
        CarteInondation carteInondation10 = new CarteInondation(NomTuile.Heliport);
        CarteInondation carteInondation11 = new CarteInondation(NomTuile.La_Porte_De_Cuivre);
        CarteInondation carteInondation12 = new CarteInondation(NomTuile.Le_Jardin_Des_Hurlements);
        CarteInondation carteInondation13 = new CarteInondation(NomTuile.La_Foret_Pourpre);
        CarteInondation carteInondation14 = new CarteInondation(NomTuile.Le_Lagon_Perdu);
        CarteInondation carteInondation15 = new CarteInondation(NomTuile.Le_Marais_Brumeux);
        CarteInondation carteInondation16 = new CarteInondation(NomTuile.Observatoire);
        CarteInondation carteInondation17 = new CarteInondation(NomTuile.Le_Rocher_Fantome);
        CarteInondation carteInondation18 = new CarteInondation(NomTuile.La_Caverne_Du_Braisier);
        CarteInondation carteInondation19 = new CarteInondation(NomTuile.Le_Temple_Du_Soleil);
        CarteInondation carteInondation20 = new CarteInondation(NomTuile.Le_Temple_De_La_Lune);
        CarteInondation carteInondation21 = new CarteInondation(NomTuile.Le_Palais_Des_Marees);
        CarteInondation carteInondation22 = new CarteInondation(NomTuile.Le_Val_Du_Crepuscule);
        CarteInondation carteInondation23 = new CarteInondation(NomTuile.La_Tour_Du_Guet);
        CarteInondation carteInondation24 = new CarteInondation(NomTuile.Le_Jardin_Des_Murmures);
        //ajout
        cartesInondations.add(carteInondation1);
        cartesInondations.add(carteInondation2);
        cartesInondations.add(carteInondation3);
        cartesInondations.add(carteInondation4);
        cartesInondations.add(carteInondation5);
        cartesInondations.add(carteInondation6);
        cartesInondations.add(carteInondation7);
        cartesInondations.add(carteInondation8);
        cartesInondations.add(carteInondation9);
        cartesInondations.add(carteInondation10);
        cartesInondations.add(carteInondation11);
        cartesInondations.add(carteInondation12);
        cartesInondations.add(carteInondation13);
        cartesInondations.add(carteInondation14);
        cartesInondations.add(carteInondation15);
        cartesInondations.add(carteInondation16);
        cartesInondations.add(carteInondation17);
        cartesInondations.add(carteInondation18);
        cartesInondations.add(carteInondation19);
        cartesInondations.add(carteInondation20);
        cartesInondations.add(carteInondation21);
        cartesInondations.add(carteInondation22);
        cartesInondations.add(carteInondation23);
        cartesInondations.add(carteInondation24);
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
