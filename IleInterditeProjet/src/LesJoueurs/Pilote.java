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

/**
 *
 * @author kemplail
 */
public class Pilote extends Aventurier {
    
    private int nbvol = 1;
    
    public Pilote(String nom, Tuile tuiledé) {
        super(nom, tuiledé);
        this.setPion(Pion.BLEU);
    }
    
    public ArrayList<Tuile> seDeplacerVol(Grille g) {

       ArrayList<Tuile> tuilesatteignable = new ArrayList();
       
       if(this.getPtsaction()>0 && this.getNbvol() == 1){
           Tuile tuileactuelle = this.getTuileCourante();
           tuilesatteignable=g.getTuilesNonCoulees();
           enleveUnVol();
    }
       return  tuilesatteignable;
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
    
    public void enleveUnVol() {
        this.setNbvol(0);
    }
    
}