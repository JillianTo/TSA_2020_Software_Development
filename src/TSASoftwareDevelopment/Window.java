/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSASoftwareDevelopment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Font.SANS_SERIF;
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
    public static int level = 0; // placeholder, replace with level from save
    public static int windowWidth;
    public static int windowHeight;
    
    // objects
    public static String name;
    public static MultipleChoice multipleChoice;
    public static StartPage startPage;
    public JButton exitBtn;
    public JButton nextBtn;
    public JLabel levelLbl;
    public JLabel questionLbl;
    public JPanel levelPnl;
    public JFrame frame;
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
        exitBtn = new JButton("Return");
        nextBtn = new JButton("Next");
        levelLbl = new JLabel("Level " + Window.level);
        questionLbl = new JLabel();
        levelPnl = new JPanel();
        exitBtn.setBounds((int)(Window.windowWidth*0.9),
                (int)(Window.windowHeight*0.075), 
                (int)(Window.windowWidth*0.05),
                (int)(Window.windowHeight*0.05));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getWindow().hideWindow();
                startPage.showWindow(); 
                
            }
        });
        nextBtn.setBounds(((int)(Window.windowWidth*0.85)),
                ((int)(Window.windowHeight*0.825)), 
                ((int)(Window.windowWidth*0.1)), 
                ((int)(Window.windowHeight*0.1)));
        levelLbl.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.05)), Window.windowWidth,
                ((int)(Window.windowHeight*0.1)));
        levelLbl.setFont(new Font(SANS_SERIF, Font.BOLD, 72));
        questionLbl.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.25)), 
                ((int)(Window.windowWidth*0.8)),
                ((int)(Window.windowHeight*0.1)));
        questionLbl.setFont(new Font(SANS_SERIF, Font.PLAIN, 24));
        levelPnl.setBounds(0, 0, ((int)(Window.windowWidth*0.8)), 
                ((int)(Window.windowHeight*0.2)));
        switch(Window.level) {
            case 2:
                levelPnl.setBackground(Color.GREEN);
                break;
            case 3:
                levelPnl.setBackground(Color.ORANGE);
                break;
            case 4:
                levelPnl.setBackground(Color.YELLOW);
                break;
            case 5:
                levelPnl.setBackground(Color.RED);
                break;    
            default:
                levelPnl.setBackground(Color.CYAN);
        }
        frame.add(exitBtn);
        frame.add(nextBtn);
        frame.add(levelLbl);
        frame.add(questionLbl);
        frame.add(levelPnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null); // not necessary, just in case a layout change is wanted later
        frame.setUndecorated(true);
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
    
    public static void run() {
        startPage = new StartPage();
        startPage.showWindow();
    }
}
