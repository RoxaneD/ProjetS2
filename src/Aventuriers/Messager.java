// OK
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

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(posXactuelle, posYactuelle)) {
            if (t.getEtat() != EtatTuile.submergee && t.getEtat() != EtatTuile.inexistante) {
                tuilesPossible.add(t);
            }
        }

        return tuilesPossible;
    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {
        Tuile tuileActuelle = getTuile();
        int posXactuelle = tuileActuelle.getPosX();
        int posYactuelle = tuileActuelle.getPosY();
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(posXactuelle, posYactuelle)) {
            if (t.getEtat() == EtatTuile.inondee) {
                tuilesPossible.add(t);
            }
        }

        return tuilesPossible;
    }
}
