package Jeu_Tests;

import Cartes.CarteAventurier;
import Controle.Action;
import Controle.Controleur;
import Controle.TypesActions;
import ElementsJeu.Tresor;
import ElementsJeu.Tuile;

public class TestControleurObservateur {

    public static void main(String[] args) {
        Controleur c = new Controleur();

        /**
         * ---------------------------------------------------------------------
         * POUR TESTER LA GRILLE - OK
         * ---------------------------------------------------------------------
         * int i = 1; for (Tuile t : c.getGrille().getTuiles()) {
         * System.out.println(i); System.out.println("Nom : " + t.getNom());
         * CarteAventurier carteAventurier = t.getEmplacementAventurier(); if
         * (carteAventurier != null) { System.out.println("Emplacement
         * aventurier : " + t.getEmplacementAventurier().getNom()); } Tresor
         * tresor = t.getEmplacementTresor(); if (tresor != null){
         * System.out.println("Emplacement tresor : "+
         * t.getEmplacementTresor().getNom()); } System.out.println(""); if (i %
         * 6 == 0){ System.out.println("-------------------------------------");
         * } i += 1; }
         *
         */
        /**
         * ---------------------------------------------------------------------
         * POUR TESTER LES AJOUTS DE JOUEURS - OK
         * ---------------------------------------------------------------------
        System.out.println("Avant ajout du joueur 'Marie' : ");
        System.out.println("joueurs :");
        for (String s : c.getJoueurs()) {
            System.out.println(s);
        }
        System.out.println("");
        System.out.println("tasJoueurs :");
        for (String s : c.getTasJoueurs().keySet()) {
            System.out.println(s);
        }
        System.out.println("");
        System.out.println("aventuriers :");
        for (String s : c.getAventuriers().keySet()) {
            System.out.println(s);
        }
        System.out.println("");

        t = new TestControleurObserve();
        t.addObservateur(c);

        Action a = new Action(TypesActions.ajoutJoueur, "Marie");
        t.notifierObservateur(a);

        System.out.println("Après ajout du joueur 'Marie' : ");
        System.out.println("joueurs :");
        for (String s : c.getJoueurs()) {
            System.out.println(s);
        }
        System.out.println("");
        System.out.println("tasJoueurs :");
        for (String s : c.getTasJoueurs().keySet()) {
            System.out.println(s);
        }
        System.out.println("");
        System.out.println("aventuriers :");
        for (String s : c.getAventuriers().keySet()) {
            System.out.println(s);
        }
        System.out.println("");*
         */

    }

}
