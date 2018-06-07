package ElementsJeu;

import Enumerations.EtatTresor;
import Enumerations.NomTresor;

public class Tresor {

    // attributs
    private NomTresor nom;  //Déclaration d'une variable nom de type NomTresor
    private EtatTresor etat;  //Déclaration d'une variable état de type EtatTresor

    // constructeurs d'un trésor donné par un nom
    public Tresor(NomTresor nom){
        setNom(nom);  //Attribue la valeur nom avec le paramètre nom
        setEtat(EtatTresor.pasRecupere);  //Donne pour état pasRecupere à l'état trésor
    }
    
    // setteurs
    public void setNom(NomTresor nom) { 
        this.nom = nom;  //Initialise la variable nom avec la valeur donnée en paramètre
    }

    public void setEtat(EtatTresor etat) {
        this.etat = etat;  //Initailse la variable etat avexc la valeur donnée en paramètre
    }

    // getteurs
    public NomTresor getNom() {
        return nom;  //Retourne la valeur de nom
    }

    public EtatTresor getEtat() {
        return etat;  //Retourne la valeur de ma variable état
    }

    // autres
}
