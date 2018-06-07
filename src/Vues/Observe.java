/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Controle.Action;
import Controle.Observateur;

/**
 *
 * @author deflandr
 */
public class Observe {

    //attributs
    private Observateur observateur;

    // autres methodes
    //Ajoute un observateur à un observe
    public void addObservateur(Observateur o) {
        this.observateur = o;
    }

    //envoie un message à l'observateur avec l'action a traiter
    public void notifierObservateur(Action action) {
        if (observateur != null) {
            observateur.traiterAction(action);
        }
    }
}
