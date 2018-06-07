//
package Controle;

import ElementsJeu.Tuile;

public class Action {

    // attributs
    private TypesActions type;//Types d'action
    private Tuile tuile;//Tuile où s'effectue l'action

    // constructeurs
    //Crée une action
    public Action(TypesActions type) {
        setType(type);//avec le type fournis en paramètre
    }

    //Crée une action 
    public Action(TypesActions type, Tuile tuile) {
        setType(type);//avec le type fournit en paramètre
        setTuile(tuile);//avec la tuile fournis en paramètre
    }

    // setteurs
    // Méthode qui met à jour le type d'action
    public void setType(TypesActions type) {
        this.type = type;
    }

    //Méthode qui met a jour la tuile
    public void setTuile(Tuile tuile) {
        this.tuile = tuile;
    }

    // getteurs
    //Méthode qui renvoie le type d'action
    public TypesActions getType() {
        return type;
    }

    //Méthode qui renvioe la tuile 
    public Tuile getTuile() {
        return tuile;
    }

    // autres
}
