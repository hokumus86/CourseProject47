package com.hokumus.course.project.ui.student;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import com.toedter.calendar.JDateChooser;

public class AddUsers extends JFrame{
	
	private JTextField txtKulAdi;
	private JTextField txtEmail;
	private JTextField txtAdi;
	private JTextField txtSoyadi;
	private JPasswordField txtSifre;
	private JDateChooser dateUyelikTarihi;
	
	public AddUsers() {
		initialize();
	}

	private void initialize() {
		
		setBounds(300, 300, 550, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAdi = new JLabel("Ad\u0131 ");
		lblAdi.setBounds(23, 24, 67, 14);
		getContentPane().add(lblAdi);
		
		txtKulAdi = new JTextField();
		txtKulAdi.setBounds(100, 21, 158, 20);
		getContentPane().add(txtKulAdi);
		txtKulAdi.setColumns(10);
		
		JLabel lblSoyadi = new JLabel("Soyad");
		lblSoyadi.setBounds(282, 27, 67, 14);
		getContentPane().add(lblSoyadi);
		
		JLabel lblTel = new JLabel("Telefon No");
		lblTel.setBounds(23, 75, 67, 14);
		getContentPane().add(lblTel);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(100, 72, 158, 20);
		getContentPane().add(txtEmail);
		
		JLabel lblKytTrihi = new JLabel("Kay\u0131t Tarihi");
		lblKytTrihi.setBounds(282, 78, 67, 14);
		getContentPane().add(lblKytTrihi);
		
		JLabel lblAdress = new JLabel("Adres");
		lblAdress.setBounds(23, 128, 67, 14);
		getContentPane().add(lblAdress);
		
		txtAdi = new JTextField();
		txtAdi.setColumns(10);
		txtAdi.setBounds(100, 125, 158, 82);
		getContentPane().add(txtAdi);
		
		JLabel lblMail = new JLabel("Email");
		lblMail.setBounds(282, 128, 67, 14);
		getContentPane().add(lblMail);
		
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.setBounds(297, 184, 91, 23);
		btnIptal.setFont(new Font("arial", Font.TRUETYPE_FONT, 12));
		getContentPane().add(btnIptal);
		btnIptal.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				AddUsers.this.dispose();				
			}
		});
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setBounds(398, 184, 91, 23);
		btnKaydet.setFont(new Font("arial", Font.TRUETYPE_FONT, 12));
		getContentPane().add(btnKaydet);
		btnKaydet.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
							
			}
		});
		
		txtSoyadi = new JTextField();
		txtSoyadi.setColumns(10);
		txtSoyadi.setBounds(359, 125, 130, 20);
		getContentPane().add(txtSoyadi);
		
		
		txtSifre = new JPasswordField();
		txtSifre.setBounds(358, 21, 131, 20);
		getContentPane().add(txtSifre);
		
		dateUyelikTarihi = new JDateChooser();
		dateUyelikTarihi.setBounds(359, 75, 130, 20);
		getContentPane().add(dateUyelikTarihi);
		setTitle("KAYIT");
		
	}
}
