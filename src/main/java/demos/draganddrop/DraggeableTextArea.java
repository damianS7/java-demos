package demos.draganddrop;

import java.awt.dnd.DropTarget;
import java.io.File;
import java.util.List;

import javax.swing.JTextArea;

public class DraggeableTextArea extends DraggeableComponent {
    private JTextArea textArea;
    
    public DraggeableTextArea(JTextArea textArea) {
        super(textArea);
        this.textArea = textArea;
    }
    
    // Que hacer cuando se arrastra un fichero a la ventana
    @Override
    public void dropTrigger() {
        // Loop them through
        for (File file : getDraggedFiles()) {
            textArea.append(file.getName());
        }
    }

}
