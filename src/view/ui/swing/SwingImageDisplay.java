package view.ui.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Image;
import view.ui.ImageDisplay;

public class SwingImageDisplay extends JPanel implements ImageDisplay{ 

    private Image image;

    public SwingImageDisplay() {
        super(new BorderLayout()); //llama al constructor de la clase padre, en este caso JPanel
    }
    
    @Override
    public void display(Image image) {
        this.image = image;
        this.removeAll();
        this.add(imagePanel());
        
    }

    private Component imagePanel() {
        return new JPanel(){
            @Override
            public void paint(Graphics g){
                g.drawImage(bitmap(), 0, 0, this.getWidth(), this.getWidth(), null);
            }

            private java.awt.Image bitmap() {
                try {
                    return ImageIO.read(new ByteArrayInputStream(image.bitmap()));
                } catch (IOException ex) {
                    System.out.println(""+ex.getMessage());
                    return null;
                }
            }
        };
    }
    
}
