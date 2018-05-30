// A COMPLETER (DEPLACEMENT) (PREMIERE DEMO)

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
        int posXactuelle = tuileActuelle.getPosX();
        int posYactuelle = tuileActuelle.getPosY();
        ArrayList<Tuile> tuilesTraitees = new ArrayList<>();
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        
        // pour récupérer les tuiles normales qui sont joignable via un chemin inondé et/ou submergé
        for (Tuile t1 : tuileActuelle.getGrille().getTuiles()){
            
        }
        
        // pour les tuiles adjacentes
        if (posXactuelle != 1) {
            Tuile tuileGauche = tuileActuelle.getGrille().getTuile(posXactuelle - 1, posYactuelle);
            if (tuileGauche.getEtat() != EtatTuile.submergee) {
                tuilesPossibles.add(tuileGauche);
            }
        }
        if (posXactuelle != 6) {
            Tuile tuileDroite = tuileActuelle.getGrille().getTuile(posXactuelle + 1, posYactuelle);
            if (tuileDroite.getEtat() != EtatTuile.submergee) {
                tuilesPossibles.add(tuileDroite);
            }
        }
        if (posYactuelle != 1) {
            Tuile tuileHaut = tuileActuelle.getGrille().getTuile(posXactuelle, posYactuelle - 1);
            if (tuileHaut.getEtat() != EtatTuile.submergee) {
                tuilesPossibles.add(tuileHaut);
            }
        }
        if (posYactuelle != 6) {
            Tuile tuileBas = tuileActuelle.getGrille().getTuile(posXactuelle, posYactuelle + 1);
            if (tuileBas.getEtat() != EtatTuile.submergee) {
                tuilesPossibles.add(tuileBas);
            }
        }
        
        return tuilesPossibles;
    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {
        Tuile tuileActuelle = getTuile();
        int posXactuelle = tuileActuelle.getPosX();
        int posYactuelle = tuileActuelle.getPosY();
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(posXactuelle,posYactuelle)){
            if (t.getEtat()==EtatTuile.inondee){
                tuilesPossible.add(t);
            }
        }

        return tuilesPossible;
    }

}
