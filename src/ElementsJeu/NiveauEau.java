package ElementsJeu;

public class NiveauEau {

    // attributs
    private int maximum;
    private int niveau;

    // constructeurs
    NiveauEau(int maximum, int niveau) {
        setMaximum(maximum);
        setNiveau(niveau);
    }

    // setteurs
    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    // getteurs
    public int getMaximum() {
        return maximum;
    }

    public int getNiveau() {
        return niveau;
    }

    // autres
    public void monterNiveau() {
        setNiveau(niveau + 1);
    }

    public void baisserNiveau() {
        setNiveau(niveau - 1);
    }
}
