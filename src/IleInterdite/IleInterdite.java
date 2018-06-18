package IleInterdite;

import Controle.Controleur;
import Vues.IHM_Menu;
import Vues.IHM_intro;

public class IleInterdite {
    
    // attributs
    private static Controleur controleur;
    private static IHM_intro ihmIntro;
    
    public static void main(String[] args) {
        controleur = new Controleur();
        IHM_Menu menu = new IHM_Menu();
        menu.addObservateur(controleur);
        ihmIntro = new IHM_intro(menu);
        
        ihmIntro.afficherIhm();
    }
}
