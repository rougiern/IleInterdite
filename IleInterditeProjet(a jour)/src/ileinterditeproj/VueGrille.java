/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author rougiern
 */
public class VueGrille extends Observable{
    
    
    
    public VueGrille(){
        
        
        
        
        
        
    }
    
    public void afficherTuiles(ArrayList<Tuile> listetuiles) {
        for (Tuile t : listetuiles) {
            System.out.println(t.getNom());
        }
        
    }
    
    public String saisirJoueur(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom du joueur a déplacez");
        String nomjoueuradeplacer = sc.nextLine();
        return nomjoueuradeplacer ;
    }
    
    public String saisirNomTuile(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom de la tuile");
        String nomtuile = sc.nextLine();
        return nomtuile ;
    }
    
    public void fintour(){
        
        System.out.println("Fin du tour points d'action remis a 3 pour tout les joueurs");
        
    }

    /**
     * @return the nomjoueur
     */
    

    /**
     * @param nomjoueur the nomjoueur to set
     */
    
    
    public boolean questionOuiNon(String question){
        
        System.out.println(question);
        Scanner sc = new Scanner(System.in);
        String rep = sc.nextLine();
        
        return rep.equals("oui");
        
    }
    
    public void poserQuestion(String question){
        
        System.out.println(question);
        
    }
    
    public String saisirCaseAassecher(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom de la case a assécher");
        String nomtuile = sc.nextLine();
        return nomtuile ;
    }
    
    public static void afficherInformation(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.OK_OPTION);
    }
       
    
    
    
    
}
