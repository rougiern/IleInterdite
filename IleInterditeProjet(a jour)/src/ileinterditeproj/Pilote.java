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
public class Pilote extends Aventurier {
    
    private int nbvol = 1;
    
    Pilote(String nom, Tuile tuiledé) {
        super(nom, tuiledé);
        this.setPion(Pion.VERT);
    }
    
    public ArrayList<Tuile> seDeplacerVol(Grille g) {

       ArrayList<Tuile> tuilesatteignable = new ArrayList();
       
       if(this.getPtsaction()>0 && this.getNbvol() == 1){
           Tuile tuileactuelle = this.getTuileCourante();
           tuilesatteignable=g.getTuilesNonCoulees();
           this.setNbvol(0);
    }
       return  tuilesatteignable;
    }
    
    public void changerTuileCourante(Tuile nouvelleTuile){
        this.getTuileCourante().retirerAventurierTuile(this);
        this.setTuileCourante(nouvelleTuile);
        this.getTuileCourante().addAventurierTuile(this);
        this.setPtsaction(this.getPtsaction()-1);
        
    }

    /**
     * @return the nbvol
     */
    public int getNbvol() {
        return nbvol;
    }

    /**
     * @param nbvol the nbvol to set
     */
    public void setNbvol(int nbvol) {
        this.nbvol = nbvol;
    }
}