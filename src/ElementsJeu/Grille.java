package ElementsJeu;

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
