package Vues;

import Controle.Action;
import Controle.TypesActions;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class IHM_Menu extends Observe {

    // attributs
    private IHM_intro ihm;

    // Constructeur
    public IHM_Menu() {
        ihm = new IHM_intro();

        ihm.getRegles().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Action a = new Action(TypesActions.reglesJeu);
                notifierObservateur(a);
            }

        });

    }
    // méthodes
    public IHM_intro getIhm() {
        return ihm;
    }

    public void afficherIhm() {
        JFrame window = new JFrame();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(508, 532);

        // Centrage de la fenêtre sur l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((dim.width / 2) - 225, (dim.height / 2) - 150);

        IHM_intro ihm = new IHM_intro();
        window.add(ihm);

        window.setVisible(true);
        ihm.repaint();
    }
}
