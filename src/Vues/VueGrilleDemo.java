package Vues;

import ElementsJeu.Grille;
import ElementsJeu.Tuile;
import Enumerations.EtatTuile;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class VueGrilleDemo extends Observe {

    // attributs - interne
    private ArrayList<Tuile> tuiles = new ArrayList<>();

    // attributs - mise en forme
    private JFrame window;
    private JPanel plateauTuiles;
    private HashMap<Tuile, JButton> fondTuiles = new HashMap<>();
    private HashMap<Tuile, JButton> devantTuiles = new HashMap<>();

    // constructeurs
    public VueGrilleDemo(Grille grille) {
        setTuiles(grille);

        this.window = new JFrame();
        window.setSize(1000, 1000);
        window.setTitle("Grille du Jeu");
        plateauTuiles = new JPanel(new GridLayout(6, 6));
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);
        for (Tuile t : grille.getTuiles()) {
            JPanel jp = new JPanel();
            jp.setBackground(Color.white);
            if (t.getEtat() != EtatTuile.inexistante) {
                // création du 1er fond de la tuile - indique si la tuile est séléctionnée ou non - rajout dans fondTUiles
                jp.setBorder(blackline);
                JButton bouton = new JButton();
                
                bouton.setPreferredSize(new Dimension(((jp.getSize().getWidth())*(0.9)), (jp.getSize().getHeight())*(0.9)));
                fondTuiles.put(t, bouton);

                // création du 2ème fond de la tuile - indique son état + son nom + emplacement aventuriers/trésors - rajout dans devantTuiles
                jp.setBorder(blackline);
                JButton bouton1 = new JButton();
                JLabel jl = new JLabel(t.getNom().toString());
                Font font = new Font(Font.SANS_SERIF, Font.BOLD, 9);
                jl.setFont(font);
                bouton1.setPreferredSize(new Dimension(20, 20));
                bouton1.add(jl);
                devantTuiles.put(t, bouton1);

                bouton.add(bouton1);
                jp.add(bouton);

                if (t.getEtat() == EtatTuile.inondee) {
                    jp.getComponent(0).setBackground(Color.CYAN);
                } else {
                    if (t.getEtat() == EtatTuile.submergee) {
                        jp.getComponent(0).setBackground(Color.blue);
                    } else {
                        if (t.getEtat() == EtatTuile.normal) {
                            jp.getComponent(0).setBackground(Color.yellow);
                        }
                    }
                }
            }
            plateauTuiles.add(jp);
        }
        window.add(plateauTuiles);
        window.setVisible(true);
    }

    // setteurs
    public void setTuiles(Grille grille) {
        for (Tuile t : grille.getTuiles()) {
            this.tuiles.add(t);
        }

    }

    // getteurs
    public ArrayList<Tuile> getTuiles() {
        for (Tuile t : tuiles) {
            System.out.println(t.getNom());
        }
        return tuiles;
    }

    // autres méthodes
    public static void main(String[] args) {
    }

    public void afficherTuiles(ArrayList<Tuile> t2) {
        for (Tuile tuile : t2) {
            fondTuiles.get(tuile).setBackground(Color.red);
        }

    }

    public void afficherGrille() {

    }

}
