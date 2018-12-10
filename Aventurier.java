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
public abstract class Aventurier {
    
    private String nom ;
    private Tuile tuileCourante ;
    private Pion pion ;
    
    public Aventurier(String nom, Tuile tuiledé) {
        this.setNom(nom);
        this.setTuileCourante(tuileCourante);
        pion=null;
    }

    /**
     * @param g
     * @return the role
     */
   
    
    public abstract void seDeplacer(Grille g);
    
    public abstract void assecher();

    /**
     * @return the tuileDepart
     */
    

    /**
     * @return the tuileCourante
     */
    public Tuile getTuileCourante() {
        return tuileCourante;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @param tuileCourante the tuileCourante to set
     */
    public void setTuileCourante(Tuile tuileCourante) {
        this.tuileCourante = tuileCourante;
    }

    /**
     * @return the pion
     */
    public Pion getPion() {
        return pion;
    }

    /**
     * @param pion the pion to set
     */
    public void setPion(Pion pion) {
        this.pion = pion;
    }
    
}