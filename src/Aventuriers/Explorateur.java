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
        setNomJoueur(nomJoueur); //appel de la fonction setNomJoueur avec nomJoueur en argument
        setEtat(EtatAventurier.vivant);  // Etat de l'aventurier est mis à vivant
        setCarteAventurier(carteaventurier); //Initialisation case départ de l'aventurier selon son nom
    }

    // autres
    @Override
    public ArrayList<Tuile> calculDeplacementPos() {
        // pour récuperer les tuiles adjacentes
        Tuile tuileActuelle = getTuile(); //la Tuile tuileActuelle prend la valeur de getTuile
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();  //tuilesPossibles est un ArrayList composé de Tuiles

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) { //Boucle qui parcours les Tuiles adjacentes à celle du joueur
            if (t.getEtat() != EtatTuile.submergee) { // Vérifie si l'état de la tuile actuelle n'est pas submergée
                tuilesPossibles.add(t);  // Alors on ajoute la tuile dans l'ArrayList tuilesPossibles
            }
        }

        // pour récupérer les tuiles diagonales
        for (Tuile t : tuileActuelle.getGrille().getTuilesDiagonales(tuileActuelle)) {
            if (t.getEtat() != EtatTuile.submergee) {  //Vérifie si la tuile n'est pas submergee
                tuilesPossibles.add(t);  // Alors ajoute la tuile diagonale à l'ArrayList
            }
        }

        return tuilesPossibles;  //retourne l'ArrayList composé des tuiles valides

    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {  //permet de calculer les tuiles où le joueur peut se déplacer
        // pour récuperer les tuiles adjacentes
        Tuile tuileActuelle = getTuile();  //tuileActuelle prend pour valeur celle de getTuile()
        ArrayList<Tuile> tuilesPossible = new ArrayList<>();

        for (Tuile t : tuileActuelle.getGrille().getTuilesAdjacentes(tuileActuelle)) {  //On regarde les tuiles adjacentes par rapport à la tuile actuelle
            if (t.getEtat() == EtatTuile.inondee) {  // vérifie si l'état de la tuile égal à inondée
                tuilesPossible.add(t);  // Alors on l'ajoute à l'ArrayList
            }
        }

        // pour récupérer les tuiles diagonales
        for (Tuile t : tuileActuelle.getGrille().getTuilesDiagonales(tuileActuelle)) {  // on parcours les tuiles situées en diagonales par rapport à la tuile actuelle
            if (t.getEtat() == EtatTuile.inondee) {  //Vérifie si l'état de la tuile est égal à inondée
                tuilesPossible.add(t);  // Alors on l'ajoute
            }
        }
        
        if (tuileActuelle.getEtat() == EtatTuile.inondee) {  // Vérifie si l'état de la tuile actuelle est égal à inondée
                tuilesPossible.add(tuileActuelle);  // Alors on l'ajoute à l'ArrayList
            }

        return tuilesPossible;  // On retourne l'ArrayList tuilesPossible
    }

}
