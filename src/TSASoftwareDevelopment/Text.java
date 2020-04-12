/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSASoftwareDevelopment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jillian To
 */
public class Text extends Window {
    // objects
    private JButton backBtn;
    // no-args constructor
    public Text() {
        super();
        createWindow();
    }
    
    // create window
    private void createWindow() {
        // chooses what level the next button will go to
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window.levelUp();
                switch(Window.level) { // placeholder, change correct answer depending on level
                    case 1:
                        Window.text = new Text();
                        Window.text.showWindow();
                        break;
                    case 2:
                        Window.multipleChoice = new MultipleChoice();
                        Window.multipleChoice.showWindow();
                        break;
                    case 4:
                        Window.fillInTheBlanks = new FillInTheBlanks();
                        Window.fillInTheBlanks.showWindow();
                        break;
                    case 6:
                        Window.maze = new Maze();
                        Window.maze.showWindow();
                    default:
                        Window.startPage = new StartPage();
                        Window.startPage.showWindow();
                }
            }
        });
        
        // layout
        nextBtn.setText("Next");
        switch(Window.level) { // placeholder, change question text depending on level
            case 0:
                questionLbl.setText("<html>Welcome to our computer science "
                        + "basics course! This course is aimed at people with "
                        + "no prior experience with computer science or "
                        + "programming. We will be utilizing the JAVA "
                        + "programming language in syntax, but lessons will "
                        + "focus on principles that can be applied to any "
                        + "programming language.</html>");
                break;
            case 1:
                questionLbl.setText("<html>The first lesson is about algoritms."
                        + " Since computers will follow exactly what you tell "
                        + "them to do, your code must be very precise. Like a "
                        + "well-written recipe, a well-written algorithm is a "
                        + "detailed sequence of steps designed to solve a "
                        + "particular problem.</html>");
                break;
            case 3:
                questionLbl.setText("<html>Like how you wouldn't start cooking "
                        + "a dish before reading the recipe, it is recommended "
                        + "to not start typing your program before thinking "
                        + "through your algorithm. Even experienced programmers"
                        + "will write out an algorithm in pseudocode, which is "
                        + "another way of saying normal English, before writing"
                        + "a program in a language like JAVA on the computer. "
                        + "This is also useful when writing a program in a team"
                        + ", as a detailed and understandable list of steps "
                        + "can allow for work to be split up.</html>");
                break;
            case 5:
                questionLbl.setText("<html>Be sure to use descriptive comments "
                        + "in your programs so that if you or someone else "
                        + "looks at it in the future, they will understand what"
                        + " you wrote. Also be sure to throughly test your "
                        + "program to make sure there are no bugs.\n\nThis is"
                        + "the end of the material for Level 1, you may return "
                        + "to older pages to review before going to the "
                        + "concluding activity.</html>");
                break;
            default:
                questionLbl.setText("Corrupted save, please exit the program "
                        + "and delete your save to regenerate it.");
        }
        
    }
}
