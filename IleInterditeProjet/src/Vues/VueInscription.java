package Vues;

import ileinterditeproj.Action;
import ileinterditeproj.Message;
import ileinterditeproj.MessageIni;
import ileinterditeproj.Parameters;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
    private JPanel panelmilieu, panelbas, panelhaut, mainPanel;
    private JComboBox l;
    private JButton btnvalider;
    private Integer[] nb = {2, 3, 4};

    public VueInscription() {

        window = new JFrame("Inscriptions des joueurs");
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        window.setBackground(Color.ORANGE);
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        window.add(mainPanel);
        
        panelhaut = new JPanel();
        
        panelhaut.add(new JLabel("~ Inscription des joueurs ~"));
        panelhaut.setBackground(Color.ORANGE);
        panelhaut.setOpaque(true);
        mainPanel.add(panelhaut, BorderLayout.NORTH);

        panelbas = new JPanel(new GridLayout(1, 3));
        panelbas.add(new JLabel(""));
        panelbas.setOpaque(false);
        btnvalider = new JButton("Valider");
        panelbas.add(btnvalider);
            BufferedImage master;            
            try {
            master = ImageIO.read(new File(Parameters.ICONS +"iconDoneOrange.jpg"));
            Image scaled = master.getScaledInstance(28, 28, java.awt.Image.SCALE_SMOOTH);
            btnvalider.setIcon(new ImageIcon(scaled));
            btnvalider.setBackground(Color.WHITE);
            } catch (IOException ex) {
            System.out.println("Erreur de lecture de de l'image");
            }

        panelbas.add(new JLabel(""));
        panelbas.setBackground(Color.ORANGE);
        panelbas.setOpaque(true);
        mainPanel.add(panelbas, BorderLayout.SOUTH);

        demarrer();

    }

    public void demarrer() {

        panelmilieu = new JPanel(new GridLayout(3, 2));
        JLabel casevide = new JLabel("");
        casevide.setOpaque(true);
        casevide.setBackground(Color.ORANGE);
        for (int i = 1; i <= 6; i++) {

            if (i == 3) {
                JLabel demande = new JLabel("Combien de joueurs participent ?", SwingConstants.CENTER);
                demande.setOpaque(true);
                demande.setBackground(Color.ORANGE);
                panelmilieu.add(demande);
            } else if (i == 4) {
                l = new JComboBox(nb);
                panelmilieu.add(l);
                l.setBackground(Color.ORANGE);
            } else {
                panelmilieu.add(casevide);
            }

        }

        btnvalider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new MessageIni(Action.NB_JOUEURS, nb[l.getSelectedIndex()]));
                clearChanged();
            }
        });

        mainPanel.add(panelmilieu, BorderLayout.CENTER);
        mainPanel.revalidate();

    }

    public void formulaire(int nbj) {

        String[] noms = new String[nbj];
        JTextField[] champs = new JTextField[nbj];

        btnvalider.removeAll();
        panelmilieu.removeAll();
        panelmilieu.setLayout(new GridLayout(nbj, 2));
        int nbc = 0;

        for (int k = 1; k <= (nbj * 2); k++) {

            if (k % 2 != 0) {
                JLabel name = new JLabel("Nom : ", SwingConstants.CENTER);
                name.setBackground(Color.ORANGE);
                name.setOpaque(true);
                panelmilieu.add(name);
            } else {
                champs[nbc] = new JTextField();
                champs[nbc].setBackground(Color.yellow);
                panelmilieu.add(champs[nbc]);
                nbc++;
            }

        }

        

        panelmilieu.revalidate();

        panelbas.removeAll();
        panelbas = new JPanel(new GridLayout(1, 3));
        panelbas.add(new JLabel(""));
        panelbas.setOpaque(false);
        btnvalider = new JButton("Inscrire");
            BufferedImage master1;            
            try {
            master1 = ImageIO.read(new File(Parameters.ICONS +"plume-orange.png"));
            Image scaled1 = master1.getScaledInstance(28, 28, java.awt.Image.SCALE_SMOOTH);
            btnvalider.setIcon(new ImageIcon(scaled1));
            btnvalider.setBackground(Color.WHITE);
            } catch (IOException ex) {
            System.out.println("Erreur de lecture de de l'image");
            }
        panelbas.add(btnvalider);
        panelbas.add(new JLabel(""));
        panelbas.setBackground(Color.ORANGE);
        panelbas.setOpaque(true);
        mainPanel.add(panelbas, BorderLayout.SOUTH);
        btnvalider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                for (int z = 0; z < nbj; z++) {
                noms[z] = champs[z].getText();
                }
                notifyObservers(new MessageIni(Action.INSCRIRE_JOUEURS, noms));
                clearChanged();
            }
        });

        btnvalider.revalidate();

        
        
    }

    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }

}
