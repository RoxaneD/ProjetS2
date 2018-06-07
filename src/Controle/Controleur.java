// A COMPLETER : Faire les getteurs autres
// A REGARDER
package Controle;

import Aventuriers.Aventurier;
import Aventuriers.Pilote;
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
    private boolean termine; // termine : la partie est finie | !termine : la partie n'est pas finie 
    private int nombreActions;
    private boolean actionEffectue = false;
    private boolean pouvoirPilote = false;
    private boolean pouvoirIngenieur = false;

    // constructeur
    //Crée unc controleur
    public Controleur() {
        setTermine(false);//en initialisant le termine à faux
    }

    // setteurs
    //Méthode qui affiche la vue aventurier
    public void afficherVueAventurier(VueAventurierDemo vueAventurier) {
        for (String s : vuesAventurier.keySet()) {//Met toute les vues aventuriers en false pour ne pas qu'elle s'affiche
            vuesAventurier.get(s).getWindow().setVisible(false);
        }
        this.vueAventurier = vueAventurier;// Met en visible seul l'aventurier actuelle
        this.vueAventurier.getWindow().setVisible(true);
    }

    //Méthode qui met à jour la vueGrille
    public void afficherVueGrille(VueGrilleDemo vueGrille) {
        this.vueGrille = vueGrille;
    }
    
    //Méthode qui met à jour le niveau d'eau
    public void setNiveauEau(NiveauEau niveauEau) {
        this.niveauEau = niveauEau;
    }

    //Méthode qui met à jour le tresor n°1
    public void setTresor1(Tresor tresor1) {
        this.tresor1 = tresor1;
    }

    //Méthode qui met à jour le tresor n°2
    public void setTresor2(Tresor tresor2) {
        this.tresor2 = tresor2;
    }

    //Méthode qui met à jour le tresor n°3
    public void setTresor3(Tresor tresor3) {
        this.tresor3 = tresor3;
    }

    //Méthode qui met à jour le tresor n°4
    public void setTresor4(Tresor tresor4) {
        this.tresor4 = tresor4;
    }

    //Méthode qui met à jour la grille
    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    //Méthode qui met à jour le HashMap aventurier
    public void setAventuriers(HashMap<String, Aventurier> aventuriers) {
        this.aventuriers = aventuriers;
    }

    //Méthode qui met à jour le tas poubelle
    public void setPoubelle(TasPoubelle poubelle) {
        this.poubelle = poubelle;
    }

    //Méthode qui met à jour le tas aventurier
    public void setTasAventuriers(TasAventuriers tasAventuriers) {
        this.tasAventuriers = tasAventuriers;
    }

    //Méthode qui met à jour la défausse tresor
    public void setDefausseTresor(DefausseTresors defausseTresor) {
        this.defausseTresor = defausseTresor;
    }

    //Méthode qui met à jour le tas trésor
    public void setTasTresor(TasTresors tasTresor) {
        this.tasTresor = tasTresor;
    }

    //Méthode qui met à jour la défausse inondation
    public void setDefausseInondation(DefausseInondations defausseInondation) {
        this.defausseInondation = defausseInondation;
    }

    //Méthode qui met à jour le tas inondation
    public void setTasInondation(TasInondations tasInondation) {
        this.tasInondation = tasInondation;
    }

    //Méthode qui met à jour le booléen termine
    public void setTermine(boolean termine) {
        this.termine = termine;
    }

    //Méthode qui met à jour le nombre d'action
    public void setNombreActions(int nombreActions) {
        this.nombreActions = nombreActions;
    }

    //Méthode qui met à jour le booléen action effectuer
    public void setActionEffectue(boolean actionEffectue) {
        this.actionEffectue = actionEffectue;
    }

    //Méthode qui met à jour le booléen pouvoir pilote
    public void setPouvoirPilote(boolean pouvoirPilote) {
        this.pouvoirPilote = pouvoirPilote;
    }

    //Méthode qui met à jour le booléen pouvoir ingenieur
    public void setPouvoirIngenieur(boolean pouvoirIngenieur) {
        this.pouvoirIngenieur = pouvoirIngenieur;
    }

    // getteurs attributs
    //Méthode qui renvoie la vue aventurier
    public VueAventurierDemo getVueAventurier() {
        return vueAventurier;
    }

    //Méthode qui renvoie le niveau d'eau
    public NiveauEau getNiveauEau() {
        return niveauEau;
    }

    //Méthode qui renvoie le tresor n°1
    public Tresor getTresor1() {
        return tresor1;
    }

    //Méthode qui renvoie le tresor n°2
    public Tresor getTresor2() {
        return tresor2;
    }

    //Méthode qui renvoie le tresor n°3
    public Tresor getTresor3() {
        return tresor3;
    }

    //Méthode qui renvoie le tresor n°4
    public Tresor getTresor4() {
        return tresor4;
    }

    //Méthode qui renvoie la grille
    public Grille getGrille() {
        return grille;
    }

    //Méthode qui renvoie le HashMap aventurier
    public HashMap<String, Aventurier> getAventuriers() {
        return aventuriers;
    }

    //Méthode qui renvoie le HashMap vues aventurier
    public HashMap<String, VueAventurierDemo> getVuesAventurier() {
        return vuesAventurier;
    }

    //Méthode qui renvoie la poubelle
    public TasPoubelle getPoubelle() {
        return poubelle;
    }

    //Méthode qui renvoie le tas aventurier
    public TasAventuriers getTasAventuriers() {
        return tasAventuriers;
    }

    //Méthode qui renvoie la defausse tresor
    public DefausseTresors getDefausseTresor() {
        return defausseTresor;
    }

    //Méthode qui renvoie le tas tresor
    public TasTresors getTasTresor() {
        return tasTresor;
    }

    //Méthode qui renvoie la defausse inondation
    public DefausseInondations getDefausseInondation() {
        return defausseInondation;
    }

    //Méthode qui renvoie le tas inondation
    public TasInondations getTasInondation() {
        return tasInondation;
    }

    // getteurs autres
    //Méthode qui renvoie la premier carte du tas tresor
    public CarteTresors getCarteTresor() {
        return getTasTresor().getPremiereCarte();
    }

    //Méthode qui renvoie la premiere carte du tas inondation
    public CarteInondation getCarteInondation() {
        return getTasInondation().getPremiereCarte();
    }

    //Méthode qui renvoie le niveau sur le niveau d'eau
    public int getNiveau() {
        return getNiveauEau().getNiveau();
    }

    //Méthode qui renvoie le booléen termine
    public boolean isTermine() {
        return termine;
    }

    //Méthode qui renvoie le nombre d'action
    public int getNombreActions() {
        return nombreActions;
    }

    //Méthode qui renvoie le nom du joueur
    public String getNomJoueur() {
        return getVueAventurier().getNomJoueur();
    }

    //Méthode qui renvoie la carte de l'aventurier
    public CarteAventurier getCarteAventurier() {
        return getVueAventurier().getCarteAventurier();
    }

    //Méthode qui renvoie le nom de l'aventurier
    public NomAventurier getNomAventurier() {
        return getCarteAventurier().getNom();
    }

    //Méthode qui renvoie l'aventurier en uttilisant sont nom pour le trouver dans le HashMap
    public Aventurier getAventurier() {
        return getAventuriers().get(getNomJoueur());
    }

    //Méthode qui renvoie la tuile choisi pour un deplacement
    public Tuile getChoixDeplacement(Tuile tuile) {
        return tuile;
    }

    //Méthode qui renvoie la tuile choisi pour un assechement
    public Tuile getChoixAssechement(Tuile tuile) {
        return tuile;
    }

    //Méthode qui renvoie la vueGrille
    public VueGrilleDemo getVueGrille() {
        return vueGrille;
    }

    //Méthode qui renvoie le booléen actionEffectuer
    public boolean isActionEffectue() {
        return actionEffectue;
    }

    //Méthode qui renvoie le booléen pouvoir pilote
    public boolean isPouvoirPilote() {
        return pouvoirPilote;
    }

    //Méthode qui renvoie le booléen pouvoir ingenieur
    public boolean isPouvoirIngenieur() {
        return pouvoirIngenieur;
    }

    // autres méthodes
    @Override
    public void traiterAction(Action action) {
        // pour demander l'affiche des tuiles possibles (pour se déplacer)
        if (action.getType() == TypesActions.demandeDeplacement) {
            //Si le nombre d'action n'est pas de 2 et que l'aventurier n'est pas l'ingenieur et que sont pouvoir est a faux alors
            if (!(getNombreActions() == 2 && getAventurier().getCarteAventurier().getNom() == NomAventurier.ingenieur && isPouvoirIngenieur())) {
                Aventurier aventurier = getAventurier();//l'aventurier prend la valeur de l'aventurier qui fait l'action
                ArrayList<Tuile> tuilesPossibles = new ArrayList<>();// Collection des tuiles possible
                for (Tuile tuile2 : aventurier.calculDeplacementPos()) {//Calcul des déplacements possible pour cette aventurier
                    tuilesPossibles.add(tuile2);
                }
                //Afficher les tuiles possibles dans la vueGrille
                vueGrille.afficherTuilesPossiblesDeplacement(tuilesPossibles);
            } 

            // pour demander l'affiche des tuiles possibles (à assécher)
        } else if (action.getType() == TypesActions.demandeAssechement) {
            Aventurier aventurier = getAventurier();//l'aventurier prend la valeur de l'aventurier qui fait l'action
            ArrayList<Tuile> tuilesPossibles = new ArrayList<>();// Collection des tuiles possible
            for (Tuile t : aventurier.calculAssechementPos()) {//Calcul des assechements possible pour cette aventurier
                tuilesPossibles.add(t);
            }
            //Afficher les tuiles possibles dans la vueGrille
            vueGrille.afficherTuilesPossiblesAssechement(tuilesPossibles);

            // autres action possible
        } else if (action.getType() == TypesActions.demandeAutres) {
            System.out.println("autres - pas traité pour le moment");

            // pour terminer son tour
        } else if (action.getType() == TypesActions.terminer) {
            this.setNombreActions(3);// Met le nombre d'action a 3 pour que le tour ce finisse
            this.setActionEffectue(true);//Met le booléen action effectuer a vrai

            // pour se déplacer sur une tuile
        } else if (action.getType() == TypesActions.deplacement) {
            //si le pouvoir du pilote est à faux et que cette aventurier est le pilote alors
            if (!pouvoirPilote && getAventurier().getCarteAventurier().getNom() == NomAventurier.pilote) {
                Pilote pilote2 = (Pilote) getAventurier();//pilote2 est objet de la classe pilote
                pilote2.setPouvoir(true);// on initialise sont pouvoir à vrai
                ///pour les tuiles adjacentes a la tuile où ce trouve l'aventurier
                for (Tuile tuile2 : getAventurier().getTuile().getGrille().getTuilesAdjacentes(getAventurier().getTuile())) {
                    if (action.getTuile() == tuile2) {// Si la tuile où l'action s'effectue est egale a une des tuiles adjacente
                        pilote2.setPouvoir(false);//alors on passe le pouvoir du pilote2 à faux
                    }
                }
                if (pilote2.getPouvoir()) {//Si le pouvoir de pilote2 a été passer a vrai alors 
                    pouvoirPilote = true;// on passe le pouvoir du pilote a vrai
                }
            }

            //Si le pouvoir de l'ingenieur est a vrai et que l'aventurier est l'ingenieur
            if (pouvoirIngenieur && getAventurier().getCarteAventurier().getNom() == NomAventurier.ingenieur) {
                setPouvoirIngenieur(false);//on passe le pouvoir a faux
                this.setNombreActions(getNombreActions() + 1);//Et on augmente le nombre d'action de 1
            }
            //Si le nombre d'action est different de 3
            if (getNombreActions() != 3) {
                int i = 0;
                //tant que la tuile est differente de celle de l'aventurier
                while (getGrille().getTuiles().get(i) != getAventurier().getTuile()) {
                    i += 1;//on change de tuile
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
            }

            // pour assécher une tuile
        } else if (action.getType() == TypesActions.assechement) {
            // on met à jour la grille
            getGrille().getTuile(action.getTuile().getPosX(), action.getTuile().getPosY()).assecher();
            // on met à jour la vueGrille, et on la réinitialise
            vueGrille.revenirGrilleDepart();
            //Si l'aventurier n'est pas l'ingenieur ou que le pouvoir ingenieur est à vrai
            if (getAventurier().getCarteAventurier().getNom() != NomAventurier.ingenieur || isPouvoirIngenieur()) {
                setNombreActions(getNombreActions() + 1);//on augmente le nombre d'action de 1
                pouvoirIngenieur = false;//On passe le pouvoir de l'ingenieur à faux
            } else {//sinon
                pouvoirIngenieur = true;//on le passe a vrai
            }
            this.setActionEffectue(true);

            // pour récupérer et afficher la position d'un joueur sur sa vue aventurier
        } else if (action.getType()
                == TypesActions.demandePosition) {
            Aventurier av = aventuriers.get(vueAventurier.getNomJoueur()); // <- il ne trouve pas l'aventurier 
            vueAventurier.setPosition(av.getTuile().getNom().toString() + " | " + av.getTuile().getPosX() + " - " + av.getTuile().getPosY());
        }
    }

}
