/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsa.software.development;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author JTo
 */
public class StartPage {
    
    //
    JFrame f;
    
    //create and initialize home page
    public void createPage(){
        //create page
        f = new JFrame(); 
        
        JButton b=new JButton("Click Here");  
        b.setBounds(50,100,95,30);  
        b.addActionListener(new ActionListener(){  
       
        public void actionPerformed(ActionEvent e){  
            
        }  
        }); 
        
       
        //screen specifications
        f.setSize(1920, 1080);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f.setUndecorated(true);
    }
    
    //make page visible
    public void showPage(){
        f.setVisible(true);
    }
    
}
