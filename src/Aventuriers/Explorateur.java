// OK + validation aux tests
package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Explorateur extends Aventurier {

    // constructeurs
    public Explorateur(String nomJoueur, CarteAventurier carteaventurier) {
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }

    // autres
    @Override
    public ArrayList<Tuile> calculDeplacementPos() {
        // pour récuperer les tuiles adjacentes
        Tuile tuileActuelle = getTuile();
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
            if (t.getEtat() != EtatTuile.submergee) {
                tuilesPossibles.add(t);
            }
        }

        // pour récupérer les tuiles diagonales
        for (Tuile t : tuileActuelle.getGrille().getTuilesDiagonales(tuileActuelle)) {
            if (t.getEtat() != EtatTuile.submergee) {
                tuilesPossibles.add(t);
            }
        }

        return tuilesPossibles;

    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {
        // pour récuperer les tuiles adjacentes
        Tuile tuileActuelle = getTuile();
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
            if (t.getEtat() == EtatTuile.inondee) {
                tuilesPossible.add(t);
            }
        }

        // pour récupérer les tuiles diagonales
        for (Tuile t : tuileActuelle.getGrille().getTuilesDiagonales(tuileActuelle)) {
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
