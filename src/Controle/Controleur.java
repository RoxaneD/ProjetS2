// A COMPLETER : Faire les getteurs autres
package Controle;

import Aventuriers.Aventurier;
import Cartes.CarteInondation;
import Cartes.CarteAventurier;
import Cartes.CarteTresors;
import ElementsJeu.Grille;
import ElementsJeu.NiveauEau;
import ElementsJeu.Tresor;
import ElementsJeu.Tuile;
import Enumerations.NomAventurier;
import Tas.DefausseInondations;
import Tas.DefausseTresors;
import Tas.TasAventuriers;
import Tas.TasInondations;
import Tas.TasPoubelle;
import Tas.TasTresors;
import Vues.VueAventurier;
import java.util.ArrayList;
import java.util.HashMap;

public class Controleur implements Observateur {

    // attributs
    private HashMap<String, Aventurier> joueurs = new HashMap<String, Aventurier>(); // tous les joueurs
    private HashMap<String, VueAventurier> vuesAventurier = new HashMap<String, VueAventurier>(); // toutes les vues
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

    private boolean termine;
    private int nombreActions;

    // constructeur
    public Controleur() {
        setTermine(false);
    }

    // setteurs
    public void setVueAventurier(VueAventurier vueAventurier) {
        this.vueAventurier = vueAventurier;
        this.vueAventurier.getWindow().setVisible(true);
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
        this.joueurs = joueurs;
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

    public void setTermine(boolean termine) {
        this.termine = termine;
    }

    public void setNombreActions(int nombreActions) {
        this.nombreActions = nombreActions;
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
    
    public HashMap<String, VueAventurier> getVuesAventurier(){
        return vuesAventurier;
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
    public CarteTresors getCarteTresor() {
        return getTasTresor().getPremiereCarte();
    }

    public CarteInondation getCarteInondation() {
        return getTasInondation().getPremiereCarte();
    }

    public int getNiveau() {
        return getNiveauEau().getNiveau();
    }

    public boolean isTermine() {
        return termine;
    }

    public int getNombreActions() {
        return nombreActions;
    }

    public String getNomJoueur() {
        return getVueAventurier().getNomJoueur();
    }

    public CarteAventurier getCarteAventurier() {
        return getVueAventurier().getCarteAventurier();
    }

    public NomAventurier getNomAventurier() {
        return getCarteAventurier().getNom();
    }

    public Aventurier getAventurier() {
        return getJoueurs().get(getNomJoueur());
    }

    public Tuile getChoixDeplacement(Tuile tuile) {
        return tuile;
    }

    public Tuile getChoixAssechement(Tuile tuile) {
        return tuile;
    }

    // autres méthodes
    @Override
    public void traiterAction(Action action) {
        // pour se déplacer
        if (action.getType() == TypesActions.deplacer) {
            Aventurier aventurier = getAventurier();
            ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
            tuilesPossibles = aventurier.calculDeplacementPos();
            // Sans ihm - juste un test
            System.out.println("Choissisez une tuile sur laquelle vous voulez vous déplacer :");
            for (Tuile t : tuilesPossibles) {
                System.out.println(t.getNom());
            }

            // pour assécher une tuile
        } else if (action.getType() == TypesActions.assecher) {
            Aventurier aventurier = getAventurier();
            ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
            tuilesPossibles = aventurier.calculAssechementPos();
            // Sans ihm - juste un test
            System.out.println("Choissisez une tuile que vous souhaitez assecher :");
            for (Tuile t : tuilesPossibles) {
                System.out.println(t.getNom());
            }

            // autres
        } else if (action.getType() == TypesActions.autres) {
            System.out.println(action.getNomJoueur() + " : autres");

            // pour terminer son tour
        } else if (action.getType() == TypesActions.terminer) {
            setNombreActions(3);
        }
    }

}
