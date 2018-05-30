// A COMPLETER (ASSECHEMENT) (POUR PREMIERE DEMO)
package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Explorateur extends Aventurier {

    // constructeurs
    Explorateur(String nomJoueur, CarteAventurier carteaventurier) {
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }

    // autres
    @Override
    public ArrayList<Tuile> calculDeplacementPos() {
        ArrayList<Tuile> tuilePossible = new ArrayList<>();

        // pour récuperer les tuiles adjacentes
        Tuile tuileActuelle = getTuile();
        int posXactuelle = tuileActuelle.getPosX();
        int posYactuelle = tuileActuelle.getPosY();
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(posXactuelle, posYactuelle)) {
            if (t.getEtat() != EtatTuile.submergee && t.getEtat() != EtatTuile.inexistante) {
                tuilesPossible.add(t);
            }
        }

        // pour récupérer les tuiles diagonales
        // A COMPLETER
        return tuilesPossible;

    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {
        // pour récuperer les tuiles adjacentes
        Tuile tuileActuelle = getTuile();
        int posXactuelle = tuileActuelle.getPosX();
        int posYactuelle = tuileActuelle.getPosY();
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(posXactuelle, posYactuelle)) {
            if (t.getEtat() == EtatTuile.inondee) {
                tuilesPossible.add(t);
            }
        }

        // pour récupérer les tuiles diagonales
        // A COMPLETER
        return tuilesPossible;
    }

}
