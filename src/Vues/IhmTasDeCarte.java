package Vues;

import Cartes.CarteInondation;
import Cartes.CarteTresors;
import Controle.Action;
import Controle.Observateur;
import Enumerations.NomTresor;
import Enumerations.NomTuile;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IhmTasDeCarte extends JPanel implements Observe {

    // attributs
    private Image image1;
    private Image image2;
    private Image image3;
    private Image image4;
    private CarteTresors ct;
    private CarteInondation ci;

    // constructeur
    public IhmTasDeCarte() {
        repaint();
        this.setVisible(false);
    }

    // setteurs
    public void setCt(CarteTresors ct) {
        this.ct = ct;
    }

    public void setCi(CarteInondation ci) {
        this.ci = ci;
    }

    // autres méthodes
    @Override
    public void paintComponent(Graphics g) {
        try {
            this.image1 = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/CarteFond bleu.png"));
        } catch (IOException ex) {
            System.err.println("Erreur de lecture de" + "/src/Image/CarteFond rouge.png");
        }
        g.drawImage(image1, 0, 50, 100, 140, null, this);

        if (ci != null) {
            try {
                this.image2 = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/Carte" + ci.getNom().toString() + ".png"));
            } catch (IOException ex) {
                System.err.println("Erreur de lecture de" + "/src/Image/CarteFond rouge.png");
            }
            g.drawImage(image2, 105, 50, 100, 140, null, this);
        }

        try {
            this.image3 = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/CarteFond rouge.png"));
        } catch (IOException ex) {
            System.err.println("Erreur de lecture de" + "/src/Image/CarteFond rouge.png");
        }
        g.drawImage(image3, 230, 50, 100, 140, null, this);

        if (ct != null) {
            try {
                this.image4 = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/Carte" + ct.getNom().toString() + ".png"));
            } catch (IOException ex) {
                System.err.println("Erreur de lecture de" + "/src/Image/CarteFond rouge.png");
            }
            g.drawImage(image4, 335, 50, 100, 140, null, this);
        }

    }

    public void afficherIhm() {
        this.setVisible(true);
    }

    @Override
    public void addObservateur(Observateur o) {
    }

    @Override
    public void notifierObservateur(Action action) {
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(443, 175);

        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        IhmTasDeCarte ihm = new IhmTasDeCarte();
        ihm.afficherIhm();
        
        CarteTresors carteTresor15 = new CarteTresors(NomTresor.Cristal);
        CarteInondation carteInondation9 = new CarteInondation(NomTuile.LesDunesDeLillusion);

        ihm.setCi(carteInondation9);
        ihm.setCt(carteTresor15);
        
        
        window.add(ihm);
        window.setVisible(true);

    }
}
