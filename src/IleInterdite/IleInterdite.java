package IleInterdite;

import Aventuriers.Aventurier;
import Cartes.CarteInondation;
import Cartes.CarteTresors;
import Controle.Controleur;
import Enumerations.NomAventurier;
import Enumerations.NomTresor;
import static Util.Utils.afficherInformation;
import Vues.IhmMenuPrincipal;
import Vues.IhmReglesDuJeu;
import java.util.ArrayList;

public class IleInterdite {

    // attributs
    private static Controleur controleur;

    // main
    public static void main(String[] args) {
        // instantiation des éléments
        // controleur
        controleur = new Controleur();

        // interaction des éléments
        System.out.println(controleur.isDebutPartie());
        controleur.getIhmMenuPrincipal().afficherIhm();

        while (!controleur.isTermine()) {
            System.out.println(" "); // pour que ça fonctionne
            if (controleur.isDebutPartie()) {
                while (!controleur.isTermine()) {
                    // vérifier qu'il n'y a pas plus de 5 cartes dans le tas joueur
                    //      sinon activer défausser (et desactiver le reste)
                    while (controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes().size() > 5) {
                        controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getDefausser().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getTerminer().setEnabled(false);
                    }

                    // actions pions -3 ou 4 actions
                    //      rendre cliquable les boutons se déplacer/assecher/termine son tour/recupérer trésor/donner carte (desactiver le reste)
                    if (controleur.getIhmAventurierActuelle().getCarteAventurier().getNom() == NomAventurier.navigateur) {
                        controleur.setNombreActions(-1);
                    } else {
                        controleur.setNombreActions(0);
                    }

                    while (controleur.getNombreActions() < 3) {
                        controleur.getIhmAventurierActuelle().getAssecher().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getDefausser().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getDonner().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getTerminer().setEnabled(true);
                    }

                    // tirage de 2 cartes trésors (automatiquement)
                    //      activer les boutons utiliser, defausser (desactiver le reste)
                    CarteTresors carte1 = controleur.getTasTresor().getPremiereCarte();
                    CarteTresors carte2 = controleur.getTasTresor().getPremiereCarte();
                    ArrayList<CarteTresors> c = new ArrayList<>();
                    c.add(carte1);
                    c.add(carte2);

                    for (CarteTresors carte : c) {
                        if (carte.getNom() == NomTresor.MonteeDesEaux) {
                            controleur.getAventurier().getTasTirage().add(carte);
                        } else {
                            controleur.getAventurier().getTasJoueur().addCarte(carte);
                        }
                    }

                    while (controleur.getAventurier().getTasTirage().size() != 0) {
                        controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getDefausser().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getTerminer().setEnabled(false);
                    }

                    // tirage des cartes inondations (automatiquement)
                    //      activer utiliser (désactiver le reste)
                    int i = 0;
                    while (i < controleur.getNiveau()) {
                        CarteInondation carteI = controleur.getTasInondation().getPremiereCarte();
                        controleur.getAventurier().getTasTirage().add(carteI);
                    }
                    
                    while (controleur.getAventurier().getTasTirage().size() != 0) {
                        controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getDefausser().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getTerminer().setEnabled(false);
                    }

                    // passage au joueur suivant
                    controleur.getIhmPlateauDeJeu().setIhmAventurierActuelle();
                }
                afficherInformation("Fin de la partie");
            }
        }
    }
}
