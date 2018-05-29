package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import java.util.ArrayList;

public class Messager extends Aventurier {

    // constructeurs
    Messager(String nomJoueur, CarteAventurier carteaventurier){
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }
    
    // autres
    @Override
    public ArrayList<Tuile> calculDeplacementPos() {

    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {

    }

}
