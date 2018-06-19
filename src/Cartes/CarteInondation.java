package Cartes;

import Enumerations.NomTuile;

public class CarteInondation extends Carte {

    // attributs
    private NomTuile nom;

    // constructeurs
    //Crée une carte
    public CarteInondation(NomTuile nom){
        setDescription("inondation");// Description par défault de la carte
        setNom(nom);//avec celui fournit en paramètre
    }
    
    //Crée une carte
    CarteInondation(String description, NomTuile nom){
        setDescription(description);//avec la description fournit en paramètre
        setNom(nom);// avec le nom fournit en paramètre
    }
    // setteurs
    // Méthode qui met à jour le nom de la carte
    public void setNom(NomTuile nom) {
        this.nom = nom;
    }

    // getteurs
    // Méthode qui renvoie le nom de la carte
    public NomTuile getNom() {
        return nom;
    }
    // autres

}
