// A COMPLETER : RAJOUTER DES LISTENERS + NOTIFIER_OBSERVATEUR
package Vues;

import Cartes.CarteAventurier;
import Controle.Action;
import Controle.TypesActions;
import Enumerations.Couleur;
import Enumerations.NomAventurier;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import Util.Utils.Pion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueAventurierDemo extends Observe {

    // attributs - internes
    private String nomJoueur;
    private CarteAventurier carteAventurier;
    private Color couleur;

    // attributs - mise en forme
    private final JPanel panelBoutons;
    private final JPanel panelCentre;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnBouger;
    private final JButton btnAssecher;
    private final JButton btnAutreAction;
    private final JButton btnTerminerTour;
    private JTextField position;

    // constructeur
    public VueAventurierDemo(String nomJoueur, CarteAventurier carteAventurier, Color couleur) {

        setNomJoueur(nomJoueur);
        setCarteAventurier(carteAventurier);
        setCouleur(couleur);
        this.window = new JFrame();
        window.setSize(350, 200);
        //le titre = nom du joueur 
        window.setTitle(nomJoueur);
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);

        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2));

        // =================================================================================
        // NORD : le titre = nom de l'aventurier sur la couleurActive du pion
        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(couleur);
        panelAventurier.add(new JLabel(carteAventurier.getNom().toString(), SwingConstants.CENTER));
        mainPanel.add(panelAventurier, BorderLayout.NORTH);

        // =================================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, couleur));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);

        panelCentre.add(new JLabel("Position", SwingConstants.CENTER));
        position = new JTextField(30);
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);

        // =================================================================================
        // SUD : les boutons
        this.panelBoutons = new JPanel(new GridLayout(2, 2));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnBouger = new JButton("Bouger");
        btnBouger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Action a = new Action(TypesActions.demandeDeplacement);
                notifierObservateur(a);
            }
        });
        this.btnAssecher = new JButton("Assecher");
        btnAssecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Action a = new Action(TypesActions.demandeAssechement);
                notifierObservateur(a);
            }
        });
        this.btnAutreAction = new JButton("AutreAction");
        btnAutreAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Action a = new Action(TypesActions.demandeAutres);
                notifierObservateur(a);
            }
        });
        this.btnTerminerTour = new JButton("Terminer Tour");
        btnTerminerTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Action a = new Action(TypesActions.terminer);
                notifierObservateur(a);
            }
        });

        this.panelBoutons.add(btnBouger);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnAutreAction);
        this.panelBoutons.add(btnTerminerTour);

        this.window.setVisible(false);
    }

    // setteurs
    public void setPosition(String pos) {
        this.position.setText(pos);
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public void setCarteAventurier(CarteAventurier carteAventurier) {
        this.carteAventurier = carteAventurier;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    // getteurs
    public JButton getBtnAutreAction() {
        return btnAutreAction;
    }

    public String getPosition() {
        return position.getText();
    }

    public JButton getBtnBouger() {
        return btnBouger;
    }

    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    public JButton getBtnTerminerTour() {
        return btnTerminerTour;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public CarteAventurier getCarteAventurier() {
        return carteAventurier;
    }

    public Color getCouleur() {
        return couleur;
    }

    public JFrame getWindow() {
        return window;
    }

    // main
    public static void main(String[] args) {
        // Instanciation de la fenêtre - exemple
        CarteAventurier carte = new CarteAventurier(NomAventurier.explorateur, Couleur.bleu);
        VueAventurierDemo vueAventurier1 = new VueAventurierDemo("Test1", carte, Pion.BLEU.getCouleur());
        vueAventurier1.getWindow().setVisible(true);
    }

}