package Vues;

import ileinterditeproj.EtatTuile;
import ileinterditeproj.Parameters;
import ileinterditeproj.Tuile;
import ileinterditeproj.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VueTuile extends JPanel {

    private JButton bouton;
    private Tuile tuile;

    public VueTuile(Tuile t) {
        super();
        this.setLayout(new BorderLayout());
        this.tuile = t;

        bouton = new JButton();
        bouton.setVerticalTextPosition(AbstractButton.CENTER);
         this.add(bouton, BorderLayout.CENTER);
        
         if (tuile.getEtat() == Utils.EtatTuile.ASSECHEE) {
            ImageIcon icone = new ImageIcon(new ImageIcon(Parameters.TUILES + tuile.getNom() + ".png").getImage().getScaledInstance(162, 150, Image.SCALE_SMOOTH));
            bouton.setIcon(icone);

        } else if (tuile.getEtat() == Utils.EtatTuile.INONDEE) {
            ImageIcon iconeinondee = new ImageIcon(new ImageIcon(Parameters.TUILES + tuile.getNom() + "_Inonde" + ".png").getImage().getScaledInstance(162, 150, Image.SCALE_SMOOTH));
            bouton.setIcon(iconeinondee);

        } else if (tuile.getEtat() == Utils.EtatTuile.COULEE) {
            bouton.setEnabled(false);

        }

        if (tuile.getTresor() == null) {

            if (tuile.getNom().equals("LaCarverneDesOmbres") || tuile.getNom().equals("LaCarverneDuBrasier") || tuile.getNom().equals("LePalaisDeCorail") || tuile.getNom().equals("LeJardinDesHurlements") || tuile.getNom().equals("LeTempleDuSoleil") || tuile.getNom().equals("LeTempleDeLaLune") || tuile.getNom().equals("LePalaisDesMarees") || tuile.getNom().equals("LeJardinDesMurmures")) {
                if (tuile.getEtat() == Utils.EtatTuile.INONDEE) {

                    ImageIcon iconepastresor = new ImageIcon(new ImageIcon(Parameters.TUILES + tuile.getNom() + "_Inonde" + "_PasTresor" + ".png").getImage().getScaledInstance(162, 150, Image.SCALE_SMOOTH));
                    bouton.setIcon(iconepastresor);
                } else {

                    ImageIcon iconepastresor = new ImageIcon(new ImageIcon(Parameters.TUILES + tuile.getNom() + "_PasTresor" + ".png").getImage().getScaledInstance(162, 150, Image.SCALE_SMOOTH));
                    bouton.setIcon(iconepastresor);
                }
            }

        }

    }

    /**
     * @return the bouton
     */
    public JButton getBouton() {
        return bouton;
    }

    /**
     * @return the tuile
     */
    public Tuile getTuile() {
        return tuile;
    }

}
