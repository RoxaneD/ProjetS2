package Tas;

import Cartes.CarteTresors;
import java.util.ArrayList;

public class DefausseTresors extends Tas{

    // attributs
    private ArrayList<CarteTresors> cartesTresors;

    // constructeurs
    //Crée une defausse de carte tresor
    public DefausseTresors() {
        setCartesTresors();
    }

    // setteurs
    //Crée un ArrayList de carte tresor
    public void setCartesTresors() {
        cartesTresors = new ArrayList<>();
    }

    // getteurs
    //Renvoie un ArrayList de carte tresor    
    public ArrayList<CarteTresors> getCartesTresors() {
        return cartesTresors;
    }

    // autres
    //Ajouter une carte à la defausse
    public void addCarte(CarteTresors carte) {
        // pour rajouter une carte au DESSUS du paquet
        cartesTresors.add(carte);
    }

    public ArrayList<CarteTresors> recupererCartes() {
        // pour récupérer tout le paquet (le paquet devient alors vide)
        ArrayList<CarteTresors> cartes = cartesTresors;
        cartesTresors = new ArrayList<CarteTresors>();//Crée un arrylist de carte tresor
        return cartes;//renvoie l'Arraylist de carte
    }
}
