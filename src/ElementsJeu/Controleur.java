package ElementsJeu;


import Cartes.CarteTresor;
import Cartes.CarteInondation;
import Cartes.CarteAventurier;
import Enumerations.Actions;

public class Controleur implements Observateur {

        
	public void traiterAction(Actions action) {
		throw new UnsupportedOperationException();
	}

	public CarteTresor getCarteTresor() {
		throw new UnsupportedOperationException();
	}

	public int getNiveau() {
		throw new UnsupportedOperationException();
	}

	public CarteInondation getCarteInondation() {
		throw new UnsupportedOperationException();
	}

	public String getNomJoueur() {
		throw new UnsupportedOperationException();
	}
        
	public void getAventurier(String nomJoueur) {
		throw new UnsupportedOperationException();
	}

	public Tuile getChoixDeplacement() {
		throw new UnsupportedOperationException();
        }
                
	public CarteAventurier getCarteAventurier(String nomJoueur) {
		throw new UnsupportedOperationException();
	}

	public Tuile getChoixAssechement() {
		throw new UnsupportedOperationException();
	}

}