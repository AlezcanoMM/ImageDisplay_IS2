package view.persistence.files;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import model.Image;
import view.persistence.ImageLoader;

public class FileImageLoader implements ImageLoader{

    private final String fileName;

    public FileImageLoader(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public Image load() {
        
        return new Image(){
            
            @Override
            public byte[] bitmap() {
                FileInputStream is = null;
                try {
                    is = new FileInputStream(fileName);
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
        };
        
    }
    
}
