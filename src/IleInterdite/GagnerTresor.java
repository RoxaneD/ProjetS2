package IleInterdite;

import Aventuriers.Aventurier;
import Aventuriers.Explorateur;
import Aventuriers.Messager;
import Cartes.CarteAventurier;
import Cartes.CarteInondation;
import Cartes.CarteTresors;
import Controle.Action;
import Controle.Controleur;
import Controle.TypesActions;
import ElementsJeu.Grille;
import ElementsJeu.NiveauEau;
import ElementsJeu.Tuile;
import Enumerations.Couleur;
import Enumerations.EtatTuile;
import Enumerations.NomAventurier;
import Enumerations.NomTresor;
import static Util.Utils.afficherInformation;
import Vues.IhmAventurier;
import Vues.IhmPlateauDeJeu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GagnerTresor {

    // attributs
    private static Controleur controleur;
    private static Grille grille;
    private static NiveauEau niveauEau;

    // main
    public static void main(String[] args) {
        // instantiation des éléments
        // controleur
        controleur = new Controleur();
        grille = new Grille();
        niveauEau = new NiveauEau();

        CarteAventurier carteAventurier1 = new CarteAventurier(NomAventurier.explorateur, Couleur.vert);
        CarteAventurier carteAventurier2 = new CarteAventurier(NomAventurier.messager, Couleur.blanc);
        
        Explorateur av1 = new Explorateur("Marie",carteAventurier1);
        Messager av2 = new Messager("Pierre",carteAventurier2);
        
        CarteTresors carteTresor1 = new CarteTresors(NomTresor.Pierre);
        
        av1.getTasJoueur().addCarte(carteTresor1);
        av1.getTasJoueur().addCarte(carteTresor1);
        av1.getTasJoueur().addCarte(carteTresor1);
        av1.getTasJoueur().addCarte(carteTresor1);
        
        av1.addTuile(grille.getTuile(5, 2));
        
        HashMap<String, Aventurier> aventuriers = new HashMap<>();
        aventuriers.put("Marie",av1);
        aventuriers.put("Pierre",av2);
        
        IhmPlateauDeJeu ihmPlateauDeJeu = new IhmPlateauDeJeu(aventuriers, grille, niveauEau);
            ihmPlateauDeJeu.getIhmGrille().addObservateur(controleur);
            for (IhmAventurier ihm : ihmPlateauDeJeu.getIhmAventuriers()) {
                ihm.addObservateur(controleur);
            }
        
        ihmPlateauDeJeu.afficherIhm();

        while (!controleur.isTermine()) {
            System.out.print(" "); // pour que ça fonctionne
            if (controleur.isDebutPartie()) {
                while (!controleur.isTermine()) {
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
                    // passage au joueur suivant
                    controleur.getIhmPlateauDeJeu().setIhmAventurierActuelle();
                }
                afficherInformation("Fin de la partie");
            }
        }
    }
}
