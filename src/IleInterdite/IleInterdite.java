package IleInterdite;

import Aventuriers.Aventurier;
import Controle.Controleur;
import static Util.Utils.afficherInformation;
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

        while (!controleur.isTermine()) {
            System.out.println("a");
            System.out.println(controleur.getIhmMenuPrincipal().isVisible());
            if (controleur.getIhmMenuPrincipal().isVisible() == false) {

                while (!controleur.isTermine()) {
                    // mettre ihmAventurierActuel sur a
                    System.out.println("b");
                    controleur.getIhmPlateauDeJeu().setIhmAventurierActuelle();
                    System.out.println(controleur.getIhmAventurierActuelle().getCarteAventurier().getNom());
                    // vérifier qu'il n'y a pas plus de 5 cartes dans le tas joueur
                    //      sinon activer défausser (et desactiver le reste)

                    // actions pions -3 ou 4 actions
                    //      rendre cliquable les boutons se déplacer/assecher/termine son tour/recupérer trésor/donner carte (desactiver le reste)
                    // tirage de 2 cartes trésors (automatiquement)
                    //      activer les boutons utiliser, defausser (desactiver le reste)
                    // tirage des cartes inondations (automatiquement)
                    //      activer utiliser (désactiver le reste)
                }
                afficherInformation("Fin de la partie");
            }
        }
    }
}
