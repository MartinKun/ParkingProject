/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class InsertUserTextField extends JTextField implements IConfigureTextField, KeyListener, FocusListener{

	private static final long serialVersionUID = 1L;
	private final int CHAR_LIMIT = 10;
    
    public InsertUserTextField(){
        addKeyListener(this);
        addFocusListener(this);
    }

    @Override
    public void validateCharacters(KeyEvent evt) {

        if (evt.getKeyChar() >= 32 && evt.getKeyChar() <= 44
                || evt.getKeyChar() == 46
                || evt.getKeyChar() == 47
                || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 64
                || evt.getKeyChar() >= 91 && evt.getKeyChar() <= 94
                || evt.getKeyChar() == 96
                || evt.getKeyChar() >= 123) {
            evt.consume();
        }

    }

    @Override
    public void setCharactersLimit(int charLimit, KeyEvent evt) {
        if (this.getText().length() >= 10) {
            evt.consume();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        validateCharacters(e);
        setCharactersLimit(CHAR_LIMIT, e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

	@Override
	public void focusGained(FocusEvent e) {
		// clear the textfield on focus if the text is "username"
		if (this.getText().trim().toLowerCase().equals("username")) {
			this.setText("");
			this.setForeground(Color.black);
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.getText().trim().equals("") || this.getText().trim().toLowerCase().equals("username")) {
			this.setText("username");
			this.setForeground(new Color(153, 153, 153));
		}
		
	}

}
