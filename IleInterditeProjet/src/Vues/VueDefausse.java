/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

/**
 *
 * @author bernaelo
 */
import ileinterditeproj.Action;
import ileinterditeproj.Message;
import LesJoueurs.Aventurier;
import ileinterditeproj.CarteHelicoptere;
import ileinterditeproj.CarteSacDeSable;
import ileinterditeproj.CarteTirage;
import ileinterditeproj.CarteTresor;
import ileinterditeproj.Utils.Commandes;
import ileinterditeproj.Utils.Tresor;
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
public class VueDefausse extends Observable {

    private JFrame window;
    private JPanel panelmilieu, panelbas, panelhaut, mainPanel;
    private JComboBox l;
    private JButton btndefausse;

    public VueDefausse(ArrayList<CarteTirage> mains) {

        window = new JFrame("Inscriptions des joueurs");
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);

        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);

        panelhaut = new JPanel();
        panelhaut.add(new JLabel("choisir une carte à défausser"));
        mainPanel.add(panelhaut, BorderLayout.NORTH);

        panelbas = new JPanel(new GridLayout(1, 3));
        panelbas.add(new JLabel(""));
        btndefausse = new JButton("Défausser");
        panelbas.add(btndefausse);
        panelbas.add(new JLabel(""));
        mainPanel.add(panelbas, BorderLayout.SOUTH);

        
        panelmilieu = new JPanel(new GridLayout(3,1));

        l = new JComboBox();
        
        int i = 1;
        
        for(CarteTirage c : mains){
            if(c instanceof CarteHelicoptere){
                l.addItem(i+" - carte helicoptere");
            }else if(c instanceof CarteSacDeSable){
                l.addItem(i+" - carte sac de sable");
            }else if(c instanceof CarteTresor){
                l.addItem(i+" - carte tresor : "+ ((CarteTresor) c ).getTypeTresor().toString());
            }
            i++;
        }
        panelmilieu.add(new JLabel(""));
        panelmilieu.add(l);
        panelmilieu.add(new JLabel(""));

        btndefausse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Commandes.DEFAUSSE,l.getSelectedIndex() ));
                clearChanged();
            }
        });

        mainPanel.add(panelmilieu, BorderLayout.CENTER);
        
        

    }

    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }
    
    public static void main(String[] args) {
        
        ArrayList<CarteTirage> main=new ArrayList();
        CarteHelicoptere carte1=new CarteHelicoptere();
        CarteSacDeSable carte2=new CarteSacDeSable();
        CarteTresor carte3=new CarteTresor(Tresor.CALICE);
        CarteTresor carte4=new CarteTresor(Tresor.ZEPHYR);
        CarteHelicoptere carte5=new CarteHelicoptere();
        CarteTresor carte6=new CarteTresor(Tresor.CRISTAL);
        CarteSacDeSable carte7=new CarteSacDeSable();
      
        main.add(carte1);
        main.add(carte2);
        main.add(carte3);
        main.add(carte4);
        main.add(carte5);
        main.add(carte6);
        main.add(carte7);
        
        VueDefausse vued = new VueDefausse(main);
        vued.afficher();
                
    }

}
