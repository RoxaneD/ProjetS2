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

        ArrayList<VueAventurierDemo> vuesAventuriers = new ArrayList<>();
        vuesAventuriers.add(vueJoueur1);
        vuesAventuriers.add(vueJoueur2);
        vuesAventuriers.add(vueJoueur3);
        vuesAventuriers.add(vueJoueur4);
        vuesAventuriers.add(vueJoueur5);
        vuesAventuriers.add(vueJoueur6);

        // test : pour 1 TOUR DE JEU - chaque joueur joue tour à tour
        for (VueAventurierDemo v : vuesAventuriers) {
            plateau.getControleur().afficherVueAventurier(v);
            Tuile t = plateau.getControleur().getAventurier().getTuile();
            // pour afficher en noir  la tuile sur lequel il est
            plateau.getControleur().getVueGrille().afficherTuileActuelle(t);
            while (plateau.getControleur().getNombreActions() < 3) {
                for (Tuile t1 : plateau.getControleur().getVueGrille().getTuiles()){
                    plateau.getControleur().getVueGrille().getFondTuiles().get(t1).setBackground(Color.WHITE);
                }
                
                while (!plateau.getControleur().isActionEffectue()) {
                    plateau.getControleur().getVueGrille().afficherTuileActuelle(t);
                }
                plateau.getControleur().setActionEffectue(false);
                t = plateau.getControleur().getAventurier().getTuile();
                // pour afficher en noir  la tuile sur lequel il est
                System.out.println(plateau.getControleur().getNombreActions());
            }
            plateau.getControleur().setNombreActions(0);
        }

        // test Utils.poserQuestion("...") et Utils.afficherInformation("..")
        //if (poserQuestion("Ceci est une question")) {
        //    afficherInformation("Ceci est une information");
        //}
    }

}
