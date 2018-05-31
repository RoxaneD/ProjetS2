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
    public void addObservateur(Observateur o) {
        this.observateur = o;
    }

    public void notifierObservateur(Action action) {
        if (observateur != null) {
            observateur.traiterAction(action);
        }
    }
}
