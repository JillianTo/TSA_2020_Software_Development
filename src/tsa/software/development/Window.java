/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsa.software.development;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jilli
 */
public class Window extends JFrame {
    // primitives
    private int windowWidth;
    private int windowHeight;
    private final int DEFAULT_WINDOW_WIDTH = 1920;
    private final int DEFAULT_WINDOW_HEIGHT = 1080;
    
    // objects
    JFrame frame;
    GraphicsDevice device;
    GraphicsEnvironment graphics;
    
    // constructor
    public Window() {
        windowWidth = DEFAULT_WINDOW_WIDTH;
        windowHeight = DEFAULT_WINDOW_HEIGHT;
        createPage();
    }
    
    // user-defined constructor
    public Window(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        createPage();
    }

    // creates page
    private void createPage() {
        frame = new JFrame(); 
        frame.setSize(windowWidth,windowHeight);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);    
        }
    
    // make page visible
    public void showPage(){
        frame.setVisible(true);
    }
    
    // hides page
    public void hidePage() {
        frame.setVisible(false);
    }
    
    public void setFullscreen() {
        graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = graphics.getDefaultScreenDevice();
        device.setFullScreenWindow(frame);
    }
    
    public JFrame getJFrame() {
        return frame;
    }
    
    public int getWindowWidth() {
        return windowWidth;
    }
    
    public int getWindowHeight() {
        return windowHeight;
    }

}
