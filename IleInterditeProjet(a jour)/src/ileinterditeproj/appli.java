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
public class appli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
        Controleur c = new Controleur();
//        c.afficherJoueurs();
//        c.afficherGrille();
//        c.getJoueurs().get(0).seDeplacer(c.getGrille());
//        c.getJoueurs().get(1).seDeplacer(c.getGrille());
          VueAventurier vueAventurier = new VueAventurier("jean", "Ingenieur",Pion.ROUGE.getCouleur() );
          vueAventurier.addObserver(c);
        
    }
    
}
