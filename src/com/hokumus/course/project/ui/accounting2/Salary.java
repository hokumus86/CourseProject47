package com.hokumus.course.project.ui.accounting2;

import javax.swing.JFrame;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.List;
import java.awt.Panel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class Salary extends JFrame {
	private JComboBox cmbogrtmsec;
	private JLabel lblogrtmnsec;
	private JComboBox cmbprsnsec;
	private JLabel lblpersonelsec;
	
	public Salary() {
		
		initialize();
		
	}

	private void initialize() {
		setTitle("MAAÞ");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,400 );
		getContentPane().setLayout(null);
		getContentPane().add(getCmbogrtmsec());
		getContentPane().add(getLblogrtmnsec());
		getContentPane().add(getCmbprsnsec());
		getContentPane().add(getLblpersonelsec());
		
	}
	private JComboBox getCmbogrtmsec() {
		if (cmbogrtmsec == null) {
			cmbogrtmsec = new JComboBox();
			cmbogrtmsec.setBounds(31, 84, 108, 20);
		}
		return cmbogrtmsec;
	}
	private JLabel getLblogrtmnsec() {
		if (lblogrtmnsec == null) {
			lblogrtmnsec = new JLabel("\u00D6\u011Fretmenleri se\u00E7iniz.");
			lblogrtmnsec.setBounds(31, 38, 108, 14);
		}
		return lblogrtmnsec;
	}
	private JComboBox getCmbprsnsec() {
		if (cmbprsnsec == null) {
			cmbprsnsec = new JComboBox();
			cmbprsnsec.setBounds(303, 84, 108, 20);
		}
		return cmbprsnsec;
	}
	private JLabel getLblpersonelsec() {
		if (lblpersonelsec == null) {
			lblpersonelsec = new JLabel("Personelleri se\u00E7iniz.");
			lblpersonelsec.setBounds(303, 38, 108, 14);
		}
		return lblpersonelsec;
	}
}
