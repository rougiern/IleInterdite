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
public class Plongeur extends Aventurier {

    Plongeur(String nom, Tuile tuiledé) {
        super(nom, tuiledé);
        this.setPion(Pion.NOIR);
    }
    
    @Override
    public void seDeplacer(Grille g) {
       ArrayList<Tuile> tuilesadj = new ArrayList();
       tuilesadj=g.getTuilesAdjacentesCroix(this.getTuileCourante());
       
       for(Tuile t : tuilesadj){
           System.out.println(t.getNom());
       }
    }

    @Override
    public void assecher() {
    }
    
}
