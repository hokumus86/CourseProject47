package com.hokumus.course.project.ui.accounting;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.BorderLayout;

public class ExpenseScreen extends JFrame {

	public ExpenseScreen() {

		initialize();
	}

	private void initialize() {
		
		setTitle("HARCAMALAR");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		getContentPane().setLayout(null);
		
		JButton btnmaas = new JButton("MAA\u015E");
		btnmaas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Salary().setVisible(true);
			}
		});
		btnmaas.setBounds(40, 69, 123, 83);
		getContentPane().add(btnmaas);
		
		JButton btnsatnalma = new JButton("SATIN ALMA");
		btnsatnalma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Purchasing().setVisible(true);
			}
		});
		btnsatnalma.setBounds(317, 69, 123, 83);
		getContentPane().add(btnsatnalma);
		
		JButton btnfaturalar = new JButton("FATURALAR");
		btnfaturalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bills().setVisible(true);
			}
		});
		btnfaturalar.setBounds(40, 212, 123, 83);
		getContentPane().add(btnfaturalar);
		
		JButton btnborclar = new JButton("BOR\u00C7LAR");
		btnborclar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Debts().setVisible(true);
			}
		});
		btnborclar.setBounds(317, 212, 123, 83);
		getContentPane().add(btnborclar);

	}
}
