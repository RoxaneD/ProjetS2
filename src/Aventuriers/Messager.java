package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Messager extends Aventurier {

    // constructeurs
    Messager(String nomJoueur, CarteAventurier carteaventurier) {
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
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();

        if (posXactuelle != 1) {
            Tuile tuileGauche = tuileActuelle.getGrille().getTuile(posXactuelle - 1, posYactuelle);
            if (tuileGauche.getEtat() != EtatTuile.submergee) {
                tuilesPossible.add(tuileGauche);
            }
        }
        if (posXactuelle != 6) {
            Tuile tuileDroite = tuileActuelle.getGrille().getTuile(posXactuelle + 1, posYactuelle);
            if (tuileDroite.getEtat() != EtatTuile.submergee) {
                tuilesPossible.add(tuileDroite);
            }
        }
        if (posYactuelle != 1) {
            Tuile tuileHaut = tuileActuelle.getGrille().getTuile(posXactuelle, posYactuelle - 1);
            if (tuileHaut.getEtat() != EtatTuile.submergee) {
                tuilesPossible.add(tuileHaut);
            }
        }
        if (posYactuelle != 6) {
            Tuile tuileBas = tuileActuelle.getGrille().getTuile(posXactuelle, posYactuelle + 1);
            if (tuileBas.getEtat() != EtatTuile.submergee) {
                tuilesPossible.add(tuileBas);
            }
        }

        return tuilesPossible;
    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {

    }

}
