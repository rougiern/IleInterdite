/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LesJoueurs;

import LesJoueurs.Aventurier;
import ileinterditeproj.Tuile;
import ileinterditeproj.Utils.Pion;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kemplail
 */
public class Messager extends Aventurier {
    
    public Messager(String nom, Tuile tuiledé) {
        super(nom, tuiledé);
        this.setPion(Pion.ORANGE);
    }

    
}