package com.hokumus.course.project.models.managementscreen;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SinifAcmaEkrani extends JFrame{
	private JLabel lblAd;
	private JTextField txtSinifAdi;
	private JLabel lblSinifKodu;
	private JTextField txtSinifKodu;
	private JLabel lblKapasite;
	private JTextField txtKapasite;
	private JButton btnKaydet;
	private JButton btnIptal;
	public SinifAcmaEkrani() {
		initialize();
	}

	private void initialize() {
		setTitle("S\u0131n\u0131f A\u00E7ma");
		setBounds(400, 200, 540, 335);
		getContentPane().setLayout(null);
		getContentPane().add(getLblAd());
		getContentPane().add(getTxtSinifAdi());
		getContentPane().add(getLblSinifKodu());
		getContentPane().add(getTxtSinifKodu());
		getContentPane().add(getLblKapasite());
		getContentPane().add(getTxtKapasite());
		getContentPane().add(getBtnKaydet());
		getContentPane().add(getBtnIptal());
	}
	private JLabel getLblAd() {
		if (lblAd == null) {
			lblAd = new JLabel("S\u0131n\u0131f Ad\u0131:");
			lblAd.setBounds(39, 66, 105, 26);
		}
		return lblAd;
	}
	private JTextField getTxtSinifAdi() {
		if (txtSinifAdi == null) {
			txtSinifAdi = new JTextField();
			txtSinifAdi.setBounds(134, 69, 113, 20);
			txtSinifAdi.setColumns(10);
		}
		return txtSinifAdi;
	}
	private JLabel getLblSinifKodu() {
		if (lblSinifKodu == null) {
			lblSinifKodu = new JLabel("S\u0131n\u0131f Kodu:");
			lblSinifKodu.setBounds(39, 138, 78, 14);
		}
		return lblSinifKodu;
	}
	private JTextField getTxtSinifKodu() {
		if (txtSinifKodu == null) {
			txtSinifKodu = new JTextField();
			txtSinifKodu.setColumns(10);
			txtSinifKodu.setBounds(134, 135, 113, 20);
		}
		return txtSinifKodu;
	}
	private JLabel getLblKapasite() {
		if (lblKapasite == null) {
			lblKapasite = new JLabel("Kapasite:");
			lblKapasite.setBounds(39, 204, 71, 14);
		}
		return lblKapasite;
	}
	private JTextField getTxtKapasite() {
		if (txtKapasite == null) {
			txtKapasite = new JTextField();
			txtKapasite.setColumns(10);
			txtKapasite.setBounds(134, 201, 113, 20);
		}
		return txtKapasite;
	}
	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.setBounds(345, 68, 89, 23);
		}
		return btnKaydet;
	}
	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.setBounds(345, 134, 89, 23);
		}
		return btnIptal;
	}
}
