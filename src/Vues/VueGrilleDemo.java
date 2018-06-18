package Vues;

//Importation de tous les packages Controle, ElementsJeu, java.awt, java.util, javax.swing
import Controle.Action;
import Controle.TypesActions;
import ElementsJeu.Grille;
import ElementsJeu.Tuile;
import Enumerations.EtatTuile;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class VueGrilleDemo extends Observe {

    // attributs - interne
    private ArrayList<Tuile> tuiles = new ArrayList<>();  //Déclaration d'un ArrayList tuiles de type Tuile et initialisation de ce dernier

    // attributs - mise en forme
    private JFrame window;  //Déclaration d'une variable window de type JFrame
    private JPanel plateauTuiles;  //Déclaration d'une variable plateauTuiles de type JPanel 
    private HashMap<Tuile, JPanel> fondTuiles = new HashMap<>();  //Déclaration d'une HashMap fondTuiles de type Tuile,JPanel
    private HashMap<Tuile, JButton> devantTuiles = new HashMap<>();  //Déclaration d'une HashMap devantTuiles de type Tuile, JButton
    
    private Dimension dimension;  //Déclaration d'une variable dimension de type Dimension

    // constructeurs
    public VueGrilleDemo(Grille grille) {
        setTuiles(grille);  //Mise à jour de grille
        this.window = new JFrame();  //window est instancié en JFrame
        window.setSize(1000/2, 700/2);  //On définie la hauteur et la largeur de la fenêtre window
        window.setTitle("Grille du Jeu");  //On modifie le titre de la fenêtre
        dimension = window.getSize();  //dimension prend les valeurs de window
        
        
        plateauTuiles = new JPanel(new GridLayout(6, 6));  //Définition de plateauTuiles en JPanel composé d'un GridLayout lui même composé de 6 lignes et 6 colonnes
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);  //Création d'une ligne noir pour les contours des tuiles
 
        for (Tuile tuile2 : grille.getTuiles()) {
           
            
            // création du 1er fond de la tuile (c'est un panel) - indique si la tuile est séléctionnée ou non - rajout dans fondTUiles
            JPanel panelFondTuile = new JPanel();  //Déclaration et initialisation d'une variable panelFondTuile de type JPanel
            panelFondTuile.setBackground(Color.white);  //Mise à jour du fond de la variable panelFondTuile
            panelFondTuile.setSize(dimension.width / 6, dimension.height / 6);  //Mise à jour de la taille du JPanel panelFondTuile

            if (tuile2.getEtat() != EtatTuile.inexistante) {  //Vérifie si l'état de la tuile est différent d'inexistant
                // on délimite la tuile
                panelFondTuile.setBorder(blackline);  //Met à jour les bords des tuiles 

                // création du 2ème fond de la tuile (c'est un panel) 
                // contient un bouton qui indique son état 
                // + contient un ou plusieurs panels qui indiquent : son nom + emplacement aventuriers/trésors - rajout dans devantTuiles
                JPanel panelDevantTuile = new JPanel(new BorderLayout());
                panelDevantTuile.setSize(new Dimension(((int) ((panelFondTuile.getSize().getWidth()) * (0.9))), ((int) (((panelFondTuile.getSize().getHeight()) * (0.9))))));

                // création du bouton qui contient l'état de la tuile
                JButton boutonEtat = new JButton();
                boutonEtat.addActionListener(
                        new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Action action;  //Déclaration d'une nouvelle Action
                        if (panelFondTuile.getBackground() == Color.RED) {  //Vérifie si le fond de la tuile est rouge
                            action = new Action(TypesActions.deplacement, tuile2);  //Définie une nouvelle action possible qui est deplacement ici
                        } else {  //Sinon
                            action = new Action(TypesActions.assechement, tuile2);  //Définie une action qui est l'assèchement
                        }
                        notifierObservateur(action);  //Envoi un message
                    }
                });
                boutonEtat.setEnabled(false);  //Le bouton état est désactivé
                boutonEtat.setPreferredSize(new Dimension(((int) ((panelFondTuile.getSize().getWidth()) * (0.9))), ((int) (((panelFondTuile.getSize().getHeight()) * (0.7))))));  //Mise  à jour de la taille du bouton

                //  création de panelInfo : contient les informations de la tuile
                JPanel panelInfo = new JPanel(new BorderLayout());  //Déclaration et instanciation du JPanel panelInfo et redéfinition en BroderLayout
                JLabel labelNomTuile = new JLabel(tuile2.getNom().toString());  //La variable labelNomTuile récupère le nom de la tuile
                labelNomTuile.setSize(((int) ((panelFondTuile.getSize().getWidth()) * (0.9))), ((int) ((panelFondTuile.getSize().getHeight()) * (0.15))));  //Mise à jour de la taille du labelNomTuile
                Font font = new Font(Font.SANS_SERIF, Font.BOLD, 9);  //Déclare et instancie la variable font de type Font
                labelNomTuile.setFont(font);  //Met à jour la variable font
                panelInfo.setPreferredSize(new Dimension(((int) ((panelFondTuile.getSize().getWidth()) * (0.9))), ((int) (((panelFondTuile.getSize().getHeight()) * (0.2))))));  //Redifinition de la taille de panelInfo
                panelInfo.add(labelNomTuile);  //Ajout de labelNomTuile dans le JPanel panelInfo

                // ajouts des deux compartiements dans panelDevantTuile
                panelDevantTuile.add(boutonEtat, BorderLayout.NORTH);  //Ajout du bouton boutonEtat dans la partie Nord du JPanel panelDevantTuile
                panelDevantTuile.add(panelInfo, BorderLayout.SOUTH);  //Ajout du panelInfo dans la partie Sud du JPanel panelDevantTuile

                if (tuile2.getEtat() == EtatTuile.inondee) {  //Vérifie si l'état de tuile2 correspond à inondé
                    panelDevantTuile.getComponent(0).setBackground(Color.CYAN);  //Redéfinie le fond du panel panelDevantTuile avec la couleur Cyan
                } else {  //Sinon
                    if (tuile2.getEtat() == EtatTuile.submergee) {  //Vérifie si l'état de tuile2 correspond à submergé
                        panelDevantTuile.getComponent(0).setBackground(Color.blue);  //Redéfinie le fond du panel panelDevantTuile avec la couleur Bleu
                    } else {  //Sinon
                        if (tuile2.getEtat() == EtatTuile.normal) {  //Vérifie si l'état de tuile 2 correspond à normal
                            panelDevantTuile.getComponent(0).setBackground(Color.orange);  //Redéfinie le fond du panel panelDevantTuile avec la couleur Orange
                        }
                    }
                }
                devantTuiles.put(tuile2, boutonEtat);  //Ajout de tuile2 et boutonEtat dans l'HashMap devantTuiles
                panelFondTuile.add(panelDevantTuile);  //Ajout de panelDevantTuile dans panelFondTuile
            }
            fondTuiles.put(tuile2, panelFondTuile);  //Ajout de tuile2 et panelFondTuile dans fondTuiles
            plateauTuiles.add(panelFondTuile);  //Ajout de panelFondTuile dans plateauTuiles
        }
        window.add(plateauTuiles);  //Ajout de plateauTuiles dans window
       //  window.setVisible(true);  //Rend window visible
    }

    // setteurs
    public void setTuiles(Grille grille) {
        for (Tuile t : grille.getTuiles()) {
            this.tuiles.add(t);  //Ajout de la tuile dans l'ArrayList tuiles 
        }
    }

    public void setFondTuiles(HashMap<Tuile, JPanel> fondTuiles) {
        this.fondTuiles = fondTuiles;  //fondTuiles prend la valeur donnée en paramètre
    }

    public void setDevantTuiles(HashMap<Tuile, JButton> devantTuiles) {
        this.devantTuiles = devantTuiles;  //devantTuiles prend la valeur donnée en paramètre
    }

    public void setWindow(JFrame window) {
        this.window = window;  //window prend la valeur donné en paramètre
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
    
    

    // getteurs
    public JPanel getPlateauTuiles() {
        return plateauTuiles;
    }
    
    
    public ArrayList<Tuile> getTuiles() {
        return tuiles;  //Retourne les tuiles contenues dans l'ArrayList tuiles
    }

    public HashMap<Tuile, JPanel> getFondTuiles() {
        return fondTuiles;  //Retourne les valeurs contenues dans l'HashMap fondTuiles
    }

    public HashMap<Tuile, JButton> getDevantTuiles() {
        return devantTuiles;  //Retournes les valeurs contenues dans l'HashMap devantTuiles
    }

    public JFrame getWindow() {
        return window;  //retourne window
    }

    public Dimension getDimension() {
        return dimension;
    }

    // autres méthodes
    public static void main(String[] args) {
    }
    

    public void afficherTuilesPossiblesDeplacement(ArrayList<Tuile> t2) {
        revenirGrilleDepart();  //Appel de la méthode pour réinitialiser la grille
        for (Tuile tuile : t2) {
            fondTuiles.get(tuile).setBackground(Color.RED);  //Mise à jour des tuiles en mettant un fond Rouge
            devantTuiles.get(tuile).setEnabled(true);  //Rend les tuils actives
        }
    }

    public void afficherTuilesPossiblesAssechement(ArrayList<Tuile> t2) {
        revenirGrilleDepart();  //Appel de la méthode pour réinitialiser la grille
        for (Tuile tuile : t2) {
            fondTuiles.get(tuile).setBackground(Color.MAGENTA);  //Redéfinie la couleur de fond en Magenta
            devantTuiles.get(tuile).setEnabled(true);  //Rend les tuiles actives
        }
    }

    public void afficherTuileActuelle(Tuile t) {
        fondTuiles.get(t).setBackground(Color.black);  //Rend la tuile Noir
    }

    public void revenirGrilleDepart() {
        for (Tuile tuile : tuiles) {
            fondTuiles.get(tuile).setBackground(Color.white);  //Mert la couleur Blanche en fond dans la tuile
            if (tuile.getEtat() != EtatTuile.inexistante) {  //Vérifie si l'état de la tuile est différent d'inexistant
                devantTuiles.get(tuile).setEnabled(false);  //rend la tuile inactives
            }
            if (tuile.getEtat() == EtatTuile.inondee) {  //Vérifie si l'état de la tuile correspond à inondé
                getDevantTuiles().get(tuile).setBackground(Color.CYAN);  //Mets la couleur Cyan en fond
            } else {  //Sinon
                if (tuile.getEtat() == EtatTuile.submergee) {  //Vérifie si l'état de la tuile correspond à submergé
                    getDevantTuiles().get(tuile).setBackground(Color.blue);  //Mets la couleur Bleue en fond
                } else {  //Sinon
                    if (tuile.getEtat() == EtatTuile.normal) {  //Vérifie si l'état de la tuile correspond a normal
                        getDevantTuiles().get(tuile).setBackground(Color.orange);  //mets la couleur Orange en fond
                    }
                }
            }
        }
    }

}
