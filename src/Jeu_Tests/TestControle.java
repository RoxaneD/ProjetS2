// petit test qui permet de voir à peu près comment fonctionne le controleur avec les vues
package Jeu_Tests;

import Aventuriers.Aventurier;
import Aventuriers.Explorateur;
import Aventuriers.Ingenieur;
import Aventuriers.Messager;
import Aventuriers.Navigateur;
import Aventuriers.Pilote;
import Aventuriers.Plongeur;
import Cartes.CarteAventurier;
import Cartes.CarteInondation;
import Cartes.CarteSpeciale;
import Cartes.CarteTresor;
import Controle.Action;
import Controle.Controleur;
import Controle.TypesActions;
import ElementsJeu.Grille;
import ElementsJeu.NiveauEau;
import ElementsJeu.Tresor;
import ElementsJeu.Tuile;
import Enumerations.Couleur;
import Enumerations.EtatTuile;
import Enumerations.NomAventurier;
import Enumerations.NomCarteSpeciale;
import Enumerations.NomTresor;
import Enumerations.NomTuile;
import Tas.DefausseInondations;
import Tas.DefausseTresors;
import Tas.TasAventuriers;
import Tas.TasInondations;
import Tas.TasPoubelle;
import Tas.TasTresors;
import Vues.Plateau;
import Vues.VueAventurierDemo;
import Vues.VueGrilleDemo;
import java.awt.Color;
import java.util.HashMap;
import java.util.Scanner;

public class TestControle {

    public static void main(String[] args) {
        // initialisation du jeu complet (cartes.aventuriers, tuiles, etc ...)
        Plateau plateau = new Plateau();

        // test : pour 1 TOUR DE JEU
        /** Fait planter pour le moment :
        for (String s : plateau.getControleur().getVuesAventurier().keySet()) {
            plateau.getControleur().setNombreActions(0);
            while (plateau.getControleur().getNombreActions() != 3) {
                plateau.getControleur().afficherVueAventurier(plateau.getControleur().getVuesAventurier().get(s));
            }
        }
        **/

        // test Utils.poserQuestion("...") et Utils.afficherInformation("..")
        //if (poserQuestion("Ceci est une question")) {
        //    afficherInformation("Ceci est une information");
        //}
    }

}
