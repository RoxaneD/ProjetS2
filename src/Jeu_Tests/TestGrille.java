package Jeu_Tests;

import Cartes.CarteAventurier;
import ElementsJeu.Grille;
import ElementsJeu.Tresor;
import ElementsJeu.Tuile;

public class TestGrille {

    public static void main(String[] args) {
        Grille g = new Grille();

        int i = 1;
        for (Tuile t : g.getTuiles()) {
            System.out.println(i);
            System.out.println("Nom : " + t.getNom());
            CarteAventurier carteAventurier = t.getEmplacementAventurier();
            if (carteAventurier != null) {
                System.out.println("Emplacement aventurier : " + t.getEmplacementAventurier().getNom());
            } 
            Tresor tresor = t.getEmplacementTresor();
            if (tresor != null){
                System.out.println("Emplacement tresor : "+ t.getEmplacementTresor().getNom());
            }
            System.out.println("");
            if (i % 6 == 0){
                System.out.println("-------------------------------------");
            }
            i += 1;
        }
    }

}
