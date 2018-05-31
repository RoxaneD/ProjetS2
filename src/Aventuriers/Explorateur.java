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
        // pour récuperer les tuiles adjacentes
        Tuile tuileActuelle = getTuile();
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
            if (t.getEtat() != EtatTuile.submergee && t.getEtat() != EtatTuile.inexistante) {
                tuilesPossibles.add(t);
            }
        }

        // pour récupérer les tuiles diagonales
        
        
        return tuilesPossibles;

    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {
        // pour récuperer les tuiles adjacentes
        Tuile tuileActuelle = getTuile();
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
            if (t.getEtat() == EtatTuile.inondee) {
                tuilesPossibles.add(t);
            }
        }

        // pour récupérer les tuiles diagonales
        // A COMPLETER
        return tuilesPossibles;
    }

}
