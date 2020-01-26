package com.hokumus.course.project.ui.managementscreen;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.hokumus.course.project.models.management.LessonClass;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;


public class SinifAcmaEkrani extends JFrame{
	private JLabel lblAd;
	private JTextField txtSinifAdi;
	private JLabel lblSinifKodu;
	private JTextField txtSinifKodu;
	private JLabel lblKapasite;
	private JTextField txtKapasite;
	private JButton btnKaydet;
	private JButton btnIptal;
	private JLabel lblMesaj;
	public SinifAcmaEkrani() {
		initialize();
	}

	private void initialize() {
		setTitle("S\u0131n\u0131f A\u00E7ma  -"+CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
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
		getContentPane().add(getLblMesaj());
	}
	private JLabel getLblAd() {
		if (lblAd == null) {
			lblAd = new JLabel("S\u0131n\u0131f Ad\u0131:");
			lblAd.setBounds(10, 36, 105, 26);
		}
		return lblAd;
	}
	private JTextField getTxtSinifAdi() {
		if (txtSinifAdi == null) {
			txtSinifAdi = new JTextField();
			txtSinifAdi.setBounds(109, 39, 113, 20);
			txtSinifAdi.setColumns(10);
		}
		return txtSinifAdi;
	}
	private JLabel getLblSinifKodu() {
		if (lblSinifKodu == null) {
			lblSinifKodu = new JLabel("S\u0131n\u0131f Kodu:");
			lblSinifKodu.setBounds(10, 109, 78, 14);
		}
		return lblSinifKodu;
	}
	private JTextField getTxtSinifKodu() {
		if (txtSinifKodu == null) {
			txtSinifKodu = new JTextField();
			txtSinifKodu.setColumns(10);
			txtSinifKodu.setBounds(109, 106, 113, 20);
		}
		return txtSinifKodu;
	}
	private JLabel getLblKapasite() {
		if (lblKapasite == null) {
			lblKapasite = new JLabel("Kapasite:");
			lblKapasite.setBounds(10, 175, 71, 14);
		}
		return lblKapasite;
	}
	private JTextField getTxtKapasite() {
		if (txtKapasite == null) {
			txtKapasite = new JTextField();
			txtKapasite.setColumns(10);
			txtKapasite.setBounds(109, 172, 113, 20);
		}
		return txtKapasite;
	}
	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					DbServicessBase<LessonClass> dao=new DbServicessBase<LessonClass>();
					LessonClass temp=new LessonClass();
					
					
					temp.setAdi(txtSinifAdi.getText());
					temp.setKod(txtSinifKodu.getText());
					temp.setKapasite((Integer.valueOf(getTxtKapasite().getText())));

					if (dao.save(temp)) {
						lblMesaj.setText("Sýnýf Baþarý ile Oluþturuldu");
					}
					else {
						lblMesaj.setText("Sýnýf  Oluþturulamadý");

					}
					
					
					
				}
			});
			btnKaydet.setBounds(334, 38, 105, 48);
		}
		return btnKaydet;
	}
	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SinifAcmaEkrani.this.dispose();
				}
			});
			btnIptal.setBounds(334, 109, 105, 48);
		}
		return btnIptal;
	}
	private JLabel getLblMesaj() {
		if (lblMesaj == null) {
			lblMesaj = new JLabel("");
			lblMesaj.setBounds(0, 270, 524, 26);
		}
		return lblMesaj;
	}
}
