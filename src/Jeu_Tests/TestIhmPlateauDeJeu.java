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
import Vues.VueAventurierDemo;
import Vues.VueGrilleDemo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author paradisc
 */
public class TestIhmPlateauDeJeu {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Grille grille = new Grille();
        CarteAventurier carte1 = new CarteAventurier(NomAventurier.plongeur, Couleur.noir);
        CarteAventurier carte2 = new CarteAventurier(NomAventurier.plongeur, Couleur.noir);

        Plongeur aventurier1 = new Plongeur("Marie", carte1);
        Pilote aventurier2 = new Pilote("Roxane", carte2);

        HashMap<String, Aventurier> aventuriers = new HashMap<>();
        aventuriers.put(aventurier1.getNomJoueur(), aventurier1);
        aventuriers.put(aventurier2.getNomJoueur(), aventurier2);

        IhmPlateauDeJeu ihm = new IhmPlateauDeJeu(aventuriers, grille);
        ihm.afficherIhm();

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
