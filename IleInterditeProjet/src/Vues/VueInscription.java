/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author kemplail
 */
public class VueInscription extends Observable {

    private JFrame window;
    private JPanel panelmilieu,panelbas,panelhaut,mainPanel;
    private JComboBox l;
    private JButton btnvalider;
    private Integer[] nb = {2,3,4};

    VueInscription() {

        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);

        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);

        panelhaut = new JPanel();
        panelhaut.add(new JLabel("~ Inscription des joueurs ~"));
        mainPanel.add(panelhaut,BorderLayout.NORTH);
        
        panelbas = new JPanel(new GridLayout(1,3));
        panelbas.add(new JLabel(""));
        btnvalider = new JButton("Valider");
        panelbas.add(btnvalider);
        panelbas.add(new JLabel(""));
        mainPanel.add(panelbas,BorderLayout.SOUTH);
        
        demarrer();
       
        
    }

    public void demarrer() {

        panelmilieu = new JPanel(new GridLayout(3,2));
        JLabel casevide = new JLabel("");

        for (int i = 1; i <= 6; i++) {

            if (i == 3) {
                JLabel demande = new JLabel("Combien de joueurs participent ?");
                panelmilieu.add(demande);
            }
            
            else if (i == 4) {
                l = new JComboBox(nb);
                panelmilieu.add(l);
            }
            else {
                panelmilieu.add(casevide);
            }
            
        }
        
        btnvalider.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(Action.NB_JOUEURS,nb[l.getSelectedIndex()]));
                        clearChanged();
                    }
                });

        mainPanel.add(panelmilieu,BorderLayout.CENTER);
        mainPanel.revalidate();
        
        
    }
    
    public void formulaire(int nbj) {
        
        String[] noms = new String[nbj];
        JTextField[] champs = new JTextField[nbj];
        
        btnvalider.removeAll();
        panelmilieu.removeAll();
        panelmilieu.setLayout(new GridLayout(nbj,2));
        int nbc = 0;
        
        for (int k = 1; k <=(nbj*2); k++) {
            
            if (k%2 != 0) {
                panelmilieu.add(new JLabel("Nom : "));
            } else {
                champs[nbc] = new JTextField();
                panelmilieu.add(champs[nbc]);
                nbc++;
            }
            
        }
        
        for (int z = 0; z < nbj; z++) {
            noms[z] = champs[z].getText();
        }
        
        panelmilieu.revalidate();
        
         btnvalider.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(Action.INSCRIRE_JOUEURS,noms));
                        clearChanged();
                    }
                });
        
         btnvalider.revalidate();
         
    }

        public void afficher() {
        this.window.setVisible(true);
    }

    void close() {
        this.window.dispose();
    }

    
}
