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
import Enumerations.EtatTuile;
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
                if (tuile.getEtat() == EtatTuile.normal) {
                    LePontDesAbimes = new ImageContainerCalques(imgFolder + "LePontDesAbimes.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LePontDesAbimes);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LePontDesAbimes = new ImageContainerCalques(imgFolder + "LePontDesAbimes_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LePontDesAbimes);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }

            } else if (tuile.getNom() == NomTuile.Heliport) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    Heliport = new ImageContainerCalques(imgFolder + "Heliport.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(Heliport);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    Heliport = new ImageContainerCalques(imgFolder + "Heliport_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(Heliport);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
                
            } else if (tuile.getNom() == NomTuile.LaCaverneDesOmbres) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaCaverneDesOmbres = new ImageContainerCalques(imgFolder + "LaCaverneDesOmbres.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaCaverneDesOmbres);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaCaverneDesOmbres = new ImageContainerCalques(imgFolder + "LaCaverneDesOmbres_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaCaverneDesOmbres);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
                
            } else if (tuile.getNom() == NomTuile.LaCaverneDuBrasier) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaCaverneDuBrasier = new ImageContainerCalques(imgFolder + "LaCaverneDuBrasier.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaCaverneDuBrasier);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaCaverneDuBrasier = new ImageContainerCalques(imgFolder + "LaCaverneDuBrasier_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaCaverneDuBrasier);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
               
            } else if (tuile.getNom() == NomTuile.LaForetPourpre) {
                 if (tuile.getEtat() == EtatTuile.normal) {
                    LaForetPourpre = new ImageContainerCalques(imgFolder + "LaForetPourpre.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaForetPourpre);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaForetPourpre = new ImageContainerCalques(imgFolder + "LaForetPourpre_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaForetPourpre);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
               
            } else if (tuile.getNom() == NomTuile.LaPorteDeBronze) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaPorteDeBronze = new ImageContainerCalques(imgFolder + "LaPorteDeBronze.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaPorteDeBronze);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaPorteDeBronze = new ImageContainerCalques(imgFolder + "LaPorteDeBronze_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaPorteDeBronze);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                } 
               
            } else if (tuile.getNom() == NomTuile.LaPorteDeCuivre) {
               if (tuile.getEtat() == EtatTuile.normal) {
                    LaPorteDeCuivre = new ImageContainerCalques(imgFolder + "LaPorteDeCuivre.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaPorteDeCuivre);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaPorteDeCuivre = new ImageContainerCalques(imgFolder + "LaPorteDeCuivre_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaPorteDeCuivre);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                } 
               
            } else if (tuile.getNom() == NomTuile.LaPorteDeFer) {
               if (tuile.getEtat() == EtatTuile.normal) {
                    LaPorteDeFer = new ImageContainerCalques(imgFolder + "LaPorteDeFer.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaPorteDeFer);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaPorteDeFer = new ImageContainerCalques(imgFolder + "LaPorteDeFer_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaPorteDeFer);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                } 
               
            } else if (tuile.getNom() == NomTuile.LaPortedArgent) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaPortedArgent = new ImageContainerCalques(imgFolder + "LaPortedArgent.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaPortedArgent);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaPortedArgent = new ImageContainerCalques(imgFolder + "LaPortedArgent_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaPortedArgent);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                } 
                
            } else if (tuile.getNom() == NomTuile.LaPortedOr) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaPortedOr = new ImageContainerCalques(imgFolder + "LaPortedOr.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaPortedOr);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaPortedOr = new ImageContainerCalques(imgFolder + "LaPortedOr_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaPortedOr);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                } 
                
            } else if (tuile.getNom() == NomTuile.LaTourDuGuet) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaTourDuGuet = new ImageContainerCalques(imgFolder + "LaTourDuGuet.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaTourDuGuet);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaTourDuGuet = new ImageContainerCalques(imgFolder + "LaTourDuGuet_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LaTourDuGuet);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                } 
                
            } else if (tuile.getNom() == NomTuile.LeJardinDesHurlements) {
               if (tuile.getEtat() == EtatTuile.normal) {
                    LeJardinDesHurlements = new ImageContainerCalques(imgFolder + "LeJardinDesHurlements.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeJardinDesHurlements);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeJardinDesHurlements = new ImageContainerCalques(imgFolder + "LeJardinDesHurlements_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeJardinDesHurlements);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                } 
               
            } else if (tuile.getNom() == NomTuile.LeJardinDesMurmures) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LeJardinDesMurmures = new ImageContainerCalques(imgFolder + "LeJardinDesMurmures.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeJardinDesMurmures);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeJardinDesMurmures = new ImageContainerCalques(imgFolder + "LeJardinDesMurmures_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeJardinDesMurmures);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                } 
                
            } else if (tuile.getNom() == NomTuile.LeLagonPerdu) {
               if (tuile.getEtat() == EtatTuile.normal) {
                    LeLagonPerdu = new ImageContainerCalques(imgFolder + "LeLagonPerdu.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeLagonPerdu);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeLagonPerdu = new ImageContainerCalques(imgFolder + "LeLagonPerdu_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeLagonPerdu);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                } 
               
            } else if (tuile.getNom() == NomTuile.LeMaraisBrumeux) {
               if (tuile.getEtat() == EtatTuile.normal) {
                    LeMaraisBrumeux = new ImageContainerCalques(imgFolder + "LeMaraisBrumeux.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeMaraisBrumeux);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeMaraisBrumeux = new ImageContainerCalques(imgFolder + "LeMaraisBrumeux_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeMaraisBrumeux);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                } 
               
            } else if (tuile.getNom() == NomTuile.LePalaisDeCorail) {
               if (tuile.getEtat() == EtatTuile.normal) {
                    LePalaisDeCorail = new ImageContainerCalques(imgFolder + "LePalaisDeCorail.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LePalaisDeCorail);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LePalaisDeCorail = new ImageContainerCalques(imgFolder + "LePalaisDeCorail_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LePalaisDeCorail);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
               
            } else if (tuile.getNom() == NomTuile.LePalaisDesMarees) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LePalaisDesMarees = new ImageContainerCalques(imgFolder + "LePalaisDesMarees.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LePalaisDesMarees);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LePalaisDesMarees = new ImageContainerCalques(imgFolder + "LePalaisDesMarees_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LePalaisDesMarees);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
                
            } else if (tuile.getNom() == NomTuile.LeRocherFantome) {
                 if (tuile.getEtat() == EtatTuile.normal) {
                    LeRocherFantome = new ImageContainerCalques(imgFolder + "LeRocherFantome.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeRocherFantome);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeRocherFantome = new ImageContainerCalques(imgFolder + "LeRocherFantome_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeRocherFantome);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
                 
            } else if (tuile.getNom() == NomTuile.LeTempleDeLaLune) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LeTempleDeLaLune = new ImageContainerCalques(imgFolder + "LeTempleDeLaLune.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeTempleDeLaLune);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeTempleDeLaLune = new ImageContainerCalques(imgFolder + "LeTempleDeLaLune_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeTempleDeLaLune);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
                
            } else if (tuile.getNom() == NomTuile.LeTempleDuSoleil) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LeTempleDuSoleil = new ImageContainerCalques(imgFolder + "LeTempleDuSoleil.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeTempleDuSoleil);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeTempleDuSoleil = new ImageContainerCalques(imgFolder + "LeTempleDuSoleil_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeTempleDuSoleil);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
                
            } else if (tuile.getNom() == NomTuile.LeValDuCrepuscule) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LeValDuCrepuscule = new ImageContainerCalques(imgFolder + "LeValDuCrepuscule.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeValDuCrepuscule);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeValDuCrepuscule = new ImageContainerCalques(imgFolder + "LeValDuCrepuscule_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LeValDuCrepuscule);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
                
            } else if (tuile.getNom() == NomTuile.LesDunesDeLillusion) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LesDunesDeLillusion = new ImageContainerCalques(imgFolder + "LesDunesDeLillusion.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LesDunesDeLillusion);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LesDunesDeLillusion = new ImageContainerCalques(imgFolder + "LesDunesDeLillusion_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LesDunesDeLillusion);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
                
            } else if (tuile.getNom() == NomTuile.LesFalaisesDeLOubli) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LesFalaisesDeLOubli = new ImageContainerCalques(imgFolder + "LesFalaisesDeLOubli.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LesFalaisesDeLOubli);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LesFalaisesDeLOubli = new ImageContainerCalques(imgFolder + "LesFalaisesDeLOubli_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(LesFalaisesDeLOubli);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
                
            } else if (tuile.getNom() == NomTuile.Observatoire) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    Observatoire = new ImageContainerCalques(imgFolder + "Observatoire.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(Observatoire);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    Observatoire = new ImageContainerCalques(imgFolder + "Observatoire_inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(Observatoire);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
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
