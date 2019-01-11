package Vues;

import ileinterditeproj.Message;
import LesJoueurs.Aventurier;
import ileinterditeproj.Utils;
import ileinterditeproj.Grille;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author IUT2-Dept Info
 */
public class VuePlateau extends Observable {
    
    private JFrame window ;


public VuePlateau(Grille g){
    window = new JFrame();
    window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
    window.setSize(1500, 700);
    
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
    JPanel mainpanel = new JPanel(new GridLayout(6, 6));
    window.add(mainpanel);
    
    for (int x=0; x<6;x++){
            for (int y=0;y<6;y++){
                if (!(g.getTableau()[x][y].getNom().equals("null"))){
                    VueTuile vT = new VueTuile(g.getTableau()[x][y]);
                    mainpanel.add(vT);
                    JButton btnValider = new JButton("Valider");
        vT.getBouton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Utils.Commandes.BOUGER,vT.getTuile()));
                clearChanged();
            }
        });
                }else{
                    JLabel vide = new JLabel(" ");
                    mainpanel.add(vide);
                }
                }
            }
    window.setVisible(true);


}

}