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

// début des modifications
public class IhmNiveauDeau extends JLayeredPane {

    // attributs
    private Image image;
    private NiveauEau niveauEau;

    // constructeur
    public IhmNiveauDeau(NiveauEau niveauEau) {
        setNiveauEau(niveauEau);
        this.setVisible(false);
        this.repaint();
    }

    // setteurs
    public void setNiveauEau(NiveauEau niveauEau) {
        this.niveauEau = niveauEau;
    }

    // autres méthodes
    @Override
    public void paintComponent(Graphics g) {
        try {
            this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/Niveau.png"));
        } catch (IOException ex) {
            System.err.println("Erreur de lecture de Niveau.png");
        }
        g.drawImage(image, 0, 38, 421, 164, null); 

        int i = niveauEau.getSemiNiveau();
        try {
            this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/stick.png"));
        } catch (IOException ex) {
            System.err.println("Erreur de lecture de stick.png");
        }
        g.drawImage(image, 408 - (2 * 35) - ((i - 1) * 35), 198, 20, 32, null); 

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
