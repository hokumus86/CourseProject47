package com.hokumus.course.project.ui.accounting;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.project.models.accounting.Bill;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.sun.xml.bind.v2.model.core.ID;
import com.toedter.calendar.JDateChooser;

public class Bills extends JFrame {
	private JButton btnDosyaSec;
	private JLabel lblbos;
	private byte[] faturalar;
	private JTable table;
	private JDateChooser tarih;
	private Long selecteditemid;
	
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
		
		tarih = new JDateChooser();
		tarih.setBounds(337, 36, 137, 20);
		getContentPane().add(tarih);
		
		JButton btnGoruntule = new JButton("G\u00FCncelle");
		btnGoruntule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbServicessBase<Bill> dao = new DbServicessBase<Bill>();
				Bill guncelle = new Bill();
				
				guncelle.setId(ID.valueOf(enumType, name));
				guncelle.setFaturalar(getName().getBytes());
				guncelle.setTarih(tarih.getDate());
				
				if (dao.update(guncelle)) {
					JOptionPane.showMessageDialog(Bills.this, "güncelleme baþarýlý.");
					
				}
				else {
					JOptionPane.showMessageDialog(Bills.this, "güncelleme baþarýsýz.");
				}
				
			}
		});
		btnGoruntule.setBounds(276, 88, 89, 23);
		getContentPane().add(btnGoruntule);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbServicessBase<Bill> dao = new DbServicessBase<Bill>();
				Bill kaydet = new Bill();
					
				
				kaydet.setTarih(tarih.getDate());
				kaydet.setFaturalar(getName().getBytes());
				if (dao.save(kaydet)) {
					JOptionPane.showMessageDialog(Bills.this, "kaydetme baþarýlý");
				}
				
				else {
					JOptionPane.showMessageDialog(Bills.this, "kaydetme baþarýsýz");
				}
				
			}
		});
		btnKaydet.setBounds(177, 88, 89, 23);
		getContentPane().add(btnKaydet);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 464, 328);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(getTable());
		getContentPane().add(getBtnsil());
		faturatablosu();
		
	}
	
	DefaultTableModel model=new DefaultTableModel();
	private JButton btnsil;
	
	private void faturatablosu() {
		
		DbServicessBase<Bill> dao=new DbServicessBase<Bill>(); 
		Bill temp = new Bill();
		List<Bill> fatura_tablosu = dao.getAllRows(temp);
		
		String [] columnNames= {"ID","FATURALAR","TARÝH"};
		String [][] data=new String [fatura_tablosu.size()][columnNames.length];
		
		
		for (int i = 0; i < fatura_tablosu.size(); i++) {
			
			
			
			data[i][0]=fatura_tablosu.get(i).getFaturalar().toString();
			data[i][1]=fatura_tablosu.get(i).getTarih().toString();
			data[i][2]=fatura_tablosu.get(i).getId().toString();
			
		}
		model=new DefaultTableModel(data,columnNames);
		table.setModel(model);
		
	}



	private JButton getBtnDosyaSec() {
		if (btnDosyaSec == null) {
			btnDosyaSec = new JButton("Dosya Se\u00E7");
			btnDosyaSec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					final JFileChooser fc = new JFileChooser();
					int result = fc.showOpenDialog(null);
					File file = fc.getSelectedFile();
					fc.setDialogTitle("Fatura Seçme Ekraný");
					fc.setApproveButtonText("Seç");
					fc.addChoosableFileFilter(new FileNameExtensionFilter("Pdf Belgesi", "pdf"));
					
					
					
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
					new String[] { "ID", "FATURALAR","TARÝH" }) {
			});

			

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] {  });

			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
		return table;
		}
		return table;
	}
	private JButton getBtnsil() {
		if (btnsil == null) {
			btnsil = new JButton("Sil");
			btnsil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					DbServicessBase<Bill> dao=new DbServicessBase<Bill>();
					 Bill sil=new Bill();
					int row = table.getSelectedRow();
					sil.setId(Long.valueOf(table.getValueAt(row, 0).toString()));
					sil.setTarih(table.getValueAt(row, 1).toString());
					sil.setFaturalar(table.getValueAt(row, 2).toString());
					
					
					if (dao.delete(sil)) {
						JOptionPane.showMessageDialog(Bills.this, "silme baþarýlý");
						faturatablosu();
					}
					else {
						JOptionPane.showMessageDialog(Bills.this, "silme baþarýsýz.");
					}
				}
			});
			btnsil.setBounds(385, 88, 89, 23);
		}
		return btnsil;
	}
}
