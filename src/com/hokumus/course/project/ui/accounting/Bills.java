package com.hokumus.course.project.ui.accounting;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.hokumus.course.project.utils.dao.DbServicessBase;

public class Bills extends JFrame {
	private JButton btnDosyaSec;
	private JLabel lblbos;

	      
	public Bills() {
		
		initialize();
		
		
	}

	private void insertpdf() {
		
		DbServicessBase<Bills> bil = new DbServicessBase<Bills>();
		Bills kaydet = new Bills();
			
		kaydet.getBtnDosyaSec().getText();
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("dosya.txt");
		} catch (FileNotFoundException e) {
			System.out.println("dosya bulunamadý.");
			e.printStackTrace();
		}
		
		
	}

	private void initialize() {
		setTitle("FATURALAR");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		getContentPane().setLayout(null);
		
		JLabel lblFaturaKaydet = new JLabel("Fatura Se\u00E7iniz");
		lblFaturaKaydet.setBounds(43, 36, 83, 14);
		getContentPane().add(lblFaturaKaydet);
		
		JLabel lblFaturaGrntle = new JLabel("Faturalar\u0131 G\u00F6r\u00FCnt\u00FCle");
		lblFaturaGrntle.setBounds(287, 36, 128, 14);
		getContentPane().add(lblFaturaGrntle);
		getContentPane().add(getBtnDosyaSec());
		getContentPane().add(getLblbos());
		
		JButton btnGoruntule = new JButton("G\u00F6r\u00FCnt\u00FCle");
		btnGoruntule.setBounds(287, 88, 89, 23);
		getContentPane().add(btnGoruntule);
		
		JButton btnKaydet = new JButton("kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				insertpdf();
			}
		});
		btnKaydet.setBounds(43, 167, 89, 23);
		getContentPane().add(btnKaydet);
		
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
}
