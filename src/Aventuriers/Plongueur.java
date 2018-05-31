// OK :D
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
        ArrayList<Tuile> tuilesTraitees = new ArrayList<>();
        ArrayList<Tuile> tuilesEnTraitement = new ArrayList<>();
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        boolean traitee = false;

        // pour récupérer les tuiles normales qui sont joignable via un chemin inondé et/ou submergé
        tuilesEnTraitement.add(tuileActuelle);
        tuilesTraitees.add(tuileActuelle);
        // pour chacune des tuiles non traités (inondées ou submergées)
        for (Tuile t1 : tuilesEnTraitement) {
            for (Tuile t2 : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
                // pour vérifier si la tuille selectionée est traitée ou pas
                traitee = false;
                for (Tuile t3 : tuilesTraitees) {
                    if (t3 == t2) {
                        traitee = true;
                    }
                }
                // si elle est normale, on l'ajoute aux tuiles possibles
                if (t2.getEtat() == EtatTuile.normal && !traitee) {
                    tuilesPossibles.add(t2);
                    // sinon on se rajoute dans tuilesEnTraitement
                } else if ((t2.getEtat() == EtatTuile.inondee || t2.getEtat() == EtatTuile.submergee) && !traitee) {
                    tuilesEnTraitement.add(t2);
                }
                tuilesTraitees.add(t2);
            }
        }

        // pour les tuiles adjacentes
        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
            if (t.getEtat() == EtatTuile.inondee) {
                tuilesPossibles.add(t);
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
