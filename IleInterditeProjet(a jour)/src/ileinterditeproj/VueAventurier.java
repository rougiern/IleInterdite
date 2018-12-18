package ileinterditeproj;

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
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;

 
public class VueAventurier extends Observable {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnBouger  ;
    private final JButton btnAssecher;
    private final JButton btnAutreAction;
    private final JButton btnTerminerTour;
    private JTextField position;
   
   
   
    
    public VueAventurier(Aventurier a){

        this.window = new JFrame();
        window.setSize(350, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        //le titre = nom du joueur 
        window.setTitle(a.getNom());
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);

        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(a.getPion().getCouleur(), 2)) ;

        // =================================================================================
        // NORD : le titre = nom de l'aventurier sur la couleurActive du pion

        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(a.getPion().getCouleur());
        panelAventurier.add(new JLabel(a.getClass().getSimpleName(),SwingConstants.CENTER ));
        mainPanel.add(panelAventurier, BorderLayout.NORTH);
   
        // =================================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, a.getPion().getCouleur()));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);
        
        panelCentre.add(new JLabel ("Position", SwingConstants.CENTER));
        position = new  JTextField(30);
        position.setText(a.getTuileCourante().getNom());
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);


        // =================================================================================
        // SUD : les boutons
        this.panelBoutons = new JPanel(new GridLayout(2,2));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnBouger = new JButton("Bouger") ;
        
        btnBouger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Action.DEPLACER,a.getNom()));
                clearChanged();
            }
        });
        
        
        this.btnAssecher = new JButton( "Assecher");
        
            btnAssecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Action.ASSECHER,a.getNom()));
                clearChanged();
            }
        });
        
        this.btnAutreAction = new JButton("AutreAction") ;
        
        btnAutreAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Action.BOUGERJOUEUR,a.getNom()));
                clearChanged();
            }
        });
        
        this.btnTerminerTour = new JButton("Terminer Tour") ;
        
        btnTerminerTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new Message(Action.TERMINERTOUR,a.getNom()));
                clearChanged();
            }
        });
        
        this.panelBoutons.add(btnBouger);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnAutreAction);
        this.panelBoutons.add(btnTerminerTour);

        this.window.setVisible(true);
    } 
    
    public void setPosition(String pos) {
        this.position.setText(pos);
    }
    
     public JButton getBtnAutreAction() {
        return btnAutreAction;
    }
    
    public String getPosition() {
        return position.getText();
    }

    public JButton getBtnBouger() {
        return btnBouger;
    }
    
    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    public JButton getBtnTerminerTour() {
        return btnTerminerTour;
    }
 
     public static void main(String [] args) {
        // Instanciation de la fenêtre 

    }
     
     public void close() {
         this.window.dispose();
     }
     
     public void afficher(){
         this.window.setVisible(true);
     }
     
     public void rafraichirPositon(Aventurier a){
         this.position.setText(a.getTuileCourante().getNom());
     }
     
}

 

