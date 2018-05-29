package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import java.util.ArrayList;

public class Ingenieur extends Aventurier {

    // constructeurs
    Ingenieur(String nomJoueur, CarteAventurier carteaventurier){
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }
    
    // autres
    @Override
    public ArrayList<Tuile> calculDeplacementPos() {
        
     ArrayList<Tuile> TuilePossible = new ArrayList<>();
     
        int posX = this.getTuile().getPosX();
        int posY = this.getTuile().getPosY();
        if(posX != 1){
            
        }
        TuilePossible.add(getTuileDeplacement(posX , posY +1 ));
            
    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {

    }

}
