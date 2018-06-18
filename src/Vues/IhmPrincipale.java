/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Cartes.CarteAventurier;
import ElementsJeu.Grille;
import Enumerations.Couleur;
import Enumerations.NomAventurier;
import Util.Utils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author paradisc
 */
public class IhmPrincipale {

    /**
     * @param args the command line arguments
     */
    private final JFrame window;
    private VueAventurierDemo vueAventurier;
    private VueGrilleDemo vueGrille;
    private JPanel panelNorth;
    private JPanel panelGrille;
    private JPanel panelSouth;
    private Dimension dimension;

    public IhmPrincipale(VueAventurierDemo vueAventurier1, VueGrilleDemo vueGrille1) {
        setVueAventurier(vueAventurier1);
        setVueGrille(vueGrille1);

        window = new JFrame();
        window.setSize(1000, 1000);
        dimension = window.getSize();
        window.setLayout(new BorderLayout());

        panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setSize((int) dimension.getWidth(), (int)(dimension.getHeight() * 0.1));
        panelNorth.add(new JLabel("Tour du joueur " + this.vueAventurier.getNomJoueur()));

        panelGrille = new JPanel();
       
        panelGrille.add(vueGrille.getPlateauTuiles());
        panelGrille.setSize((int) dimension.getWidth(), (int)(dimension.getHeight() * 0.7));
        System.out.println("Panel Grille ::::" + panelGrille.getSize());
        vueGrille.getDimension().setSize(panelGrille.getSize());        
        
        
        /*panelGrille.setSize(vueGrille.getDimension().getSize());
        System.out.println("Panel Grille :" + panelGrille.getSize());
        System.out.println("Panel Plateau  :" + vueGrille.getDimension().getSize());*/
         

        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(3, 3));
        panelSouth.setSize((int) dimension.getWidth(), (int)(dimension.getHeight() * 0.2));
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
        window.add(panelGrille, BorderLayout.CENTER);
        window.add(panelSouth, BorderLayout.SOUTH);
        
        System.out.println("jnrjgkej enjkgrbejkgberjkgbjk"+panelGrille.getSize());

    }

    public IhmPrincipale(VueAventurierDemo vueJoueur1, Grille grilleDeJeu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        /*CarteAventurier carte = new CarteAventurier(NomAventurier.explorateur, Couleur.bleu);
        //Création d'une vue aventurier de nom Test1 avec la carte et le pion
        VueAventurierDemo vueAventurier1 = new VueAventurierDemo("Test1", carte, Utils.Pion.BLEU.getCouleur());
        Grille grille = new Grille();
        VueGrilleDemo vueGrille = new VueGrilleDemo(grille);
        
        IhmPrincipale ihm1 = new IhmPrincipale(vueAventurier1,vueGrille);*/
 /*ihm1.getWindow().setVisible(true);*/

    }

}
