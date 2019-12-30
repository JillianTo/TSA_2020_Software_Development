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
    static MultipleChoice multipleChoice;
    static StartPage startPage;
    public JButton continueBtn;
    public JButton exitBtn;
    private JFrame frame;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    // no-args constructor
    public Window() {
        windowWidth = (int)screenSize.getWidth();
        windowHeight = (int)screenSize.getHeight();
        createWindow();
    }
    
    // user-defined resolution constructor
    public Window(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        createWindow();
    }
    
    // creates window
    private void createWindow() {
        frame = new JFrame(); 
        continueBtn = new JButton("Continue");
        exitBtn = new JButton("Exit");
        continueBtn.setBounds(((int)(Window.windowWidth*0.605)),
                ((int)(Window.windowHeight*0.7)), 
                ((int)(Window.windowWidth*0.05)), 
                ((int)(Window.windowHeight*0.05)));
        continueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(level) { // placeholder, change what window is opened depending on level
                    default:
                        multipleChoice = new MultipleChoice();
                        multipleChoice.showWindow();
                }
            }
        });
        exitBtn.setBounds((int)(Window.windowWidth*0.9),
                (int)(Window.windowHeight*0.075), 
                (int)(Window.windowWidth*0.05),
                (int)(Window.windowHeight*0.05));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                continueBtn.setVisible(true);
                getWindow().hideWindow();
                startPage.showWindow(); 
                
            }
        });
        frame.add(continueBtn);
        frame.add(exitBtn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null); // not necessary, just in case a layout change is wanted later
        frame.setUndecorated(true);
    }
    
    // returns JFrame
    public JFrame getFrame() {
        return frame;
    }
    
    public Window getWindow() {
        return this;
    }
    
    public void showWindow() {
        frame.setVisible(true);
    }
    
    public void hideWindow() {
        frame.setVisible(false);
    }
    
    public void resetWindow() {
        frame.dispose();
        createWindow();
    }
    
    public static void run() {
        startPage = new StartPage();
        startPage.showWindow();
    }
}
