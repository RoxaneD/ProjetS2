package Vues;

import Controle.Action;
import Controle.TypesActions;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IhmReglesDuJeu extends JPanel {

    // attributs
    private IhmObserve ihm;

    private Integer width, height;

    private JFrame window; 
    private JPanel titre;
    private JPanel informations;
    private JPanel options;
    private JButton fermer;

    // constructeur
    public IhmReglesDuJeu(IhmObserve ihm) {
        super();
        width = 508;
        height = 532;
        this.setLayout(new BorderLayout());
        this.setSize(508, 532);
        setIhmObserve(ihm);

        titre = new JPanel();
        titre.add(new JLabel("Règle du jeu : Île Interdite"));
        add(titre, BorderLayout.NORTH);

        informations = new JPanel(new GridLayout(5, 1));
        informations.add(new JLabel("Blabla1"));
        informations.add(new JLabel("Blabla2"));
        informations.add(new JLabel("Blabla3"));
        informations.add(new JLabel("Blabla4"));
        informations.add(new JLabel("Blabla5"));
        add(informations, BorderLayout.CENTER);

        options = new JPanel(new BorderLayout());
        fermer = new JButton("Fermer");
        options.add(fermer, BorderLayout.EAST);
        add(options, BorderLayout.SOUTH);

        fermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Action a = new Action(TypesActions.fermerReglesJeu);
                getIhmObserve().notifierObservateur(a);
            }
        });

        setVisible(false);
    }

    // setteurs
    public void setIhmObserve(IhmObserve ihm) {
        this.ihm = ihm;
    }

    // getteurs
    public IhmObserve getIhmObserve() {
        return ihm;
    }

    // autres méthodes
    public void afficherIhm() {
        window = new JFrame();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(508, 532);

        // Centrage de la fenêtre sur l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((dim.width / 6) - 225, (dim.height / 2) - 241);

        window.add(this);

        this.setVisible(true);
        window.setVisible(true);
        this.repaint();
    }
    
    public void cacherIhm(){
        window.setVisible(false);
    }

    // main
    public static void main(String[] args) {
        IhmObserve ihmObserve = new IhmObserve();
        IhmReglesDuJeu ihm = new IhmReglesDuJeu(ihmObserve);

        ihm.afficherIhm();
    }
}
