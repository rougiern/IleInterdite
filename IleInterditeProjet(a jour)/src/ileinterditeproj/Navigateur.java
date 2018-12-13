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
public class Navigateur extends Aventurier {
    
    Navigateur(String nom, Tuile tuiledé) {
        super(nom,tuiledé);
        this.setPion(Pion.JAUNE);
    }
    
    @Override
    public ArrayList<Tuile> seDeplacer(Grille g) {
        return null;
    }

    @Override
    public void assecher(Grille g) {
        
    }
    
    public void deplacerJoueur(Aventurier aventurier) {
        
    }
    
    public void changerTuileCourante(Tuile nouvelleTuile){
        this.getTuileCourante().retirerAventurierTuile(this);
        this.setTuileCourante(nouvelleTuile);
        this.getTuileCourante().addAventurierTuile(this);
        this.setPtsaction(this.getPtsaction()-1);
        
    }
}