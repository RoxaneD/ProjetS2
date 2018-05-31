/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import ElementsJeu.Observateur;
import Enumerations.Actions;

/**
 *
 * @author deflandr
 */
public interface Observe {

    public void addObservateur(Observateur o);

    public void notifierObservateur(Actions a);
}
