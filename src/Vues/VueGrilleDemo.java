package Vues;

import ElementsJeu.Grille;
import ElementsJeu.Tuile;
import Enumerations.EtatTuile;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
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
            if (t.getEtat() != EtatTuile.inexistante) {
                jp.setBorder(blackline);
                JButton bouton1 = new JButton();
                JLabel jl = new JLabel(t.getNom().toString());
                Font font =new Font(Font.SANS_SERIF,Font.BOLD,9);                        
                jl.setFont(font);
                bouton1.setPreferredSize(new Dimension(140, 140));
                bouton1.add(jl);
                jp.add(bouton1);


                if (t.getEtat() == EtatTuile.inondee) {
                    jp.setBackground(Color.yellow);
                    //bouton1.setBackground(Color.yellow);
 
                } else {
                    if (t.getEtat() == EtatTuile.submergee) {
                         jp.setBackground(Color.blue);
                        //bouton1.setBackground(Color.blue);
  
                    } else {
                        if (t.getEtat() == EtatTuile.normal) {
                             jp.setBackground(Color.LIGHT_GRAY);
                            //bouton1.setBackground(Color.LIGHT_GRAY);
          
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
