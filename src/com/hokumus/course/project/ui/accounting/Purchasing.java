package com.hokumus.course.project.ui.accounting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hokumus.course.project.models.accounting.Purchasings;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.toedter.calendar.JDateChooser;

public class Purchasing extends JFrame {
	private JTextField txtmlzm;
	private JTextField txtfiyat;
	private JDateChooser tarih;
	public Purchasing() {
		
	  initialize();
	  
	  
	}

	private void initialize() {
		setTitle("SATINALMA");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		getContentPane().setLayout(null);
		
		JLabel lblSatnAlnanEsya = new JLabel("Sat\u0131n al\u0131nan e\u015Fya ve malzemeleri giriniz.");
		lblSatnAlnanEsya.setBounds(10, 30, 226, 28);
		getContentPane().add(lblSatnAlnanEsya);
		
		txtmlzm = new JTextField();
		txtmlzm.setBounds(27, 88, 170, 20);
		getContentPane().add(txtmlzm);
		txtmlzm.setColumns(10);
		
		JLabel lblEsyamlzmfiyat = new JLabel("E\u015Fya yada Malzemelerin fiyat\u0131n\u0131 giriniz.");
		lblEsyamlzmfiyat.setBounds(10, 131, 228, 21);
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
				
				kaydet.setMalzeme(txtmlzm.getText());
				kaydet.setFiyat(new BigDecimal(txtfiyat.getText()));
				kaydet.setTarih(tarih.getDate());
				
				if (dao.save(kaydet)) {
					JOptionPane.showMessageDialog(Purchasing.this, "Kayýt Baþarýlý");
				}
				else {
					JOptionPane.showMessageDialog(Purchasing.this, "Kayýt Baþarýsýz");
				}		
			}
		});
		btnKaydet.setBounds(10, 351, 89, 23);
		getContentPane().add(btnKaydet);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Purchasing.this.dispose();
			}
		});
		btnIptal.setBounds(108, 351, 89, 23);
		getContentPane().add(btnIptal);
		
		JLabel lblEsyamlzmtarih = new JLabel("E\u015Fya yada Malzemenin Tarihini Giriniz.");
		lblEsyamlzmtarih.setBounds(10, 235, 226, 14);
		getContentPane().add(lblEsyamlzmtarih);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setBounds(85, 269, 46, 14);
		getContentPane().add(lblTarih);
		
		tarih = new JDateChooser();
		tarih.setBounds(27, 294, 170, 20);
		getContentPane().add(tarih);

	}
}
