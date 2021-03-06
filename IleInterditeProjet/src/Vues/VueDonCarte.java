/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import LesJoueurs.Aventurier;
import LesJoueurs.Messager;
import ileinterditeproj.CarteHelicoptere;
import ileinterditeproj.CarteSacDeSable;
import ileinterditeproj.CarteTirage;
import ileinterditeproj.CarteTresor;
import ileinterditeproj.Message;
import ileinterditeproj.Utils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author duttod
 */
public class VueDonCarte extends Observable{
    
    private JFrame window;
    private JPanel panelmilieu, panelbas, panelhaut, mainPanel;
    private JComboBox l;
    private JComboBox joueurs;
    private JButton btndon,btnannul;
    private ArrayList<Integer> indexmains;

    public VueDonCarte(ArrayList<CarteTirage> mains ,ArrayList<Aventurier> joueurs ,Aventurier jcourant) {

        window = new JFrame("Donner une carte");
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);

        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);

        panelhaut = new JPanel();
        panelhaut.add(new JLabel("Choisir une carte à donner"));
        mainPanel.add(panelhaut, BorderLayout.NORTH);

        panelbas = new JPanel(new GridLayout(1, 3));
        btndon = new JButton("Donner");
        panelbas.add(btndon);        
        panelbas.add(new JLabel(""));
        btnannul = new JButton("Annuler");
        panelbas.add(btnannul);  
        mainPanel.add(panelbas, BorderLayout.SOUTH);

        
        panelmilieu = new JPanel(new GridLayout(5,1));

        l = new JComboBox();
        indexmains = new ArrayList();
        int i = 0;
        while(i<mains.size()){
            
            if(mains.get(i) instanceof CarteTresor){
                l.addItem(i+" - carte tresor : "+ ((CarteTresor)mains.get(i)).getTypeTresor().toString());
                indexmains.add(i);
            }
            i++;
        }
        panelmilieu.add(new JLabel(""));
        panelmilieu.add(l);
        
        
        this.joueurs = new JComboBox() ;
        
        for(Aventurier a : joueurs){
            if(jcourant instanceof Messager){
                if(!(a.getNom().equals(jcourant.getNom()))){
                    this.joueurs.addItem(a.getNom());
                }
            }else{
                if(!(a.getNom().equals(jcourant.getNom()))&&a.getTuileCourante()==jcourant.getTuileCourante()){
                    this.joueurs.addItem(a.getNom());
                }
            }
        }
        
        panelmilieu.add(new JLabel("A quel joueur voulez vous donnez la carte ?"));
        panelmilieu.add(this.joueurs);
        panelmilieu.add(new JLabel(""));
        

        btndon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Utils.Commandes.DONNER,indexmains.get(l.getSelectedIndex()),getnomJ() ));
                System.out.println(l.getSelectedItem());
                clearChanged();
            }
        });
        
        btnannul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Utils.Commandes.FERMER_DONCARTE ));
                System.out.println(l.getSelectedItem());
                clearChanged();
            }
        });
        
        
        mainPanel.add(panelmilieu, BorderLayout.CENTER);
        
        

    }
    
    public String getnomJ(){
        int a = this.joueurs.getSelectedIndex();
        return (String)this.joueurs.getItemAt(a) ;
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }
    
    public void cacher(){
        this.window.setVisible(false);
        
    }

    public void close() {
        this.window.dispose();
    }
    
}
