// petit test qui permet de voir à peu près comment fonctionne le controleur avec les vues
package Controle;

import Aventuriers.Messager;
import ElementsJeu.NiveauEau;
import static Util.Utils.afficherInformation;
import static Util.Utils.poserQuestion;
import Vues.VueAventurier;
import java.awt.Color;

public class Test {

    public static void main(String[] args) {
        // création du controleur
        Controleur controleur1 = new Controleur();
        
        // création des éléments
        VueAventurier vueAventurier1 = new VueAventurier("Roxane", "Messager", Color.BLACK);
        
        // ajout du controleur en tant qu'observateur de ces élements
        vueAventurier1.addObservateur(controleur1);
        
        // ajouts des éléments au controleur
        controleur1.setVueAventurier(vueAventurier1);
        
        // test Utils.poserQuestion("...") et Utils.afficherInformation("..")
        //if (poserQuestion("Ceci est une question")) {
        //    afficherInformation("Ceci est une information");
        //}

    }

}
