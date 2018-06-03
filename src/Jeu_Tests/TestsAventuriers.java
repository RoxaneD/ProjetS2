/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu_Tests;

import Aventuriers.Explorateur;
import Aventuriers.Ingenieur;
import Aventuriers.Messager;
import Aventuriers.Navigateur;
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
public class TestsAventuriers {

    public static void main(String[] args) {

        // création de la grille
        Grille grilleDeJeu = new Grille();

        // création des cartes aventuriers 
        CarteAventurier carte1 = new CarteAventurier("description", NomAventurier.explorateur, Couleur.vert);
        CarteAventurier carte2 = new CarteAventurier("description", NomAventurier.messager, Couleur.blanc);
        CarteAventurier carte3 = new CarteAventurier("description", NomAventurier.pilote, Couleur.bleu);
        CarteAventurier carte4 = new CarteAventurier("description", NomAventurier.plongeur, Couleur.noir);
        CarteAventurier carte5 = new CarteAventurier("description", NomAventurier.ingenieur, Couleur.rouge);
        CarteAventurier carte6 = new CarteAventurier("description", NomAventurier.navigateur, Couleur.jaune);

        // création des aventuriers 
        Explorateur explorateur = new Explorateur("Explorateur", carte1);
        Messager messager = new Messager("Messager", carte2);
        Pilote pilote = new Pilote("Pilote", carte3);
        Plongeur plongeur = new Plongeur("Plongeur", carte4);
        Ingenieur ingenieur = new Ingenieur("Ingenieur", carte5);
        Navigateur navigateur = new Navigateur("Navigateur", carte6);

        // initialisation de la grille de jeu (création des tuiles + ajout des états+ ajout dans la grille)
        Tuile t1 = new Tuile(grilleDeJeu, 1, 1);
        Tuile t2 = new Tuile(grilleDeJeu, 2, 1);
        Tuile t3 = new Tuile(grilleDeJeu, 3, 1, NomTuile.Le_Pont_Des_Abimes);
        Tuile t4 = new Tuile(grilleDeJeu, 4, 1, NomTuile.La_Porte_De_Bronze, carte5);
        Tuile t5 = new Tuile(grilleDeJeu, 5, 1);
        Tuile t6 = new Tuile(grilleDeJeu, 6, 1);
        Tuile t7 = new Tuile(grilleDeJeu, 1, 2);
        Tuile t8 = new Tuile(grilleDeJeu, 2, 2, NomTuile.La_Caverne_Des_Ombres);
        Tuile t9 = new Tuile(grilleDeJeu, 3, 2, NomTuile.La_Porte_De_Fer, carte4);
        Tuile t10 = new Tuile(grilleDeJeu, 4, 2, NomTuile.La_Porte_d_Or, carte6);
        Tuile t11 = new Tuile(grilleDeJeu, 5, 2, NomTuile.Les_Falaises_De_L_Oubli);
        Tuile t12 = new Tuile(grilleDeJeu, 6, 2);
        Tuile t13 = new Tuile(grilleDeJeu, 1, 3, NomTuile.Le_Palais_De_Corail);
        Tuile t14 = new Tuile(grilleDeJeu, 2, 3, NomTuile.La_Porte_d_Argent, carte2);
        Tuile t15 = new Tuile(grilleDeJeu, 3, 3, NomTuile.Les_Dunes_De_L_illusion);
        Tuile t16 = new Tuile(grilleDeJeu, 4, 3, NomTuile.Heliport, carte3);
        Tuile t17 = new Tuile(grilleDeJeu, 5, 3, NomTuile.La_Porte_De_Cuivre, carte1);
        Tuile t18 = new Tuile(grilleDeJeu, 6, 3, NomTuile.Le_Jardin_Des_Hurlements);
        Tuile t19 = new Tuile(grilleDeJeu, 1, 4, NomTuile.La_Foret_Pourpre);
        Tuile t20 = new Tuile(grilleDeJeu, 2, 4, NomTuile.Le_Lagon_Perdu);
        Tuile t21 = new Tuile(grilleDeJeu, 3, 4, NomTuile.Le_Marais_Brumeux);
        Tuile t22 = new Tuile(grilleDeJeu, 4, 4, NomTuile.Observatoire);
        Tuile t23 = new Tuile(grilleDeJeu, 5, 4, NomTuile.Le_Rocher_Fantome);
        Tuile t24 = new Tuile(grilleDeJeu, 6, 4, NomTuile.La_Caverne_Du_Braisier);
        Tuile t25 = new Tuile(grilleDeJeu, 1, 5);
        Tuile t26 = new Tuile(grilleDeJeu, 2, 5, NomTuile.Le_Temple_Du_Soleil);
        Tuile t27 = new Tuile(grilleDeJeu, 3, 5, NomTuile.Le_Temple_De_La_Lune);
        Tuile t28 = new Tuile(grilleDeJeu, 4, 5, NomTuile.Le_Palais_Des_Marees);
        Tuile t29 = new Tuile(grilleDeJeu, 5, 5, NomTuile.Le_Val_Du_Crepuscule);
        Tuile t30 = new Tuile(grilleDeJeu, 6, 5);
        Tuile t31 = new Tuile(grilleDeJeu, 1, 6);
        Tuile t32 = new Tuile(grilleDeJeu, 2, 6);
        Tuile t33 = new Tuile(grilleDeJeu, 3, 6, NomTuile.La_Tour_Du_Guet);
        Tuile t34 = new Tuile(grilleDeJeu, 4, 6, NomTuile.Le_Jardin_Des_Murmures);
        Tuile t35 = new Tuile(grilleDeJeu, 5, 6);
        Tuile t36 = new Tuile(grilleDeJeu, 6, 6);

        t4.setEtat(EtatTuile.inondee);
        t15.setEtat(EtatTuile.submergee);
        t20.setEtat(EtatTuile.inondee);
        t21.setEtat(EtatTuile.submergee);
        t22.setEtat(EtatTuile.inondee);
        t23.setEtat(EtatTuile.submergee);
        t24.setEtat(EtatTuile.inondee);
        t27.setEtat(EtatTuile.submergee);
        t34.setEtat(EtatTuile.inondee);

        grilleDeJeu.getTuiles().add(t1);
        grilleDeJeu.getTuiles().add(t2);
        grilleDeJeu.getTuiles().add(t3);
        grilleDeJeu.getTuiles().add(t4);
        grilleDeJeu.getTuiles().add(t5);
        grilleDeJeu.getTuiles().add(t6);
        grilleDeJeu.getTuiles().add(t7);
        grilleDeJeu.getTuiles().add(t8);
        grilleDeJeu.getTuiles().add(t9);
        grilleDeJeu.getTuiles().add(t10);
        grilleDeJeu.getTuiles().add(t11);
        grilleDeJeu.getTuiles().add(t12);
        grilleDeJeu.getTuiles().add(t13);
        grilleDeJeu.getTuiles().add(t14);
        grilleDeJeu.getTuiles().add(t15);
        grilleDeJeu.getTuiles().add(t16);
        grilleDeJeu.getTuiles().add(t17);
        grilleDeJeu.getTuiles().add(t18);
        grilleDeJeu.getTuiles().add(t19);
        grilleDeJeu.getTuiles().add(t20);
        grilleDeJeu.getTuiles().add(t21);
        grilleDeJeu.getTuiles().add(t22);
        grilleDeJeu.getTuiles().add(t23);
        grilleDeJeu.getTuiles().add(t24);
        grilleDeJeu.getTuiles().add(t25);
        grilleDeJeu.getTuiles().add(t26);
        grilleDeJeu.getTuiles().add(t27);
        grilleDeJeu.getTuiles().add(t28);
        grilleDeJeu.getTuiles().add(t29);
        grilleDeJeu.getTuiles().add(t30);
        grilleDeJeu.getTuiles().add(t31);
        grilleDeJeu.getTuiles().add(t32);
        grilleDeJeu.getTuiles().add(t33);
        grilleDeJeu.getTuiles().add(t34);
        grilleDeJeu.getTuiles().add(t35);
        grilleDeJeu.getTuiles().add(t36);

        // ajouts des aventuriers sur leur case
        explorateur.addTuile(t17);
        messager.addTuile(t14);
        pilote.addTuile(t16);
        plongeur.addTuile(t9);
        ingenieur.addTuile(t4);
        navigateur.addTuile(t10);

        // --------------------------------------------------------------------------------------------
        // TESTS
        // --------------------------------------------------------------------------------------------
        // tests explorateur
        System.out.println("------------------------------------------------");
        System.out.println("Explorateur (vert) - Test VALIDE");

        System.out.println("");
        System.out.println("Tuile actuelle :");
        System.out.println(explorateur.getTuile().getNom());

        System.out.println("");
        System.out.println("Tuile où se déplacer :");
        for (Tuile t : explorateur.calculDeplacementPos()) {
            System.out.println(t.getNom());
        }

        System.out.println();
        System.out.println("Tuile à assecher :");
        for (Tuile t : explorateur.calculAssechementPos()) {
            System.out.println(t.getNom());
        }
        System.out.println("");

        // tests messager
        System.out.println("------------------------------------------------");
        System.out.println("Messager (blanc - orange sur le modèle) - Test VALIDE");

        System.out.println("");
        System.out.println("Tuile actuelle :");
        System.out.println(messager.getTuile().getNom());

        System.out.println("");
        System.out.println("Tuile où se déplacer :");
        for (Tuile t : messager.calculDeplacementPos()) {
            System.out.println(t.getNom());
        }

        System.out.println();
        System.out.println("Tuile à assecher :");
        for (Tuile t : messager.calculAssechementPos()) {
            System.out.println(t.getNom());
        }
        System.out.println("");

        // tests pilote
        System.out.println("------------------------------------------------");
        System.out.println("Pilote (bleu) - Test VALIDE");

        System.out.println("");
        System.out.println("Tuile actuelle :");
        System.out.println(pilote.getTuile().getNom());

        System.out.println("");
        System.out.println("Tuile où se déplacer (avec son pouvoir activé):");
        for (Tuile t : pilote.calculDeplacementPos()) {
            System.out.println(t.getNom());
        }

        System.out.println("");
        System.out.println("Tuile où se déplacer (avec son pouvoir désactivé):");
         pilote.setPouvoir(true);
        for (Tuile t : pilote.calculDeplacementPos()) {
            System.out.println(t.getNom());
        }

        System.out.println();
        System.out.println("Tuile à assecher :");
        for (Tuile t : pilote.calculAssechementPos()) {
            System.out.println(t.getNom());
        }
        System.out.println("");

        // tests plongeur
        System.out.println("------------------------------------------------");
        System.out.println("Plongeur (noir) - Test VALIDE");

        System.out.println("");
        System.out.println("Tuile actuelle :");
        System.out.println(plongeur.getTuile().getNom());

        System.out.println("");
        System.out.println("Tuile où se déplacer :");
        for (Tuile t : plongeur.calculDeplacementPos()) {
            System.out.println(t.getNom());
        }

        System.out.println();
        System.out.println("Tuile à assecher :");
        for (Tuile t : plongeur.calculAssechementPos()) {
            System.out.println(t.getNom());
        }
        System.out.println("");

        // tests ingénieur
        System.out.println("------------------------------------------------");
        System.out.println("Ingénieur (rouge) - Test VALIDE");

        System.out.println("");
        System.out.println("Tuile actuelle :");
        System.out.println(ingenieur.getTuile().getNom());

        System.out.println("");
        System.out.println("Tuile où se déplacer :");
        for (Tuile t : ingenieur.calculDeplacementPos()) {
            System.out.println(t.getNom());
        }

        System.out.println();
        System.out.println("Tuile à assecher :");
        for (Tuile t : ingenieur.calculAssechementPos()) {
            System.out.println(t.getNom());
        }
        System.out.println("");

        // tests navigateur
        System.out.println("------------------------------------------------");
        System.out.println("Navigateur (jaune) - Test VALIDE");

        System.out.println("");
        System.out.println("Tuile actuelle :");
        System.out.println(navigateur.getTuile().getNom());

        System.out.println("");
        System.out.println("Tuile où se déplacer :");
        for (Tuile t : navigateur.calculDeplacementPos()) {
            System.out.println(t.getNom());
        }

        System.out.println("");
        System.out.println("Tuile à assecher :");
        for (Tuile t : navigateur.calculAssechementPos()) {
            System.out.println(t.getNom());
        }
        System.out.println("");
    }

}
