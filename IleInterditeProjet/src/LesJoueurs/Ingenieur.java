/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LesJoueurs;

import LesJoueurs.Aventurier;
import ileinterditeproj.EtatTuile;
import ileinterditeproj.Utils.Pion;
import ileinterditeproj.Tuile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kemplail
 */
public class Ingenieur extends Aventurier {
    
    private int nbAsseche = 1;
    
    public Ingenieur(String nom, Tuile tuiledé) {
        super(nom, tuiledé);
        this.setPion(Pion.ROUGE);
    }
        
    public void assechertuile2efois(Tuile t) {
        t.setEtat(ileinterditeproj.Utils.EtatTuile.ASSECHEE);
    }

    /**
     * @return the nbAsseche
     */
    public int getNbAsseche() {
        return nbAsseche;
    }

    /**
     * @param nbAsseche the nbAsseche to set
     */
    public void setNbAsseche(int nbAsseche) {
        this.nbAsseche = nbAsseche;
    }
    
    
}