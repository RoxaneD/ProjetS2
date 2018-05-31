package ElementsJeu;

import Enumerations.EtatTuile;
import java.util.ArrayList;

public class Grille {

    // attributs
    private ArrayList<Tuile> tuiles;

    // constructeurs
    Grille() {
        setTuiles();
    }

    // setteurs
    public void setTuiles() {
        tuiles = new ArrayList<>();
    }

    // getteurs
    public ArrayList<Tuile> getTuiles() {
        return tuiles;
    }
    
    public Tuile getTuile(int x, int y){
        Tuile tuileRecherchee = null;
        for (Tuile t : tuiles){
            if (t.getPosX()==x && t.getPosY()==y){
                tuileRecherchee = t;
            }
        }
        return tuileRecherchee;
    }
    
    public ArrayList<Tuile> getTuilesAdjacentes(Tuile tuile){
        ArrayList<Tuile> tuiles = new ArrayList<>();
        int x = tuile.getPosX();
        int y = tuile.getPosY();
        Tuile t;
        if (x != 1){
            t = getTuile(x-1,y);
             if (t.getEtat()!=EtatTuile.inexistante){
                 tuiles.add(t);
             }
        }
        if (x != 6){
            t = getTuile(x+1,y);
            if (t.getEtat()!=EtatTuile.inexistante){
                 tuiles.add(t);
             }
        }
        if (y != 1){
            t = getTuile(x,y-1);
            if (t.getEtat()!=EtatTuile.inexistante){
                 tuiles.add(t);
             }
        }
        if (y != 6){
            t = getTuile(x,y+1);
            if (t.getEtat()!=EtatTuile.inexistante){
                 tuiles.add(t);
             }
        }
        return tuiles;
    }
    
    public ArrayList<Tuile> getTuilesDiagonales(Tuile tuile){
        ArrayList<Tuile> tuiles = new ArrayList<>();
        int x = tuile.getPosX();
        int y = tuile.getPosY();
        
        
        return tuiles;
    }

    // autres
    public void addTuile(Tuile tuile) {
        tuiles.add(tuile);
    }

    public void removeTuile(Tuile tuile) {
        int i = 0;
        while (tuiles.get(i) != tuile) {
            i += 1;
        }
        if (i < tuiles.size()) {
            tuiles.remove(i);
        }
    }
}
