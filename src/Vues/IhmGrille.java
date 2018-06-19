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
    private String imgFolder = System.getProperty("user.dir") + "/src/Image/";
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
        System.out.println("test1");
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
                    LePontDesAbimes = new ImageContainerCalques(imgFolder + "LePontDesAbimes_Inonde.png", 0, 0, 160, 140);
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
                    Heliport = new ImageContainerCalques(imgFolder + "Heliport_Inonde.png", 0, 0, 160, 140);
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
                    LaCaverneDesOmbres = new ImageContainerCalques(imgFolder + "LaCaverneDesOmbres_Inonde.png", 0, 0, 160, 140);
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
                    LaCaverneDuBrasier = new ImageContainerCalques(imgFolder + "LaCaverneDuBrasier_Inonde.png", 0, 0, 160, 140);
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
                    LaForetPourpre = new ImageContainerCalques(imgFolder + "LaForetPourpre_Inonde.png", 0, 0, 160, 140);
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
                    LaPorteDeBronze = new ImageContainerCalques(imgFolder + "LaPorteDeBronze_Inonde.png", 0, 0, 160, 140);
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
                    LaPorteDeCuivre = new ImageContainerCalques(imgFolder + "LaPorteDeCuivre_Inonde.png", 0, 0, 160, 140);
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
                    LaPorteDeFer = new ImageContainerCalques(imgFolder + "LaPorteDeFer_Inonde.png", 0, 0, 160, 140);
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
                    LaPortedArgent = new ImageContainerCalques(imgFolder + "LaPortedArgent_Inonde.png", 0, 0, 160, 140);
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
                    LaPortedOr = new ImageContainerCalques(imgFolder + "LaPortedOr_Inonde.png", 0, 0, 160, 140);
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
                    LaTourDuGuet = new ImageContainerCalques(imgFolder + "LaTourDuGuet_Inonde.png", 0, 0, 160, 140);
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
                    LeJardinDesHurlements = new ImageContainerCalques(imgFolder + "LeJardinDesHurlements_Inonde.png", 0, 0, 160, 140);
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
                    LeJardinDesMurmures = new ImageContainerCalques(imgFolder + "LeJardinDesMurmures_Inonde.png", 0, 0, 160, 140);
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
                    LeLagonPerdu = new ImageContainerCalques(imgFolder + "LeLagonPerdu_Inonde.png", 0, 0, 160, 140);
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
                    LeMaraisBrumeux = new ImageContainerCalques(imgFolder + "LeMaraisBrumeux_Inonde.png", 0, 0, 160, 140);
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
                    LePalaisDeCorail = new ImageContainerCalques(imgFolder + "LePalaisDeCorail_Inonde.png", 0, 0, 160, 140);
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
                    LePalaisDesMarees = new ImageContainerCalques(imgFolder + "LePalaisDesMarees_Inonde.png", 0, 0, 160, 140);
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
                    LeRocherFantome = new ImageContainerCalques(imgFolder + "LeRocherFantome_Inonde.png", 0, 0, 160, 140);
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
                    LeTempleDeLaLune = new ImageContainerCalques(imgFolder + "LeTempleDeLaLune_Inonde.png", 0, 0, 160, 140);
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
                    LeTempleDuSoleil = new ImageContainerCalques(imgFolder + "LeTempleDuSoleil_Inonde.png", 0, 0, 160, 140);
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
                    LeValDuCrepuscule = new ImageContainerCalques(imgFolder + "LeValDuCrepuscule_Inonde.png", 0, 0, 160, 140);
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
                    LesDunesDeLillusion = new ImageContainerCalques(imgFolder + "LesDunesDeLillusion_Inonde.png", 0, 0, 160, 140);
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
                    LesFalaisesDeLOubli = new ImageContainerCalques(imgFolder + "LesFalaisesDeLOubli_Inonde.png", 0, 0, 160, 140);
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
                    Observatoire = new ImageContainerCalques(imgFolder + "Observatoire_Inonde.png", 0, 0, 160, 140);
                    boutons.put(tuile, new JButton());
                    boutons.get(tuile).add(Observatoire);
                    this.add(boutons.get(tuile));
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    this.add(new JLabel(""));
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        System.out.println("test2");

        for (Tuile tuile : tuiles) {
            if (tuile.getNom() == null) {
                this.add(new JLabel(""));
            } else if (tuile.getNom() == NomTuile.LePontDesAbimes) {

                if (tuile.getEtat() == EtatTuile.normal) {
                    LePontDesAbimes = new ImageContainerCalques(imgFolder + "LePontDesAbimes.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LePontDesAbimes);
                    boutons.get(tuile).add(LePontDesAbimes);
                   
                    

                   /* this.remove(boutons.get(tuile));
                    this.add(boutons.get(tuile));*/

                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LePontDesAbimes = new ImageContainerCalques(imgFolder + "LePontDesAbimes_Inonde.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LePontDesAbimes);
                    boutons.get(tuile).add(LePontDesAbimes);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        //this.add(new JLabel(""));
                    }

                }
            } else if (tuile.getNom() == NomTuile.Heliport) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    Heliport = new ImageContainerCalques(imgFolder + "Heliport.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(Heliport);
                    boutons.get(tuile).add(Heliport);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    Heliport = new ImageContainerCalques(imgFolder + "Heliport_Inonde.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(Heliport);
                    boutons.get(tuile).add(Heliport);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        // this.add(new JLabel(""));
                    }//this.remove(boutons.get(tuile));
                }
            } else if (tuile.getNom() == NomTuile.LaCaverneDesOmbres) {

                if (tuile.getEtat() == EtatTuile.normal) {
                    LaCaverneDesOmbres = new ImageContainerCalques(imgFolder + "LaCaverneDesOmbres.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LaCaverneDesOmbres);
                    boutons.get(tuile).add(LaCaverneDesOmbres);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaCaverneDesOmbres = new ImageContainerCalques(imgFolder + "LaCaverneDesOmbres_Inonde.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LaCaverneDesOmbres);
                    boutons.get(tuile).add(LaCaverneDesOmbres);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    //this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        // this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LaCaverneDuBrasier) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaCaverneDuBrasier = new ImageContainerCalques(imgFolder + "LaCaverneDuBrasier.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LaCaverneDuBrasier);
                    boutons.get(tuile).add(LaCaverneDuBrasier);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaCaverneDuBrasier = new ImageContainerCalques(imgFolder + "LaCaverneDuBrasier_Inonde.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LaCaverneDuBrasier);
                    boutons.get(tuile).add(LaCaverneDuBrasier);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        // this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LaForetPourpre) {

                if (tuile.getEtat() == EtatTuile.normal) {
                    LaForetPourpre = new ImageContainerCalques(imgFolder + "LaForetPourpre.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LaForetPourpre);
                    boutons.get(tuile).add(LaForetPourpre);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaForetPourpre = new ImageContainerCalques(imgFolder + "LaForetPourpre_Inonde.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LaForetPourpre);
                    boutons.get(tuile).add(LaForetPourpre);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        // this.add(new JLabel(""));
                    }

                }
            } else if (tuile.getNom() == NomTuile.LaPorteDeBronze) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaPorteDeBronze = new ImageContainerCalques(imgFolder + "LaPorteDeBronze.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LaPorteDeBronze);
                    boutons.get(tuile).add(LaPorteDeBronze);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaPorteDeBronze = new ImageContainerCalques(imgFolder + "LaPorteDeBronze_Inonde.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LaPorteDeBronze);
                    boutons.get(tuile).add(LaPorteDeBronze);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    // this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        // this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LaPorteDeCuivre) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaPorteDeCuivre = new ImageContainerCalques(imgFolder + "LaPorteDeCuivre.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LaPorteDeCuivre);
                    boutons.get(tuile).add(LaPorteDeCuivre);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaPorteDeCuivre = new ImageContainerCalques(imgFolder + "LaPorteDeCuivre_Inonde.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LaPorteDeCuivre);
                    boutons.get(tuile).add(LaPorteDeCuivre);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    //this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        // this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LaPorteDeFer) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaPorteDeFer = new ImageContainerCalques(imgFolder + "LaPorteDeFer.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LaPorteDeFer);
                    boutons.get(tuile).add(LaPorteDeFer);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaPorteDeFer = new ImageContainerCalques(imgFolder + "LaPorteDeFer_Inonde.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LaPorteDeFer);
                    boutons.get(tuile).add(LaPorteDeFer);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    // this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        // this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LaPortedArgent) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaPortedArgent = new ImageContainerCalques(imgFolder + "LaPortedArgent.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LaPortedArgent);
                    boutons.get(tuile).add(LaPortedArgent);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaPortedArgent = new ImageContainerCalques(imgFolder + "LaPortedArgent_Inonde.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LaPortedArgent);
                    boutons.get(tuile).add(LaPortedArgent);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    // this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        // this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LaPortedOr) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaPortedOr = new ImageContainerCalques(imgFolder + "LaPortedOr.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LaPortedOr);
                    boutons.get(tuile).add(LaPortedOr);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaPortedOr = new ImageContainerCalques(imgFolder + "LaPortedOr_Inonde.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LaPortedOr);
                    boutons.get(tuile).add(LaPortedOr);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    //  this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        //this.add(new JLabel(""));
                    }

                }
            } else if (tuile.getNom() == NomTuile.LaTourDuGuet) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LaTourDuGuet = new ImageContainerCalques(imgFolder + "LaTourDuGuet.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LaTourDuGuet);
                    boutons.get(tuile).add(LaTourDuGuet);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LaTourDuGuet = new ImageContainerCalques(imgFolder + "LaTourDuGuet_Inonde.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LaTourDuGuet);
                    boutons.get(tuile).add(LaTourDuGuet);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        //this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LeJardinDesHurlements) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LeJardinDesHurlements = new ImageContainerCalques(imgFolder + "LeJardinDesHurlements.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LeJardinDesHurlements);
                    boutons.get(tuile).add(LeJardinDesHurlements);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeJardinDesHurlements = new ImageContainerCalques(imgFolder + "LeJardinDesHurlements_Inonde.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LeJardinDesHurlements);
                    boutons.get(tuile).add(LeJardinDesHurlements);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    //this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        //this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LeJardinDesMurmures) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LeJardinDesMurmures = new ImageContainerCalques(imgFolder + "LeJardinDesMurmures.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LeJardinDesMurmures);
                    boutons.get(tuile).add(LeJardinDesMurmures);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeJardinDesMurmures = new ImageContainerCalques(imgFolder + "LeJardinDesMurmures_Inonde.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LeJardinDesMurmures);
                    boutons.get(tuile).add(LeJardinDesMurmures);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    // this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        //this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LeLagonPerdu) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LeLagonPerdu = new ImageContainerCalques(imgFolder + "LeLagonPerdu.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LeLagonPerdu);
                    boutons.get(tuile).add(LeLagonPerdu);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeLagonPerdu = new ImageContainerCalques(imgFolder + "LeLagonPerdu_Inonde.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LeLagonPerdu);
                    boutons.get(tuile).add(LeLagonPerdu);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    // this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        //this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LeMaraisBrumeux) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LeMaraisBrumeux = new ImageContainerCalques(imgFolder + "LeMaraisBrumeux.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LeMaraisBrumeux);
                    boutons.get(tuile).add(LeMaraisBrumeux);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeMaraisBrumeux = new ImageContainerCalques(imgFolder + "LeMaraisBrumeux_Inonde.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LeMaraisBrumeux);
                    boutons.get(tuile).add(LeMaraisBrumeux);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    //this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        //this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LePalaisDeCorail) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LePalaisDeCorail = new ImageContainerCalques(imgFolder + "LePalaisDeCorail.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LePalaisDeCorail);
                    boutons.get(tuile).add(LePalaisDeCorail);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LePalaisDeCorail = new ImageContainerCalques(imgFolder + "LePalaisDeCorail_Inonde.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LePalaisDeCorail);
                    boutons.get(tuile).add(LePalaisDeCorail);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    //this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        // this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LePalaisDesMarees) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LePalaisDesMarees = new ImageContainerCalques(imgFolder + "LePalaisDesMarees.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LePalaisDesMarees);
                    boutons.get(tuile).add(LePalaisDesMarees);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LePalaisDesMarees = new ImageContainerCalques(imgFolder + "LePalaisDesMarees_Inonde.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LePalaisDesMarees);
                    boutons.get(tuile).add(LePalaisDesMarees);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    //this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        // this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LeRocherFantome) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LeRocherFantome = new ImageContainerCalques(imgFolder + "LeRocherFantome.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LeRocherFantome);
                    boutons.get(tuile).add(LeRocherFantome);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeRocherFantome = new ImageContainerCalques(imgFolder + "LeRocherFantome_Inonde.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LeRocherFantome);
                    boutons.get(tuile).add(LeRocherFantome);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    // this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        //this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LeTempleDeLaLune) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LeTempleDeLaLune = new ImageContainerCalques(imgFolder + "LeTempleDeLaLune.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LeTempleDeLaLune);
                    boutons.get(tuile).add(LeTempleDeLaLune);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeTempleDeLaLune = new ImageContainerCalques(imgFolder + "LeTempleDeLaLune_Inonde.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LeTempleDeLaLune);
                    boutons.get(tuile).add(LeTempleDeLaLune);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    //this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        //  this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LeTempleDuSoleil) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LeTempleDuSoleil = new ImageContainerCalques(imgFolder + "LeTempleDuSoleil.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LeTempleDuSoleil);
                    boutons.get(tuile).add(LeTempleDuSoleil);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeTempleDuSoleil = new ImageContainerCalques(imgFolder + "LeTempleDuSoleil_Inonde.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LeTempleDuSoleil);
                    boutons.get(tuile).add(LeTempleDuSoleil);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    // this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        //  this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LeValDuCrepuscule) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LeValDuCrepuscule = new ImageContainerCalques(imgFolder + "LeValDuCrepuscule.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(LeValDuCrepuscule);
                    boutons.get(tuile).add(LeValDuCrepuscule);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LeValDuCrepuscule = new ImageContainerCalques(imgFolder + "LeValDuCrepuscule_Inonde.png", 0, 0, 160, 140);
                  boutons.get(tuile).remove(LeValDuCrepuscule);
                    boutons.get(tuile).add(LeValDuCrepuscule);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    //this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        //this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LesDunesDeLillusion) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LesDunesDeLillusion = new ImageContainerCalques(imgFolder + "LesDunesDeLillusion.png", 0, 0, 160, 140);
                   
                   boutons.get(tuile).remove(LesDunesDeLillusion);
                    boutons.get(tuile).add(LesDunesDeLillusion);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LesDunesDeLillusion = new ImageContainerCalques(imgFolder + "LesDunesDeLillusion_Inonde.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LesDunesDeLillusion);
                    boutons.get(tuile).add(LesDunesDeLillusion);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        // this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.LesFalaisesDeLOubli) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    LesFalaisesDeLOubli = new ImageContainerCalques(imgFolder + "LesFalaisesDeLOubli.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LesFalaisesDeLOubli);
                    boutons.get(tuile).add(LesFalaisesDeLOubli);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    LesFalaisesDeLOubli = new ImageContainerCalques(imgFolder + "LesFalaisesDeLOubli_Inonde.png", 0, 0, 160, 140);
                   boutons.get(tuile).remove(LesFalaisesDeLOubli);
                    boutons.get(tuile).add(LesFalaisesDeLOubli);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    // this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        //  this.add(new JLabel(""));
                    }
                }
            } else if (tuile.getNom() == NomTuile.Observatoire) {
                if (tuile.getEtat() == EtatTuile.normal) {
                    Observatoire = new ImageContainerCalques(imgFolder + "Observatoire.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(Observatoire);
                    boutons.get(tuile).add(Observatoire);
                } else if (tuile.getEtat() == EtatTuile.inondee) {
                    Observatoire = new ImageContainerCalques(imgFolder + "Observatoire_Inonde.png", 0, 0, 160, 140);
                    boutons.get(tuile).remove(Observatoire);
                    boutons.get(tuile).add(Observatoire);
                } else if (tuile.getEtat() == EtatTuile.submergee) {
                    // this.remove(boutons.get(tuile));
                    if (boutons.get(tuile) != null) {
                        this.remove(boutons.get(tuile));
                        this.add(new JLabel(""));
                    } else {
                        // this.add(new JLabel(""));
                    }
                }
            }
        }
    }

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
