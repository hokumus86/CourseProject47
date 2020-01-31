package com.hokumus.course.project.ui.accounting;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Bills extends JFrame {
	private JButton btnDosyaSec;
	private JLabel lblbos;
	private ArrayList<Integer> faturalar = new ArrayList<Integer>();
	private JTable table;
	private void goruntule() {
		
		
	}
	public static void oku() {
		
		try {
			FileInputStream fis = new FileInputStream("file.pdf");
					
			
			int oku;
			while ((oku = fis.read()) !=-1) {
			
			
				
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("dosya bulunamadý.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	      
	public Bills() {
		
		initialize();
		
		
	}



	private void initialize() {
		setTitle("FATURALAR");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		getContentPane().setLayout(null);
		
		JLabel lblFaturaKaydet = new JLabel("Fatura Se\u00E7iniz");
		lblFaturaKaydet.setBounds(43, 36, 83, 14);
		getContentPane().add(lblFaturaKaydet);
		getContentPane().add(getBtnDosyaSec());
		getContentPane().add(getLblbos());
		
		JButton btnGoruntule = new JButton("G\u00FCncelle");
		btnGoruntule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnGoruntule.setBounds(287, 88, 89, 23);
		getContentPane().add(btnGoruntule);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				
			}
		});
		btnKaydet.setBounds(174, 88, 89, 23);
		getContentPane().add(btnKaydet);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 464, 328);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(getTable());
		
	}
	
	private JButton getBtnDosyaSec() {
		if (btnDosyaSec == null) {
			btnDosyaSec = new JButton("Dosya Se\u00E7");
			btnDosyaSec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					JFileChooser fc = new JFileChooser();
					fc.setDialogTitle("Fatura Seçme Ekraný");
					fc.setApproveButtonText("Seç");
					
					fc.addChoosableFileFilter(new FileNameExtensionFilter("Pdf Belgesi", "pdf"));
					
					
					int result = fc.showOpenDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						
						lblbos.setText(fc.getSelectedFile().getName());
					}
				
				
					else if (result == JFileChooser.CANCEL_OPTION) {
						lblbos.setText("Fatura Seçilmedi.");
					}
				
					
					
				}
			});
			btnDosyaSec.setBounds(43, 88, 108, 23);
		}
		return btnDosyaSec;
	}
	private JLabel getLblbos() {
		if (lblbos == null) {
			lblbos = new JLabel("");
			lblbos.setForeground(Color.RED);
			lblbos.setBounds(43, 61, 152, 14);
		}
		return lblbos;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(new Object[][] {}, 
					new String[] { "ID", "FATURALAR", }) {
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
