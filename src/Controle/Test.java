//
package Controle;

import Aventuriers.Messager;
import static Util.Utils.afficherInformation;
import static Util.Utils.poserQuestion;
import Vues.VueAventurier;
import java.awt.Color;

public class Test {

    public static void main(String[] args) {
        Controleur controleur1 = new Controleur();
        VueAventurier vueAventurier1 = new VueAventurier("Roxane", "Messager", Color.BLACK);
        vueAventurier1.addObservateur(controleur1);
        controleur1.setVueAventurier(vueAventurier1);
        if (poserQuestion("Ceci est une question")) {
            afficherInformation("Ceci est une information");
        }

    }

}
