/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournoimorpion;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author duttod
 */
public class ObservateurIni implements Observer{
    private ArrayList<Joueur> listeJ ;
    
    public ObservateurIni(){
        
    VueInitialisation v = new VueInitialisation(listeJ);
    v.afficher();
    v.addObserver(this);
    
    
    }
    
    
    
    @Override
    public void update(Observable o, Object arg) {
        
        Joueur j = new Joueur((String) arg);
        listeJ.add(j);
        
    
}

}
