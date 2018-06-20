package Vues;

import Aventuriers.Aventurier;
import Aventuriers.Pilote;
import Aventuriers.Plongeur;
import Cartes.CarteAventurier;
import Controle.Action;
import Controle.Observateur;
import ElementsJeu.Grille;
import Enumerations.Couleur;
import Enumerations.NomAventurier;
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
    Border bleu = BorderFactory.createLineBorder(Color.blue, 1);
    Border vert = BorderFactory.createLineBorder(Color.green, 1);
    Border rouge = BorderFactory.createLineBorder(Color.red, 1);
    Border jaune = BorderFactory.createLineBorder(Color.yellow, 1);

    // attributs internes
    private Observateur observateur;
    private int nombreJoueurs;

    // ihms
    private ArrayList<IhmAventurier> ihmAventuriers = new ArrayList<>();
    private IhmAventurier ihmAventurier;
    private IhmGrille ihmGrille;

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
    public IhmPlateauDeJeu(HashMap<String, Aventurier> aventuriers, Grille grille) {

        // instantiations des ihms
        nombreJoueurs = aventuriers.size();

        for (Aventurier a : aventuriers.values()) {
            IhmAventurier ihm = new IhmAventurier(a);
            ihmAventuriers.add(ihm);

        }
        setIhmAventurierActuelle(ihmAventuriers.get(0));
        ihmGrille = new IhmGrille(grille);
        ihmGrille.setVisible(true);

        this.window = new JFrame("Île Interdite");
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

    // autre méthodes
    public void afficherIhm() {
        window.setVisible(true);
    }

    public void cacherIhm() {
        window.setVisible(false);
    }

    public void mettreAJour() {
        // on efface et recréé les composants
        panelPrincipal = new JPanel(new BorderLayout());
        panelDroit = new JPanel(new GridLayout(3, 1));   // pour l'ihm aventurier actuelle + les autres
        panelAventurier = new JPanel();                                 // pour l'ihm aventurier actuelle

        panelAventuriers1 = new JPanel(new GridLayout(3, 1));                               // pour les autres ihms aventurier
        panelAventuriers2 = new JPanel(new GridLayout(3, 1));                              // pour les autres ihms aventurier

        panelGauche = new JPanel(new BorderLayout());    // pour l'ihm grille + tas de carte + niveau d'eau
        eauEtCartes = new JPanel(new BorderLayout());    // dans panelGauche en bas
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
                
        // panel droit
        panelDroit.setPreferredSize(new Dimension((int) (dimension.width * 0.4), (int) (dimension.height)));

        panelAventurier.setBorder(noir);

        panelAventuriers1.setBorder(bleu);

        panelAventuriers2.setBorder(rouge);

        panelDroit.setBorder(jaune);
        // pour les aventuriers

        panelAventurier.add(ihmAventurier);

        ihmAventurier.afficherIhmComplete();
        if (nombreJoueurs
                == 2) {
            panelAventuriers1 = new JPanel(new GridLayout(3, 1));
            panelAventuriers1.add(ihmAventuriers.get(1));
            panelAventuriers1.add(new JLabel("a"));
            panelAventuriers1.add(new JLabel("b"));
            panelAventuriers2 = new JPanel(new GridLayout(3, 1));
            panelAventuriers2.add(new JLabel("c"));
            panelAventuriers2.add(new JLabel("d"));
            panelAventuriers2.add(new JLabel("e"));

            ihmAventuriers.get(1).afficherIhmReduite();

        } else if (nombreJoueurs
                == 3) {
            panelAventuriers1 = new JPanel(new GridLayout(3, 1));
            panelAventuriers1.add(ihmAventuriers.get(1));
            panelAventuriers1.add(ihmAventuriers.get(2));
            panelAventuriers1.add(new JLabel());
            panelAventuriers2 = new JPanel(new GridLayout(3, 1));
            panelAventuriers2.add(new JPanel());
            panelAventuriers2.add(new JPanel());
            panelAventuriers2.add(new JPanel());

            ihmAventuriers.get(1).afficherIhmReduite();
            ihmAventuriers.get(2).afficherIhmReduite();

        } else if (nombreJoueurs
                == 4) {
            panelAventuriers1 = new JPanel(new GridLayout(3, 1));
            panelAventuriers1.add(ihmAventuriers.get(1));
            panelAventuriers1.add(ihmAventuriers.get(2));
            panelAventuriers1.add(ihmAventuriers.get(3));
            panelAventuriers2 = new JPanel(new GridLayout(3, 1));
            panelAventuriers2.add(new JPanel());
            panelAventuriers2.add(new JPanel());
            panelAventuriers2.add(new JPanel());

            ihmAventuriers.get(1).afficherIhmReduite();
            ihmAventuriers.get(2).afficherIhmReduite();
            ihmAventuriers.get(3).afficherIhmReduite();

        } else if (nombreJoueurs
                == 5) {
            panelAventuriers1 = new JPanel(new GridLayout(3, 1));
            panelAventuriers1.add(ihmAventuriers.get(1));
            panelAventuriers1.add(ihmAventuriers.get(2));
            panelAventuriers1.add(ihmAventuriers.get(3));
            panelAventuriers2 = new JPanel(new GridLayout(3, 1));
            panelAventuriers2.add(ihmAventuriers.get(4));
            panelAventuriers2.add(new JPanel());
            panelAventuriers2.add(new JPanel());

            ihmAventuriers.get(1).afficherIhmReduite();
            ihmAventuriers.get(2).afficherIhmReduite();
            ihmAventuriers.get(3).afficherIhmReduite();
            ihmAventuriers.get(4).afficherIhmReduite();

        } else if (nombreJoueurs
                == 6) {
            panelAventuriers1 = new JPanel(new GridLayout(3, 1));
            panelAventuriers1.add(ihmAventuriers.get(1));
            panelAventuriers1.add(ihmAventuriers.get(2));
            panelAventuriers1.add(ihmAventuriers.get(3));
            panelAventuriers2 = new JPanel(new GridLayout(3, 1));
            panelAventuriers2.add(ihmAventuriers.get(4));
            panelAventuriers2.add(ihmAventuriers.get(5));
            panelAventuriers2.add(new JPanel());

            ihmAventuriers.get(1).afficherIhmReduite();
            ihmAventuriers.get(2).afficherIhmReduite();
            ihmAventuriers.get(3).afficherIhmReduite();
            ihmAventuriers.get(4).afficherIhmReduite();
            ihmAventuriers.get(5).afficherIhmReduite();

        }

        panelDroit.add(panelAventurier);

        panelDroit.add(panelAventuriers1);

        panelDroit.add(panelAventuriers2);

        // AJOUTER IHMAVENTURIERS EN DESSOUS
        panelPrincipal.add(panelDroit, BorderLayout.EAST);

        // panel gauche
        panelGauche.setPreferredSize(
                new Dimension((int) (dimension.width * 0.6), (int) (dimension.height)));
        panelGauche.setBorder(vert);

        panelGauche.add(ihmGrille, BorderLayout.CENTER);

        panelPrincipal.add(panelGauche, BorderLayout.WEST);

        window.add(panelPrincipal);

        // pour la grille
        // pour les tas de cartes
        // pour le niveau d'eau
        // réafficher l'ihm
        afficherIhm();
    }

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

        HashMap<String, Aventurier> aventuriers = new HashMap<>();
        aventuriers.put(aventurier1.getNomJoueur(), aventurier1);
        aventuriers.put(aventurier2.getNomJoueur(), aventurier2);

        IhmPlateauDeJeu ihm = new IhmPlateauDeJeu(aventuriers, grille);
        ihm.afficherIhm();
        ihm.mettreAJour();
        ihm.mettreAJour();
        ihm.mettreAJour();
    }
}
