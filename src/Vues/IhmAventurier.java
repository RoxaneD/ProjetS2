package Vues;

import Aventuriers.Aventurier;
import Aventuriers.Plongeur;
import Cartes.CarteAventurier;
import Enumerations.Couleur;
import Enumerations.NomAventurier;
import Tas.TasJoueur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
    private TasJoueur tasJoueur = new TasJoueur();

    // attributs visuels
    private JPanel panelVisible = new JPanel(new BorderLayout());            // cartes visible par tous + nom du joueur
    private JPanel panelInvisible = new JPanel(new BorderLayout());          // cartes visible que par l'aventurier + actions

    private JPanel titre = new JPanel();                   // dans panelVisible
    private JPanel panelCartesVisibles = new JPanel(new BorderLayout());     // dans panelVisible
    private JPanel carteAventurier = new JPanel();         // dans panelVisible
    private JPanel panelCartesJoueur = new JPanel();       // dans panelVisible
    private JPanel actionsPion = new JPanel();             // dans panelInvisible
    private JPanel actionsCartes = new JPanel();           // dans panelInvisible
    private JPanel panelCartesTirages = new JPanel();      // dans panelInvisible

    private Image image;
    
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
    private JButton visible10 = new JButton();
    private JButton visible11 = new JButton();
    private JButton visible12 = new JButton();
    private JButton visible13 = new JButton();
    private JButton visible14 = new JButton();
    private JButton visible15 = new JButton();

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

    private JButton deplacer = new JButton();               // dans actionsPion
    private JButton assecher = new JButton();               // dans actionsPion
    private JButton terminer = new JButton();               // dans actionsPion
    private JButton recupererTresor = new JButton();        // dans actionsPion
    private JButton defausser = new JButton();              // dans actionsCartes
    private JButton utiliser = new JButton();               // dans actionsCartes
    private JButton donner = new JButton();                 // dans actionsCartes

    // constructeur
    public IhmAventurier(IhmObserve ihm, Aventurier a) {
        // instantiations obligatoires
        super();
        setIhmObserve(ihm);
        this.setLayout(new BorderLayout());

        // instantiations des attributs
        // pour les attributs interne
        tasJoueur = a.getTasJoueur();
        
        // pour le panel visible
        Border noir = BorderFactory.createLineBorder(Color.black, 1); 
        Border bleu = BorderFactory.createLineBorder(Color.blue, 1);
        Border vert = BorderFactory.createLineBorder(Color.green, 1);
        Border rouge = BorderFactory.createLineBorder(Color.red, 1);
        Border jaune = BorderFactory.createLineBorder(Color.yellow, 1);
        
        panelVisible.setBorder(noir);
        
        // partie supérieure
        JLabel labelTitre = new JLabel(a.getNomJoueur() + " : " + a.getCarteAventurier().getNom().toString());
        titre.add(labelTitre);
        titre.setBorder(bleu);
        panelVisible.add(titre, BorderLayout.NORTH);

        // partie inférieure
        panelCartesVisibles.setBorder(vert);
        try {
            this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/"+a.getCarteAventurier().getNom().toString().toLowerCase()+".png"));
        } catch (IOException ex) {
            System.err.println("Erreur de lecture de"+"/src/Image/"+a.getCarteAventurier().getNom().toString().toLowerCase()+".png");
        }
        
        carteAventurier.setOpaque(true);
        carteAventurier.setBorder(rouge);
        panelCartesVisibles.add(carteAventurier, BorderLayout.WEST);
        panelCartesVisibles.add(panelCartesJoueur, BorderLayout.CENTER);
        panelVisible.add(panelCartesVisibles, BorderLayout.SOUTH);

        add(panelVisible, BorderLayout.NORTH);

        // pour le panel invisible
        add(panelInvisible, BorderLayout.SOUTH);
    }

    // setteurs
    public void setIhmObserve(IhmObserve ihm) {
        this.ihmObserve = ihm;
    }

    // getteurs
    // autres méthodes
    @Override
    public void paintComponent(Graphics g) {
        if (complete){
            titre.setOpaque(false);
        panelCartesVisibles.setOpaque(false);
        carteAventurier.setOpaque(false);
        panelVisible.setOpaque(false);
        panelInvisible.setOpaque(false);
        panelCartesJoueur.setOpaque(false);
        carteAventurier.setSize(150,210);
        g.drawImage(image,0,titre.getHeight(),carteAventurier.getWidth(), carteAventurier.getHeight(),null, carteAventurier);
        } else {
            titre.setOpaque(false);
        panelCartesVisibles.setOpaque(false);
        carteAventurier.setOpaque(false);
        panelVisible.setOpaque(false);
        panelInvisible.setOpaque(false);
        panelCartesJoueur.setOpaque(false);
        carteAventurier.setSize(150,210);
        g.drawImage(image,0,titre.getHeight(),carteAventurier.getWidth(), carteAventurier.getHeight(),null, carteAventurier);
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

    // main (test)
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.setSize(500, 700);

        // Centrage de la fenêtre sur l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((dim.width / 2) - 225, (dim.height / 2) - 241);

        IhmObserve ihmObserve = new IhmObserve();
        CarteAventurier c = new CarteAventurier(NomAventurier.plongeur, Couleur.noir);
        Plongeur a = new Plongeur("Marie", c);
        IhmAventurier ihm = new IhmAventurier(ihmObserve, a);

        window.add(ihm);
        ihm.afficherIhmComplete();
        window.setVisible(true);

    }
}
