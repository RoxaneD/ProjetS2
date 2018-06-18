// A COMPLETER (SEMAINE BLOQUEE)
// Pour la première démo : OK + validation aux tests
package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Navigateur extends Aventurier {

    // constructeurs
    // Crée un Navigateur avec un nom et sa carte 
    public Navigateur(String nomJoueur, CarteAventurier carteaventurier) {
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }

    // autres
    @Override
    //Méthode calculant les déplacements possible du Navigateur
    public ArrayList<Tuile> calculDeplacementPos() {
        Tuile tuileActuelle = getTuile();  // Tuile où se trouve le Navigateur
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();  //Collection contenant les tuiles où le Navigateur peut se déplacer

        //Pour les tuiles adjacentes
        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
            if (t.getEtat() != EtatTuile.submergee) {  //Vérifie si la tuile n'est pas submergée
                tuilesPossible.add(t);  //Ajoute la tuile à la collection tuilesPossible
            }
        }

        return tuilesPossible;  //Renvoi la collection de tuiles possible
    }

    @Override
    //Méthode permettant de calculer les déplacements possibles
    public ArrayList<Tuile> calculAssechementPos() {
        Tuile tuileActuelle = getTuile();  //Tuile où se trouve le Navigateur
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();  //Collection de tuile où le Navigateur peut se déplacer
        
        //Pour les tuiles adjacentes
        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
            if (t.getEtat() == EtatTuile.inondee) {  //Vérifie si la tuile est inondée
                tuilesPossible.add(t);  //Ajoute la tuile à la collection tuilesPossible
            }
        }
        if (tuileActuelle.getEtat() == EtatTuile.inondee) {  //Vérifie si la tuile où se trouve le Navigateur est inondée
                tuilesPossible.add(tuileActuelle);  //Ajoute la tuile à la collection tuilesPossible
            }

        return tuilesPossible;  //Retourne la collection tuilesPossible 
    }

}
