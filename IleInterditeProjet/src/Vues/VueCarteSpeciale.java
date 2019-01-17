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
import ileinterditeproj.Parameters;
import ileinterditeproj.Utils;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author davidpa
 */
public class VueCarteSpeciale extends Observable {

    private final JFrame window;
    private JButton btnCartesacDesable;
    private JButton btnCarteHelico;
    private JPanel mainPanel;
    //private final

    public VueCarteSpeciale(Aventurier a) {

        this.window = new JFrame();
        window.setSize(450, 425);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        //le titre = nom du joueur 
        window.setTitle("Vos cartes speciales");
        JPanel panelPrincipale = new JPanel(new BorderLayout());
        
        mainPanel = new JPanel(new GridLayout(1, 2));
        window.add(panelPrincipale);
        panelPrincipale.add(mainPanel, BorderLayout.CENTER);

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
        JPanel panelhead = new JPanel(new GridLayout(1,2));
        JLabel labelcarteSac = new JLabel("Carte sac de sable(" + nbcarteSac + ")");
        panelhead.add(labelcarteSac);
        labelcarteSac.setBorder(new MatteBorder(2, 2, 2, 2,a.getPion().getCouleur()));
        
        JLabel labelcarteHelico = new JLabel("Carte Helicoptère(" + nbcarteHelico + ")");
        panelhead.add(labelcarteHelico);
        labelcarteHelico.setBorder(new MatteBorder(2, 2, 2, 2,a.getPion().getCouleur()));
        panelPrincipale.add(panelhead, BorderLayout.NORTH);
                
                
                
                
                
        btnCartesacDesable = new JButton("");
        
        ImageIcon icone = new ImageIcon(new ImageIcon(Parameters.CARTES + "SacsDeSable.png").getImage().getScaledInstance(200, 350, Image.SCALE_DEFAULT));
        btnCartesacDesable.setIcon(icone);
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

        btnCarteHelico = new JButton("");
        ImageIcon icone1 = new ImageIcon(new ImageIcon(Parameters.CARTES + "Helicoptere.png").getImage().getScaledInstance(200, 350, Image.SCALE_DEFAULT));
        btnCarteHelico.setBackground(a.getPion().getCouleur());
        btnCarteHelico.setIcon(icone1);
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

            JPanel panelaventurier = new JPanel(new GridLayout(1,2));
            panelaventurier.setBackground(avt.getPion().getCouleur());
            panelaventurier.add(new JLabel(avt.getNom(), SwingConstants.CENTER));
            panelaventurier.add(boutondeplacer);
            mainPanel.add(panelaventurier);

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

    public void actualiserPourDeplacerNav(ArrayList<Aventurier> joueurs, Aventurier a) {

        mainPanel.removeAll();
        window.setTitle("Déplacement aventurier");
        mainPanel.setLayout(new GridLayout(joueurs.size()-1, 2));
        JButton boutondeplacer;
        JPanel panelaventurier;
        for (Aventurier avt : joueurs) {
            if (!(avt.getNom().equals(a.getNom()))) {
                boutondeplacer = new JButton("Déplacer");

                panelaventurier = new JPanel(new GridLayout(1,2));
                panelaventurier.setBackground(avt.getPion().getCouleur());
                panelaventurier.add(new JLabel(avt.getNom(), SwingConstants.CENTER));
                panelaventurier.add(boutondeplacer);
                mainPanel.add(panelaventurier);
                boutondeplacer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(Utils.Commandes.DEMANDE_DEPLACER, avt.getNom()));
                        clearChanged();
                    }
                });
            }
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