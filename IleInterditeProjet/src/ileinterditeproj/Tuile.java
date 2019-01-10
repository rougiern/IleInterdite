/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import LesJoueurs.Aventurier;
import java.util.ArrayList;

/**
 *
 * @author kemplail
 */
public class Tuile extends ObjetIdentifie{
    
    private String nom;
    private ArrayList<Aventurier> aventuriers;
    private Utils.EtatTuile etat ;
    
    Tuile(String nom) {
        super();
        this.setNom(nom);
        aventuriers = new ArrayList<>();
        etat=Utils.EtatTuile.ASSECHEE;
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
    
    public void retirerAventurierTuile(Aventurier a){
        int i =0;
         while(i<getAventuriers().size()&& getAventuriers().get(i).getNom().equals(a.getNom())){
                i++;
            }
            if(i!=getAventuriers().size()){
            getAventuriers().remove(i);
            }
    }
    
    public void addAventurierTuile(Aventurier a){
        
        getAventuriers().add(a);
    }

    /**
     * @return the aventuriers
     */
    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;
    }

    /**
     * @param aventuriers the aventuriers to set
     */
    public void setAventuriers(ArrayList<Aventurier> aventuriers) {
        this.aventuriers = aventuriers;
    }

    /**
     * @return the etat
     */
    public Utils.EtatTuile getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(Utils.EtatTuile etat) {
        this.etat = etat;
    }
    
}
