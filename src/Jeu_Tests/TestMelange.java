/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu_Tests;

import Cartes.CarteAventurier;
import Cartes.CarteInondation;
import Cartes.CarteTresor;
import Cartes.CarteTresors;
import ElementsJeu.Grille;
import Enumerations.Couleur;
import Enumerations.NomAventurier;
import Tas.TasAventuriers;
import Tas.TasInondations;
import Tas.TasTresors;
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
        
        //test Melange pour le tas aventuriers
        System.out.println("Tas Aventurier : ");
        TasAventuriers tasAv = new TasAventuriers();
        for (CarteAventurier c : tasAv.getCartesAventuriers()){
            System.out.println(c.getNom());
        }
        
        System.out.println("");
        
        //test melange pour le tas inondations
        System.out.println("Tas Inondation : ");
        TasInondations tasIn = new TasInondations();
        for(CarteInondation c : tasIn.getCartesInondations()){
            System.out.println(c.getNom());
        }
        
        System.out.println("");
        
        //test melange pour le tas tresor
        System.out.println("Tas Tresor : ");
        TasTresors tasTr = new TasTresors();
        for(CarteTresors c : tasTr.getCartesTresors()){
            System.out.println(c.getNom());
        }
        
        System.out.println("");
        
    }
    
}
