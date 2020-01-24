package com.hokumus.course.project.ui.accounting;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class DebtorsScreen extends JFrame {
	public DebtorsScreen() {
		setTitle("Borçlu Kiþiler Ekran\u0131");
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);
		
		JLabel lbl = new JLabel("X Ki\u015Fisinin 2000TL Borcu var.");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl.setBounds(10, 59, 278, 14);
		getContentPane().add(lbl);
		setBounds(300, 300, 500, 500);

	}

}
