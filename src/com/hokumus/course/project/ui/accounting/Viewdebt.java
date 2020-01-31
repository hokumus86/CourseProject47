package com.hokumus.course.project.ui.accounting;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Viewdebt extends JFrame {
	private JScrollPane scrollPane;
	private JTable table;
	
	public Viewdebt() {
		initialize();
		
	}

	private void initialize() {
		setTitle("Fatura Görüntüle");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollPane());
		
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 464, 439);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(new Object[][] {}, 
					new String[] { "ID", "AD", "SOYAD","ALINAN","KALAN", "TARÝH" }) {
			});

			

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] {  });

			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
		return table;

			
		}
		return table;
	}
}
