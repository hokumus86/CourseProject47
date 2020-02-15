package com.hokumus.course.project.ui.accounting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.project.models.accounting.Purchasings;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.hokumus.course.project.utils.dao.PurchasingDao;
import com.toedter.calendar.JDateChooser;

public class Purchasing extends JFrame {
	private JTextField txtmlzm;
	private JTextField txtfiyat;
	private JDateChooser tarih;
	private JButton btnGncelle;
	private JButton btnSil;
	private Long selecteditemid;
	private JLabel lblAdet;
	private JTextField txtadet;
	private JLabel lblEsyaMalzmadet;
	private JScrollPane scrollPane;
	private JTable table;
	
	public Purchasing() {
		
	  initialize();
	  
	  
	}

	private void initialize() {
		setTitle("SATINALMA");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		getContentPane().setLayout(null);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setBounds(85, 329, 46, 14);
		getContentPane().add(lblTarih);
		
		tarih = new JDateChooser();
		tarih.setBounds(27, 354, 170, 20);
		getContentPane().add(tarih);
		
		JLabel lblSatnAlnanEsya = new JLabel("Sat\u0131n al\u0131nan e\u015Fya ve malzemeleri giriniz.");
		lblSatnAlnanEsya.setBounds(10, 30, 197, 28);
		getContentPane().add(lblSatnAlnanEsya);
		
		txtmlzm = new JTextField();
		txtmlzm.setBounds(27, 88, 170, 20);
		getContentPane().add(txtmlzm);
		txtmlzm.setColumns(10);
		
		JLabel lblEsyamlzmfiyat = new JLabel("E\u015Fya yada Malzemelerin fiyat\u0131n\u0131 giriniz.");
		lblEsyamlzmfiyat.setBounds(10, 131, 197, 21);
		getContentPane().add(lblEsyamlzmfiyat);
		
		txtfiyat = new JTextField();
		txtfiyat.setColumns(10);
		txtfiyat.setBounds(27, 188, 170, 20);
		getContentPane().add(txtfiyat);
		
		JLabel lblMalzeme = new JLabel("Malzeme");
		lblMalzeme.setBounds(85, 69, 64, 14);
		getContentPane().add(lblMalzeme);
		
		JLabel lblFiyat = new JLabel("Fiyat");
		lblFiyat.setBounds(85, 163, 46, 14);
		getContentPane().add(lblFiyat);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbServicessBase<Purchasings> dao = new DbServicessBase<Purchasings>();
				Purchasings kaydet = new Purchasings();
				
				
				kaydet.setAdet(new BigDecimal(txtadet.getText()));
				kaydet.setMalzeme(txtmlzm.getText());
				kaydet.setFiyat(new BigDecimal(txtfiyat.getText()));
				kaydet.setTarih(tarih.getDate());
				
				if (dao.save(kaydet)) {
					JOptionPane.showMessageDialog(Purchasing.this, "Kayýt Baþarýlý");
					satinalmatablosu();
				}
				else {
					JOptionPane.showMessageDialog(Purchasing.this, "Kayýt Baþarýsýz");
				}		
			}
		});
		btnKaydet.setBounds(10, 397, 89, 23);
		getContentPane().add(btnKaydet);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Purchasing.this.dispose();
			}
		});
		btnIptal.setBounds(135, 397, 89, 23);
		getContentPane().add(btnIptal);
		
		JLabel lblEsyamlzmtarih = new JLabel("E\u015Fya yada Malzemenin Tarihini Giriniz.");
		lblEsyamlzmtarih.setBounds(10, 304, 197, 14);
		getContentPane().add(lblEsyamlzmtarih);
		getContentPane().add(getBtnGncelle());
		getContentPane().add(getBtnSil());
		getContentPane().add(getLblAdet());
		getContentPane().add(getTxtadet());
		getContentPane().add(getLblEsyaMalzmadet());
		getContentPane().add(getScrollPane_1());
		
	

	}
	private void satinalmatablosu() {
		PurchasingDao purchdao = new PurchasingDao();
		List<Purchasings> liste = purchdao.getAllRows(new Purchasings());
		
		String[][] data = new String[liste.size()][5];
		String[] columns = { "ID","MALZEME","FÝYAT","ADET","TARÝH"};
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = String.valueOf(liste.get(i).getId());
			data[i][1] = liste.get(i).getMalzeme();
			data[i][2] = liste.get(i).getFiyat().toString();
			data[i][3] = liste.get(i).getAdet().toString();
			data[i][4] = liste.get(i).getTarih().toString();
			
		}
		DefaultTableModel model = new DefaultTableModel(data, columns);
			table.setModel(model);
		
	}
	private JButton getBtnGncelle() {
		if (btnGncelle == null) {
			btnGncelle = new JButton("G\u00FCncelle");
			
			btnGncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					DbServicessBase<Purchasings> purchdao = new DbServicessBase<Purchasings>();
					Purchasings guncelle = new Purchasings();
					
					
					guncelle.setFiyat(new BigDecimal(txtfiyat.getText()));
					guncelle.setMalzeme(txtmlzm.getText());
					guncelle.setId(selecteditemid);
					guncelle.setAdet(new BigDecimal(txtadet.getText()));
					
					if (purchdao.update(guncelle)) {
						JOptionPane.showMessageDialog(Purchasing.this, " baþarýlý");
						satinalmatablosu();
						
					} else
						JOptionPane.showMessageDialog(Purchasing.this, " baþarýsýz");
				}
			});
			btnGncelle.setBounds(256, 397, 89, 23);
		}
		return btnGncelle;
	}
	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("Sil");
			btnSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					DbServicessBase<Purchasings> purchdao = new DbServicessBase<Purchasings>();
					Purchasings sil = new Purchasings();
					
					sil.setId(selecteditemid);
					sil.setFiyat(new BigDecimal(txtfiyat.getText().toString()));
					sil.setMalzeme(txtmlzm.getText());
					sil.setTarih(tarih.getDate());
					
					
					if (purchdao.delete(sil)) {
						JOptionPane.showMessageDialog(Purchasing.this, " baþarýlý");
						satinalmatablosu();
						
					} else
						JOptionPane.showMessageDialog(Purchasing.this, " baþarýsýz");
				}
			});
			btnSil.setBounds(385, 397, 89, 23);
		}
		return btnSil;
	}
	private JLabel getLblAdet() {
		if (lblAdet == null) {
			lblAdet = new JLabel("Adet");
			lblAdet.setBounds(85, 251, 46, 14);
		}
		return lblAdet;
	}
	private JTextField getTxtadet() {
		if (txtadet == null) {
			txtadet = new JTextField();
			txtadet.setBounds(27, 276, 170, 20);
			txtadet.setColumns(10);
		}
		return txtadet;
	}
	private JLabel getLblEsyaMalzmadet() {
		if (lblEsyaMalzmadet == null) {
			lblEsyaMalzmadet = new JLabel("E\u015Fya yada Malzemelerin adetini giriniz.");
			lblEsyaMalzmadet.setBounds(10, 219, 197, 21);
		}
		return lblEsyaMalzmadet;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(207, 30, 267, 344);
			scrollPane.setViewportView(getTable_1());
			satinalmatablosu();
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				
					selecteditemid = Long.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
					txtmlzm.setText(CourseUtils.getValue(table.getValueAt(table.getSelectedRow(), 1)));
					txtfiyat.setText(CourseUtils.getValue(table.getValueAt(table.getSelectedRow(), 2)));
					txtadet.setText(CourseUtils.getValue(table.getValueAt(table.getSelectedRow(), 3)));
					
				
				}
				
			});
		}
		return table;
	}
}
