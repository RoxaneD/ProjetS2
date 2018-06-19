package Vues;

import Demo.ImageContainerCalques;
import ElementsJeu.Grille;
import ElementsJeu.Tuile;
import Enumerations.NomTuile;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import ElementsJeu.Grille;
import ElementsJeu.Tuile;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class IhmGrille extends JPanel {

    // doit contenir : les tuiles -> Pas de nom et de couleur, mais l'image associée (en fonction de asseché/innondé)
    //                            -> l'emplacement des trésors (image)
    //                            -> l'emplacement des aventuriers (pendant la partie)
    // 
    Grille grille = new Grille();
    ImageContainerCalques LePontDesAbimes;
    Tuile lepont = new Tuile(grille, 1,1,NomTuile.Le_Pont_Des_Abimes);
    public IhmGrille() {
    String imgFolder = System.getProperty("user.dir") + "/src/Image/" ;
    LePontDesAbimes = new ImageContainerCalques(imgFolder+"LePontDesAbimes.png", 0, 0, 450, 300);
    this.add(LePontDesAbimes, -2000);
    this.repaint();

    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.LePontDesAbimes != null) {
            this.LePontDesAbimes.paintComponent(g);
        }
       
    }
    
    
    
    
    public static void main(String[] args) {
       JFrame window = new JFrame() ;
        window.setSize(450, 300);
        // Centrage de la fenêtre sur l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        window.setLocation(100, dim.height/2-window.getSize().height/2);

        window.add(new IhmGrille());

        window.setVisible(true);
        
       /* JButton bouton11 = new JButton();
        JButton bouton12 = new JButton();
        JButton bouton13 = new JButton();
        JButton bouton14 = new JButton();
        JButton bouton15 = new JButton();
        JButton bouton16 = new JButton();
        JButton bouton21 = new JButton();
        JButton bouton22 = new JButton();
        JButton bouton23 = new JButton();
        JButton bouton24 = new JButton();
        JButton bouton25 = new JButton();
        JButton bouton26 = new JButton();
        JButton bouton31 = new JButton();
        JButton bouton32 = new JButton();
        JButton bouton33 = new JButton();
        JButton bouton34 = new JButton();
        JButton bouton35 = new JButton();
        JButton bouton36 = new JButton();
        JButton bouton41 = new JButton();
        JButton bouton42 = new JButton();
        JButton bouton43 = new JButton();
        JButton bouton44 = new JButton();
        JButton bouton45 = new JButton();
        JButton bouton46 = new JButton();
        JButton bouton51 = new JButton();
        JButton bouton52 = new JButton();
        JButton bouton53 = new JButton();
        JButton bouton54 = new JButton();
        JButton bouton55 = new JButton();
        JButton bouton56 = new JButton();
        JButton bouton61 = new JButton();
        JButton bouton62 = new JButton();
        JButton bouton63 = new JButton();
        JButton bouton64 = new JButton();
        JButton bouton65 = new JButton();
        JButton bouton66 = new JButton();
        
        ArrayList<JButton> boutons = new ArrayList<>();
        
        boutons.add(bouton11);
        boutons.add(bouton12);
        boutons.add(bouton13);
        boutons.add(bouton14);
        boutons.add(bouton15);
        boutons.add(bouton16);
        boutons.add(bouton21);
        boutons.add(bouton22);
        boutons.add(bouton23);
        boutons.add(bouton24);
        boutons.add(bouton25);
        boutons.add(bouton26);
        boutons.add(bouton31);
        boutons.add(bouton32);
        boutons.add(bouton33);
        boutons.add(bouton34);
        boutons.add(bouton35);
        boutons.add(bouton36);
        boutons.add(bouton41);
        boutons.add(bouton42);
        boutons.add(bouton43);
        boutons.add(bouton44);
        boutons.add(bouton45);
        boutons.add(bouton46);
        boutons.add(bouton51);
        boutons.add(bouton52);
        boutons.add(bouton53);
        boutons.add(bouton54);
        boutons.add(bouton55);
        boutons.add(bouton56);
        boutons.add(bouton61);
        boutons.add(bouton62);
        boutons.add(bouton63);
        boutons.add(bouton64);
        boutons.add(bouton65);
        boutons.add(bouton66);
        
        for(JButton bouton : boutons){
            bouton.setBorder(blackline);
            this.add(bouton);
        }*/

        

    }

    //Getteur
    public Grille getGrille() {
        return grille;
    }

    //Setteur
    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.LePontDesAbimes != null) {
            this.LePontDesAbimes.paintComponent(g);
        }
       
    }
}

