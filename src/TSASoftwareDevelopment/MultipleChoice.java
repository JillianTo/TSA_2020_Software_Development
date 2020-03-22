/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSASoftwareDevelopment;

import java.awt.Font;
import static java.awt.Font.SANS_SERIF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jillian To
 */
public class MultipleChoice extends Window {
    // primitives
    private final int FONT_SIZE = 16;
    
    // objects
    private JRadioButton aBtn;
    private JRadioButton bBtn;
    private JRadioButton cBtn;
    private JRadioButton dBtn;
    private ButtonGroup mcGroup;
    
    // user-defined start page constructor
    public MultipleChoice() {
        super();
        createWindow();
    }
    
    // create window
    private void createWindow() {
        aBtn = new JRadioButton();
        bBtn = new JRadioButton();
        cBtn = new JRadioButton();
        dBtn = new JRadioButton();
        mcGroup = new ButtonGroup();
        mcGroup.add(aBtn);
        mcGroup.add(bBtn);
        mcGroup.add(cBtn);
        mcGroup.add(dBtn);
        switch(Window.level) { // placeholder, change question text depending on level
            default:
                questionLbl.setText("Question");
        }
        aBtn.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.55)), 
                ((int)(Window.windowWidth*0.75)), 
                ((int)(Window.windowHeight*0.1)));
        aBtn.setFont(new Font(SANS_SERIF, Font.PLAIN, FONT_SIZE));
        bBtn.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.65)), 
                ((int)(Window.windowWidth*0.75)), 
                ((int)(Window.windowHeight*0.1)));
        bBtn.setFont(new Font(SANS_SERIF, Font.PLAIN, FONT_SIZE));
        cBtn.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.75)), 
                ((int)(Window.windowWidth*0.75)), 
                ((int)(Window.windowHeight*0.1)));
        cBtn.setFont(new Font(SANS_SERIF, Font.PLAIN, FONT_SIZE));
        dBtn.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.85)), 
                ((int)(Window.windowWidth*0.75)), 
                ((int)(Window.windowHeight*0.1)));
        dBtn.setFont(new Font(SANS_SERIF, Font.PLAIN, FONT_SIZE));
        switch(Window.level) { // placeholder, change answer text depending on level
            default:
                aBtn.setText("A");
                bBtn.setText("B");
                cBtn.setText("C");
                dBtn.setText("D");
        }
         nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(Window.level) { // placeholder, change correct answer depending on level
                    default:
                        if(aBtn.isSelected()) {
                            Window.level++; // add external save
                            JOptionPane.showMessageDialog(null, "Correct, good "
                                    + "job!");
                            Window.startPage = new StartPage();
                            Window.startPage.showWindow();
                        } else
                            JOptionPane.showMessageDialog(null, "Incorrect, try"
                                    + " again.");
                }
            }
        });
        nextBtn.setText("Check Answer");
        frame.add(aBtn);
        frame.add(bBtn);
        frame.add(cBtn);
        frame.add(dBtn);
    }

}
