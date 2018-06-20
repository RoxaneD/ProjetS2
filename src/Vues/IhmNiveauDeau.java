package Vues;

import Cartes.CarteInondation;
import Cartes.CarteTresors;
import Demo.ImageContainerCalques;
import ElementsJeu.NiveauEau;
import Enumerations.NomTresor;
import Enumerations.NomTuile;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class IhmNiveauDeau extends JLayeredPane {

    // attributs
    ImageContainerCalques niveau;
    ImageContainerCalques stick;
    private NiveauEau niveauEau;

    // constructeur
    public IhmNiveauDeau(NiveauEau niveauEau) {
        setNiveauEau(niveauEau);
        this.setVisible(false);

        String imgFolder = System.getProperty("user.dir") + "/src/Image/";
        niveau = new ImageContainerCalques(imgFolder + "Niveau.png", 0, 38, 421, 164);
        this.add(niveau, -2000);

        int i = niveauEau.getSemiNiveau();
        stick = new ImageContainerCalques(imgFolder + "stick.png", 408-(2*35)-((i-1)*35), 198, 20, 32);
        this.add(stick, -1000);

        this.repaint();
    }

    // setteurs
    public void setNiveauEau(NiveauEau niveauEau) {
        this.niveauEau = niveauEau;
    }

    // autres méthodes
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.niveau != null) {
            this.niveau.paintComponent(g);
        }
        if (this.stick != null) {
            this.stick.paintComponent(g);
        }
    }

    public void afficherIhm() {
        this.setVisible(true);
    }

    // main
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(431, 276);

        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NiveauEau n = new NiveauEau();
        n.setSemiNiveau(1);

        IhmNiveauDeau ihm = new IhmNiveauDeau(n);
        ihm.afficherIhm();

        window.add(ihm);
        window.setVisible(true);
    }
}
