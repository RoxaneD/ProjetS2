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
    private Grille grille;
    private ArrayList<Tuile> tuiles;
    private HashMap<Tuile, JButton> boutons = new HashMap<>();
    private ImageContainerCalques LePontDesAbimes;
    private ImageContainerCalques LaPorteDeBronze;
    private ImageContainerCalques LaCaverneDesOmbres;
    private ImageContainerCalques LaPorteDeFer;
    private ImageContainerCalques LaPortedOr;
    private ImageContainerCalques LesFalaisesDeLOubli;
    private ImageContainerCalques LePalaisDeCorail;
    private ImageContainerCalques LaPortedArgent;
    private ImageContainerCalques LesDunesDeLillusion;
    private ImageContainerCalques Heliport;
    private ImageContainerCalques LaPorteDeCuivre;
    private ImageContainerCalques LeJardinDesHurlements;
    private ImageContainerCalques LaForetPourpre;
    private ImageContainerCalques LeLagonPerdu;
    private ImageContainerCalques LeMaraisBrumeux;
    private ImageContainerCalques Observatoire;
    private ImageContainerCalques LeRocherFantome;
    private ImageContainerCalques LaCaverneDuBrasier;
    private ImageContainerCalques LeTempleDuSoleil;
    private ImageContainerCalques LeTempleDeLaLune;
    private ImageContainerCalques LePalaisDesMarees;
    private ImageContainerCalques LeValDuCrepuscule;
    private ImageContainerCalques LaTourDuGuet;
    private ImageContainerCalques LeJardinDesMurmures;

    public IhmGrille(Grille grille) {
        setGrille(grille);
        this.tuiles = grille.getTuiles();
        this.setLayout(new GridLayout(6, 6, 5, 5));
        String imgFolder = System.getProperty("user.dir") + "/src/Image/";

        for (Tuile tuile : tuiles) {
            if (tuile.getNom() == null) {
                this.add(new JLabel(""));
            } else if (tuile.getNom() == NomTuile.LePontDesAbimes) {
                boutons.put(tuile, new JButton());
                LePontDesAbimes = new ImageContainerCalques(imgFolder + "LePontDesAbimes.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LePontDesAbimes);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.Heliport) {
                boutons.put(tuile, new JButton());
                Heliport = new ImageContainerCalques(imgFolder + "Heliport.png", 0, 0, 160, 140);
                boutons.get(tuile).add(Heliport);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LaCaverneDesOmbres) {
                boutons.put(tuile, new JButton());
                LaCaverneDesOmbres = new ImageContainerCalques(imgFolder + "LaCaverneDesOmbres.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LaCaverneDesOmbres);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LaCaverneDuBrasier) {
                boutons.put(tuile, new JButton());
                LaCaverneDuBrasier = new ImageContainerCalques(imgFolder + "LaCaverneDuBrasier.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LaCaverneDuBrasier);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LaForetPourpre) {
                boutons.put(tuile, new JButton());
                LaForetPourpre = new ImageContainerCalques(imgFolder + "LaForetPourpre.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LaForetPourpre);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LaPorteDeBronze) {
                boutons.put(tuile, new JButton());
                LaPorteDeBronze = new ImageContainerCalques(imgFolder + "LaPorteDeBronze.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LaPorteDeBronze);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LaPorteDeCuivre) {
                boutons.put(tuile, new JButton());
                LaPorteDeCuivre = new ImageContainerCalques(imgFolder + "LaPorteDeCuivre.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LaPorteDeCuivre);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LaPorteDeFer) {
                boutons.put(tuile, new JButton());
                LaPorteDeFer = new ImageContainerCalques(imgFolder + "LaPorteDeFer.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LaPorteDeFer);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LaPortedArgent) {
                boutons.put(tuile, new JButton());
                LaPortedArgent = new ImageContainerCalques(imgFolder + "LaPortedArgent.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LaPortedArgent);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LaPortedOr) {
                boutons.put(tuile, new JButton());
                LaPortedOr = new ImageContainerCalques(imgFolder + "LaPortedOr.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LaPortedOr);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LaTourDuGuet) {
                boutons.put(tuile, new JButton());
                LaTourDuGuet = new ImageContainerCalques(imgFolder + "LaTourDuGuet.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LaTourDuGuet);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LeJardinDesHurlements) {
                boutons.put(tuile, new JButton());
                LeJardinDesHurlements = new ImageContainerCalques(imgFolder + "LeJardinDesHurlements.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LeJardinDesHurlements);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LeJardinDesMurmures) {
                boutons.put(tuile, new JButton());
                LeJardinDesMurmures = new ImageContainerCalques(imgFolder + "LeJardinDesMurmures.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LeJardinDesMurmures);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LeLagonPerdu) {
                boutons.put(tuile, new JButton());
                LeLagonPerdu = new ImageContainerCalques(imgFolder + "LeLagonPerdu.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LeLagonPerdu);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LeMaraisBrumeux) {
                boutons.put(tuile, new JButton());
                LeMaraisBrumeux = new ImageContainerCalques(imgFolder + "LeMaraisBrumeux.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LeMaraisBrumeux);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LePalaisDeCorail) {
                boutons.put(tuile, new JButton());
                LePalaisDeCorail = new ImageContainerCalques(imgFolder + "LePalaisDeCorail.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LePalaisDeCorail);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LePalaisDesMarees) {
                boutons.put(tuile, new JButton());
                LePalaisDesMarees = new ImageContainerCalques(imgFolder + "LePalaisDesMarees.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LePalaisDesMarees);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LeRocherFantome) {
                boutons.put(tuile, new JButton());
                LeRocherFantome = new ImageContainerCalques(imgFolder + "LeRocherFantome.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LeRocherFantome);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LeTempleDeLaLune) {
                boutons.put(tuile, new JButton());
                LeTempleDeLaLune = new ImageContainerCalques(imgFolder + "LeTempleDeLaLune.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LeTempleDeLaLune);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LeTempleDuSoleil) {
                boutons.put(tuile, new JButton());
                LeTempleDuSoleil = new ImageContainerCalques(imgFolder + "LeTempleDuSoleil.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LeTempleDuSoleil);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LeValDuCrepuscule) {
                boutons.put(tuile, new JButton());
                LeValDuCrepuscule = new ImageContainerCalques(imgFolder + "LeValDuCrepuscule.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LeValDuCrepuscule);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LesDunesDeLillusion) {
                boutons.put(tuile, new JButton());
                LesDunesDeLillusion = new ImageContainerCalques(imgFolder + "LesDunesDeLillusion.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LesDunesDeLillusion);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.LesFalaisesDeLOubli) {
                boutons.put(tuile, new JButton());
                LesFalaisesDeLOubli = new ImageContainerCalques(imgFolder + "LesFalaisesDeLOubli.png", 0, 0, 160, 140);
                boutons.get(tuile).add(LesFalaisesDeLOubli);
                this.add(boutons.get(tuile));
            } else if (tuile.getNom() == NomTuile.Observatoire) {
                boutons.put(tuile, new JButton());
                Observatoire = new ImageContainerCalques(imgFolder + "Observatoire.png", 0, 0, 160, 140);
                boutons.get(tuile).add(Observatoire);
                this.add(boutons.get(tuile));
            }
        }

        //this.repaint();
    }

    /*public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.LePontDesAbimes != null) {
            this.LePontDesAbimes.paintComponent(g);
        }
       
    }*/
    public static void main(String[] args) {

    }

    //Getteur
    public Grille getGrille() {
        return grille;
    }

    //Setteur
    public void setGrille(Grille grille) {
        this.grille = grille;
    }

}
