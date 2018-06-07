package ElementsJeu;

public class NiveauEau {

    // attributs
    private int maximum;  //Déclaration d'un integer
    private int niveau;  //Déclaration d'un integer
    private int semiNiveau;  //Déclaration d'un integer
    private boolean initialise = false;  //Déclaration d'un booléen et l'initialise avec l'état faux

    // constructeurs du niveau d'eau
    public NiveauEau() {
        setMaximum(10);  //Le niveau Maximum d'eau est de 10
    }

    // setteurs
    public void setMaximum(int maximum) {
        this.maximum = maximum;  //Initialise la variable avec la valeur donné en paramètre
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;  //Initialise la variable avec la valeur donnée en paramètre
    }

    public void setSemiNiveau(int semiNiveau) {
        this.semiNiveau = semiNiveau;  //
        if (!initialise && (semiNiveau == 1 || semiNiveau == 2)) {
            setNiveau(2);
        } else if (!initialise && (semiNiveau ==3 || semiNiveau == 4)) {
            setNiveau(3);
        } else if (initialise && (semiNiveau == 3 || semiNiveau == 6 || semiNiveau == 8 || semiNiveau == 10)) {
            setNiveau(getNiveau() + 1);
        }
        initialise = true;
    }

    // getteurs
    public int getMaximum() {
        return maximum;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getSemiNiveau() {
        return semiNiveau;
    }

    // autres
    public void monterNiveau() {
        setSemiNiveau(semiNiveau + 1);
    }

    public void baisserNiveau() {
        setNiveau(niveau - 1);
    }
}
