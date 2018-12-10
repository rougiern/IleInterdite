/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import java.util.ArrayList;

/**
 *
 * @author kemplail
 */
public class appli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Grille g1 = new Grille();
        ArrayList<Tuile> lestuiles = new ArrayList();
        Tuile t1 = new Tuile("Le Pont des Abimes");
        Tuile t2 = new Tuile("La Porte de Bronze");  // Pion.ROUGE
        Tuile t3 = new Tuile("La Caverne des Ombres");
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
     
        g1.setTableau(lestuiles);
        
        Controleur c = new Controleur(g1);
        c.afficherJoueurs();
        c.afficherGrille();
        c.getJoueurs().get(0).seDeplacer(g1);
        
    }
    
}
