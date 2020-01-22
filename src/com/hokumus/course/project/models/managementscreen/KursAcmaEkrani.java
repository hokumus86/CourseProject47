package com.hokumus.course.project.models.managementscreen;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class KursAcmaEkrani extends JFrame {
	private JLabel lblKursAd;
	private JLabel lblBalamaTarihi;
	private JTextField txtbaslamaTarihi;
	private JLabel lblFiyat;
	private JTextField txtfiyat;
	private JLabel lblDurum;
	private JTextField txtKullaniciAdi;
	private JComboBox comboBox;
	private JButton btnKaydet;
	private JButton btnIptal;

	public KursAcmaEkrani() {
		initalize();
		
		
	}

	private void initalize() {
		setTitle("Kurs A\u00E7ma");
		setBounds(400, 200, 684, 400);
		getContentPane().setLayout(null);
		getContentPane().add(getLblKursAd());
		getContentPane().add(getLblBalamaTarihi());
		getContentPane().add(getTxtbaslamaTarihi());
		getContentPane().add(getLblFiyat());
		getContentPane().add(getTxtfiyat());
		getContentPane().add(getLblDurum());
		getContentPane().add(getTxtKullaniciAdi());
		getContentPane().add(getComboBox());
		getContentPane().add(getBtnKaydet());
		getContentPane().add(getBtnIptal());
	}
	private JLabel getLblKursAd() {
		if (lblKursAd == null) {
			lblKursAd = new JLabel("Kurs Ad\u0131:");
			lblKursAd.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblKursAd.setBounds(39, 63, 78, 14);
		}
		return lblKursAd;
	}
	private JLabel getLblBalamaTarihi() {
		if (lblBalamaTarihi == null) {
			lblBalamaTarihi = new JLabel("Ba\u015Flama Tarihi:");
			lblBalamaTarihi.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBalamaTarihi.setBounds(39, 127, 108, 14);
		}
		return lblBalamaTarihi;
	}
	private JTextField getTxtbaslamaTarihi() {
		if (txtbaslamaTarihi == null) {
			txtbaslamaTarihi = new JTextField();
			txtbaslamaTarihi.setColumns(10);
			txtbaslamaTarihi.setBounds(150, 124, 127, 20);
		}
		return txtbaslamaTarihi;
	}
	private JLabel getLblFiyat() {
		if (lblFiyat == null) {
			lblFiyat = new JLabel("Fiyat:");
			lblFiyat.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFiyat.setBounds(39, 191, 46, 14);
		}
		return lblFiyat;
	}
	private JTextField getTxtfiyat() {
		if (txtfiyat == null) {
			txtfiyat = new JTextField();
			txtfiyat.setColumns(10);
			txtfiyat.setBounds(150, 188, 127, 20);
		}
		return txtfiyat;
	}
	private JLabel getLblDurum() {
		if (lblDurum == null) {
			lblDurum = new JLabel("Durum:");
			lblDurum.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDurum.setBounds(39, 260, 78, 17);
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
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"AKT\u0130F", "PAS\u0130F"}));
			comboBox.setBounds(150, 260, 127, 20);
		}
		return comboBox;
	}
	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.setBounds(475, 79, 114, 38);
		}
		return btnKaydet;
	}
	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.setBounds(475, 168, 114, 40);
		}
		return btnIptal;
	}
}
