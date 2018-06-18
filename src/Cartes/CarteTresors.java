package Cartes;

import Enumerations.NomCarteSpeciale;
import Enumerations.NomTresor;

public class CarteTresors extends Carte {
    
    //attributs
    private NomTresor nom;

    // constructeurs
    //Crée une carte
    public CarteTresors(){
        setDescription("");//Description par défault de la carte
    }
    
    //Crée une carte
    public CarteTresors(String description){
        setDescription(description);//Description de la carte fournit en paramètre
    }
    
    public CarteTresors(NomTresor nom) {
        super();//uttilise le construceur de la classe mère Carte
        setNom(nom);// avec le nom fournit en paramètre
    }

    //Crée une carte
    public CarteTresors(String description, NomTresor nom) {
        setDescription("");
        setNom(nom);// avec le nom fournit en paramètre
    }

    // setteurs
    //Méthode qui met à jour le nom de la carte
    public void setNom(NomTresor nom) {
        this.nom = nom;
    }
    // getteurs
    //Méthode qui renvoie le nom de la carte
    public NomTresor getNom() {
        return nom;
    }
}
