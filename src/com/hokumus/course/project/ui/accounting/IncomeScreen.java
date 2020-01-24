package com.hokumus.course.project.ui.accounting;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class IncomeScreen extends JFrame {
	public IncomeScreen() {
		setTitle("Gelir Ekran\u0131");
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bu ay \u00F6\u011Frenci taksitleri ve sponsorluklardan toplamda 328.000TL gelir elde edildi.");
		lblNewLabel.setBounds(10, 79, 464, 14);
		getContentPane().add(lblNewLabel);
		setBounds(300, 300, 500, 500);
		
	}
}
