/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu_Tests;

import ElementsJeu.Grille;
import ElementsJeu.Tuile;
import Enumerations.EtatTuile;
import Enumerations.NomTuile;
import Vues.IhmPrincipale;
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
    private static IhmPrincipale ihm;
    
    public static void main(String[] args) {
        // TODO code application logic here
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
               
        Grille grilleDeJeu = new Grille();

        Tuile t1 = new Tuile(grilleDeJeu, 1, 1);
        Tuile t2 = new Tuile(grilleDeJeu, 2, 1);
        Tuile t3 = new Tuile(grilleDeJeu, 3, 1, NomTuile.Le_Pont_Des_Abimes);
        Tuile t4 = new Tuile(grilleDeJeu, 4, 1, NomTuile.La_Porte_De_Bronze);
        Tuile t5 = new Tuile(grilleDeJeu, 5, 1);
        Tuile t6 = new Tuile(grilleDeJeu, 6, 1);
        Tuile t7 = new Tuile(grilleDeJeu, 1, 2);
        Tuile t8 = new Tuile(grilleDeJeu, 2, 2, NomTuile.La_Caverne_Des_Ombres);
        Tuile t9 = new Tuile(grilleDeJeu, 3, 2, NomTuile.La_Porte_De_Fer);
        Tuile t10 = new Tuile(grilleDeJeu, 4, 2, NomTuile.La_Porte_d_Or);
        Tuile t11 = new Tuile(grilleDeJeu, 5, 2, NomTuile.Les_Falaises_De_L_Oubli);
        Tuile t12 = new Tuile(grilleDeJeu, 6, 2);
        Tuile t13 = new Tuile(grilleDeJeu, 1, 3, NomTuile.Le_Palais_De_Corail);
        Tuile t14 = new Tuile(grilleDeJeu, 2, 3, NomTuile.La_Porte_d_Argent);
        Tuile t15 = new Tuile(grilleDeJeu, 3, 3, NomTuile.Les_Dunes_De_L_illusion);
        Tuile t16 = new Tuile(grilleDeJeu, 4, 3, NomTuile.Heliport);
        Tuile t17 = new Tuile(grilleDeJeu, 5, 3, NomTuile.La_Porte_De_Cuivre);
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
        
        VueGrilleDemo vueGrille = new VueGrilleDemo(grilleDeJeu);
       // vueGrille.getWindow().setVisible(false);
       // vueJoueur1.getWindow().setVisible(false);
        
        ihm = new IhmPrincipale(vueJoueur1,vueGrille);
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
    

