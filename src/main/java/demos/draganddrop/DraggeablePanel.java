package demos.draganddrop;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.io.File;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DraggeablePanel extends DraggeableComponent {
    private JLabel label;
    
    public DraggeablePanel(JPanel panel) {
        super(panel);
        label = new JLabel("drop something here");
        DropTarget dt = new DropTarget(panel, this);
        panel.add(label);
    }
    
    // Que hacer cuando se arrastra un fichero a la ventana
    @Override
    public void dropTrigger() {
        // Loop them through
        for (File file : draggedFiles) {
            label.setText(file.getName());
        }
    }
    

}
