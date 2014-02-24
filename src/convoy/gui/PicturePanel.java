/*
 * Oakes Isaac
 * Krypto (Semester Project)
 * December 11, 2013
 * oki5001@psu.edu
 */

/*
 * MyPicturePanel.java
 * 
 * This class is a panel that adds a picture to fill the panel
 */

package convoy.gui;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class PicturePanel extends JPanel {
    private BufferedImage image;                                // used to store image to be loaded
    
    /**
     * This constructor, calls the super class constructor and loads the image to the panel
     * 
     * @param imageName file path name for the image to be loaded
     */
    public PicturePanel() {
        super();
    }
    
    /**
     * This constructor, calls the super class constructor and loads the image to the panel
     * 
     * @param imageName file path name for the image to be loaded
     */
   public PicturePanel(String imageName) {
        super();
        setLayout(this.getLayout());
        loadImage(imageName);
        repaint();
        revalidate();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }
    
    /**
     * Method used to load an image
     * @param imageName the file path of the image to be loaded
     */
    private void loadImage(String imageName) {
       try {
            image = ImageIO.read(getClass().getResource(imageName));
        } catch (IOException ex) {
        }
    }
}
