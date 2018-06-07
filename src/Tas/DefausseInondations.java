package Tas;

import Cartes.CarteInondation;
import java.util.ArrayList;

public class DefausseInondations {

    // attributs
    private ArrayList<CarteInondation> cartesInondation;

    // constructeurs
    //Crée une defausse de carte inondation
    public DefausseInondations() {
        setCartesInondation();
    }

    // setteurs
    //Crée un ArrayList de carte inondation
    public void setCartesInondation() {
        cartesInondation = new ArrayList<>();
    }

    // getteurs
    //Renvoie un ArrayList de carte inondation
    public ArrayList<CarteInondation> getCartesInondation() {
        return cartesInondation;
    }

    // autres
    //Ajouter une carte à la defausse
    public void addCarte(CarteInondation carte) {
        // pour rajouter une carte au DESSUS du paquet
        cartesInondation.add(carte);
    }

    public ArrayList<CarteInondation> recupererCartes() {
        // pour récupérer tout le paquet (le paquet devient alors vide)
        ArrayList<CarteInondation> cartes = cartesInondation;
        cartesInondation = new ArrayList<CarteInondation>();//Crée un arrylist de carte tresor
        return cartes;//renvoie l'Arraylist de carte
    }
}
