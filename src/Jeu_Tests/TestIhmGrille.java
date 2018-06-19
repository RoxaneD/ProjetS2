/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu_Tests;

import ElementsJeu.Grille;
import Vues.IhmGrille;
import java.awt.Component;
import javax.swing.JFrame;


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
    private static IhmGrille ihm = new IhmGrille(grille);

    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        window.add(ihm);
        window.setSize(600, 600);
        window.setVisible(true);
        
    }
    
}
