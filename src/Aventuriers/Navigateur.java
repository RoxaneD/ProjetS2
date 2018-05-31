// A COMPLETER (SEMAINE BLOQUEE)
package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Navigateur extends Aventurier {

    // constructeurs
    public Navigateur(String nomJoueur, CarteAventurier carteaventurier) {
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }

    // autres
    @Override
    // A MODIFIER PENDANT LA SEMAINE BLOQUEE
    public ArrayList<Tuile> calculDeplacementPos() {
        Tuile tuileActuelle = getTuile();
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
            if (t.getEtat() != EtatTuile.submergee) {
                tuilesPossible.add(t);
            }
        }

        return tuilesPossible;
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
        if (tuileActuelle.getEtat() == EtatTuile.inondee) {
                tuilesPossible.add(tuileActuelle);
            }

        return tuilesPossible;
    }

}
