package demos.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

public class Preferences {
    private Properties properties;
    private File file;

    public Preferences(File file) {
        this.file = file;
        properties = new Properties();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (SecurityException e) {
            // Sin permisos de lectura
        } catch (FileNotFoundException e) {
            // Fichero no encontrado, generar nuevo
        }

        try {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Guarda en un fichero
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            properties.store(fos, "Preferences");
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public void print() {
        for (Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }

}