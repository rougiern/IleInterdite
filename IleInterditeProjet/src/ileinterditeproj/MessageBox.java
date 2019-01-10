package ileinterditeproj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


/**
 *
 * @author IUT2-Dept Info
 */
public class MessageBox {
    private final JFrame window ;
    private final JEditorPane html ;
    private final JScrollPane scrollPane;
    String texte ;
    private final JPanel panelZephyr;
    private final JPanel panelCalice;
    private final JPanel panelCristal;
    private final JPanel panelPierre;
    
    public MessageBox() {
        window = new JFrame() ;
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setLocation(940, Parameters.TOP_AUTRES_VUES);
        window.setSize(310, Parameters.HAUTEUR_AUTRES_VUES);
        window.setUndecorated(Parameters.UNDECORATED);
        window.setResizable(Parameters.RESIZABLE);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);
        
        JPanel panelTresors = new JPanel(new GridLayout(1,4));
        mainPanel.add(panelTresors, BorderLayout.NORTH);
        
        this.panelZephyr = new JPanel();
        panelZephyr.setBackground(Utils.Tresor.ZEPHYR.getBgColor());
        panelZephyr.add(new JLabel(Utils.Tresor.ZEPHYR.name(), JLabel.CENTER));
        panelTresors.add(panelZephyr);
        panelZephyr.setVisible(false);
        
        this.panelCalice = new JPanel();
        panelCalice.setBackground(Utils.Tresor.CALICE.getBgColor());
        panelCalice.add(new JLabel(Utils.Tresor.CALICE.name(), JLabel.CENTER));
        panelTresors.add(panelCalice);
        panelCalice.setVisible(false);
        
        this.panelCristal = new JPanel();
        panelCristal.setBackground(Utils.Tresor.CRISTAL.getBgColor());
        panelCristal.add(new JLabel(Utils.Tresor.CRISTAL.name(), JLabel.CENTER));
        panelTresors.add(panelCristal);
        panelCristal.setVisible(false);
        
        this.panelPierre = new JPanel();
        panelPierre.setBackground(Utils.Tresor.PIERRE.getBgColor());
        panelPierre.add(new JLabel(Utils.Tresor.PIERRE.name(), JLabel.CENTER));
        panelTresors.add(panelPierre);
        panelPierre.setVisible(false);
        
        html = new JEditorPane();
        html.setContentType("text/html");
        scrollPane = new JScrollPane(html);
        this.scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
        
        html.setMinimumSize(new Dimension(180, 280));
        html.setPreferredSize(new Dimension(180, 280));
        scrollPane.setPreferredSize(new Dimension(180, 280));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setMinimumSize(new Dimension(180, 280));
        
        html.setText("<html><h1 style=\"text-align:center; color:blue;\">Bienvenue dans<br>l'Île Interdite</h1></html>");
        mainPanel.add(scrollPane, BorderLayout.CENTER) ;
        
        window.setVisible(true);
        
        this.texte = "" ;
    }
    
    public void displayMessage(String texte, Color couleur, Boolean precederDunTrait, Boolean garderCouleur) {
        html.setText("<html>" + (precederDunTrait ? "<hr>" : "") + this.texte + "<div style=\"color : " + toRGB(couleur) + "\">"+ texte + "</div></html>");
        if (garderCouleur)
            this.texte += "<div style=\"color : " + toRGB(couleur) + "\">" + (precederDunTrait ? "<hr>" : "") + texte + "</div>" ;
        else 
            this.texte += "<div>" + (precederDunTrait ? "<hr>" : "") + texte + "</div>" ;
    }
    
    public void displayAlerte(String texte) {
        this.texte += "<div style=\"color : " + toRGB(Color.RED) + "\"><b>" + texte + "</b></div>" ;
        html.setText("<html>" + this.texte +  "</html>");
    }
    
    public String toRGB(Color couleur) {
        return "#"+Integer.toHexString(couleur.getRGB()).substring(2);
    }

    public void setZephyrVisible() {
        this.panelZephyr.setVisible(true);
        this.displayMessage("Vous avez gagné le " + Utils.Tresor.ZEPHYR.toString(), Utils.Tresor.ZEPHYR.getBgColor(), false, true);
    }

    public void setPierreVisible() {
        this.panelPierre.setVisible(true);
        this.displayMessage("Vous avez gagné la " + Utils.Tresor.PIERRE.toString(), Utils.Tresor.PIERRE.getBgColor(), false, true);
    }

    public void setCaliceVisible() {
        this.panelCalice.setVisible(true);
        this.displayMessage("Vous avez gagné le " + Utils.Tresor.CALICE.toString(), Utils.Tresor.CALICE.getBgColor(), false, true);
    }

    public void setCristalVisible() {
        this.panelCristal.setVisible(true);
        this.displayMessage("Vous avez gagné le "  + Utils.Tresor.CRISTAL.toString(), Utils.Tresor.CRISTAL.getBgColor(), false, true);
    }

    public void displayTresor(Utils.Tresor tresor) {
        switch(tresor) {
            case ZEPHYR :
                setZephyrVisible();
                break ;
            case PIERRE :
                setPierreVisible();
                break;
            case CALICE :
                setCaliceVisible();
                break;
            case CRISTAL :
                setCristalVisible();
                break;
        }
    }

    public static void main(String[] args) {   
        MessageBox messageBox = new MessageBox();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Afficher un message, appuyer sur Entrée");
        String suite = scanner.nextLine();
        messageBox.displayMessage("C'est à Manon de joueur", Color.blue, Boolean.TRUE, false);
        messageBox.displayMessage("Manon peut se déplacer sur les tuiles <ul><li>Héliport</li><li>Jardin des Murmures</li><li>La Porte d'Argent</li></ul>", Color.blue, false, false);
        messageBox.displayMessage("Manon s'est déplacé vers Héliport", Color.blue, false, false);
        messageBox.displayMessage("Manon peut se déplacer vers...", Color.blue, false, false);

        System.out.println("Afficher un message, appuyer sur Entrée");
        suite = scanner.nextLine();
        messageBox.displayMessage("C'est à Pierre de joueur", Color.blue, Boolean.TRUE, false);
        messageBox.displayMessage("Pierre peut se déplacer sur les tuiles <ul><li>Héliport</li><li>Jardin des Murmures</li><li>La Porte d'Argent</li></ul>", Color.blue, false, false);
        messageBox.displayMessage("Pierre s'est déplacé vers Héliport", Color.blue, false, false);
        messageBox.displayMessage("Pierre peut se déplacer vers...", Color.blue, false, false);
        messageBox.displayMessage("C'est à Paul de joueur", Color.blue, Boolean.TRUE, false);
        messageBox.displayMessage("Paul peut se déplacer sur les tuiles <ul><li>Héliport</li><li>Jardin des Murmures</li><li>La Porte d'Argent</li></ul>", Color.blue, false, false);
        messageBox.displayMessage("Paul s'est déplacé vers Héliport", Color.blue, false, false);
        messageBox.displayMessage("Paul peut se déplacer vers...", Color.blue, false, false);
        messageBox.displayMessage("C'est à Jean de joueur", Color.blue, Boolean.TRUE, false);
        messageBox.displayMessage("Jean peut se déplacer sur les tuiles <ul><li>Héliport</li><li>Jardin des Murmures</li><li>La Porte d'Argent</li></ul>", Color.blue, false, false);
        messageBox.displayMessage("Jean s'est déplacé vers Héliport", Color.blue, false, false);
        messageBox.displayMessage("Jean peut se déplacer vers...", Color.blue, false, false);

        System.out.println("Afficher une alerte, appuyer sur Entrée");
        suite = scanner.nextLine();
        messageBox.displayAlerte("Vous avez tiré une carte Montée des Eaux");

        System.out.println("Afficher le Calice, appuyer sur Entrée");
        suite = scanner.nextLine();
        messageBox.setCaliceVisible();

        System.out.println("Afficher la Pierre, appuyer sur Entrée");
        suite = scanner.nextLine();
        messageBox.setPierreVisible();

        System.out.println("Afficher le Zéphyr, appuyer sur Entrée");
        suite = scanner.nextLine();
        messageBox.setZephyrVisible();

        System.out.println("Afficher le Cristal, appuyer sur Entrée");
        suite = scanner.nextLine();
        messageBox.setCristalVisible();
    }
}
