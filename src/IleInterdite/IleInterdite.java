package IleInterdite;

import Controle.Controleur;
import Vues.IhmMenuPrincipal;
import Vues.IhmReglesDuJeu;

public class IleInterdite {
    
    // attributs
    private static Controleur controleur;
    
    // main
    public static void main(String[] args) {
        // instantiation des éléments
            // controleur
        controleur = new Controleur();
        
        // interaction des éléments
        controleur.getIhmMenuPrincipal().afficherIhm();
    }
}
