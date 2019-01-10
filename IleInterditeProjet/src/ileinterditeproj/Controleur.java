/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import LesJoueurs.Messager;
import LesJoueurs.Plongeur;
import LesJoueurs.Pilote;
import LesJoueurs.Navigateur;
import LesJoueurs.Explorateur;
import LesJoueurs.Ingenieur;
import LesJoueurs.Aventurier;
import LesJoueurs.Aventurier;
import LesJoueurs.Explorateur;
import LesJoueurs.Ingenieur;
import LesJoueurs.Messager;
import LesJoueurs.Navigateur;
import LesJoueurs.Pilote;
import LesJoueurs.Plongeur;
import Vues.VueInitialisation;
import Vues.VueAventurier;
import Vues.VueInscription;
import Vues.VuePlateau;
import ileinterditeproj.EtatTuile;
import ileinterditeproj.Grille;
import ileinterditeproj.Message;
import ileinterditeproj.Tuile;
import ileinterditeproj.Utils.Commandes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 *
 * @author kemplail
 */
public class Controleur implements Observer {

    private Grille grille;
    private ArrayList<Aventurier> joueurs;
    private ArrayList<Tuile> tuilesdepart;
    private ArrayList<CarteInondation> piocheInondation ;
    private ArrayList<CarteInondation> defausseInondation ;
    private ArrayList<CarteTirage> piocheTirage;
    private ArrayList<CarteTirage> defausseTirage;
    private VueAventurier vueaventurier;
    private VueInscription vueinsc; 
    private VuePlateau vplateau ;
    private VueInitialisation vueIni;
    private int compteurtour = 0;
   
    Controleur() {
        
        //Création de la Grille
        grille = new Grille();
        ArrayList<Tuile> lestuiles = new ArrayList();
        
        //Création des tuiles
        Tuile t1 = new Tuile("Le Pont des Abimes");
        Tuile t2 = new Tuile("La Porte de Bronze"); t2.setEtat(Utils.EtatTuile.INONDEE); // Pion.ROUGE
        Tuile t3 = new Tuile("La Caverne des Ombres");
        Tuile t4 = new Tuile("La Porte de Fer" );    //Pion.VIOLET
        Tuile t5 = new Tuile("La Porte d'Or");   //Pion.JAUNE
        Tuile t6 = new Tuile("Les Falaises de l'Oubli");
        Tuile t7 = new Tuile("Le Palais de Corail");
        Tuile t8 = new Tuile("La Porte d'Argent");  //Pion.ORANGE
        Tuile t9 = new Tuile("Les Dunes de l’Illusion"); t9.setEtat(Utils.EtatTuile.COULEE);
        Tuile t10 = new Tuile("Heliport");      //Pion.BLEU 
        Tuile t11= new Tuile("La Porte de Cuivre");  // Pion.VERT
        Tuile t12 = new Tuile("Le Jardin des Hurlements"); 
        Tuile t13 = new Tuile("La Foret Pourpre");
        Tuile t14 = new Tuile("Le Lagon Perdu"); t14.setEtat(Utils.EtatTuile.INONDEE);
        Tuile t15 = new Tuile("Le Marais Brumeux"); t15.setEtat(Utils.EtatTuile.COULEE);
        Tuile t16 = new Tuile("Observatoire"); t16.setEtat(Utils.EtatTuile.INONDEE);
        Tuile t17 = new Tuile("Le Rocher Fantome"); t17.setEtat(Utils.EtatTuile.COULEE);
        Tuile t18 = new Tuile("La Caverne du Brasier"); t18.setEtat(Utils.EtatTuile.INONDEE);
        Tuile t19 = new Tuile("Le Temple du Soleil");
        Tuile t20 = new Tuile("Le Temple de La Lune"); t20.setEtat(Utils.EtatTuile.COULEE);
        Tuile t21 = new Tuile("Le Palais des Marees");
        Tuile t22 = new Tuile("Le Val du Crepuscule");
        Tuile t23 = new Tuile("La Tour du Guet");
        Tuile t24 = new Tuile("Le Jardin des Murmures"); t24.setEtat(Utils.EtatTuile.INONDEE);
        
        //Affectation des tuiles de départ
        tuilesdepart = new ArrayList();
        
        tuilesdepart.add(t2);
        tuilesdepart.add(t4);
        tuilesdepart.add(t5);
        tuilesdepart.add(t8);
        tuilesdepart.add(t10);
        tuilesdepart.add(t11);
        
        //Ajout des tuiles dans la liste des tuiles
        lestuiles.add(t1);
        lestuiles.add(t2);
        lestuiles.add(t3);
        lestuiles.add(t4);
        lestuiles.add(t5);
        lestuiles.add(t6);
        lestuiles.add(t7);
        lestuiles.add(t8);
        lestuiles.add(t9);
        lestuiles.add(t10);
        lestuiles.add(t11);
        lestuiles.add(t12);
        lestuiles.add(t13);
        lestuiles.add(t14);
        lestuiles.add(t15);
        lestuiles.add(t16);
        lestuiles.add(t17);
        lestuiles.add(t18);
        lestuiles.add(t19);
        lestuiles.add(t20);
        lestuiles.add(t21);
        lestuiles.add(t22);
        lestuiles.add(t23);
        lestuiles.add(t24);
        
        // Création des collections pioche/défausse Inondation
        piocheInondation = new ArrayList();
        defausseInondation = new ArrayList();
        
        //Initialisation de la grille
        grille.setTableau(lestuiles);
        
        //Création de la liste des cartes inondations, en fonction des tuiles inondées
        setpiocheInondation(lestuiles);
        
        joueurs = new ArrayList();
       
        //vueIni = new VueInitialisation();
        //setJoueurs(vueIni);
        
               vueaventurier = new VueAventurier(this.getJoueurs().get(compteurtour));
               vueaventurier.addObserver(this);
        
    }
    
    @Override
    public void update(Observable arg0, Object arg1) {
        
        if(arg1 instanceof Message){
            Message message = (Message) arg1 ;
            if(message.getAction()==Commandes.BOUGER){
                
                int i = 0;
                while(i<joueurs.size() && !(joueurs.get(i).getNom().equals(message.getNomJ()))){
                    i++;
                }
                
                Grille g = this.getGrille();
                Scanner sc = new Scanner(System.in) ;
                ArrayList<Tuile> tuilesatteignables;
                
                if (!(joueurs.get(i) instanceof Pilote)) {
                
                tuilesatteignables = joueurs.get(i).seDeplacer(grille);
                
                }
                
                else {
                    
                    System.out.println("Voulez-vous utiliser votre vol ?");
                    String rep = sc.nextLine();
                    if (rep.equals("oui")) {
                        tuilesatteignables = ((Pilote)joueurs.get(i)).seDeplacerVol(grille);
                    } else {
                        tuilesatteignables = joueurs.get(i).seDeplacer(grille);
                    }
                    
                }
                 
                if (tuilesatteignables.isEmpty() == false) {
                
                affichernomtuiles(tuilesatteignables);
                 
                 System.out.println("Ou se déplacer ?");
                 String nomtuile = sc.nextLine();
                 Tuile nouvelletuile = chercherTuile(nomtuile,tuilesatteignables);
                 
                 if(nouvelletuile != null){
                     joueurs.get(i).changerTuileCourante(nouvelletuile);
                     grisebouton(vueaventurier, joueurs.get(i).getPtsaction());
                     System.out.println("Action effectuée : Nouvelle tuile :"+joueurs.get(i).getTuileCourante().getNom());
                     vueaventurier.rafraichirPositon(joueurs.get(i));
                 }
                 
                }else {
                    System.out.println("Action impossible");
                }
                
               
                
            }
            
            else if(message.getAction() == Commandes.ASSECHER) {
                
                int i = 0;
                while ((i < joueurs.size()) && (!(joueurs.get(i).getNom().equals(message.getNomJ())))) {
                    i++; 
                }
                
                    Grille g = this.getGrille();
                    
                    ArrayList<Tuile> tuilesassechables = joueurs.get(i).assecher(grille);
                    
                    if (tuilesassechables.isEmpty() == false) {
                   
                    affichernomtuiles(tuilesassechables);
                        
                    System.out.println("Quelle case assécher ?");
                    Scanner sc = new Scanner(System.in) ;
                    String nomtuile = sc.nextLine();
                    Tuile tuileassecher = chercherTuile(nomtuile,tuilesassechables);
                    
                    if (tuileassecher != null) {
                       joueurs.get(i).assechertuile(tuileassecher);
                        grisebouton(vueaventurier, joueurs.get(i).getPtsaction());
                       System.out.println("Action effectuée : Tuile assechée :"+tuileassecher.getNom());
                    } 
                    
                    if (joueurs.get(i) instanceof Ingenieur) {
                    
                    System.out.println("Voulez-vous assécher une autre case ?");
                    String rep = sc.nextLine();
                    
                    if(rep.equals("oui") ) {
                     
                    tuilesassechables = joueurs.get(i).assecher(grille);
                    
                   
                    if (tuilesassechables.isEmpty() == false) {
                    
                    affichernomtuiles(tuilesassechables);
                    
                    System.out.println("Quelle case assécher ?");
                    sc = new Scanner(System.in) ;
                    nomtuile = sc.nextLine();
                    tuileassecher = chercherTuile(nomtuile,joueurs.get(i).seDeplacer(grille));
                        if (tuileassecher != null) {
                            ((Ingenieur)joueurs.get(i)).assechertuile2efois(tuileassecher);
                            System.out.println("Action effectuée : Tuile assechée :"+tuileassecher.getNom());
                            }else{
                            System.out.println("Assechement impossible");
                            }
                    }else {
                        System.out.println("Assechement impossible");
                    }
                    }
          
                    }
                    
                 } else {
                        System.out.println("Assechement impossible");
                    }
        
             }
        
            else if ((message.getAction() ==Commandes.DEPLACER)) {
                
                 int i = 0;
                while ((i < joueurs.size()) && (!(joueurs.get(i).getNom().equals(message.getNomJ())))) {
                    i++; 
                }
                
                int nbActions = joueurs.get(i).getPtsaction();
                Grille g = this.getGrille();
                
                if (joueurs.get(i) instanceof Navigateur && nbActions > 0) {
                    
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Entrez le nom du joueur");
                    String nomjoueuradeplacer = sc.nextLine();
                    
                    Aventurier av = chercherAventurier(nomjoueuradeplacer);
                    
                    if (av != null) {  
                        ArrayList<Tuile> tuilesatteignables = av.deplacementParNavigateur(g);
                            if (tuilesatteignables.isEmpty() == false) {
                
                                affichernomtuiles(tuilesatteignables);
                 
                                System.out.println("Ou le déplacer ?");
                                String nomtuile = sc.nextLine();
                                Tuile nouvelletuile = chercherTuile(nomtuile,tuilesatteignables);
                 
                                 if(nouvelletuile != null){
                                 joueurs.get(i).changerTuileCourante(nouvelletuile);
                                 joueurs.get(i).enleveUneAction();
                                 grisebouton(vueaventurier, joueurs.get(i).getPtsaction());
                                 System.out.println("Action effectuée : Nouvelle tuile :"+joueurs.get(i).getTuileCourante().getNom());
                                 }
                            }else {
                               System.out.println("Action impossible");
                            }
                        
                        
                    }
                    
                }
                
            } else if(message.getAction() == Commandes.TERMINER) {
               compteurtour++;
                if (compteurtour < joueurs.size()) {
                    vueaventurier.close();
                    vueaventurier = new VueAventurier(this.getJoueurs().get(compteurtour));
                    vueaventurier.addObserver(this);
                } else {
                    System.out.println("Le tour est terminé");
                    compteurtour = 0;
                    
                    for (Aventurier j : joueurs) {
                        j.setPtsaction(3);
                        if (j instanceof Pilote) {
                            ((Pilote) j).setNbvol(1);
                        }
                    }
                    
                    vueaventurier = new VueAventurier(this.getJoueurs().get(compteurtour) );
                    vueaventurier.addObserver(this);
                    
                }
            }
            
        }
            
    }
    
    public void addAventurier(Aventurier aventurier) {
        
        if (this.getJoueurs().size() < 4) {
        this.getJoueurs().add(aventurier); }
    }

    /**
     * @return the grille
     */
    public Grille getGrille() {
        return grille;
    }

    /**
     * @return the joueurs
     */
    public ArrayList<Aventurier> getJoueurs() {
        return joueurs;
    }
    
    public void afficherJoueurs(){
        
        for (Aventurier j: joueurs){
            
            System.out.println("Nom :"+j.getNom()+" Role:"+j.getClass().getSimpleName());
            
        }
       
    }
    
    public void afficherGrille(){
        int i = 1;
        for (int x=0; x<6;x++){
            for (int y=0;y<6;y++){
                System.out.println("Tuiles n°"+i+"="+grille.getTableau()[x][y].getNom());
                i++;
                
            }
       }
    
    }

    /**
     * @param joueurs the joueurs to set
     */
    public void setJoueurs(VueInitialisation v) {
        
            ArrayList<String> noms = v.getNoms();
            ArrayList<String> roles = v.getRoles();
            
            int i = 0;
            while(i<roles.size()){
            
            if(roles.get(i).equals("plongeur")){
                Plongeur p = new Plongeur(noms.get(i),tuilesdepart.get(1)); //Noir
                joueurs.add(p);
            }else if(roles.get(i).equals("messager")){
                Messager m = new Messager(noms.get(i),tuilesdepart.get(3));  //Blanc
                joueurs.add(m);
            }else if(roles.get(i).equals("navigateur")){
                Navigateur n = new Navigateur(noms.get(i),tuilesdepart.get(2)); // Jaune
                joueurs.add(n);
            }else if(roles.get(i).equals("pilote")){
                Pilote pilote = new Pilote(noms.get(i),tuilesdepart.get(4)); // Bleu
                joueurs.add(pilote);
            }else if(roles.get(i).equals("ingenieur")){
                  // Pion.ROUGE
                Ingenieur ing = new Ingenieur(noms.get(i),tuilesdepart.get(0)); //Rouge
                joueurs.add(ing);
            }else if(roles.get(i).equals("explorateur")){
                Explorateur exp = new Explorateur(noms.get(i),tuilesdepart.get(5)); //Vert
                joueurs.add(exp);
            }
            i++;
            }
            
        }
        
    

    public Tuile chercherTuile(String nomtuile, ArrayList<Tuile> tuilesatteignable) {
        int i =0;
        Tuile tvoulu = null;
        while(i<tuilesatteignable.size() && tuilesatteignable.get(i).getNom().equals(nomtuile)==false){
           i++;
        }
         if(i<tuilesatteignable.size() && tuilesatteignable.get(i).getNom().equals(nomtuile) ){
             tvoulu = tuilesatteignable.get(i) ;
         }
         
         return tvoulu;
        
    }
    
    public Aventurier chercherAventurier(String nomjoueurcherche) {
        int i =0;
        Aventurier jvoulu = null;
        while(i<joueurs.size() && joueurs.get(i).getNom().equals(nomjoueurcherche)==false){
           i++;
        }
         if(i<joueurs.size() && joueurs.get(i).getNom().equals(nomjoueurcherche) ){
             jvoulu = joueurs.get(i) ;
         }
         
         return jvoulu;
        
    }
    
    private void affichernomtuiles(ArrayList<Tuile> listetuiles) {
        for (Tuile t : listetuiles) {
            System.out.println(t.getNom());
        }
    }
    
    public void grisebouton(Observable av, int nbaction) {
        
        if(nbaction==0){
            
            ((VueAventurier)av).getBtnAssecher().setEnabled(false);
            ((VueAventurier)av).getBtnBouger().setEnabled(false);
            ((VueAventurier)av).getBtnAutreAction().setEnabled(false);
        }
    }
    
    public void setpiocheInondation(ArrayList<Tuile> listeT){
        for(Tuile t : listeT){
            CarteInondation carte = new CarteInondation(t);
            getPiocheInondation().add(carte);
        }       
    }
    
    public void setPiocheTirage() {
        
        //Création des cartes trésor
        for (int i = 1; i <= 20; i++) {
            if (i <= 5) {
                this.getPiocheTirage().add(new CarteTresor(Utils.Tresor.CALICE));
            } else if (i > 5 && i <= 10) {
                this.getPiocheTirage().add(new CarteTresor(Utils.Tresor.CRISTAL));
            } else if (i > 10 && i <= 15) {
                this.getPiocheTirage().add(new CarteTresor(Utils.Tresor.PIERRE));
            } else {
                this.getPiocheTirage().add(new CarteTresor(Utils.Tresor.ZEPHYR));
            }
        }
        
        //Création des cartes hélicos
        for (int j = 1; j <= 3; j++) {
            this.getPiocheTirage().add(new CarteHelicoptere());
        }
        
        for (int k = 1; k <= 2; k++) {
            this.getPiocheTirage().add(new CarteSacDeSable());
        }
        
        for (int l = 1; l <= 2; l++) {
            this.getPiocheTirage().add(new CarteMonteedesEaux());
        }
        
    }
    
            
    public void melangeDefausseCarteInondation() {
        Collections.shuffle(this.getDefausseInondation());
        this.getPiocheInondation().addAll(this.getDefausseInondation());
        this.getDefausseInondation().clear();
    }

    /**
     * @return the piocheInondation
     */
    public ArrayList<CarteInondation> getPiocheInondation() {
        return piocheInondation;
    }

    /**
     * @return the defausseInondation
     */
    public ArrayList<CarteInondation> getDefausseInondation() {
        return defausseInondation;
    }

    /**
     * @return the piocheTirage
     */
    public ArrayList<CarteTirage> getPiocheTirage() {
        return piocheTirage;
    }

    /**
     * @return the defausseTirage
     */
    public ArrayList<CarteTirage> getDefausseTirage() {
        return defausseTirage;
    }
    
}