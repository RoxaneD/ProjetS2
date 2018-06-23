package IleInterdite;

import Cartes.CarteInondation;
import Cartes.CarteTresors;
import Controle.Controleur;
import ElementsJeu.Tuile;
import Enumerations.EtatTuile;
import Enumerations.NomAventurier;
import Enumerations.NomTresor;
import static Util.Utils.afficherInformation;
import java.util.ArrayList;
import java.util.Collections;

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

                    controleur.getIhmAventurierActuelle().getAssecher().setEnabled(true);
                    controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(true);
                    controleur.getIhmAventurierActuelle().getTerminer().setEnabled(true);
                    controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(false);
                    if (controleur.getAventurier().getTasJoueur().getCartes().size() == 0) {
                        controleur.getIhmAventurierActuelle().getDefausser().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                    } else {
                        controleur.getIhmAventurierActuelle().getDefausser().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getDonner().setEnabled(true);
                    }

                    while (controleur.getNombreActions() < 3) {
                        System.out.println(" "); // sinon ça ne fonctionne pas
                        if (controleur.getIhmAventurierActuelle().getAventurier().getTuile() != null) {
                            if (controleur.getIhmAventurierActuelle().getAventurier().getTuile().getEmplacementTresor() != null) {
                                NomTresor n = controleur.getAventurier().getTuile().getEmplacementTresor().getNom();
                                ArrayList<CarteTresors> carteAExaminer = new ArrayList<>();
                                for (CarteTresors ct : controleur.getAventurier().getTasJoueur().getCartes()) {
                                    if (ct.getNom() == n) {
                                        carteAExaminer.add(ct);
                                    }
                                }
                                if (carteAExaminer.size() > 3) {
                                    controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(true);
                                }
                            }
                        }
                    }

                    controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getTerminer().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getDefausser().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                    for (CarteTresors ct : controleur.getAventurier().getTasJoueur().getCartes()) {
                        if (ct.getNom() == NomTresor.Helicoptere || ct.getNom() == NomTresor.SacsDeSable) {
                            controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(true);
                        } else {
                            controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(false);
                        }
                    }

                    // tirage de 2 cartes trésors (automatiquement)
                    //      activer les boutons utiliser, defausser (desactiver le reste)
                    // on remet la défausse dans le tas si le tas est vide
                    if (controleur.getTasTresor().getCartesTresors().size() == 0) {
                        Collections.shuffle(controleur.getDefausseTresor().getCartesTresors());
                        for (CarteTresors ci : controleur.getDefausseTresor().getCartesTresors()) {
                            controleur.getTasTresor().addCarte(ci);
                        }
                    }
                    CarteTresors carte1 = controleur.getTasTresor().getPremiereCarte();

                    // on remet la défausse dans le tas si le tas est vide
                    if (controleur.getTasTresor().getCartesTresors().size() == 0) {
                        Collections.shuffle(controleur.getDefausseTresor().getCartesTresors());
                        for (CarteTresors ci : controleur.getDefausseTresor().getCartesTresors()) {
                            controleur.getTasTresor().addCarte(ci);
                        }
                    }
                    CarteTresors carte2 = controleur.getTasTresor().getPremiereCarte();

                    ArrayList<CarteTresors> c = new ArrayList<>();
                    c.add(carte1);
                    c.add(carte2);

                    for (CarteTresors carte : c) {
                        if (carte.getNom() == NomTresor.MonteeDesEaux) {
                            controleur.getIhmAventurierActuelle().getAventurier().getTasTirage().add(carte);
                        } else {
                            controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().addCarte(carte);
                        }
                    }

                    controleur.getIhmPlateauDeJeu().mettreAJour();

                    while (controleur.getAventurier().getTasTirage().size() != 0) {
                        controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getDefausser().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getTerminer().setEnabled(false);
                    }

                    controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getTerminer().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getDefausser().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                    for (CarteTresors ct : controleur.getAventurier().getTasJoueur().getCartes()) {
                        if (ct.getNom() == NomTresor.Helicoptere || ct.getNom() == NomTresor.SacsDeSable) {
                            controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(true);
                        } else {
                            controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(false);
                        }
                    }

                    // tirage des cartes inondations (automatiquement)
                    //      activer utiliser (désactiver le reste)
                    int i = 0;
                    while (i < controleur.getNiveau()) {
                        if (controleur.getTasInondation().getCartesInondations().size() == 0) {
                            Collections.shuffle(controleur.getDefausseInondation().getCartesInondation());
                            for (CarteInondation ci : controleur.getDefausseInondation().getCartesInondation()) {
                                controleur.getTasInondation().addCarte(ci);
                            }
                        }
                        CarteInondation carteI = controleur.getTasInondation().getPremiereCarte();
                        controleur.getIhmAventurierActuelle().getAventurier().getTasTirage().add(carteI);
                        i += 1;
                    }

                    controleur.getIhmPlateauDeJeu().mettreAJour();

                    while (controleur.getIhmAventurierActuelle().getAventurier().getTasTirage().size() != 0) {
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
