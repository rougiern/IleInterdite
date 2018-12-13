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
public class Explorateur extends Aventurier {
    
    Explorateur(String nom, Tuile tuiledé) {
        super(nom, tuiledé);
        this.setPion(Pion.VERT);
    }
    
    @Override
    public ArrayList<Tuile> seDeplacer(Grille g) {
       ArrayList<Tuile> tuilesatteignable = new ArrayList();
       
       if(this.getPtsaction()>0){
           Tuile tuileactuel= this.getTuileCourante();
           tuilesatteignable=g.getTuilesAdjacentesCarre(this.getTuileCourante());      
    }
       return  tuilesatteignable;
    }

    @Override
    public void assecher(Grille g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changerTuileCourante(Tuile nouvelletuile) {
        this.getTuileCourante().retirerAventurierTuile(this);
        this.setTuileCourante(nouvelletuile);
        this.getTuileCourante().addAventurierTuile(this);
        this.setPtsaction(this.getPtsaction()-1);
    }
       
       
       
    }
    
       
    
  

