/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author davidpa
 */
public class PanelImage  extends JPanel {
    private Image image ;
    private Integer width, height ;
    
    
    public PanelImage(int width, int height,Image image) {
        super();
        this.height = height;
        this.width = width;
        this.image = image;
        
        
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(this.image,0,0,600,300,this);
    }
}
