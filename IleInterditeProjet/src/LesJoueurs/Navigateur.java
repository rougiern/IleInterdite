/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LesJoueurs;

import LesJoueurs.Aventurier;
import ileinterditeproj.Utils.Pion;
import ileinterditeproj.Tuile;
import java.util.ArrayList;

/**
 *
 * @author kemplail
 */
public class Navigateur extends Aventurier {
    
    public Navigateur(String nom, Tuile tuiledé) {
        super(nom,tuiledé);
        this.setPion(Pion.JAUNE);
    }
    

}