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
import javax.swing.*;

/**
 *
 * @author Jillian To
 */

public class StartPage extends Window {
    // objects
    private JPanel lessonPanel;
    private JPanel levelPanel;
    private JLabel welcomeLbl;
    
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
        lessonPanel = new JPanel();
        levelPanel = new JPanel();
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        welcomeLbl = new JLabel("Welcome " + Window.name + "!");
        
        lessonPanel.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.2)), 
                ((int)(Window.windowWidth*0.5)), 
                ((int)(Window.windowHeight*0.6)));
        lessonPanel.setBackground(Color.LIGHT_GRAY);
        levelPanel.setBounds(((int)(Window.windowWidth*0.5)),
                ((int)(Window.windowHeight*0.2)), 
                ((int)(Window.windowWidth*0.2)), 
                ((int)(Window.windowHeight*0.6)));
        switch(Window.level) {
            case 1:
                levelPanel.setBackground(Color.CYAN);
                break;
            case 2:
                levelPanel.setBackground(Color.GREEN);
                break;
            case 3:
                levelPanel.setBackground(Color.ORANGE);
                break;
            case 4:
                levelPanel.setBackground(Color.YELLOW);
                break;
            default:
                levelPanel.setBackground(Color.RED);
        }
        welcomeLbl.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.05)), Window.windowWidth,
                ((int)(Window.windowHeight*0.1)));
        welcomeLbl.setFont(new Font(SANS_SERIF, Font.BOLD, 72));
        this.getFrame().add(lessonPanel);
        this.getFrame().add(levelPanel);
        this.getFrame().add(welcomeLbl);
        }
}
