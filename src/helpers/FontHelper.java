package helpers;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Font;
import java.io.InputStream;


public class FontHelper {

    public Font addFont(String fontName, int fontStyle, float fontSize) {
        Font font;
        try {
            InputStream is = getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            
        } catch (Exception e) {
            System.err.println(fontName + "Font not found.");
            font = new Font("Arial",Font.PLAIN, 14);
        }
        return font.deriveFont(fontStyle,fontSize);
    }

}
