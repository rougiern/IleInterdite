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
    
    public void afficherJoueurs(){
        
        for (Aventurier j: joueurs){
            
            System.out.println("Nom :"+j.getNom()+" Role:"+j.getClass().getSimpleName());
            
        }
       
    }
    
    public void afficherGrille(){
        int i = 1;
        for (int x=0; x<6;x++){
            for (int y=0;y<6;y++){
                System.out.println("Tuiles n°"+i+"="+grille.getTableau()[x][y].getNom());
                i++;
                
            }
       }
    
    }

    /**
     * @param joueurs the joueurs to set
     */
    public void setJoueurs() {
        System.out.println("Combien y a t'il de joueurs ?");
        Scanner sc = new Scanner(System.in) ;
        int nbJ = sc.nextInt();
        while (nbJ >4 || nbJ < 2 ) {
             
             System.out.println("Le nombre de joueurs doit être compris entre 2 et 4 inclus");
             nbJ = sc.nextInt();
        }
        for(int i = 0 ; i<nbJ ; i++){
            System.out.println("Entrez votre nom");
            String nom = sc.next();
            System.out.println("Entrez votre role");
            String role = sc.next();
            while ( role.equals("plongeur")==false && role.equals("messager")==false && role.equals("navigateur")==false && role.equals("explorateur")==false && role.equals("ingenieur")==false && role.equals("pilote")==false ) {
               System.out.println("Le role n'existe pas veuillez choisir un role valide ");
               role = sc.nextLine();
            }
            if(role.equals("plongeur")){
                Plongeur p = new Plongeur(nom,new Tuile("La Porte de Fer")); //Noir
                joueurs.add(p);
            }else if(role.equals("messager")){
                Messager m = new Messager(nom,new Tuile("La Porte d'Argent"));  //Blanc
                joueurs.add(m);
            }else if(role.equals("navigateur")){
                Navigateur n = new Navigateur(nom,new Tuile("La Porte d'Or")); // Jaune
                joueurs.add(n);
            }else if(role.equals("pilote")){
                Pilote pilote = new Pilote(nom,new Tuile("Heliport")); // Bleu
                joueurs.add(pilote);
            }else if(role.equals("ingenieur")){
                Ingenieur ing = new Ingenieur(nom,new Tuile("La Porte de Bronze")); //Rouge
                joueurs.add(ing);
            }else if(role.equals("explorateur")){
                Explorateur exp = new Explorateur(nom,new Tuile("La Porte de Cuivre")); //Vert
                joueurs.add(exp);
            }
            
        }
        
    }
    
}