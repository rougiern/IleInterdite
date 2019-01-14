package ileinterditeproj;

import LesJoueurs.Aventurier;
import ileinterditeproj.Utils.Tresor;
import java.util.ArrayList;

/**
 *
 * @author kemplail
 */
public class Tuile extends ObjetIdentifie{
    
    private String nom;
    private ArrayList<Aventurier> aventuriers;
    private Utils.EtatTuile etat ;
    private Tresor tresor=null;
    
    Tuile(String nom) {
        super();
        this.setNom(nom);
        aventuriers = new ArrayList<>();
        etat=Utils.EtatTuile.ASSECHEE;
    }
    
     Tuile(String nom, Tresor tresor) {
        super();
        this.setNom(nom);
        this.setTresor(tresor);
        aventuriers = new ArrayList<>();
        etat=Utils.EtatTuile.ASSECHEE;
    }


    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void retirerAventurierTuile(Aventurier a){
        int i =0;
         while(i<getAventuriers().size()&& !(aventuriers.get(i).getNom().equals(a.getNom()))){
                i++;
            }
            if(i!=getAventuriers().size()){
            aventuriers.remove(i);
            }
    }
    
    public void addAventurierTuile(Aventurier a){
        
        aventuriers.add(a);
    }

    /**
     * @return the aventuriers
     */
    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;
    }

    /**
     * @param aventuriers the aventuriers to set
     */
    public void setAventuriers(ArrayList<Aventurier> aventuriers) {
        this.aventuriers = aventuriers;
    }

    /**
     * @return the etat
     */
    public Utils.EtatTuile getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(Utils.EtatTuile etat) {
        this.etat = etat;
    }

    /**
     * @return the tresor
     */
    public Tresor getTresor() {
        return tresor;
    }

    /**
     * @param tresor the tresor to set
     */
    public void setTresor(Tresor tresor) {
        this.tresor = tresor;
    }
    
}
