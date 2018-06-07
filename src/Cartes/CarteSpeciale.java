package Cartes;

import Enumerations.NomCarteSpeciale;

public class CarteSpeciale extends CarteTresors {

    // attributs
    private NomCarteSpeciale nom;// Nom de la carte

    // constructeurs
    //Crée une carte
    public CarteSpeciale(NomCarteSpeciale nom) {
        super();// uttilise le constructeur de la classe mère Carte
        setNom(nom);// avec le nom fournit en paramètre
    }
    //Crée une carte
    public CarteSpeciale(String description, NomCarteSpeciale nom) {
        super(description);//Uttilise le constructeur de la classe mère Carte
        setNom(nom);//avec le nom fournit en paramètre
    }

    // setteurs
    // Méthode qui met à jour le nom de la carte
    public void setNom(NomCarteSpeciale nom) {
        this.nom = nom;
    }
    // getteurs
    // Méthode qui renvoie le nom de la carte
    public NomCarteSpeciale getNom() {
        return nom;
    }

}
