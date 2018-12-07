/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournoimorpion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author duttod
 */
public class VueInitialisation extends Observable{
    
   
    private JFrame fenetre ;
    private JButton ajouterJ;
    private JButton supprimerJ;
    private  JTextField champnom;
    
    public VueInitialisation(ArrayList<Joueur> lesjoueurs ) {
        
        fenetre = new JFrame();
        fenetre.setSize(500, 500);
        Color couleurfond =fenetre.getBackground();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        fenetre.setLocation(dim.width/2-fenetre.getSize().width/2, dim.height/2-fenetre.getSize().height/2);
        fenetre.setBackground(Color.LIGHT_GRAY);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        JLabel titre = new JLabel("Tournoi de Morpion");
        fenetre.add(mainPanel);
        JPanel titrePanel = new JPanel();
        titrePanel.add(titre);
        
        mainPanel.add(titrePanel);
        JPanel panelcontent = new JPanel(new BorderLayout());
        
        JPanel panelJoueurs = new JPanel();
        panelcontent.add(panelJoueurs,BorderLayout.WEST);
        mainPanel.add(panelcontent);
        
        panelJoueurs.setLayout(new BoxLayout(panelJoueurs, BoxLayout.PAGE_AXIS));
  
        
        JLabel labelJ = new JLabel("Liste des joueurs");
        panelJoueurs.add(labelJ);
        
        JPanel panelListeJ = new JPanel();
        for (Joueur j : lesjoueurs){
            
            panelJoueurs.add(new JLabel(j.getNom()));
            
        }
        
        
        
        panelListeJ.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        
        
        panelJoueurs.add(panelListeJ);
        ajouterJ = new JButton("+");
        ajouterJ.setBackground(couleurfond);
        
        ajouterJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(champnom.getText());
                clearChanged();
            }
        });
        
        
        
        
        
        supprimerJ = new JButton("-");
        supprimerJ.setBackground(couleurfond);
        champnom = new JTextField("Entrez nom joueur");
        champnom.setBackground(couleurfond);
        JLabel vide = new JLabel(" ");
        
        
        JPanel panelButton = new JPanel();
        panelButton.add(ajouterJ);
        panelButton.add(supprimerJ);
        panelButton.add(champnom);
        panelButton.setAlignmentX(0);
        
        panelJoueurs.add(panelButton);
        
        
        
        JButton tutoriel = new JButton("tutoriel");
        tutoriel.setBackground(couleurfond);
        JButton reinitialiser = new JButton("Réinitialiser tournoi");
        reinitialiser.setBackground(couleurfond);
        JButton start = new JButton("Lancer tournoi");
        start.setBackground(couleurfond);
        
        
        JPanel panelButtonFonctionalite = new JPanel();
        panelButtonFonctionalite.setLayout(new BoxLayout(panelButtonFonctionalite, BoxLayout.PAGE_AXIS));
        panelButtonFonctionalite.add(new JLabel(" "));
        panelButtonFonctionalite.add(reinitialiser);
        panelButtonFonctionalite.add(new JLabel(" "));
        panelButtonFonctionalite.add(tutoriel);
        panelButtonFonctionalite.add(new JLabel(" "));
        panelButtonFonctionalite.add(start);
        
        panelcontent.add(panelButtonFonctionalite,BorderLayout.EAST);
        
    }
    
     public void afficher() {
        this.fenetre.setVisible(true);
    }
    
     
}
