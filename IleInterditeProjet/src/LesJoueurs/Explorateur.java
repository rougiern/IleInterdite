/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LesJoueurs;

import LesJoueurs.Aventurier;
import ileinterditeproj.Grille;
import ileinterditeproj.Utils.Pion;
import ileinterditeproj.Tuile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kemplail
 */
public class Explorateur extends Aventurier {
    
    public Explorateur(String nom, Tuile tuiledé) {
        super(nom, tuiledé);
        this.setPion(Pion.VERT);
    }
    
    @Override
    public ArrayList<Tuile> seDeplacer(Grille g) {
       ArrayList<Tuile> tuilesatteignable = new ArrayList();
       
       if(this.getPtsaction()>0){
           Tuile tuileactuelle= this.getTuileCourante();
           tuilesatteignable=g.getTuilesAdjacentesCarreNonCoulees(tuileactuelle);      
    }
       return  tuilesatteignable;
    }

    @Override
    public ArrayList<Tuile> assecher(Grille g) {
        
        ArrayList<Tuile> tuilesassechables = new ArrayList();
        
        if (this.getPtsaction() > 0) {
            Tuile tuileactuelle = this.getTuileCourante();
            tuilesassechables = g.getTuilesAdjacentesCarreInondees(tuileactuelle);
            
        }
        
        return tuilesassechables;
        
    }
       
       
    }
    
       
    
  

