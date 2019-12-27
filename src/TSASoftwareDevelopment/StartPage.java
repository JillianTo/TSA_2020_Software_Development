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
    private JLabel welcomeLbl;
    private JPanel lessonPanel;
    private JPanel levelPanel;
    
    // no-args constructor
    public StartPage() {
        super();
        createPage();
    }
    
    // user-defined resolution constructor
    public StartPage(int windowWidth, int windowHeight) {
        super(windowWidth, windowHeight);
        createPage();
    }

    // creates page
    private void createPage() {
        welcomeLbl = new JLabel("Welcome " + Window.name + "!");
        lessonPanel = new JPanel();
        levelPanel = new JPanel();
        welcomeLbl.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.05)), Window.windowWidth,
                ((int)(Window.windowHeight*0.1)));
        welcomeLbl.setFont(new Font(SANS_SERIF, Font.BOLD, 72));
        lessonPanel.setBounds(((int)(Window.windowWidth*0.05)),
                ((int)(Window.windowHeight*0.2)), 
                ((int)(Window.windowWidth*0.5)), 
                ((int)(Window.windowHeight*0.6)));
        lessonPanel.setBackground(Color.LIGHT_GRAY);
        levelPanel.setBounds(((int)(Window.windowWidth*0.5)),
                ((int)(Window.windowHeight*0.2)), 
                ((int)(Window.windowWidth*0.2)), 
                ((int)(Window.windowHeight*0.6)));
        switch(Window.level) { // add later that this will choose which level window to open based on save
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
        this.getFrame().add(welcomeLbl);
        this.getFrame().add(lessonPanel);
        this.getFrame().add(levelPanel);
        
        }
}
