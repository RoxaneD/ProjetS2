package Vues;

import Controle.Action;
import Controle.Observateur;

public interface Observe {
    
    //Ajoute un observateur à un observe
    public void addObservateur(Observateur o);

    //envoie un message à l'observateur avec l'action a traiter
    public void notifierObservateur(Action action);
}
