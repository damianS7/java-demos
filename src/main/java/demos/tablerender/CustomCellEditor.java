package demos.tablerender;

import java.awt.Component;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;

public class CustomCellEditor  extends AbstractCellEditor implements TableCellEditor {
	private Component comp;
	
	@Override
	public Object getCellEditorValue() {
        return comp;
	}
	
	@Override
	public boolean isCellEditable(EventObject e) {
		return true;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		comp = (Component) value;
        return comp;
	}

}
