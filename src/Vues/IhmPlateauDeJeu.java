package Vues;

import Aventuriers.Aventurier;
import Cartes.CarteAventurier;
import Cartes.CarteTresors;
import ElementsJeu.Grille;
import Enumerations.Couleur;
import Enumerations.NomAventurier;
import Util.Utils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IhmPlateauDeJeu {

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
    private Dimension dimension = new Dimension();

    // constructeur
    public IhmPlateauDeJeu(HashMap<String, Aventurier> aventuriers,Grille grille) {

        // instantiations des ihms
        for (Aventurier a : aventuriers.values()) {
            IhmAventurier ihm = new IhmAventurier(a);
            ihmAventuriers.add(ihm);
        }
        setIhmAventurierActuelle(ihmAventuriers.get(0));
        ihmGrille = new IhmGrille(grille);
        
        // instantiation des composants organisationnels
        window.setSize(1000, 1000);
        dimension = window.getSize();
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
    }

}
