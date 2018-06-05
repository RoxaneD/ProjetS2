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
    private HashMap<Tuile, JPanel> fondTuiles = new HashMap<>();
    private HashMap<Tuile, JButton> devantTuiles = new HashMap<>();
    private Dimension dimension;

    // constructeurs
    public VueGrilleDemo(Grille grille) {
        setTuiles(grille);

        this.window = new JFrame();
        window.setSize(1000, 1000);
        window.setTitle("Grille du Jeu");
        dimension = window.getSize();
        plateauTuiles = new JPanel(new GridLayout(6, 6));
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);
        for (Tuile t : grille.getTuiles()) {
            // création du 1er fond de la tuile (c'est un panel) - indique si la tuile est séléctionnée ou non - rajout dans fondTUiles
            JPanel panelFondTuile = new JPanel();
            panelFondTuile.setBackground(Color.white);
            panelFondTuile.setSize(dimension.width / 6, dimension.height / 6);

            if (t.getEtat() != EtatTuile.inexistante) {
                // on délimite la tuile
                panelFondTuile.setBorder(blackline);
                
                // création du 2ème fond de la tuile (c'est un panel) 
                // contient un bouton qui indique son état 
                // + contient un ou plusieurs panels qui indiquent : son nom + emplacement aventuriers/trésors - rajout dans devantTuiles
                
                JPanel panelDevantTuile = new JPanel(new BorderLayout());
                panelDevantTuile.setSize(new Dimension(((int) ((panelFondTuile.getSize().getWidth()) * (0.9))), ((int) (((panelFondTuile.getSize().getHeight()) * (0.9))))));
                
                // création du bouton qui contient l'état de la tuile
                JButton boutonEtat = new JButton();
                boutonEtat.setPreferredSize(new Dimension(((int) ((panelFondTuile.getSize().getWidth()) * (0.9))), ((int) (((panelFondTuile.getSize().getHeight()) * (0.7))))));
                
                //  création de panelInfo : contient les informations de la tuile
                JPanel panelInfo = new JPanel(new BorderLayout());
                JLabel labelNomTuile = new JLabel(t.getNom().toString());
                Font font = new Font(Font.SANS_SERIF, Font.BOLD, 9);
                labelNomTuile.setFont(font);
                panelInfo.setPreferredSize(new Dimension(((int) ((panelFondTuile.getSize().getWidth()) * (0.9))), ((int) (((panelFondTuile.getSize().getHeight()) * (0.3))))));
                panelInfo.add(labelNomTuile);
                
                // ajouts des deux compartiements dans panelDevantTuile
                panelDevantTuile.add(boutonEtat, BorderLayout.NORTH);
                panelDevantTuile.add(panelInfo, BorderLayout.SOUTH);
                
                if (t.getEtat() == EtatTuile.inondee) {
                    panelDevantTuile.getComponent(0).setBackground(Color.CYAN);
                } else {
                    if (t.getEtat() == EtatTuile.submergee) {
                        panelDevantTuile.getComponent(0).setBackground(Color.blue);
                    } else {
                        if (t.getEtat() == EtatTuile.normal) {
                            panelDevantTuile.getComponent(0).setBackground(Color.yellow);
                        }
                    }
                }
                devantTuiles.put(t, boutonEtat);
                panelFondTuile.add(panelDevantTuile);
            }
            fondTuiles.put(t, panelFondTuile);
            plateauTuiles.add(panelFondTuile);
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

    public void afficherTuilesPossibles(ArrayList<Tuile> t2) {
        for (Tuile tuile : t2) {
            fondTuiles.get(tuile).setBackground(Color.RED);
        }

    }
    
    public void afficherTuileActuelle(Tuile t){
        fondTuiles.get(t).setBackground(Color.DARK_GRAY);
    }

    public void revenirGrilleDepart() {
        for (Tuile tuile : tuiles){
            fondTuiles.get(tuile).setBackground(Color.white);
        }
    }

}
