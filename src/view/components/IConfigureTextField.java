/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

/**
 *
 * @author conde
 */
public interface IConfigureTextField {

    public abstract void setCharactersLimit(int charLimit, java.awt.event.KeyEvent evt);

    public abstract void validateCharacters(java.awt.event.KeyEvent evt);

}
