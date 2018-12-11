/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kemplail
 */
public class Plongeur extends Aventurier {

    Plongeur(String nom, Tuile tuiledé) {
        super(nom, tuiledé);
        this.setPion(Pion.NOIR);
    }
    
    @Override
    public void seDeplacer(Grille g) {
       ArrayList<Tuile> tuilesadj = new ArrayList();
       tuilesadj=g.getTuilesAdjacentesCroix(this.getTuileCourante());
       
       for(Tuile t : tuilesadj){
           System.out.println(t.getNom());
       }
       if(this.getPtsaction()>0){
        System.out.println("Entrez la tuile sur laquel vous voulez vous déplacez");
        Scanner sc = new Scanner(System.in) ;
        String tuilevoulu = sc.nextLine();
        int i =0;
        while(i<tuilesadj.size() && tuilesadj.get(i).getNom().equals(tuilevoulu)==false){
           i++;
        }
        if(i<tuilesadj.size()){
            if(tuilesadj.get(i).getNom().equals(tuilevoulu)){
                if(tuilesadj.get(i).getEtat()!=EtatTuile.Coulee){
                    this.getTuileCourante().retirerAventurierTuile(this);
                    this.setTuileCourante(tuilesadj.get(i));
                    this.getTuileCourante().addAventurierTuile(this);
                    System.out.println("Déplacement effectué");
                    this.setPtsaction(this.getPtsaction()-1);
                    System.out.println("Il vous reste " + this.getPtsaction()+" points d'action");
                }else{
                    System.out.println("Déplacement impossible tuile coulée"); 
                }
            }
        }
       }else{
           System.out.println("Plus de points d'action pour se déplacer");
       }
       
    }
       
       
    

    @Override
    public void assecher() {

    }
    
}
