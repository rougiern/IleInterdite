/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author kemplail
 */
public class Grille {
    
    private Tuile tableau[][] ; 
    
    
    Grille() {
        
        tableau = new Tuile[6][6];
        
    }

    /**
     * @return the tableau
     */
    public Tuile[][] getTableau() {
        return tableau;
    }

    /**
     * @param tableau the tableau to set
     */
    public void setTableau(ArrayList<Tuile> lestuiles) {
        int i = 0;
        for (int x=0; x<6;x++){
            for (int y=0;y<6;y++){
                if ((x==0 && y ==0) || (x==0 && y==1) || (x==0 && y==4) || (x==0 && y==5) || (x==1 && y==0) ||(x==1 && y==5) || (x==4 && y==0)||(x==4 && y==5) || (x==5 && y==5) || (x==5 && y==0)|| (x==5 && y==1)||(x==5 && y==4) ){
                 tableau[x][y]=new Tuile("null") ;  
                }else{
                tableau[x][y]=lestuiles.get(i);
                i++;
                }
            }
            
        }
        
    }
    

   
    
}
