/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;
//import de tout les package aventurier, les cartes, la grille les enumerations
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
import Cartes.CarteTresors;
import Controle.Controleur;
import ElementsJeu.Grille;
import ElementsJeu.NiveauEau;
import ElementsJeu.Tresor;
import ElementsJeu.Tuile;
import Enumerations.Couleur;
import Enumerations.EtatTuile;
import Enumerations.NomAventurier;
import Enumerations.NomTresor;
import Enumerations.NomTuile;
import Tas.DefausseInondations;
import Tas.DefausseTresors;
import Tas.TasAventuriers;
import Tas.TasInondations;
import Tas.TasPoubelle;
import Tas.TasTresors;
import java.awt.Color;
import java.util.HashMap;

public class Plateau {

    // attributs
    private Controleur controleur;

    // constructeur
    public Plateau() {
        // création du controleur
        this.controleur = new Controleur();

        //  CREATION DES ELEMENTS
        //      CARTES -----------------------------------------------------------------------------------------------------------------
        //          cartes aventuriers 
        CarteAventurier carteAventurier1 = new CarteAventurier(NomAventurier.explorateur, Couleur.vert);
        CarteAventurier carteAventurier2 = new CarteAventurier(NomAventurier.messager, Couleur.blanc);
        CarteAventurier carteAventurier3 = new CarteAventurier(NomAventurier.pilote, Couleur.bleu);
        CarteAventurier carteAventurier4 = new CarteAventurier(NomAventurier.plongeur, Couleur.noir);
        CarteAventurier carteAventurier5 = new CarteAventurier(NomAventurier.ingenieur, Couleur.rouge);
        CarteAventurier carteAventurier6 = new CarteAventurier(NomAventurier.navigateur, Couleur.jaune);
        //          cartes inondations
        CarteInondation carteInondation1 = new CarteInondation(NomTuile.LePontDesAbimes);
        CarteInondation carteInondation2 = new CarteInondation(NomTuile.LaPorteDeBronze);
        CarteInondation carteInondation3 = new CarteInondation(NomTuile.LaCaverneDesOmbres);
        CarteInondation carteInondation4 = new CarteInondation(NomTuile.LaPorteDeFer);
        CarteInondation carteInondation5 = new CarteInondation(NomTuile.LaPortedOr);
        CarteInondation carteInondation6 = new CarteInondation(NomTuile.LesFalaisesDeLOubli);
        CarteInondation carteInondation7 = new CarteInondation(NomTuile.LePalaisDeCorail);
        CarteInondation carteInondation8 = new CarteInondation(NomTuile.LaPortedArgent);
        CarteInondation carteInondation9 = new CarteInondation(NomTuile.LesDunesDeLillusion);
        CarteInondation carteInondation10 = new CarteInondation(NomTuile.Heliport);
        CarteInondation carteInondation11 = new CarteInondation(NomTuile.LaPorteDeCuivre);
        CarteInondation carteInondation12 = new CarteInondation(NomTuile.LeJardinDesHurlements);
        CarteInondation carteInondation13 = new CarteInondation(NomTuile.LaForetPourpre);
        CarteInondation carteInondation14 = new CarteInondation(NomTuile.LeLagonPerdu);
        CarteInondation carteInondation15 = new CarteInondation(NomTuile.LeMaraisBrumeux);
        CarteInondation carteInondation16 = new CarteInondation(NomTuile.Observatoire);
        CarteInondation carteInondation17 = new CarteInondation(NomTuile.LeRocherFantome);
        CarteInondation carteInondation18 = new CarteInondation(NomTuile.LaCaverneDuBraisier);
        CarteInondation carteInondation19 = new CarteInondation(NomTuile.LeTempleDuSoleil);
        CarteInondation carteInondation20 = new CarteInondation(NomTuile.LeTempleDeLaLune);
        CarteInondation carteInondation21 = new CarteInondation(NomTuile.LePalaisDesMarees);
        CarteInondation carteInondation22 = new CarteInondation(NomTuile.LeValDuCrepuscule);
        CarteInondation carteInondation23 = new CarteInondation(NomTuile.LaTourDuGuet);
        CarteInondation carteInondation24 = new CarteInondation(NomTuile.LeJardinDesMurmures);
        //          cartes trésors
        CarteTresors carteTresor1 = new CarteTresors(NomTresor.Pierre);
        CarteTresors carteTresor2 = new CarteTresors(NomTresor.Pierre);
        CarteTresors carteTresor3 = new CarteTresors(NomTresor.Pierre);
        CarteTresors carteTresor4 = new CarteTresors(NomTresor.Pierre);
        CarteTresors carteTresor5 = new CarteTresors(NomTresor.Pierre);
        CarteTresors carteTresor6 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor7 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor8 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor9 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor10 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor11 = new CarteTresors(NomTresor.Cristal);
        CarteTresors carteTresor12 = new CarteTresors(NomTresor.Cristal);
        CarteTresors carteTresor13 = new CarteTresors(NomTresor.Cristal);
        CarteTresors carteTresor14 = new CarteTresors(NomTresor.Cristal);
        CarteTresors carteTresor15 = new CarteTresors(NomTresor.Cristal);
        CarteTresors carteTresor16 = new CarteTresors(NomTresor.Calice);
        CarteTresors carteTresor17 = new CarteTresors(NomTresor.Calice);
        CarteTresors carteTresor18 = new CarteTresors(NomTresor.Calice);
        CarteTresors carteTresor19 = new CarteTresors(NomTresor.Calice);
        CarteTresors carteTresor20 = new CarteTresors(NomTresor.Calice);
        //          cartes spéciales
        CarteTresors carteSpeciale1 = new CarteTresors(NomTresor.Helicoptere);
        CarteTresors carteSpeciale2 = new CarteTresors(NomTresor.Helicoptere);
        CarteTresors carteSpeciale3 = new CarteTresors(NomTresor.Helicoptere);
        CarteTresors carteSpeciale4 = new CarteTresors(NomTresor.MonteeDesEaux);
        CarteTresors carteSpeciale5 = new CarteTresors(NomTresor.MonteeDesEaux);
        CarteTresors carteSpeciale6 = new CarteTresors(NomTresor.MonteeDesEaux);
        CarteTresors carteSpeciale7 = new CarteTresors(NomTresor.SacsDeSable);
        CarteTresors carteSpeciale8 = new CarteTresors(NomTresor.SacsDeSable);

        //      TAS ---------------------------------------------------------------------------------------------------------------------
        //              poubelle
        TasPoubelle poubelle = new TasPoubelle();
        //              tas aventuriers
        TasAventuriers tasAventurier = new TasAventuriers();
        tasAventurier.addCarte(carteAventurier1);
        tasAventurier.addCarte(carteAventurier2);
        tasAventurier.addCarte(carteAventurier3);
        tasAventurier.addCarte(carteAventurier4);
        tasAventurier.addCarte(carteAventurier5);
        tasAventurier.addCarte(carteAventurier6);
        //              defausse tresors
        DefausseTresors defausseTresor = new DefausseTresors();
        //              tas tresors
        TasTresors tasTresor = new TasTresors();
        tasTresor.addCarte(carteTresor1);
        tasTresor.addCarte(carteTresor2);
        tasTresor.addCarte(carteTresor3);
        tasTresor.addCarte(carteTresor4);
        tasTresor.addCarte(carteTresor5);
        tasTresor.addCarte(carteTresor6);
        tasTresor.addCarte(carteTresor7);
        tasTresor.addCarte(carteTresor8);
        tasTresor.addCarte(carteTresor9);
        tasTresor.addCarte(carteTresor10);
        tasTresor.addCarte(carteTresor11);
        tasTresor.addCarte(carteTresor12);
        tasTresor.addCarte(carteTresor13);
        tasTresor.addCarte(carteTresor14);
        tasTresor.addCarte(carteTresor15);
        tasTresor.addCarte(carteTresor16);
        tasTresor.addCarte(carteTresor17);
        tasTresor.addCarte(carteTresor18);
        tasTresor.addCarte(carteTresor19);
        tasTresor.addCarte(carteTresor20);
        //              defausse inondations
        DefausseInondations defausseInondation = new DefausseInondations();
        //              tas inondations
        TasInondations tasInondation = new TasInondations();
        tasInondation.addCarte(carteInondation1);
        tasInondation.addCarte(carteInondation2);
        tasInondation.addCarte(carteInondation3);
        tasInondation.addCarte(carteInondation4);
        tasInondation.addCarte(carteInondation5);
        tasInondation.addCarte(carteInondation6);
        tasInondation.addCarte(carteInondation7);
        tasInondation.addCarte(carteInondation8);
        tasInondation.addCarte(carteInondation9);
        tasInondation.addCarte(carteInondation10);
        tasInondation.addCarte(carteInondation11);
        tasInondation.addCarte(carteInondation12);
        tasInondation.addCarte(carteInondation13);
        tasInondation.addCarte(carteInondation14);
        tasInondation.addCarte(carteInondation15);
        tasInondation.addCarte(carteInondation16);
        tasInondation.addCarte(carteInondation17);
        tasInondation.addCarte(carteInondation18);
        tasInondation.addCarte(carteInondation19);
        tasInondation.addCarte(carteInondation20);
        tasInondation.addCarte(carteInondation21);
        tasInondation.addCarte(carteInondation22);
        tasInondation.addCarte(carteInondation23);
        tasInondation.addCarte(carteInondation24);

        //      TRESORS --------------------------------------------------------------------------------------------------------------
        Tresor tresor1 = new Tresor(NomTresor.Pierre);
        Tresor tresor2 = new Tresor(NomTresor.Zephyr);
        Tresor tresor3 = new Tresor(NomTresor.Cristal);
        Tresor tresor4 = new Tresor(NomTresor.Calice);

        //      GRILLE + TUILES -------------------------------------------------------------------------------------------------------
        Grille grilleDeJeu = new Grille();

        Tuile t1 = new Tuile(grilleDeJeu, 1, 1);
        Tuile t2 = new Tuile(grilleDeJeu, 2, 1);
        Tuile t3 = new Tuile(grilleDeJeu, 3, 1, NomTuile.LePontDesAbimes);
        Tuile t4 = new Tuile(grilleDeJeu, 4, 1, NomTuile.LaPorteDeBronze, carteAventurier5);
        Tuile t5 = new Tuile(grilleDeJeu, 5, 1);
        Tuile t6 = new Tuile(grilleDeJeu, 6, 1);
        Tuile t7 = new Tuile(grilleDeJeu, 1, 2);
        Tuile t8 = new Tuile(grilleDeJeu, 2, 2, NomTuile.LaCaverneDesOmbres, tresor3);
        Tuile t9 = new Tuile(grilleDeJeu, 3, 2, NomTuile.LaPorteDeFer, carteAventurier4);
        Tuile t10 = new Tuile(grilleDeJeu, 4, 2, NomTuile.LaPortedOr, carteAventurier6);
        Tuile t11 = new Tuile(grilleDeJeu, 5, 2, NomTuile.LesFalaisesDeLOubli);
        Tuile t12 = new Tuile(grilleDeJeu, 6, 2);
        Tuile t13 = new Tuile(grilleDeJeu, 1, 3, NomTuile.LePalaisDeCorail, tresor4);
        Tuile t14 = new Tuile(grilleDeJeu, 2, 3, NomTuile.LaPortedArgent, carteAventurier2);
        Tuile t15 = new Tuile(grilleDeJeu, 3, 3, NomTuile.LesDunesDeLillusion);
        Tuile t16 = new Tuile(grilleDeJeu, 4, 3, NomTuile.Heliport, carteAventurier3);
        Tuile t17 = new Tuile(grilleDeJeu, 5, 3, NomTuile.LaPorteDeCuivre, carteAventurier1);
        Tuile t18 = new Tuile(grilleDeJeu, 6, 3, NomTuile.LeJardinDesHurlements, tresor2);
        Tuile t19 = new Tuile(grilleDeJeu, 1, 4, NomTuile.LaForetPourpre);
        Tuile t20 = new Tuile(grilleDeJeu, 2, 4, NomTuile.LeLagonPerdu);
        Tuile t21 = new Tuile(grilleDeJeu, 3, 4, NomTuile.LeMaraisBrumeux);
        Tuile t22 = new Tuile(grilleDeJeu, 4, 4, NomTuile.Observatoire);
        Tuile t23 = new Tuile(grilleDeJeu, 5, 4, NomTuile.LeRocherFantome);
        Tuile t24 = new Tuile(grilleDeJeu, 6, 4, NomTuile.LaCaverneDuBraisier, tresor3);
        Tuile t25 = new Tuile(grilleDeJeu, 1, 5);
        Tuile t26 = new Tuile(grilleDeJeu, 2, 5, NomTuile.LeTempleDuSoleil, tresor1);
        Tuile t27 = new Tuile(grilleDeJeu, 3, 5, NomTuile.LeTempleDeLaLune, tresor1);
        Tuile t28 = new Tuile(grilleDeJeu, 4, 5, NomTuile.LePalaisDesMarees, tresor4);
        Tuile t29 = new Tuile(grilleDeJeu, 5, 5, NomTuile.LeValDuCrepuscule);
        Tuile t30 = new Tuile(grilleDeJeu, 6, 5);
        Tuile t31 = new Tuile(grilleDeJeu, 1, 6);
        Tuile t32 = new Tuile(grilleDeJeu, 2, 6);
        Tuile t33 = new Tuile(grilleDeJeu, 3, 6, NomTuile.LaTourDuGuet);
        Tuile t34 = new Tuile(grilleDeJeu, 4, 6, NomTuile.LeJardinDesMurmures, tresor2);
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
        
        controleur.initialiserGrille(grilleDeJeu);

        //      NIVEAU D'EAU -------------------------------------------------------------------------------------------------------
        NiveauEau niveauEau = new NiveauEau();

        //      JOUEURS --------------------------------------------------------------------------------------------------------------
        //          création
        Explorateur explorateur = new Explorateur("NomJoueur1", carteAventurier1);
        Messager messager = new Messager("NomJoueur2", carteAventurier2);
        Pilote pilote = new Pilote("NomJoueur3", carteAventurier3);
        Plongeur plongeur = new Plongeur("NomJoueur4", carteAventurier4);
        Ingenieur ingenieur = new Ingenieur("NomJoueur5", carteAventurier5);
        Navigateur navigateur = new Navigateur("NomJoueur6", carteAventurier6);

        //         ajout dans le hashmap
        HashMap<String, Aventurier> joueurs = new HashMap<>();
        controleur.setAventuriers(joueurs);

        controleur.getAventuriers().put(explorateur.getNomJoueur(), explorateur);
        controleur.getAventuriers().put(messager.getNomJoueur(), messager);
        controleur.getAventuriers().put(pilote.getNomJoueur(), pilote);
        controleur.getAventuriers().put(plongeur.getNomJoueur(), plongeur);
        controleur.getAventuriers().put(ingenieur.getNomJoueur(), ingenieur);
        controleur.getAventuriers().put(navigateur.getNomJoueur(), navigateur);

        //          emplacement des joueurs
        t17.addAventurier(explorateur);
        t14.addAventurier(messager);
        t16.addAventurier(pilote);
        t4.addAventurier(ingenieur);
        t9.addAventurier(plongeur);
        t10.addAventurier(navigateur);

        //  VUES
        //      VUEAVENTURIER (une par joueur) - création
        VueAventurierDemo joueur1 = new VueAventurierDemo(explorateur.getNomJoueur(), carteAventurier1, Color.green);
        VueAventurierDemo joueur2 = new VueAventurierDemo(messager.getNomJoueur(), carteAventurier2, Color.white);
        VueAventurierDemo joueur3 = new VueAventurierDemo(pilote.getNomJoueur(), carteAventurier3, Color.blue);
        VueAventurierDemo joueur4 = new VueAventurierDemo(plongeur.getNomJoueur(), carteAventurier4, Color.black);
        VueAventurierDemo joueur5 = new VueAventurierDemo(ingenieur.getNomJoueur(), carteAventurier5, Color.red);
        VueAventurierDemo joueur6 = new VueAventurierDemo(navigateur.getNomJoueur(), carteAventurier6, Color.yellow);

        //      VUEAVENTURIER - ajout dans l'arrayList vuesAventurier du controleur
        controleur.getVuesAventurier().put(joueur1.getNomJoueur(), joueur1);
        controleur.getVuesAventurier().put(joueur2.getNomJoueur(), joueur2);
        controleur.getVuesAventurier().put(joueur3.getNomJoueur(), joueur3);
        controleur.getVuesAventurier().put(joueur4.getNomJoueur(), joueur4);
        controleur.getVuesAventurier().put(joueur5.getNomJoueur(), joueur5);
        controleur.getVuesAventurier().put(joueur6.getNomJoueur(), joueur6);

        //      VUEAVENTURIER- ajout du controleur en tant qu'observateur
        joueur1.addObservateur(controleur);
        joueur2.addObservateur(controleur);
        joueur3.addObservateur(controleur);
        joueur4.addObservateur(controleur);
        joueur5.addObservateur(controleur);
        joueur6.addObservateur(controleur);

        //      VUEGRILLE - création
        VueGrilleDemo vueGrille = new VueGrilleDemo(grilleDeJeu);

        //      VUEGRILLE - ajout du controleur en tant qu'observateur
        vueGrille.addObservateur(controleur);
        
        controleur.afficherVueGrille(vueGrille);
        

// ----------------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------------------
    }

    // setteurs
    // getteurs
    //renvoie le controleur
    public Controleur getControleur() {
        return controleur;
    }

    public static void main(String[] args) {
    }
}
