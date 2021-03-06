package IleInterdite;

import Aventuriers.Aventurier;
import Cartes.CarteInondation;
import Cartes.CarteTresors;
import Controle.Action;
import Controle.Controleur;
import Controle.TypesActions;
import ElementsJeu.Tresor;
import ElementsJeu.Tuile;
import Enumerations.EtatTresor;
import Enumerations.EtatTuile;
import Enumerations.NomAventurier;
import Enumerations.NomTresor;
import static Util.Utils.afficherInformation;
import Vues.IhmAventurier;
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
            System.out.print(" "); // pour que ça fonctionne
            if (controleur.isDebutPartie()) {

                // -------------------------------------------------------------------------------------------------------------------------------------------
                // on donne deux cartes par joueurs (exceptés le cartes montées des eaux) <- En tant normal, pour la démonstration on utilise ce qu'il y a en dessous
                for (IhmAventurier ia
                        : controleur.getIhmPlateauDeJeu().getIhmAventuriers()) {
                    CarteTresors carte1
                            = controleur.getTasTresor().getPremiereCarte();
                    CarteTresors carte2 = controleur.getTasTresor().getPremiereCarte();
                    while (carte1.getNom() == NomTresor.MonteeDesEaux) {
                        controleur.getTasTresor().addCarte(carte1);
                        Collections.shuffle(controleur.getTasTresor().getCartesTresors());
                        carte1 = controleur.getTasTresor().getPremiereCarte();
                    }
                    while (carte2.getNom() == NomTresor.MonteeDesEaux) {
                        controleur.getTasTresor().addCarte(carte2);
                        Collections.shuffle(controleur.getTasTresor().getCartesTresors());
                        carte2 = controleur.getTasTresor().getPremiereCarte();
                    }
                    ia.getAventurier().getTasJoueur().addCarte(carte1);
                    ia.getAventurier().getTasJoueur().addCarte(carte2);
                }

                // pour la démo ! Remplace ce qu'il y a au dessus -----(récupérer des trésors + gagner)----------------------------------------------------------------------------------------
                /**
                 * for (IhmAventurier ia :
                 * controleur.getIhmPlateauDeJeu().getIhmAventuriers()) {
                 * CarteTresors carte1 = null; CarteTresors carte2 = null;
                 * CarteTresors carte3 = null; CarteTresors carte4 = null; if
                 * (ia.getAventurier().getCarteAventurier().getNom() ==
                 * NomAventurier.explorateur) { for (CarteTresors c :
                 * controleur.getTasTresor().getCartesTresors()) { if (carte1 ==
                 * null && c.getNom() == NomTresor.Calice) { carte1 = c; } else
                 * if (carte2 == null && c.getNom() == NomTresor.Calice) {
                 * carte2 = c; } else if (carte3 == null && c.getNom() ==
                 * NomTresor.Calice) { carte3 = c; } else if (carte4 == null &&
                 * c.getNom() == NomTresor.Calice) { carte4 = c; } } } else if
                 * (ia.getAventurier().getCarteAventurier().getNom() ==
                 * NomAventurier.messager) { for (CarteTresors c :
                 * controleur.getTasTresor().getCartesTresors()) { if (carte1 ==
                 * null && c.getNom() == NomTresor.Pierre) { carte1 = c; } else
                 * if (carte2 == null && c.getNom() == NomTresor.Pierre) {
                 * carte2 = c; } else if (carte3 == null && c.getNom() ==
                 * NomTresor.Pierre) { carte3 = c; } else if (carte4 == null &&
                 * c.getNom() == NomTresor.Pierre) { carte4 = c; } } } else if
                 * (ia.getAventurier().getCarteAventurier().getNom() ==
                 * NomAventurier.navigateur) { for (CarteTresors c :
                 * controleur.getTasTresor().getCartesTresors()) { if (carte1 ==
                 * null && c.getNom() == NomTresor.Zephyr) { carte1 = c; } else
                 * if (carte2 == null && c.getNom() == NomTresor.Zephyr) {
                 * carte2 = c; } else if (carte3 == null && c.getNom() ==
                 * NomTresor.Zephyr) { carte3 = c; } else if (carte4 == null &&
                 * c.getNom() == NomTresor.Zephyr) { carte4 = c; } } } else if
                 * (ia.getAventurier().getCarteAventurier().getNom() ==
                 * NomAventurier.plongeur) { for (CarteTresors c :
                 * controleur.getTasTresor().getCartesTresors()) { if (carte1 ==
                 * null && c.getNom() == NomTresor.Cristal) { carte1 = c; } else
                 * if (carte2 == null && c.getNom() == NomTresor.Cristal) {
                 * carte2 = c; } else if (carte3 == null && c.getNom() ==
                 * NomTresor.Cristal) { carte3 = c; } else if (carte4 == null &&
                 * c.getNom() == NomTresor.Cristal) { carte4 = c; } } } else if
                 * (ia.getAventurier().getCarteAventurier().getNom() ==
                 * NomAventurier.pilote) { for (CarteTresors c :
                 * controleur.getTasTresor().getCartesTresors()) { if (carte1 ==
                 * null && c.getNom() == NomTresor.Calice) { carte1 = c; } else
                 * if (carte2 == null && c.getNom() == NomTresor.Calice) {
                 * carte2 = c; } else if (carte3 == null && c.getNom() ==
                 * NomTresor.Calice) { carte3 = c; } else if (carte4 == null &&
                 * c.getNom() == NomTresor.Calice) { carte4 = c; } } } else {
                 * for (CarteTresors c :
                 * controleur.getTasTresor().getCartesTresors()) { if (carte1 ==
                 * null && c.getNom() == NomTresor.Calice) { carte1 = c; } else
                 * if (carte2 == null && c.getNom() == NomTresor.Calice) {
                 * carte2 = c; } else if (carte3 == null && c.getNom() ==
                 * NomTresor.Calice) { carte3 = c; } else if (carte4 == null &&
                 * c.getNom() == NomTresor.Calice) { carte4 = c; } } }
                 * ia.getAventurier().getTasJoueur().addCarte(carte1);
                 * ia.getAventurier().getTasJoueur().addCarte(carte2);
                 * ia.getAventurier().getTasJoueur().addCarte(carte3);
                 * ia.getAventurier().getTasJoueur().addCarte(carte4); }
                *
                 */
                // -------------------------------------------------------------------------------------------------------------------------------------------
                // on utilise les 6 premières cartes inondations qu'on place dans la défausse
                CarteInondation ci1;
                int i = 0;
                while (i < 6) {
                    ci1 = controleur.getTasInondation().getPremiereCarte();
                    controleur.getIhmAventurierActuelle().getAventurier().getTasTirage().add(ci1);
                    Action a = new Action(TypesActions.utiliserCarte, ci1);
                    controleur.traiterAction(a);
                    i += 1;
                }

                // tour de jeu
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
                    if (controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes().size() == 0) {
                        controleur.getIhmAventurierActuelle().getDefausser().setEnabled(false);
                        controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                    } else {
                        controleur.getIhmAventurierActuelle().getDefausser().setEnabled(true);
                        controleur.getIhmAventurierActuelle().getDonner().setEnabled(true);
                    }
                    while (controleur.getNombreActions() < 3) {
                        System.out.print(" "); // sinon ça ne fonctionne pas
                        if (controleur.getIhmAventurierActuelle().getAventurier().getTuile() != null) {
                            if (controleur.getIhmAventurierActuelle().getAventurier().getTuile().getEmplacementTresor() != null) {
                                for (Tresor t : controleur.getIhmPlateauDeJeu().getIhmGrille().getTresors()) {
                                    if (t.getNom() == controleur.getIhmAventurierActuelle().getAventurier().getTuile().getEmplacementTresor().getNom()) {
                                        if (t.getEtat() != EtatTresor.recupere) {
                                            NomTresor n = controleur.getIhmAventurierActuelle().getAventurier().getTuile().getEmplacementTresor().getNom();
                                            ArrayList<CarteTresors> carteAExaminer = new ArrayList<>();
                                            for (CarteTresors ct : controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes()) {
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
                            }
                        }
                    }

                    controleur.setNombreActions(0);

                    controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getTerminer().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getDefausser().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                    for (CarteTresors ct : controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes()) {
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

                    if (!controleur.isTermine()) {
                        while (controleur.getIhmAventurierActuelle().getAventurier().getTasTirage().size() != 0) {
                            System.out.print(" "); // sinon ne marche pas
                            controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getDefausser().setEnabled(true);
                            controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(true);
                            controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getTerminer().setEnabled(false);
                        }
                    }

                    controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getTerminer().setEnabled(true);
                    controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getDefausser().setEnabled(false);
                    controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                    for (CarteTresors ct : controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes()) {
                        if (ct.getNom() == NomTresor.Helicoptere || ct.getNom() == NomTresor.SacsDeSable) {
                            controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(true);
                        } else {
                            controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(false);
                        }
                    }

                    // tirage des cartes inondations (automatiquement)
                    //      activer utiliser (désactiver le reste)
                    if (!controleur.isTermine()) {
                        i = 0;
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
                    }
                    controleur.getIhmPlateauDeJeu().mettreAJour();

                    if (!controleur.isTermine()) {
                        while (controleur.getIhmAventurierActuelle().getAventurier().getTasTirage().size() != 0) {
                            System.out.print(" ");
                            controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getDefausser().setEnabled(true);
                            controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(true);
                            controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getTerminer().setEnabled(false);
                        }
                    }

                    ArrayList<CarteTresors> car = new ArrayList<>();
                    if (controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes().size() != 0) {
                        car = new ArrayList<CarteTresors>();
                        for (CarteTresors ca : controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes()) {
                            if (ca.getNom() == NomTresor.Helicoptere || ca.getNom() == NomTresor.SacsDeSable) {
                                car.add(ca);
                            }
                        }
                    }

                    if (!controleur.isTermine()) {
                        while (controleur.getNombreActions() != 3 && car.size() != 0) {
                            System.out.print(" ");
                            controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getDefausser().setEnabled(true);
                            controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(true);
                            controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getTerminer().setEnabled(true);
                            if (controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes().size() != 0) {
                                car = new ArrayList<CarteTresors>();
                                for (CarteTresors ca : controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes()) {
                                    if (ca.getNom() == NomTresor.Helicoptere || ca.getNom() == NomTresor.SacsDeSable) {
                                        car.add(ca);
                                    }
                                }
                            }
                        }
                    }

                    if (!controleur.isTermine()) {
                        while (controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes().size() > 5) {
                            System.out.print(" ");
                            controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getDefausser().setEnabled(true);
                            controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(true);
                            controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getTerminer().setEnabled(false);
                            if (controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes().size() != 0) {
                                car = new ArrayList<CarteTresors>();
                                for (CarteTresors ca : controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes()) {
                                    if (ca.getNom() == NomTresor.Helicoptere || ca.getNom() == NomTresor.SacsDeSable) {
                                        car.add(ca);
                                    }
                                }
                            }
                        }
                    }

                    if (!controleur.isTermine()) {
                        while (controleur.getNombreActions() != 3 && controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes().size() != 0) {
                            System.out.print(" ");
                            controleur.getIhmAventurierActuelle().getAssecher().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getDefausser().setEnabled(true);
                            controleur.getIhmAventurierActuelle().getUtiliser().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getDeplacer().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getDonner().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getRecupererTresor().setEnabled(false);
                            controleur.getIhmAventurierActuelle().getTerminer().setEnabled(true);
                            if (controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes().size() != 0) {
                                car = new ArrayList<CarteTresors>();
                                for (CarteTresors ca : controleur.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes()) {
                                    if (ca.getNom() == NomTresor.Helicoptere || ca.getNom() == NomTresor.SacsDeSable) {
                                        car.add(ca);
                                    }
                                }
                            }
                        }
                    }
                    // passage au joueur suivant
                    if (!controleur.isTermine()) {
                        controleur.getIhmPlateauDeJeu().setIhmAventurierActuelle();
                    }
                }
            }
        }

    }
}
