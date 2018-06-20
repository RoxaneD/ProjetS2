/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu_Tests;

import Aventuriers.Aventurier;
import Aventuriers.Explorateur;
import Cartes.CarteAventurier;
import ElementsJeu.Grille;
import ElementsJeu.Tuile;
import Enumerations.Couleur;
import Enumerations.EtatTuile;
import Enumerations.NomAventurier;
import Vues.IhmGrille;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author paradisc
 */
public class TestIhmGrille {

    /**
     * @param args the command line arguments
     */
    private static JFrame window = new JFrame();
    private static Grille grille = new Grille();
    private static IhmGrille ihm;
    private static ArrayList<Tuile> tuiles = new ArrayList<>();
    

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        tuiles.add(grille.getTuile(3,3));
        tuiles.add(grille.getTuile(3,4));
        tuiles.add(grille.getTuile(3,6));
        tuiles.add(grille.getTuile(4,4));
        System.out.println(tuiles.get(1).getNom().toString());
                
        
        ihm = new IhmGrille(grille);
        window.add(ihm);
        window.setSize(800, 800);
        window.setVisible(true);           
        
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
