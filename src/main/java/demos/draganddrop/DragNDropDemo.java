package demos.draganddrop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
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
        
        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
        DraggeableTextArea dta = new DraggeableTextArea(textArea);
        
        JPanel panel = new JPanel();
        DraggeablePanel dp = new DraggeablePanel(panel);

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
