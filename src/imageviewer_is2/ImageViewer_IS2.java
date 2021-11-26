package imageviewer_is2;

import presenter.Command;
import presenter.NextCommand;
import presenter.PrevCommand;
import view.persistence.ImageLoader;
import view.persistence.files.FileImageLoader;

public class ImageViewer_IS2 {

    public static void main(String[] args) {
        ImageLoader imageLoader = new FileImageLoader("C:\\Users\\Entrar\\Desktop\\imaginoso.jpg");
        MainFrame mainFrame = new MainFrame();
        Command nextCommand = new NextCommand();
        Command prevCommand = new PrevCommand();
        
        mainFrame.add(nextCommand);
        mainFrame.add(prevCommand);
        
        mainFrame.getImageDisplay().display(imageLoader.load());
        
        mainFrame.setVisible(true);
    }
    
}
