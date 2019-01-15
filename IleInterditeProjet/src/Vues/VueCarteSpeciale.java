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
    private JPanel mainPanel;
    //private final

    public VueCarteSpeciale(Aventurier a) {

        this.window = new JFrame();
        window.setSize(500, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        //le titre = nom du joueur 
        window.setTitle("Vos cartes speciales");
        mainPanel = new JPanel(new GridLayout(1, 2));
        window.add(mainPanel);
        
        int nbcarteSac = 0;
        int nbcarteHelico = 0;
        
        if (!a.getMains().isEmpty()) {
            for (CarteTirage carteTirage : a.getMains()) {
                if (carteTirage instanceof CarteSacDeSable) {
                    nbcarteSac++;
                } else if (carteTirage instanceof CarteHelicoptere) {
                    nbcarteHelico++;
                }
            }
        }

        btnCartesacDesable = new JButton("Carte sac de sable(" + nbcarteSac + ")");
        btnCartesacDesable.setBackground(a.getPion().getCouleur());
        mainPanel.add(btnCartesacDesable);
        if (nbcarteSac == 0) {
            btnCartesacDesable.setEnabled(false);
        }
        btnCartesacDesable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Commandes.UTILISER_CARTE_SACSABLE, a.getNom()));
                clearChanged();
            }
        });

        btnCarteHelico = new JButton("Carte Helicoptère(" + nbcarteHelico + ")");
        btnCarteHelico.setBackground(a.getPion().getCouleur());
        mainPanel.add(btnCarteHelico);
        if (nbcarteHelico == 0) {
            btnCarteHelico.setEnabled(false);
        }
        btnCarteHelico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Utils.Commandes.UTILISER_CARTE_HELICO, a.getNom()));
                clearChanged();
            }
        });

        window.setVisible(true);
    }

    public void actualiserPourDeplacer(ArrayList<Aventurier> joueurs) {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(joueurs.size(), 2));
        JButton boutondeplacer;
        for (Aventurier avt : joueurs) {
            boutondeplacer = new JButton("Déplacer");
            
            mainPanel.add(new JLabel(avt.getNom(), SwingConstants.CENTER));
            mainPanel.add(boutondeplacer);
            
            boutondeplacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Utils.Commandes.BOUGER_AVEC_HELICO, avt.getNom()));
                clearChanged();
            }
        });
        }
        mainPanel.revalidate();
    }

    public void close() {
        this.window.dispose();
    }

    public void afficher() {
        this.window.setVisible(true);
    }

}
