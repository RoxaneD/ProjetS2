package ElementsJeu;

import Cartes.CarteAventurier;
import Aventuriers.Aventurier;
import Enumerations.EtatTuile;
import Enumerations.NomTuile;
import java.util.ArrayList;

public class Tuile {

    // attributs
    private EtatTuile etat;  //Déclaration d'une variable etat de type EtatTuile
    private int posX;  //Déclaration d'une variable posX de type int
    private int posY;  //Déclaration d'une variable posY de type int
    private NomTuile nom;  //Déclaration d'une variable nom de type NomTuile
    private CarteAventurier emplacementAventurier;  //Déclaration d'une variable emplacementAventurier de type CarteAventurier
    private Tresor emplacementTresor;  //Déclaration d'une variable emplacementTresor de type Tresor
    private Grille grille;  //Déclaration d'une variable grille de type Grille
    private ArrayList<Aventurier> aventuriers;  //Déclaration d'un ArrayList aventuriers de type Aventurier

    // constructeurs d'une tuile dans une grille avec des coordonnées
    public Tuile(Grille grille, int posX, int posY){
        setEtat(EtatTuile.inexistante);  //Attribue la valeur inexistante à l'EtatTuile 
        setGrille(grille);  //Met à jour la valeur de grille
        setPosX(posX);  //Met à jour la valeur de posX
        setPosY(posY);  //Met à jour la valeur de posY
        setAventuriers();  //Met à jour la valeur d'aventuriers
    }
    
    //Constructeur d'une tuile dans une grille avec des coordonnées et un nom 
    public Tuile(Grille grille, int posX, int posY, NomTuile nom) {
        setEtat(EtatTuile.normal);  //Met à jour la variable EtatTuile avec la valeur normal
        setGrille(grille);  //Met à jour la variable grille
        setPosX(posX);  //Met à jour la variable posX
        setPosY(posY);  //met à jour la variable posY
        setNom(nom);  //Met à jour la variable nom
        setAventuriers();  //Met à jour l'ArrayList aventuriers
    }

    //Constructeur d'une tuile dans une grille avec des coordonnées, un nom et une CarteAventurier
    public Tuile(Grille grille, int posX, int posY, NomTuile nom, CarteAventurier emplacementAventurier) {
        setEtat(EtatTuile.normal);  //Met à jour la variable EtatTuile avec la valeur normal
        setGrille(grille);  //Met à jour la variable grille
        setPosX(posX);  //Met à jour la variable posX
        setPosY(posY);  //met à jour la variable posY
        setNom(nom);  //Met à jour la variable nom
        setEmplacementAventurier(emplacementAventurier);  //Met à jour la variable emplacementAventurier
        setAventuriers();  //Met à jour l'ArrayList aventuriers
    }

    //Constructeur d'une tuile dans une grille avec des coordonnées, un nom et un tresor
    public Tuile(Grille grille, int posX, int posY, NomTuile nom, Tresor emplacementTresor) {
        setEtat(EtatTuile.normal);  //Met à jour la variable EtatTuile avec la valeur normal
        setGrille(grille); //Met à jour la variable grille
        setPosX(posX);  //Met à jour la variable posX
        setPosY(posY);  //met à jour la variable posY
        setNom(nom);  //Met à jour la variable nom
        setEmplacementTresor(emplacementTresor);  //Met à jour la variable emplacementTresor
        setAventuriers();  //Met à jour l'ArrayList aventuriers
    }

    //Constructeur d'une tuile dans une grille avec des coordonnées, un nom, une CarteAventurier et un trésor
    public Tuile(Grille grille, int posX, int posY, NomTuile nom, CarteAventurier emplacementAventurier, Tresor emplacementTresor) {
        setEtat(EtatTuile.normal);  //Met à jour la variable EtatTuile avec la valeur normal
        setGrille(grille); //Met à jour la variable grille
        setPosX(posX);  //Met à jour la variable posX
        setPosY(posY);  //met à jour la variable posY
        setNom(nom);  //Met à jour la variable nom
        setEmplacementAventurier(emplacementAventurier);  //Met à jour la variable emplacementAventurier
        setEmplacementTresor(emplacementTresor);  //Met à jour la variable emplacementTresor
        setAventuriers();  //Met à jour l'ArrayList aventuriers
    }

    // setteurs
    public void setEtat(EtatTuile etat) {
        this.etat = etat;  //Met à jour la valeur d'état avec la valeur donnée en paramètre
    }

    public void setPosX(int posX) {
        this.posX = posX;  //Met à jour la valeur de posX avec la valeur donnée en paramètre
    }

    public void setPosY(int posY) {
        this.posY = posY;  //Met à jour la valeur de posY avec la valeur donnée en paramètre
    }

    public void setNom(NomTuile nom) {
        this.nom = nom;  //Met à jour la valeur de nom avec la valeur donnée en paramètre
    }

    public void setEmplacementAventurier(CarteAventurier emplacementAventurier) {
        this.emplacementAventurier = emplacementAventurier;  //Met à jour la valeur d'emplacementAventurier avec la valeur donnée en paramètre
    }

    public void setEmplacementTresor(Tresor emplacementTresor) {
        this.emplacementTresor = emplacementTresor;  //Met à jour la valeur d'emplacementTresor avec la valeur donnée en paramètre
    }

    public void setGrille(Grille grille) {
        this.grille = grille;  //Met à jour la valeur de grille avec la valeur donnée en paramètre
    }

    public void setAventuriers() {
        aventuriers = new ArrayList<>();  //Met à jour la valeur d'aventuriers avec la valeur donnée en paramètre
    }

    // getteurs
    public EtatTuile getEtat() {
        return etat;  //Retourne la valeur d'etat
    }

    public int getPosX() {
        return posX;  //Retourne la valeur de posX
    }

    public int getPosY() {
        return posY;  //Retourne la valeur de posY
    }

    public NomTuile getNom() {
        return nom;  //Retourne la valeur de nom
    }

    public CarteAventurier getEmplacementAventurier() {
        return emplacementAventurier;  //Retourne la valeur d'emplacementAventurier
    }

    public Tresor getEmplacementTresor() {
        return emplacementTresor;  //Retourne la valeur d'emplacementTresor
    }

    public Grille getGrille() {
        return grille;  //Retourne la valeur de grille
    }

    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;  //Retourne l'ArrayList d'aventuriers
    }

    // autres
    public void removeAventurier(Aventurier aventurier) {
        int i = 0;  //Initialise la variable int à 0
        while (aventuriers.get(i).getCarteAventurier().getNom() != aventurier.getCarteAventurier().getNom()) {  //Boucle tant que aventuriers.get(i) est différent d'aventurier
            i += 1;  //Itération
        }
        if (i < aventuriers.size()) {  //Vérifie que i est inférieur à la taille de l'ArrayList aventuriers
            aventuriers.remove(i);  //Supprime l'aventurier à l'indice i dans l'ArrayList aventuriers
        }
    }

    public void addAventurier(Aventurier aventurier) {
        aventuriers.add(aventurier);  //Ajoute un aventurier
        aventurier.removeTuile();  //Supprime la tuile où se trouve l'aventurier
        aventurier.addTuile(this);  //Ajoute la tuile de l'Aventurier
    }

    public void assecher() {
        setEtat(EtatTuile.normal);  //Met à jour la valeur d'EtatTuile avec pour valeur normal
    }

}
