/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSASoftwareDevelopment;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.SANS_SERIF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.EventListener;
import javax.swing.*;

/**
 *
 * @author Jillian To
 */

public class StartPage extends Window {
    // primitives
    private final int FONT_SIZE = 64;
    private final int MAX_LEVEL = 10; // placeholder, replace with actual max level
    
    // objects
    private EventListener[] listenersA;
    private EventListener[] listenersB;
    private EventListener[] listenersC;
    private JButton continueBtn; // using nextBtn for this function doesn't work
    private JCheckBox sectionA;
    private JCheckBox sectionB;
    private JCheckBox sectionC;
    private JLabel levelInfoLbl;
    private JLabel welcomeLbl;
    private JPanel lessonPnl;
    private JProgressBar progressBar;
    
    // no-args constructor
    public StartPage() {
        super();
        createWindow();
    }
    
    // user-defined resolution constructor
    public StartPage(int windowWidth, int windowHeight) {
        super(windowWidth, windowHeight);
        createWindow();
    }

    // creates window
    private void createWindow() {
        // object instantiations
        continueBtn = new JButton("Continue");
        sectionA = new JCheckBox();
        sectionB = new JCheckBox();
        sectionC = new JCheckBox();
        levelInfoLbl = new JLabel();
        welcomeLbl = new JLabel("Welcome " + Window.name + "!");
        lessonPnl = new JPanel();
        progressBar = new JProgressBar(0, MAX_LEVEL);
        
        // remove listeners on check boxes so user can't manually check them
        listenersA = sectionA.getListeners(MouseListener.class);
        for (EventListener eventListener : listenersA) {
            sectionA.removeMouseListener((MouseListener) eventListener);
        }
        listenersB = sectionB.getListeners(MouseListener.class);
        for (EventListener eventListener : listenersB) {
            sectionB.removeMouseListener((MouseListener) eventListener);
        }
        listenersC = sectionC.getListeners(MouseListener.class);
        for (EventListener eventListener : listenersC) {
            sectionC.removeMouseListener((MouseListener) eventListener);
        }
        
        // makes exit button quit the program
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitBtn.setText("Exit");
        
        // chooses what level the continue button will open
        continueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(level) { 
                    case 0:
                        Window.text = new Text();
                        Window.text.showWindow();
                        break;
                    case 1:
                        Window.fillInTheBlanks = new FillInTheBlanks();
                        Window.fillInTheBlanks.showWindow();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Corrupted save, "
                                + "please exit the program and delete your save"
                                + " file to regenerate it.");
                }
            }
        });
        
        // layout
        continueBtn.setBounds(((int)(Window.windowWidth*0.6025)),
                ((int)(Window.windowHeight*0.7)), 
                ((int)(Window.windowWidth*0.05)), 
                ((int)(Window.windowHeight*0.05)));
        sectionA.setBounds(((int)(Window.windowWidth*0.075)),
                ((int)(Window.windowHeight*0.25)), 
                ((int)(Window.windowWidth*0.4)),
                ((int)(Window.windowHeight*0.1)));
        sectionA.setFont(new Font(SANS_SERIF, Font.PLAIN, FONT_SIZE));
        sectionA.setOpaque(false);
        sectionB.setBounds(((int)(Window.windowWidth*0.075)),
                ((int)(Window.windowHeight*0.4375)), 
                ((int)(Window.windowWidth*0.4)),
                ((int)(Window.windowHeight*0.1)));
        sectionB.setFont(new Font(SANS_SERIF, Font.PLAIN, FONT_SIZE));
        sectionB.setOpaque(false);
        sectionC.setBounds(((int)(Window.windowWidth*0.075)),
                ((int)(Window.windowHeight*0.625)), 
                ((int)(Window.windowWidth*0.4)),
                ((int)(Window.windowHeight*0.1)));
        sectionC.setFocusable(false); // don't remember what this was for
        sectionC.setFont(new Font(SANS_SERIF, Font.PLAIN, FONT_SIZE));
        sectionC.setOpaque(false);
        
        // change lesson text and what boxes are checked depending on level
        switch(Window.level) { 
            default:
                sectionA.setText("Basics 1");
                sectionB.setText("Basics 2");
                sectionC.setText("Basics 3");
        }
        switch(Window.level) {
            case 2:
                sectionA.setSelected(true);
                sectionB.setSelected(false);
                sectionC.setSelected(false);
                break;
            default:
                sectionA.setSelected(false);
                sectionB.setSelected(false);
                sectionC.setSelected(false);
        }
        
        // layout
        levelLbl.setBounds(((int)(Window.windowWidth*0.58)),
                ((int)(Window.windowHeight*0.1)), 
                ((int)(Window.windowWidth*0.2)), 
                ((int)(Window.windowHeight*0.6)));
        levelInfoLbl.setBounds(((int)(Window.windowWidth*0.595)),
                ((int)(Window.windowHeight*0.25)), 
                ((int)(Window.windowWidth*0.2)), 
                ((int)(Window.windowHeight*0.6)));
        levelInfoLbl.setFont(new Font(SANS_SERIF, Font.PLAIN, 32));
        levelInfoLbl.setText(Window.levelInfo);
        
        // layout
        welcomeLbl.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.05)), Window.windowWidth,
                ((int)(Window.windowHeight*0.1)));
        welcomeLbl.setFont(new Font(SANS_SERIF, Font.BOLD, 72));
        lessonPnl.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.2)), 
                ((int)(Window.windowWidth*0.5)), 
                ((int)(Window.windowHeight*0.6)));
        lessonPnl.setBackground(Color.LIGHT_GRAY);
        levelPnl.setBounds(((int)(Window.windowWidth*0.5)),
                ((int)(Window.windowHeight*0.2)), 
                ((int)(Window.windowWidth*0.2)), 
                ((int)(Window.windowHeight*0.6)));
        progressBar.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.875)), 
                ((int)(Window.windowWidth*0.2)), 
                ((int)(Window.windowHeight*0.05)));
        progressBar.setStringPainted(true);
        progressBar.setValue(Window.level);
        
        // adds components to JFrame
        frame.remove(levelPnl); // done so that this panel doesn't go over the continue button
        frame.add(continueBtn);
        frame.add(sectionA);
        frame.add(sectionB);
        frame.add(sectionC);
        frame.add(levelLbl);
        frame.add(levelInfoLbl);
        frame.add(welcomeLbl);
        frame.add(lessonPnl);
        frame.add(levelPnl);
        frame.add(progressBar);
        frame.remove(backBtn);
        frame.remove(nextBtn);
        frame.remove(questionLbl);
        }
}
