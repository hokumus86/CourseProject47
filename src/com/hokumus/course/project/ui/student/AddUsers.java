package com.hokumus.course.project.ui.student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hokumus.course.project.models.student.Student;
import com.hokumus.course.project.utils.dao.StudentDAO;
import com.toedter.calendar.JDateChooser;

public class AddUsers extends JFrame { // ???????

	private JTextField txtAdi;
	private JTextField txtTelNo;
	private JTextField txtAdress;
	private JTextField txtMail;
	private JDateChooser dateKayitTarihi;
	private JTextField txtSoyadi;

	public AddUsers() {
		
		initialize();
		
	}

	private void initialize() {
		setTitle("KAYIT");
		setBounds(300, 300, 550, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblAdi = new JLabel("Ad\u0131 ");
		lblAdi.setFont(new Font("Arial", Font.BOLD, 12));
		lblAdi.setBounds(23, 24, 67, 14);
		getContentPane().add(lblAdi);

		txtAdi = new JTextField();
		txtAdi.setBounds(100, 21, 158, 20);
		getContentPane().add(txtAdi);
		txtAdi.setColumns(10);

		JLabel lblSoyadi = new JLabel("Soyad");
		lblSoyadi.setFont(new Font("Arial", Font.BOLD, 12));
		lblSoyadi.setBounds(282, 27, 67, 14);
		getContentPane().add(lblSoyadi);

		JLabel lblTel = new JLabel("Telefon No");
		lblTel.setFont(new Font("Arial", Font.BOLD, 12));
		lblTel.setBounds(23, 75, 67, 14);
		getContentPane().add(lblTel);

		txtTelNo = new JTextField();
		txtTelNo.setColumns(10);
		txtTelNo.setBounds(100, 72, 158, 20);
		getContentPane().add(txtTelNo);

		JLabel lblKytTrihi = new JLabel("Kay\u0131t Tarihi");
		lblKytTrihi.setFont(new Font("Arial", Font.BOLD, 12));
		lblKytTrihi.setBounds(282, 78, 67, 14);
		getContentPane().add(lblKytTrihi);

		JLabel lblAdress = new JLabel("Adres");
		lblAdress.setFont(new Font("Arial", Font.BOLD, 12));
		lblAdress.setBounds(23, 128, 67, 14);
		getContentPane().add(lblAdress);

		txtAdress = new JTextField();
		txtAdress.setColumns(10);
		txtAdress.setBounds(100, 125, 158, 82);
		getContentPane().add(txtAdress);

		JLabel lblMail = new JLabel("Email");
		lblMail.setFont(new Font("Arial", Font.BOLD, 12));
		lblMail.setBounds(282, 128, 67, 14);
		getContentPane().add(lblMail);

		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.setBounds(282, 215, 91, 23);
		btnIptal.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(btnIptal);
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUsers.this.dispose();
			}
		});

		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setBounds(394, 215, 91, 23);
		btnKaydet.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(btnKaydet);
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDAO studentDao = new StudentDAO();
				Student student = new Student();
				student.setAd(txtAdi.getText());
				student.setSoyad(txtSoyadi.getText()); // ?????????
				student.setAdres(txtAdress.getText());
				student.setMail(txtMail.getText());
				if (studentDao.save(student)) {
					JOptionPane.showMessageDialog(AddUsers.this, "Kayýt Baþarýlý..!");
				} else
					JOptionPane.showMessageDialog(AddUsers.this, "Kayýt Baþarýsýz..!");
			}
		});

		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(359, 125, 130, 20);
		getContentPane().add(txtMail);

		dateKayitTarihi = new JDateChooser();
		dateKayitTarihi.setBounds(359, 75, 130, 20);
		getContentPane().add(dateKayitTarihi);
		
		txtSoyadi = new JTextField();
		txtSoyadi.setColumns(10);
		txtSoyadi.setBounds(359, 22, 130, 20);
		getContentPane().add(txtSoyadi);

	}
}
