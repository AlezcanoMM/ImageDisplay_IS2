package view.persistence.files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import model.Image;
import view.persistence.ImageLoader;

public class FileImageLoader implements ImageLoader{

    private final String[] imageExtensions = {"jpg", "png", "bmp"};
    private final File[] files;
    private int index = 0;
    
    public FileImageLoader(String folder) {
        this.files = new File(folder).listFiles(withImageExtensions());
    }
    
    @Override
    public Image load() {
        return imageAt(index);
    }
    
    public Image imageAt(int i){
        return new Image(){
            
            @Override
            public byte[] bitmap() {
                FileInputStream is = null;
                try {
                    is = new FileInputStream(files[i]);
                    return read(is);
                } catch (FileNotFoundException ex) {
                    System.out.println(""+ex.getMessage());
                    return null;
                }
            }

            private byte[] read(FileInputStream is) {
                byte[] buffer = new byte[4096];
                
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                while(true){
                    try {
                        int length = is.read(buffer);
                        
                        if(length <= 0){
                            break;
                        }
                        
                        os.write(buffer, 0, length);
                        
                    } catch (IOException ex) {
                        System.out.println(""+ex.getMessage());
                    }
                }
                
                return os.toByteArray();
            }            

            @Override
            public Image next() {
                if(i >= files.length){
                    index = 0;
                    return imageAt(index);
                } else {
                    index++;
                    return imageAt(index);
                }
            }

            @Override
            public Image prev() {
                if(i < 0){
                    index = 0;
                    return imageAt(index);
                } else {
                    index--;
                    return imageAt(index);
                }
            }
            
        };
    }
    
    private FilenameFilter withImageExtensions(){
        return new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
                for(String ImageExtension: imageExtensions){
                    if(name.endsWith(ImageExtension)){
                        return true;
                    }
                }
                return false;
            }
        };
    }
    
}
