/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

/**
 *
 * @author duttod
 */
public class CarteInondation extends ObjetIdentifie{
    
    private Tuile tuile ;
    
    public CarteInondation(Tuile t){
        this.tuile=t;
   
    }   

    /**
     * @return the tuile
     */
    public Tuile getTuile() {
        return tuile;
    }

    /**
     * @param tuile the tuile to set
     */
    public void setTuile(Tuile tuile) {
        this.tuile = tuile;
    }
    
    
    
}
