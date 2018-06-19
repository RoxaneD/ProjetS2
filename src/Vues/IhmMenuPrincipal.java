package Vues;

import Controle.Action;
import Controle.Observateur;
import Controle.TypesActions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IhmMenuPrincipal extends JPanel implements Observe {

    // variable
    private Observateur observateur;
    
    // variables internes
    private int nombreJoueurs = 2; // représente le nombre de joueurs
    private boolean presse = false;
    private Integer width, height;

    // éléments de l'ihm
    private JFrame window;
    private JPanel panelTitre = new JPanel(new BorderLayout()); // représente l'espace pour le titre
    private JPanel panelJoueurs = new JPanel(); // représente les joueurs
    private JPanel panelInfos = new JPanel(new BorderLayout()); // pour : 'ajouter un joueur' + 'commencer' + 'regles du jeu'
    private JButton ajouter = new JButton("Ajouter un joueur");
    private JButton commencer = new JButton("Commencer");
    private JButton regles = new JButton("Règles du jeu");
    private Image image;
    private JTextField nom1 = new JTextField();
    private JTextField nom2 = new JTextField();
    private JTextField nom3 = new JTextField();
    private JTextField nom4 = new JTextField();
    private JTextField nom5 = new JTextField();
    private JTextField nom6 = new JTextField();
    private JLabel joueur1 = new JLabel("                   Joueur n°1 : ");
    private JLabel joueur2 = new JLabel("                   Joueur n°2 : ");
    private JLabel joueur3 = new JLabel("                   Joueur n°3 : ");
    private JLabel joueur4 = new JLabel("                   Joueur n°4 : ");
    private JLabel joueur5 = new JLabel("                   Joueur n°5 : ");
    private JLabel joueur6 = new JLabel("                   Joueur n°6 : ");
    private JButton supp3 = new JButton("X");
    private JButton supp4 = new JButton("X");
    private JButton supp5 = new JButton("X");
    private JButton supp6 = new JButton("X");

    // constructeurs
    public IhmMenuPrincipal() {
        super();
        width = 508;
        height = 532;

        this.setLayout(new BorderLayout());
        this.setSize(508, 532);

        nom1.setText("joueur1");
        nom2.setText("joueur2");
        nom3.setText("joueur3");
        nom4.setText("joueur4");
        nom5.setText("joueur5");
        nom6.setText("joueur6");

        // IMAGE
        try {
            this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Image/ciel.png"));
        } catch (IOException ex) {
            System.err.println("Erreur de lecture de ciel.png");
        }

        // PANEL TITRE
        JPanel titre = new JPanel();
        JLabel jl = new JLabel("Ile Interdite");
        jl.setFont(new Font(jl.getFont().getName(), jl.getFont().getStyle(), 30));
        jl.setForeground(Color.white);
        titre.add(jl);
        titre.setOpaque(false);
        JPanel espace3 = new JPanel();
        JPanel espace4 = new JPanel();
        espace3.setOpaque(false);
        espace4.setOpaque(false);
        panelTitre.add(espace3, BorderLayout.NORTH);
        panelTitre.add(titre, BorderLayout.CENTER);
        panelTitre.add(espace4, BorderLayout.SOUTH);
        panelTitre.setOpaque(false);
        this.add(panelTitre, BorderLayout.NORTH);

        // PANEL JOUEURS
        panelJoueurs = new JPanel(new GridLayout(6, 2));
        panelJoueurs.setOpaque(false);
        this.add(panelJoueurs, BorderLayout.CENTER);

        JPanel gauche1 = new JPanel(new BorderLayout());
        JPanel espace17 = new JPanel();
        espace17.setOpaque(false);
        gauche1.add(espace17, BorderLayout.CENTER);
        gauche1.add(joueur1, BorderLayout.EAST);
        panelJoueurs.add(gauche1);
        JPanel p1 = new JPanel(new BorderLayout());
        JLabel espace5 = new JLabel("  ");
        JLabel espace6 = new JLabel("  ");
        p1.add(espace5, BorderLayout.NORTH);
        p1.add(nom1, BorderLayout.CENTER);
        p1.add(espace6, BorderLayout.SOUTH);
        p1.setOpaque(false);
        panelJoueurs.add(p1);

        JPanel gauche2 = new JPanel(new BorderLayout());
        JPanel espace18 = new JPanel();
        espace18.setOpaque(false);
        gauche2.add(espace18, BorderLayout.CENTER);
        gauche2.add(joueur2, BorderLayout.EAST);
        panelJoueurs.add(gauche2);
        JPanel p2 = new JPanel(new BorderLayout());
        JLabel espace7 = new JLabel("  ");
        JLabel espace8 = new JLabel("  ");
        p2.add(espace7, BorderLayout.NORTH);
        p2.add(nom2, BorderLayout.CENTER);
        p2.add(espace8, BorderLayout.SOUTH);
        p2.setOpaque(false);
        panelJoueurs.add(p2);

        JPanel gauche3 = new JPanel(new BorderLayout());
        gauche3.add(supp3, BorderLayout.CENTER);
        gauche3.add(joueur3, BorderLayout.EAST);
        panelJoueurs.add(gauche3);
        JPanel p3 = new JPanel(new BorderLayout());
        JLabel espace9 = new JLabel("  ");
        JLabel espace10 = new JLabel("  ");
        p3.add(espace9, BorderLayout.NORTH);
        p3.add(nom3, BorderLayout.CENTER);
        p3.add(espace10, BorderLayout.SOUTH);
        p3.setOpaque(false);
        panelJoueurs.add(p3);

        JPanel gauche4 = new JPanel(new BorderLayout());
        gauche4.add(supp4, BorderLayout.CENTER);
        gauche4.add(joueur4, BorderLayout.EAST);
        panelJoueurs.add(gauche4);
        JPanel p4 = new JPanel(new BorderLayout());
        JLabel espace11 = new JLabel("  ");
        JLabel espace12 = new JLabel("  ");
        p4.add(espace11, BorderLayout.NORTH);
        p4.add(nom4, BorderLayout.CENTER);
        p4.add(espace12, BorderLayout.SOUTH);
        p4.setOpaque(false);
        panelJoueurs.add(p4);

        JPanel gauche5 = new JPanel(new BorderLayout());
        gauche5.add(supp5, BorderLayout.CENTER);
        gauche5.add(joueur5, BorderLayout.EAST);
        panelJoueurs.add(gauche5);
        JPanel p5 = new JPanel(new BorderLayout());
        JLabel espace13 = new JLabel("  ");
        JLabel espace14 = new JLabel("  ");
        p5.add(espace13, BorderLayout.NORTH);
        p5.add(nom5, BorderLayout.CENTER);
        p5.add(espace14, BorderLayout.SOUTH);
        p5.setOpaque(false);
        panelJoueurs.add(p5);

        JPanel gauche6 = new JPanel(new BorderLayout());
        gauche6.add(supp6, BorderLayout.CENTER);
        gauche6.add(joueur6, BorderLayout.EAST);
        panelJoueurs.add(gauche6);
        JPanel p6 = new JPanel(new BorderLayout());
        JLabel espace15 = new JLabel("  ");
        JLabel espace16 = new JLabel("  ");
        p6.add(espace15, BorderLayout.NORTH);
        p6.add(nom6, BorderLayout.CENTER);
        p6.add(espace16, BorderLayout.SOUTH);
        p6.setOpaque(false);
        panelJoueurs.add(p6);

        nom3.setVisible(false);
        nom4.setVisible(false);
        nom5.setVisible(false);
        nom6.setVisible(false);
        joueur3.setVisible(false);
        joueur4.setVisible(false);
        joueur5.setVisible(false);
        joueur6.setVisible(false);
        supp3.setVisible(false);
        supp4.setVisible(false);
        supp5.setVisible(false);
        supp6.setVisible(false);
        supp3.setBackground(Color.WHITE);
        supp4.setBackground(Color.WHITE);
        supp5.setBackground(Color.WHITE);
        supp6.setBackground(Color.WHITE);
        gauche1.setOpaque(false);
        gauche2.setOpaque(false);
        gauche3.setOpaque(false);
        gauche4.setOpaque(false);
        gauche5.setOpaque(false);
        gauche6.setOpaque(false);

        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPressed() && nombreJoueurs < 6) {
                    nombreJoueurs = nombreJoueurs + 1;
                }
                repaint();
            }
        });

        supp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreJoueurs = nombreJoueurs - 1;
                repaint();
            }
        });

        supp4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreJoueurs = nombreJoueurs - 1;
                repaint();
            }
        });

        supp5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreJoueurs = nombreJoueurs - 1;
                repaint();
            }
        });

        supp6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreJoueurs = nombreJoueurs - 1;
                repaint();
            }
        });
        // PANEL INFOS
        JPanel ajout = new JPanel(new BorderLayout());
        JPanel espace1 = new JPanel();
        JPanel espace2 = new JPanel();
        espace1.setOpaque(false);
        espace2.setOpaque(false);
        ajout.add(espace1, BorderLayout.WEST);
        ajout.add(ajouter);
        ajout.add(espace2, BorderLayout.EAST);
        ajout.setOpaque(false);
        regles.setBackground(Color.WHITE);
        ajouter.setBackground(Color.WHITE);
        commencer.setBackground(Color.WHITE);
        panelInfos.add(regles, BorderLayout.WEST);
        panelInfos.add(ajout, BorderLayout.CENTER);
        panelInfos.add(commencer, BorderLayout.EAST);
        panelInfos.setOpaque(false);
        this.add(panelInfos, BorderLayout.SOUTH);

        commencer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> nomJoueurs = new ArrayList<>();
                int i = 1;
                int b = getNombreJoueurs();
                while (i <= b) {
                    nomJoueurs.add(getNomJoueurs().get(i - 1));
                    i += 1;
                }
                Action a = new Action(TypesActions.commencerPartie, nomJoueurs);
                notifierObservateur(a);
                repaint();
            }
        });

        regles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Action a = new Action(TypesActions.reglesJeu);
                notifierObservateur(a);
                repaint();
            }
        });

        this.setVisible(true);

    }

    // setteurs

    public void setCommencer(JButton commencer) {
        this.commencer = commencer;
    }

    public void setPressed(boolean p) {
        this.presse = p;
    }

    // getteurs
    public JPanel getWindow() {
        return this;
    }

    public int getNombreJoueurs() {
        return nombreJoueurs;
    }

    public boolean isPressed() {
        return presse;
    }

    public ArrayList<String> getNomJoueurs() {
        ArrayList<String> a = new ArrayList<>();
        a.add(nom1.getText());
        a.add(nom2.getText());
        a.add(nom3.getText());
        a.add(nom4.getText());
        a.add(nom5.getText());
        a.add(nom6.getText());
        return a;
    }

    // autres
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, width, height, null, this);
        supp3.setVisible(false);
        supp4.setVisible(false);
        supp5.setVisible(false);
        supp6.setVisible(false);

        if (nombreJoueurs == 2) {
            nom3.setVisible(false);
            joueur3.setVisible(false);
            nom4.setVisible(false);
            joueur4.setVisible(false);
            nom5.setVisible(false);
            joueur5.setVisible(false);
            nom6.setVisible(false);
            joueur6.setVisible(false);
        } else if (nombreJoueurs == 3) {
            nom3.setVisible(true);
            joueur3.setVisible(true);
            supp3.setVisible(true);
            nom4.setVisible(false);
            joueur4.setVisible(false);
            nom5.setVisible(false);
            joueur5.setVisible(false);
            nom6.setVisible(false);
            joueur6.setVisible(false);
        } else if (nombreJoueurs == 4) {
            nom4.setVisible(true);
            joueur4.setVisible(true);
            supp4.setVisible(true);
            nom5.setVisible(false);
            joueur5.setVisible(false);
            nom6.setVisible(false);
            joueur6.setVisible(false);
        } else if (nombreJoueurs == 5) {
            nom5.setVisible(true);
            joueur5.setVisible(true);
            supp5.setVisible(true);
            nom6.setVisible(false);
            joueur6.setVisible(false);
        } else if (nombreJoueurs == 6) {
            nom6.setVisible(true);
            joueur6.setVisible(true);
            supp6.setVisible(true);
        }
        this.setPreferredSize(new Dimension(509, 532));
        this.setPreferredSize(new Dimension(508, 532));
    }

    public void afficherIhm() {
        window = new JFrame();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(508, 532);

        // Centrage de la fenêtre sur l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((dim.width / 2) - 225, (dim.height / 2) - 241);

        window.add(this);

        window.setVisible(true);
        repaint();
    }

    public void cacherIhm() {
        window.setVisible(false);
    }

    public static void main(String[] args) {
        IhmMenuPrincipal ihm = new IhmMenuPrincipal();

        ihm.afficherIhm();
    }

    @Override
    public void addObservateur(Observateur o) {
        this.observateur = o;
    }

    @Override
    public void notifierObservateur(Action action) {
        if (observateur != null) {
            observateur.traiterAction(action);
        }
        window.setPreferredSize(new Dimension(509, 532));
        window.setPreferredSize(new Dimension(508, 532));
    }
}
