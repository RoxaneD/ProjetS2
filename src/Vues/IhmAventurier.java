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

public class IhmAventurier extends JPanel {

    // doit contenir -> son tas de carte
    // sa couleur - sa classe (sa carte aventurier)
    // son nom
    // les boutons pour ses actions -> deplacer - assecher - defausser - utiliser - recuperer tresor - rien faire - donner une carte
    //
    // attribut qui permet la communication
    private IhmObserve ihmObserve;

    // attributs internes
    private Integer width, height;
    private boolean complete = false;
    private Aventurier aventurier;

    // attributs visuels
    private JPanel panelVisible = new JPanel(new BorderLayout());            // cartes visible par tous + nom du joueur
    private JPanel panelInvisible = new JPanel(new BorderLayout());          // cartes visible que par l'aventurier + actions

    private JPanel titre = new JPanel();                   // dans panelVisible
    private JPanel panelCartesVisibles = new JPanel(new BorderLayout());     // dans panelVisible
    private JPanel carteAventurier = new JPanel();         // dans panelVisible
    private JPanel panelCartesJoueur = new JPanel();       // dans panelVisible            
    private JPanel actions = new JPanel(new GridLayout(9, 1)); // dans panelInvisible
    private JPanel panelCartesTirages = new JPanel();      // dans panelInvisible

    private Image imageCarteAventurier;
    private Image imageV1;
    private Image imageIV1;

    private ArrayList<JButton> cartesVisibles = new ArrayList<>();
    private JButton visible1 = new JButton();
    private JButton visible2 = new JButton();
    private JButton visible3 = new JButton();
    private JButton visible4 = new JButton();
    private JButton visible5 = new JButton();
    private JButton visible6 = new JButton();
    private JButton visible7 = new JButton();
    private JButton visible8 = new JButton();
    private JButton visible9 = new JButton();

    private ArrayList<JButton> cartesTirages = new ArrayList<>();
    private JButton tirage1 = new JButton();
    private JButton tirage2 = new JButton();
    private JButton tirage3 = new JButton();
    private JButton tirage4 = new JButton();
    private JButton tirage5 = new JButton();
    private JButton tirage6 = new JButton();
    private JButton tirage7 = new JButton();
    private JButton tirage8 = new JButton();
    private JButton tirage9 = new JButton();

    private JButton deplacer = new JButton("Déplacer");               // dans actionsPion
    private JButton assecher = new JButton("Assècher");               // dans actionsPion
    private JButton terminer = new JButton("Terminer");               // dans actionsPion
    private JButton recupererTresor = new JButton("Récuperer trésor");        // dans actionsPion
    private JButton defausser = new JButton("Defausser");              // dans actionsCartes
    private JButton utiliser = new JButton("Utiliser");               // dans actionsCartes
    private JButton donner = new JButton("           Donner           ");                 // dans actionsCartes

    // constructeur
    public IhmAventurier(IhmObserve ihm, Aventurier a) {
        // instantiations obligatoires
        super();
        setIhmObserve(ihm);
        this.setLayout(new BorderLayout());

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
        JLabel labelTitre = new JLabel(a.getNomJoueur() + " : " + a.getCarteAventurier().getNom().toString());
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

        add(panelVisible, BorderLayout.NORTH);

        // pour le panel invisible
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(panelCartesTirages, BorderLayout.WEST);

        actions.add(defausser);
        actions.add(utiliser);
        actions.add(donner);
        actions.add(new JLabel(""));
        actions.add(deplacer);
        actions.add(assecher);
        actions.add(recupererTresor);
        actions.add(new JLabel(""));
        actions.add(terminer);
        
        p.add(actions, BorderLayout.EAST);
        
        panelInvisible.add(p);

        add(panelInvisible, BorderLayout.SOUTH);

        repaint();
    }

    // setteurs
    public void setIhmObserve(IhmObserve ihm) {
        this.ihmObserve = ihm;
    }

    // getteurs
    // autres méthodes
    @Override
    public void paintComponent(Graphics g) {
        if (complete) {
            titre.setOpaque(false);
            panelCartesVisibles.setOpaque(false);
            carteAventurier.setOpaque(false);
            panelVisible.setOpaque(false);
            panelInvisible.setOpaque(false);
            panelCartesJoueur.setOpaque(false);
            actions.setOpaque(false);

            carteAventurier.setSize(150, 210);
            g.drawImage(imageCarteAventurier, 0, titre.getHeight() + 10, carteAventurier.getWidth(), carteAventurier.getHeight(), null, carteAventurier);

            int taille = aventurier.getTasJoueur().getCartes().size();
            panelCartesVisibles.setLayout(new GridLayout(1, taille));
            int i1 = 0;
            for (CarteTresors c : aventurier.getTasJoueur().getCartes()) {
                JPanel p = new JPanel();
                try {
                    this.imageV1 = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/Carte" + c.getNom().toString() + ".png"));
                } catch (IOException ex) {
                    System.err.println("Erreur de lecture de" + "/src/Image/Carte" + c.getNom().toString() + ".png");
                }
                g.drawImage(imageV1, 160 + ((432 / taille) * i1), titre.getHeight() + 10, carteAventurier.getWidth(), carteAventurier.getHeight(), null, p);
                panelCartesVisibles.add(p);
                i1 += 1;
            }

            taille = aventurier.getTasTirage().size();
            panelCartesTirages.setLayout(new GridLayout(1, taille));
            int i2 = 0;
            for (Carte c : aventurier.getTasTirage()) {
                JPanel p = new JPanel();
                if (c.getDescription() == "tresors") {
                    CarteTresors a = (CarteTresors) (c);
                    try {
                        this.imageIV1 = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/Carte" + a.getNom().toString() + ".png"));
                    } catch (IOException ex) {
                        System.err.println("Erreur de lecture de" + "/src/Image/Carte" + a.getNom().toString() + ".png");
                    }
                } else if (c.getDescription() == "inondation") {
                    CarteInondation a = (CarteInondation) (c);
                    try {
                        this.imageIV1 = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/Carte" + a.getNom().toString() + ".png"));
                    } catch (IOException ex) {
                        System.err.println("Erreur de lecture de" + "/src/Image/Carte" + a.getNom().toString() + ".png");
                    }
                }

                g.drawImage(imageIV1, ((400 / taille) * i2), titre.getHeight() + 230, carteAventurier.getWidth(), carteAventurier.getHeight(), null, p);
                panelCartesTirages.add(p);
                i2 += 1;
            }
        } else {
            titre.setOpaque(false);
            panelCartesVisibles.setOpaque(false);
            carteAventurier.setOpaque(false);
            panelVisible.setOpaque(false);
            panelInvisible.setOpaque(false);
            panelCartesJoueur.setOpaque(false);
            carteAventurier.setSize(150, 210);
            g.drawImage(imageCarteAventurier, 0, titre.getHeight(), carteAventurier.getWidth(), carteAventurier.getHeight(), null, carteAventurier);
        }
    }

    public void afficherIhmComplete() {
        complete = true;
        repaint();
    }

    public void afficherIhmReduite() {
        complete = false;
        repaint();
    }

    public void afficherCarte() {

    }

    // main (test)
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700, 509);

        // Centrage de la fenêtre sur l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((dim.width / 2) - 225, (dim.height / 2) - 241);

        IhmObserve ihmObserve = new IhmObserve();
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

        IhmAventurier ihm = new IhmAventurier(ihmObserve, a);

        window.add(ihm);
        ihm.afficherIhmComplete();
        window.setVisible(true);
    }
}
