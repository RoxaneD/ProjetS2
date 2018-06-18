/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu_Tests;

import Cartes.CarteAventurier;
import ElementsJeu.Grille;
import Enumerations.Couleur;
import Enumerations.NomAventurier;
import Tas.TasAventuriers;
import java.util.ArrayList;

/**
 *
 * @author dechambm
 */
public class TestMelange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // création de la grille
        Grille grilleDeJeu = new Grille();
        
        TasAventuriers tasAv = new TasAventuriers();
        
        //test Melange pour le tas aventuriers
        for (CarteAventurier c : tasAv.getCartesAventuriers()){
            System.out.println(c.getNom());
        }
        
        
        
        
    }
    
}
