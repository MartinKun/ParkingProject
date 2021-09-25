/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author conde
 */
public class CustomPaintedPanel extends JPanel{
    
    private String fileName;
    private Image image;

    public CustomPaintedPanel(String fileName) {
        this.fileName = fileName;
    }
    
    public void paint (Graphics g){
        image = new ImageIcon(getClass().getResource(fileName)).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
