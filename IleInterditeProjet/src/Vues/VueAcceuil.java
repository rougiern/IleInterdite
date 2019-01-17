/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import ileinterditeproj.Action;
import ileinterditeproj.Message;
import ileinterditeproj.MessageIni;
import ileinterditeproj.Parameters;
import ileinterditeproj.Utils;
import ileinterditeproj.Utils.Commandes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author davidpa
 */
public class VueAcceuil  extends Observable {
    private JFrame window;
    private JPanel panelmilieu, panelbas, panelhaut; 
    private PanelImage mainPanel;
    private JButton btnjouer,btntuto;
    private Image image;

    
    public VueAcceuil()  {
        
        try {
            this.image = ImageIO.read(new File(Parameters.ICONS +"ileinterdite_slider-template-mobile.png"));
        } catch (IOException ex) {
            System.err.println("Erreur de lecture de de l'image");
        }
        window = new JFrame("L' île interdite");
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(625, 315);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);

        mainPanel = new PanelImage(600,300,image);
        mainPanel.setLayout(new GridLayout(7,5));
        for(int i=0;i<=34;i++){
            if((i!=30) && (i!=34)){
              JLabel label = new JLabel(" ");
              label.setOpaque(false);
              mainPanel.add(label);
            }
            else if (i == 30){
                btnjouer = new JButton("JOUER");               
                btnjouer.setBackground(Color.white);
                btnjouer.setBorder(new MatteBorder(2, 2, 2, 2,Color.ORANGE));
                mainPanel.add(btnjouer);
            BufferedImage master;            
            try {
            master = ImageIO.read(new File(Parameters.ICONS +"iconPlay.png"));
/*          // A utiliser si l'image doit être dimensionnée comme un bouton de taille prédéfinie
            Dimension size = button.getSize();
            Insets insets = button.getInsets();
            size.width -= insets.left + insets.right;
            size.height -= insets.top + insets.bottom;
            if (size.width > size.height) {
                size.width = -1;
            } else {
                size.height = -1;
            } */

            // On impose une taille de 18px * 18px à l'image
            Image scaled = master.getScaledInstance(28, 28, java.awt.Image.SCALE_SMOOTH);
            btnjouer.setIcon(new ImageIcon(scaled));
            } catch (IOException ex) {
            System.out.println("Erreur de lecture de de l'image");
            }      
            btnjouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new MessageIni(Action.COMMENCER_PARTIE,"COMMENCER_PARTIE"));
                clearChanged();
            }
        });    
            }
            else {
                btntuto = new JButton("REGLES");               
                btntuto.setBackground(Color.WHITE);
                btntuto.setBorder(new MatteBorder(2, 2, 2, 2,Color.ORANGE));
                mainPanel.add(btntuto);
            BufferedImage master1;            
            try {
            master1 = ImageIO.read(new File(Parameters.ICONS +"iconRules.png"));
/*          // A utiliser si l'image doit être dimensionnée comme un bouton de taille prédéfinie
            Dimension size = button.getSize();
            Insets insets = button.getInsets();
            size.width -= insets.left + insets.right;
            size.height -= insets.top + insets.bottom;
            if (size.width > size.height) {
                size.width = -1;
            } else {
                size.height = -1;
            } */

            // On impose une taille de 18px * 18px à l'image
            Image scaled1 = master1.getScaledInstance(28, 28, java.awt.Image.SCALE_SMOOTH);
            btntuto.setIcon(new ImageIcon(scaled1));
            } catch (IOException ex) {
            System.out.println("Erreur de lecture de de l'image");
            } 
            btntuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new MessageIni(Action.OUVRIR_PAGEWEB,"http://regle.jeuxsoc.fr/ilint_rg.pdf"));
                clearChanged();
            }
        }); 
            }
            

               

    
        mainPanel.repaint();
        window.add(mainPanel);
        window.setVisible(true);
        window.setIconImage(image);
          
        }
    }  
    
        public void afficher() {
        this.window.setVisible(true);
    }
        
            public void close() {
        this.window.dispose();
    }
    
    
 
         

}
