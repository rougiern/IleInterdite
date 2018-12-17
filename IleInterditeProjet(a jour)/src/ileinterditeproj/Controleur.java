/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 *
 * @author kemplail
 */
public class Controleur implements Observer {

    private Grille grille;
    private ArrayList<Aventurier> joueurs;
   
    Controleur(Grille g ) {
        
        this.grille=g;
        joueurs = new ArrayList();
        setJoueurs();
        
        
        
        
        
        
        
        
    }
    
    @Override
    public void update(Observable arg0, Object arg1) {
        
    }
    
    public void addAventurier(Aventurier aventurier) {
        
        if (this.getJoueurs().size() < 4) {
        this.getJoueurs().add(aventurier); }
    }

    /**
     * @return the grille
     */
    public Grille getGrille() {
        return grille;
    }

    /**
     * @return the joueurs
     */
    public ArrayList<Aventurier> getJoueurs() {
        return joueurs;
    }

    /**
     * @param joueurs the joueurs to set
     */
    public void setJoueurs() {
        System.out.println("Combien y a t'il de joueurs ?");
        Scanner sc = new Scanner(System.in) ;
        int nbJ = sc.nextInt();
        for(int i = 0 ; i<=nbJ ; i++){
            System.out.println("Entrez votre nom");
            String nom = sc.next();
            System.out.println("Entrez votre role");
            String role = sc.next();
            if(role.equals("plongeur")){
                Plongeur p = new Plongeur(nom,new Tuile("La marée maudite"));
            }else if(role.equals("messager")){
                
            }else if(role.equals("navigateur")){
                
            }else if(role.equals("pilote")){
                
            }else if(role.equals("ingenieur")){
                
            }else if(role.equals("explorateur")){
                
            }
            
        }
        
    }
    
}