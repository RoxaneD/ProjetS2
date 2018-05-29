package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import java.util.ArrayList;

public class Explorateur extends Aventurier {

    // constructeurs
    Explorateur(String nomJoueur, CarteAventurier carteaventurier){
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }
    
    // autres

    
    @Override
    public ArrayList<Tuile> calculDeplacementPos() {
        int posX = this.getTuile().getPosX();
        int posY = this.getTuile().getPosY();
        if(posX ==1){
      
        }
        
        
    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {
        
    }

}
