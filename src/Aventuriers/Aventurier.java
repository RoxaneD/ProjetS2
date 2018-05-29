package Aventuriers;

import ElementsJeu.Tuile;
import Enumerations.Couleur;
import Enumerations.EtatAventurier;
import java.util.ArrayList;

public abstract class Aventurier {

	private String nomJoueur;
	private EtatAventurier etat;
	private Couleur couleur;

	public void getTuile() {
		// TODO - implement Aventurier.getTuile
		throw new UnsupportedOperationException();
	}

	public abstract ArrayList<Tuile> calculDeplacementPos();

	public void removeTuile() {
		// TODO - implement Aventurier.removeTuile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tuile
	 */
	public void addTuile(Tuile tuile) {
		// TODO - implement Aventurier.addTuile
		throw new UnsupportedOperationException();
	}

	public abstract ArrayList<Tuile> calculAssechementPos();

}