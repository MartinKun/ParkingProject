package view.components;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPasswordField;

public class InsertPasswordTextField extends JPasswordField implements IConfigureTextField, KeyListener, FocusListener {

	private static final long serialVersionUID = 1L;
	
	private final int CHAR_LIMIT = 10;

    public InsertPasswordTextField() {
        addKeyListener(this);
        addFocusListener(this);
    }

    @Override
    public void setCharactersLimit(int charLimit, KeyEvent evt) {
        if (String.valueOf(this.getPassword()).length() >= 10) {
            evt.consume();
        }
    }

    @Override
    public void validateCharacters(KeyEvent evt) {
    	if (evt.getKeyChar() == 32) {
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

		// get the password text
		String pass = String.valueOf(this.getPassword());
		if (pass.trim().toLowerCase().equals("password")) {
			this.setText("");
			this.setForeground(Color.black);
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		String pass = String.valueOf(this.getPassword());

		if (pass.trim().equals("") || pass.trim().toLowerCase().equals("password")) {
			this.setText("password");
			this.setForeground(new Color(153, 153, 153));
		}
		
	}

}
