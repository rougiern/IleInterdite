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
    
    @Override
    public ArrayList<Tuile> seDeplacer(Grille g) {

       ArrayList<Tuile> tuilesatteignable = new ArrayList();
       
       if(this.getPtsaction()>0){
           Tuile tuileactuel= this.getTuileCourante();
           tuilesatteignable=g.getTuilesAdjacentesCroix(this.getTuileCourante());      
    }
       return  tuilesatteignable;
    }

    @Override
    public void assecher(Grille g) {
       
    }
    
    @Override
    public void changerTuileCourante(Tuile nouvelleTuile){
        this.getTuileCourante().retirerAventurierTuile(this);
        this.setTuileCourante(nouvelleTuile);
        this.getTuileCourante().addAventurierTuile(this);
        this.setPtsaction(this.getPtsaction()-1);
        
    }
    
    
}
