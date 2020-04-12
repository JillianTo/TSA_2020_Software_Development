/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSASoftwareDevelopment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author Jillian To
 */
public class FillInTheBlanks extends Window {
    // objects
    JTextField answerFld;
    
    // no-args constructor
    public FillInTheBlanks() {
        super();
        createWindow();
    }
    
    private void createWindow() {
        // object instantiations
        answerFld = new JTextField();
        
        // picks correct answer and what level to go to next depending on
        // current level
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(Window.level) { 
                    case 4:
                        if(answerFld.getText().toLowerCase().equals("pseudocode"
                        )) {
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
            case 4:
                questionLbl.setText("Fill in the blank: Algorithms are written "
                        + "in __________.");
                break;
            default:
                questionLbl.setText("Question");
        }
        
        // layout
        answerFld.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.75)), 
                ((int)(Window.windowWidth*0.7)), 
                ((int)(Window.windowHeight*0.05)));
        
        // adds components to JFrame
        frame.add(answerFld);
    }
    
}
