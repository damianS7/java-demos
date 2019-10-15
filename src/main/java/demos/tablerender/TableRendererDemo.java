package demos.tablerender;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class TableRendererDemo {
	private TableRender table;
	private JFrame frame;
	
	public TableRendererDemo() {
		initComponents();
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton btnNuevaFila = new JButton("Nueva fila");
		btnNuevaFila.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JProgressBar bar = new JProgressBar();
				bar.setValue(50);
				bar.setStringPainted(true);
				JButton boton = new JButton("boton");
                JRadioButton radio = new JRadioButton("hi");
                JTextField field = new JTextField("hola");
                JLabel label = new JLabel("hola");
                JComboBox<String> combo = new JComboBox<String>();
                DefaultComboBoxModel<String> cm = new DefaultComboBoxModel<String>();
                combo.setModel(cm);
                cm.addElement("Si");
                cm.addElement("No");
                cm.setSelectedItem("No");

                JCheckBox check = new JCheckBox("Do it");
                Object[] row = new Object[] {"Fila " + table.getRowCount(), boton, combo, check, label,
                        radio, field, bar};
                table.addRow(row);
			}
		});
		panel.add(btnNuevaFila, "cell 0 0");
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[453px,grow]", "[423px]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 0 0,growx,aligny top");
		
		String[] cols = new String[] {"id", "Boton", "Combo", "Check", "JLabel", "Radio",
        "text", "bar", ""};
		table = new TableRender(cols);
		table.allowEditableCells();
		scrollPane.setViewportView(table);
		frame.setVisible(true);
	}
	
	private void initComponents() {
        frame = new JFrame();
        frame.setSize(900, 600);
        frame.setTitle("Table Renderer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableRendererDemo();
            }
        });
	}
}
