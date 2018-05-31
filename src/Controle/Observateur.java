/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;
import Enumerations.Actions;

/**
 *
 * @author deflandr
 */
public interface Observateur {
    public void traiterAction(Actions a);
}
