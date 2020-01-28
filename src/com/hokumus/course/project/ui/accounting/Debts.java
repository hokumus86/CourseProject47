package com.hokumus.course.project.ui.accounting;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

public class Debts extends JFrame {
	private JTextField txtisim;
	private JTextField txtsoyad;
	private JTextField txtalinan;
	private JTextField txtkalan;
	private JTable tableborclar;
	
	public Debts() {
		
		initialize();
		
	}

	private void initialize() {
		
		setTitle("BOR\u00C7LAR");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().setLayout(null);
		
		JLabel lblIsim = new JLabel("\u0130sim");
		lblIsim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIsim.setBounds(23, 29, 60, 14);
		getContentPane().add(lblIsim);
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setBounds(23, 54, 60, 14);
		getContentPane().add(lblSoyad);
		
		JLabel lblAlinan = new JLabel("Al\u0131nan");
		lblAlinan.setBounds(23, 79, 60, 14);
		getContentPane().add(lblAlinan);
		
		JLabel lblKalan = new JLabel("Kalan");
		lblKalan.setBounds(23, 104, 46, 14);
		getContentPane().add(lblKalan);
		
		JLabel lblAylar = new JLabel("Aylar");
		lblAylar.setBounds(270, 11, 46, 14);
		getContentPane().add(lblAylar);
		
		JPanel panel = new JPanel();
		panel.setBounds(217, 29, 115, 161);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JCheckBox checkBoxocak = new JCheckBox("1");
		checkBoxocak.setBounds(26, 7, 46, 23);
		panel.add(checkBoxocak);
		
		JCheckBox checkBoxsubat = new JCheckBox("2");
		checkBoxsubat.setBounds(74, 7, 43, 23);
		panel.add(checkBoxsubat);
		
		JCheckBox checkBoxmart = new JCheckBox("3");
		checkBoxmart.setBounds(26, 33, 46, 23);
		panel.add(checkBoxmart);
		
		JCheckBox checkBoxnisan = new JCheckBox("4");
		checkBoxnisan.setBounds(74, 33, 43, 23);
		panel.add(checkBoxnisan);
		
		JCheckBox checkBoxmayis = new JCheckBox("5");
		checkBoxmayis.setBounds(26, 59, 46, 23);
		panel.add(checkBoxmayis);
		
		JCheckBox checkBoxhaziran = new JCheckBox("6");
		checkBoxhaziran.setBounds(74, 59, 43, 23);
		panel.add(checkBoxhaziran);
		
		JCheckBox checkBoxtemmuz = new JCheckBox("7");
		checkBoxtemmuz.setBounds(26, 85, 46, 23);
		panel.add(checkBoxtemmuz);
		
		JCheckBox chckbxagustos = new JCheckBox("8");
		chckbxagustos.setBounds(74, 85, 43, 23);
		panel.add(chckbxagustos);
		
		JCheckBox checkBox = new JCheckBox("9");
		checkBox.setBounds(26, 111, 46, 23);
		panel.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("10");
		checkBox_1.setBounds(73, 111, 44, 23);
		panel.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("11");
		checkBox_2.setBounds(26, 137, 46, 23);
		panel.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("12");
		checkBox_3.setBounds(73, 137, 44, 23);
		panel.add(checkBox_3);
		
		txtisim = new JTextField();
		txtisim.setBounds(70, 27, 137, 20);
		getContentPane().add(txtisim);
		txtisim.setColumns(10);
		
		txtsoyad = new JTextField();
		txtsoyad.setBounds(70, 54, 137, 20);
		getContentPane().add(txtsoyad);
		txtsoyad.setColumns(10);
		
		txtalinan = new JTextField();
		txtalinan.setBounds(70, 79, 137, 20);
		getContentPane().add(txtalinan);
		txtalinan.setColumns(10);
		
		txtkalan = new JTextField();
		txtkalan.setBounds(70, 104, 137, 20);
		getContentPane().add(txtkalan);
		txtkalan.setColumns(10);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setBounds(342, 26, 89, 23);
		getContentPane().add(btnKaydet);
		
		JButton btnDzelt = new JButton("D\u00FCzelt");
		btnDzelt.setBounds(342, 75, 89, 23);
		getContentPane().add(btnDzelt);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.setBounds(342, 125, 89, 23);
		getContentPane().add(btnIptal);
		
		JScrollPane scrollPaneborc = new JScrollPane();
		scrollPaneborc.setBounds(10, 201, 464, 249);
		scrollPaneborc.setLayout(null);
		getContentPane().add(scrollPaneborc);
		
		tableborclar = new JTable();
		scrollPaneborc.setViewportView(tableborclar);
		
	}
}
