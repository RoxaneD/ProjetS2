package ElementsJeu;

public class NiveauEau {

    // attributs
    private int maximum;
    private int niveau;
    private int semiNiveau;
    private boolean initialise = false;

    // constructeurs
    public NiveauEau() {
        setMaximum(10);
    }

    // setteurs
    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setSemiNiveau(int semiNiveau) {
        this.semiNiveau = semiNiveau;
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
