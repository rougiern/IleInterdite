package Vues;
 
import ileinterditeproj.EtatTuile;
import ileinterditeproj.Parameters;
import ileinterditeproj.Tuile;
import ileinterditeproj.Utils;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VueTuile extends JPanel {
    
    private JButton bouton ;
    private Tuile tuile ;
    
    public VueTuile(Tuile t){
        super(new BorderLayout());
        this.tuile=t;
        bouton = new JButton(getTuile().getNom());
        this.add(bouton,BorderLayout.CENTER);
        if(tuile.getEtat()==Utils.EtatTuile.ASSECHEE){
            bouton.setBackground(Parameters.TUILE_ASSECHEE_BG);
        }else if(tuile.getEtat()==Utils.EtatTuile.INONDEE){
            bouton.setBackground(Parameters.TUILE_INONDEE_BG);
        }else if(tuile.getEtat()==Utils.EtatTuile.COULEE){
           
        }
        
    }

    /**
     * @return the bouton
     */
    public JButton getBouton() {
        return bouton;
    }

    /**
     * @return the tuile
     */
    public Tuile getTuile() {
        return tuile;
    }
    
}