// A COMPLETER : Faire les getteurs autres
// A REGARDER
package Controle;

import Aventuriers.Aventurier;
import Aventuriers.Explorateur;
import Aventuriers.Ingenieur;
import Aventuriers.Messager;
import Aventuriers.Navigateur;
import Aventuriers.Pilote;
import Aventuriers.Plongeur;
import Cartes.Carte;
import Cartes.CarteInondation;
import Cartes.CarteAventurier;
import Cartes.CarteTresors;
import ElementsJeu.Grille;
import ElementsJeu.NiveauEau;
import ElementsJeu.Tresor;
import ElementsJeu.Tuile;
import Enumerations.EtatTuile;
import Enumerations.NomAventurier;
import Enumerations.NomTresor;
import Enumerations.NomTuile;
import Tas.DefausseInondations;
import Tas.DefausseTresors;
import Tas.TasAventuriers;
import Tas.TasInondations;
import Tas.TasJoueur;
import Tas.TasPoubelle;
import Tas.TasTresors;
import Vues.IhmAventurier;
import Vues.IhmGrille;
import Vues.IhmMenuPrincipal;
import Vues.IhmPlateauDeJeu;
import Vues.IhmReglesDuJeu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Controleur implements Observateur {

    // attributs
    //          ihm 
    private IhmMenuPrincipal ihmMenuPrincipal;
    private IhmReglesDuJeu ihmReglesDuJeu;
    private IhmPlateauDeJeu ihmPlateauDeJeu;

    //          autres attributs
    private ArrayList<String> joueurs = new ArrayList<String>(); // contient tous les nom de joueurs
    private HashMap<String, Aventurier> aventuriers = new HashMap<String, Aventurier>(); // String : un nom de joueur
    private HashMap<String, TasJoueur> tasJoueurs = new HashMap<String, TasJoueur>();
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
    private boolean debutPartie = false;

    // constructeur
    public Controleur() {
        // attributs interne
        setTermine(false);//en initialisant le termine à faux

        // instantiation des éléments internes
        setGrille();
        setNiveauEau();
        Tresor tresor1 = new Tresor(NomTresor.Pierre);
        Tresor tresor2 = new Tresor(NomTresor.Zephyr);
        Tresor tresor3 = new Tresor(NomTresor.Cristal);
        Tresor tresor4 = new Tresor(NomTresor.Calice);
        setTresor1(tresor1);
        setTresor2(tresor2);
        setTresor3(tresor3);
        setTresor4(tresor4);
        setPoubelle();
        setTasAventuriers();
        setDefausseTresor();
        setTasTresor();
        setDefausseInondation();
        setTasInondation();

        // instantiation des ihm
        // menu
        ihmMenuPrincipal = new IhmMenuPrincipal();
        ihmMenuPrincipal.addObservateur(this);
        // regles du jeu
        ihmReglesDuJeu = new IhmReglesDuJeu();
        ihmReglesDuJeu.addObservateur(this);
        // plateau de jeu
        // fait dans traiterAction(commencer)
    }

    //Méthode qui met à jour le niveau d'eau
    public void setNiveauEau() {
        this.niveauEau = new NiveauEau();
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

    //Méthode qui initialise la grille
    public void setGrille() {
        this.grille = new Grille();
    }

    //Méthode qui met à jour la grille (à ne pas utiliser)
    public void initialiserGrille(Grille grille) {
        this.grille = grille;
    }

    //Méthode qui met à jour le HashMap aventurier
    public void setAventuriers(HashMap<String, Aventurier> aventuriers) {
        this.aventuriers = aventuriers;
    }

    //Méthode qui met à jour le tas poubelle
    public void setPoubelle() {
        this.poubelle = new TasPoubelle();
    }

    //Méthode qui met à jour le tas aventurier
    public void setTasAventuriers() {
        this.tasAventuriers = new TasAventuriers();
    }

    //Méthode qui met à jour la défausse tresor
    public void setDefausseTresor() {
        this.defausseTresor = new DefausseTresors();
    }

    //Méthode qui met à jour le tas trésor
    public void setTasTresor() {
        this.tasTresor = new TasTresors();
    }

    //Méthode qui met à jour la défausse inondation
    public void setDefausseInondation() {
        this.defausseInondation = new DefausseInondations();
    }

    //Méthode qui met à jour le tas inondation
    public void setTasInondation() {
        this.tasInondation = new TasInondations();
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
    public IhmAventurier getIhmAventurierActuelle() {
        return ihmPlateauDeJeu.getIhmAventurierActuelle();
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

    public ArrayList<Aventurier> getArrayAventuriers() {
        ArrayList<Aventurier> a = new ArrayList<Aventurier>();
        for (Aventurier av : getAventuriers().values()) {
            a.add(av);
        }
        return a;
    }

    //Méthode qui renvoie le HashMap vues aventurier
    public ArrayList<IhmAventurier> getIhmAventurier() {
        return ihmPlateauDeJeu.getIhmAventuriers();
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
        return getIhmAventurierActuelle().getNomJoueur();
    }

    //Méthode qui renvoie la carte de l'aventurier
    public CarteAventurier getCarteAventurier() {
        return getIhmAventurierActuelle().getCarteAventurier();
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
    public IhmGrille getIhmGrille() {
        return ihmPlateauDeJeu.getIhmGrille();
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

    public ArrayList<String> getJoueurs() {
        return joueurs;
    }

    public HashMap<String, TasJoueur> getTasJoueurs() {
        return tasJoueurs;
    }

    // POUR LES IHMS
    public IhmMenuPrincipal getIhmMenuPrincipal() {
        return ihmMenuPrincipal;
    }

    public IhmReglesDuJeu getIhmReglesDuJeu() {
        return ihmReglesDuJeu;
    }

    public IhmPlateauDeJeu getIhmPlateauDeJeu() {
        return ihmPlateauDeJeu;
    }

    public boolean isDebutPartie() {
        return debutPartie;
    }

    public void mettreAjourGrille() {
        this.getGrille().mettreAjourGrille(this.getIhmGrille().getTuiles());
    }

    // autres méthodes
    @Override
    public void traiterAction(Action action) {
        // pour commencer une partie
        if (action.getType() == TypesActions.commencerPartie) { // OK ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("commencerPartie");
            for (String s : action.getJoueurs()) {
                joueurs.add(s);
                TasJoueur t = new TasJoueur();
                tasJoueurs.put(s, t);
                CarteAventurier c = tasAventuriers.getPremiereCarte();
                if (c.getNom() == NomAventurier.explorateur) {
                    Explorateur av = new Explorateur(s, c);
                    av.addTuile(getGrille().getTuile(NomTuile.LaPorteDeCuivre));
                    aventuriers.put(s, av);
                } else if (c.getNom() == NomAventurier.pilote) {
                    Pilote av = new Pilote(s, c);
                    av.addTuile(getGrille().getTuile(NomTuile.Heliport));
                    aventuriers.put(s, av);
                } else if (c.getNom() == NomAventurier.navigateur) {
                    Navigateur av = new Navigateur(s, c);
                    av.addTuile(getGrille().getTuile(NomTuile.LaPortedOr));
                    aventuriers.put(s, av);
                } else if (c.getNom() == NomAventurier.plongeur) {
                    Plongeur av = new Plongeur(s, c);
                    av.addTuile(getGrille().getTuile(NomTuile.LaPorteDeFer));
                    aventuriers.put(s, av);
                } else if (c.getNom() == NomAventurier.ingenieur) {
                    Ingenieur av = new Ingenieur(s, c);
                    av.addTuile(getGrille().getTuile(NomTuile.LaPorteDeBronze));
                    aventuriers.put(s, av);
                } else {
                    Messager av = new Messager(s, c);
                    av.addTuile(getGrille().getTuile(NomTuile.LaPortedArgent));
                    aventuriers.put(s, av);
                }
            }
            // ouvrir ihm principale
            this.getNiveauEau().setSemiNiveau(action.getNiveau());
            ihmPlateauDeJeu = new IhmPlateauDeJeu(aventuriers, this.getGrille(), getNiveauEau());
            ihmPlateauDeJeu.getIhmGrille().addObservateur(this);
            for (IhmAventurier ihm : ihmPlateauDeJeu.getIhmAventuriers()) {
                ihm.addObservateur(this);
            }
            ihmPlateauDeJeu.afficherIhm();

            debutPartie = true;

            // fermer IHM_Menu
            ihmMenuPrincipal.cacherIhm();

            // pour demander l'affiche des tuiles possibles (pour se déplacer)
        } else if (action.getType() == TypesActions.demandeDeplacement) { // OK -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("demandeDeplacement");
            //Si le nombre d'action n'est pas de 2 et que l'aventurier n'est pas l'ingenieur et que sont pouvoir est a faux alors
            if (!(getNombreActions() == 2 && getAventurier().getCarteAventurier().getNom() == NomAventurier.ingenieur && isPouvoirIngenieur())) {
                Aventurier aventurier = getAventurier();//l'aventurier prend la valeur de l'aventurier qui fait l'action
                ArrayList<Tuile> tuilesPossibles = new ArrayList<>();// Collection des tuiles possible
                for (Tuile tuile2 : aventurier.calculDeplacementPos()) {//Calcul des déplacements possible pour cette aventurier
                    tuilesPossibles.add(tuile2);
                }
                //Afficher les tuiles possibles dans la vueGrille
                getIhmGrille().revenirGrilleDepart();
                getIhmGrille().afficherTuilesPossiblesDeplacement(tuilesPossibles);
            }

            // pour demander l'affiche des tuiles possibles (à assécher)
        } else if (action.getType() == TypesActions.demandeAssechement) { // OK -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("demandeAssechement");
            Aventurier aventurier = getAventurier();//l'aventurier prend la valeur de l'aventurier qui fait l'action
            ArrayList<Tuile> tuilesPossibles = new ArrayList<>();// Collection des tuiles possible
            for (Tuile t : aventurier.calculAssechementPos()) {//Calcul des assechements possible pour cette aventurier
                tuilesPossibles.add(t);
            }
            //Afficher les tuiles possibles dans la vueGrille
            getIhmGrille().revenirGrilleDepart();
            getIhmGrille().afficherTuilesPossiblesAssechement(tuilesPossibles);
            // pour se déplacer sur une tuile
        } else if (action.getType() == TypesActions.deplacement) { // A FAIRE -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("deplacement");
            //si le pouvoir du pilote est à faux et que cette aventurier est le pilote alors
            if (!pouvoirPilote && getIhmAventurierActuelle().getAventurier().getCarteAventurier().getNom() == NomAventurier.pilote) {
                Pilote pilote2 = (Pilote) getAventurier();//pilote2 est objet de la classe pilote
                pilote2.setPouvoir(true);// on initialise sont pouvoir à vrai
                ///pour les tuiles adjacentes a la tuile où se trouve l'aventurier
                System.out.println(getIhmAventurierActuelle().getAventurier().getTuile().getNom());
                for (Tuile tuile2 : getGrille().getTuilesAdjacentes(getIhmAventurierActuelle().getAventurier().getTuile())) {
                    if (action.getTuile() == tuile2) {// Si la tuile où l'action s'effectue est egale a une des tuiles adjacente
                        pilote2.setPouvoir(false);//alors on passe le pouvoir du pilote2 à faux
                    }
                }
                if (pilote2.getPouvoir()) {//Si le pouvoir de pilote2 a été passer a vrai alors 
                    pouvoirPilote = true;// on passe le pouvoir du pilote a vrai
                }
            }

            //Si le pouvoir de l'ingenieur est a vrai et que l'aventurier est l'ingenieur
            if (pouvoirIngenieur && getIhmAventurierActuelle().getAventurier().getCarteAventurier().getNom() == NomAventurier.ingenieur) {
                setPouvoirIngenieur(false);//on passe le pouvoir a faux
                this.setNombreActions(getNombreActions() + 1);//Et on augmente le nombre d'action de 1
            }

            this.mettreAjourGrille();

            //Si le nombre d'action est different de 3
            if (getNombreActions() != 3) {
                int i = 0;
                //tant que la tuile est differente de celle de l'aventurier
                while (getGrille().getTuiles().get(i) != getAventurier().getTuile()) {
                    i += 1;//on change de tuile
                }

                // on retire de la tuile initiale l'aventurier
                getGrille().getTuiles().get(i).removeAventurier(getIhmAventurierActuelle().getAventurier());
                getIhmGrille().getTuiles().get(i).removeAventurier(getIhmAventurierActuelle().getAventurier());

                // on retire de l'aventurier sa tuile initiale
                getAventurier().removeTuile();
                getIhmAventurierActuelle().getAventurier().removeTuile();

                // on rajoute l'aventurier à la nouvelle tuile ET la tuile à l'aventurier (grille)
                for (Tuile t : getGrille().getTuiles()) {
                    if (action.getTuile().getNom() == t.getNom()) {
                        t.addAventurier(getIhmAventurierActuelle().getAventurier());
                        getAventurier().addTuile(t);
                    }
                }

                // on rajoute l'aventurier à la nouvelle tuile ET la tuile à l'aventurier (ihmGrille)
                for (Tuile t : getIhmGrille().getTuiles()) {
                    if (action.getTuile().getNom() == t.getNom()) {
                        t.addAventurier(getIhmAventurierActuelle().getAventurier());
                        getIhmAventurierActuelle().getAventurier().addTuile(t);
                    }
                }

                // on met à jour la liste des tuiles de la Grille
                getGrille().getTuile(getIhmAventurierActuelle().getAventurier().getTuile().getPosX(), getIhmAventurierActuelle().getAventurier().getTuile().getPosY()).addAventurier(getIhmAventurierActuelle().getAventurier());
                getIhmGrille().getGrille().getTuile(getIhmAventurierActuelle().getAventurier().getTuile().getPosX(), getIhmAventurierActuelle().getAventurier().getTuile().getPosY()).addAventurier(getIhmAventurierActuelle().getAventurier());

                getIhmGrille().setGrille(getGrille());
                getIhmGrille().revenirGrilleDepart();
                getIhmPlateauDeJeu().mettreAJour();
                getIhmPlateauDeJeu().getIhmGrille().repaint();
                getIhmGrille().repaint();
                

                setNombreActions(getNombreActions() + 1);
                System.out.println(getNombreActions());
                this.setActionEffectue(true);

            }
            // pour assécher une tuile
        } else if (action.getType() == TypesActions.assechement) { // A FAIRE --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("assecher");
            // on met à jour la grille
            getGrille().getTuile(action.getTuile().getPosX(), action.getTuile().getPosY()).assecher();
            // on met à jour la vueGrille, et on la réinitialise
            getIhmGrille().revenirGrilleDepart();
            //Si l'aventurier n'est pas l'ingenieur ou que le pouvoir ingenieur est à vrai
            if (getAventurier().getCarteAventurier().getNom() != NomAventurier.ingenieur || isPouvoirIngenieur()) {
                setNombreActions(getNombreActions() + 1);//on augmente le nombre d'action de 1
                pouvoirIngenieur = false;//On passe le pouvoir de l'ingenieur à faux
            } else {//sinon
                pouvoirIngenieur = true;//on le passe a vrai
            }
            this.setActionEffectue(true);

            // pour terminer son tour
        } else if (action.getType() == TypesActions.terminerTour) { // OK -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("terminerTour");
            this.setNombreActions(3);// Met le nombre d'action à 3 pour que le tour se finisse
            this.setActionEffectue(true);//Met le booléen action effectuée à vrai
            getIhmGrille().revenirGrilleDepart();

            // pour recupérer un trésor
        } else if (action.getType() == TypesActions.recupererTresor) { // A FAIRE -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("recupererTresor");

            // pour afficher les cartes qu'on peut utiliser (de ses propres cartes)
        } else if (action.getType() == TypesActions.demandeUtilisationCarte) { // A FAIRE -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("demandeUtilisationCarte");
            ArrayList<Integer> cartesPos = new ArrayList<>();
            Integer i = 0;
            for (CarteTresors c : ihmPlateauDeJeu.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes()) {
             
                if (c.getNom() == NomTresor.Helicoptere || c.getNom() == NomTresor.MonteeDesEaux || c.getNom() == NomTresor.SacsDeSable) {
                    System.out.println("demandeUtilisationCarte action");
                    System.out.println("taille du i "+i);
                    System.out.println("Nom de la carte "+c.getNom());
                    System.out.println("Nom de la carte par ihm "+ihmPlateauDeJeu.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes().get(i).getNom());
                    
                    if (c.getNom() == ihmPlateauDeJeu.getIhmAventurierActuelle().getAventurier().getTasJoueur().getCartes().get(i).getNom()) {
                        cartesPos.add(i);
                        System.out.println("i == "+i);
                    }

                }
                i++;
            }
            if (!cartesPos.isEmpty()) {
                ihmPlateauDeJeu.getIhmAventurierActuelle().setChoix("utiliser");
                ihmPlateauDeJeu.getIhmAventurierActuelle().afficherCarteJoueur(cartesPos);
            }

            // pour utiliser une carte
        } else if (action.getType() == TypesActions.utiliserCarte) { // A FAIRE -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("utiliserCarte");
            // pour une carte hélicoptère
            if (action.getCarteT().getNom() == NomTresor.Helicoptere) {

                // pour une carte montée des eaux
            } else if (action.getCarteT().getNom() == NomTresor.MonteeDesEaux) {
                // on augmente le semi niveau de 1
                niveauEau.monterNiveau();
                // on remet la defausse inondation au dessus du tas de cartes inondation
                ArrayList<CarteInondation> ci = new ArrayList<>();
                ci = defausseInondation.recupererCartes();
                Collections.shuffle(ci);
                for (CarteInondation c : ci) {
                    tasInondation.addCarte(c);
                }
                // on défausse cette carte dans la defausse tresors
                defausseTresor.addCarte(action.getCarteT());
                int i = 0;
                for (CarteTresors c : tasJoueurs.get(action.getNom()).getCartes()) {
                    if (c == action.getCarteT()) {
                        tasJoueurs.get(action.getNom()).getCartes().remove(i);
                    }
                    i += 1;
                }
                // pour une carte sac de sable
            } else if (action.getCarteT().getNom() == NomTresor.SacsDeSable) {
                ArrayList<Tuile> tuilesPos = new ArrayList<>();
                for (Tuile t : grille.getTuiles()) {
                    if (t.getEtat() == EtatTuile.inondee) {
                        tuilesPos.add(t);
                    }
                }
                // ihm2.afficherTuile(ArrayList<Tuile>);
            }

            // pour afficher la liste des joueurs à qui on peut donner une carte trésor
        } else if (action.getType() == TypesActions.demandeDonCarte) { // A FAIRE -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            for (Aventurier av : aventuriers.values()) {
                if (getAventurier().getTuile() == av.getTuile() && getAventurier() != av) {
                    for (IhmAventurier ihm : getIhmAventurier()) {
                        if (ihm.getAventurier() == av) {
                            ihm.setPeutDonner(true);
                            ihm.repaint();
                        }
                    }
                    System.out.println(av.getNomJoueur());
                }
            }
            System.out.println("demandeDonCarte");

            // pour donner une carte trésor à un joueur
        } else if (action.getType() == TypesActions.donCarte) { // A FAIRE-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("donCarte");

            // pour recevoir la liste des cartes qu'on peut défausser
        } else if (action.getType() == TypesActions.demandeDefausseCarte) { // A FAIRE----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("demandeDefausseCarte");

            // pour se défausse d'une carte
        } else if (action.getType() == TypesActions.defausserCarte) { // A FAIRE ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("defausserCarte");
            // pour afficher les règles du jeu
        } else if (action.getType() == TypesActions.reglesJeu) { // OK ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("reglesJeu");
            ihmReglesDuJeu.afficherIhm();

            // pour fermer les règles du jeu
        } else if (action.getType() == TypesActions.fermerReglesJeu) { // OK ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("fermerReglesJeu");
            ihmReglesDuJeu.cacherIhm();
        }
    }
}
