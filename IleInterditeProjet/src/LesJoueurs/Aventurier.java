/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LesJoueurs;

import ileinterditeproj.CarteHelicoptere;
import ileinterditeproj.CarteSacDeSable;
import ileinterditeproj.CarteTirage;
import ileinterditeproj.CarteTresor;
import ileinterditeproj.EtatTuile;
import ileinterditeproj.Grille;
import ileinterditeproj.ObjetIdentifie;
import ileinterditeproj.Tuile;
import ileinterditeproj.Utils.Pion;
import java.util.ArrayList;

/**
 *
 * @author kemplail
 */
public abstract class Aventurier extends ObjetIdentifie{
    
    private String nom ;
    private int ptsaction  ;
    private Tuile tuileCourante ;
    private Pion pion ;
    private ArrayList<CarteTirage> mains ;
    
    public Aventurier(String nom, Tuile tuilede) {
        super();
        this.setNom(nom);
        this.setTuileCourante(tuilede);
        this.ptsaction=3;
        pion=null;
        mains = new ArrayList();
    }

    /**
     * @param g
     * @return the role
     */
   public boolean pasDeTresor() {
       boolean cond = false ;
       int i =0;
       while(i<mains.size() && !(mains.get(i) instanceof CarteTresor)){
           i++;  
       }
       if(i!=mains.size()){
           cond = true ;
       }
       return cond ;
       
    }
   
   public boolean pasDeCarteAction() {
       boolean cond = false ;
       int i =0;
       while(i<mains.size() && !(mains.get(i) instanceof CarteSacDeSable) && !(mains.get(i) instanceof CarteHelicoptere)){
           i++;  
       }
       if(i!=mains.size()){
           cond = true ;
       }
       return cond ;
       
    }
    
    public ArrayList<Tuile> seDeplacer(Grille g) {

       ArrayList<Tuile> tuilesatteignable = new ArrayList();
       
       if(this.getPtsaction()>0){
           Tuile tuileactuelle = this.getTuileCourante();
           tuilesatteignable=g.getTuilesAdjacentesCroixNonCoulees(tuileactuelle);      
    }
       return  tuilesatteignable;
    }
    
    public ArrayList<Tuile> assecher(Grille g) {
       
        ArrayList<Tuile> tuilesassechables = new ArrayList();
        
        if (this.getPtsaction() > 0) {
            Tuile tuileactuelle = this.getTuileCourante();
            tuilesassechables = g.getTuilesAdjacentesCroixInondees(tuileactuelle);   
        }
        return tuilesassechables;
        }
    
        public void changerTuileCourante(Tuile nouvelletuile) {
        this.getTuileCourante().retirerAventurierTuile(this);
        this.setTuileCourante(nouvelletuile);
        this.getTuileCourante().addAventurierTuile(this);
        this.setPtsaction(this.getPtsaction()-1);
        }
        
        public void assechertuile(Tuile t) {
        
        t.setEtat(ileinterditeproj.Utils.EtatTuile.ASSECHEE);
        this.enleveUneAction();
        
        }

        public ArrayList<Tuile> deplacementParNavigateur(Grille g) {

       ArrayList<Tuile> tuilesatteignable = new ArrayList();
       
           Tuile tuileactuelle = this.getTuileCourante();
           tuilesatteignable=g.getTuilesAdjacentes2CasesNonCoulees(tuileactuelle);      

       return  tuilesatteignable;
    }
        
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
    
    public void enleveUneAction() {
        this.ptsaction = this.getPtsaction()-1;
    }

    /**
     * @return the mains
     */
    public ArrayList<CarteTirage> getMains() {
        return mains;
    }
    
    public void retirerCarte(int numcarte){
        
            mains.remove(numcarte);
        
    }
    
    public boolean possedeHelico(){
       boolean bool = false ;
       for(CarteTirage t : mains){
           if(t instanceof CarteHelicoptere){
               bool = true ;      
           }
       }
       return bool ;
    }
    
    public boolean possedeSacSable(){
       boolean bool = false ;
       for(CarteTirage t : mains){
           if(t instanceof CarteSacDeSable){
               bool = true ;      
           }
       }
       return bool ;
    }

    

}