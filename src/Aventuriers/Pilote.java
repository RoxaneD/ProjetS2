// OK

package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Pilote extends Aventurier {

    private Boolean pouvoir = true;

    // constructeurs
    Pilote(String nomJoueur, CarteAventurier carteaventurier) {
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }

    // autres
    @Override
    public ArrayList<Tuile> calculDeplacementPos() {

        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        Tuile tuileActuelle = getTuile();

        if (pouvoir) {
            for (Tuile t : tuileActuelle.getGrille().getTuiles()) {
                if (t.getEtat() != EtatTuile.submergee && t.getEtat() != EtatTuile.inexistante) {
                    tuilesPossibles.add(t);
                }
            }

        } else {
            for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
                if (t.getEtat() != EtatTuile.submergee) {
                    tuilesPossibles.add(t);
                }
            }
        }

        return tuilesPossibles;

    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {
        Tuile tuileActuelle = getTuile();
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
            if (t.getEtat() == EtatTuile.inondee) {
                tuilesPossible.add(t);
            }
        }

        return tuilesPossible;
    }

}
