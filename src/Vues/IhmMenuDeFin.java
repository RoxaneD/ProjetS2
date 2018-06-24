package Vues;

import Controle.Action;
import Controle.Observateur;
import Controle.TypesActions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class IhmMenuDeFin implements Observe{

    // BORDURES :D
    private static Border noir = BorderFactory.createLineBorder(Color.black, 1);
    private static Border bleu = BorderFactory.createLineBorder(Color.blue, 1);
    private static Border vert = BorderFactory.createLineBorder(Color.green, 1);
    private static Border rouge = BorderFactory.createLineBorder(Color.red, 1);
    private static Border jaune = BorderFactory.createLineBorder(Color.yellow, 1);

    // attributs
    private Observateur observateur;
    
    private JFrame window = new JFrame();
    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel panelHaut = new JPanel(new BorderLayout());
    private JPanel panelBas = new JPanel(new BorderLayout());
    private JPanel panelMilieu = new JPanel();
    private JButton quitter = new JButton("Fermer le jeu");
    private JButton recommencer = new JButton("Rejouer");
    private JButton menu = new JButton("Revenir au menu principal");
    private JLabel resultat = new JLabel();

    // constructeur
    public IhmMenuDeFin(String s) {
        window = new JFrame();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(450, 180);

        // Centrage de la fenêtre sur l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((dim.width / 2) - 225, (dim.height / 2) - 241);

        panelHaut.add(quitter, BorderLayout.EAST);
        panel.add(panelHaut, BorderLayout.NORTH);
        setResultat(s);
        panelMilieu.add(resultat);
        panel.add(panelMilieu, BorderLayout.CENTER);
        panelBas.add(menu, BorderLayout.EAST);
        panelBas.add(recommencer, BorderLayout.WEST);
        panel.add(panelBas, BorderLayout.SOUTH);

        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Action a = new Action(TypesActions.quitter);
                notifierObservateur(a);
            }
        });
        
        recommencer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Action a = new Action(TypesActions.recommencer);
                notifierObservateur(a);
            }
        });
        
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Action a = new Action(TypesActions.revenirMenu);
                notifierObservateur(a);
            }
        });

        quitter.setVisible(true);
        menu.setVisible(true);
        resultat.setVisible(true);
        panelBas.setVisible(true);
        panel.setVisible(true);
        quitter.setOpaque(false);
        menu.setOpaque(false);
        resultat.setOpaque(false);
        panelBas.setOpaque(false);
        panel.setOpaque(false);

        window.add(panel);
        this.window.setVisible(false);
    }

    // méthodes
    public void setResultat(String s) {
        this.resultat.setText(s);
    }
    
    @Override
    public void addObservateur(Observateur o) {
        this.observateur = o;
    }

    @Override
    public void notifierObservateur(Action action) {
        this.observateur.traiterAction(action);
    }

    public JFrame getWindow() {
        return window;
    }

    public static void main(String[] args) {
        IhmMenuDeFin ihm = new IhmMenuDeFin("Bravo !");
        ihm.getWindow().setVisible(true);
    }
}
