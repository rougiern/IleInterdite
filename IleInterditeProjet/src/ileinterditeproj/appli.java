/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import Vues.VuePlateau;
import Vues.VueTuile;
import java.util.ArrayList;
import javax.swing.JFrame;

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
        VuePlateau v = new VuePlateau(c.getGrille());
        
      
    }
    
}
