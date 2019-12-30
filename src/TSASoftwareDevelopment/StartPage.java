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
    private JButton continueBtn;
    private JLabel welcomeLbl;
    private JCheckBox sectionA;
    private JCheckBox sectionB;
    private JCheckBox sectionC;
    private JProgressBar progressBar;
    private JPanel lessonPnl;
    
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
        continueBtn = new JButton("Continue");
        welcomeLbl = new JLabel("Welcome " + Window.name + "!");
        sectionA = new JCheckBox();
        sectionB = new JCheckBox();
        sectionC = new JCheckBox();
        progressBar = new JProgressBar(0, MAX_LEVEL);
        lessonPnl = new JPanel();
        continueBtn.setBounds(((int)(Window.windowWidth*0.6025)),
                ((int)(Window.windowHeight*0.7)), 
                ((int)(Window.windowWidth*0.05)), 
                ((int)(Window.windowHeight*0.05)));
        continueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(level) { // placeholder, change what window is opened depending on level
                    default:
                        Window.multipleChoice = new MultipleChoice();
                        Window.multipleChoice.showWindow();
                }
            }
        });
        welcomeLbl.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.05)), Window.windowWidth,
                ((int)(Window.windowHeight*0.1)));
        welcomeLbl.setFont(new Font(SANS_SERIF, Font.BOLD, 72));
        sectionA.setBounds(((int)(Window.windowWidth*0.075)),
                ((int)(Window.windowHeight*0.25)), 
                ((int)(Window.windowWidth*0.4)),
                ((int)(Window.windowHeight*0.1)));
        sectionA.setOpaque(false);
        sectionA.setFont(new Font(SANS_SERIF, Font.PLAIN, FONT_SIZE));
        listenersA = sectionA.getListeners(MouseListener.class);
        for (EventListener eventListener : listenersA) {
            sectionA.removeMouseListener((MouseListener) eventListener);
        }
        sectionB.setBounds(((int)(Window.windowWidth*0.075)),
                ((int)(Window.windowHeight*0.4375)), 
                ((int)(Window.windowWidth*0.4)),
                ((int)(Window.windowHeight*0.1)));
        sectionB.setOpaque(false);
        sectionB.setFont(new Font(SANS_SERIF, Font.PLAIN, FONT_SIZE));
        listenersB = sectionB.getListeners(MouseListener.class);
        for (EventListener eventListener : listenersB) {
            sectionB.removeMouseListener((MouseListener) eventListener);
        }
        sectionC.setBounds(((int)(Window.windowWidth*0.075)),
                ((int)(Window.windowHeight*0.625)), 
                ((int)(Window.windowWidth*0.4)),
                ((int)(Window.windowHeight*0.1)));
        sectionC.setOpaque(false);
        sectionC.setFont(new Font(SANS_SERIF, Font.PLAIN, FONT_SIZE));
        switch(Window.level) { // placeholder, change lesson text and what boxes are checked depending on level
            default:
                sectionA.setText("Basics 1");
                sectionB.setText("Basics 2");
                sectionC.setText("Basics 3");
        }
        listenersC = sectionC.getListeners(MouseListener.class);
        for (EventListener eventListener : listenersC) {
            sectionC.removeMouseListener((MouseListener) eventListener);
        }
        sectionC.setFocusable(false);
        progressBar.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.875)), 
                ((int)(Window.windowWidth*0.2)), 
                ((int)(Window.windowHeight*0.05)));
        progressBar.setValue(Window.level);
        progressBar.setStringPainted(true);
        lessonPnl.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.2)), 
                ((int)(Window.windowWidth*0.5)), 
                ((int)(Window.windowHeight*0.6)));
        lessonPnl.setBackground(Color.LIGHT_GRAY);
        levelPnl.setBounds(((int)(Window.windowWidth*0.5)),
                ((int)(Window.windowHeight*0.2)), 
                ((int)(Window.windowWidth*0.2)), 
                ((int)(Window.windowHeight*0.6)));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitBtn.setText("Exit");
        frame.remove(levelPnl); // done so that this panel doesn't go over the continue button
        frame.add(continueBtn);
        frame.add(welcomeLbl);
        frame.add(sectionA);
        frame.add(sectionB);
        frame.add(sectionC);
        frame.add(progressBar);
        frame.add(lessonPnl);
        frame.add(levelPnl);
        frame.remove(nextBtn);
        frame.remove(levelLbl);
        frame.remove(questionLbl);
        }
}
