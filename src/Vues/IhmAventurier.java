package Vues;

import Aventuriers.Aventurier;
import Aventuriers.Explorateur;
import Aventuriers.Ingenieur;
import Aventuriers.Messager;
import Aventuriers.Navigateur;
import Aventuriers.Pilote;
import Aventuriers.Plongeur;
import Cartes.Carte;
import Cartes.CarteAventurier;
import Cartes.CarteInondation;
import Cartes.CarteTresors;
import Controle.Action;
import Controle.Observateur;
import Controle.TypesActions;
import Enumerations.Couleur;
import Enumerations.NomAventurier;
import Enumerations.NomTresor;
import Enumerations.NomTuile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class IhmAventurier extends JPanel implements Observe {

    // BORDURES :D
    private static Border noir = BorderFactory.createLineBorder(Color.black, 1);
    private static Border bleu = BorderFactory.createLineBorder(Color.blue, 1);
    private static Border vert = BorderFactory.createLineBorder(Color.green, 1);
    private static Border rouge = BorderFactory.createLineBorder(Color.red, 1);
    private static Border jaune = BorderFactory.createLineBorder(Color.yellow, 1);

    // doit contenir -> son tas de carte
    // sa couleur - sa classe (sa carte aventurier)
    // son nom
    // les boutons pour ses actions -> deplacer - assecher - defausser - utiliser - recuperer tresor - rien faire - donner une carte
    //
    // attribut qui permet la communication
    private Observateur observateur;

    // attributs internes
    private boolean complete = false;
    private boolean afficheCarteJoueur = false;
    private boolean afficheCarteTirage = false;
    private boolean peutDonner = false;
    private boolean helicoptere = false;
    private boolean choisi = false;
    private boolean active0 = false;
    private boolean active1 = false;
    private boolean active2 = false;
    private boolean active3 = false;
    private boolean active4 = false;
    private boolean active5 = false;
    private boolean active6 = false;
    private boolean active7 = false;
    private boolean active8 = false;
    private boolean active9 = false;
    private boolean active10 = false;
    private boolean active11 = false;
    private boolean active12 = false;
    private boolean active13 = false;
    private boolean active14 = false;
    private boolean active15 = false;
    private boolean active16 = false;
    private boolean active17 = false;
    private ArrayList<Boolean> actives = new ArrayList<>();
    private Aventurier aventurier;
    private String choix; // est mit à jour après un clic sur un bouton d'actions de cartes
    private ArrayList<Integer> pos = new ArrayList<>(); // arrayList retourné par le controleur qui contient les positions des cartes pouvant etre utilisées/donnés/défaussés

    // attributs visuels
    private JPanel panelVisible = new JPanel(new BorderLayout());            // cartes visible par tous + nom du joueur
    private JPanel panelInvisible = new JPanel(new BorderLayout());          // cartes visible que par l'aventurier + actions

    private JPanel titre = new JPanel();                   // dans panelVisible
    private JPanel panelCartesVisibles = new JPanel(new BorderLayout());     // dans panelVisible
    private JPanel carteAventurier = new JPanel();         // dans panelVisible
    private JPanel panelCartesJoueur = new JPanel();       // dans panelVisible            
    private JPanel actions = new JPanel(new GridLayout(13, 1)); // dans panelInvisible
    private JPanel panelCartesTirages = new JPanel();      // dans panelInvisible

    private JLabel labelTitre;

    private Image imageCarteAventurier;
    private Image imageV1;
    private Image iconTarget;

    private Image imageIV1;

    private JButton deplacer = new JButton("Déplacer");               // dans actionsPion
    private JButton assecher = new JButton("Assècher");               // dans actionsPion
    private JButton terminer = new JButton("Terminer");               // dans actionsPion
    private JButton recupererTresor = new JButton("Récuperer trésor");        // dans actionsPion
    private JButton defausser = new JButton("Defausser");              // dans actionsCartes
    private JButton utiliser = new JButton("Utiliser");               // dans actionsCartes
    private JButton donner = new JButton("           Donner           ");                 // dans actionsCartes

    private ArrayList<Integer> cartesTresoraAfficher = new ArrayList<>();
    private ArrayList<Integer> cartesTirageAffiche = new ArrayList<>();

    // constructeur
    public IhmAventurier(Aventurier a) {
        // instantiations obligatoires
        super();
        this.setLayout(new BorderLayout());

        // BORDURES :D
        Border noir = BorderFactory.createLineBorder(Color.black, 1);
        Border bleu = BorderFactory.createLineBorder(Color.blue, 1);
        Border vert = BorderFactory.createLineBorder(Color.green, 1);
        Border rouge = BorderFactory.createLineBorder(Color.red, 1);
        Border jaune = BorderFactory.createLineBorder(Color.yellow, 1);

        // instantiations des attributs
        //
        if (a.getCarteAventurier().getNom() == NomAventurier.explorateur) {
            aventurier = new Explorateur(a.getNomJoueur(), a.getCarteAventurier());
        } else if (a.getCarteAventurier().getNom() == NomAventurier.plongeur) {
            aventurier = new Plongeur(a.getNomJoueur(), a.getCarteAventurier());
        } else if (a.getCarteAventurier().getNom() == NomAventurier.messager) {
            aventurier = new Messager(a.getNomJoueur(), a.getCarteAventurier());
        } else if (a.getCarteAventurier().getNom() == NomAventurier.navigateur) {
            aventurier = new Navigateur(a.getNomJoueur(), a.getCarteAventurier());
        } else if (a.getCarteAventurier().getNom() == NomAventurier.ingenieur) {
            aventurier = new Ingenieur(a.getNomJoueur(), a.getCarteAventurier());
        } else if (a.getCarteAventurier().getNom() == NomAventurier.pilote) {
            aventurier = new Pilote(a.getNomJoueur(), a.getCarteAventurier());
        }
        aventurier.setTasJoueur(a.getTasJoueur());
        aventurier.setTasTirage(a.getTasTirage());

        // pour le panel visible
        //      partie supérieure
        this.labelTitre = new JLabel(a.getNomJoueur() + " : " + a.getTuile().getNom());
        titre.add(labelTitre);
        panelVisible.add(titre, BorderLayout.NORTH);

        //      partie inférieure
        try {
            this.imageCarteAventurier = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/" + a.getCarteAventurier().getNom().toString().toLowerCase() + ".png"));
        } catch (IOException ex) {
            System.err.println("Erreur de lecture de" + "/src/Image/" + a.getCarteAventurier().getNom().toString().toLowerCase() + ".png");
        }

        carteAventurier.setOpaque(true);
        panelCartesVisibles.add(carteAventurier, BorderLayout.WEST);
        panelCartesVisibles.add(panelCartesJoueur, BorderLayout.CENTER);
        panelVisible.add(panelCartesVisibles, BorderLayout.SOUTH);

        repaint();
        add(panelVisible, BorderLayout.NORTH);

        // pour le panel invisible
        panelInvisible.add(panelCartesTirages, BorderLayout.WEST);

        actions.add(terminer);
        actions.add(new JLabel(""));
        actions.add(new JLabel(""));
        actions.add(new JLabel(""));
        actions.add(new JLabel(""));
        actions.add(new JLabel(""));
        actions.add(new JLabel(""));
        actions.add(defausser);
        actions.add(utiliser);
        actions.add(donner);
        actions.add(deplacer);
        actions.add(assecher);
        actions.add(recupererTresor);

        pos.add(0);
        pos.add(1);
        pos.add(2);
        pos.add(3);
        pos.add(4);
        pos.add(5);
        pos.add(6);
        pos.add(7);
        pos.add(8);

        pos.add(9);
        pos.add(10);
        pos.add(11);
        pos.add(12);
        pos.add(13);
        pos.add(14);
        pos.add(15);
        pos.add(16);
        pos.add(17);

        defausser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Action a = new Action(TypesActions.demandeDefausseCarte);
                a.setNom(getAventurier().getNomJoueur());
                notifierObservateur(a);
            }
        });

        utiliser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Action a = new Action(TypesActions.demandeUtilisationCarte);
                a.setNom(getAventurier().getNomJoueur());
                notifierObservateur(a);
            }
        });

        donner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Action a = new Action(TypesActions.demandeDonCarte);
                a.setNom(getAventurier().getNomJoueur());
                notifierObservateur(a);
            }
        });

        deplacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Action a = new Action(TypesActions.demandeDeplacement);
                a.setNom(getAventurier().getNomJoueur());
                notifierObservateur(a);
            }
        });

        assecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Action a = new Action(TypesActions.demandeAssechement);
                a.setNom(getAventurier().getNomJoueur());
                notifierObservateur(a);
            }
        });

        recupererTresor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Action a = new Action(TypesActions.recupererTresor);
                a.setNom(getAventurier().getNomJoueur());
                notifierObservateur(a);
            }
        });

        terminer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Action a = new Action(TypesActions.terminerTour);
                a.setNom(getAventurier().getNomJoueur());
                notifierObservateur(a);
            }
        });

        panelInvisible.add(actions, BorderLayout.EAST);

        add(panelInvisible, BorderLayout.SOUTH);
        repaint();

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int taille1 = aventurier.getTasJoueur().getCartes().size();
                int taille2 = aventurier.getTasTirage().size();
                if (choix == "utiliser") {
                    for (Integer a : pos) {
                        if (a == 0 && active0 || a == 1 && active1 || a == 2 && active2 || a == 3 && active3 || a == 4 && active4 || a == 5 && active5 || a == 6 && active6 || a == 7 && active7 || a == 8 && active8
                                || a == 9 && active9 || a == 10 && active10 || a == 11 && active11 || a == 12 && active12 || a == 13 && active13 || a == 14 && active14 || a == 15 && active15 || a == 16 && active16 || a == 17 && active17) {
                            if (a < 9 && taille1 != 0) { // pour les cartes du tasJoueur
                                if (a + 1 == taille1) { // alors -> dernière carte
                                    if ((e.getX() > 110 + ((432 / taille1) * a)) && (e.getX() < (110 + ((432 / taille1) * a) + 100))) {
                                        if ((e.getY() > (titre.getHeight() + 5)) && (e.getY() < (titre.getHeight() + 145))) {
                                            Action action = new Action(TypesActions.utiliserCarte, aventurier.getTasJoueur().getCarte(a + 1));
                                            action.setNom(getAventurier().getNomJoueur());
                                            notifierObservateur(action);
                                            System.out.println("utiliser - dernière carte du tasJoueur");
                                        }
                                    }
                                } else { // les autres cartes

                                    if (taille1 < 3) { // dans ce cas il y a un espace entre les différentes cartes
                                        if ((e.getX() > (110 + ((432 / taille1) * a))) && (e.getX() < (110 + ((432 / taille1) * a) + 100))) {
                                            if ((e.getY() > (titre.getHeight() + 5)) && (e.getY() < (titre.getHeight() + 145))) {
                                                Action action = new Action(TypesActions.utiliserCarte, aventurier.getTasJoueur().getCarte(a + 1));
                                                action.setNom(getAventurier().getNomJoueur());
                                                notifierObservateur(action);
                                                System.out.println("utiliser - carte n°" + (a + 1) + " du tasJoueur");
                                            }
                                        }
                                    } else {
                                        if ((e.getX() > (110 + ((432 / taille1) * a))) && (e.getX() < (110 + ((432 / taille1) * (a + 1))))) {
                                            if ((e.getY() > (titre.getHeight() + 5)) && (e.getY() < (titre.getHeight() + 145))) {
                                                Action action = new Action(TypesActions.utiliserCarte, aventurier.getTasJoueur().getCarte(a + 1));
                                                action.setNom(getAventurier().getNomJoueur());
                                                notifierObservateur(action);
                                                System.out.println("utiliser - carte n°" + (a + 1) + " du tasJoueur");
                                            }
                                        }
                                    }

                                }

                            } else if (a >= 9 && taille2 != 0) { // pour les cartes tirages

                                if (a + 1 - 9 == taille2) { // alors -> dernière carte
                                    if ((e.getX() > ((400 / taille2) * (a - 9))) && (e.getX() < (((400 / taille2) * (a - 9)) + 100))) {
                                        if ((e.getY() > (titre.getHeight() + 160)) && (e.getY() < (titre.getHeight() + 300))) {
                                            Action action = new Action(TypesActions.utiliserCarte, aventurier.getTasTirage().get(a - 9));
                                            action.setNom(getAventurier().getNomJoueur());
                                            notifierObservateur(action);
                                            System.out.println("utiliser - dernière carte du tasTirage");

                                        }
                                    }
                                } else { // les autres cartes
                                    if (taille2 < 3) {
                                        if ((e.getX() > ((400 / taille2) * (a - 9))) && (e.getX() < (((400 / taille2) * (a - 9)) + 100))) {
                                            if ((e.getY() > (titre.getHeight() + 160)) && (e.getY() < (titre.getHeight() + 300))) {
                                                Action action = new Action(TypesActions.utiliserCarte, aventurier.getTasTirage().get(a - 9));
                                                action.setNom(getAventurier().getNomJoueur());
                                                notifierObservateur(action);
                                                System.out.println("utiliser - carte n°" + (a - 8) + " du tasTirage");
                                            }
                                        }
                                    } else {
                                        if ((e.getX() > ((400 / taille2) * (a - 9))) && (e.getX() < ((400 / taille2) * (a - 8)))) {
                                            if ((e.getY() > (titre.getHeight() + 160)) && (e.getY() < (titre.getHeight() + 300))) {
                                                Action action = new Action(TypesActions.utiliserCarte, aventurier.getTasTirage().get(a - 9));
                                                action.setNom(getAventurier().getNomJoueur());
                                                notifierObservateur(action);
                                                System.out.println("utiliser - carte n°" + (a - 8) + " du tasTirage");

                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                } else if (choix == "donner") {
                    for (Integer a : pos) {
                        if (a == 0 && active0 || a == 1 && active1 || a == 2 && active2 || a == 3 && active3 || a == 4 && active4 || a == 5 && active5 || a == 6 && active6 || a == 7 && active7 || a == 8 && active8
                                || a == 9 && active9 || a == 10 && active10 || a == 11 && active11 || a == 12 && active12 || a == 13 && active13 || a == 14 && active14 || a == 15 && active15 || a == 16 && active16 || a == 17 && active17) {
                            if (a < 9 && taille1 != 0) { // pour les cartes du tasJoueur

                                if (a + 1 == taille1) { // alors -> dernière carte
                                    if ((e.getX() > (110 + ((432 / taille1) * a))) && (e.getX() < (110 + ((432 / taille1) * a) + 100))) {
                                        if ((e.getY() > (titre.getHeight() + 5)) && (e.getY() < (titre.getHeight() + 145))) {
                                            Action action = new Action(TypesActions.donCarte, aventurier.getTasJoueur().getCarte(a + 1));
                                            notifierObservateur(action);
                                            System.out.println("donner - dernière carte du tasJoueur");
                                        }
                                    }
                                } else { // les autres cartes
                                    if (taille1 < 3) { // dans ce cas il y a un espace entre les différentes cartes
                                        if ((e.getX() > (110 + ((432 / taille1) * a))) && (e.getX() < (110 + ((432 / taille1) * a) + 100))) {
                                            if ((e.getY() > (titre.getHeight() + 5)) && (e.getY() < (titre.getHeight() + 145))) {
                                                Action action = new Action(TypesActions.donCarte, aventurier.getTasJoueur().getCarte(a + 1));
                                                notifierObservateur(action);
                                                System.out.println("donner - carte n°" + (a + 1) + " du tasJoueur");
                                            }
                                        }
                                    } else {
                                        if ((e.getX() > (110 + ((432 / taille1) * a))) && (e.getX() < (110 + ((432 / taille1) * (a + 1))))) {
                                            if ((e.getY() > (titre.getHeight() + 5)) && (e.getY() < (titre.getHeight() + 145))) {
                                                Action action = new Action(TypesActions.donCarte, aventurier.getTasJoueur().getCarte(a + 1));
                                                notifierObservateur(action);
                                                System.out.println("donner - carte n°" + (a + 1) + " du tasJoueur");
                                            }
                                        }
                                    }

                                }

                            } else if (a >= 9 && taille2 != 0) { // pour les cartes tirages

                                if (a + 1 - 9 == taille2) { // alors -> dernière carte
                                    if ((e.getX() > ((400 / taille2) * (a - 9))) && (e.getX() < (((400 / taille2) * (a - 9)) + 100))) {
                                        if ((e.getY() > (titre.getHeight() + 160)) && (e.getY() < (titre.getHeight() + 300))) {
                                            Action action = new Action(TypesActions.donCarte, aventurier.getTasTirage().get(a - 9));
                                            notifierObservateur(action);
                                            System.out.println("donner - dernière carte du tasTirage");

                                        }
                                    }
                                } else { // les autres cartes
                                    if (taille2 < 3) {
                                        if ((e.getX() > ((400 / taille2) * (a - 9))) && (e.getX() < (((400 / taille2) * (a - 9)) + 100))) {
                                            if ((e.getY() > (titre.getHeight() + 160)) && (e.getY() < (titre.getHeight() + 300))) {
                                                Action action = new Action(TypesActions.donCarte, aventurier.getTasTirage().get(a - 9));
                                                notifierObservateur(action);
                                                System.out.println("donner - carte n°" + (a - 8) + " du tasTirage");
                                            }
                                        }
                                    } else {
                                        if ((e.getX() > ((400 / taille2) * (a - 9))) && (e.getX() < ((400 / taille2) * (a - 8)))) {
                                            if ((e.getY() > (titre.getHeight() + 160)) && (e.getY() < (titre.getHeight() + 300))) {
                                                Action action = new Action(TypesActions.donCarte, aventurier.getTasTirage().get(a - 9));
                                                notifierObservateur(action);
                                                System.out.println("donner - carte n°" + (a - 8) + " du tasTirage");

                                            }
                                        }
                                    }
                                }

                            }
                        }

                    }
                } else if (choix == "defausser") {
                    for (Integer a : pos) {
                        if (a == 0 && active0 || a == 1 && active1 || a == 2 && active2 || a == 3 && active3 || a == 4 && active4 || a == 5 && active5 || a == 6 && active6 || a == 7 && active7 || a == 8 && active8
                                || a == 9 && active9 || a == 10 && active10 || a == 11 && active11 || a == 12 && active12 || a == 13 && active13 || a == 14 && active14 || a == 15 && active15 || a == 16 && active16 || a == 17 && active17) {
                            if (a < 9 && taille1 != 0) { // pour les cartes du tasJoueur
                                if (a + 1 == taille1) { // alors -> dernière carte
                                    if ((e.getX() > (110 + ((432 / taille1) * a))) && (e.getX() < (110 + ((432 / taille1) * a) + 100))) {
                                        if ((e.getY() > (titre.getHeight() + 5)) && (e.getY() < (titre.getHeight() + 145))) {
                                            Action action = new Action(TypesActions.defausserCarte, aventurier.getTasJoueur().getCarte(a + 1));
                                            notifierObservateur(action);
                                            System.out.println("defausser - dernière carte du tasJoueur");
                                        }
                                    }
                                } else { // les autres cartes
                                    if (taille1 < 3) { // dans ce cas il y a un espace entre les différentes cartes
                                        if ((e.getX() > (110 + ((432 / taille1) * a))) && (e.getX() < (110 + ((432 / taille1) * a) + 100))) {
                                            if ((e.getY() > (titre.getHeight() + 5)) && (e.getY() < (titre.getHeight() + 145))) {
                                                Action action = new Action(TypesActions.defausserCarte, aventurier.getTasJoueur().getCarte(a + 1));
                                                notifierObservateur(action);
                                                System.out.println("defausser - carte n°" + (a + 1) + " du tasJoueur");
                                            }
                                        }
                                    } else {
                                        if ((e.getX() > (110 + ((432 / taille1) * a))) && (e.getX() < (110 + ((432 / taille1) * (a + 1))))) {
                                            if ((e.getY() > (titre.getHeight() + 5)) && (e.getY() < (titre.getHeight() + 145))) {
                                                Action action = new Action(TypesActions.defausserCarte, aventurier.getTasJoueur().getCarte(a + 1));
                                                notifierObservateur(action);
                                                System.out.println("defausser - carte n°" + (a + 1) + " du tasJoueur");
                                            }
                                        }
                                    }

                                }

                            } else if (a >= 9 && taille2 != 0) { // pour les cartes tirages
                                if (a + 1 - 9 == taille2) { // alors -> dernière carte
                                    if ((e.getX() > ((400 / taille2) * (a - 9))) && (e.getX() < (((400 / taille2) * (a - 9)) + 100))) {
                                        if ((e.getY() > (titre.getHeight() + 160)) && (e.getY() < (titre.getHeight() + 300))) {
                                            Action action = new Action(TypesActions.defausserCarte, aventurier.getTasTirage().get(a - 9));
                                            notifierObservateur(action);
                                            System.out.println("defausser - dernière carte du tasTirage");

                                        }
                                    }
                                } else { // les autres cartes
                                    if (taille2 < 3) {
                                        if ((e.getX() > ((400 / taille2) * (a - 9))) && (e.getX() < (((400 / taille2) * (a - 9)) + 100))) {
                                            if ((e.getY() > (titre.getHeight() + 160)) && (e.getY() < (titre.getHeight() + 300))) {
                                                Action action = new Action(TypesActions.defausserCarte, aventurier.getTasTirage().get(a - 9));
                                                notifierObservateur(action);
                                                System.out.println("defausser - carte n°" + (a - 8) + " du tasTirage");
                                            }
                                        }
                                    } else {
                                        if ((e.getX() > ((400 / taille2) * (a - 9))) && (e.getX() < ((400 / taille2) * (a - 8)))) {
                                            if ((e.getY() > (titre.getHeight() + 160)) && (e.getY() < (titre.getHeight() + 300))) {
                                                Action action = new Action(TypesActions.defausserCarte, aventurier.getTasTirage().get(a - 9));
                                                notifierObservateur(action);
                                                System.out.println("defausser - carte n°" + (a - 8) + " du tasTirage");

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
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

    }

    public JButton getDeplacer() {
        return deplacer;
    }

    public JButton getAssecher() {
        return assecher;
    }

    public JButton getTerminer() {
        return terminer;
    }

    public JButton getRecupererTresor() {
        return recupererTresor;
    }

    public JButton getDefausser() {
        return defausser;
    }

    public JButton getUtiliser() {
        return utiliser;
    }

    public JButton getDonner() {
        return donner;
    }

    @Override

    public void paintComponent(Graphics g) {
        // BORDURES :D
        Border noir = BorderFactory.createLineBorder(Color.black, 1);
        Border bleu = BorderFactory.createLineBorder(Color.blue, 1);
        Border vert = BorderFactory.createLineBorder(Color.green, 1);
        Border rouge = BorderFactory.createLineBorder(Color.red, 1);
        Border jaune = BorderFactory.createLineBorder(Color.yellow, 1);

        titre.setOpaque(false);
        panelCartesVisibles.setOpaque(false);
        carteAventurier.setOpaque(false);
        panelVisible.setOpaque(false);
        panelInvisible.setOpaque(false);
        panelCartesJoueur.setOpaque(false);
        panelCartesTirages.setOpaque(false);
        actions.setOpaque(false);

        carteAventurier.setSize(100, 140); // 150,210
        g.drawImage(imageCarteAventurier, 0, titre.getHeight() + 10, carteAventurier.getWidth(), carteAventurier.getHeight(), null, carteAventurier);
        if (peutDonner) {
            g.setColor(Color.red);
            g.drawRect(0, titre.getHeight() + 10, carteAventurier.getWidth(), carteAventurier.getHeight());
            //------------------------------------------------A mettre les bonne valeur pour endre cliquable----------
            /**
             * if ((e.getX() > 110 + ((432 / taille1) * a)) && (e.getX() < (110 + ((432 / taille1) * a) + 100))) {
             * if ((e.getY() > (titre.getHeight() + 5)) && (e.getY() <
             * (titre.getHeight() + 145))) { Action action = new
             * Action(TypesActions.utiliserCarte,
             * aventurier.getTasJoueur().getCarte(a + 1));
             * notifierObservateur(action); System.out.println("utiliser -
             * dernière carte du tasJoueur"); } }*
             */
        }

        int taille = aventurier.getTasJoueur().getCartes().size();
        panelCartesVisibles.setLayout(new GridLayout(1, taille));
        int i1 = 0;
        for (CarteTresors c : aventurier.getTasJoueur().getCartes()) {
            try {
                this.imageV1 = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/Carte" + c.getNom().toString() + ".png"));
                this.iconTarget = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/iconTarget.png"));
            } catch (IOException ex) {
                System.err.println("Erreur de lecture de" + "/src/Image/Carte" + c.getNom().toString() + ".png");
            }
            g.drawImage(imageV1, 110 + ((432 / taille) * i1), titre.getHeight() + 5, carteAventurier.getWidth(), carteAventurier.getHeight(), null, panelCartesVisibles);
            if (afficheCarteJoueur) {
                for (Integer pos : cartesTresoraAfficher) {

                    if (aventurier.getTasJoueur().getCartes().indexOf(c) == pos) {

                        g.drawImage(iconTarget, 110 + ((432 / taille) * i1), titre.getHeight() + 5, 25, 25, null, panelCartesVisibles);
                        if (pos == 0) {
                            active0 = true;
                            actives.add(active0);
                        } else if (pos == 1) {
                            active1 = true;
                            actives.add(active1);
                        } else if (pos == 2) {
                            active2 = true;
                            actives.add(active2);
                        } else if (pos == 3) {
                            active3 = true;
                            actives.add(active3);
                        } else if (pos == 4) {
                            active4 = true;
                            actives.add(active4);
                        } else if (pos == 5) {
                            active5 = true;
                            actives.add(active5);
                        } else if (pos == 6) {
                            active6 = true;
                            actives.add(active6);
                        } else if (pos == 7) {
                            active7 = true;
                            actives.add(active7);
                        } else if (pos == 8) {
                            active8 = true;
                            actives.add(active8);
                        }
                    }
                }
            }

            i1 += 1;
        }

        taille = aventurier.getTasTirage().size();
        panelCartesTirages.setLayout(new GridLayout(1, taille));
        int i2 = 0;
        for (Carte c : aventurier.getTasTirage()) {
            if (c.getDescription() == "inondation") {
                CarteInondation a = (CarteInondation) (c);
                try {
                    this.imageIV1 = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/Carte" + a.getNom().toString() + ".png"));
                } catch (IOException ex) {
                    System.err.println("Erreur de lecture de" + "/src/Image/Carte" + a.getNom().toString() + ".png");
                }
            } else {
                CarteTresors a = (CarteTresors) (c);
                try {
                    this.imageIV1 = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/Carte" + a.getNom().toString() + ".png"));
                } catch (IOException ex) {
                    System.err.println("Erreur de lecture de" + "/src/Image/Carte" + a.getNom().toString() + ".png");
                }
            }

            g.drawImage(imageIV1, ((400 / taille) * i2), titre.getHeight() + 160, carteAventurier.getWidth(), carteAventurier.getHeight(), null, panelCartesTirages);
            if (afficheCarteTirage) {
                for (Integer pos : cartesTirageAffiche) {
                    if (aventurier.getTasTirage().indexOf(c) == pos - 1) {
                        g.drawImage(iconTarget, ((400 / taille) * i2), titre.getHeight() + 160, 25, 25, null, panelCartesTirages);
                        if (pos - 1 == 0) {
                            active9 = true;
                            actives.add(active9);
                        } else if (pos - 1 == 1) {
                            active10 = true;
                            actives.add(active10);
                        } else if (pos - 1 == 2) {
                            active11 = true;
                            actives.add(active11);
                        } else if (pos - 1 == 3) {
                            active12 = true;
                            actives.add(active12);
                        } else if (pos - 1 == 4) {
                            active13 = true;
                            actives.add(active13);
                        } else if (pos - 1 == 5) {
                            active14 = true;
                            actives.add(active14);
                        } else if (pos - 1 == 6) {
                            active15 = true;
                            actives.add(active15);
                        } else if (pos - 1 == 7) {
                            active16 = true;
                            actives.add(active16);
                        } else if (pos - 1 == 8) {
                            active17 = true;
                            actives.add(active17);
                        }
                    }
                }
            }
            i2 += 1;
        }

        if (!complete) {
            titre.setOpaque(false);
            panelCartesVisibles.setOpaque(false);
            carteAventurier.setOpaque(false);
            panelVisible.setOpaque(false);
            panelInvisible.setOpaque(false);
            panelInvisible.setVisible(false);
            panelCartesJoueur.setOpaque(false);
            panelCartesTirages.setOpaque(false);
            panelCartesTirages.setVisible(false);
            actions.setOpaque(false);
            actions.setVisible(false);
            defausser.setVisible(false);
            utiliser.setVisible(false);
            donner.setVisible(false);
            deplacer.setVisible(false);
            assecher.setVisible(false);
            recupererTresor.setVisible(false);
            terminer.setVisible(false);
        } else {
            panelInvisible.setVisible(true);
            panelCartesTirages.setVisible(true);
            actions.setOpaque(true);
            actions.setVisible(true);
            defausser.setVisible(true);
            utiliser.setVisible(true);
            donner.setVisible(true);
            deplacer.setVisible(true);
            assecher.setVisible(true);
            recupererTresor.setVisible(true);
            terminer.setVisible(true);
        }

    }

    // setteurs
    public void setChoix(String choix) {
        this.choix = choix;
    }

    public void setPeutDonner(boolean peutDonner) {
        this.peutDonner = peutDonner;
    }

    public void setLabelTitre(String s) {
        this.labelTitre.removeAll();
        this.labelTitre.setText(s);
    }

    public void setHelicoptere(boolean helicoptere) {
        this.helicoptere = helicoptere;
    }

    public void setChoisi(boolean choisi) {
        this.choisi = choisi;
    }

    // getteurs
    public String getNomJoueur() {
        return aventurier.getNomJoueur();
    }

    public CarteAventurier getCarteAventurier() {
        return aventurier.getCarteAventurier();
    }

    public Aventurier getAventurier() {
        return aventurier;
    }

    // autres méthodes
    public void afficherIhmComplete() {
        complete = true;
        repaint();
    }

    public void afficherIhmReduite() {
        complete = false;
        repaint();
    }

    public void afficherCarteJoueur(ArrayList<Integer> pos) {
        afficheCarteJoueur = true;
        cartesTresoraAfficher = pos;
        repaint();
    }

    public void afficherCarteTirage(ArrayList<Integer> pos) {
        afficheCarteTirage = true;
        cartesTirageAffiche = pos;
        repaint();
    }

    @Override
    public void addObservateur(Observateur o) {
        this.observateur = o;
    }

    @Override
    public void notifierObservateur(Action action) {
        if (observateur != null) {
            observateur.traiterAction(action);
        }
    }

    // main (test)
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(660, 365);

        // Centrage de la fenêtre sur l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((dim.width / 2) - 225, (dim.height / 2) - 241);

        CarteAventurier c = new CarteAventurier(NomAventurier.plongeur, Couleur.noir);
        Plongeur a = new Plongeur("Marie", c);
        CarteTresors carteTresor1 = new CarteTresors(NomTresor.Pierre);
        CarteTresors carteTresor2 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor3 = new CarteTresors(NomTresor.Cristal);
        CarteTresors carteTresor4 = new CarteTresors(NomTresor.Calice);
        CarteTresors carteTresor5 = new CarteTresors(NomTresor.Helicoptere);
        CarteTresors carteTresor6 = new CarteTresors(NomTresor.SacsDeSable);
        CarteTresors carteTresor7 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor8 = new CarteTresors(NomTresor.Cristal);
        CarteTresors carteTresor9 = new CarteTresors(NomTresor.Pierre);
        a.getTasJoueur().addCarte(carteTresor1);
        a.getTasJoueur().addCarte(carteTresor2);
        a.getTasJoueur().addCarte(carteTresor3);
        a.getTasJoueur().addCarte(carteTresor4);
        a.getTasJoueur().addCarte(carteTresor5);
        a.getTasJoueur().addCarte(carteTresor6);
        a.getTasJoueur().addCarte(carteTresor7);
        a.getTasJoueur().addCarte(carteTresor8);
        a.getTasJoueur().addCarte(carteTresor9);

        CarteTresors carteTresor10 = new CarteTresors(NomTresor.MonteeDesEaux);
        CarteTresors carteTresor11 = new CarteTresors(NomTresor.MonteeDesEaux);
        CarteInondation carte1 = new CarteInondation(NomTuile.Heliport);
        CarteInondation carte2 = new CarteInondation(NomTuile.LaCaverneDuBrasier);
        CarteInondation carte3 = new CarteInondation(NomTuile.LaForetPourpre);
        CarteInondation carte4 = new CarteInondation(NomTuile.LeValDuCrepuscule);
        CarteInondation carte5 = new CarteInondation(NomTuile.LesDunesDeLillusion);
        CarteInondation carte6 = new CarteInondation(NomTuile.LaPortedOr);
        CarteInondation carte7 = new CarteInondation(NomTuile.LePalaisDesMarees);
        a.getTasTirage().add(carteTresor10);
        a.getTasTirage().add(carteTresor11);

        a.getTasTirage().add(carte1);
        a.getTasTirage().add(carte2);
        a.getTasTirage().add(carte3);
        a.getTasTirage().add(carte4);
        a.getTasTirage().add(carte5);
        a.getTasTirage().add(carte6);
        a.getTasTirage().add(carte7);

        IhmAventurier ihm = new IhmAventurier(a);
        ihm.setChoix("defausser");
        ihm.pos.add(0);
        ihm.pos.add(1);
        ihm.pos.add(2);
        ihm.pos.add(3);
        ihm.pos.add(4);
        ihm.pos.add(5);
        ihm.pos.add(6);
        ihm.pos.add(7);
        ihm.pos.add(8);

        ihm.pos.add(9);
        ihm.pos.add(10);
        ihm.pos.add(11);
        ihm.pos.add(12);
        ihm.pos.add(13);
        ihm.pos.add(14);
        ihm.pos.add(15);
        ihm.pos.add(16);
        ihm.pos.add(17);

        ArrayList<Integer> cartes = new ArrayList<>();
        cartes.add(0);
        cartes.add(1);

        ArrayList<Integer> cartesTirages = new ArrayList<>();
        cartesTirages.add(1);
        cartesTirages.add(2);

        // pour une ihm réduite
        /**
         * window.add(ihm); ihm.afficherIhmReduite(); ihm.repaint();
         * window.setPreferredSize(new Dimension(705,285));
         * window.setPreferredSize(new Dimension(700,285));
         * window.setSize(700,285); window.setVisible(true);
         * window.setEnabled(false);
         *
         */
        // pour une ihm complete
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(700, 500);
        p.add(ihm, BorderLayout.CENTER);
        ihm.afficherIhmComplete();
        ihm.afficherCarteJoueur(cartes);
        ihm.afficherCarteTirage(cartesTirages);
        window.add(p);
        System.out.println(p.getSize().width);
        System.out.println(p.getSize().height);
        p.setBorder(noir);
        window.setVisible(true);

    }
}
