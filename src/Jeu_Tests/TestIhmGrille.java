/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu_Tests;

import ElementsJeu.Grille;
import Enumerations.EtatTuile;
import Vues.IhmGrille;
import java.awt.Component;
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
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //grille.getTuile(4,4).setEtat(EtatTuile.inondee);
        //grille.getTuile(3,3).setEtat(EtatTuile.submergee);
        ihm = new IhmGrille(grille);
        System.out.println("test3");
        window.add(ihm);
        window.setSize(1200, 1200);
        window.setVisible(true);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }
    
}
