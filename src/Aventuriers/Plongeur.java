// OK + validation aux tests
package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Plongeur extends Aventurier {

    // constructeurs
    public Plongeur(String nomJoueur, CarteAventurier carteaventurier) {
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }

    // autres
    @Override
    public ArrayList<Tuile> calculDeplacementPos() {
        Tuile tuileActuelle = getTuile();
        ArrayList<Tuile> tuilesTraitees = new ArrayList<>();
        ArrayList<Tuile> tuilesATraiter = new ArrayList<>();
        ArrayList<Tuile> tuilesEnTraitement = new ArrayList<>();
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        boolean traitee = false;

        // pour récupérer les tuiles normales qui sont joignable via un chemin inondé et/ou submergé
        tuilesATraiter.add(tuileActuelle);
        tuilesTraitees.add(tuileActuelle);
        // pour chacune des tuiles non traités (inondées ou submergées)
        while (tuilesATraiter.size() != 0) {
            tuilesEnTraitement = tuilesATraiter;
            tuilesATraiter = new ArrayList<>();
            for (Tuile t1 : tuilesEnTraitement) {
                for (Tuile t2 : tuileActuelle.getGrille().getTuilesAdjacentes(t1)) {
                    // pour vérifier si la tuille selectionée est traitée ou pas
                    traitee = false;
                    for (Tuile t3 : tuilesTraitees) {
                        if (t3 == t2) {
                            traitee = true;
                        }
                    }
                    // si elle est normale ou inondée, on l'ajoute aux tuiles possibles
                    if ((t2.getEtat() == EtatTuile.normal || t2.getEtat() == EtatTuile.inondee )&& !traitee) {
                        tuilesPossibles.add(t2);
                        // si elle est inondée ou submergée on se rajoute dans tuilesATraiter
                    }
                    
                    if ((t2.getEtat() == EtatTuile.inondee || t2.getEtat() == EtatTuile.submergee) && !traitee) {
                        tuilesATraiter.add(t2);
                    }
                    tuilesTraitees.add(t2);
                }
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
        if (tuileActuelle.getEtat() == EtatTuile.inondee) {
            tuilesPossible.add(tuileActuelle);
        }

        return tuilesPossible;
    }

}
