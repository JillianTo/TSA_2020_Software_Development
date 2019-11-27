/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsa.software.development;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author JTo
 */

public class StartPage extends Window {
    // objects
    JButton exitBtn;
    JLabel welcomeLbl;
    
    // constructor
    public StartPage() {
        super();
        createPage();
    }
    
    // user-defined constructor
    public StartPage(int windowWidth, int windowHeight) {
        super(windowWidth, windowHeight);
        createPage();
    }

    // creates page
    private void createPage() {
        exitBtn = new JButton("Exit");
        welcomeLbl = new JLabel("Welcome");
        exitBtn.setBounds(((int)(this.getWindowWidth()*0.85)),
                ((int)(this.getWindowHeight()*0.85)),
                ((int)(this.getWindowWidth()*0.1)),
                ((int)(this.getWindowHeight()*0.1))); // x-axis, y-axis, width, height
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.getJFrame().add(exitBtn);
        this.getJFrame().add(welcomeLbl);
        }
}
