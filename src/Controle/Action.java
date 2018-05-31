//
package Controle;

public class Action {

    // attributs
    private String nomJoueur;
    private TypesActions type;

    // constructeurs
    public Action(TypesActions type, String nomJoueur) {
        setType(type);
        setNomJoueur(nomJoueur);
    }

    // setteurs
    public void setType(TypesActions type) {
        this.type = type;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    // getteurs
    public TypesActions getType() {
        return type;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    // autres
}
