/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import Aventuriers.Explorateur;
import Aventuriers.Messager;
import Aventuriers.Pilote;
import Aventuriers.Plongeur;
import Cartes.CarteAventurier;
import ElementsJeu.Grille;
import ElementsJeu.Tuile;
import Enumerations.Couleur;
import Enumerations.EtatTuile;
import Enumerations.NomAventurier;
import Enumerations.NomTuile;

/**
 *
 * @author deflandr
 */
public class TourDeJeu {

    public static void main(String[] args) {

        Grille grilleDeJeu = new Grille();
        CarteAventurier carte = new CarteAventurier("OUI", NomAventurier.explorateur, Couleur.vert);
        CarteAventurier carte2 = new CarteAventurier("NON", NomAventurier.messager, Couleur.blanc);
        CarteAventurier carte3 = new CarteAventurier("NOergerN", NomAventurier.pilote, Couleur.bleu);
        CarteAventurier carte4 = new CarteAventurier("NOergerN", NomAventurier.plongueur, Couleur.noir);
        Explorateur explorateur = new Explorateur("Billy", carte);
        Messager messager = new Messager("Billy", carte2);
        Pilote pilote = new Pilote("Billy", carte3);
        Plongeur plongeur = new Plongeur("Billy",carte4);
        Tuile t = new Tuile(grilleDeJeu, 1, 1, NomTuile.La_Caverne_Des_Ombres);
        Tuile t2 = new Tuile(grilleDeJeu, 2, 1, NomTuile.La_Porte_De_Fer, carte);
        Tuile t3 = new Tuile(grilleDeJeu, 3, 1, NomTuile.La_Porte_d_Or);
        Tuile t4 = new Tuile(grilleDeJeu, 1, 2, NomTuile.La_Porte_d_Argent,carte4);
        Tuile t5 = new Tuile(grilleDeJeu, 2, 2, NomTuile.Les_Dunes_De_L_illusion);
        Tuile t6 = new Tuile(grilleDeJeu, 3, 2, NomTuile.Heliport, carte2);
        Tuile t7 = new Tuile(grilleDeJeu, 1, 3, NomTuile.Le_Lagon_Perdu);
        Tuile t8 = new Tuile(grilleDeJeu, 2, 3, NomTuile.Le_Marais_Brumeux);
        Tuile t9 = new Tuile(grilleDeJeu, 3, 3, NomTuile.Observatoire);
        Tuile t10 = new Tuile(grilleDeJeu, 1, 6, NomTuile.La_Tour_Du_Guet);
        t5.setEtat(EtatTuile.submergee);
        t7.setEtat(EtatTuile.inondee);
        t6.setEtat(EtatTuile.inondee);
        t9.setEtat(EtatTuile.inexistante);
        grilleDeJeu.getTuiles().add(t);
        grilleDeJeu.getTuiles().add(t2);
        grilleDeJeu.getTuiles().add(t3);
        grilleDeJeu.getTuiles().add(t4);
        grilleDeJeu.getTuiles().add(t5);
        grilleDeJeu.getTuiles().add(t6);
        grilleDeJeu.getTuiles().add(t7);
        grilleDeJeu.getTuiles().add(t8);
        grilleDeJeu.getTuiles().add(t9);
        grilleDeJeu.getTuiles().add(t10);

        explorateur.addTuile(t2);
        messager.addTuile(t6);
        pilote.addTuile(t);
        plongeur.addTuile(t4);

        System.out.println("Explorateur");
        System.out.println(explorateur.getTuile().getNom());
        System.out.println("Tuile où se déplacer :");
        for (Tuile T : explorateur.calculDeplacementPos()) {
            System.out.println(T.getNom());
        }

        System.out.println();

        System.out.println("Tuile à assecher :");
        for (Tuile T : explorateur.calculAssechementPos()) {
            System.out.println(T.getNom());
        }
        System.out.println();
        System.out.println("Messager");
        System.out.println(messager.getTuile().getNom());
        System.out.println("Tuile où se déplacer :");
        for (Tuile T : messager.calculDeplacementPos()) {
            System.out.println(T.getNom());
        }

        System.out.println();

        System.out.println("Tuile à assecher :");
        for (Tuile T : messager.calculAssechementPos()) {
            System.out.println(T.getNom());
        }
         pilote.setPouvoir(true);
         System.out.println();
        System.out.println("Pilote");
        System.out.println(pilote.getTuile().getNom());
        System.out.println("Tuile où se déplacer :");
        for (Tuile T : pilote.calculDeplacementPos()) {
            System.out.println(T.getNom());
        }

        System.out.println();

        System.out.println("Tuile à assecher :");
        for (Tuile T : pilote.calculAssechementPos()) {
            System.out.println(T.getNom());
        }
        
         System.out.println();
        System.out.println("Plongeur");
        System.out.println(plongeur.getTuile().getNom());
        System.out.println("Tuile où se déplacer :");
        for (Tuile T : plongeur.calculDeplacementPos()) {
            System.out.println(T.getNom());
        }

        System.out.println();

        System.out.println("Tuile à assecher :");
        for (Tuile T : plongeur.calculAssechementPos()) {
            System.out.println(T.getNom());
        }
       

    }

}
