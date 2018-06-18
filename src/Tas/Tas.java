/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tas;

import Cartes.Carte;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author deflandr
 */
public class Tas {

    public ArrayList<Carte> melangerTas(ArrayList<Carte> cartes) {
        Collections.shuffle(cartes);
        return cartes;
    }
}
