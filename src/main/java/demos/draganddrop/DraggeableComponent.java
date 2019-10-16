package demos.draganddrop;

import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.util.List;

import javax.swing.JComponent;

public abstract class DraggeableComponent implements DropTargetListener {
    protected List<File> draggedFiles;
    
    public DraggeableComponent(JComponent component) {
        DropTarget dt = new DropTarget(component, this);
    }
    
    public List<File> getDraggedFiles() {
        return draggedFiles;
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
                    dropTrigger();
                }
            } catch (Exception e) {
                // Print out the error stack
                e.printStackTrace();
            }
        }
        // Inform that the drop is complete
        dtde.dropComplete(true);
    }

    public abstract void dropTrigger();

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
