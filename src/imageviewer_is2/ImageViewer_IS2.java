package imageviewer_is2;

import view.persistence.ImageLoader;
import view.persistence.files.FileImageLoader;

public class ImageViewer_IS2 {

    public static void main(String[] args) {
        ImageLoader imageLoader = new FileImageLoader("C:\\Users\\Entrar\\Desktop\\imaginoso.jpg");
        MainFrame mainFrame = new MainFrame();
        
        mainFrame.getImageDisplay().display(imageLoader.load());
        
        mainFrame.setVisible(true);
    }
    
}
