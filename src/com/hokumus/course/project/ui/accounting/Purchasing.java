package com.hokumus.course.project.ui.accounting;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Purchasing extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	
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
		
		textField = new JTextField();
		textField.setBounds(27, 88, 170, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEsyamlzmfiyat = new JLabel("E\u015Fya yada Malzemelerin fiyat\u0131n\u0131 giriniz.");
		lblEsyamlzmfiyat.setBounds(10, 131, 228, 21);
		getContentPane().add(lblEsyamlzmfiyat);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(27, 188, 170, 20);
		getContentPane().add(textField_1);
		
		JLabel lblMalzeme = new JLabel("Malzeme");
		lblMalzeme.setBounds(85, 69, 64, 14);
		getContentPane().add(lblMalzeme);
		
		JLabel lblFiyat = new JLabel("Fiyat");
		lblFiyat.setBounds(85, 163, 46, 14);
		getContentPane().add(lblFiyat);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setBounds(10, 351, 89, 23);
		getContentPane().add(btnKaydet);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.setBounds(108, 351, 89, 23);
		getContentPane().add(btnIptal);
		
		JLabel lblEsyamlzmtarih = new JLabel("E\u015Fya yada Malzemenin Tarihini Giriniz.");
		lblEsyamlzmtarih.setBounds(10, 235, 226, 14);
		getContentPane().add(lblEsyamlzmtarih);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setBounds(85, 269, 46, 14);
		getContentPane().add(lblTarih);
		
	}
}
