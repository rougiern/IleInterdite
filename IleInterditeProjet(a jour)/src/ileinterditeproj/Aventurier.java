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
    private int ptsaction  ;
    private Tuile tuileCourante ;
    private Pion pion ;
    
    public Aventurier(String nom, Tuile tuilede) {
        this.setNom(nom);
        this.setTuileCourante(tuilede);
        this.ptsaction=3;
        pion=null;
    }

    /**
     * @param g
     * @return the role
     */
   
    
    public abstract ArrayList<Tuile> seDeplacer(Grille g);
    
    public abstract void assecher(Grille g);

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

    /**
     * @return the ptsaction
     */
    public int getPtsaction() {
        return ptsaction;
    }

    /**
     * @param ptsaction the ptsaction to set
     */
    public void setPtsaction(int ptsaction) {
        this.ptsaction = ptsaction;
    }

    public abstract void changerTuileCourante(Tuile nouvelletuile);
    //To change body of generated methods, choose Tools | Templates.

}