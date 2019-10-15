package demos.files;

import java.io.File;

public class FileManagerDemo {
    public static void main(String[] args) {
        File file = new File("test.txt");
        if(!file.exists()) {
            return;
        }
        
        FileManager fm = new FileManager(file);
        Preferences p = new Preferences(file);
        p.setProperty("prop1", "propVal1");
        p.print();
        
    }
}
