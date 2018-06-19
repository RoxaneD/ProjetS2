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
import javax.swing.JPanel;

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
    LePontDesAbimes = new ImageContainerCalques(imgFolder+"LePontDesAbimes.png", 0, 0, 160, 140);
    this.add(LePontDesAbimes, 0);
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
        
    }
}
