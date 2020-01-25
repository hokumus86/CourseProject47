package com.hokumus.course.project.ui.accounting2;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
	
	
	private JButton btnexpense;
	private JButton btnincome;
	private JButton btnotherexpense;
	private JButton btnsorgu;
	
	public Main() {
		
		initialize();
		
	}

	private void initialize() {
		setTitle("MUHASEBE");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,400 );
		getContentPane().setLayout(null);
		getContentPane().add(getBtnexpense());
		getContentPane().add(getBtnincome());
		getContentPane().add(getBtnotherexpense());
		getContentPane().add(getBtnsorgu());
		setBounds(300, 100, 500, 400);
		
	}
	private JButton getBtnexpense() {
		if (btnexpense == null) {
			btnexpense = new JButton("HARCAMALAR");
			btnexpense.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					new Expenses().setVisible(true);
					
				}
			});
			btnexpense.setBounds(33, 34, 417, 49);
		}
		return btnexpense;
	}
	private JButton getBtnincome() {
		if (btnincome == null) {
			btnincome = new JButton("GEL\u0130RLER");
			btnincome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Incomings().setVisible(true);
				}
			});
			btnincome.setBounds(33, 104, 417, 49);
		}
		return btnincome;
	}
	private JButton getBtnotherexpense() {
		if (btnotherexpense == null) {
			btnotherexpense = new JButton("D\u0130\u011EER HARCAMALAR");
			btnotherexpense.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new OtherExpenses().setVisible(true);
				}
			});
			btnotherexpense.setBounds(33, 177, 417, 49);
		}
		return btnotherexpense;
	}
	private JButton getBtnsorgu() {
		if (btnsorgu == null) {
			btnsorgu = new JButton("SORGULAMA");
			btnsorgu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Search().setVisible(true);
				}
			});
			btnsorgu.setBounds(33, 247, 417, 45);
		}
		return btnsorgu;
	}
}
