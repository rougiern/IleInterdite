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
public class Plongeur extends Aventurier {

    Plongeur(String nom, Tuile tuiledé) {
        super(nom, tuiledé);
        this.setPion(Pion.NOIR);
    }
    
    @Override
    public ArrayList<Tuile> seDeplacer(Grille g) {
       
      return null;  //A DEFINIR *_*
    }
       
    public void changerTuileCourante(Tuile nouvelleTuile){
        this.getTuileCourante().retirerAventurierTuile(this);
        this.setTuileCourante(nouvelleTuile);
        this.getTuileCourante().addAventurierTuile(this);
        this.setPtsaction(this.getPtsaction()-1);
        
    }

    
    
}
