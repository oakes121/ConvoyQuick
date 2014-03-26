package textEditor2;
/**
 * Contains The Main String Arguments
 * 
 * @author Joseph Lewis
 * @version 11/16/2008
 */
import javax.swing.UIManager; // allows for look and feel of windows

public class Instinator
{
     //Build the main so java builds the class when it is set up as a jar
    public static void main(String[] args)
    {
        
          //Set to look like windows:
          try {
              UIManager.setLookAndFeel(
              "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
          } catch (Exception e) { }

        
        
        new BlueWriter();
    }
}

