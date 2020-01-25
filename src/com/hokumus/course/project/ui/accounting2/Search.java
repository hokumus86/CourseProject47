package com.hokumus.course.project.ui.accounting2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Search extends JFrame {
	private JLabel lblarama;
	private JTextField txtarama;
	private JTextField txtbilgigoster;
	private JButton btnara;
	
	public Search() {
		
		initialize();
		
		
	}

	private void initialize() {
		
		setTitle("ARAMA");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,400 );
		getContentPane().setLayout(null);
		getContentPane().add(getLblarama());
		getContentPane().add(getTxtarama());
		getContentPane().add(getTextField_1());
		getContentPane().add(getBtnara());
	}
	private JLabel getLblarama() {
		if (lblarama == null) {
			lblarama = new JLabel("Arama Yap\u0131lacak Ki\u015Finin TCKN giriniz.");
			lblarama.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblarama.setBounds(78, 39, 289, 35);
		}
		return lblarama;
	}
	private JTextField getTxtarama() {
		if (txtarama == null) {
			txtarama = new JTextField();
			txtarama.setBounds(136, 101, 198, 20);
			txtarama.setColumns(10);
		}
		return txtarama;
	}
	private JTextField getTextField_1() {
		if (txtbilgigoster == null) {
			txtbilgigoster = new JTextField();
			txtbilgigoster.setBounds(78, 186, 289, 132);
			txtbilgigoster.setColumns(10);
		}
		return txtbilgigoster;
	}
	private JButton getBtnara() {
		if (btnara == null) {
			btnara = new JButton("ARA");
			btnara.setBounds(185, 132, 89, 23);
		}
		return btnara;
	}
}
