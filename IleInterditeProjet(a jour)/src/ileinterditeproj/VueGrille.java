/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rougiern
 */
public class VueGrille extends Observable{
    private final JFrame window;
    
    public VueGrille(){
        
        window = new JFrame();
        window.setSize(2500, 1200); // plein écran
        
        JPanel mainPanel = new JPanel(new BorderLayout());  // le panel principal contenant le BorderLayout
        window.add(mainPanel);
        
        JPanel contentPanel = new JPanel (new GridLayout(6, 6)); // la grille contenue dans le BorderLayout
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        // à continuer plus tard pour le projet tutoré
        
        
        
        
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }
    
    
    
}
