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
public abstract class Aventurier {
    
    private String nom ;
    private Tuile tuileDepart;
    private Tuile tuileCourante ;
    
    public Aventurier(String nom, Tuile tuiledé) {
        this.setNom(nom);
        this.setTuileDepart(tuiledé);
    }

    /**
     * @return the role
     */
   
    
    public abstract void seDeplacer();
    
    public abstract void assecher();

    /**
     * @return the tuileDepart
     */
    public Tuile getTuileDepart() {
        return tuileDepart;
    }

    /**
     * @param tuileDepart the tuileDepart to set
     */
    public void setTuileDepart(Tuile tuileDepart) {
        this.tuileDepart = tuileDepart;
    }

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
    
}