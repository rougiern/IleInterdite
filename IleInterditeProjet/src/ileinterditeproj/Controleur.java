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
import Vues.VueAventurier;
import Vues.VueDefausse;
import Vues.VueInscription;
import Vues.VueNiveau;
import Vues.VuePlateau;
import ileinterditeproj.EtatTuile;
import ileinterditeproj.Grille;
import ileinterditeproj.Message;
import ileinterditeproj.Tuile;
import ileinterditeproj.Utils.Commandes;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
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
    private VueNiveau vueniv ;
    private VuePlateau vplateau ;
    private int compteurtour = 0;
    private ArrayList<Tuile> tuilesatteignables;
    private Aventurier joueurcourant;
    private ArrayList<Tuile> tuilesassechables;
    private ArrayList<Utils.Tresor> tresorsrecupérés;
    private VueDefausse vdefausse;
    
    
    Controleur() {
        
        joueurcourant=null;
        tuilesatteignables=null;
        tuilesassechables=null;
        
        //Création de la Grille
        grille = new Grille();
        ArrayList<Tuile> lestuiles = new ArrayList();
        
        //Création des tuiles
        Tuile t1 = new Tuile("Le Pont des Abimes");
        Tuile t2 = new Tuile("La Porte de Bronze");  // Pion.ROUGE
        Tuile t3 = new Tuile("La Caverne des Ombres", Utils.Tresor.CRISTAL);
        Tuile t4 = new Tuile("La Porte de Fer" );    //Pion.VIOLET
        Tuile t5 = new Tuile("La Porte d'Or");   //Pion.JAUNE
        Tuile t6 = new Tuile("Les Falaises de l'Oubli");
        Tuile t7 = new Tuile("Le Palais de Corail" , Utils.Tresor.CALICE);
        Tuile t8 = new Tuile("La Porte d'Argent");  //Pion.ORANGE
        Tuile t9 = new Tuile("Les Dunes de l’Illusion"); 
        Tuile t10 = new Tuile("Heliport");      //Pion.BLEU 
        Tuile t11= new Tuile("La Porte de Cuivre");  // Pion.VERT
        Tuile t12 = new Tuile("Le Jardin des Hurlements",Utils.Tresor.ZEPHYR);  
        Tuile t13 = new Tuile("La Foret Pourpre");
        Tuile t14 = new Tuile("Le Lagon Perdu"); 
        Tuile t15 = new Tuile("Le Marais Brumeux"); 
        Tuile t16 = new Tuile("Observatoire"); 
        Tuile t17 = new Tuile("Le Rocher Fantome"); 
        Tuile t18 = new Tuile("La Caverne du Brasier", Utils.Tresor.CRISTAL); 
        Tuile t19 = new Tuile("Le Temple du Soleil", Utils.Tresor.PIERRE);
        Tuile t20 = new Tuile("Le Temple de La Lune", Utils.Tresor.PIERRE); 
        Tuile t21 = new Tuile("Le Palais des Marees", Utils.Tresor.CALICE);
        Tuile t22 = new Tuile("Le Val du Crepuscule");
        Tuile t23 = new Tuile("La Tour du Guet");
        Tuile t24 = new Tuile("Le Jardin des Murmures", Utils.Tresor.ZEPHYR);
        
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
        piocheTirage = new ArrayList();
        defausseTirage = new ArrayList();
        tresorsrecupérés = new ArrayList();
        
        //Création de la vue niveau
        vueniv = new VueNiveau(1);
        //Initialisation de la grille
        grille.setTableau(lestuiles);
        
        //Création de la liste des cartes inondations, en fonction des tuiles inondées
        setpiocheInondation(lestuiles);
        Collections.shuffle(piocheInondation);
        for(int i =0 ;i<6 ;i++){
            tirerCarteInondation();
        }
        
        //Création de la liste des cartes tirages
        setPiocheTirage();
                
        //Lancement du jeu      
        joueurs = new ArrayList();
        
        vueinsc = new VueInscription();
        vueinsc.addObserver(this);
        vueinsc.afficher();
       
        //Création du plateau
        this.vplateau = new VuePlateau(this.grille);
        vplateau.addObserver(this);
        
        
        //Creation de la vue défausse
        
        this.vdefausse=new VueDefausse(new ArrayList<CarteTirage>());
        vdefausse.addObserver(this);
        

    }
    
    @Override
    public void update(Observable arg0, Object arg1) {
        int nbaInge = 1;
        if(arg1 instanceof MessageIni){
            MessageIni message = (MessageIni) arg1;
            if(message.getAction()==Action.NB_JOUEURS){
                vueinsc.formulaire(message.getNbj());
            }else if (message.getAction()==Action.INSCRIRE_JOUEURS){
                AttribuerRole(message.getNoms());
                vueinsc.close();
                
                joueurcourant=joueurs.get(0);
                
                //Distribution des cartes
                DistributionDébut();
                
                vueaventurier = new VueAventurier(this.getJoueurs().get(compteurtour));
                vueaventurier.addObserver(this);
                vplateau.raffraichir(grille);
                vplateau.afficher();
                afficherJoueurs();
        }  
        }
        if(arg1 instanceof Message){
            Message message = (Message) arg1 ;
            if((arg0 instanceof VueAventurier) && message.getAction()==Commandes.BOUGER){
                
                vplateau.setDerniereaction(Commandes.BOUGER);
                
//                int i = 0;
//                while(i<joueurs.size() && !(joueurs.get(i).getNom().equals(message.getNomJ()))){
//                    i++;
//                }
//                joueurcourant=joueurs.get(i);
                
                Grille g = this.getGrille();
                Scanner sc = new Scanner(System.in) ;
                                
                if (!(joueurcourant instanceof Pilote)) {
                
                tuilesatteignables = joueurcourant.seDeplacer(grille);
                           
                }else{   
                    if(((Pilote)joueurcourant).getNbvol()==1){                 
                        if (Utils.poserQuestion("Voulez-vous utiliser votre vol ?")) {
                            tuilesatteignables = ((Pilote)joueurcourant).seDeplacerVol(grille);
                        } else {
                        tuilesatteignables = joueurcourant.seDeplacer(grille);
                        }  
                    }
                }
                 
                if (tuilesatteignables.isEmpty() == false) {
                
                affichernomtuiles(tuilesatteignables);
                
                  System.out.println("Ou se déplacer ?");

                 
                }else {
                    System.out.println("Action impossible");
                }
                
               
                
            }else if((arg0 instanceof VuePlateau) && message.getAction()==Commandes.BOUGER){
                
                int x=0;
                
                                   
                   
                while(x<tuilesatteignables.size()&& !(tuilesatteignables.get(x).getNom().equals(message.getTuile().getNom()))){
                    x++;
                }
                
                if(x!=tuilesatteignables.size()){
                    System.out.println(tuilesatteignables.get(x).getNom());
                    joueurcourant.getTuileCourante().retirerAventurierTuile(joueurcourant);
                    tuilesatteignables.get(x).addAventurierTuile(joueurcourant);
                    joueurcourant.setTuileCourante(tuilesatteignables.get(x));
                    joueurcourant.enleveUneAction();
                    grisebouton(vueaventurier, joueurcourant.getPtsaction());
                    System.out.println("Action effectuée : Nouvelle tuile :"+joueurcourant.getTuileCourante().getNom());
                    vueaventurier.rafraichirPositon(joueurcourant);
                    vplateau.raffraichir(grille);
                }else{
                    System.out.println("la case n'est pas valide");
                }

            }
            
            else if ((arg0 instanceof VueAventurier) && message.getAction() == Commandes.RECUPERER_TRESOR) {
                
                int i = 0;
                while(i<joueurs.size() && !(joueurs.get(i).getNom().equals(message.getNomJ()))){
                    i++;
                }
   
                // On regarde si il a 4 cartes tirage du même trésor que le trésor de la tuile sur la quelle il est
                int nbok = 0;
                if (joueurs.get(i).getTuileCourante().getTresor() != null) {
                    for (CarteTirage c : joueurs.get(i).getMains()) {
                        if (c instanceof CarteTresor) {
                            if (((CarteTresor) c).getTypeTresor() == joueurs.get(i).getTuileCourante().getTresor()) {
                                nbok++;
                            }
                        }
                    }
                }    
                    
                // Si c'est le cas, on retire ces cartes de sa main
                int nbretires = 0;    
                if (nbok >= 4) {
                        for (int u = 0; u < joueurs.get(i).getMains().size(); u++) {
                            if (joueurs.get(i).getMains().get(u) instanceof CarteTresor) {
                                if (((CarteTresor) joueurs.get(i).getMains().get(u)).getTypeTresor() == joueurs.get(i).getTuileCourante().getTresor()) {
                                    joueurs.get(i).getMains().remove(u);
                                }
                            }   
                        }
                        
                // On ajoute à la liste des trésors récupérés le trésor concerné, et on enlève de la tuile le trésor
                        tresorsrecupérés.add(joueurs.get(i).getTuileCourante().getTresor());
                        joueurs.get(i).getTuileCourante().setTresor(null);
                        joueurs.get(i).enleveUneAction();
                        System.out.println("Trésor récupéré");
                        
                    } else {
                        
                        System.out.println("Impossible");
                        
                    }
                    
                
                
            }
            
            else if((arg0 instanceof VueAventurier) && message.getAction()==Commandes.ASSECHER){
                
                vplateau.setDerniereaction(Commandes.ASSECHER);
                nbaInge = 1;
                
//                int i = 0;
//                while(i<joueurs.size() && !(joueurs.get(i).getNom().equals(message.getNomJ()))){
//                    i++;
//                }
//                
//                joueurcourant=joueurs.get(i);
                
                    Grille g = this.getGrille();
                    
                    tuilesassechables = joueurcourant.assecher(grille);
                    if(joueurcourant.getTuileCourante().getEtat()==Utils.EtatTuile.INONDEE){
                        tuilesassechables.add(joueurcourant.getTuileCourante());
                    }
                   
                    if (tuilesassechables.isEmpty() == false) {
                   
                    affichernomtuiles(tuilesassechables);
                       
                    System.out.println("cliquez sur une case à assecher");
                    
                 } else {
                        System.out.println("Assechement impossible");
                    }
        
             }
            
            else if((arg0 instanceof VuePlateau) && message.getAction()==Commandes.ASSECHER){
                
                int i=0;
                
                while(i<tuilesassechables.size()&& !(tuilesassechables.get(i).getNom().equals(message.getTuile().getNom()))){
                    i++;
                }
                
                if(i<tuilesassechables.size()){
                    
                    if (joueurcourant instanceof Ingenieur && nbaInge==0) {
                        
                        System.out.println("deuxieme assechement inge NBA=0");
                        
                    }
                        
                    System.out.println(tuilesassechables.get(i).getNom());
                    joueurcourant.assechertuile(tuilesassechables.get(i));
                    

                    grisebouton(vueaventurier, joueurcourant.getPtsaction());
                    System.out.println("Action effectuée : tuile assechee :"+tuilesassechables.get(i).getNom());
                    vplateau.raffraichir(this.grille);
                    
                    vplateau.setDerniereaction(Utils.Commandes.NULL);
                    
                    if (joueurcourant instanceof Ingenieur && nbaInge==1) {
                        nbaInge=0;
                        deuxiemeAssechementInge();
                        
                    }
                    
                    
                }else{
                    System.out.println("la case n'est pas valide");
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
                                 joueurs.get(i).getTuileCourante().retirerAventurierTuile(joueurcourant);
                                 joueurs.get(i).changerTuileCourante(nouvelletuile);
                                 nouvelletuile.addAventurierTuile(joueurcourant);
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
                   tirerCarteInondation();
              
               vplateau.raffraichir(this.grille);
                int i = 0;
                while ((i < joueurs.size()) && (!(joueurs.get(i).getNom().equals(message.getNomJ())))) {
                    i++; 
                }
               tirerCartetirage(this.getJoueurs().get(i));
               compteurtour++;
                if (compteurtour < joueurs.size()) {
                    vueaventurier.close();
                    vueaventurier = new VueAventurier(this.getJoueurs().get(compteurtour));
                    vueaventurier.addObserver(this);
                    
                    joueurcourant=this.getJoueurs().get(compteurtour);
//                    défausse carte
                    defausse();
                } else {
                    vueaventurier.close();
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
                    
                    joueurcourant=this.getJoueurs().get(compteurtour);
//                    défausse carte
                    defausse();
                    
                }
            } else if ((arg0 instanceof VueDefausse) && message.getAction() == Commandes.DEFAUSSE){
                
                System.out.println("suppr carte");
                joueurcourant.defausserCarte(message.getNbcarte());
                
                
                if(joueurcourant.getMains().size()>5){
                    vdefausse.rafraichir(joueurcourant.getMains());
                    System.out.println("rafraichissement");
                }else{                    
                    vdefausse.close();
                    System.out.println("cacher");
                }
                
            }
            
        }
            
    }
    
    public void deuxiemeAssechementInge(){
        
                  
                 
                if(Utils.poserQuestion("Voulez-vous assécher une autre case ?") ) {
                     
                    
                    
                    tuilesassechables = joueurcourant.assecher(grille);
                    if(joueurcourant.getTuileCourante().getEtat()==Utils.EtatTuile.INONDEE){
                        tuilesassechables.add(joueurcourant.getTuileCourante());
                    }
                   affichernomtuiles(tuilesassechables);
                   System.out.println("2iem affi inge");
                    if (tuilesassechables.isEmpty() == false) {
                        affichernomtuiles(tuilesassechables);
                        joueurcourant.setPtsaction(joueurcourant.getPtsaction()+1);
                        System.out.println("Quelle case assécher ING ?");
                        vplateau.setDerniereaction(Commandes.ASSECHER);
                    }else {
                        System.out.println("Assechement impossible");
                }
                }
                    
    }
    
    
    public void addAventurier(Aventurier aventurier) {
        
        if (this.getJoueurs().size() < 4) {
        this.getJoueurs().add(aventurier); }
    }

    public Grille getGrille() {
        return grille;
    }

    public ArrayList<Aventurier> getJoueurs() {
        return joueurs;
    }
    
    public void afficherJoueurs(){
        
        for (Aventurier j: joueurs){
            
            System.out.println("Nom :"+j.getNom()+" Role:"+j.getClass().getSimpleName());  
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
        
        Collections.shuffle(piocheTirage);
        
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

    private void AttribuerRole(String[] noms) {
           ArrayList<String> roles ;
            roles = new ArrayList();
            roles.add("plongeur");
            roles.add("explorateur");
            roles.add("navigateur");
            roles.add("messager");
            roles.add("ingenieur");
            roles.add("pilote");
        for(int i=0;i<noms.length;i++){
            Random r = new Random();
            int valeur =r.nextInt(roles.size());
            if(roles.get(valeur).equals("plongeur")){
                Plongeur p = new Plongeur(noms[i],tuilesdepart.get(1)); //Noir
                tuilesdepart.get(1).addAventurierTuile(p);
                roles = retirerRole(roles,"plongeur");
                joueurs.add(p);
            }else if(roles.get(valeur).equals("explorateur")){
                Explorateur exp = new Explorateur(noms[i],tuilesdepart.get(5));
                tuilesdepart.get(5).addAventurierTuile(exp);
                roles = retirerRole(roles,"explorateur");//Blanc
                joueurs.add(exp);
            }else if(roles.get(valeur).equals("navigateur")){
                Navigateur n = new Navigateur(noms[i],tuilesdepart.get(2));
                tuilesdepart.get(2).addAventurierTuile(n);
                roles = retirerRole(roles,"navigateur");
                joueurs.add(n);
            }else if(roles.get(valeur).equals("messager")){
                 Messager m = new Messager(noms[i],tuilesdepart.get(3));
                 tuilesdepart.get(3).addAventurierTuile(m);
                 roles = retirerRole(roles,"messager");
                 joueurs.add(m);
            }else if(roles.get(valeur).equals("ingenieur")){
                Ingenieur ing = new Ingenieur(noms[i],tuilesdepart.get(0));
                tuilesdepart.get(0).addAventurierTuile(ing);
                roles = retirerRole(roles,"ingenieur");
                joueurs.add(ing);
            }else if(roles.get(valeur).equals("pilote")){
                Pilote pilote = new Pilote(noms[i],tuilesdepart.get(4));
                tuilesdepart.get(4).addAventurierTuile(pilote);
                roles = retirerRole(roles,"pilote");// Bleu
                joueurs.add(pilote);
            }
            
           
            
        }
    }
    

    private ArrayList<String> retirerRole(ArrayList<String> roles, String r) {
       
        int i = 0;
        while(i<roles.size()&& !(roles.get(i).equals(r))){
                i++;
            }
            if(i!=roles.size()){
            roles.remove(i);
            }
            return roles;
    }
           
    
    
    
     public void defausserCarteInondation(int i) {
        defausseInondation.add(piocheInondation.get(i));
        piocheInondation.remove(i);

    }

    public void defausserCarteMonteedesEaux(int i) {

        defausseTirage.add(piocheTirage.get(i));
        piocheTirage.remove(i);

    }

    private void tirerCartetirage(Aventurier j) {

        CarteTirage carte1 = null, carte2 = null;

        for (int t = 0; t < 2; t++) {

            if (piocheTirage.isEmpty()) {
                melangeDefausseCarteTirage();
            }

            if (j.getMains().size() < 9) {

                if (t == 0) {
                    carte1 = piocheTirage.get(0);
                } else {
                    carte2 = piocheTirage.get(0);
                }

                if (piocheTirage.get(0) instanceof CarteMonteedesEaux) {
                    this.tireCarteMonteeDesEaux(0);
                } else {
                    j.getMains().add(piocheTirage.get(0));
                    piocheTirage.remove(piocheTirage.get(0));
                }

            }

        }

        if (carte1 instanceof CarteMonteedesEaux || carte2 instanceof CarteMonteedesEaux) {
            this.melangeDefausseCarteInondation();
        }

    }

    public void tirerCarteInondation() {
        String[] listeInnon = new String[vueniv.getNiveau()] ;
        for (int x = 0; x < vueniv.getNiveau(); x++) {

            if (piocheInondation.isEmpty()) {
                melangeDefausseCarteInondation();
            }
            CarteInondation cInon = piocheInondation.get(0);
            listeInnon[x]=cInon.getTuile().getNom();
            Tuile ttire = cInon.getTuile();
            grille.inonderTuile(ttire);
            if (ttire.getEtat() == Utils.EtatTuile.INONDEE) {
                defausserCarteInondation(0);
            } else if (ttire.getEtat() == Utils.EtatTuile.COULEE) {
                piocheInondation.remove(0);
            }
        }
        String s = "";
        for (int x = 0; x < vueniv.getNiveau(); x++) {
            s = s + listeInnon[x] +"," ;
        }
        s=s+" S'innonde maintenant !!!";
        
        Utils.afficherInformation(s);

    }

    public void tireCarteMonteeDesEaux(int i) {

        // On augmente le niveau de l'eau
        this.vueniv.setNiveau(vueniv.getNiveau() + 1);

        // On défausse la carte Montée des eaux qui vient d'être tirée
        this.defausserCarteMonteedesEaux(i);
}

    private void melangeDefausseCarteTirage() {
        Collections.shuffle(this.getDefausseTirage());
        piocheTirage.addAll(this.getDefausseTirage());
        defausseTirage.clear();
    }
    
    public void melangeDefausseCarteInondation() {
        Collections.shuffle(this.getDefausseInondation());
        piocheInondation.addAll(this.getDefausseInondation());
        defausseInondation.clear();
    }
    
    public void DistributionDébut() {
        
        for (Aventurier a : this.getJoueurs()) {
            int r = 0, nb = 0;
            while (r != 2) {
                if (!(this.getPiocheTirage().get(nb) instanceof CarteMonteedesEaux)) {
                    a.getMains().add(this.getPiocheTirage().get(nb));
                    this.getPiocheTirage().remove(nb);
                    r++;
                }
                nb++;
            }
        }
        
    }
    
    public void defausse(){
        
        if(joueurcourant.getMains().size()>5){
            vdefausse = new VueDefausse(joueurcourant.getMains());
            vdefausse.addObserver(this);
//            vdefausse.rafraichir(joueurcourant.getMains());
            vdefausse.afficher();
            
        }
        
    }
    

}