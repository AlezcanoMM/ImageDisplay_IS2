package imageviewer_is2;

import java.awt.Component;
import javax.swing.JFrame;
import view.ui.swing.SwingImageDisplay;

public class MainFrame extends JFrame{

    SwingImageDisplay imageDisplay;
    
    public MainFrame() {
        this.setTitle("Image Viewer");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.add(image());
    }

    private Component image() {
        SwingImageDisplay swingImageDisplay = new SwingImageDisplay();
        this.imageDisplay = swingImageDisplay;
        return swingImageDisplay;
    }

    public SwingImageDisplay getImageDisplay() {
        return imageDisplay;
    }
    
}
