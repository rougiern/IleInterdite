/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rougiern
 */
public class VueInitialisation extends Observable{
  
    private int nbj;
    private ArrayList<String> roles ;
    private ArrayList<String> noms ;
    
    public VueInitialisation(){
        roles = new ArrayList();
        noms = new ArrayList();
        System.out.println("Combien y a t'il de joueurs ?");
        Scanner sc = new Scanner(System.in) ;
        nbj = sc.nextInt();
        while (nbj>4 || nbj < 2 ) {      
             System.out.println("Le nombre de joueurs doit être compris entre 2 et 4 inclus");  
        }
        for(int i = 0 ; i<nbj ; i++){
            System.out.println("Entrez votre nom");
            String nom = sc.next();
            noms.add(nom);
            System.out.println("Entrez votre role");
            String role = sc.next();
            while ( !(role.equals("plongeur")) && !(role.equals("messager")) && !(role.equals("navigateur")) && !(role.equals("explorateur")) && !(role.equals("ingenieur")) && !(role.equals("pilote")) ) {
               System.out.println("Le role n'existe pas veuillez choisir un role valide ");
               role = sc.nextLine();
            }
            roles.add(role);
                
               
            }
            
        }
        
        
        
        
        
    

    /**
     * @return the nbj
     */
    public int getNbj() {
        return nbj;
    }

    /**
     * @param nbj the nbj to set
     */
    public void setNbj(int nbj) {
        this.nbj = nbj;
    }

    /**
     * @return the role
     */

    /**
     * @return the roles
     */
    public ArrayList<String> getRoles() {
        return roles;
    }

    /**
     * @return the noms
     */
    public ArrayList<String> getNoms() {
        return noms;
    }
   
    
    
    
}
