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
 * @author jilli
 */
public class MultipleChoice extends Window {
    // objects
    private JButton submitBtn;
    private JLabel levelLbl;
    private JLabel questionLbl;
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
        submitBtn = new JButton("Check Answer");
        levelLbl = new JLabel("Level " + Window.level);
        questionLbl = new JLabel();
        aBtn = new JRadioButton();
        bBtn = new JRadioButton();
        cBtn = new JRadioButton();
        dBtn = new JRadioButton();
        mcGroup = new ButtonGroup();
        mcGroup.add(aBtn);
        mcGroup.add(bBtn);
        mcGroup.add(cBtn);
        mcGroup.add(dBtn);
        submitBtn.setBounds(((int)(Window.windowWidth*0.875)),
                ((int)(Window.windowHeight*0.8)), 
                ((int)(Window.windowWidth*0.1)), 
                ((int)(Window.windowHeight*0.1)));
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(Window.level) { // placeholder, change correct answer depending on level
                    default:
                        if(aBtn.isSelected()) {
                            Window.level++; // add save
                            JOptionPane.showMessageDialog(null, "Correct");
                            getWindow().hideWindow();
                            Window.startPage.showWindow();
                        } else
                            JOptionPane.showMessageDialog(null, "Incorrect");
                }
            }
        });
        levelLbl.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.05)), Window.windowWidth,
                ((int)(Window.windowHeight*0.1)));
        levelLbl.setFont(new Font(SANS_SERIF, Font.BOLD, 72));
        questionLbl.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.05)), Window.windowWidth,
                ((int)(Window.windowHeight*0.1)));
        aBtn.setBounds(((int)(Window.windowWidth*0.1)),
                ((int)(Window.windowHeight*0.6)), 
                ((int)(Window.windowWidth*0.1)), 
                ((int)(Window.windowHeight*0.1)));
        bBtn.setBounds(((int)(Window.windowWidth*0.1)),
                ((int)(Window.windowHeight*0.7)), 
                ((int)(Window.windowWidth*0.1)), 
                ((int)(Window.windowHeight*0.1)));
        cBtn.setBounds(((int)(Window.windowWidth*0.1)),
                ((int)(Window.windowHeight*0.8)), 
                ((int)(Window.windowWidth*0.1)), 
                ((int)(Window.windowHeight*0.1)));
        dBtn.setBounds(((int)(Window.windowWidth*0.1)),
                ((int)(Window.windowHeight*0.9)), 
                ((int)(Window.windowWidth*0.1)), 
                ((int)(Window.windowHeight*0.1)));
        switch(Window.level) { // placeholder, change answer text depending on level
            default:
                aBtn.setText("A");
                bBtn.setText("B");
                cBtn.setText("C");
                dBtn.setText("D");
        }
        this.getFrame().add(submitBtn);
        this.getFrame().add(levelLbl);
        this.getFrame().add(questionLbl);
        this.getFrame().add(aBtn);
        this.getFrame().add(bBtn);
        this.getFrame().add(cBtn);
        this.getFrame().add(dBtn);
        this.getFrame().remove(continueBtn);
    }

}
