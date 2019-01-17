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
public class MessageIni {

    /**
     * @return the nbj
     */
    public int getNbj() {
        return nbj;
    }
    
    private Action action;
    private String[] noms;
    private int nbj;
    private String lien;
    private String difficulte ;
    
    
    public MessageIni(Action a ,String[] n){
        this.action=a;
        this.noms=n;
        
    }
    
    public MessageIni(Action a ,int n){
        this.action=a;
        this.nbj=n;
        
    }
    
    public MessageIni(Action a ,String n){
        this.action=a;
        this.lien=n;
    }
    
    public MessageIni(Action action, String[] noms, String difficulte) {
        this.action=action;
        this.noms=noms;
        this.difficulte=difficulte;
    }

    

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @return the noms
     */
    public String[] getNoms() {
        return noms;
    }

    /**
     * @return the lien
     */
    public String getLien() {
        return lien;
    }

    /**
     * @return the difficulte
     */
    public String getDifficulte() {
        return difficulte;
    }
    

    
    
    
}
