package view.components;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import helpers.FontHelper;

public class EnterVehiclePlateTextField extends JTextField implements IConfigureTextField, KeyListener{
	
    private final int CHAR_LIMIT = 10;
	
	public EnterVehiclePlateTextField() {
        addKeyListener(this);
        
        FontHelper fontHelper = new FontHelper();
        this.setFont(fontHelper.addFont("../resources/fonts/LicensePlate.ttf", Font.PLAIN, 48));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		setCharactersLimit(CHAR_LIMIT, e);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharactersLimit(int charLimit, KeyEvent evt) {
        if (this.getText().length() >= 10) {
            evt.consume();
        }
		
	}

	@Override
	public void validateCharacters(KeyEvent evt) {
		// TODO Auto-generated method stub
		
	}

}
