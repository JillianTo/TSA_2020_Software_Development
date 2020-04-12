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
    private ButtonGroup mcGroup;
    private JRadioButton aBtn;
    private JRadioButton bBtn;
    private JRadioButton cBtn;
    private JRadioButton dBtn;
    
    // no-args constructor
    public MultipleChoice() {
        super();
        createWindow();
    }
    
    // create window
    private void createWindow() {
        // object instantiations
        mcGroup = new ButtonGroup();
        aBtn = new JRadioButton();
        bBtn = new JRadioButton();
        cBtn = new JRadioButton();
        dBtn = new JRadioButton();
        
        // adds radio buttons to button group
        mcGroup.add(aBtn);
        mcGroup.add(bBtn);
        mcGroup.add(cBtn);
        mcGroup.add(dBtn);
        
        // checks answer and picks what level the next button will go to
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(Window.level) { // placeholder, change correct answer depending on level
                    case 2:
                        if(bBtn.isSelected()) {
                            Window.levelUp();
                            JOptionPane.showMessageDialog(null, "Correct, good "
                                    + "job!");
                            Window.text = new Text();
                            Window.text.showWindow();
                        } else
                            JOptionPane.showMessageDialog(null, "Incorrect, try"
                                    + " again.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Corrupted save, "
                                + "please exit the program and delete your save"
                                + " file to regenerate it.");
                }
            }
        });
        
        // layout
        nextBtn.setText("Check Answer");
        
        // changes question text depending on level
        switch(Window.level) { 
            case 2:
                questionLbl.setText("What is an algorithm?");
            default:
                questionLbl.setText("Question");
        }
        
        // layout
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
        
        // changes answer text depending on level
        switch(Window.level) { 
            case 2:
                aBtn.setText("A computer component.");
                bBtn.setText("A sequence of steps designed to solve a "
                        + "particular problem.");
                cBtn.setText("1000 bytes.");
                dBtn.setText("A computer programmer.");
                break;
            default:
                aBtn.setText("A");
                bBtn.setText("B");
                cBtn.setText("C");
                dBtn.setText("D");
        } 
        
        // adds components to JFrame
        frame.add(aBtn);
        frame.add(bBtn);
        frame.add(cBtn);
        frame.add(dBtn);
    }

}
