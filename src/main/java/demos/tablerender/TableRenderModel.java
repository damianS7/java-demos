package demos.tablerender;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableRenderModel extends AbstractTableModel {
    private String[] columns;
    private List<Object[]> rows = new ArrayList<Object[]>();

    public TableRenderModel(String[] columns) {
        super();
        this.columns = columns;
    }

    public void addRow(Object[] row) {
        rows.add(row);
    }

    public void addColumn(String columnName) {
        String[] oldColumns = columns;
        String[] newColumns = new String[columns.length + 1];
        System.arraycopy(oldColumns, 0, newColumns, 0, columns.length);
        newColumns[newColumns.length - 1] = columnName;
        columns = newColumns;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (rowIndex >= rows.size() || rowIndex < 0 || columnIndex < 0 || columnIndex >= columns.length) {
            return;
        }

        rows.get(rowIndex)[columnIndex] = aValue;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
