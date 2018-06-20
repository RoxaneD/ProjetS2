/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 *
 * @author Eric
 * Cette classe contient 3 images superposées : 
 * - une photo de jardin en arrière-plan
 * - une statue en plan intermédiaire
 * - un dragon au premier plan
 */
public class DemoCalques extends JLayeredPane {

    ImageContainerCalques fond ;
    ImageContainerCalques statue ;
    ImageContainerCalques dragon ;

    public DemoCalques() {
        // Récupération du chemin vers le dossier contenant les images
        String imgFolder = System.getProperty("user.dir") + "/src/Image/" ;
        
        // Instanciation d'une image pour le jardin
        // Remarque : les positions et les tailles sont en dur !
        // Dans l'idéal, il faudrait recevoir la taille de la fenêtre et 
        // faire quelque chose de proportionnel.
        fond  = new ImageContainerCalques(imgFolder+"Niveau.png", 0, 0, 450, 300);
        this.add(fond, -2000);
        
        // Instanciation d'une image pour la statue
        statue = new ImageContainerCalques(imgFolder+"stick.png", 200, 170, 40, 80);
        this.add(statue, -1000);

        // Instanciation d'une image pour le dragon
        dragon = new ImageContainerCalques(imgFolder+"sable.png", 250, 3, 200, 200);
        this.add(dragon, 0);

        // Repaint : déclenche la méthode paintComponent
        this.repaint();
    }

    @Override
    /**
     * paintComponent permet de gérer l'affichage / la mise à jour des
     * images, à condition que le paintComponent de chaque objet soit appelé
     * avec le même contexte graphique (Graphics)
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.fond != null) {
            this.fond.paintComponent(g);
        }
        if (this.statue != null) {
            this.statue.paintComponent(g);
        }
        if (this.dragon != null) {
            this.dragon.paintComponent(g);
        }
    }
    
    public static void main(String[] args) {
        JFrame window = new JFrame() ;
        window.setSize(450, 300);
        // Centrage de la fenêtre sur l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        window.setLocation(100, dim.height/2-window.getSize().height/2);

        window.add(new DemoCalques());

        window.setVisible(true);
    }
    
}
