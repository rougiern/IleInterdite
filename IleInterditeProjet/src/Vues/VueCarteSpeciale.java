/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import LesJoueurs.Aventurier;
import ileinterditeproj.Message;
import ileinterditeproj.Utils.Commandes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import ileinterditeproj.CarteTirage;
import ileinterditeproj.CarteSacDeSable;
import ileinterditeproj.CarteMonteedesEaux;
import ileinterditeproj.CarteHelicoptere;
import ileinterditeproj.CarteTresor;
import ileinterditeproj.Utils;
import java.util.ArrayList;        
/**
 *
 * @author davidpa
 */
public class VueCarteSpeciale extends Observable {
        private final JFrame window;
        private final JButton btnCartesacDesable;
        private final JButton btnCarteHelico;
        //private final
    public VueCarteSpeciale(Aventurier a){

        this.window = new JFrame();
        window.setSize(500,200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        //le titre = nom du joueur 
        window.setTitle("Vos cartes speciales");
        JPanel mainPanel = new JPanel(new GridLayout(1,2));
        window.add(mainPanel);
                int nbcarteSacDeSable = 0;
                int nbcarteHelicoptere = 0;
                if (!a.getMains().isEmpty() ){
                    for (CarteTirage carteTirage : a.getMains())
                         if (carteTirage instanceof CarteSacDeSable){
                             nbcarteSacDeSable++;
                         }

                        else if (carteTirage instanceof CarteHelicoptere){
                             nbcarteHelicoptere++;
                         }
                }
                
        btnCartesacDesable = new JButton("Carte sac de sable("+nbcarteSacDeSable+")" );
        btnCartesacDesable.setBackground(a.getPion().getCouleur());
        mainPanel.add(btnCartesacDesable);
        if(nbcarteSacDeSable ==0){
            btnCartesacDesable.setEnabled(false);
        }
        
        btnCarteHelico = new JButton("Carte Helicoptère("+nbcarteSacDeSable+")" );
        btnCarteHelico.setBackground(a.getPion().getCouleur());
        mainPanel.add(btnCarteHelico);
        if(nbcarteHelicoptere == 0){
            btnCarteHelico.setEnabled(false);
        }     
        window.setVisible(true);
    }
    
    public void actualiserPourDeplacer(ArrayList<Aventurier> joueurs){
        window.setSize(350,500);
        window.setVisible(false);
        window.removeAll();
        JPanel mainPanel = new JPanel(new GridLayout(joueurs.size(),2));
        window.add(mainPanel);
        for(Aventurier avt : joueurs ){
            mainPanel.add(new JLabel(avt.getNom()));
            mainPanel.add(new JButton("Déplacer"));
        }
        window.setVisible(true);
    }
}
