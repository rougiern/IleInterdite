/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

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
    public void seDeplacer(Grille g) {
        
    }

    @Override
    public void assecher() {
        
    }
    
    public void deplacerJoueur(Aventurier aventurier) {
        
    }
    
}