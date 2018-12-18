/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import java.util.ArrayList;

/**
 *
 * @author kemplail
 */
public class Navigateur extends Aventurier {
    
    Navigateur(String nom, Tuile tuiledé) {
        super(nom,tuiledé);
        this.setPion(Pion.JAUNE);
    }
    

}