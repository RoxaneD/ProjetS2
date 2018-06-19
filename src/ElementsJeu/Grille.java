package ElementsJeu;

import Cartes.CarteAventurier;
import Enumerations.Couleur;
import Enumerations.EtatTuile;
import Enumerations.NomAventurier;
import Enumerations.NomTresor;
import Enumerations.NomTuile;
import java.util.ArrayList;
import java.util.Collections;

public class Grille {

    // attributs
    private ArrayList<Tuile> tuiles;  //déclaration d'un ArrayList

    // constructeurs d'une grille avec des tuiles
    public Grille() {
        setTuiles();
    }

    // setteurs de l'ArrayList tuiles
    public void setTuiles() {
        tuiles = new ArrayList<>();  //Déclaration de l'ArrayList tuiles
        CarteAventurier carteAventurier1 = new CarteAventurier(NomAventurier.explorateur, Couleur.vert);
        CarteAventurier carteAventurier2 = new CarteAventurier(NomAventurier.messager, Couleur.blanc);
        CarteAventurier carteAventurier3 = new CarteAventurier(NomAventurier.pilote, Couleur.bleu);
        CarteAventurier carteAventurier4 = new CarteAventurier(NomAventurier.plongeur, Couleur.noir);
        CarteAventurier carteAventurier5 = new CarteAventurier(NomAventurier.ingenieur, Couleur.rouge);
        CarteAventurier carteAventurier6 = new CarteAventurier(NomAventurier.navigateur, Couleur.jaune);

        Tresor tresor1 = new Tresor(NomTresor.Pierre);
        Tresor tresor2 = new Tresor(NomTresor.Zephyr);
        Tresor tresor3 = new Tresor(NomTresor.Cristal);
        Tresor tresor4 = new Tresor(NomTresor.Calice);

        ArrayList<NomTuile> nomTuiles = new ArrayList<NomTuile>();
        nomTuiles.add(NomTuile.LePontDesAbimes);
        nomTuiles.add(NomTuile.LaPorteDeBronze);
        nomTuiles.add(NomTuile.LaCaverneDesOmbres);
        nomTuiles.add(NomTuile.LaPorteDeFer);
        nomTuiles.add(NomTuile.LaPortedOr);
        nomTuiles.add(NomTuile.LesFalaisesDeLOubli);
        nomTuiles.add(NomTuile.LePalaisDeCorail);
        nomTuiles.add(NomTuile.LaPortedArgent);
        nomTuiles.add(NomTuile.LesDunesDeLillusion);
        nomTuiles.add(NomTuile.Heliport);
        nomTuiles.add(NomTuile.LaPorteDeCuivre);
        nomTuiles.add(NomTuile.LeJardinDesHurlements);
        nomTuiles.add(NomTuile.LaForetPourpre);
        nomTuiles.add(NomTuile.LeLagonPerdu);
        nomTuiles.add(NomTuile.LeMaraisBrumeux);
        nomTuiles.add(NomTuile.Observatoire);
        nomTuiles.add(NomTuile.LeRocherFantome);
        nomTuiles.add(NomTuile.LaCaverneDuBrasier);
        nomTuiles.add(NomTuile.LeTempleDuSoleil);
        nomTuiles.add(NomTuile.LeTempleDeLaLune);
        nomTuiles.add(NomTuile.LePalaisDesMarees);
        nomTuiles.add(NomTuile.LeValDuCrepuscule);
        nomTuiles.add(NomTuile.LaTourDuGuet);
        nomTuiles.add(NomTuile.LeJardinDesMurmures);

        Collections.shuffle(nomTuiles);

        tuiles.add(new Tuile(this, 1, 1));
        tuiles.add(new Tuile(this, 2, 1));
        tuiles.add(new Tuile(this, 3, 1, nomTuiles.get(0)));
        tuiles.add(new Tuile(this, 4, 1, nomTuiles.get(1)));
        tuiles.add(new Tuile(this, 5, 1));
        tuiles.add(new Tuile(this, 6, 1));
        tuiles.add(new Tuile(this, 1, 2));
        tuiles.add(new Tuile(this, 2, 2, nomTuiles.get(2)));
        tuiles.add(new Tuile(this, 3, 2, nomTuiles.get(3)));
        tuiles.add(new Tuile(this, 4, 2, nomTuiles.get(4)));
        tuiles.add(new Tuile(this, 5, 2, nomTuiles.get(5)));
        tuiles.add(new Tuile(this, 6, 2));
        tuiles.add(new Tuile(this, 1, 3, nomTuiles.get(6)));
        tuiles.add(new Tuile(this, 2, 3, nomTuiles.get(7)));
        tuiles.add(new Tuile(this, 3, 3, nomTuiles.get(8)));
        tuiles.add(new Tuile(this, 4, 3, nomTuiles.get(9)));
        tuiles.add(new Tuile(this, 5, 3, nomTuiles.get(10)));
        tuiles.add(new Tuile(this, 6, 3, nomTuiles.get(11)));
        tuiles.add(new Tuile(this, 1, 4, nomTuiles.get(12)));
        tuiles.add(new Tuile(this, 2, 4, nomTuiles.get(13)));
        tuiles.add(new Tuile(this, 3, 4, nomTuiles.get(14)));
        tuiles.add(new Tuile(this, 4, 4, nomTuiles.get(15)));
        tuiles.add(new Tuile(this, 5, 4, nomTuiles.get(16)));
        tuiles.add(new Tuile(this, 6, 4, nomTuiles.get(17)));
        tuiles.add(new Tuile(this, 1, 5));
        tuiles.add(new Tuile(this, 2, 5, nomTuiles.get(18)));
        tuiles.add(new Tuile(this, 3, 5, nomTuiles.get(19)));
        tuiles.add(new Tuile(this, 4, 5, nomTuiles.get(20)));
        tuiles.add(new Tuile(this, 5, 5, nomTuiles.get(21)));
        tuiles.add(new Tuile(this, 6, 5));
        tuiles.add(new Tuile(this, 1, 6));
        tuiles.add(new Tuile(this, 2, 6));
        tuiles.add(new Tuile(this, 3, 6, nomTuiles.get(22)));
        tuiles.add(new Tuile(this, 4, 6, nomTuiles.get(23)));
        tuiles.add(new Tuile(this, 5, 6));
        tuiles.add(new Tuile(this, 6, 6));

        for (Tuile t : tuiles) {
            if (t.getNom() == NomTuile.LaPorteDeBronze) {
                t.setEmplacementAventurier(carteAventurier5);
            } else if (t.getNom() == NomTuile.LaCaverneDesOmbres) {
                t.setEmplacementTresor(tresor3);
            } else if (t.getNom() == NomTuile.LaPorteDeFer) {
                t.setEmplacementAventurier(carteAventurier4);
            } else if (t.getNom() == NomTuile.LaPortedOr) {
                t.setEmplacementAventurier(carteAventurier6);
            } else if (t.getNom() == NomTuile.LePalaisDeCorail) {
                t.setEmplacementTresor(tresor4);
            } else if (t.getNom() == NomTuile.LaPortedArgent) {
                t.setEmplacementAventurier(carteAventurier2);
            } else if (t.getNom() == NomTuile.Heliport) {
                t.setEmplacementAventurier(carteAventurier3);
            } else if (t.getNom() == NomTuile.LaPorteDeCuivre) {
                t.setEmplacementAventurier(carteAventurier1);
            } else if (t.getNom() == NomTuile.LeJardinDesHurlements) {
                t.setEmplacementTresor(tresor2);
            } else if (t.getNom() == NomTuile.LaCaverneDuBrasier) {
                t.setEmplacementTresor(tresor3);
            } else if (t.getNom() == NomTuile.LeTempleDuSoleil) {
                t.setEmplacementTresor(tresor1);
            } else if (t.getNom() == NomTuile.LeTempleDeLaLune) {
                t.setEmplacementTresor(tresor1);
            } else if (t.getNom() == NomTuile.LePalaisDesMarees) {
                t.setEmplacementTresor(tresor4);
            } else if (t.getNom() == NomTuile.LeJardinDesMurmures) {
                t.setEmplacementTresor(tresor2);
            }
        } 
    }

    // getteurs 
    public ArrayList<Tuile> getTuiles() {
        return tuiles;  //Retourne l'ArrayList tuiles
    }

    //getteur avec un indice x et y 
    public Tuile getTuile(int x, int y) {
        Tuile tuileRecherchee = null;  //Initialisation de tuileRecherchée avec pour valeur null
        for (Tuile t : tuiles) {  //Parcours de l'arrayList tuiles
            if (t.getPosX() == x && t.getPosY() == y) {  //Condition pour trouver la tuile recherchée avec l'indice x et y 
                tuileRecherchee = t;  //tuileRecherchee prend pour valeur les coordonnées de la tuile correspondantes dand l'ArrayList 
            }
        }
        return tuileRecherchee;  //Retourne la tuile trouvée
    }
    
    public Tuile getTuile(NomTuile nom) {
        Tuile tuileRecherchee = null;  //Initialisation de tuileRecherchée avec pour valeur null
        for (Tuile t : tuiles) {  //Parcours de l'arrayList tuiles
            if (t.getNom() == nom) {  //Condition pour trouver la tuile recherchée avec l'indice x et y 
                tuileRecherchee = t;  //tuileRecherchee prend pour valeur les coordonnées de la tuile correspondantes dand l'ArrayList 
            }
        }
        return tuileRecherchee;  //Retourne la tuile trouvée
    }

    //getteur d'un ArrayList de Tuile avec une tuile en paramètre
    public ArrayList<Tuile> getTuilesAdjacentes(Tuile tuile) {
        if (tuile.getEtat() != EtatTuile.inexistante) {  //Vérifie que l'état de la tuile est différent d'inexistant
            ArrayList<Tuile> tuiles = new ArrayList<>();  //Déclaration d'un ArrayList de Tuile
            int x = tuile.getPosX();  //Initialisation de la variable x en utilisant la méthode getPosX avec la tuile
            int y = tuile.getPosY();  //Initialisation de la variable y en utilisant la méthode getPosY avec la tuile
            Tuile tuile2;  //Déclaration d'une Tuile tuile2
            if (x != 1) { // tuile à gauche
                tuile2 = getTuile(x - 1, y);  //Initialise la tuile2 avec les coordonnées x-1 et y
                if (tuile2.getEtat() != EtatTuile.inexistante) { //Vérifie que l'état de tuile2 est différent d'inexistant
                    tuiles.add(tuile2);  //Ajout de tuile2 dans l'ArrayList tuiles
                }
            }

            if (x != 6) { // tuile à droite
                tuile2 = getTuile(x + 1, y);  //initilaisation de tuile2 avec les coordonnées x+1 et y
                if (tuile2.getEtat() != EtatTuile.inexistante) {  //Vérifie que l'état de la tuile2 est différent d'inexistant
                    tuiles.add(tuile2);  //Ajout de tuile2 dans l'ArrayList tuiles
                }
            }

            if (y != 1) { // tuile en haut
                tuile2 = getTuile(x, y - 1);  //Initialisation de tuile2 avec les coordonnées x et y-1
                if (tuile2.getEtat() != EtatTuile.inexistante) {  //Vérifie que l'état de tuile2 est différent d'inexistant
                    tuiles.add(tuile2);  //Ajout de tuile2 dans l'ArrayList tuiles
                }
            }

            if (y != 6) { // tuile en bas
                tuile2 = getTuile(x, y + 1);  //Initialise tuile2 avec les coordonnées x et y+1 
                if (tuile2.getEtat() != EtatTuile.inexistante) {  //Vérifie que l'état de tuile2 est différent d'inexistant
                    tuiles.add(tuile2);  //Ajout de tuile2 dans l'ArrayList tuiles
                }
            }
            return tuiles;  //Retourne l'ArrayList tuiles contenant des Tuile
        }
        return null;  //retourne la valeur null
    }

    //getteur de tuiles placées en diagonales par rapport à une tuile donnée
    public ArrayList<Tuile> getTuilesDiagonales(Tuile tuile) {
        if (tuile.getEtat() != EtatTuile.inexistante) {  //Vérifie que l'état de la tuile est différent d'inexistant 
            ArrayList<Tuile> tuiles = new ArrayList<>();  //Déclaration d'un ArrayList tuiles contenant des Tuile
            int x = tuile.getPosX();  //Initialisation de la variable x avec le getteur getPosX
            int y = tuile.getPosY();  //Initialisation de la variable y avec le getteur getPosY
            Tuile tuile2;  //Déclaration d'une Tuile tuile2
            if (x != 1 && y != 1) { // tuile en haut à gauche
                tuile2 = getTuile(x - 1, y - 1);  //Initialise tuile2 avec les coordonnées x-1 et y-1
                if (tuile2.getEtat() != EtatTuile.inexistante) {  //Vérifie que l'état de tuile2 est différent d'inexistant
                    tuiles.add(tuile2);  //Ajout de tuile2 dans l'ArrayList tuiles
                }
            }
            if (x != 6 && y != 1) { // tuile en haut à droite
                tuile2 = getTuile(x + 1, y - 1);  //Initialise tuile2 avec les coordonnées x+1 et y-1
                if (tuile2.getEtat() != EtatTuile.inexistante) {  //Vérifie que l'état de tuile2 est différent d'inexistant
                    tuiles.add(tuile2);  //Ajout de tuile2 dans l'ArrayList tuiles
                }
            }
            if (x != 1 && y != 6) { // tuile en bas à gauche
                tuile2 = getTuile(x - 1, y + 1);  //Initialise tuile2 avec les coordonnées x-1 et y+1
                if (tuile2.getEtat() != EtatTuile.inexistante) {  //Vérifie que l'état de tuile2 est différent d'inexistant
                    tuiles.add(tuile2);  //Ajout de tuile2 dans l'ArrayList tuiles
                }
            }
            if (x != 6 && y != 6) { // tuile en bas à droite
                tuile2 = getTuile(x + 1, y + 1);  //Initialise tuile2 avec les coordonnées x+1 et y-1 
                if (tuile2.getEtat() != EtatTuile.inexistante) {  //Vérifie que l'état de tuile2 est différent d'inexistant
                    tuiles.add(tuile2);  //Ajout de tuile2 dans l'ArrayList tuiles
                }
            }
            return tuiles;  //Retourne l'Arraylist tuiles
        }
        return null;  //Retourne la valeur null
    }

    // autres
    public void addTuile(Tuile tuile) {
        tuiles.add(tuile);  //Ajoute la tuile dans l'ArrayList tuiles
    }

    public void removeTuile(Tuile tuile) {
        int i = 0;  //Initialise i à 0 
        while (tuiles.get(i) != tuile) {  //Boucle tant que la tuile contenu dans l'ArrayList est différent de celle donné en paramètre
            i += 1;  //Itération
        }
        if (i < tuiles.size()) {  //Vérifie si l'indice de la tuile est inférieur à la taille de l'ArrayList
            tuiles.remove(i); //Supprime la tuile à l'indice i dans tuiles
        }
    }
}
