package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
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
             ArrayList<Tuile> tuilePossible = new ArrayList<>();

        
        int posX = this.getTuile().getPosX();
        int posY = this.getTuile().getPosY();
        if(posX != 1){
           Tuile T = getTuile().getGrille().getTuile(posX -1, posY);
           if ( T.getEtat() != EtatTuile.submergee ){
              tuilePossible.add(T);
           }
        }
        
        if(posX != 6){
            Tuile T = getTuile().getGrille().getTuile(posX +1, posY);
           if ( T.getEtat() != EtatTuile.submergee ){
              tuilePossible.add(T);
           }
        }
        
        if(posY != 1){
            Tuile T = getTuile().getGrille().getTuile(posX, posY -1);
           if ( T.getEtat() != EtatTuile.submergee ){
              tuilePossible.add(T);
           }
        }
        
        if(posY != 6){
            Tuile T = getTuile().getGrille().getTuile(posX, posY +1 );
           if ( T.getEtat() != EtatTuile.submergee ){
              tuilePossible.add(T);
           }
        }
        
        return tuilePossible;
        
        
    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {
        return null;
        
    }

}
