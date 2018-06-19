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
        CarteInondation carteInondation1 = new CarteInondation(NomTuile.LePontDesAbimes);
        CarteInondation carteInondation2 = new CarteInondation(NomTuile.LaPorteDeBronze);
        CarteInondation carteInondation3 = new CarteInondation(NomTuile.LaCaverneDesOmbres);
        CarteInondation carteInondation4 = new CarteInondation(NomTuile.LaPorteDeFer);
        CarteInondation carteInondation5 = new CarteInondation(NomTuile.LaPortedOr);
        CarteInondation carteInondation6 = new CarteInondation(NomTuile.LesFalaisesDeLOubli);
        CarteInondation carteInondation7 = new CarteInondation(NomTuile.LePalaisDeCorail);
        CarteInondation carteInondation8 = new CarteInondation(NomTuile.LaPortedArgent);
        CarteInondation carteInondation9 = new CarteInondation(NomTuile.LesDunesDeLillusion);
        CarteInondation carteInondation10 = new CarteInondation(NomTuile.Heliport);
        CarteInondation carteInondation11 = new CarteInondation(NomTuile.LaPorteDeCuivre);
        CarteInondation carteInondation12 = new CarteInondation(NomTuile.LeJardinDesHurlements);
        CarteInondation carteInondation13 = new CarteInondation(NomTuile.LaForetPourpre);
        CarteInondation carteInondation14 = new CarteInondation(NomTuile.LeLagonPerdu);
        CarteInondation carteInondation15 = new CarteInondation(NomTuile.LeMaraisBrumeux);
        CarteInondation carteInondation16 = new CarteInondation(NomTuile.Observatoire);
        CarteInondation carteInondation17 = new CarteInondation(NomTuile.LeRocherFantome);
        CarteInondation carteInondation18 = new CarteInondation(NomTuile.LaCaverneDuBrasier);
        CarteInondation carteInondation19 = new CarteInondation(NomTuile.LeTempleDuSoleil);
        CarteInondation carteInondation20 = new CarteInondation(NomTuile.LeTempleDeLaLune);
        CarteInondation carteInondation21 = new CarteInondation(NomTuile.LePalaisDesMarees);
        CarteInondation carteInondation22 = new CarteInondation(NomTuile.LeValDuCrepuscule);
        CarteInondation carteInondation23 = new CarteInondation(NomTuile.LaTourDuGuet);
        CarteInondation carteInondation24 = new CarteInondation(NomTuile.LeJardinDesMurmures);
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
