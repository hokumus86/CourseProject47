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
		
		JLabel lblEsyaYadaMalzemelerin = new JLabel("E\u015Fya yada Malzemelerin fiyat\u0131n\u0131 giriniz.");
		lblEsyaYadaMalzemelerin.setBounds(246, 34, 228, 21);
		getContentPane().add(lblEsyaYadaMalzemelerin);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(246, 88, 170, 20);
		getContentPane().add(textField_1);
		
		JLabel lblMalzeme = new JLabel("Malzeme");
		lblMalzeme.setBounds(85, 69, 64, 14);
		getContentPane().add(lblMalzeme);
		
		JLabel lblFiyat = new JLabel("Fiyat");
		lblFiyat.setBounds(309, 69, 46, 14);
		getContentPane().add(lblFiyat);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.setBounds(172, 169, 89, 23);
		getContentPane().add(btnEkle);
		
	}
}
