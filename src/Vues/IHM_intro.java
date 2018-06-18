/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author fourniep
 */
public class IHM_intro extends JPanel {

    // variables internes
    private int i; // représente le nombre de joueurs
    private boolean presse = false;
    private Integer width, height;

    // éléments de l'ihm
    private JPanel fenetre = new JPanel();
    private JPanel panelPrincipal = new JPanel(new BorderLayout()); // représente l'ensemble de l'ihm
    private JPanel panelTitre = new JPanel(); // représente l'espace pour le titre
    private JPanel panelJoueurs = new JPanel(); // représente les joueurs
    private JPanel panelInfos = new JPanel(); // pour : 'ajouter un joueur' + 'commencer' + 'regles du jeu'
    private JButton ajouter = new JButton("Ajouter un joueur");
    private JButton commencer = new JButton("Commencer");
    private JButton regles = new JButton("Règles du jeu");

    // ?
    private Image image;

    public IHM_intro() {
        i = 2;
        width = 500;
        height = 500;
        try {
            this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/ciel.png"));
        } catch (IOException ex) {
            System.err.println("Erreur de lecture de ciel.png");
        }
        
        fenetre.add(new JLabel("Ile Interdite"));
        fenetre.setSize(500, 500);
        

        panelJoueurs = new JPanel(new GridLayout(6, 2));

        panelJoueurs.setOpaque(false);
        panelPrincipal.add(panelJoueurs, BorderLayout.CENTER);
        panelJoueurs.add(new JLabel("Nom Joueur 1 : ", JLabel.RIGHT));
        JTextField champNom = new JTextField();
        panelJoueurs.add(champNom);

        panelJoueurs.add(new JLabel("Nom joueur 2 : ", JLabel.RIGHT));
        JTextField champNom1 = new JTextField();
        panelJoueurs.add(champNom1);

        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPressed() && i < 6) {
                    System.out.println("Bouton cliqué");
                    i = i + 1;
                    System.out.println("i=i+1");
                    panelJoueurs.add(new JLabel("Nom Joueur " + i + " : ", JLabel.RIGHT));
                    System.out.println("add panelCentre");
                    JTextField champNom3 = new JTextField();
                    panelJoueurs.add(champNom3);
                    System.out.println("ajout textfield");

                    //Redimensionnement pour actualiser la page MAIS A CHANGER PARCE QUE C'EST MOCHE !!!
                    fenetre.setSize(501, 501);
                    fenetre.setSize(500, 500);
                }
            }
        });
        panelPrincipal.add(ajouter, BorderLayout.SOUTH);

        fenetre.add(panelPrincipal);
        fenetre.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, width, height, null, this);

    }

    public JPanel getWindow() {
        return fenetre;
    }

    public boolean isPressed() {
        return presse;
    }

    public void setPressed(boolean p) {
        this.presse = p;
    }

    public boolean getPressed() {
        return this.presse;
    }
    

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(450, 532);
        
        // Centrage de la fenêtre sur l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((dim.width/2)-225, (dim.height / 2)-150);
        
        IHM_intro ihm = new IHM_intro();
        window.add(ihm);
        
        window.setVisible(true);
        ihm.repaint();
    }

}
