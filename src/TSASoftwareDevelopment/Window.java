/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSASoftwareDevelopment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jillian To
 */
public class Window extends JFrame {
    // primitives
    static int windowWidth;
    static int windowHeight;
    static boolean isMinimized = false;
    
    // objects
    static String name;
    private JFrame frame;
    static Window currentWindow;
    private Window window;
    private SettingsPage settingsPage;
    private JButton settingsBtn;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    // no-args constructor
    public Window() {
        windowWidth = (int)screenSize.getWidth();
        windowHeight = (int)screenSize.getHeight();
        createPage();
        fullscreen();
    }

    public Window(SettingsPage settingsPage) {
        windowWidth = (int)screenSize.getWidth();
        windowHeight = (int)screenSize.getHeight();
        this.settingsPage = settingsPage;
        createPage();
        fullscreen();
    }
    
    // creates page
    private void createPage() {
        frame = new JFrame(); 
        settingsBtn = new JButton("Settings");
        settingsBtn.setBounds((int)(windowWidth*0.9),
                (int)(windowHeight*0.07), (int)(windowWidth*0.05),
                (int)(windowHeight*0.05));
        settingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hidePage();
                settingsPage.showPage();
            }
        });
        frame.add(settingsBtn);
        frame.setLayout(null); // placeholder
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // returns JFrame
    public JFrame getJFrame() {
        return frame;
    }
    
    public Window getWindow() {
        return window;
    }
    
    // returns settings button
    public JButton getSettingsBtn() {
        return settingsBtn;
    }
    
    public void showPage() {
        frame.setVisible(true);
    }
    
    public void hidePage() {
        frame.setVisible(false);
    }
    
    public void fullscreen() {
        frame.dispose();
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        showPage();
    }
    
    public void minimize(int windowWidth, int windowHeight) {
        frame.dispose();
        frame.setUndecorated(false);
        frame.setSize(windowWidth, windowHeight); // doesn't currently work
        showPage();
    }
    
    public void linkWindows(Window window) {
        this.window = window;
    }
}
