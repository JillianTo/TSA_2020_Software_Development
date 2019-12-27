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
    static int level = 1; // placeholder, replace with level from save
    static int windowWidth;
    static int windowHeight;
    
    // objects
    static String name;
    private JFrame frame;
    static JButton exitBtn;
    static Window currentWindow;
    private Window nextWindow;
    private StartPage startPage;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    // no-args constructor
    public Window() {
        windowWidth = (int)screenSize.getWidth();
        windowHeight = (int)screenSize.getHeight();
        createPage();
    }
    
    
    
    // user-defined resolution constructor
    public Window(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        createPage();
    }
    
    // user-defined start page constructor
    public Window(StartPage startPage) {
        this.startPage = startPage;
        createPage();
    }
    
    // user-defined start page and resolution constructor
    public Window(int windowWidth, int windowHeight, StartPage startPage) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.startPage = startPage;
        createPage();
    }
    
    // creates page
    private void createPage() {
        frame = new JFrame(); 
        exitBtn = new JButton("Exit");
        exitBtn.setBounds((int)(Window.windowWidth*0.9),
                (int)(Window.windowHeight*0.075), 
                (int)(Window.windowWidth*0.05),
                (int)(Window.windowHeight*0.05));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(exitBtn);
        frame.setLayout(null); // placeholder
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Window.currentWindow = this;
    }
    
    // returns JFrame
    public JFrame getFrame() {
        return frame;
    }
    
    public Window getNextWindow() {
        return nextWindow;
    }
    
    public void showPage() {
        frame.setVisible(true);
    }
    
    public void hidePage() {
        frame.setVisible(false);
    }
    
    public void linkWindows(Window nextWindow) {
        this.nextWindow = nextWindow;
    }
}
