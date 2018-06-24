package Vues;

import Aventuriers.Aventurier;
import Controle.Action;
import Controle.Observateur;
import Controle.TypesActions;
import Demo.ImageContainerCalques;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import ElementsJeu.Grille;
import ElementsJeu.Tresor;
import ElementsJeu.Tuile;
import Enumerations.EtatTresor;
import Enumerations.EtatTuile;
import Enumerations.NomAventurier;
import Enumerations.NomTresor;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IhmGrille extends JPanel implements Observe {

    // doit contenir : les tuiles -> Pas de nom et de couleur, mais l'image associée (en fonction de asseché/innondé)
    //                            -> l'emplacement des trésors (image)
    //                            -> l'emplacement des aventuriers (pendant la partie)
    // 
    private Observateur observateur;

    private Grille grille;
    private ArrayList<Tuile> tuiles;
    private HashMap<Tuile, JButtonImage> boutons = new HashMap<>();
    private HashMap<Tuile, JLabel> tuileInexistante = new HashMap<>();
    private ArrayList<Tresor> tresors = new ArrayList<>();
    private String imgFolder = System.getProperty("user.dir") + "/src/Image/";
    private ArrayList<Aventurier> aventuriers;
    private Image image;
    private ImageContainerCalques imageTuile;

    private ArrayList<JButtonImage> listBouton = new ArrayList<>();
    private ArrayList<JLabel> listLabel = new ArrayList<>();

    private boolean initialise = false;

    public IhmGrille(Grille grille, ArrayList<Aventurier> aventuriers, ArrayList<Tresor> tresors) {

        setTresors(tresors);

        setAventuriers(aventuriers);

        setGrille(grille);

        this.tuiles = grille.getTuiles();
        this.setLayout(new GridLayout(6, 6, 5, 5));

        JButtonImage bouton11 = new JButtonImage();
        JButtonImage bouton12 = new JButtonImage();
        JButtonImage bouton13 = new JButtonImage();
        JButtonImage bouton14 = new JButtonImage();
        JButtonImage bouton15 = new JButtonImage();
        JButtonImage bouton16 = new JButtonImage();
        JButtonImage bouton21 = new JButtonImage();
        JButtonImage bouton22 = new JButtonImage();
        JButtonImage bouton23 = new JButtonImage();
        JButtonImage bouton24 = new JButtonImage();
        JButtonImage bouton25 = new JButtonImage();
        JButtonImage bouton26 = new JButtonImage();
        JButtonImage bouton31 = new JButtonImage();
        JButtonImage bouton32 = new JButtonImage();
        JButtonImage bouton33 = new JButtonImage();
        JButtonImage bouton34 = new JButtonImage();
        JButtonImage bouton35 = new JButtonImage();
        JButtonImage bouton36 = new JButtonImage();
        JButtonImage bouton41 = new JButtonImage();
        JButtonImage bouton42 = new JButtonImage();
        JButtonImage bouton43 = new JButtonImage();
        JButtonImage bouton44 = new JButtonImage();
        JButtonImage bouton45 = new JButtonImage();
        JButtonImage bouton46 = new JButtonImage();
        JButtonImage bouton51 = new JButtonImage();
        JButtonImage bouton52 = new JButtonImage();
        JButtonImage bouton53 = new JButtonImage();
        JButtonImage bouton54 = new JButtonImage();
        JButtonImage bouton55 = new JButtonImage();
        JButtonImage bouton56 = new JButtonImage();
        JButtonImage bouton61 = new JButtonImage();
        JButtonImage bouton62 = new JButtonImage();
        JButtonImage bouton63 = new JButtonImage();
        JButtonImage bouton64 = new JButtonImage();
        JButtonImage bouton65 = new JButtonImage();
        JButtonImage bouton66 = new JButtonImage();

        listBouton.add(bouton11);
        listBouton.add(bouton12);
        listBouton.add(bouton13);
        listBouton.add(bouton14);
        listBouton.add(bouton15);
        listBouton.add(bouton16);
        listBouton.add(bouton21);
        listBouton.add(bouton22);
        listBouton.add(bouton23);
        listBouton.add(bouton24);
        listBouton.add(bouton25);
        listBouton.add(bouton26);
        listBouton.add(bouton31);
        listBouton.add(bouton32);
        listBouton.add(bouton33);
        listBouton.add(bouton34);
        listBouton.add(bouton35);
        listBouton.add(bouton36);
        listBouton.add(bouton41);
        listBouton.add(bouton42);
        listBouton.add(bouton43);
        listBouton.add(bouton44);
        listBouton.add(bouton45);
        listBouton.add(bouton46);
        listBouton.add(bouton51);
        listBouton.add(bouton52);
        listBouton.add(bouton53);
        listBouton.add(bouton54);
        listBouton.add(bouton55);
        listBouton.add(bouton56);
        listBouton.add(bouton61);
        listBouton.add(bouton62);
        listBouton.add(bouton63);
        listBouton.add(bouton64);
        listBouton.add(bouton65);
        listBouton.add(bouton66);

        for (JButton b : listBouton) {
            b.setEnabled(false);
        }

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();
        JLabel label7 = new JLabel();
        JLabel label8 = new JLabel();
        JLabel label9 = new JLabel();
        JLabel label10 = new JLabel();
        JLabel label11 = new JLabel();
        JLabel label12 = new JLabel();
        JLabel label13 = new JLabel();
        JLabel label14 = new JLabel();
        JLabel label15 = new JLabel();
        JLabel label16 = new JLabel();
        JLabel label17 = new JLabel();
        JLabel label18 = new JLabel();
        JLabel label19 = new JLabel();
        JLabel label20 = new JLabel();
        JLabel label21 = new JLabel();
        JLabel label22 = new JLabel();
        JLabel label23 = new JLabel();
        JLabel label24 = new JLabel();
        JLabel label25 = new JLabel();
        JLabel label26 = new JLabel();
        JLabel label27 = new JLabel();
        JLabel label28 = new JLabel();
        JLabel label29 = new JLabel();
        JLabel label30 = new JLabel();
        JLabel label31 = new JLabel();
        JLabel label32 = new JLabel();
        JLabel label33 = new JLabel();
        JLabel label34 = new JLabel();
        JLabel label35 = new JLabel();
        JLabel label36 = new JLabel();

        listLabel.add(label1);
        listLabel.add(label2);
        listLabel.add(label3);
        listLabel.add(label4);
        listLabel.add(label5);
        listLabel.add(label6);
        listLabel.add(label7);
        listLabel.add(label8);
        listLabel.add(label9);
        listLabel.add(label10);
        listLabel.add(label11);
        listLabel.add(label12);
        listLabel.add(label13);
        listLabel.add(label14);
        listLabel.add(label15);
        listLabel.add(label16);
        listLabel.add(label17);
        listLabel.add(label18);
        listLabel.add(label19);
        listLabel.add(label20);
        listLabel.add(label21);
        listLabel.add(label22);
        listLabel.add(label23);
        listLabel.add(label24);
        listLabel.add(label25);
        listLabel.add(label26);
        listLabel.add(label27);
        listLabel.add(label28);
        listLabel.add(label29);
        listLabel.add(label30);
        listLabel.add(label31);
        listLabel.add(label32);
        listLabel.add(label33);
        listLabel.add(label34);
        listLabel.add(label35);
        listLabel.add(label36);
        repaint();
    }

    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;
    }

    public void setAventuriers(ArrayList<Aventurier> aventuriers) {
        this.aventuriers = new ArrayList<Aventurier>();
        for (Aventurier a : aventuriers) {
            this.aventuriers.add(a);
        }
    }

    public void setTresors(ArrayList<Tresor> tresors) {
        this.tresors = new ArrayList<Tresor>();
        for (Tresor t : tresors) {
            this.tresors.add(t);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        // on recommence
        int i = 0;
        int j = 0;
        this.tuiles = grille.getTuiles();

        // pour les trésors
        for (Tresor t : this.tresors) {
            if (t.getEtat() == EtatTresor.pasRecupere && t.getNom() == NomTresor.Calice) {
                try {
                    this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/calice.png"));
                } catch (IOException ex) {
                    System.err.println("Erreur de lecture de calice.png");
                }
                g.drawImage(image, 10, 10, 90, 120, null, this);
            } else if (t.getEtat() == EtatTresor.pasRecupere && t.getNom() == NomTresor.Zephyr) {
                try {
                    this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/zephyr.png"));
                } catch (IOException ex) {
                    System.err.println("Erreur de lecture de zephyr.png");
                }
                g.drawImage(image, 10, 620, 90, 120, null, this);
            } else if (t.getEtat() == EtatTresor.pasRecupere && t.getNom() == NomTresor.Cristal) {
                try {
                    this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/cristal.png"));
                } catch (IOException ex) {
                    System.err.println("Erreur de lecture de cristal.png");
                }
                g.drawImage(image, 780, 10, 90, 120, null, this);
            } else if (t.getEtat() == EtatTresor.pasRecupere && t.getNom() == NomTresor.Pierre) {
                try {
                    this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/pierre.png"));
                } catch (IOException ex) {
                    System.err.println("Erreur de lecture de pierre.png");
                }
                g.drawImage(image, 780, 620, 90, 120, null, this);
            }
        }

        // pour les tuiles et les pions
        for (Tuile tuile : tuiles) {
            if (tuile.getEtat() == EtatTuile.inexistante) {
                if (tuileInexistante.get(tuile) == null) {
                    tuileInexistante.put(tuile, listLabel.get(j));
                    this.add(listLabel.get(j));
                    j++;
                }
                if (boutons.get(tuile) != null) {
                    boutons.get(tuile).setOpaque(false);
                    boutons.get(tuile).setVisible(false);
                }
            } else if (tuile.getEtat() == EtatTuile.normal) {
                try {
                    this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/" + tuile.getNom().toString() + ".png"));
                } catch (IOException ex) {
                    System.err.println("Erreur de lecture de " + tuile.getNom().toString() + ".png");
                }
                if (boutons.get(tuile) == null) {
                    boutons.put(tuile, listBouton.get(i));
                    boutons.get(tuile).setImage(image);
                    boutons.get(tuile).repaint();
                    this.add(boutons.get(tuile));
                } else {
                    boutons.get(tuile).setImage(image);
                    boutons.get(tuile).repaint();
                }
            } else if (tuile.getEtat() == EtatTuile.inondee) {
                try {
                    this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/" + tuile.getNom().toString() + "_Inonde.png"));
                } catch (IOException ex) {
                    System.err.println("Erreur de lecture de" + tuile.getNom().toString() + "_Inonde.png");
                }
                if (boutons.put(tuile, listBouton.get(i)) == null) {
                    boutons.put(tuile, listBouton.get(i));
                    boutons.get(tuile).setImage(image);
                    boutons.get(tuile).repaint();
                    this.add(boutons.get(tuile));
                } else {
                    boutons.get(tuile).setImage(image);
                    boutons.get(tuile).repaint();
                }
            } else if (tuile.getEtat() == EtatTuile.submergee) {
                if (boutons.get(tuile) == null) {
                    boutons.put(tuile, listBouton.get(i));
                    boutons.get(tuile).setOpaque(false);
                    boutons.get(tuile).setEnabled(false);
                    boutons.get(tuile).setBorder(null);
                    boutons.get(tuile).setVisible(false);
                    this.add(listBouton.get(i));
                } else {
                    boutons.get(tuile).setEnabled(false);
                    boutons.get(tuile).setOpaque(false);
                    boutons.get(tuile).setVisible(false);
                    boutons.get(tuile).setBorder(null);
                    boutons.get(tuile).setImage(null);
                    this.add(listBouton.get(i));
                }
            }
            i++;
        }

        for (Tuile t : boutons.keySet()) {
            boutons.get(t).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (boutons.get(t).getBackground() == Color.RED) {
                        Action a = new Action(TypesActions.deplacement, t);
                        notifierObservateur(a);
                    } else if (boutons.get(t).getBackground() == Color.MAGENTA) {
                        Action a = new Action(TypesActions.assechement, t);
                        notifierObservateur(a);
                    }
                }
            });
        }
    }

    public void afficherTuilesPossiblesDeplacement(ArrayList<Tuile> t2) {
        revenirGrilleDepart();  //Appel de la méthode pour réinitialiser la grille
        for (Tuile tuile : t2) {
            boutons.get(tuile).setBackground(Color.RED);  //Mise à jour des tuiles en mettant un fond Rouge
            boutons.get(tuile).setOpaque(true);
            boutons.get(tuile).setEnabled(true);  //Rend les tuils actives
        }
        repaint();
    }

    public void afficherTuilesPossiblesAssechement(ArrayList<Tuile> t2) {
        revenirGrilleDepart();  //Appel de la méthode pour réinitialiser la grille
        for (Tuile tuile : t2) {
            boutons.get(tuile).setBackground(Color.MAGENTA);  //Redéfinie la couleur de fond en Magenta
            boutons.get(tuile).setOpaque(true);
            boutons.get(tuile).setEnabled(true);  //Rend les tuiles actives
        }
        repaint();
    }

    public void afficherTuileActuelle(Tuile t) {
        boutons.get(t).setBackground(Color.black);  //Rend la tuile Noir
        boutons.get(t).setEnabled(true);
        boutons.get(t).setOpaque(true);
    }

    public void revenirGrilleDepart() {
        int i = 0;
        int j = 0;
        for (Tuile tuile : tuiles) {
            if (tuile.getEtat() != EtatTuile.inexistante) {  //Vérifie si l'état de la tuile est différent d'inexistant
                if (boutons.put(tuile, listBouton.get(i)) == null) {
                    boutons.put(tuile, listBouton.get(i));
                    this.add(boutons.get(tuile));
                }
                boutons.get(tuile).setEnabled(false);  //rend la tuile inactives
                boutons.get(tuile).setBackground(Color.white);  //Mert la couleur Blanche en fond dans la tuile
            } else {
                if (tuileInexistante.get(tuile) == null) {
                    tuileInexistante.put(tuile, listLabel.get(j));
                    this.add(listLabel.get(j));
                    j++;
                }
            }
            if (tuile.getEtat() == EtatTuile.submergee) {  //Vérifie si l'état de la tuile correspond à submergé
                if (boutons.get(tuile) == null) {
                    boutons.put(tuile, listBouton.get(i));
                }
            }
            i++;
        }
    }

    //Getteur
    public Grille getGrille() {
        return grille;
    }

    public ArrayList<Tuile> getTuiles() {
        return tuiles;
    }

    public HashMap<Tuile, JButtonImage> getBoutons() {
        return boutons;
    }

    public HashMap<Tuile, JLabel> getTuileInexistante() {
        return tuileInexistante;
    }

    public ArrayList<JButtonImage> getListBouton() {
        return listBouton;
    }

    public ArrayList<JLabel> getListLabel() {
        return listLabel;
    }

    public ArrayList<Tresor> getTresors() {
        return tresors;
    }

    //Setteur
    public void setGrille(Grille grille) {
        this.grille = grille;
        this.tuiles = new ArrayList<Tuile>();
        for (Tuile t : grille.getTuiles()) {
            tuiles.add(t);
        }
    }

    public void setTuiles(ArrayList<Tuile> tuiles) {
        this.tuiles = tuiles;
    }

    public void setBoutons(HashMap<Tuile, JButtonImage> boutons) {
        this.boutons = boutons;
    }

    public void setTuileInexistante(HashMap<Tuile, JLabel> tuileInexistante) {
        this.tuileInexistante = tuileInexistante;
    }

    public void setListBouton(ArrayList<JButtonImage> listBouton) {
        this.listBouton = listBouton;
    }

    public void setListLabel(ArrayList<JLabel> listLabel) {
        this.listLabel = listLabel;
    }

    @Override
    public void addObservateur(Observateur o) {
        this.observateur = o;
    }

    @Override
    public void notifierObservateur(Action action) {
        observateur.traiterAction(action);
    }

    public static void main(String[] args) {

    }

}
