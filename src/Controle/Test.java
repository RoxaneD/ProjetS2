// petit test qui permet de voir à peu près comment fonctionne le controleur avec les vues
package Controle;

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
import Enumerations.Couleur;
import Enumerations.NomAventurier;
import Enumerations.NomCarteSpeciale;
import Enumerations.NomTresor;
import Enumerations.NomTuile;
import Vues.VueAventurier;
import java.awt.Color;

public class Test {

    public static void main(String[] args) {
        // création du controleur
        Controleur controleur = new Controleur();

        // création des éléments
        //      CARTES
        //          cartes aventuriers 
        CarteAventurier carteAventurier1 = new CarteAventurier(NomAventurier.explorateur, Couleur.vert);
        CarteAventurier carteAventurier2 = new CarteAventurier(NomAventurier.messager, Couleur.blanc);
        CarteAventurier carteAventurier3 = new CarteAventurier(NomAventurier.pilote, Couleur.bleu);
        CarteAventurier carteAventurier4 = new CarteAventurier( NomAventurier.plongeur, Couleur.noir);
        CarteAventurier carteAventurier5 = new CarteAventurier(NomAventurier.ingenieur, Couleur.rouge);
        CarteAventurier carteAventurier6 = new CarteAventurier(NomAventurier.navigateur, Couleur.jaune);
        //          cartes inondations
        CarteInondation carteInondation1= new CarteInondation(NomTuile.Le_Pont_Des_Abimes);
        CarteInondation carteInondation2= new CarteInondation(NomTuile.La_Porte_De_Bronze);
        CarteInondation carteInondation3= new CarteInondation(NomTuile.La_Caverne_Des_Ombres);
        CarteInondation carteInondation4= new CarteInondation(NomTuile.La_Porte_De_Fer);
        CarteInondation carteInondation5= new CarteInondation(NomTuile.La_Porte_d_Or);
        CarteInondation carteInondation6= new CarteInondation(NomTuile.Les_Falaises_De_L_Oubli);
        CarteInondation carteInondation7= new CarteInondation(NomTuile.Le_Palais_De_Corail);
        CarteInondation carteInondation8= new CarteInondation(NomTuile.La_Porte_d_Argent);
        CarteInondation carteInondation9= new CarteInondation(NomTuile.Les_Dunes_De_L_illusion);
        CarteInondation carteInondation10= new CarteInondation(NomTuile.Heliport);
        CarteInondation carteInondation11= new CarteInondation(NomTuile.La_Porte_De_Cuivre);
        CarteInondation carteInondation12= new CarteInondation(NomTuile.Le_Jardin_Des_Hurlements);
        CarteInondation carteInondation13= new CarteInondation(NomTuile.La_Foret_Pourpre);
        CarteInondation carteInondation14= new CarteInondation(NomTuile.Le_Lagon_Perdu);
        CarteInondation carteInondation15= new CarteInondation(NomTuile.Le_Marais_Brumeux);
        CarteInondation carteInondation16= new CarteInondation(NomTuile.Observatoire);
        CarteInondation carteInondation17= new CarteInondation(NomTuile.Le_Rocher_Fantome);
        CarteInondation carteInondation18= new CarteInondation(NomTuile.La_Caverne_Du_Braisier);
        CarteInondation carteInondation19= new CarteInondation(NomTuile.Le_Temple_Du_Soleil);
        CarteInondation carteInondation20= new CarteInondation(NomTuile.Le_Temple_De_La_Lune);
        CarteInondation carteInondation21= new CarteInondation(NomTuile.Le_Palais_Des_Marees);
        CarteInondation carteInondation22= new CarteInondation(NomTuile.Le_Val_Du_Crepuscule);
        CarteInondation carteInondatio23= new CarteInondation(NomTuile.La_Tour_Du_Guet);
        CarteInondation carteInondation24= new CarteInondation(NomTuile.Le_Jardin_Des_Murmures);
        //          cartes trésors
        CarteTresor carteTresor1 = new CarteTresor(NomTresor.La_Pierre_sacree);
        CarteTresor carteTresor2 = new CarteTresor(NomTresor.La_Pierre_sacree);
        CarteTresor carteTresor3 = new CarteTresor(NomTresor.La_Pierre_sacree);
        CarteTresor carteTresor4 = new CarteTresor(NomTresor.La_Pierre_sacree);
        CarteTresor carteTresor5 = new CarteTresor(NomTresor.La_Pierre_sacree);
        CarteTresor carteTresor6 = new CarteTresor(NomTresor.La_Statue_du_zephyr);
        CarteTresor carteTresor7 = new CarteTresor(NomTresor.La_Statue_du_zephyr);
        CarteTresor carteTresor8 = new CarteTresor(NomTresor.La_Statue_du_zephyr);
        CarteTresor carteTresor9 = new CarteTresor(NomTresor.La_Statue_du_zephyr);
        CarteTresor carteTresor10 = new CarteTresor(NomTresor.La_Statue_du_zephyr);
        CarteTresor carteTresor11 = new CarteTresor(NomTresor.Le_Cristal_ardent);
        CarteTresor carteTresor12 = new CarteTresor(NomTresor.Le_Cristal_ardent);
        CarteTresor carteTresor13 = new CarteTresor(NomTresor.Le_Cristal_ardent);
        CarteTresor carteTresor14 = new CarteTresor(NomTresor.Le_Cristal_ardent);
        CarteTresor carteTresor15 = new CarteTresor(NomTresor.Le_Cristal_ardent);
        CarteTresor carteTresor16 = new CarteTresor(NomTresor.Le_Calice_de_l_onde);
        CarteTresor carteTresor17 = new CarteTresor(NomTresor.Le_Calice_de_l_onde);
        CarteTresor carteTresor18 = new CarteTresor(NomTresor.Le_Calice_de_l_onde);
        CarteTresor carteTresor19 = new CarteTresor(NomTresor.Le_Calice_de_l_onde);
        CarteTresor carteTresor20 = new CarteTresor(NomTresor.Le_Calice_de_l_onde);
        //          cartes spéciales
        CarteSpeciale carteSpeciale1 = new CarteSpeciale(NomCarteSpeciale.helico);
        CarteSpeciale carteSpeciale2 = new CarteSpeciale(NomCarteSpeciale.helico);
        CarteSpeciale carteSpeciale3 = new CarteSpeciale(NomCarteSpeciale.helico);
        CarteSpeciale carteSpeciale4 = new CarteSpeciale(NomCarteSpeciale.monteeEau);
        CarteSpeciale carteSpeciale5 = new CarteSpeciale(NomCarteSpeciale.monteeEau);
        CarteSpeciale carteSpeciale6 = new CarteSpeciale(NomCarteSpeciale.monteeEau);
        CarteSpeciale carteSpeciale7 = new CarteSpeciale(NomCarteSpeciale.sacSable);
        CarteSpeciale carteSpeciale8 = new CarteSpeciale(NomCarteSpeciale.sacSable);
        
        // joueurs
        Explorateur explorateur = new Explorateur("Explorateur", carteAventurier1);
        Messager messager = new Messager("Messager", carteAventurier2);
        Pilote pilote = new Pilote("Pilote", carteAventurier3);
        Plongeur plongeur = new Plongeur("Plongeur", carteAventurier4);
        Ingenieur ingenieur = new Ingenieur("Ingenieur", carteAventurier5);
        Navigateur navigateur = new Navigateur("Navigateur", carteAventurier6);

        // vueAventurier (une par joueur)
        VueAventurier joueur1 = new VueAventurier("Roxane", "Messager", Color.BLACK);
        VueAventurier joueur2 = new VueAventurier("Roxane", "Messager", Color.BLACK);
        VueAventurier joueur3 = new VueAventurier("Roxane", "Messager", Color.BLACK);
        VueAventurier joueur4 = new VueAventurier("Roxane", "Messager", Color.BLACK);
        VueAventurier joueur5 = new VueAventurier("Roxane", "Messager", Color.BLACK);
        VueAventurier joueur6 = new VueAventurier("Roxane", "Messager", Color.BLACK);

        // ajout du controleur en tant qu'observateur de ces élements
        joueur1.addObservateur(controleur);
        joueur2.addObservateur(controleur);
        joueur3.addObservateur(controleur);
        joueur4.addObservateur(controleur);
        joueur5.addObservateur(controleur);
        joueur6.addObservateur(controleur);

        // test Utils.poserQuestion("...") et Utils.afficherInformation("..")
        //if (poserQuestion("Ceci est une question")) {
        //    afficherInformation("Ceci est une information");
        //}
    }

}
