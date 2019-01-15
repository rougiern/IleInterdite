/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

/**
 *
 * @author duttod
 */
public class CarteTresor extends CarteTirage{
    private Utils.Tresor type;
    
    public CarteTresor(Utils.Tresor type){
        this.type=type;
    }
    
    public Utils.Tresor getTypeTresor(){
        return type;
    }
    
    public String toString(){
        return this.getClass().getSimpleName() +":"+this.getTypeTresor().libelle;
    }

    
    
    
}
