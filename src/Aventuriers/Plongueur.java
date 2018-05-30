package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Plongueur extends Aventurier {

    // constructeurs
    Plongueur(String nomJoueur, CarteAventurier carteaventurier) {
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }

    // autres
    @Override
    public ArrayList<Tuile> calculDeplacementPos() {
        Tuile tuileActuelle = getTuile();
        int posXactuelle = tuileActuelle.getPosX();
        int posYactuelle = tuileActuelle.getPosY();
        ArrayList<Tuile> tuilesNormal = new ArrayList<>();
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();
        
        for (Tuile t : tuileActuelle.getGrille().getTuiles()){
            // à faire - Roxaneee
        }
        
        return tuilesPossible;
    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {
        Tuile tuileActuelle = getTuile();
        int posXactuelle = tuileActuelle.getPosX();
        int posYactuelle = tuileActuelle.getPosY();
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();

        if (posXactuelle != 1) {
            Tuile tuileGauche = tuileActuelle.getGrille().getTuile(posXactuelle - 1, posYactuelle);
            if (tuileGauche.getEtat() == EtatTuile.inondee) {
                tuilesPossible.add(tuileGauche);
            }
        }
        if (posXactuelle != 6) {
            Tuile tuileDroite = tuileActuelle.getGrille().getTuile(posXactuelle + 1, posYactuelle);
            if (tuileDroite.getEtat() == EtatTuile.inondee) {
                tuilesPossible.add(tuileDroite);
            }
        }
        if (posYactuelle != 1) {
            Tuile tuileHaut = tuileActuelle.getGrille().getTuile(posXactuelle, posYactuelle - 1);
            if (tuileHaut.getEtat() == EtatTuile.inondee) {
                tuilesPossible.add(tuileHaut);
            }
        }
        if (posYactuelle != 6) {
            Tuile tuileBas = tuileActuelle.getGrille().getTuile(posXactuelle, posYactuelle + 1);
            if (tuileBas.getEtat() == EtatTuile.inondee) {
                tuilesPossible.add(tuileBas);
            }
        }

        return tuilesPossible;
    }

}
