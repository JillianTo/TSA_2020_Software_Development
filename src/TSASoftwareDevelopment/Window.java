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
    
    // objects
    private JFrame frame;
    private JFrame frame2;
    private JFrame settingsPage;
    private JButton exitBtn;
    private JButton settingsBtn;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static String name;
    
    // no-args constructor
    public Window() {
        createPage();
    }
    
    // user-defined constructor
    public Window(Window frame2, SettingsPage settingsPage) {
        this.frame2 = frame2;
        this.settingsPage = settingsPage;
        createPage();
    }

    // creates page
    private void createPage() {
        windowWidth = (int)screenSize.getWidth();
        System.out.println(windowWidth);
        windowHeight = (int)screenSize.getHeight();
        System.out.println(windowHeight);
        frame = new JFrame(); 
        exitBtn = new JButton("Exit");
        settingsBtn = new JButton("Settings");
        exitBtn.setBounds((int)(windowWidth*0.85), (int)(windowHeight*0.85),
                (int)(windowWidth*0.1), (int)(windowHeight*0.1)); // x-axis, y-axis, width, height
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        settingsBtn.setBounds((int)(windowWidth*0.9),
                (int)(windowHeight*0.07), (int)(windowWidth*0.05),
                (int)(windowHeight*0.05));
        settingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                settingsPage.setVisible(true);
            }
        });
        frame.add(exitBtn);
        frame.add(settingsBtn);
        frame.setLayout(null); // placeholder
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    }
    
    // returns JFrame
    public JFrame getJFrame() {
        return frame;
    }
    
    // returns settings button
    public JButton getSettingsBtn() {
        return settingsBtn;
    }
}
