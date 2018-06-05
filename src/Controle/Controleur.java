// A COMPLETER : Faire les getteurs autres
// A REGARDER
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
import Vues.VueAventurierDemo;
import Vues.VueGrilleDemo;
import java.util.ArrayList;
import java.util.HashMap;

public class Controleur implements Observateur {

    // attributs
    //          vues 
    private HashMap<String, VueAventurierDemo> vuesAventurier = new HashMap<String, VueAventurierDemo>(); // String : un nom de joueur
    private VueAventurierDemo vueAventurier;         // une pour chaque joueur (il n'y en a qu'une seule à la fois à l'écran)
    private VueGrilleDemo vueGrille;
    //          autres attributs
    private HashMap<String, Aventurier> aventuriers = new HashMap<String, Aventurier>(); // String : un nom de joueur
    private Grille grille;
    private NiveauEau niveauEau;
    private Tresor tresor1;
    private Tresor tresor2;
    private Tresor tresor3;
    private Tresor tresor4;
    private TasPoubelle poubelle;
    private TasAventuriers tasAventuriers;
    private DefausseTresors defausseTresor;
    private TasTresors tasTresor;
    private DefausseInondations defausseInondation;
    private TasInondations tasInondation;
    //          compteurs - boolean
    private boolean termine;
    private int nombreActions;
    private boolean actionEffectue = false;

    // constructeur
    public Controleur() {
        setTermine(false);
    }

    // setteurs
    public void afficherVueAventurier(VueAventurierDemo vueAventurier) {
        for (String s : vuesAventurier.keySet()) {
            vuesAventurier.get(s).getWindow().setVisible(false);
        }
        this.vueAventurier = vueAventurier;
        this.vueAventurier.getWindow().setVisible(true);
    }

    public void afficherVueGrille(VueGrilleDemo vueGrille) {
        this.vueGrille = vueGrille;
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

    public void setAventuriers(HashMap<String, Aventurier> aventuriers) {
        this.aventuriers = aventuriers;
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

    public void setActionEffectue(boolean actionEffectue) {
        this.actionEffectue = actionEffectue;
    }

    // getteurs attributs
    public VueAventurierDemo getVueAventurier() {
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

    public HashMap<String, Aventurier> getAventuriers() {
        return aventuriers;
    }

    public HashMap<String, VueAventurierDemo> getVuesAventurier() {
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
        return getAventuriers().get(getNomJoueur());
    }

    public Tuile getChoixDeplacement(Tuile tuile) {
        return tuile;
    }

    public Tuile getChoixAssechement(Tuile tuile) {
        return tuile;
    }

    public VueGrilleDemo getVueGrille() {
        return vueGrille;
    }

    public boolean isActionEffectue() {
        return actionEffectue;
    }

    // autres méthodes
    @Override
    public void traiterAction(Action action) {
        // pour demander l'affiche des tuiles possibles (pour se déplacer)
        if (action.getType() == TypesActions.demandeDeplacement) {
            Aventurier aventurier = getAventurier();
            ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
            for (Tuile t : aventurier.calculDeplacementPos()) {
                tuilesPossibles.add(t);
            }
            vueGrille.afficherTuilesPossiblesDeplacement(tuilesPossibles);

            // pour demander l'affiche des tuiles possibles (à assécher)
        } else if (action.getType() == TypesActions.demandeAssechement) {
            Aventurier aventurier = getAventurier();
            ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
            for (Tuile t : aventurier.calculAssechementPos()) {
                tuilesPossibles.add(t);
            }
            vueGrille.afficherTuilesPossiblesAssechement(tuilesPossibles);

            // autres
        } else if (action.getType() == TypesActions.demandeAutres) {
            System.out.println("autres - pas traité pour le moment");

            // pour terminer son tour
        } else if (action.getType() == TypesActions.terminer) {
            this.setNombreActions(3);
            this.setActionEffectue(true);
            
            // pour se déplacer sur une tuile
        } else if (action.getType() == TypesActions.deplacement) {
            int i = 0;
            while (getGrille().getTuiles().get(i) != getAventurier().getTuile()) {
                i += 1;
            }
            getGrille().getTuiles().get(i).removeAventurier(getAventurier());
            // on retire de la tuile initiale l'aventurier
            // on retire de l'aventurier sa tuile initiale
            this.getAventurier().removeTuile();
            this.getAventurier().addTuile(action.getTuile());
            // on rajoute à la nouvelle tuile l'aventurier
            action.getTuile().addAventurier(getAventurier());

            i = 0;
            while (getGrille().getTuiles().get(i) != getAventurier().getTuile()) {
                i += 1;
            }
            getGrille().getTuiles().get(i).addAventurier(getAventurier());
            // on met à jour la liste des tuiles de la Grille
            getGrille().getTuile(getAventurier().getTuile().getPosX(), getAventurier().getTuile().getPosY()).addAventurier(getAventurier());

            // on met à jour la vueGrille, et on la réinitialise
            vueGrille.setTuiles(getGrille());
            vueGrille.revenirGrilleDepart();

            setNombreActions(getNombreActions() + 1);
            this.setActionEffectue(true);

            // pour assécher une tuile
        } else if (action.getType() == TypesActions.assechement) {
            // on met à jour la grille
            getGrille().getTuile(action.getTuile().getPosX(), action.getTuile().getPosY()).assecher();
            // on met à jour la vueGrille, et on la réinitialise
            vueGrille.revenirGrilleDepart();

            setNombreActions(getNombreActions() + 1);
            this.setActionEffectue(true);

            // pour récupérer et afficher la position d'un joueur sur sa vue aventurier
        } else if (action.getType() == TypesActions.demandePosition) {
            Aventurier av = aventuriers.get(vueAventurier.getNomJoueur()); // <- il ne trouve pas l'aventurier 
            vueAventurier.setPosition(av.getTuile().getNom().toString() + " | " + av.getTuile().getPosX() + " - " + av.getTuile().getPosY());
        }
    }

}
