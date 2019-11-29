/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSASoftwareDevelopment;

/**
 *
 * @author Jillian To
 */
public class TSASoftwareDevelopment {

    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) { 
        // objects
        Window window = new Window();
        SettingsPage settingsPage = new SettingsPage();
        StartPage startPage = new StartPage(settingsPage);
        
        // run program
        startPage.showPage();
        settingsPage.linkWindows(startPage);
    }
    
}
