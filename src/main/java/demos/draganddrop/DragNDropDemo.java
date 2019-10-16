package demos.draganddrop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.dnd.DropTarget;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class DragNDropDemo {
    private JFrame frame;
    
    public DragNDropDemo() {
        frame = new JFrame();
        frame.setTitle("Drag and drop test");
        frame.setSize(450, 450);
        frame.getContentPane().setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 438, 179);
        frame.getContentPane().add(scrollPane);
        
        DraggeableTextArea textArea = new DraggeableTextArea();
        textArea.setWrapStyleWord(true);
        scrollPane.setViewportView(textArea);
        
        DraggeablePanel panel = new DraggeablePanel();
        panel.setBounds(0, 191, 438, 216);
        frame.getContentPane().add(panel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DragNDropDemo();
            }
        });
    }
}
