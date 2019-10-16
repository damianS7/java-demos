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

public class DraggeablePanel extends JPanel implements DraggeableComponent {
    private List<File> draggedFiles;
    private JLabel label;
    public DraggeablePanel() {
        super();
        DropTarget dt = new DropTarget(this, this);
        label =new JLabel("drop something here");
        add(label);
    }
    
    // Que hacer cuando se arrastra un fichero a la ventana
    protected void dragTrigger() {
        // Loop them through
        for (File file : draggedFiles) {
            label.setText(file.getName());
        }
    }
    
    
    @Override
    public void drop(DropTargetDropEvent dtde) {
        Transferable transferable = dtde.getTransferable();
        // Accept copy drops
        dtde.acceptDrop(DnDConstants.ACTION_COPY);

        // Get the data formats of the dropped item
        DataFlavor[] flavors = dtde.getTransferable().getTransferDataFlavors();

        // Loop through the flavors
        for (DataFlavor flavor : flavors) {
            try {
                // If the drop items are files
                if (flavor.isFlavorJavaFileListType()) {
                    // Get all of the dropped files
                    draggedFiles = (List<File>) transferable.getTransferData(flavor);
                    dragTrigger();
                }
            } catch (Exception e) {
                // Print out the error stack
                e.printStackTrace();
            }
        }
        // Inform that the drop is complete
        dtde.dropComplete(true);
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        // TODO Auto-generated method stub
        
    }
}
