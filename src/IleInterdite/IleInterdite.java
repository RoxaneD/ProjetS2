package IleInterdite;

import Controle.Controleur;
import Vues.IHM_Menu;
import Vues.IHM_intro;

public class IleInterdite {
    
    // attributs
    private static Controleur controleur = new Controleur();
    private static IHM_Menu ihmMenu = new IHM_Menu();
    private static IHM_intro ihmIntro = new IHM_intro(ihmMenu);
    
    public static void main(String[] args) {
        ihmMenu.addObservateur(controleur);
        ihmMenu.afficherIhm();
        
        
    }
}
