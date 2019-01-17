package Vues;


import LesJoueurs.Aventurier;
import LesJoueurs.Messager;
import LesJoueurs.Navigateur;
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
import ileinterditeproj.Parameters;
import ileinterditeproj.Utils;
import java.util.ArrayList;
 
public class VueAventurier extends JPanel {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
//    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JPanel panelHeader;
    private final JPanel panelFooter;
    private final JButton btnBouger  ;
    private final JButton btnAssecher;
    private final JButton btnAutreAction;
    private final JButton btnRecupererTresor;
    private final JButton btnUtiliserCarte;
    private final JButton btnTerminerTour;
    private JTextField position;
    private final JButton btnDeplacerJoueur;
   
   
    
    public VueAventurier(Aventurier a){

//        this.window = new JFrame();
//       window.setSize(350, 500);
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
//        //le titre = nom du joueur 
//        window.setTitle(a.getNom());

        
        
        panelHeader = new JPanel(new GridLayout(2,1));
        mainPanel = new JPanel(new BorderLayout());
                
        panelHeader.add(mainPanel);
        

        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(a.getPion().getCouleur(), 2)) ;

        // =================================================================================
        // =Première partie de la fenêtre                                                  =
        // =Affichage du  nom de l'aventurier, sa position et les 6 boutons d'actions      =
        // =================================================================================
        
        
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
        
        panelCentre.add(new JLabel (a.getNom(), SwingConstants.CENTER));
        position = new  JTextField(30);
        position.setText(a.getTuileCourante().getNom());
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);


        // =================================================================================
        // SUD : les boutons
        if (!(a instanceof Navigateur)) {
                this.panelBoutons = new JPanel(new GridLayout(3,2)); } else {
                 this.panelBoutons = new JPanel(new GridLayout(4,2));
        }
        
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnBouger = new JButton("Bouger") ;
        
//        btnBouger.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setChanged();
//                notifyObservers(new Message(Commandes.BOUGER,a.getNom()));
//                clearChanged();
//            }
//        });
        
        
        this.btnAssecher = new JButton( "Assecher");
        
//            btnAssecher.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setChanged();
//                notifyObservers(new Message(Commandes.ASSECHER,a.getNom()));
//                clearChanged();
//            }
//        });
        
        this.btnAutreAction = new JButton("Donner carte") ;
        
        
//        btnAutreAction.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setChanged();
//                notifyObservers(new Message(Commandes.DONNER,a.getNom()));             
//                clearChanged();
//            }
//        });
        
        this.btnTerminerTour = new JButton("Terminer Tour") ;
        
//        btnTerminerTour.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setChanged();
//                notifyObservers(new Message(Commandes.TERMINER,a.getNom()));
//                clearChanged();
//            }
//            
//        });
        
        this.btnRecupererTresor = new JButton("Récuperer un trésor") ;
        
//        btnRecupererTresor.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setChanged();
//                notifyObservers(new Message(Commandes.RECUPERER_TRESOR,a.getNom()));
//                clearChanged();
//            }
//            
//        });
        
        this.btnUtiliserCarte = new JButton("Utiliser une carte spéciale") ;
        
//        btnUtiliserCarte.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setChanged();
//                notifyObservers(new Message(Commandes.CHOISIR_CARTE,a.getNom()));
//                clearChanged();
//            }
//            
//        });

               

        this.panelBoutons.add(btnBouger);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnAutreAction);
        this.panelBoutons.add(btnTerminerTour);
        this.panelBoutons.add(btnRecupererTresor);
        this.panelBoutons.add(btnUtiliserCarte);
        
        if(a instanceof Navigateur){
            this.btnDeplacerJoueur = new JButton("Déplacer un Joueur") ;
        
//        btnDeplacerJoueur.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setChanged();
//                notifyObservers(new Message(Commandes.DEPLACER,a.getNom()));
//                clearChanged();
//            }
//            
//        });
            this.panelBoutons.add(btnDeplacerJoueur);
            this.panelBoutons.add(new JLabel(""));
        }else{
            this.btnDeplacerJoueur=null;
        }
        
 
        // =================================================================================
        // =Deuxième partie de la fenêtre                                                  =
        // =Affichage des cartes en mains                                                  =
        // =================================================================================
        
        int taille = a.getMains().size();
        int nbcarteSacDeSable = 0;
        int nbcarteHelicoptere = 0;
        int nbcarteTresor = 0;
        int nbcarteTresorPierre = 0;
        int nbcarteTresorZephyr = 0;
        int nbcarteTresorCrystal = 0;
        int nbcarteTresorCalice = 0;
        ArrayList<CarteTresor> les_tresors = new ArrayList<>();

        this.panelFooter = new JPanel(new GridLayout(4,1));
        panelFooter.setBorder(BorderFactory.createLineBorder(a.getPion().getCouleur(), 2)) ;
        if (a.getMains().size() != 0 ){
            for (CarteTirage carteTirage : a.getMains())
                if (carteTirage instanceof CarteSacDeSable){
                    nbcarteSacDeSable++;
                }

                else if (carteTirage instanceof CarteHelicoptere){
                    nbcarteHelicoptere++;
                }
                else if (carteTirage instanceof CarteTresor){
                    nbcarteTresor++;
                    les_tresors.add((CarteTresor) carteTirage);
                }    
                if (les_tresors.size() !=0){
                    for (CarteTresor carteTresor :les_tresors){
                        if (carteTresor.getTypeTresor() == Utils.Tresor.PIERRE){
                            nbcarteTresorPierre++;
                        }
                        else if (carteTresor.getTypeTresor() == Utils.Tresor.ZEPHYR){
                            nbcarteTresorZephyr++;
                        }
                        else if (carteTresor.getTypeTresor() == Utils.Tresor.CRISTAL){
                            nbcarteTresorCrystal++;
                        }
                        else if (carteTresor.getTypeTresor() == Utils.Tresor.CALICE){
                            nbcarteTresorCalice++;
                        }
                    
                   }
                }
        }
            
            panelFooter.add(new JLabel("Carte Sac De Sable ("+nbcarteSacDeSable+")"));
            panelFooter.add(new JLabel("Carte Hélicoptère ("+nbcarteHelicoptere+")"));
            panelFooter.add(new JLabel("Carte Tresor ("+nbcarteTresor+")"));
            
            String[] tresorList = { "Carte Tresor : La Pierre Sacrée (" + nbcarteTresorPierre+")",
                "Carte Tresor : La statue du Zéphyr (" + nbcarteTresorZephyr+")",
                "Carte Tresor : Le Cristal Ardent (" + nbcarteTresorCrystal+")",
                "Carte Tresor : Le Calice de l'Onde (" + nbcarteTresorCalice+")",
            };
            JComboBox listeTresor = new JComboBox(tresorList);
            listeTresor.setBackground(a.getPion().getCouleur());
            
            
            panelFooter.add(listeTresor);
            
            panelHeader.add(panelFooter);
            
            this.setLayout(new BorderLayout());
            
            this.add(panelHeader, BorderLayout.CENTER);
            this.add(new JLabel(" "), BorderLayout.EAST);
            this.add(new JLabel(" "), BorderLayout.WEST);
            this.setBackground(Parameters.PLATEAU_BG);
        
//            this.window.setVisible(true);
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
     
//     public void close() {
//         this.window.dispose();
//     }
//     
//     public void afficher(){
//         this.window.setVisible(true);
//     }
     
     public void rafraichirPositon(Aventurier a){
         this.position.setText(a.getTuileCourante().getNom());
     }
     
     public void rafraichirMains(Aventurier a){
//        this.window.setVisible(false);
        this.panelFooter.removeAll();
        int nbcarteSacDeSable = 0;
        int nbcarteHelicoptere = 0;
        int nbcarteTresor = 0;
        int nbcarteTresorPierre = 0;
        int nbcarteTresorZephyr = 0;
        int nbcarteTresorCrystal = 0;
        int nbcarteTresorCalice = 0;
        ArrayList<CarteTresor> les_tresors = new ArrayList<>();
        panelFooter.setBorder(BorderFactory.createLineBorder(a.getPion().getCouleur(), 2)) ;
        if (!a.getMains().isEmpty()){
            for (CarteTirage carteTirage : a.getMains())
                if (carteTirage instanceof CarteSacDeSable){
                    nbcarteSacDeSable++;
                }

                else if (carteTirage instanceof CarteHelicoptere){
                    nbcarteHelicoptere++;
                }
                else if (carteTirage instanceof CarteTresor){
                    nbcarteTresor++;
                    les_tresors.add((CarteTresor) carteTirage);
                }    
                if (!les_tresors.isEmpty()){
                    for (CarteTresor carteTresor :les_tresors){
                        if (carteTresor.getTypeTresor() == Utils.Tresor.PIERRE){
                            nbcarteTresorPierre++;
                        }
                        else if (carteTresor.getTypeTresor() == Utils.Tresor.ZEPHYR){
                            nbcarteTresorZephyr++;
                        }
                        else if (carteTresor.getTypeTresor() == Utils.Tresor.CRISTAL){
                            nbcarteTresorCrystal++;
                        }
                        else if (carteTresor.getTypeTresor() == Utils.Tresor.CALICE){
                            nbcarteTresorCalice++;
                        }
                    
                    }
                }
        }
            panelFooter.add(new JLabel("Carte Sac De Sable ("+nbcarteSacDeSable+")"));
            panelFooter.add(new JLabel("Carte Hélicoptère ("+nbcarteHelicoptere+")"));
            panelFooter.add(new JLabel("Carte Tresor ("+nbcarteTresor+")  "));
            
            String[] tresorList = { "Carte Tresor : La Pierre Sacrée (" + nbcarteTresorPierre+")",
                "Carte Tresor : La statue du Zéphyr (" + nbcarteTresorZephyr+")",
                "Carte Tresor : Le Cristal Ardent (" + nbcarteTresorCrystal+")",
                "Carte Tresor : Le Calice de l'Onde (" + nbcarteTresorCalice+")",
            };
            JComboBox listeTresor = new JComboBox(tresorList);
            listeTresor.setBackground(a.getPion().getCouleur());
            
            
            panelFooter.add(listeTresor);
//            this.window.setVisible(true);
     }

    /**
     * @return the btnRecupererTresor
     */
    public JButton getBtnRecupererTresor() {
        return btnRecupererTresor;
    }

    /**
     * @return the btnUtiliserCarte
     */
    public JButton getBtnUtiliserCarte() {
        return btnUtiliserCarte;
    }
    
    public void griserActions(){
        this.btnAssecher.setEnabled(false);
        this.btnAutreAction.setEnabled(false);
        this.btnBouger.setEnabled(false);
        this.btnRecupererTresor.setEnabled(false);
        this.btnTerminerTour.setEnabled(false);
        this.btnUtiliserCarte.setEnabled(false);
        if(this.btnDeplacerJoueur!=null){
            this.btnDeplacerJoueur.setEnabled(false);
        }
    }
    
    public void degriserActions(){
        this.btnAssecher.setEnabled(true);
        this.btnAutreAction.setEnabled(true);
        this.btnBouger.setEnabled(true);
        this.btnRecupererTresor.setEnabled(true);
        this.btnTerminerTour.setEnabled(true);
        this.btnUtiliserCarte.setEnabled(true);
        if(this.btnDeplacerJoueur!=null){
            this.btnDeplacerJoueur.setEnabled(true);
        }
    }

    /**
     * @return the btnDeplacerJoueur
     */
    public JButton getBtnDeplacerJoueur() {
        return btnDeplacerJoueur;
    }
     
}

 

