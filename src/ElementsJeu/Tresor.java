package ElementsJeu;

import Enumerations.EtatTresor;
import Enumerations.NomTresor;

public class Tresor {

    // attributs
    private NomTresor nom;
    private EtatTresor etat;

    // constructeurs
    public Tresor(NomTresor nom){
        setNom(nom);
        setEtat(EtatTresor.pasRecupere);
    }
    
    // setteurs
    public void setNom(NomTresor nom) {
        this.nom = nom;
    }

    public void setEtat(EtatTresor etat) {
        this.etat = etat;
    }

    // getteurs
    public NomTresor getNom() {
        return nom;
    }

    public EtatTresor getEtat() {
        return etat;
    }

    // autres
}
