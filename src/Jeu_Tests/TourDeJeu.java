// petit test qui permet de voir à peu près comment fonctionne le controleur avec les vues
package Jeu_Tests;

import ElementsJeu.Tuile;
import Vues.Plateau;
import Vues.VueAventurierDemo;
import java.awt.Color;
import java.util.ArrayList;

public class TourDeJeu {

    public static void main(String[] args) {
        // initialisation du jeu complet (cartes.aventuriers, tuiles, etc ...)
        Plateau plateau = new Plateau();
        VueAventurierDemo vueJoueur1 = plateau.getControleur().getVuesAventurier().get("NomJoueur1");
        VueAventurierDemo vueJoueur2 = plateau.getControleur().getVuesAventurier().get("NomJoueur2");
        VueAventurierDemo vueJoueur3 = plateau.getControleur().getVuesAventurier().get("NomJoueur3");
        VueAventurierDemo vueJoueur4 = plateau.getControleur().getVuesAventurier().get("NomJoueur4");
        VueAventurierDemo vueJoueur5 = plateau.getControleur().getVuesAventurier().get("NomJoueur5");
        VueAventurierDemo vueJoueur6 = plateau.getControleur().getVuesAventurier().get("NomJoueur6");

        //Création de la vue aventurier et ajout des aventuriers
        ArrayList<VueAventurierDemo> vuesAventuriers = new ArrayList<>();
        vuesAventuriers.add(vueJoueur1);
        vuesAventuriers.add(vueJoueur2);
        vuesAventuriers.add(vueJoueur3);
        vuesAventuriers.add(vueJoueur4);
        vuesAventuriers.add(vueJoueur5);
        vuesAventuriers.add(vueJoueur6);

        // test : pour 1 TOUR DE JEU - chaque joueur joue tour à tour
        while (plateau.getControleur().isTermine() == false) {
            for (VueAventurierDemo vueAventurierTest : vuesAventuriers) {
                plateau.getControleur().afficherVueAventurier(vueAventurierTest);
                Tuile tuile2 = plateau.getControleur().getAventurier().getTuile();
                // pour afficher en noir  la tuile sur lequel il est
                plateau.getControleur().getVueGrille().afficherTuileActuelle(tuile2);
                while (plateau.getControleur().getNombreActions() < 3) {
                    for (Tuile t1 : plateau.getControleur().getVueGrille().getTuiles()) {
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
            //on passe tout les pouvoir a faux et termine a vrai
            plateau.getControleur().setPouvoirIngenieur(false);
            plateau.getControleur().setPouvoirPilote(false);
            plateau.getControleur().setTermine(true);
        }
        //On passe a faux la visibilite des fenètres
        plateau.getControleur().getVueAventurier().getWindow().setVisible(false);
        plateau.getControleur().getVueGrille().getWindow().setVisible(false);

        // test Utils.poserQuestion("...") et Utils.afficherInformation("..")
        //if (poserQuestion("Ceci est une question")) {
        //    afficherInformation("Ceci est une information");
        //}
    }

}
