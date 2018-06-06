// OK + validation aux tests
package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Pilote extends Aventurier {

    private Boolean pouvoir = false; // false : pouvoir pas utilisé | true : pouvoir utilisé

    // constructeurs
    public Pilote(String nomJoueur, CarteAventurier carteaventurier) {
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }

    // setteurs
    public void setPouvoir(Boolean pouvoir) {
        this.pouvoir = pouvoir;
    }

    // getteurs
    public Boolean getPouvoir() {

        return pouvoir;

    }

    // autres
    @Override
    public ArrayList<Tuile> calculDeplacementPos() {
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        Tuile tuileActuelle = getTuile();

        if (!pouvoir) {

            for (Tuile t : tuileActuelle.getGrille().getTuiles()) {
                if (t.getEtat() != EtatTuile.submergee && t.getEtat() != EtatTuile.inexistante && t!=tuileActuelle) {
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
        if (tuileActuelle.getEtat() == EtatTuile.inondee) {
                tuilesPossible.add(tuileActuelle);
            }

        return tuilesPossible;
    }

}
