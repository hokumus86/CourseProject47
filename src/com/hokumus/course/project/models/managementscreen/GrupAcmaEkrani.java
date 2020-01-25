package com.hokumus.course.project.models.managementscreen;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;

public class GrupAcmaEkrani extends JFrame {
	private JLabel lblKursAd;
	private JComboBox cmbKursAdi;
	private JLabel lblGrupAd;
	private JTextField txtGrupAdi;
	private JLabel lblretmen;
	private JComboBox cmbOgretmen;
	private JLabel lblrenciSays;
	private JTextField txtOgrenciSayisi;
	private JLabel lblSnf;
	private JComboBox cmbSinif;
	private JLabel lblBalamaTarihi;
	private JLabel lblBitiTarihi;
	private JPanel panel;
	private JCheckBox chckbxPazartesi;
	private JCheckBox chckbxSali;
	private JCheckBox chckbxCarsamba;
	private JCheckBox chckbxPersembe;
	private JCheckBox chckbxCuma;
	private JCheckBox chckbxCumartesi;
	private JButton btnKaydet;
	private JButton btnIptal;
	private JTextField txtMesaj;
	private JPanel panel_1;
	private JButton btnTemizle;
	private JDateChooser dateBaslamaTrh;
	private JDateChooser dateBitisTrh;

	public GrupAcmaEkrani() {
		initialize();
	}

	private void initialize() {
		setTitle("Grup A\u00E7ma");
		setBounds(400, 150, 715, 510);
		getContentPane().setLayout(null);
		getContentPane().add(getLblKursAd());
		getContentPane().add(getCmbKursAdi());
		getContentPane().add(getLblGrupAd());
		getContentPane().add(getTxtGrupAdi());
		getContentPane().add(getLblretmen());
		getContentPane().add(getCmbOgretmen());
		getContentPane().add(getLblrenciSays());
		getContentPane().add(getTxtOgrenciSayisi());
		getContentPane().add(getLblSnf());
		getContentPane().add(getCmbSinif());
		getContentPane().add(getLblBalamaTarihi());
		getContentPane().add(getLblBitiTarihi());
		getContentPane().add(getPanel());
		getContentPane().add(getBtnKaydet());
		getContentPane().add(getBtnIptal());
		getContentPane().add(getPanel_1());
		getContentPane().add(getBtnTemizle());
		getContentPane().add(getDateBaslamaTrh());
		getContentPane().add(getDateBitisTrh());
	}

	private JLabel getLblKursAd() {
		if (lblKursAd == null) {
			lblKursAd = new JLabel("Kurs Ad\u0131:");
			lblKursAd.setBounds(46, 65, 76, 14);
		}
		return lblKursAd;
	}

	private JComboBox getCmbKursAdi() {
		if (cmbKursAdi == null) {
			cmbKursAdi = new JComboBox();
			cmbKursAdi.setToolTipText("");
			cmbKursAdi.setBounds(157, 62, 103, 20);
		}
		return cmbKursAdi;
	}

	private JLabel getLblGrupAd() {
		if (lblGrupAd == null) {
			lblGrupAd = new JLabel("Grup Ad\u0131:");
			lblGrupAd.setBounds(46, 120, 76, 14);
		}
		return lblGrupAd;
	}

	private JTextField getTxtGrupAdi() {
		if (txtGrupAdi == null) {
			txtGrupAdi = new JTextField();
			txtGrupAdi.setBounds(157, 117, 103, 20);
			txtGrupAdi.setColumns(10);
		}
		return txtGrupAdi;
	}

	private JLabel getLblretmen() {
		if (lblretmen == null) {
			lblretmen = new JLabel("\u00D6\u011Fretmen:");
			lblretmen.setBounds(46, 177, 76, 14);
		}
		return lblretmen;
	}

	private JComboBox getCmbOgretmen() {
		if (cmbOgretmen == null) {
			cmbOgretmen = new JComboBox();
			cmbOgretmen.setBounds(157, 171, 103, 20);
		}
		return cmbOgretmen;
	}

	private JLabel getLblrenciSays() {
		if (lblrenciSays == null) {
			lblrenciSays = new JLabel("\u00D6\u011Frenci Say\u0131s\u0131:");
			lblrenciSays.setBounds(46, 238, 101, 14);
		}
		return lblrenciSays;
	}

	private JTextField getTxtOgrenciSayisi() {
		if (txtOgrenciSayisi == null) {
			txtOgrenciSayisi = new JTextField();
			txtOgrenciSayisi.setColumns(10);
			txtOgrenciSayisi.setBounds(157, 235, 103, 20);
		}
		return txtOgrenciSayisi;
	}

	private JLabel getLblSnf() {
		if (lblSnf == null) {
			lblSnf = new JLabel("S\u0131n\u0131f:");
			lblSnf.setBounds(46, 305, 76, 14);
		}
		return lblSnf;
	}

	private JComboBox getCmbSinif() {
		if (cmbSinif == null) {
			cmbSinif = new JComboBox();
			cmbSinif.setBounds(157, 302, 103, 20);
		}
		return cmbSinif;
	}

	private JLabel getLblBalamaTarihi() {
		if (lblBalamaTarihi == null) {
			lblBalamaTarihi = new JLabel("Ba\u015Flama Tarihi:");
			lblBalamaTarihi.setBounds(41, 385, 103, 14);
		}
		return lblBalamaTarihi;
	}

	private JLabel getLblBitiTarihi() {
		if (lblBitiTarihi == null) {
			lblBitiTarihi = new JLabel("Biti\u015F Tarihi:");
			lblBitiTarihi.setBounds(199, 385, 103, 14);
		}
		return lblBitiTarihi;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(
					new TitledBorder(null, "G\u00FCn Se\u00E7imi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(322, 58, 133, 199);
			panel.setLayout(null);
			panel.add(getChckbxPazartesi());
			panel.add(getChckbxSali());
			panel.add(getChckbxCarsamba());
			panel.add(getChckbxPersembe());
			panel.add(getChckbxCuma());
			panel.add(getChckbxCumartesi());
		}
		return panel;
	}

	private JCheckBox getChckbxPazartesi() {
		if (chckbxPazartesi == null) {
			chckbxPazartesi = new JCheckBox("Pazartesi");
			chckbxPazartesi.setBounds(18, 26, 118, 23);
		}
		return chckbxPazartesi;
	}

	private JCheckBox getChckbxSali() {
		if (chckbxSali == null) {
			chckbxSali = new JCheckBox("Sal\u0131");
			chckbxSali.setBounds(18, 52, 97, 23);
		}
		return chckbxSali;
	}

	private JCheckBox getChckbxCarsamba() {
		if (chckbxCarsamba == null) {
			chckbxCarsamba = new JCheckBox("\u00C7ar\u015Famba");
			chckbxCarsamba.setBounds(18, 78, 97, 23);
		}
		return chckbxCarsamba;
	}

	private JCheckBox getChckbxPersembe() {
		if (chckbxPersembe == null) {
			chckbxPersembe = new JCheckBox("Per\u015Fembe");
			chckbxPersembe.setBounds(18, 104, 97, 23);
		}
		return chckbxPersembe;
	}

	private JCheckBox getChckbxCuma() {
		if (chckbxCuma == null) {
			chckbxCuma = new JCheckBox("Cuma");
			chckbxCuma.setBounds(18, 130, 97, 23);
		}
		return chckbxCuma;
	}

	private JCheckBox getChckbxCumartesi() {
		if (chckbxCumartesi == null) {
			chckbxCumartesi = new JCheckBox("Cumartesi");
			chckbxCumartesi.setBounds(18, 156, 97, 23);
		}
		return chckbxCumartesi;
	}

	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.setBounds(537, 61, 108, 38);
		}
		return btnKaydet;
	}

	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.setBounds(537, 130, 108, 38);
		}
		return btnIptal;
	}

	private JTextField getTxtMesaj() {
		if (txtMesaj == null) {
			txtMesaj = new JTextField();
			txtMesaj.setBounds(10, 23, 283, 23);
			txtMesaj.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtMesaj.setForeground(Color.RED);
			txtMesaj.setColumns(10);
		}
		return txtMesaj;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Mesaj", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(367, 305, 303, 57);
			panel_1.setLayout(null);
			panel_1.add(getTxtMesaj());
		}
		return panel_1;
	}

	private JButton getBtnTemizle() {
		if (btnTemizle == null) {
			btnTemizle = new JButton("Temizle");
			btnTemizle.setBounds(537, 200, 108, 38);
		}
		return btnTemizle;
	}

	private JDateChooser getDateBaslamaTrh() {
		if (dateBaslamaTrh == null) {
			dateBaslamaTrh = new JDateChooser();
			dateBaslamaTrh.setDateFormatString("dd/MM/yyyy");
			dateBaslamaTrh.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					if (dateBaslamaTrh.getDate() != null) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

						String gun = sdf.format(dateBaslamaTrh.getDate());
						JOptionPane.showMessageDialog(GrupAcmaEkrani.this, gun);

					}

				}
			});
			dateBaslamaTrh.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}

				public void inputMethodTextChanged(InputMethodEvent event) {
					dateBaslamaTrh.setDateFormatString("dd/MM/yyyy");
					JOptionPane.showMessageDialog(GrupAcmaEkrani.this, dateBaslamaTrh.getDateFormatString());
				}
			});
			dateBaslamaTrh.setBounds(41, 403, 105, 22);
		}
		return dateBaslamaTrh;
	}

	private JDateChooser getDateBitisTrh() {
		if (dateBitisTrh == null) {
			dateBitisTrh = new JDateChooser();
			dateBitisTrh.setBounds(197, 403, 105, 22);
		}
		return dateBitisTrh;
	}
}
