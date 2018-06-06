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
    // Crée un pilote avec les paramètres : nom d'aventurier, son état et sa carte
    public Pilote(String nomJoueur, CarteAventurier carteaventurier) {
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }

    // setteurs
    // Variable qui set a savoir si le pilote a déjà uttilisé sa compétence ce tour
    public void setPouvoir(Boolean pouvoir) {
        this.pouvoir = pouvoir;// si vrai la compétence est uttilisé 
    }

    // getteurs
    // Méthode qui renvoie la valeur de pouvoir
    public Boolean getPouvoir() {

        return pouvoir;

    }

    // autres
    @Override
    //Méthode qui calcul les tuiles où peut ce deplacer le pilote
    public ArrayList<Tuile> calculDeplacementPos() {
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();// Collection des tuiles où le pilote peut ce déplacer
        Tuile tuileActuelle = getTuile();// Tuile où ce trouve le pilote

        if (!pouvoir) {
        // Si le pouvoir est a faux alors le pilote peut ce déplacer dans toute la grille
            for (Tuile t : tuileActuelle.getGrille().getTuiles()) {
                if (t.getEtat() != EtatTuile.submergee && t.getEtat() != EtatTuile.inexistante && t != tuileActuelle) {
                    tuilesPossibles.add(t);// Ajout a la collection les tuiles qui sont inondéé et les tuiles normales
                }
            }

        } else {
        // Si le pouvoir est a vrai alors le pilote a un déplacement normale avec les tuiles adjacentes
            for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
                if (t.getEtat() != EtatTuile.submergee) {
                    tuilesPossibles.add(t);// Ajout de toute les tuiles qui ne sont pas submergée
                }
            }
        }
        // Renvoie la collection des tuiles possibles
        return tuilesPossibles;
    }

    // Méthode qui calcul les tuiles que le pilote peut assècher
    @Override
    public ArrayList<Tuile> calculAssechementPos() {
        Tuile tuileActuelle = getTuile();// Tuiles où ce trouve le pilote
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();// Collection de tuile qu'il est possible d'assècher
        // Ajout de toute les tuiles possible dans la collection
        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
            if (t.getEtat() == EtatTuile.inondee) {// Les tuiles possible sont celles qui sont inondée
                tuilesPossible.add(t);
            }
        }// Vérification si la tuile actuelle est inondée ou non
        if (tuileActuelle.getEtat() == EtatTuile.inondee) {
            tuilesPossible.add(tuileActuelle);
        }
        // Renvoie la collection de tuile possible
        return tuilesPossible;
    }

}
