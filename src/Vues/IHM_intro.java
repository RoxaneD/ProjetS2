/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author fourniep
 */
public class IHM_intro {
     private JButton ajouter = new JButton("Ajouter Joueur");
     private JFrame fenetre = new JFrame();
     private int i;
     private JPanel panneau = new JPanel();
     private boolean presse = false;
     private JPanel panelCentre;
     private Image image ;
     private Integer width, height ;


     
    public IHM_intro() {
        i=2;
        width =500;
        height=500;
        /*try {
            this.image = ImageIO.read(new File(System.getProperty("user.dir") +"/src/Pictures/fortnite.png"));
       
            //Pour une image de fond
            //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }*/ 
        fenetre.setTitle("Inscription des joueurs");
        fenetre.setSize(500,500);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ajouter.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if(!isPressed() && i<6){
                    System.out.println("Bouton cliqué");
                    i=i+1;
                    System.out.println("i=i+1");
                    panelCentre.add(new JLabel("Nom Joueur "+ i +" : ", JLabel.RIGHT)); 
                    System.out.println("add panelCentre");
                    JTextField champNom3 = new JTextField();
                    panelCentre.add(champNom3);
                    System.out.println("ajout textfield");
                    
                    //Redimensionnement pour actualiser la page MAIS A CHANGER PARCE QUE C'EST MOCHE !!!
                    fenetre.setSize(501, 501);
                    fenetre.setSize(500,500);
                } 
            }

            @Override
            public void mousePressed(MouseEvent e) {
               System.out.println("Bouton pressé"); 
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Bouton relâché"); 

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        
        panelCentre = new JPanel(new GridLayout(6,2));
        
        panelCentre.setOpaque(false);
        fenetre.add(panelCentre, BorderLayout.CENTER);
        panelCentre.add(new JLabel("Nom Joueur 1 : ", JLabel.RIGHT));        
        JTextField champNom = new JTextField();
        panelCentre.add(champNom);
        
        panelCentre.add(new JLabel("Nom joueur 2 : ",JLabel.RIGHT));
        JTextField champNom1 = new JTextField();
        panelCentre.add(champNom1);
        fenetre.add(ajouter,BorderLayout.SOUTH);
        
        

        fenetre.setVisible(true);
    }
    
    public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, width, height, null);
        
}
    
    public JFrame getWindow() {
        return fenetre;
    }
    
    public boolean isPressed() {
        return presse;
    }
    
            
   
    
    public void setPressed(boolean p) {
        this.presse = p;
    }
    
    public boolean getPressed() {
        return this.presse;
    }  

    
        
    
    public static void main(String[] args) {
        JFrame window = new JFrame() ;
        window.setSize(450, 300);
        // Centrage de la fenêtre sur l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        window.setLocation(100, dim.height/2-window.getSize().height/2);
        IHM_intro ihm = new IHM_intro();
        ihm.getWindow().setVisible(true);
        
    }    

        

    
}
