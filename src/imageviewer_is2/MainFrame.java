package imageviewer_is2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import presenter.Command;
import view.ui.swing.SwingImageDisplay;

public class MainFrame extends JFrame{

    private SwingImageDisplay imageDisplay;
    private Map<String, Command> commands = new HashMap<String, Command>();
    
    public MainFrame() {
        this.setTitle("Image Viewer");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.add(image());
        this.add(toolbar(), BorderLayout.SOUTH);
    }

    private Component image() {
        SwingImageDisplay swingImageDisplay = new SwingImageDisplay();
        this.imageDisplay = swingImageDisplay;
        return swingImageDisplay;
    }

    public void add(Command command){
        commands.put(command.name(), command);
    }
    
    public SwingImageDisplay getImageDisplay() {
        return imageDisplay;
    }
    
    private Component toolbar(){
        JPanel panel = new JPanel();
        panel.add(button("Prev"));
        panel.add(button("Next"));
        return panel;
    }
    
    public Component button(String name){
        JButton button = new JButton(name);
        
        
        return button;
    }
    
}
