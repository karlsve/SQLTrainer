/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltrainer.welcome;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author karlinsv
 */
public class BackgroundImage extends JPanel {
    
    Image image = null;
    
    public BackgroundImage() {
        
    }
    
    public BackgroundImage(Image image) {
        this.image = image;
    }
    
    public void setBackgroundImage(Image image) {
        this.image = image;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, null);
    }
    
}
