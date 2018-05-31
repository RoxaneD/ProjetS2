package Cartes;

import Enumerations.Couleur;
import Enumerations.NomAventurier;

public class CarteAventurier extends Carte {

    // attributs
    private NomAventurier nom;
    private Couleur couleur;

    // constructeurs
    public CarteAventurier(NomAventurier nom, Couleur couleur) {
        setDescription("");
        setNom(nom);
        setCouleur(couleur);
    }
    
    public CarteAventurier(String description, NomAventurier nom, Couleur couleur) {
        setDescription(description);
        setNom(nom);
        setCouleur(couleur);
    }

    // setteurs
    public void setNom(NomAventurier nom) {
        this.nom = nom;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    // getteurs
    public NomAventurier getNom() {
        return this.nom;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    // autres
}
