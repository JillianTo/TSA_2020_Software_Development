/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSASoftwareDevelopment;

import javax.swing.*;

/**
 *
 * @author Jillian To
 */
public class SettingsPage extends Window {
    // objects
    private JButton resetBtn;
    
    // no-args constructor
    public SettingsPage() {
        super();
        this.getSettingsBtn().setVisible(false);
        createPage();
    }
    
    private void createPage() {
        resetBtn = new JButton("Reset");
    }
}
