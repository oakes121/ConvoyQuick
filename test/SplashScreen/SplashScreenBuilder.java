/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SplashScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 *
 * @author Mike Moye <mtm5313@psu.edu>
 */
public class SplashScreenBuilder extends JWindow{
    
    public static void main(String args[]){
        
        SplashScreenBuilder ssb = new SplashScreenBuilder(); 
              
        ssb.showSplash();
        
    }
    
    public void showSplash(){
    
    JPanel content = (JPanel) getContentPane();            
    content.setBackground(Color.blue);

    // Set the window's bounds, centering the window
    int width = 700;
    int height = 450;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width - width) / 2;
    int y = (screen.height - height) / 2;
    setBounds(x, y, width, height);

    // Build the splash screen
    JLabel label = new JLabel(new ImageIcon("java-tip.gif"));
    JLabel copyrt = new JLabel("Splash Screen!!!", JLabel.CENTER);

    content.add(label, BorderLayout.CENTER);

    // Fun starts here...    
//        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
//        content.add(copyrt, BorderLayout.SOUTH);

    label.setLayout(new BorderLayout());
    Font font = copyrt.getFont();
    copyrt.setFont(font.deriveFont(Font.BOLD, 24f));
    label.add(copyrt);

    Color oraRed = new Color(200, 50, 20, 255);
    content.setBorder(BorderFactory.createLineBorder(oraRed, 10));

    // Display it
    setVisible(true);

    // Don't do this, as it will cause the EDT to be stopped.  Instead
    // setup some kind of callback that can tell when the resources are 
    // loaded and start the rest of the application from there...
    // Wait a little while, maybe while loading resources
    //try {
    //    Thread.sleep(duration);
    //} catch (Exception e) {
    //}

    //setVisible(false);
    
    }
}
