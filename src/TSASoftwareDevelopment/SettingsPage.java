/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSASoftwareDevelopment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jillian To
 */
public class SettingsPage extends Window {
    // objects
    private JButton exitBtn;
    private JButton resetBtn;
    private JButton windowSettingBtn;
    private JButton returnBtn;
    private JLabel horResLbl;
    private JLabel vertResLbl;
    private JTextField windowWidthFld;
    private JTextField windowHeightFld;
    
    // no-args constructor
    public SettingsPage() {
        super();
        createPage();
    }
    
    private void createPage() {
        exitBtn = new JButton("Exit");
        resetBtn = new JButton("Reset");
        windowSettingBtn = new JButton("Minimize");
        returnBtn = new JButton("Return");
        horResLbl = new JLabel("Horizontal Resolution");
        vertResLbl = new JLabel("Vertical Resolution");
        windowWidthFld = new JTextField();
        windowHeightFld = new JTextField();
        exitBtn.setBounds((int)(Window.windowWidth*0.85), 
                (int)(Window.windowHeight*0.85), (int)(Window.windowWidth*0.1), 
                (int)(Window.windowHeight*0.1)); // x-axis, y-axis, width, height
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        resetBtn.setBounds((int)(Window.windowWidth*0.05), 
                (int)(Window.windowHeight*0.9), (int)(Window.windowWidth*0.05), 
                (int)(Window.windowHeight*0.05)); // x-axis, y-axis, width, height
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Unimplemented");
            }
        });
        windowSettingBtn.setBounds((int)(Window.windowWidth*0.5),
                (int)(Window.windowHeight*0.4), (int)(Window.windowWidth*0.05),
                (int)(Window.windowHeight*0.05));
        windowSettingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Window.isMinimized) 
                    fullscreenAll();
                else
                    minimizeAll();
            }
        });
        returnBtn.setBounds((int)(Window.windowWidth*0.9),
                (int)(Window.windowHeight*0.07), (int)(Window.windowWidth*0.05),
                (int)(Window.windowHeight*0.05));
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hidePage();
                currentWindow.showPage();
            }
        });
        windowWidthFld.setBounds((int)(Window.windowWidth*0.05), 
                (int)(Window.windowHeight*0.1), (int)(Window.windowWidth*0.05), 
                (int)(Window.windowHeight*0.03));
        windowWidthFld.setEditable(true);
        windowHeightFld.setBounds((int)(Window.windowWidth*0.05), 
                (int)(Window.windowHeight*0.25), (int)(Window.windowWidth*0.05), 
                (int)(Window.windowHeight*0.03));
        windowHeightFld.setEditable(true);
        this.getSettingsBtn().setVisible(false);
        this.getJFrame().add(exitBtn);
        this.getJFrame().add(resetBtn);
        this.getJFrame().add(windowSettingBtn);
        this.getJFrame().add(returnBtn);
        this.getJFrame().add(windowWidthFld);
        this.getJFrame().add(windowHeightFld);
    }
    
    private void minimizeAll() { // add all windows into here
        Window.windowWidth = Integer.parseInt(windowWidthFld.getText()); //placeholder, replace with user-defined
        Window.windowHeight = Integer.parseInt(windowHeightFld.getText()); //placeholder, replace with user-defined
        Window.isMinimized = true;
        windowSettingBtn.setText("Fullscreen");
        this.minimize(Window.windowWidth, Window.windowHeight);
        this.getWindow().minimize(Window.windowWidth, Window.windowHeight);
    }
    
    private void fullscreenAll() { // add all windows into here
        Window.isMinimized = false;
        windowSettingBtn.setText("Minimize");
        this.fullscreen();
        this.getWindow().fullscreen();
    }
}
