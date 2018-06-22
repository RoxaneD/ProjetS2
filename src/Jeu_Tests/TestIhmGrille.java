/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu_Tests;

import Aventuriers.Aventurier;
import Aventuriers.Pilote;
import Aventuriers.Plongeur;
import Cartes.CarteAventurier;
import ElementsJeu.Grille;
import ElementsJeu.Tresor;
import ElementsJeu.Tuile;
import Enumerations.Couleur;
import Enumerations.EtatTuile;
import Enumerations.NomAventurier;
import Enumerations.NomTresor;
import Vues.IhmGrille;
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

    public static void main(String[] args) {
        // TODO code application logic here
        tuiles.add(grille.getTuile(3, 3));
        tuiles.add(grille.getTuile(3, 4));
        tuiles.add(grille.getTuile(3, 6));

        grille.getTuile(4, 4).setEtat(EtatTuile.submergee);
        grille.getTuile(3, 3).setEtat(EtatTuile.inondee);

        CarteAventurier carte1 = new CarteAventurier(NomAventurier.plongeur, Couleur.noir);
        CarteAventurier carte2 = new CarteAventurier(NomAventurier.pilote, Couleur.bleu);

        Plongeur aventurier1 = new Plongeur("Marie", carte1);
        aventurier1.addTuile(grille.getTuile(3, 3));
        aventurier1.addTuile(grille.getTuile(4, 3));
        Pilote aventurier2 = new Pilote("Roxane", carte2);

        ArrayList<Aventurier> a = new ArrayList<>();
        a.add(aventurier1);
        a.add(aventurier2);

        Tresor tresor1 = new Tresor(NomTresor.Calice);
        Tresor tresor2 = new Tresor(NomTresor.Cristal);
        Tresor tresor3 = new Tresor(NomTresor.Pierre);
        Tresor tresor4 = new Tresor(NomTresor.Zephyr);

        ArrayList<Tresor> tr = new ArrayList<Tresor>();
        tr.add(tresor1);
        tr.add(tresor2);
        tr.add(tresor3);
        tr.add(tresor4);

        ihm = new IhmGrille(grille, a, tr);

        grille.getTuile(2, 2).setEtat(EtatTuile.submergee);
        ihm.afficherTuilesPossiblesAssechement(tuiles);
        ihm.afficherTuileActuelle(grille.getTuile(3, 2));
        

        window.add(ihm);
        window.setSize(800, 800);
        window.setVisible(true);

        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        

    }

}
