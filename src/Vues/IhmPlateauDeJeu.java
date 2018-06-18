/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Cartes.CarteAventurier;
import Cartes.CarteTresors;
import ElementsJeu.Grille;
import Enumerations.Couleur;
import Enumerations.NomAventurier;
import Util.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author paradisc
 */
public class IhmPlateauDeJeu {

    /**
     * @param args the command line arguments
     */
    private final JFrame window;
    private VueAventurierDemo vueAventurier;
    private VueGrilleDemo vueGrille;
    private JPanel panelNorth;
    private JPanel panelCentre;
    private JPanel panelSouth;
    private Dimension dimension;

    // A changer pour arrayList de joueur
    public IhmPlateauDeJeu(VueAventurierDemo vueAventurier1, VueGrilleDemo vueGrille1) {

        setVueAventurier(vueAventurier1);
        setVueGrille(vueGrille1);

        window = new JFrame();
        window.setSize(1000, 1000);
        dimension = window.getSize();
        window.setLayout(new BorderLayout());

        panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setSize((int) dimension.getWidth(), (int) (dimension.getHeight() * 0.1));
        panelNorth.add(new JLabel("Tour du joueur " + this.vueAventurier.getNomJoueur()));

        panelCentre = new JPanel();
        panelCentre.setLayout(new BorderLayout());
        panelCentre.add(vueGrille.getPlateauTuiles(),BorderLayout.CENTER);
        panelCentre.setSize((int) dimension.getWidth(), (int) (dimension.getHeight() * 0.7));
        
        
        JPanel panelCentreEst = new JPanel();
        panelCentreEst.setLayout(new GridLayout(/*Nombre De Joueur*/4,2));
        panelCentreEst.setSize(300, 350);
        panelCentre.add(panelCentreEst,BorderLayout.EAST);
        JPanel panelEstGauche = new JPanel();
        
        int i = 0;
        for(CarteTresors carte : vueAventurier.getTasJoueur().getCartes()){
            i++;
        }
        panelCentreEst.add(new JLabel(vueAventurier.getNomJoueur()));
        panelEstGauche.setLayout(new GridLayout(i,1));
        
        for(CarteTresors carte : vueAventurier.getTasJoueur().getCartes()){
            JButton bouton = new JButton(carte.getNom().name());
            panelCentreEst.add(bouton,BorderLayout.EAST);
            bouton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
            panelCentreEst.add(new JButton(""));
            panelCentreEst.add(new JButton(""));
            panelCentreEst.add(new JButton(""));
            panelCentreEst.add(new JButton(""));
            
        }
        
        
        
        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(3, 3));
        panelSouth.setSize((int) dimension.getWidth(), (int) (dimension.getHeight() * 0.2));
        panelSouth.add(new JLabel(""));
        panelSouth.add(vueAventurier.getBtnAssecher());
        panelSouth.add(vueAventurier.getBtnBouger());
        panelSouth.add(new JLabel(""));
        panelSouth.add(vueAventurier.getBtnAutreAction());
        panelSouth.add(vueAventurier.getBtnTerminerTour());
        panelSouth.add(new JLabel(""));
        panelSouth.add(new JLabel(""));
        panelSouth.add(new JLabel(""));

        window.add(panelNorth, BorderLayout.NORTH);
        window.add(panelCentre, BorderLayout.CENTER);
        window.add(panelSouth, BorderLayout.SOUTH);

    }

    public void setVueAventurier(VueAventurierDemo vueAventurier) {
        this.vueAventurier = vueAventurier;
    }

    public void setVueGrille(VueGrilleDemo vueGrille) {
        this.vueGrille = vueGrille;
    }

    public JFrame getWindow() {
        return window;
    }

    public static void main(String[] args) {
        // TODO code application logic here
       /* CarteAventurier carte = new CarteAventurier(NomAventurier.explorateur, Couleur.bleu);
        //Création d'une vue aventurier de nom Test1 avec la carte et le pion
        VueAventurierDemo vueAventurier1 = new VueAventurierDemo("Test1", carte, Utils.Pion.BLEU.getCouleur());
        Grille grille = new Grille();
        VueGrilleDemo vueGrille = new VueGrilleDemo(grille);
        
        IhmPrincipale ihm1 = new IhmPrincipale(vueAventurier1,vueGrille);
        ihm1.getWindow().setVisible(true);*/

    }

}
