/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import java.awt.Color;

/**
 *
 * @author duttod
 */
public enum Pion {
        ROUGE("Rouge", new Color(255, 0, 0)),
        VERT("Vert", new Color(0, 195, 0)),
        BLEU("Bleu", new Color(55,194,198)),
	BLANC("BLANC", new Color(255, 255, 255)),
	NOIR("NOIR", new Color(0, 0, 0)),
	JAUNE("Jaune", new Color(255, 255, 0)) ;

        private final String libelle ;
	private final Color couleur ;


	Pion (String libelle, Color couleur) {
            this.libelle = libelle ;
            this.couleur = couleur ;
        }
        
        public String toString(){
            
            return this.libelle;
        }
        
        public Color getCouleur(){
            
            return this.couleur;
        }

}

