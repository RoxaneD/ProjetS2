// petit test qui permet de voir à peu près comment fonctionne le controleur avec les vues
package Jeu_Tests;

import ElementsJeu.Tuile;
import Vues.Plateau;
import Vues.VueAventurierDemo;

public class TestControle {

    public static void main(String[] args) {
        // initialisation du jeu complet (cartes.aventuriers, tuiles, etc ...)
        Plateau plateau = new Plateau();

        // test : pour 1 TOUR DE JEU - chaque joueur joue tour à tour
        plateau.getControleur().afficherVueAventurier(plateau.getControleur().getVuesAventurier().get("NomJoueur1"));
        Tuile t = plateau.getControleur().getAventurier().getTuile();
        // pour afficher en rose la tuile sur lequel il est
        while (plateau.getControleur().getNombreActions() != 3) {
            plateau.getControleur().getVueGrille().afficherTuileActuelle(plateau.getControleur().getAventurier().getTuile());
        }
        plateau.getControleur().setNombreActions(0);
        System.out.println(plateau.getControleur().getNombreActions());

        // test Utils.poserQuestion("...") et Utils.afficherInformation("..")
        //if (poserQuestion("Ceci est une question")) {
        //    afficherInformation("Ceci est une information");
        //}
    }

}
