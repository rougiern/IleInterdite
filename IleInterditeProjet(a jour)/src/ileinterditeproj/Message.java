/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

/**
 *
 * @author Haruka
 */
public class Message {
    
    private Action action ;
    private String nomJ ;
    
    
    public Message(Action action ,String nom){
        this.action=action;
        this.nomJ=nom;
        
    }

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(Action action) {
        this.action = action;
    }

    /**
     * @return the nomJ
     */
    public String getNomJ() {
        return nomJ;
    }

    /**
     * @param nomJ the nomJ to set
     */
    public void setNomJ(String nomJ) {
        this.nomJ = nomJ;
    }
    
}
