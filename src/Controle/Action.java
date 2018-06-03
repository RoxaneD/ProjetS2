//
package Controle;

public class Action {

    // attributs
    private TypesActions type;

    // constructeurs
    public Action(TypesActions type) {
        setType(type);
    }

    // setteurs
    public void setType(TypesActions type) {
        this.type = type;
    }

    // getteurs
    public TypesActions getType() {
        return type;
    }

    // autres
}
