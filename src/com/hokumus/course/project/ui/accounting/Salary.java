package com.hokumus.course.project.ui.accounting;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;


public class Salary extends JFrame {
	
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
		
		JLabel lblAylar = new JLabel("Aylar");
		lblAylar.setBounds(397, 30, 46, 14);
		getContentPane().add(lblAylar);
		
		JPanel panel = new JPanel();
		panel.setBounds(348, 43, 115, 161);
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
		
		JComboBox comboBoxpersonelsec = new JComboBox();
		comboBoxpersonelsec.setBounds(191, 53, 147, 31);
		getContentPane().add(comboBoxpersonelsec);
		
		JComboBox comboBoxogrtmnsec = new JComboBox();
		comboBoxogrtmnsec.setBounds(22, 53, 147, 31);
		getContentPane().add(comboBoxogrtmnsec);
		
		JButton btnHesapla = new JButton("Hesapla");
		btnHesapla.setBounds(130, 164, 115, 39);
		getContentPane().add(btnHesapla);
		
		JScrollPane scrlpnmaastablo = new JScrollPane();
		scrlpnmaastablo.setBounds(10, 210, 464, 240);
		getContentPane().add(scrlpnmaastablo);
		
	}
}
