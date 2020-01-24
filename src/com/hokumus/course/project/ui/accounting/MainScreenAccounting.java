package com.hokumus.course.project.ui.accounting;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreenAccounting extends JFrame{
	public MainScreenAccounting() {
		setTitle("Ana Muhasebe Ekran\u0131");
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);
		
		JButton btnIncome = new JButton("Gelirleri G\u00F6r!");
		btnIncome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IncomeScreen().setVisible(true);
			}
		});
		btnIncome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIncome.setBounds(10, 63, 171, 123);
		getContentPane().add(btnIncome);
		
		JButton btnExpense = new JButton("Giderleri G\u00F6r!");
		btnExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExpenseScreen().setVisible(true);
			}
		});
		btnExpense.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExpense.setBounds(303, 63, 171, 123);
		getContentPane().add(btnExpense);
		
		JButton btnGenelAnaliz = new JButton("Genel Analiz!");
		btnGenelAnaliz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGenelAnaliz.setBounds(10, 259, 171, 123);
		getContentPane().add(btnGenelAnaliz);
		
		JButton btnBorc = new JButton("Bor\u00E7lu Ki\u015Fileri G\u00F6ster!");
		btnBorc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorc.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnBorc.setBounds(303, 259, 171, 123);
		getContentPane().add(btnBorc);
		setBounds(300, 300, 500, 500);
		
	}
}
