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
public class Messager extends Aventurier {
    
    Messager(String nom, Tuile tuiledé) {
        super(nom, tuiledé);
        this.setPion(Pion.BLANC);
    }
    
    @Override
    public void seDeplacer(Grille g) {
    }

    @Override
    public void assecher() {
    }
    
}