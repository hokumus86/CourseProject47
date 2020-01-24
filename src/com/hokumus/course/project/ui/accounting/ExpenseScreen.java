package com.hokumus.course.project.ui.accounting;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExpenseScreen extends JFrame {
	public ExpenseScreen() {
		setTitle("Gider Ekran\u0131");
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bu ay k\u0131r\u0131lan e\u015Fyalar, gelen faturalar ve verilen maa\u015Flar ile birlikte toplam 240.000TL gider var.");
		lblNewLabel.setBounds(10, 94, 464, 14);
		getContentPane().add(lblNewLabel);
		setBounds(300, 300, 500, 500);
		
	}
}
