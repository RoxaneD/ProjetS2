package Vues;

import Aventuriers.Aventurier;
import Aventuriers.Pilote;
import Aventuriers.Plongeur;
import Cartes.CarteAventurier;
import Cartes.CarteInondation;
import Cartes.CarteTresors;
import Controle.Action;
import Controle.Observateur;
import ElementsJeu.Grille;
import ElementsJeu.NiveauEau;
import Enumerations.Couleur;
import Enumerations.NomAventurier;
import Enumerations.NomTresor;
import Enumerations.NomTuile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class IhmPlateauDeJeu extends JPanel implements Observe {

    // BORDURES :D
    Border noir = BorderFactory.createLineBorder(Color.black, 1);

    // attributs internes
    private Observateur observateur;
    private int nombreJoueurs;

    // ihms
    private ArrayList<IhmAventurier> ihmAventuriers = new ArrayList<>();
    private IhmAventurier ihmAventurier;
    private IhmGrille ihmGrille;
    private IhmNiveauDeau ihmNiveauEau;
    private IhmTasDeCarte ihmTasDeCarte;

    // composants organisationnels
    private JFrame window = new JFrame("Île Interdite");      // la fenêtre de jeu
    private JPanel panelPrincipal = new JPanel(new BorderLayout());
    private JPanel panelDroit = new JPanel(new GridLayout(3, 1));   // pour l'ihm aventurier actuelle + les autres
    private JPanel panelAventurier = new JPanel();                                 // pour l'ihm aventurier actuelle

    private JPanel panelAventuriers1 = new JPanel(new GridLayout(3, 1));                               // pour les autres ihms aventurier
    private JPanel panelAventuriers2 = new JPanel(new GridLayout(3, 1));                              // pour les autres ihms aventurier

    private JPanel panelAv11 = new JPanel();
    private JPanel panelAv12 = new JPanel();
    private JPanel panelAv13 = new JPanel();
    private JPanel panelAv21 = new JPanel();
    private JPanel panelAv22 = new JPanel();
    private JPanel panelAv23 = new JPanel();

    private JPanel panelGauche = new JPanel(new BorderLayout());    // pour l'ihm grille + tas de carte + niveau d'eau
    private JPanel autreAventuriers = new JPanel();                 // dans panelDroit en bas
    private JPanel eauEtCartes = new JPanel(new BorderLayout());    // dans panelGauche en bas
    private JPanel cartes = new JPanel();                           // dans eauEtCartes à droite
    private JPanel eau = new JPanel();                              // dans eauEtCartes à gauche

    // attributs interne
    private Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    // constructeur
    public IhmPlateauDeJeu(HashMap<String, Aventurier> aventuriers, Grille grille, NiveauEau niveauEau) {

        // instantiations des ihms
        nombreJoueurs = aventuriers.size();

        for (Aventurier a : aventuriers.values()) {
            IhmAventurier ihm = new IhmAventurier(a);
            ihmAventuriers.add(ihm);

        }
        ihmNiveauEau = new IhmNiveauDeau(niveauEau);
        ihmNiveauEau.afficherIhm();
        ihmTasDeCarte = new IhmTasDeCarte();
        ihmTasDeCarte.setSize(443, 175);
        ihmTasDeCarte.afficherIhm();
        System.out.println(ihmTasDeCarte.getSize().width);

        setIhmAventurierActuelle(ihmAventuriers.get(0));
        ihmGrille = new IhmGrille(grille);
        ihmGrille.setVisible(true);

        this.setSize(dimension.width, dimension.height);
        window.setSize(dimension.width, dimension.height);

        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mettreAJour();
    }

    // setteurs
    public void setIhmAventurierActuelle(IhmAventurier ihmAventurier) {
        this.ihmAventurier = ihmAventurier;
    }

    // getteurs
    public JFrame getWindow() {
        return window;
    }

    public IhmAventurier getIhmAventurierActuelle() {
        return this.ihmAventurier;
    }

    public IhmGrille getIhmGrille() {
        return this.ihmGrille;
    }

    public ArrayList<IhmAventurier> getIhmAventuriers() {
        return this.ihmAventuriers;
    }

    public IhmNiveauDeau getIhmNiveauEau() {
        return ihmNiveauEau;
    }

    public IhmTasDeCarte getIhmTasDeCarte() {
        return ihmTasDeCarte;
    }

    // autre méthodes
    public void afficherIhm() {
        window.setVisible(true);
    }

    public void cacherIhm() {
        window.setVisible(false);
    }

    public void mettreAJour() {
        // on efface et recréé les composants
        window.remove(panelPrincipal);
        this.setVisible(true);

        panelPrincipal = new JPanel(new BorderLayout());
        panelDroit = new JPanel(new GridLayout(3, 1));   // pour l'ihm aventurier actuelle + les autres
        panelAventurier = new JPanel(new BorderLayout());                                 // pour l'ihm aventurier actuelle

        panelAventuriers1 = new JPanel(new GridLayout(3, 1));                               // pour les autres ihms aventurier
        panelAventuriers2 = new JPanel(new GridLayout(3, 1)); // pour les autres ihms aventurier

        panelAv11 = new JPanel(new BorderLayout());
        panelAv12 = new JPanel(new BorderLayout());
        panelAv13 = new JPanel(new BorderLayout());
        panelAv21 = new JPanel(new BorderLayout());
        panelAv22 = new JPanel(new BorderLayout());
        panelAv23 = new JPanel(new BorderLayout());

        panelGauche = new JPanel(new BorderLayout());    // pour l'ihm grille + tas de carte + niveau d'eau
        eauEtCartes = new JPanel(new GridLayout(1, 2));    // dans panelGauche en bas
        cartes = new JPanel();                           // dans eauEtCartes à droite
        eau = new JPanel();

        // on les mets en setOpaque(false);
        panelPrincipal.setOpaque(false);
        panelDroit.setOpaque(false);
        panelAventurier.setOpaque(false);
        panelAventuriers1.setOpaque(false);
        panelAventuriers2.setOpaque(false);
        panelGauche.setOpaque(false);
        eauEtCartes.setOpaque(false);
        cartes.setOpaque(false);
        eau.setOpaque(false);
        panelAv11.setOpaque(false);
        panelAv12.setOpaque(false);
        panelAv13.setOpaque(false);
        panelAv21.setOpaque(false);
        panelAv22.setOpaque(false);
        panelAv23.setOpaque(false);

        // PANEL DROIT (1)
        panelDroit.setPreferredSize(
                new Dimension((int) (dimension.width * 0.4), (int) (dimension.height)));
        // pour les aventuriers

        panelAventurier.add(ihmAventurier, BorderLayout.CENTER);

        ihmAventurier.afficherIhmComplete();
        ihmAventurier.setBorder(noir);
        ihmAventurier.setEnabled(true);

        if (nombreJoueurs
                == 2) {
            panelAventuriers1 = new JPanel(new GridLayout(3, 1));
            panelAv11.add(ihmAventuriers.get(1), BorderLayout.CENTER);
            ihmAventuriers.get(1).afficherIhmReduite();
            ihmAventuriers.get(1).setEnabled(false);
            ihmAventuriers.get(1).setBorder(noir);
            panelAventuriers1.add(panelAv11);
            panelAventuriers1.add(new JLabel(""));
            panelAventuriers1.add(new JLabel(""));
            panelAventuriers2 = new JPanel(new GridLayout(3, 1));
            panelAventuriers2.add(new JLabel(""));
            panelAventuriers2.add(new JLabel(""));
            panelAventuriers2.add(new JLabel(""));

        } else if (nombreJoueurs
                == 3) {
            panelAventuriers1 = new JPanel(new GridLayout(3, 1));
            panelAv11.add(ihmAventuriers.get(1), BorderLayout.CENTER);
            panelAventuriers1.add(panelAv11);
            ihmAventuriers.get(1).afficherIhmReduite();
            ihmAventuriers.get(1).setEnabled(false);
            ihmAventuriers.get(1).setBorder(noir);
            panelAv12.add(ihmAventuriers.get(2), BorderLayout.CENTER);
            panelAventuriers1.add(panelAv12);
            ihmAventuriers.get(2).afficherIhmReduite();
            ihmAventuriers.get(2).setEnabled(false);
            ihmAventuriers.get(2).setBorder(noir);
            panelAventuriers1.add(new JLabel(""));
            panelAventuriers2 = new JPanel(new GridLayout(3, 1));
            panelAventuriers2.add(new JLabel(""));
            panelAventuriers2.add(new JLabel(""));
            panelAventuriers2.add(new JLabel(""));

        } else if (nombreJoueurs
                == 4) {
            panelAventuriers1 = new JPanel(new GridLayout(3, 1));
            panelAv11.add(ihmAventuriers.get(1), BorderLayout.CENTER);
            ihmAventuriers.get(1).afficherIhmReduite();
            ihmAventuriers.get(1).setEnabled(false);
            ihmAventuriers.get(1).setBorder(noir);
            panelAventuriers1.add(panelAv11);
            panelAv12.add(ihmAventuriers.get(2), BorderLayout.CENTER);
            ihmAventuriers.get(2).afficherIhmReduite();
            ihmAventuriers.get(2).setEnabled(false);
            ihmAventuriers.get(2).setBorder(noir);
            panelAventuriers1.add(panelAv12);
            panelAv13.add(ihmAventuriers.get(3), BorderLayout.CENTER);
            ihmAventuriers.get(3).afficherIhmReduite();
            ihmAventuriers.get(3).setEnabled(false);
            ihmAventuriers.get(3).setBorder(noir);
            panelAventuriers1.add(panelAv13);

            panelAventuriers2 = new JPanel(new GridLayout(3, 1));
            panelAventuriers2.add(new JLabel(""));
            panelAventuriers2.add(new JLabel(""));
            panelAventuriers2.add(new JLabel(""));

        } else if (nombreJoueurs
                == 5) {
            panelAventuriers1 = new JPanel(new GridLayout(3, 1));
            panelAv11.add(ihmAventuriers.get(1), BorderLayout.CENTER);
            ihmAventuriers.get(1).afficherIhmReduite();
            ihmAventuriers.get(1).setEnabled(false);
            ihmAventuriers.get(1).setBorder(noir);
            panelAventuriers1.add(panelAv11);
            panelAv12.add(ihmAventuriers.get(2), BorderLayout.CENTER);
            ihmAventuriers.get(2).afficherIhmReduite();
            ihmAventuriers.get(2).setEnabled(false);
            ihmAventuriers.get(2).setBorder(noir);
            panelAventuriers1.add(panelAv12);
            panelAv13.add(ihmAventuriers.get(3), BorderLayout.CENTER);
            ihmAventuriers.get(3).afficherIhmReduite();
            ihmAventuriers.get(3).setEnabled(false);
            ihmAventuriers.get(3).setBorder(noir);
            panelAventuriers1.add(panelAv13);
            panelAventuriers2 = new JPanel(new GridLayout(3, 1));
            panelAv21.add(ihmAventuriers.get(4), BorderLayout.CENTER);
            ihmAventuriers.get(4).afficherIhmReduite();
            ihmAventuriers.get(4).setEnabled(false);
            ihmAventuriers.get(4).setBorder(noir);
            panelAventuriers2.add(panelAv21);

            panelAventuriers2.add(new JLabel(""));
            panelAventuriers2.add(new JLabel(""));

        } else if (nombreJoueurs
                == 6) {
            panelAventuriers1 = new JPanel(new GridLayout(3, 1));
            panelAv11.add(ihmAventuriers.get(1), BorderLayout.CENTER);
            ihmAventuriers.get(1).afficherIhmReduite();
            ihmAventuriers.get(1).setEnabled(false);
            ihmAventuriers.get(1).setBorder(noir);
            panelAventuriers1.add(panelAv11);
            panelAv12.add(ihmAventuriers.get(2), BorderLayout.CENTER);
            ihmAventuriers.get(2).afficherIhmReduite();
            ihmAventuriers.get(2).setEnabled(false);
            ihmAventuriers.get(2).setBorder(noir);
            panelAventuriers1.add(panelAv12);
            panelAv13.add(ihmAventuriers.get(3), BorderLayout.CENTER);
            ihmAventuriers.get(3).afficherIhmReduite();
            ihmAventuriers.get(3).setEnabled(false);
            ihmAventuriers.get(3).setBorder(noir);
            panelAventuriers1.add(panelAv13);
            panelAventuriers2 = new JPanel(new GridLayout(3, 1));
            panelAv21.add(ihmAventuriers.get(4), BorderLayout.CENTER);
            ihmAventuriers.get(4).afficherIhmReduite();
            ihmAventuriers.get(4).setEnabled(false);
            ihmAventuriers.get(4).setBorder(noir);
            panelAventuriers2.add(panelAv21);
            panelAv22.add(ihmAventuriers.get(5), BorderLayout.CENTER);
            ihmAventuriers.get(5).afficherIhmReduite();
            ihmAventuriers.get(5).setEnabled(false);
            ihmAventuriers.get(5).setBorder(noir);
            panelAventuriers2.add(panelAv22);

            panelAventuriers2.add(new JLabel(""));
        }

        panelDroit.add(panelAventurier);
        panelDroit.add(panelAventuriers1);
        panelDroit.add(panelAventuriers2);

        // AJOUTER IHMAVENTURIERS EN DESSOUS
        panelPrincipal.add(panelDroit, BorderLayout.EAST);

        // PANEL GAUCHE (2)
        //panelGauche.setPreferredSize(new Dimension((int) (dimension.width * 0.5), (int) (dimension.height)));
        ihmGrille.setPreferredSize(new Dimension((int) (dimension.width * 0.525), (int) (dimension.height * 0.7125)));

        panelGauche.add(ihmGrille, BorderLayout.NORTH);
        eauEtCartes.add(ihmNiveauEau);
        ihmNiveauEau.setSize(431, 276);
        eauEtCartes.add(ihmTasDeCarte);
        System.out.println(eauEtCartes.getSize().height);
        ihmTasDeCarte.setSize(443, 175);
        panelGauche.add(eauEtCartes, BorderLayout.CENTER);

        panelPrincipal.add(panelGauche, BorderLayout.WEST);

        window.add(panelPrincipal);

        // pour la grille
        // pour les tas de cartes
        // pour le niveau d'eau
        // réafficher l'ihm
        panelPrincipal.setOpaque(false);
        panelDroit.setOpaque(false);
        panelAventurier.setOpaque(false);
        panelAventuriers1.setOpaque(false);
        panelAventuriers2.setOpaque(false);
        panelGauche.setOpaque(false);
        eauEtCartes.setOpaque(false);
        cartes.setOpaque(false);
        eau.setOpaque(false);
        panelAv11.setOpaque(false);
        panelAv12.setOpaque(false);
        panelAv13.setOpaque(false);
        panelAv21.setOpaque(false);
        panelAv22.setOpaque(false);
        panelAv23.setOpaque(false);

        afficherIhm();
    }

    // Observe
    @Override
    public void addObservateur(Observateur o) {
        this.observateur = o;
    }

    @Override
    public void notifierObservateur(Action action) {
        observateur.traiterAction(action);
    }

    // main
    public static void main(String[] args) {
        Grille grille = new Grille();
        CarteAventurier carte1 = new CarteAventurier(NomAventurier.plongeur, Couleur.noir);
        CarteAventurier carte2 = new CarteAventurier(NomAventurier.pilote, Couleur.bleu);

        Plongeur aventurier1 = new Plongeur("Marie", carte1);
        Pilote aventurier2 = new Pilote("Roxane", carte2);
        Pilote aventurier3 = new Pilote("Roxane2", carte2);
        Pilote aventurier4 = new Pilote("Roxane3", carte2);
        Pilote aventurier5 = new Pilote("Roxaned", carte2);
        Pilote aventurier6 = new Pilote("mARIE2", carte2);

        CarteTresors carteTresor6 = new CarteTresors(NomTresor.SacsDeSable);
        CarteTresors carteTresor7 = new CarteTresors(NomTresor.Zephyr);
        CarteTresors carteTresor8 = new CarteTresors(NomTresor.Cristal);
        aventurier1.getTasJoueur().addCarte(carteTresor6);
        aventurier1.getTasJoueur().addCarte(carteTresor7);
        aventurier1.getTasJoueur().addCarte(carteTresor8);
        aventurier2.getTasJoueur().addCarte(carteTresor6);
        aventurier2.getTasJoueur().addCarte(carteTresor7);
        aventurier2.getTasJoueur().addCarte(carteTresor8);
        aventurier3.getTasJoueur().addCarte(carteTresor6);
        aventurier3.getTasJoueur().addCarte(carteTresor7);
        aventurier3.getTasJoueur().addCarte(carteTresor8);
        aventurier4.getTasJoueur().addCarte(carteTresor6);
        aventurier4.getTasJoueur().addCarte(carteTresor7);
        aventurier4.getTasJoueur().addCarte(carteTresor8);
        aventurier4.getTasJoueur().addCarte(carteTresor6);
        aventurier4.getTasJoueur().addCarte(carteTresor7);
        aventurier4.getTasJoueur().addCarte(carteTresor8);
        aventurier4.getTasJoueur().addCarte(carteTresor6);
        aventurier4.getTasJoueur().addCarte(carteTresor7);
        aventurier4.getTasJoueur().addCarte(carteTresor8);

        aventurier1.getTasTirage().add(carteTresor6);

        HashMap<String, Aventurier> aventuriers = new HashMap<>();
        aventuriers.put(aventurier1.getNomJoueur(), aventurier1);
        aventuriers.put(aventurier2.getNomJoueur(), aventurier2);
        aventuriers.put(aventurier3.getNomJoueur(), aventurier3);
        aventuriers.put(aventurier4.getNomJoueur(), aventurier4);
        aventuriers.put(aventurier5.getNomJoueur(), aventurier5);
        aventuriers.put(aventurier6.getNomJoueur(), aventurier6);
        
        NiveauEau niveauEau = new NiveauEau();

        CarteTresors carteTresor15 = new CarteTresors(NomTresor.Cristal);
        CarteInondation carteInondation9 = new CarteInondation(NomTuile.LesDunesDeLillusion);

        IhmPlateauDeJeu ihm = new IhmPlateauDeJeu(aventuriers, grille, niveauEau);

        ihm.getIhmTasDeCarte().setCi(carteInondation9);
        ihm.getIhmTasDeCarte().setCt(carteTresor15);

        ihm.afficherIhm();
        ihm.mettreAJour();
    }

}
