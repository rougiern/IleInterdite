package Vues;

import ileinterditeproj.Message;
import LesJoueurs.Aventurier;
import ileinterditeproj.Utils;
import ileinterditeproj.Grille;
import ileinterditeproj.Parameters;
import ileinterditeproj.Utils.Commandes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author IUT2-Dept Info
 */
public class VuePlateau extends Observable {

    private JFrame window;
    private JPanel panelgrille;
    private Utils.Commandes derniereaction;
    private JPanel paneljoueur;
    JPanel panelcase;
    private int nb;
    private JPanel paneljoueurgauche;
     private JPanel paneljoueurdroite;
//    private JPanel paneljoueurdroite;
    private JPanel mainpanel ;
    private JPanel panelplateau;
    private VueNiveau vueniveau;
    
    private VueAventurier vuej1;
    private VueAventurier vuej2;
    private VueAventurier vuej3;
    private VueAventurier vuej4;

    public VuePlateau(Grille g,ArrayList<Aventurier> av) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        window = new JFrame("Plateau de jeu");
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(dim);
        
        vueniveau = new VueNiveau(1);

        
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        panelgrille = new JPanel(new GridBagLayout());
        mainpanel=new JPanel(new BorderLayout());
        
        paneljoueurgauche=new JPanel(new GridBagLayout());
        paneljoueurdroite = new JPanel(new GridBagLayout());
        
        panelplateau=new JPanel(new BorderLayout());
        mainpanel.add(paneljoueurdroite,BorderLayout.WEST);
        mainpanel.add(paneljoueurgauche,BorderLayout.EAST);
        panelplateau.add(panelgrille,BorderLayout.CENTER);

        
        mainpanel.add(panelplateau,BorderLayout.CENTER);
        window.add(mainpanel);
        panelgrille.setBackground(Parameters.PLATEAU_BG);
        vueniveau.setBackground(Parameters.PLATEAU_BG);
         paneljoueurdroite.setBackground(Parameters.PLATEAU_BG);
        paneljoueurgauche.setBackground(Parameters.PLATEAU_BG);
        
        
        raffraichir(g,av);
        
    }

    public void raffraichir(Grille g,ArrayList<Aventurier> av) {
        
        
        paneljoueurgauche.removeAll();
        paneljoueurdroite.removeAll();
        panelgrille.removeAll();
        
        if(av.isEmpty()==false){

            GridBagConstraints constraints = new GridBagConstraints();
             constraints.gridheight = 1;
             constraints.gridwidth = 1;

             constraints.gridx = 0;
             constraints.gridy = 0;
            vuej1=new VueAventurier(av.get(0));
            setBouton(getVuej1(),av.get(0));
            paneljoueurgauche.add(getVuej1(), constraints);
             
            
            constraints.gridx = 0;
             constraints.gridy = -1;
            vuej2=new VueAventurier(av.get(1));
            setBouton(getVuej2(),av.get(1));        
            paneljoueurgauche.add(getVuej2(), constraints);


            if(av.size()>2){

                constraints.gridx = 0;
             constraints.gridy = 0;
                vuej3=new VueAventurier(av.get(2));
                setBouton(getVuej3(),av.get(2));
                paneljoueurdroite.add(getVuej3(),constraints);
                
               
            }else{
                vuej3=null;
                paneljoueurdroite.add(new JLabel(" ")); 
                
            }
            
             if(av.size()>3){

                    constraints.gridx = 0;
                     constraints.gridy = -1;
                    vuej4=new VueAventurier(av.get(3));
                    setBouton(getVuej4(),av.get(3));
                    paneljoueurdroite.add(getVuej4(),constraints);                
                }else{
                    vuej4=null;
                    paneljoueurdroite.add(new JLabel(" ")); 
                }
            
            this.griserAction();
        }

          for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (!(g.getTableau()[x][y].getNom().equals("null"))) {
                    VueTuile vT = new VueTuile(g.getTableau()[x][y]);
                    
                    JPanel panelcase = new JPanel(new BorderLayout());
                    panelcase.setPreferredSize(new Dimension(162, 150));
                    panelcase.add(vT, BorderLayout.CENTER);
                    
                    paneljoueur = new JPanel(new GridLayout(1, 4));
                    panelcase.add(paneljoueur, BorderLayout.SOUTH);
                    
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = x;
                    gbc.gridy = y;
                    gbc.gridheight = 1;
                    gbc.gridwidth = 1;
                    panelgrille.add(panelcase,gbc);
                    
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
                            notifyObservers(new Message(getDerniereaction(), vT.getTuile()));
                            clearChanged();
                        }
                    });
                } else {
                    JLabel vide = new JLabel(" ");
                    panelgrille.add(vide);
                }
            }
        }
        panelgrille.revalidate();
        paneljoueurgauche.revalidate();
        paneljoueurdroite.revalidate();

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
    
    private void setBouton(VueAventurier vAv, Aventurier av){
        
        vAv.getBtnBouger().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Commandes.DEMANDE_BOUGER,av.getNom()));
                clearChanged();
            }
        });
        
        vAv.getBtnAssecher().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Commandes.DEMANDE_ASSECHER,av.getNom()));
                clearChanged();
            }
        });
        
        
        vAv.getBtnAutreAction().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Commandes.DONNER,av.getNom()));             
                clearChanged();
            }
        });
        
        vAv.getBtnTerminerTour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Commandes.TERMINER,av.getNom()));
                clearChanged();
            }
            
        });
        
        vAv.getBtnRecupererTresor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Commandes.RECUPERER_TRESOR,av.getNom()));
                clearChanged();
            }
            
        });
        
        vAv.getBtnUtiliserCarte().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Commandes.CHOISIR_CARTE,av.getNom()));
                clearChanged();
            }
            
        });
        
        if(vAv.getBtnDeplacerJoueur()!=null){
            vAv.getBtnDeplacerJoueur().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new Message(Commandes.DEMANDE_DEPLACER,av.getNom()));
                    clearChanged();
                }

            });
        }
        
        
    }

    /**
     * @return the vuej1
     */
    public VueAventurier getVuej1() {
        return vuej1;
    }

    /**
     * @return the vuej2
     */
    public VueAventurier getVuej2() {
        return vuej2;
    }

    /**
     * @return the vuej3
     */
    public VueAventurier getVuej3() {
        return vuej3;
    }

    /**
     * @return the vuej4
     */
    public VueAventurier getVuej4() {
        return vuej4;
    }
    
    public void griserAction(){
        vuej1.griserActions();
        vuej2.griserActions();
        if (vuej3!=null){
            vuej3.griserActions();
            if (vuej4!=null){
                vuej4.griserActions();
            }
        }
        
        
    }

    /**
     * @return the vueniveau
     */
    public VueNiveau getVueniveau() {
        return vueniveau;
    }

    /**
     * @return the derniereaction
     */
    public Utils.Commandes getDerniereaction() {
        return derniereaction;
    }

}