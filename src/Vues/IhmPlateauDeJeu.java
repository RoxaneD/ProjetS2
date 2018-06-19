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
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IhmPlateauDeJeu extends JPanel implements Observe {

    //
    private Observateur observateur;
    
    // ihms
    private ArrayList<IhmAventurier> ihmAventuriers = new ArrayList<>();
    private IhmAventurier ihmAventurier;
    private IhmGrille ihmGrille;

    // composants organisationnels
    private final JFrame window = new JFrame("Île Interdite");      // la fenêtre de jeu
    private JPanel panelPrincipal = new JPanel(new BorderLayout());
    private JPanel panelDroit = new JPanel(new BorderLayout());     // pour les ihm aventurier
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
        for (Aventurier a : aventuriers.values()) {
            IhmAventurier ihm = new IhmAventurier(a);
            ihmAventuriers.add(ihm);
        }
        setIhmAventurierActuelle(ihmAventuriers.get(0));
        ihmGrille = new IhmGrille(grille);

        // instantiation des composants organisationnels
        window.setSize(dimension.width, dimension.height);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // panel droit
        panelDroit.setPreferredSize(new Dimension((int) (dimension.width * 0.4), (int) (dimension.height * 0.3)));
        panelDroit.add(ihmAventurier, BorderLayout.NORTH);
        // AJOUTER IHMAVENTURIERS EN DESSOUS
        panelPrincipal.add(panelDroit, BorderLayout.EAST);

        // panel gauche
        panelGauche.setPreferredSize(new Dimension((int) (dimension.width * 0.5), (int) (dimension.height * 0.5)));
        panelGauche.add(ihmGrille, BorderLayout.CENTER);

        panelPrincipal.add(panelGauche, BorderLayout.WEST);

        window.add(panelPrincipal);
    }

    // setteurs
    public void setIhmAventurierActuelle(IhmAventurier ihmAventurier) {
        this.ihmAventurier = ihmAventurier;
    }

    // getteurs
    public JFrame getWindow() {
        return window;
    }

    public void afficherIhm() {
        window.setVisible(true);
    }

    public void cacherIhm() {
        window.setVisible(false);
    }

    // autre méthodes
    public static void main(String[] args) {
        Grille grille = new Grille();
        CarteAventurier carte1 = new CarteAventurier(NomAventurier.plongeur, Couleur.noir);
        CarteAventurier carte2 = new CarteAventurier(NomAventurier.plongeur, Couleur.noir);

        Plongeur aventurier1 = new Plongeur("Marie", carte1);
        Pilote aventurier2 = new Pilote("Roxane", carte2);

        HashMap<String, Aventurier> aventuriers = new HashMap<>();
        aventuriers.put(aventurier1.getNomJoueur(), aventurier1);
        aventuriers.put(aventurier2.getNomJoueur(), aventurier2);

        IhmPlateauDeJeu ihm = new IhmPlateauDeJeu(aventuriers, grille);
        ihm.afficherIhm();
    }

    @Override
    public void addObservateur(Observateur o) {
        this.observateur = o;
    }

    @Override
    public void notifierObservateur(Action action) {
        observateur.traiterAction(action);
    }

}
