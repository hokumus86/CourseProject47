package com.hokumus.course.project.ui.accounting;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import com.toedter.calendar.JDateChooser;


public class Salary extends JFrame {
	private JDateChooser tarih2;
	
	public Salary () {
		
		initialize();
		
		
	}

	private void initialize() {
		setTitle("MAAÞ");		
		setBounds(300, 300, 500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblogrtmnsec = new JLabel("\u00D6\u011Fretmen Se\u00E7iniz.");
		lblogrtmnsec.setBounds(27, 18, 154, 39);
		getContentPane().add(lblogrtmnsec);
		
		JLabel lblpersonelsec = new JLabel("Personel Se\u00E7iniz.");
		lblpersonelsec.setBounds(203, 18, 154, 39);
		getContentPane().add(lblpersonelsec);
		
		JComboBox comboBoxpersonelsec = new JComboBox();
		comboBoxpersonelsec.setBounds(167, 53, 147, 31);
		getContentPane().add(comboBoxpersonelsec);
		
		JComboBox comboBoxogrtmnsec = new JComboBox();
		comboBoxogrtmnsec.setBounds(10, 53, 147, 31);
		getContentPane().add(comboBoxogrtmnsec);
		
		JButton btnHesapla = new JButton("Hesapla");
		btnHesapla.setBounds(180, 160, 115, 39);
		getContentPane().add(btnHesapla);
		
		JScrollPane scrlpnmaastablo = new JScrollPane();
		scrlpnmaastablo.setBounds(10, 210, 464, 240);
		getContentPane().add(scrlpnmaastablo);
		
		tarih2 = new JDateChooser();
		tarih2.setBounds(344, 53, 130, 20);
		getContentPane().add(tarih2);
		
		JLabel lblTarih2 = new JLabel("Tarih");
		lblTarih2.setBounds(380, 30, 46, 14);
		getContentPane().add(lblTarih2);
	}
}
