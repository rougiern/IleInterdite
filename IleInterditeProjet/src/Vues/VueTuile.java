package Vues;
 
import ileinterditeproj.EtatTuile;
import ileinterditeproj.Tuile;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VueTuile extends JPanel {
    
    private JButton bouton ;
    private Tuile tuile ;
    
    public VueTuile(Tuile t){
        super();
        this.tuile=t;
        bouton = new JButton(tuile.getNom());
        this.add(bouton);
        if(tuile.getEtat()==EtatTuile.Normal){
            bouton.setBackground(Color.LIGHT_GRAY);
        }else if(tuile.getEtat()==EtatTuile.Inondee){
            bouton.setBackground(Color.cyan);
        }else if(tuile.getEtat()==EtatTuile.Coulee){
           
        }
        
    }
    
}