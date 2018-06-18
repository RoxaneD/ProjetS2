// A COMPLETER : RAJOUTER DES LISTENERS + NOTIFIER_OBSERVATEUR
package Vues;
//import de tout les package aventurier, les cartes, la grille les enumerations
import Cartes.CarteAventurier;
import Cartes.CarteTresor;
import Cartes.CarteTresors;
import Controle.Action;
import Controle.TypesActions;
import Enumerations.Couleur;
import Enumerations.NomAventurier;
import Tas.TasJoueur;
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
    private String position = "";

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
    private final TasJoueur tasJoueur;

    // constructeur
    //Crée la vue aventurier
    public VueAventurierDemo(String nomJoueur, CarteAventurier carteAventurier, Color couleur) {

        setNomJoueur(nomJoueur);//avec le nom du joueur en parametre
        setCarteAventurier(carteAventurier);//avec la carte aventurier en parametre
        setCouleur(couleur);//avec la couleur en parametre
        //création d'une nouvelle fenetre
        this.window = new JFrame();
        window.setSize(350, 200);
        //le titre = nom du joueur 
        window.setTitle(nomJoueur);
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);
        //ajout d'un JPanel en borderLayout dans la fenetre
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
        panelCentre.add(new JLabel("Position actuelle : \n" + position, SwingConstants.CENTER));

        // =================================================================================
        // SUD : les boutons
        //Création des differents boutons
        //Et de leur ActionListener respectif
        this.panelBoutons = new JPanel(new GridLayout(2, 2));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnBouger = new JButton("Bouger");
        btnBouger.addActionListener(new ActionListener() {
            @Override//Fait une demande de deplacement
            public void actionPerformed(ActionEvent e) {
                Action a = new Action(TypesActions.demandeDeplacement);
                notifierObservateur(a);
            }
        });
        this.btnAssecher = new JButton("Assecher");
        btnAssecher.addActionListener(new ActionListener() {
            @Override//fait une demande d'assechement
            public void actionPerformed(ActionEvent e) {
                Action a = new Action(TypesActions.demandeAssechement);
                notifierObservateur(a);
            }
        });
        this.btnAutreAction = new JButton("AutreAction");
        btnAutreAction.addActionListener(new ActionListener() {
            @Override//Fait une demande pour d'autre action
            public void actionPerformed(ActionEvent e) {
            }
        });
        this.btnTerminerTour = new JButton("Terminer Tour");
        btnTerminerTour.addActionListener(new ActionListener() {
            @Override//Fait une demande pour terminer le tour
            public void actionPerformed(ActionEvent e) {
                Action a = new Action(TypesActions.terminer);
                notifierObservateur(a);
            }
        });
        //Ajout de tout les boutons au JPanel
        this.panelBoutons.add(btnBouger);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnAutreAction);
        this.panelBoutons.add(btnTerminerTour);
        
        tasJoueur = new TasJoueur();
        

        this.window.setVisible(false);
    }

    // setteurs
    //Méthode qui met a jour le nom du joueur avec celui en parametre
    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    //Méthode qui met a jour la carte aventurier avec celle en parametre
    public void setCarteAventurier(CarteAventurier carteAventurier) {
        this.carteAventurier = carteAventurier;
    }

    //Méthode qui met a jour la couleur avec celle en parametre
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    //Méthode qui met a jour la position avec celle en parametre
    public void setPosition(String position) {
        this.position = position;
    }
    
    public void addCarteTresors(CarteTresors carteT) {
        tasJoueur.addCarte(carteT);
    }

    // getteurs
    //Méthode qui renvoie le bouton autre action
    public JButton getBtnAutreAction() {
        return btnAutreAction;
    }

    //Méthode qui renvoie le bouton bouger
    public JButton getBtnBouger() {
        return btnBouger;
    }

    //Méthode qui renvoie le bouton assecher
    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    //Méthode qui renvoie le bouton terminer tour
    public JButton getBtnTerminerTour() {
        return btnTerminerTour;
    }

    //Méthode qui renvoie le nom du joueur
    public String getNomJoueur() {
        return nomJoueur;
    }

    //Méthode qui renvoie la carte aventurier
    public CarteAventurier getCarteAventurier() {
        return carteAventurier;
    }

    //Méthode qui renvoie la couleur
    public Color getCouleur() {
        return couleur;
    }

    //Méthode qui renvoie la fenetre d'affichage
    public JFrame getWindow() {
        return window;
    }

    //Méthode qui renvoie la position
    public String getPosition() {
        return position;
    }

    public TasJoueur getTasJoueur() {
        return tasJoueur;
    }
    
    

    // main
    public static void main(String[] args) {
        // Instanciation de la fenêtre - exemple
        //création d'une carte aventurier explorateur
       /* CarteAventurier carte = new CarteAventurier(NomAventurier.explorateur, Couleur.bleu);
        //Création d'une vue aventurier de nom Test1 avec la carte et le pion
        VueAventurierDemo vueAventurier1 = new VueAventurierDemo("Test1", carte, Pion.BLEU.getCouleur());
        //affichage sur la fenetre de cette vue
        vueAventurier1.getWindow().setVisible(true);*/
    }

    

}
