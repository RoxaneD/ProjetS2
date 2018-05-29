package Aventuriers;

import ElementsJeu.Tuile;
import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Enumerations.EtatAventurier;
import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Pilote extends Aventurier {

    private Boolean pouvoir = true;

    // constructeurs
    Pilote(String nomJoueur, CarteAventurier carteaventurier) {
        setNomJoueur(nomJoueur);
        setEtat(EtatAventurier.vivant);
        setCarteAventurier(carteaventurier);
    }

    // autres
    @Override
    public ArrayList<Tuile> calculDeplacementPos() {

        ArrayList<Tuile> tuilePossible = new ArrayList<>();

        if (pouvoir) {

            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 6; j++) {
                    
                    Tuile T = getTuile().getGrille().getTuile(i,j);
                    if (T.getEtat() != EtatTuile.submergee) {
                        tuilePossible.add(T);
                    }

                }
            }

        } else {
            int posX = this.getTuile().getPosX();
            int posY = this.getTuile().getPosY();

            if (posX != 1) {
                Tuile T = getTuile().getGrille().getTuile(posX - 1, posY);
                if (T.getEtat() == EtatTuile.inondee) {
                    tuilePossible.add(T);
                }
            }

            if (posX != 6) {
                Tuile T = getTuile().getGrille().getTuile(posX + 1, posY);
                if (T.getEtat() == EtatTuile.inondee) {
                    tuilePossible.add(T);
                }
            }

            if (posY != 1) {
                Tuile T = getTuile().getGrille().getTuile(posX, posY - 1);
                if (T.getEtat() == EtatTuile.inondee) {
                    tuilePossible.add(T);
                }
            }

            if (posY != 6) {
                Tuile T = getTuile().getGrille().getTuile(posX, posY + 1);
                if (T.getEtat() == EtatTuile.inondee) {
                    tuilePossible.add(T);
                }
            }
        }

        return tuilePossible;

    }

    @Override
    public ArrayList<Tuile> calculAssechementPos() {
        ArrayList<Tuile> tuilePossible = new ArrayList<>();

        int posX = this.getTuile().getPosX();
        int posY = this.getTuile().getPosY();

        if (posX != 1) {
            Tuile T = getTuile().getGrille().getTuile(posX - 1, posY);
            if (T.getEtat() == EtatTuile.inondee) {
                tuilePossible.add(T);
            }
        }

        if (posX != 6) {
            Tuile T = getTuile().getGrille().getTuile(posX + 1, posY);
            if (T.getEtat() == EtatTuile.inondee) {
                tuilePossible.add(T);
            }
        }

        if (posY != 1) {
            Tuile T = getTuile().getGrille().getTuile(posX, posY - 1);
            if (T.getEtat() == EtatTuile.inondee) {
                tuilePossible.add(T);
            }
        }

        if (posY != 6) {
            Tuile T = getTuile().getGrille().getTuile(posX, posY + 1);
            if (T.getEtat() == EtatTuile.inondee) {
                tuilePossible.add(T);
            }
        }

        return tuilePossible;

    }

}
