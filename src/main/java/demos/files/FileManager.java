package demos.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    private File file;
    private String fileContent;
    
    public FileManager(File file) {
	this.file = file;
	load();
    }
    
    private void load() {
	try {
	    Path path = Paths.get(file.getAbsolutePath());
	    fileContent = new String(Files.readAllBytes(path), "UTF-8");
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
    public String getContent() {
	return fileContent;
    }
    
    public void writeContent(String content) {
	try {
	    FileOutputStream fos = new FileOutputStream(file);
	    fos.write(content.getBytes());
	    fos.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
