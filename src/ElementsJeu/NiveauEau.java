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
        this.semiNiveau = semiNiveau;  //Initialise la variable avec la valeur donnée en paramètre
        if (!initialise && (semiNiveau == 1 || semiNiveau == 2)) {  //Vérifie si initialisé et que semiNiveau =1 ou semiNiveau = 2
            setNiveau(2);  //Initialise Niveau avec la valeur 2 
        } else if (!initialise && (semiNiveau ==3 || semiNiveau == 4)) {  //Vérifie si intialisé et que semiNiveau = 3 ou semiNiveau = 4
            setNiveau(3);  //Initialise Niveau à 3 
        } else if (initialise && (semiNiveau == 3 || semiNiveau == 6 || semiNiveau == 8 || semiNiveau == 10)) {  //Vérifie que initialisé = faux et que semiNiveau= 6 ou 8 ou 10
            setNiveau(getNiveau() + 1);  //Initialse le niveau avec la valeur niveau + 1
        }
        initialise = true;  //Initialise la variable à vrai
    }

    // getteurs
    public int getMaximum() {
        return maximum;  //Retourne la valeur de maximum
    }

    public int getNiveau() {
        return niveau;  //Retourne la valeur de niveau
    }

    public int getSemiNiveau() {
        return semiNiveau;  //Retourne la valeur de semiNiveau
    }

    // autres
    public void monterNiveau() {
        setSemiNiveau(semiNiveau + 1);  //Rajoute un niveau à la valeur de semiNiveau
    }

    public void baisserNiveau() {
        setNiveau(niveau - 1);  //Retire un niveau à la valeur de semiNiveau
    }
}
