package demos.files;

import java.io.File;
import java.io.IOException;

public class FilesDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        if(!file.exists()) {
            file.createNewFile();
        }
        
        //FileManager fm = new FileManager(file);
        //Preferences p = new Preferences(file);
        //p.setProperty("prop1", "propVal1");
        //p.save();
        //System.out.println(p.getProperty("prop1"));
        
        FileManager fm = new FileManager(file);
        System.out.println(fm.getContent());
        fm.writeContent("hello2!!!");
        System.out.println(fm.getContent());
    }
}
