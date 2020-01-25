package com.hokumus.course.project.ui.accounting2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Expenses extends JFrame {
	private JButton btnmaas;
	private JButton btnsatinalma;
	private JButton btnfatura;
	private JButton btnborclar;
	
	public Expenses() {
		
		initialize();
		
		
	}

	private void initialize() {
		
		setTitle("HARCAMALAR");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,400 );
		getContentPane().setLayout(null);
		getContentPane().add(getBtnmaas());
		getContentPane().add(getBtnsatinalma());
		getContentPane().add(getBtnfatura());
		getContentPane().add(getBtnborclar());
		
	}
	private JButton getBtnmaas() {
		if (btnmaas == null) {
			btnmaas = new JButton("MAA\u015E");
			btnmaas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					new Salary().setVisible(true);
				}
			});
			btnmaas.setBounds(83, 57, 131, 89);
		}
		return btnmaas;
	}
	private JButton getBtnsatinalma() {
		if (btnsatinalma == null) {
			btnsatinalma = new JButton("SATIN ALMA");
			btnsatinalma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Purchasing().setVisible(true);
				}
			});
			btnsatinalma.setBounds(287, 57, 131, 89);
		}
		return btnsatinalma;
	}
	private JButton getBtnfatura() {
		if (btnfatura == null) {
			btnfatura = new JButton("FATURALAR");
			btnfatura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Bills().setVisible(true);
				}
			});
			btnfatura.setBounds(83, 205, 131, 89);
		}
		return btnfatura;
	}
	private JButton getBtnborclar() {
		if (btnborclar == null) {
			btnborclar = new JButton("BOR\u00C7LAR");
			btnborclar.setBounds(287, 205, 131, 89);
		}
		return btnborclar;
	}
}
