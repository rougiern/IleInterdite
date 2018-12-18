/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kemplail
 */
public class Ingenieur extends Aventurier {
    
    Ingenieur(String nom, Tuile tuiledé) {
        super(nom, tuiledé);
        this.setPion(Pion.ROUGE);
    }
        
    public void assechertuile2efois(Tuile t) {
        t.setEtat(EtatTuile.Normal);
    }
    
    
}