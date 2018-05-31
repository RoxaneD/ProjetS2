package Tas;

import Cartes.CarteInondation;
import java.util.ArrayList;

public class DefausseInondations {

    // attributs
    private ArrayList<CarteInondation> cartesInondation;

    // constructeurs
    public DefausseInondations() {
        setCartesInondation();
    }

    // setteurs
    public void setCartesInondation() {
        cartesInondation = new ArrayList<>();
    }

    // getteurs
    public ArrayList<CarteInondation> getCartesInondation() {
        return cartesInondation;
    }

    // autres
    public void addCarte(CarteInondation carte) {
        // pour rajouter une carte au DESSUS du paquet
        cartesInondation.add(carte);
    }

    public ArrayList<CarteInondation> recupererCartes() {
        // pour récupérer tout le paquet (le paquet devient alors vide)
        ArrayList<CarteInondation> cartes = cartesInondation;
        cartesInondation = new ArrayList<CarteInondation>();
        return cartes;
    }
}
