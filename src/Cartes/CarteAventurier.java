package Cartes;


import Cartes.Carte;
import Enumerations.Couleur;
import Enumerations.NomAventurier;

public class CarteAventurier extends Carte {

	private NomAventurier nom;
        private Couleur couleur;

	public NomAventurier getNom() {
		return this.nom;
	}

}