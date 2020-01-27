package com.hokumus.course.project.ui.accounting;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bills extends JFrame {
	
	public Bills() {
		
		initialize();
		
	}

	private void initialize() {
		setTitle("FATURALAR");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		getContentPane().setLayout(null);
		
		JLabel lblFaturaKaydet = new JLabel("Fatura Kaydet");
		lblFaturaKaydet.setBounds(71, 36, 83, 14);
		getContentPane().add(lblFaturaKaydet);
		
		JLabel lblFaturaGrntle = new JLabel("Fatura G\u00F6r\u00FCnt\u00FCle");
		lblFaturaGrntle.setBounds(287, 36, 108, 14);
		getContentPane().add(lblFaturaGrntle);
		
		JLabel lblFilechooser = new JLabel("filechooser yap");
		lblFilechooser.setBounds(189, 120, 101, 14);
		getContentPane().add(lblFilechooser);
		
	}

}
