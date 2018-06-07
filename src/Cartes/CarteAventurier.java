package Cartes;

import Enumerations.Couleur;
import Enumerations.NomAventurier;

public class CarteAventurier extends Carte {

    // attributs
    private NomAventurier nom;// Nom du joueur
    private Couleur couleur;// Couleur qui identifie la carte aventurier

    // constructeurs
    //
    public CarteAventurier(NomAventurier nom, Couleur couleur) {
        setDescription("");// Description par défault lors de la création de la carte
        setNom(nom);// Met à jour le nom de la carte aventurier avec celui en paramètre
        setCouleur(couleur);// Met à jour la couleur de la carte aventurier avec celui fournis en paramètre
    }
    
    public CarteAventurier(String description, NomAventurier nom, Couleur couleur) {
        setDescription(description);// Met à jour la description de la carte aventurierr avec celui en paramètre
        setNom(nom);// Met à jour le nom de la carte aventurier avec celui en paramètre
        setCouleur(couleur);// Met à jour la couleur de la carte aventurier avec celui fournis en paramètre
    }

    // setteurs
    // Méthode qui met à jour le nom de la carte aventurier
    public void setNom(NomAventurier nom) {
        this.nom = nom;
    }

    //Méthode qui met à jour la couleur de la carte aventurier
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    // getteurs
    //Méthode qui renvoie le nom de la carte aventurier
    public NomAventurier getNom() {
        return this.nom;
    }

    //Méthode qui renvoie la couleur de la carte aventurier
    public Couleur getCouleur() {
        return couleur;
    }

    // autres
}
