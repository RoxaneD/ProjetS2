package Cartes;

import Enumerations.NomCarteSpeciale;

public class CarteTresors extends Carte {

    // constructeurs
    //Crée une carte
    public CarteTresors(){
        setDescription("");//Description par défault de la carte
    }
    
    //Crée une carte
    public CarteTresors(String description){
        setDescription(description);//Description de la carte fournit en paramètre
    }
}
