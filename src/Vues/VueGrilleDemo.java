package Vues;

import ElementsJeu.Grille;
import ElementsJeu.Tuile;
import Enumerations.EtatTuile;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueGrilleDemo extends Observe {

    // attributs - interne
    private ArrayList<Tuile> tuiles = new ArrayList<>();

    // attributs - mise en forme
    private JFrame window;
    private JPanel plateauTuiles;

    // constructeurs
    public VueGrilleDemo(Grille grille) {
        setTuiles(grille);

        this.window = new JFrame();
        window.setSize(1000, 1000);
        window.setTitle("Grille du Jeu");
        plateauTuiles = new JPanel(new GridLayout(6, 6));
        for (Tuile t : grille.getTuiles()) {
            JPanel jp = new JPanel();
            if (t.getEtat() != EtatTuile.inexistante) {
                JLabel jl = new JLabel(t.getNom().toString());
                jp.add(jl);
            }
            plateauTuiles.add(jp);
        }
        window.add(plateauTuiles);
        window.setVisible(true);
    }

    // setteurs
    public void setTuiles(Grille grille) {
        this.tuiles = grille.getTuiles();
    }

    // getteurs
    public ArrayList<Tuile> getTuiles() {
        return tuiles;
    }

    // autres méthodes
    public static void main(String[] args) {
    }

}
