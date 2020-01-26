package com.hokumus.course.project.ui.managementscreen;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.hokumus.course.project.models.CourseUsers;
import com.hokumus.course.project.models.management.Courses;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;

import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;


public class KursAcmaEkrani extends JFrame {
	private JLabel lblKursAd;
	private JLabel lblFiyat;
	private JTextField txtfiyat;
	private JLabel lblDurum;
	private JTextField txtKullaniciAdi;
	private JComboBox cmbDurum;
	private JButton btnKaydet;
	private JButton btnIptal;
	private JLabel lblMesaj;

	public KursAcmaEkrani() {
		initalize();
		
		
	}

	private void initalize() {
		setTitle("Kurs A\u00E7ma  -"+CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
		setBounds(400, 200, 684, 400);
		getContentPane().setLayout(null);
		getContentPane().add(getLblKursAd());
		getContentPane().add(getLblFiyat());
		getContentPane().add(getTxtfiyat());
		getContentPane().add(getLblDurum());
		getContentPane().add(getTxtKullaniciAdi());
		getContentPane().add(getCmbDurum());
		getContentPane().add(getBtnKaydet());
		getContentPane().add(getBtnIptal());
		getContentPane().add(getLblMesaj());
	}
	
	
	
	
	
	
	
	private JLabel getLblKursAd() {
		if (lblKursAd == null) {
			lblKursAd = new JLabel("Kurs Ad\u0131:");
			lblKursAd.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblKursAd.setBounds(39, 63, 78, 14);
		}
		return lblKursAd;
	}
	private JLabel getLblFiyat() {
		if (lblFiyat == null) {
			lblFiyat = new JLabel("Fiyat:");
			lblFiyat.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFiyat.setBounds(42, 132, 46, 14);
		}
		return lblFiyat;
	}
	private JTextField getTxtfiyat() {
		if (txtfiyat == null) {
			txtfiyat = new JTextField();
			txtfiyat.setColumns(10);
			txtfiyat.setBounds(150, 131, 127, 20);
		}
		return txtfiyat;
	}
	private JLabel getLblDurum() {
		if (lblDurum == null) {
			lblDurum = new JLabel("Durum:");
			lblDurum.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDurum.setBounds(39, 193, 78, 17);
		}
		return lblDurum;
	}
	private JTextField getTxtKullaniciAdi() {
		if (txtKullaniciAdi == null) {
			txtKullaniciAdi = new JTextField();
			txtKullaniciAdi.setColumns(10);
			txtKullaniciAdi.setBounds(150, 62, 127, 20);
		}
		return txtKullaniciAdi;
	}
	private JComboBox getCmbDurum() {
		if (cmbDurum == null) {
			cmbDurum = new JComboBox();
			cmbDurum.setModel(new DefaultComboBoxModel(new String[] {"AKT\u0130F", "PAS\u0130F"}));
			cmbDurum.setBounds(150, 193, 127, 20);
		}
		return cmbDurum;
	}
	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Courses> dao=new DbServicessBase<Courses>();
					DateTimeFormatter format=DateTimeFormatter.ofPattern("d/M/yyyy");
					
					Courses temp=new Courses();
					temp.setAdi(txtKullaniciAdi.getText());
					temp.setDurum(cmbDurum.getSelectedItem().toString());
					temp.setFiyat(new BigDecimal(txtfiyat.getText()));
					
					if (dao.save(temp)) {
						lblMesaj.setText("Kurs Baþarlý Ýle Oluþturuldu");
					}
					else {
						lblMesaj.setText("Kurs Baþarlý Ýle Oluþturulamadý");
					}
					
					
					
				}
			});
			btnKaydet.setBounds(475, 79, 114, 38);
		}
		return btnKaydet;
	}
	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					KursAcmaEkrani.this.dispose();
				}
			});
			btnIptal.setBounds(475, 168, 114, 40);
		}
		return btnIptal;
	}
	private JLabel getLblMesaj() {
		if (lblMesaj == null) {
			lblMesaj = new JLabel("");
			lblMesaj.setBounds(0, 330, 668, 31);
		}
		return lblMesaj;
	}
}
