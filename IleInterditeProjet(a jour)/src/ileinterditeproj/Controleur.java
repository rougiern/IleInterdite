/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import java.util.ArrayList;
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
   
    Controleur() {
        
        grille = new Grille();
        ArrayList<Tuile> lestuiles = new ArrayList();
        Tuile t1 = new Tuile("Le Pont des Abimes");
        Tuile t2 = new Tuile("La Porte de Bronze");  // Pion.ROUGE
        Tuile t3 = new Tuile("La Caverne des Ombres");//t3.setEtat(EtatTuile.Coulee);
        Tuile t4 = new Tuile("La Porte de Fer" );    //Pion.VIOLET
        Tuile t5 = new Tuile("La Porte d’Or");    //Pion.JAUNE
        Tuile t6 = new Tuile("Les Falaises de l’Oubli");
        Tuile t7 = new Tuile("Le Palais de Corail");
        Tuile t8 = new Tuile("La Porte d’Argent");  //Pion.ORANGE
        Tuile t9 = new Tuile("Les Dunes de l’Illusion");
        Tuile t10 = new Tuile("Heliport");      //Pion.BLEU 
        Tuile t11= new Tuile("La Porte de Cuivre");  // Pion.VERT
        Tuile t12 = new Tuile("Le Jardin des Hurlements");
        Tuile t13 = new Tuile("La Foret Pourpre");
        Tuile t14 = new Tuile("Le Lagon Perdu");
        Tuile t15 = new Tuile("Le Marais Brumeux");
        Tuile t16 = new Tuile("Observatoire");
        Tuile t17 = new Tuile("Le Rocher Fantome");
        Tuile t18 = new Tuile("La Caverne du Brasier");
        Tuile t19 = new Tuile("Le Temple du Soleil");
        Tuile t20 = new Tuile("Le Temple de La Lune");
        Tuile t21 = new Tuile("Le Palais des Marees");
        Tuile t22 = new Tuile("Le Val du Crepuscule");
        Tuile t23 = new Tuile("La Tour du Guet");
        Tuile t24 = new Tuile("Le Jardin des Murmures");
        
        tuilesdepart = new ArrayList();
        
        tuilesdepart.add(t2);
        tuilesdepart.add(t4);
        tuilesdepart.add(t5);
        tuilesdepart.add(t8);
        tuilesdepart.add(t10);
        tuilesdepart.add(t11);
        
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
     
        grille.setTableau(lestuiles);
        
        
        joueurs = new ArrayList();
        setJoueurs();
        
        
        
        
        
        
        
        
        
    }
    
    @Override
    public void update(Observable arg0, Object arg1) {
        
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
    public void setJoueurs() {
        System.out.println("Combien y a t'il de joueurs ?");
        Scanner sc = new Scanner(System.in) ;
        int nbJ = sc.nextInt();
        while (nbJ >4 || nbJ < 2 ) {
             
             System.out.println("Le nombre de joueurs doit être compris entre 2 et 4 inclus");
             nbJ = sc.nextInt();
        }
        for(int i = 0 ; i<nbJ ; i++){
            System.out.println("Entrez votre nom");
            String nom = sc.next();
            System.out.println("Entrez votre role");
            String role = sc.next();
            while ( role.equals("plongeur")==false && role.equals("messager")==false && role.equals("navigateur")==false && role.equals("explorateur")==false && role.equals("ingenieur")==false && role.equals("pilote")==false ) {
               System.out.println("Le role n'existe pas veuillez choisir un role valide ");
               role = sc.nextLine();
            }
            if(role.equals("plongeur")){
                Plongeur p = new Plongeur(nom,tuilesdepart.get(1)); //Noir
                joueurs.add(p);
            }else if(role.equals("messager")){
                Messager m = new Messager(nom,tuilesdepart.get(3));  //Blanc
                joueurs.add(m);
            }else if(role.equals("navigateur")){
                Navigateur n = new Navigateur(nom,tuilesdepart.get(2)); // Jaune
                joueurs.add(n);
            }else if(role.equals("pilote")){
                Pilote pilote = new Pilote(nom,tuilesdepart.get(4)); // Bleu
                joueurs.add(pilote);
            }else if(role.equals("ingenieur")){
                  // Pion.ROUGE
                Ingenieur ing = new Ingenieur(nom,tuilesdepart.get(0)); //Rouge
                joueurs.add(ing);
            }else if(role.equals("explorateur")){
                Explorateur exp = new Explorateur(nom,tuilesdepart.get(5)); //Vert
                joueurs.add(exp);
            }
            
        }
        
    }
    
}