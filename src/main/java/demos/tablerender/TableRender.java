package demos.tablerender;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class TableRender extends JTable {
	private TableRenderModel tableModel;
	private boolean allowEditableCell = false;
	
	public TableRender(String[] cols) {
		super();
		tableModel = new TableRenderModel(cols);
        setModel(tableModel);
	}
	
	public void allowEditableCells() {
		allowEditableCell = true;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return allowEditableCell;
	}
	
	public void addRow(Object[] row) {
        int columnCount = getColumnCount();
        
        Object[] f = new Object[columnCount+1];
        
        if(row.length >= columnCount)
            System.arraycopy(row, 0, f, 0, columnCount);
        else
            System.arraycopy(row, 0, f, 0, row.length);
        
        
        for (int i = 0; i < f.length-1; i++) {
        	Object o = f[i];
        	setCellRenderer(i, o);
        }
        
        tableModel.addRow(f);
        tableModel.fireTableDataChanged();
    }
	
	private void setCellRenderer(int column, Object comp) {
        if(!(comp instanceof JComponent)) {
        	return;
        }
        
        CustomCellRenderer ccr = new CustomCellRenderer();
        CustomCellEditor cce = new CustomCellEditor();
        
        TableColumn tc = getColumnModel().getColumn(column);
        tc.setCellRenderer(ccr);
        tc.setCellEditor(cce);
    }
}
