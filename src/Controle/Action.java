//
package Controle;

import ElementsJeu.Tuile;

public class Action {

    // attributs
    private TypesActions type;
    private Tuile tuile;

    // constructeurs
    public Action(TypesActions type) {
        setType(type);
    }

    public Action(TypesActions type, Tuile tuile) {
        setType(type);
        setTuile(tuile);
    }

    // setteurs
    public void setType(TypesActions type) {
        this.type = type;
    }

    public void setTuile(Tuile tuile) {
        this.tuile = tuile;
    }

    // getteurs
    public TypesActions getType() {
        return type;
    }

    public Tuile getTuile() {
        return tuile;
    }

    // autres
}
