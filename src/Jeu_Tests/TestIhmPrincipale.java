/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu_Tests;

import Cartes.CarteAventurier;
import Cartes.CarteTresors;
import ElementsJeu.Grille;
import ElementsJeu.Tuile;
import Enumerations.Couleur;
import Enumerations.EtatTuile;
import Enumerations.NomAventurier;
import Enumerations.NomTresor;
import Enumerations.NomTuile;
import Util.Utils;
import Vues.IhmPlateauDeJeu;
import Vues.Plateau;
import Vues.VueAventurierDemo;
import Vues.VueGrilleDemo;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author paradisc
 */
public class TestIhmPrincipale {

    /**
     * @param args the command line arguments
     */
    private static IhmPlateauDeJeu ihm;

    public static void main(String[] args) {
        // TODO code application logic here
        
        Grille grilleDeJeu = new Grille();
        VueGrilleDemo vueGrille = new VueGrilleDemo(grilleDeJeu);
        
         CarteAventurier carte = new CarteAventurier(NomAventurier.explorateur, Couleur.bleu);
        VueAventurierDemo vueJoueur1 = new VueAventurierDemo("Aventurier 1", carte, Utils.Pion.BLEU.getCouleur());
        CarteTresors carteT = new CarteTresors( NomTresor.La_Pierre_sacree);
        vueJoueur1.addCarteTresors(carteT);

        //vueGrille.getWindow().setVisible(false);
        // vueJoueur1.getWindow().setVisible(false);

        ihm = new IhmPlateauDeJeu(vueJoueur1, vueGrille);
        ihm.getWindow().setVisible(true);

        /*  while (plateau.getControleur().isTermine() == false) {
            for (VueAventurierDemo vueAventurierTest : vuesAventuriers) {
                plateau.getControleur().afficherVueAventurier(vueAventurierTest);
                Tuile tuile2 = plateau.getControleur().getAventurier().getTuile();
                // pour afficher en noir  la tuile sur lequel il est
                plateau.getControleur().getVueGrille().afficherTuileActuelle(tuile2);
                while (plateau.getControleur().getNombreActions() < 3) {
                    for (Tuile t : plateau.getControleur().getVueGrille().getTuiles()) {
                        plateau.getControleur().getVueGrille().getFondTuiles().get(t1).setBackground(Color.WHITE);
                    }
                    //Tant que le booléen actioneffectuer est a faux on affiche la tuile actuelle
                    while (!plateau.getControleur().isActionEffectue()) {
                        plateau.getControleur().getVueGrille().afficherTuileActuelle(tuile2);
                    }
                    plateau.getControleur().setActionEffectue(false);
                    tuile2 = plateau.getControleur().getAventurier().getTuile();
                    // pour afficher en noir  la tuile sur lequel il est
                    System.out.println(plateau.getControleur().getNombreActions());
                }
                //On passe le nombre d'action à 0
                plateau.getControleur().setNombreActions(0);
            }
            //on passe tous les pouvoirs a faux et termine a vrai
            plateau.getControleur().setPouvoirIngenieur(false);
            plateau.getControleur().setPouvoirPilote(false);
            plateau.getControleur().setTermine(true);
        }*/
        //On passe a faux la visibilite des fenètres
        // plateau.getControleur().getVueAventurier().getWindow().setVisible(false);
        // plateau.getControleur().getVueGrille().getWindow().setVisible(false);
        // test Utils.poserQuestion("...") et Utils.afficherInformation("..")
        //if (poserQuestion("Ceci est une question")) {
        //    afficherInformation("Ceci est une information");
        //}
    }
}
