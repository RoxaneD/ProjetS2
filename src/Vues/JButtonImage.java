package Vues;


import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;


public class JButtonImage extends JButton { 
 public Image img; 


 public void setImage(Image img) { 
  this.img = img; 
  repaint(); 
 } 


 public void paintComponent(Graphics g) { 
  super.paintComponent(g); 
  if (img != null) { 
   g.drawImage(img, 0, 0, 100, 110, null); 
  } 
 } 


 public Image getImage() { 
  return img; 
 } 
} 
