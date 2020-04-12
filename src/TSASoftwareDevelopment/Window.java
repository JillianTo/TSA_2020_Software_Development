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
    public static String levelInfo;
    public static String name;
    public static FillInTheBlanks fillInTheBlanks;
    public static Maze maze;
    public static MultipleChoice multipleChoice;
    public static StartPage startPage;
    public static Text text;
    public JButton backBtn;
    public JButton exitBtn;
    public JButton nextBtn;
    public JFrame frame;
    public JLabel levelLbl;
    public JLabel questionLbl;
    public JPanel levelPnl;
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
        // object instantiations
        frame = new JFrame();
        backBtn = new JButton("Back");
        exitBtn = new JButton("Return to Menu");
        nextBtn = new JButton("Next");
        levelLbl = new JLabel();
        questionLbl = new JLabel();
        levelPnl = new JPanel();
        
        // chooses what level the back button will go to
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Window.level > 0)
                    Window.levelDown();
                switch(Window.level) {
                    case 1:
                        Window.text = new Text();
                        Window.text.showWindow();
                        break;
                    default:
                        Window.startPage = new StartPage();
                        Window.startPage.showWindow();
                }
            }
        });
        
        // layout
        backBtn.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.825)), 
                ((int)(Window.windowWidth*0.1)), 
                ((int)(Window.windowHeight*0.1)));
        
        // exit button goes back to the start page
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getWindow().hideWindow();
                startPage.showWindow(); 
                
            }
        });
        
        // layout
        exitBtn.setBounds((int)(Window.windowWidth*0.9),
                (int)(Window.windowHeight*0.075), 
                (int)(Window.windowWidth*0.05),
                (int)(Window.windowHeight*0.05));
        
        // default next button behavior
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window.levelUp();
                Window.startPage = new StartPage();
                Window.startPage.showWindow();
            }
        });
        
        // layout
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
        
        // changes background color and level text depending on level variable
        switch(Window.level) {
            case 7:
                levelInfo = "Syntax"; // no reason for this to be here rather than StartPage other than to save having another switch statement
                levelLbl.setText("Level 2");
                levelPnl.setBackground(Color.GREEN);
                break;
            case 8:
                levelInfo = "Variables";
                levelLbl.setText("Level 3");
                levelPnl.setBackground(Color.ORANGE);
                break;
            case 9:
                levelInfo = "If Then Statements";
                levelLbl.setText("Level 4");
                levelPnl.setBackground(Color.YELLOW);
                break;
            case 10:
                levelInfo = "Loops";
                levelLbl.setText("Level 5");
                levelPnl.setBackground(Color.RED);
                break;    
            default:
                levelInfo = "Algorithms";
                levelLbl.setText("Level 1");
                levelPnl.setBackground(Color.CYAN);
        }
        
        // adds components to JFrame
        frame.add(backBtn);
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
    
    public static void levelUp() {
        level++; //add external save
    }
    
    public static void levelDown() {
        level--; //add external save
    }
}
