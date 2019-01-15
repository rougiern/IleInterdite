package Vues;

import ileinterditeproj.Message;
import LesJoueurs.Aventurier;
import ileinterditeproj.Utils;
import ileinterditeproj.Grille;
import ileinterditeproj.Parameters;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author IUT2-Dept Info
 */
public class VuePlateau extends Observable {

    private JFrame window;
    private JPanel mainpanel;
    private Utils.Commandes derniereaction;
    private JPanel paneljoueur;
    JPanel panelcase;
    private int nb;

    public VuePlateau(Grille g) {
        window = new JFrame("Plateau de jeu");
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(1200, 600);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        mainpanel = new JPanel(new GridLayout(6, 6));
        window.add(mainpanel);
        mainpanel.setBackground(Parameters.PLATEAU_BG);

        raffraichir(g);

    }

    public void raffraichir(Grille g) {

        mainpanel.removeAll();

          for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (!(g.getTableau()[x][y].getNom().equals("null"))) {
                    VueTuile vT = new VueTuile(g.getTableau()[x][y]);

                    JPanel panelcase = new JPanel(new BorderLayout());
                    panelcase.add(vT, BorderLayout.CENTER);
                    paneljoueur = new JPanel(new GridLayout(1, 4));
                    panelcase.add(paneljoueur, BorderLayout.SOUTH);
                    mainpanel.add(panelcase);
                    nb = g.getTableau()[x][y].getAventuriers().size();

                    JLabel labelvide = new JLabel("");
                    
                    for (int k = 1; k <= 4; k++) {
                           if (nb > 0) {
                           JPanel couleur = new JPanel();
                           couleur.setBackground(g.getTableau()[x][y].getAventuriers().get(nb-1).getPion().getCouleur());
                           paneljoueur.add(couleur);
                           nb--;
                        } else {
                            paneljoueur.add(new JPanel());
                        }

                    }

                    vT.getBouton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            setChanged();
                            notifyObservers(new Message(derniereaction, vT.getTuile()));
                            setDerniereaction(Utils.Commandes.NULL);
                            clearChanged();
                            
                        }
                    });
                } else {
                    JLabel vide = new JLabel(" ");
                    mainpanel.add(vide);
                }
            }
        }
        mainpanel.revalidate();

    }

    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }

    /**
     * @param derniereaction the derniereaction to set
     */
    public void setDerniereaction(Utils.Commandes derniereaction) {
        this.derniereaction = derniereaction;
    }

}
