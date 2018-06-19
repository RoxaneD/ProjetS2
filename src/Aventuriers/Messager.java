// OK + validation aux tests
package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Messager extends Aventurier {

    // constructeurs
    public Messager(String nomJoueur, CarteAventurier carteaventurier) {  //Un Messager est composé d'un nom et d'une carte Aventurier
        setNomJoueur(nomJoueur);  //Attribution du nom avec setNomJoueur() et le nom du messager en paramètre
        setEtat(EtatAventurier.vivant);  //Mise à jour de l'état aventurier en lui donnant pour valeur Vivant
        setCarteAventurier(carteaventurier);  //Attribution de la carte aventurier avec setCarteAventurier() et carteAventurier en paramètre
        setTasJoueur();
    }

    // autres
    @Override
    //Création d'un ArrayList composé de Tuile
    public ArrayList<Tuile> calculDeplacementPos() {    
        Tuile tuileActuelle = getTuile();  //tuileActuelle prend la valeur de getTuile()
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();  // Déclaration d'un ArrayList nommé tuilesPossible

        // pour les tuiles adjacentes
        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {
            if (t.getEtat() != EtatTuile.submergee) {  //vérification que l'état de la tuileActuelle est différente de submergée
                tuilesPossible.add(t);  // Alors on l'ajoute à l'Arraylist
            }
        }

        return tuilesPossible; // On retourne l'ArrayList tuilesPossible
    }

    @Override
    
    public ArrayList<Tuile> calculAssechementPos() {
        Tuile tuileActuelle = getTuile();
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();

        // pour les tuiles adjacentes
        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) { 
            if (t.getEtat() == EtatTuile.inondee) {  // Vérifie si la tuile est inondée
                tuilesPossible.add(t);  // Ajoute la tuile à l'ArrayList tuilesPossible
            }
        }
        if (tuileActuelle.getEtat() == EtatTuile.inondee) {  //Vérifie si la tuile actuelle est inondée
            tuilesPossible.add(tuileActuelle);  //Ajoute la tuile actuelle à l'ArrayList tuilesPossible
        }

        return tuilesPossible;  // Retourne l'ArrayList tuilesPossible
    }
}
