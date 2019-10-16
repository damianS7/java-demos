package demos.ui;

import java.awt.EventQueue;


public class AmazingUiDemo {
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatUI();
            }
        });
    }
}
