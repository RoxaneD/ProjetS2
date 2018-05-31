package ElementsJeu;

import Cartes.CarteAventurier;
import Aventuriers.Aventurier;
import Enumerations.EtatTuile;
import Enumerations.NomTuile;
import java.util.ArrayList;

public class Tuile {

    // attributs
    private EtatTuile etat;
    private int posX;
    private int posY;
    private NomTuile nom;
    private CarteAventurier emplacementAventurier;
    private Tresor emplacementTresor;
    private Grille grille;
    private ArrayList<Aventurier> aventuriers;

    // constructeurs
    public Tuile(Grille grille, int posX, int posY){
        setEtat(EtatTuile.inexistante);
        setGrille(grille);
        setPosX(posX);
        setPosY(posY);
        setAventuriers();
    }
    
    public Tuile(Grille grille, int posX, int posY, NomTuile nom) {
        setEtat(EtatTuile.normal);
        setGrille(grille);
        setPosX(posX);
        setPosY(posY);
        setNom(nom);
        setAventuriers();
    }

    public Tuile(Grille grille, int posX, int posY, NomTuile nom, CarteAventurier emplacementAventurier) {
        setEtat(EtatTuile.normal);
        setGrille(grille);
        setPosX(posX);
        setPosY(posY);
        setNom(nom);
        setEmplacementAventurier(emplacementAventurier);
        setAventuriers();
    }

    public Tuile(Grille grille, int posX, int posY, NomTuile nom, Tresor emplacementTresor) {
        setEtat(EtatTuile.normal);
        setGrille(grille);
        setPosX(posX);
        setPosY(posY);
        setNom(nom);
        setEmplacementTresor(emplacementTresor);
        setAventuriers();
    }

    public Tuile(Grille grille, int posX, int posY, NomTuile nom, CarteAventurier emplacementAventurier, Tresor emplacementTresor) {
        setEtat(EtatTuile.normal);
        setGrille(grille);
        setPosX(posX);
        setPosY(posY);
        setNom(nom);
        setEmplacementAventurier(emplacementAventurier);
        setEmplacementTresor(emplacementTresor);
        setAventuriers();
    }

    // setteurs
    public void setEtat(EtatTuile etat) {
        this.etat = etat;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setNom(NomTuile nom) {
        this.nom = nom;
    }

    public void setEmplacementAventurier(CarteAventurier emplacementAventurier) {
        this.emplacementAventurier = emplacementAventurier;
    }

    public void setEmplacementTresor(Tresor emplacementTresor) {
        this.emplacementTresor = emplacementTresor;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public void setAventuriers() {
        aventuriers = new ArrayList<>();
    }

    // getteurs
    public EtatTuile getEtat() {
        return etat;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public NomTuile getNom() {
        return nom;
    }

    public CarteAventurier getEmplacementAventurier() {
        return emplacementAventurier;
    }

    public Tresor getEmplacementTresor() {
        return emplacementTresor;
    }

    public Grille getGrille() {
        return grille;
    }

    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;
    }

    // autres
    public void removeAventurier(Aventurier aventurier) {
        int i = 0;
        while (aventuriers.get(i) != aventurier) {
            i += 1;
        }
        if (i < aventuriers.size()) {
            aventuriers.remove(i);
        }
    }

    public void addAventurier(Aventurier aventurier) {
        aventuriers.add(aventurier);
    }

    public void assecher() {
        setEtat(EtatTuile.normal);
    }

}
