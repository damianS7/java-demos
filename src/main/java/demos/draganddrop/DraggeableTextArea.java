package demos.draganddrop;

import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.io.File;
import java.util.List;

import javax.swing.JTextArea;

public class DraggeableTextArea extends JTextArea implements DraggeableComponent {
    private List<File> draggedFiles;
    
    public DraggeableTextArea() {
        super();
        this.setEditable(false);
        DropTarget dt = new DropTarget(this, this);
    }
    
    // Que hacer cuando se arrastra un fichero a la ventana
    protected void dragTrigger() {
        System.out.println("DRAG!");
        // Loop them through
        for (File file : draggedFiles) {
            this.append(file.getName());
        }
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

    @Override
    public void drop(DropTargetDropEvent dtde) {
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
                    draggedFiles = (List<File>) dtde.getTransferable().getTransferData(flavor);
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
}
