package com.hokumus.course.project.ui.accounting2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class OtherExpenses extends JFrame {
	private JLabel lblelektrik;
	private JLabel lblsu;
	private JLabel lbldglgaz;
	private JLabel lblvergi;
	private JLabel lblinternet;
	private JLabel lblkira;
	private JTextField txtelektrik;
	private JTextField txtsu;
	private JTextField txtgaz;
	private JTextField txtvergi;
	private JTextField txtinternet;
	private JTextField txtkira;
	private JLabel lbltoplam;
	private JTextField txttoplam;
	private JButton btntopla;
	
	public OtherExpenses() {
		
		initialize();
		
		
	}

	private void initialize() {
		
		setTitle("DÝÐER HARCAMALAR");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,400 );
		getContentPane().setLayout(null);
		getContentPane().add(getLblelektrik());
		getContentPane().add(getLblsu());
		getContentPane().add(getLbldglgaz());
		getContentPane().add(getLblvergi());
		getContentPane().add(getLblinternet());
		getContentPane().add(getLblkira());
		getContentPane().add(getTxtelektrik());
		getContentPane().add(getTxtsu());
		getContentPane().add(getTxtgaz());
		getContentPane().add(getTxtvergi());
		getContentPane().add(getTxtinternet());
		getContentPane().add(getTxtkira());
		getContentPane().add(getLbltoplam());
		getContentPane().add(getTxttoplam());
		getContentPane().add(getBtntopla());
		
	}

	private JLabel getLblelektrik() {
		if (lblelektrik == null) {
			lblelektrik = new JLabel("Elektrik Faturas\u0131");
			lblelektrik.setBounds(44, 39, 81, 14);
		}
		return lblelektrik;
	}
	private JLabel getLblsu() {
		if (lblsu == null) {
			lblsu = new JLabel("Su Faturas\u0131");
			lblsu.setBounds(44, 78, 81, 14);
		}
		return lblsu;
	}
	private JLabel getLbldglgaz() {
		if (lbldglgaz == null) {
			lbldglgaz = new JLabel("Do\u011Falgaz Faturas\u0131");
			lbldglgaz.setBounds(44, 120, 81, 14);
		}
		return lbldglgaz;
	}
	private JLabel getLblvergi() {
		if (lblvergi == null) {
			lblvergi = new JLabel("VERG\u0130");
			lblvergi.setBounds(44, 162, 81, 14);
		}
		return lblvergi;
	}
	private JLabel getLblinternet() {
		if (lblinternet == null) {
			lblinternet = new JLabel("\u0130nternet Faturas\u0131");
			lblinternet.setBounds(44, 212, 81, 14);
		}
		return lblinternet;
	}
	private JLabel getLblkira() {
		if (lblkira == null) {
			lblkira = new JLabel("K\u0130RA ");
			lblkira.setBounds(44, 262, 81, 14);
		}
		return lblkira;
	}
	private JTextField getTxtelektrik() {
		if (txtelektrik == null) {
			txtelektrik = new JTextField();
			txtelektrik.setBounds(178, 36, 86, 20);
			txtelektrik.setColumns(10);
		}
		return txtelektrik;
	}
	private JTextField getTxtsu() {
		if (txtsu == null) {
			txtsu = new JTextField();
			txtsu.setColumns(10);
			txtsu.setBounds(178, 75, 86, 20);
		}
		return txtsu;
	}
	private JTextField getTxtgaz() {
		if (txtgaz == null) {
			txtgaz = new JTextField();
			txtgaz.setColumns(10);
			txtgaz.setBounds(178, 117, 86, 20);
		}
		return txtgaz;
	}
	private JTextField getTxtvergi() {
		if (txtvergi == null) {
			txtvergi = new JTextField();
			txtvergi.setColumns(10);
			txtvergi.setBounds(178, 159, 86, 20);
		}
		return txtvergi;
	}
	private JTextField getTxtinternet() {
		if (txtinternet == null) {
			txtinternet = new JTextField();
			txtinternet.setColumns(10);
			txtinternet.setBounds(178, 209, 86, 20);
		}
		return txtinternet;
	}
	private JTextField getTxtkira() {
		if (txtkira == null) {
			txtkira = new JTextField();
			txtkira.setColumns(10);
			txtkira.setBounds(178, 259, 86, 20);
		}
		return txtkira;
	}
	private JLabel getLbltoplam() {
		if (lbltoplam == null) {
			lbltoplam = new JLabel("TOPLAM");
			lbltoplam.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbltoplam.setBounds(339, 134, 94, 14);
		}
		return lbltoplam;
	}
	private JTextField getTxttoplam() {
		if (txttoplam == null) {
			txttoplam = new JTextField();
			txttoplam.setBounds(298, 159, 147, 48);
			txttoplam.setColumns(10);
		}
		return txttoplam;
	}
	private JButton getBtntopla() {
		if (btntopla == null) {
			btntopla = new JButton("Topla");
			btntopla.setBounds(175, 307, 89, 23);
		}
		return btntopla;
	}
}
