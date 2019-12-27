/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSASoftwareDevelopment;

import static TSASoftwareDevelopment.Window.exitBtn;
import java.awt.Font;
import static java.awt.Font.SANS_SERIF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jilli
 */
public class MultipleChoice extends Window {
    // primitives
    private boolean evaluation;
    // objects
    private enum Answer {
        A, B, C, D;
    }
    private Answer answer;
    private JButton submitBtn;
    private JLabel levelLbl;
    private JRadioButton aBtn;
    private JRadioButton bBtn;
    private JRadioButton cBtn;
    private JRadioButton dBtn;
    private ButtonGroup mcGroup;
    
    // user-defined constructor
    public MultipleChoice() {
        super();
        createPage();
    }
    
    private void createPage() {
        submitBtn = new JButton("Continue");
        levelLbl = new JLabel("Level " + Window.level);
        aBtn = new JRadioButton();
        bBtn = new JRadioButton();
        cBtn = new JRadioButton();
        dBtn = new JRadioButton();
        mcGroup.add(aBtn);
        mcGroup.add(bBtn);
        mcGroup.add(cBtn);
        mcGroup.add(dBtn);
        submitBtn.setBounds(((int)(Window.windowWidth*0.875)),
                ((int)(Window.windowHeight*0.05)), 
                ((int)(Window.windowWidth*0.1)), 
                ((int)(Window.windowHeight*0.1)));
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(level) { // placeholder, change correct answer depending on level
                    default:
                        if(answer == Answer.A)
                            evaluation = true;
                        else
                            evaluation = false;
                }
            }
        });
        levelLbl.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.05)), Window.windowWidth,
                ((int)(Window.windowHeight*0.1)));
        levelLbl.setFont(new Font(SANS_SERIF, Font.BOLD, 72));
        switch(Window.level) { // placeholder, change answer text depending on level
            default:
                aBtn.setText("A");
                bBtn.setText("B");
                cBtn.setText("C");
                dBtn.setText("D");
        }
    }
}
