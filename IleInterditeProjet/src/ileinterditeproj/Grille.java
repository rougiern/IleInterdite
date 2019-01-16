/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

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

    public ArrayList<Tuile> getTuilesAdjacentesCroixNonCoulees(Tuile tuileCourante) {
        int posX = 0;
        int posY =0;
        for (int x=0; x<6;x++){
            for (int y=0;y<6;y++){
                if (tableau[x][y].getNom().equals(tuileCourante.getNom())){
                 posX=x;
                 posY=y;
                
                }
            }
        }
        
        ArrayList<Tuile> tuilesadj = new ArrayList();
        
        if(posX!=0){
            if(tableau[posX-1][posY].getNom().equals("null")==false && tableau[posX-1][posY].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX-1][posY]);}}
        
        if(posX!=5){
            if(tableau[posX+1][posY].getNom().equals("null")==false && tableau[posX+1][posY].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX+1][posY]);}}
        
        if(posY!=5){
            if(tableau[posX][posY+1].getNom().equals("null")==false && tableau[posX][posY+1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX][posY+1]);}}
        
        if(posY!=0){
            if(tableau[posX][posY-1].getNom().equals("null")==false && tableau[posX][posY-1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX][posY-1]);}}
        
        return tuilesadj ;
        
    }
    
     public ArrayList<Tuile> getTuilesAdjacentesCroixInondees(Tuile tuileCourante) {
        int posX = 0;
        int posY =0;
        for (int x=0; x<6;x++){
            for (int y=0;y<6;y++){
                if (tableau[x][y].getNom().equals(tuileCourante.getNom())){
                 posX=x;
                 posY=y;
                
                }
            }
        }
        
        ArrayList<Tuile> tuilesadj = new ArrayList();
        
        if(posX!=0){
            if(tableau[posX-1][posY].getNom().equals("null")==false && tableau[posX-1][posY].getEtat()==Utils.EtatTuile.INONDEE){
                tuilesadj.add(tableau[posX-1][posY]);}}
        
        if(posX!=5){
            if(tableau[posX+1][posY].getNom().equals("null")==false && tableau[posX+1][posY].getEtat()==Utils.EtatTuile.INONDEE){
                tuilesadj.add(tableau[posX+1][posY]);}}
        
        if(posY!=5){
            if(tableau[posX][posY+1].getNom().equals("null")==false && tableau[posX][posY+1].getEtat()==Utils.EtatTuile.INONDEE){
                tuilesadj.add(tableau[posX][posY+1]);}}
        
        if(posY!=0){
            if(tableau[posX][posY-1].getNom().equals("null")==false && tableau[posX][posY-1].getEtat()==Utils.EtatTuile.INONDEE){
                tuilesadj.add(tableau[posX][posY-1]);}}
        
        return tuilesadj ;
        
    }
    
    public ArrayList<Tuile> getTuilesAdjacentesCarreNonCoulees(Tuile tuileCourante) {
        int posX = 0;
        int posY =0;
        for (int x=0; x<6;x++){
            for (int y=0;y<6;y++){
                if (tableau[x][y].getNom().equals(tuileCourante.getNom())){
                 posX=x;
                 posY=y;
                
                }
            }
        }
        
        ArrayList<Tuile> tuilesadj = new ArrayList();
        
        if(posX!=0){
            if(tableau[posX-1][posY].getNom().equals("null")==false && tableau[posX-1][posY].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX-1][posY]);}}
        
        if(posX!=5){
            if(tableau[posX+1][posY].getNom().equals("null")==false && tableau[posX+1][posY].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX+1][posY]);}}
        
        if(posY!=5){
            if(tableau[posX][posY+1].getNom().equals("null")==false && tableau[posX][posY+1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX][posY+1]);}}
        
        if(posY!=0){
            if(tableau[posX][posY-1].getNom().equals("null")==false && tableau[posX][posY-1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX][posY-1]);}}
        
        if(posX>0 && posY >0){
            if(tableau[posX-1][posY-1].getNom().equals("null")==false && tableau[posX-1][posY-1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX-1][posY-1]);}}
        
        if(posX<5 && posY<5 ){
            if(tableau[posX+1][posY+1].getNom().equals("null")==false && tableau[posX+1][posY+1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX+1][posY+1]);}}
        
        if(posX>0 && posY<5 ){
            if(tableau[posX-1][posY+1].getNom().equals("null")==false && tableau[posX-1][posY+1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX-1][posY+1]);}}
        
        if(posX<5 && posY>0){
            if(tableau[posX+1][posY-1].getNom().equals("null")==false && tableau[posX+1][posY-1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX+1][posY-1]);}}
        
        
        
        return tuilesadj ;
        
    }
    
    public ArrayList<Tuile> getTuilesAdjacentesCarreInondees(Tuile tuileCourante) {
        int posX = 0;
        int posY =0;
        for (int x=0; x<6;x++){
            for (int y=0;y<6;y++){
                if (tableau[x][y].getNom().equals(tuileCourante.getNom())){
                 posX=x;
                 posY=y;
                
                }
            }
        }
        
        ArrayList<Tuile> tuilesadj = new ArrayList();
        
        if(posX!=0){
            if(tableau[posX-1][posY].getNom().equals("null")==false && tableau[posX-1][posY].getEtat()==Utils.EtatTuile.INONDEE){
                tuilesadj.add(tableau[posX-1][posY]);}}
        
        if(posX!=5){
            if(tableau[posX+1][posY].getNom().equals("null")==false && tableau[posX+1][posY].getEtat()==Utils.EtatTuile.INONDEE){
                tuilesadj.add(tableau[posX+1][posY]);}}
        
        if(posY!=5){
            if(tableau[posX][posY+1].getNom().equals("null")==false && tableau[posX][posY+1].getEtat()==Utils.EtatTuile.INONDEE){
                tuilesadj.add(tableau[posX][posY+1]);}}
        
        if(posY!=0){
            if(tableau[posX][posY-1].getNom().equals("null")==false && tableau[posX][posY-1].getEtat()==Utils.EtatTuile.INONDEE){
                tuilesadj.add(tableau[posX][posY-1]);}}
        
        if(posX>0 && posY >0){
            if(tableau[posX-1][posY-1].getNom().equals("null")==false && tableau[posX-1][posY-1].getEtat()==Utils.EtatTuile.INONDEE){
                tuilesadj.add(tableau[posX-1][posY-1]);}}
        
        if(posX<5 && posY<5 ){
            if(tableau[posX+1][posY+1].getNom().equals("null")==false && tableau[posX+1][posY+1].getEtat()==Utils.EtatTuile.INONDEE){
                tuilesadj.add(tableau[posX+1][posY+1]);}}
        
        if(posX>0 && posY<5 ){
            if(tableau[posX-1][posY+1].getNom().equals("null")==false && tableau[posX-1][posY+1].getEtat()==Utils.EtatTuile.INONDEE){
                tuilesadj.add(tableau[posX-1][posY+1]);}}
        
        if(posX<5 && posY>0){
            if(tableau[posX+1][posY-1].getNom().equals("null")==false && tableau[posX+1][posY-1].getEtat()==Utils.EtatTuile.INONDEE){
                tuilesadj.add(tableau[posX+1][posY-1]);}}
        
        
        
        return tuilesadj ;
        
    }
    
public ArrayList<Tuile> getTuilesNonCoulees() {
    
    ArrayList<Tuile> tuilesatteignables = new ArrayList<>();
    
    for (int x=0; x<6;x++){
            for (int y=0;y<6;y++){
                    if ((tableau[x][y].getEtat()==Utils.EtatTuile.ASSECHEE || tableau[x][y].getEtat()==Utils.EtatTuile.INONDEE) && tableau[x][y].getNom() != "null") {
                        tuilesatteignables.add(tableau[x][y]);
                    }
            }
    }
    
    return tuilesatteignables;
    
} 


    public ArrayList<Tuile> getTuilesAdjacentes2CasesNonCoulees(Tuile tuileCourante) {
        int posX = 0;
        int posY =0;
        for (int x=0; x<6;x++){
            for (int y=0;y<6;y++){
                if (tableau[x][y].getNom().equals(tuileCourante.getNom())){
                 posX=x;
                 posY=y;
                
                }
            }
        }
        
        ArrayList<Tuile> tuilesadj = new ArrayList();
        
         if(posX!=0){
            if(tableau[posX-1][posY].getNom().equals("null")==false && tableau[posX-1][posY].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX-1][posY]);}}
        
        if(posX!=5){
            if(tableau[posX+1][posY].getNom().equals("null")==false && tableau[posX+1][posY].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX+1][posY]);}}
        
        if(posY!=5){
            if(tableau[posX][posY+1].getNom().equals("null")==false && tableau[posX][posY+1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX][posY+1]);}}
        
        if(posY!=0){
            if(tableau[posX][posY-1].getNom().equals("null")==false && tableau[posX][posY-1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX][posY-1]);}}
        
         if(posX>1){
            if(tableau[posX-2][posY].getNom().equals("null")==false && tableau[posX-2][posY].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX-2][posY]);}}
        
        if(posX<4){
            if(tableau[posX+2][posY].getNom().equals("null")==false && tableau[posX+2][posY].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX+2][posY]);}}
        
        if(posY<4){
            if(tableau[posX][posY+2].getNom().equals("null")==false && tableau[posX][posY+2].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX][posY+2]);}}
        
        if(posY>1){
            if(tableau[posX][posY-2].getNom().equals("null")==false && tableau[posX][posY-2].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX][posY-2]);}}
        
        if(posX>0 && posY>0)  {
            if(tableau[posX-1][posY-1].getNom().equals("null")==false && tableau[posX-1][posY-1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX-1][posY-1]);}}
        
        if(posX<5 && posY<5 ){
            if(tableau[posX+1][posY+1].getNom().equals("null")==false && tableau[posX+1][posY+1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX+1][posY+1]);}}
        
        if(posX>0 && posY<5 ){
            if(tableau[posX-1][posY+1].getNom().equals("null")==false && tableau[posX-1][posY+1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX-1][posY+1]);}}
        
        if(posX<5 && posY>0){
            if(tableau[posX+1][posY-1].getNom().equals("null")==false && tableau[posX+1][posY-1].getEtat()!=Utils.EtatTuile.COULEE){
                tuilesadj.add(tableau[posX+1][posY-1]);}}
        
        
        return tuilesadj ;
        
    }    

    public ArrayList<Tuile> getTuilesAdjacentesPlongeur(Tuile tuileCourante) {
       
        
        ArrayList<Tuile> tuilesadj = new ArrayList();
        
        tuilesadj.addAll(this.getTuilesAdjacentesCroix(tuileCourante));
        
   
        int i = 0;
        ArrayList<Tuile> nvtuile = new ArrayList();
            
        while (i < tuilesadj.size()) {
            nvtuile.clear();
            if((tuilesadj.get(i).getEtat()==Utils.EtatTuile.COULEE || tuilesadj.get(i).getEtat()==Utils.EtatTuile.INONDEE) && !(tuilesadj.get(i).getNom().equals("null"))){
                for (Tuile t2 : this.getTuilesAdjacentesCroix(tuilesadj.get(i))){
                    if(!(tuilesadj.contains(t2) )){
                        nvtuile.add(t2);
                    }  
                }
                
            }
             i++;
             tuilesadj.addAll(nvtuile);
        }
      
        int x = 0;
        while (x < tuilesadj.size() ) {
            if(tuilesadj.get(x).getEtat()==Utils.EtatTuile.COULEE){
                 tuilesadj.remove(x);
            }
             x++;
        }
        tuilesadj.remove(tuileCourante);

        return tuilesadj ;
        
    }
    
    public ArrayList<Tuile> getTuilesAdjacentesCroix(Tuile tuileCourante) {
        int posX = 0;
        int posY =0;
        for (int x=0; x<6;x++){
            for (int y=0;y<6;y++){
                if (tableau[x][y].getNom().equals(tuileCourante.getNom())){
                 posX=x;
                 posY=y;
                
                }
            }
        }
        
        ArrayList<Tuile> tuilesadj = new ArrayList();
        
        if(posX!=0){
            if(tableau[posX-1][posY].getNom().equals("null")==false ){
                tuilesadj.add(tableau[posX-1][posY]);}}
        
        if(posX!=5){
            if(tableau[posX+1][posY].getNom().equals("null")==false ){
                tuilesadj.add(tableau[posX+1][posY]);}}
        
        if(posY!=5){
            if(tableau[posX][posY+1].getNom().equals("null")==false ){
                tuilesadj.add(tableau[posX][posY+1]);}}
        
        if(posY!=0){
            if(tableau[posX][posY-1].getNom().equals("null")==false ){
                tuilesadj.add(tableau[posX][posY-1]);}}
        
        return tuilesadj ;
        
    }
    
    public void inonderTuile(Tuile t) {
        if(t.getEtat()==Utils.EtatTuile.ASSECHEE){
            t.setEtat(Utils.EtatTuile.INONDEE);
        }else if(t.getEtat()==Utils.EtatTuile.INONDEE){
            t.setEtat(Utils.EtatTuile.COULEE);
        }
    }
    
    public ArrayList<Tuile> getTuilesInondees() {
    
    ArrayList<Tuile> tuilesatteignables = new ArrayList<>();
    
    for (int x=0; x<6;x++){
            for (int y=0;y<6;y++){
                    if ((tableau[x][y].getEtat()==Utils.EtatTuile.INONDEE) && tableau[x][y].getNom() != "null") {
                        tuilesatteignables.add(tableau[x][y]);
                    }
            }
    }
    
    return tuilesatteignables;
    
} 
    
}
