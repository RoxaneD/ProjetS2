package ElementsJeu;

import Enumerations.EtatTuile;
import java.util.ArrayList;

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
