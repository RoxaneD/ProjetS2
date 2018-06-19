// OK + validation aux tests
package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Ingenieur extends Aventurier {

    // constructeurs
    // Crée un ingénieur avec les paramètres : nom d'aventurier, son état et sa carte
    public Ingenieur(String nomJoueur, CarteAventurier carteaventurier) {
        setNomJoueur(nomJoueur); 
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
        setTasJoueur();
    }

    // autres
    //Méthode qui calcul les tuiles où peut ce deplacer l'ingénieur
    @Override
    public ArrayList<Tuile> calculDeplacementPos() {
        Tuile tuileActuelle = getTuile();// Tuile où ce trouve l'ingénieur
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();// Collection de tuile où il est possible de ce déplacer

        // Ajout de toute les tuiles possible dans la collection
        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
            if (t.getEtat() != EtatTuile.submergee) { // Les tuiles possibles sont celles qui ne sont pas submergée
                tuilesPossible.add(t);
            }
        }

        // Renvoie la collection de tuile possible
        return tuilesPossible;
    }

    // Méthode qui calcul les tuiles que l'ingénieur peut assècher
    @Override
    public ArrayList<Tuile> calculAssechementPos() {
        Tuile tuileActuelle = getTuile();// Tuiles où ce trouve l'ingénieur
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
