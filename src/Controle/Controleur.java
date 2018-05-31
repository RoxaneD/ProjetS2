// A COMPLETER : Faire les getteurs autres
package Controle;

import Aventuriers.Aventurier;
import Cartes.CarteTresor;
import Cartes.CarteInondation;
import Cartes.CarteAventurier;
import ElementsJeu.Grille;
import ElementsJeu.NiveauEau;
import ElementsJeu.Tresor;
import ElementsJeu.Tuile;
import Tas.DefausseInondations;
import Tas.DefausseTresors;
import Tas.TasAventuriers;
import Tas.TasInondations;
import Tas.TasPoubelle;
import Tas.TasTresors;
import Vues.VueAventurier;
import java.util.HashMap;

public class Controleur implements Observateur {

    // attributs
    private HashMap<String, Aventurier> joueurs; // tous les joueurs
    private VueAventurier vueAventurier;         // une pour chaque joueur (il n'y en a qu'une seule à la fois à l'écran)
    private NiveauEau niveauEau;                 
    private Tresor tresor1;
    private Tresor tresor2;
    private Tresor tresor3;
    private Tresor tresor4;
    private Grille grille;
    private TasPoubelle poubelle;
    private TasAventuriers tasAventuriers;
    private DefausseTresors defausseTresor;
    private TasTresors tasTresor;
    private DefausseInondations defausseInondation;
    private TasInondations tasInondation;

    // constructeur
    public Controleur() {
    }

    // setteurs
    public void setVueAventurier(VueAventurier vueAventurier) {
        this.vueAventurier = vueAventurier;
    }

    public void setNiveauEau(NiveauEau niveauEau) {
        this.niveauEau = niveauEau;
    }

    public void setTresor1(Tresor tresor1) {
        this.tresor1 = tresor1;
    }

    public void setTresor2(Tresor tresor2) {
        this.tresor2 = tresor2;
    }

    public void setTresor3(Tresor tresor3) {
        this.tresor3 = tresor3;
    }

    public void setTresor4(Tresor tresor4) {
        this.tresor4 = tresor4;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public void setJoueurs(HashMap<String, Aventurier> joueurs) {
        this.joueurs = new HashMap<>();
    }

    public void setPoubelle(TasPoubelle poubelle) {
        this.poubelle = poubelle;
    }

    public void setTasAventuriers(TasAventuriers tasAventuriers) {
        this.tasAventuriers = tasAventuriers;
    }

    public void setDefausseTresor(DefausseTresors defausseTresor) {
        this.defausseTresor = defausseTresor;
    }

    public void setTasTresor(TasTresors tasTresor) {
        this.tasTresor = tasTresor;
    }

    public void setDefausseInondation(DefausseInondations defausseInondation) {
        this.defausseInondation = defausseInondation;
    }

    public void setTasInondation(TasInondations tasInondation) {
        this.tasInondation = tasInondation;
    }

    // getteurs attributs
    public VueAventurier getVueAventurier() {
        return vueAventurier;
    }

    public NiveauEau getNiveauEau() {
        return niveauEau;
    }

    public Tresor getTresor1() {
        return tresor1;
    }

    public Tresor getTresor2() {
        return tresor2;
    }

    public Tresor getTresor3() {
        return tresor3;
    }

    public Tresor getTresor4() {
        return tresor4;
    }

    public Grille getGrille() {
        return grille;
    }

    public HashMap<String, Aventurier> getJoueurs() {
        return joueurs;
    }

    public TasPoubelle getPoubelle() {
        return poubelle;
    }

    public TasAventuriers getTasAventuriers() {
        return tasAventuriers;
    }

    public DefausseTresors getDefausseTresor() {
        return defausseTresor;
    }

    public TasTresors getTasTresor() {
        return tasTresor;
    }

    public DefausseInondations getDefausseInondation() {
        return defausseInondation;
    }

    public TasInondations getTasInondation() {
        return tasInondation;
    }

    // getteurs autres
    public CarteTresor getCarteTresor() {
        throw new UnsupportedOperationException();
    }

    public int getNiveau() {
        throw new UnsupportedOperationException();
    }

    public CarteInondation getCarteInondation() {
        throw new UnsupportedOperationException();
    }

    public String getNomJoueur() {
        throw new UnsupportedOperationException();
    }

    public void getAventurier(String nomJoueur) {
        throw new UnsupportedOperationException();
    }

    public Tuile getChoixDeplacement() {
        throw new UnsupportedOperationException();
    }

    public CarteAventurier getCarteAventurier(String nomJoueur) {
        throw new UnsupportedOperationException();
    }

    public Tuile getChoixAssechement() {
        throw new UnsupportedOperationException();
    }

    // autres méthodes
    @Override
    public void traiterAction(Action action) {
        if (action.getType() == TypesActions.deplacer) {
            System.out.println(action.getNomJoueur()+" : deplacer");
        } else if (action.getType() == TypesActions.assecher) {
            System.out.println(action.getNomJoueur()+" : assecher");
        } else if (action.getType() == TypesActions.autres) {
            System.out.println(action.getNomJoueur()+" : autres");
        } else if (action.getType() == TypesActions.terminer) {
            System.out.println(action.getNomJoueur()+" : terminer");
        }
    }

}
