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
public class Plongeur extends Aventurier {

    public Plongeur(String nom, Tuile tuiledé) {
        super(nom, tuiledé);
        this.setPion(Pion.VIOLET);
    }
    
    @Override
    public ArrayList<Tuile> seDeplacer(Grille g) {
       
      ArrayList<Tuile> tuilesatteignable = new ArrayList();
       
       if(this.getPtsaction()>0){
           Tuile tuileactuelle = this.getTuileCourante();
           tuilesatteignable=g.getTuilesAdjacentesPlongeur(tuileactuelle);
    }
       return  tuilesatteignable;
       
    }  
    
}
