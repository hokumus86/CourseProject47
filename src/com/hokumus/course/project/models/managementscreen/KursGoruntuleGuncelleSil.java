package com.hokumus.course.project.models.managementscreen;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class KursGoruntuleGuncelleSil extends JFrame {
	private JScrollPane scrollPane;
	private JButton btnGuncelle;
	private JTable table;
	private JLabel lblKursAd;
	private JTextField txtKursAdi;
	private JLabel lblBalamaTarihi;
	private JTextField txtBaslamaTarihi;
	private JTextField txtFiyat;
	private JLabel lblFiyat;
	private JLabel lblDurum;
	private JComboBox comboBox;
	private JTextField txtArama;
	private JTextField txtMesaj;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnSil;
	private JButton btnTemizle;
	private JButton btnIptal;
	public KursGoruntuleGuncelleSil() {
		initialize();
	}

	private void initialize() {
		setTitle("Kurs G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil");
		setBounds(400, 130, 730, 603);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnGuncelle());
		getContentPane().add(getLblKursAd());
		getContentPane().add(getTxtKursAdi());
		getContentPane().add(getLblBalamaTarihi());
		getContentPane().add(getTxtBaslamaTarihi());
		getContentPane().add(getTxtFiyat());
		getContentPane().add(getLblFiyat());
		getContentPane().add(getLblDurum());
		getContentPane().add(getComboBox());
		getContentPane().add(getPanel());
		getContentPane().add(getPanel_1());
		getContentPane().add(getBtnSil());
		getContentPane().add(getBtnTemizle());
		getContentPane().add(getBtnIptal());
	}

	
	
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 197, 682, 337);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JButton getBtnGuncelle() {
		if (btnGuncelle == null) {
			btnGuncelle = new JButton(" G\u00FCncelle");
			btnGuncelle.setBounds(443, 20, 103, 29);
		}
		return btnGuncelle;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "ADI", "BA\u015ELAMA TAR\u0130H\u0130", "F\u0130YAT", "DURUM"
				}
			));
		}
		return table;
	}
	private JLabel getLblKursAd() {
		if (lblKursAd == null) {
			lblKursAd = new JLabel("Kurs Ad\u0131:");
			lblKursAd.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblKursAd.setBounds(10, 24, 83, 14);
		}
		return lblKursAd;
	}
	private JTextField getTxtKursAdi() {
		if (txtKursAdi == null) {
			txtKursAdi = new JTextField();
			txtKursAdi.setBounds(103, 21, 86, 20);
			txtKursAdi.setColumns(10);
		}
		return txtKursAdi;
	}
	private JLabel getLblBalamaTarihi() {
		if (lblBalamaTarihi == null) {
			lblBalamaTarihi = new JLabel("Ba\u015Flama Tarihi:");
			lblBalamaTarihi.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblBalamaTarihi.setBounds(10, 55, 95, 14);
		}
		return lblBalamaTarihi;
	}
	private JTextField getTxtBaslamaTarihi() {
		if (txtBaslamaTarihi == null) {
			txtBaslamaTarihi = new JTextField();
			txtBaslamaTarihi.setColumns(10);
			txtBaslamaTarihi.setBounds(103, 55, 86, 20);
		}
		return txtBaslamaTarihi;
	}
	private JTextField getTxtFiyat() {
		if (txtFiyat == null) {
			txtFiyat = new JTextField();
			txtFiyat.setColumns(10);
			txtFiyat.setBounds(327, 24, 86, 20);
		}
		return txtFiyat;
	}
	private JLabel getLblFiyat() {
		if (lblFiyat == null) {
			lblFiyat = new JLabel("Fiyat:");
			lblFiyat.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblFiyat.setBounds(254, 24, 46, 14);
		}
		return lblFiyat;
	}
	private JLabel getLblDurum() {
		if (lblDurum == null) {
			lblDurum = new JLabel("Durum:");
			lblDurum.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblDurum.setBounds(254, 55, 80, 14);
		}
		return lblDurum;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setToolTipText("\r\n");
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"AKT\u0130F", "PAS\u0130F"}));
			comboBox.setBounds(327, 52, 86, 20);
		}
		return comboBox;
	}
	private JTextField getTxtArama() {
		if (txtArama == null) {
			txtArama = new JTextField();
			txtArama.setBounds(10, 19, 714, 26);
			txtArama.setToolTipText("Arama");
			txtArama.setColumns(10);
		}
		return txtArama;
	}
	private JTextField getTxtMesaj() {
		if (txtMesaj == null) {
			txtMesaj = new JTextField();
			txtMesaj.setBounds(10, 14, 300, 26);
			txtMesaj.setColumns(10);
		}
		return txtMesaj;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Arama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(20, 141, 694, 56);
			panel.setLayout(null);
			panel.add(getTxtArama());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Mesaj", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(20, 93, 320, 51);
			panel_1.setLayout(null);
			panel_1.add(getTxtMesaj());
		}
		return panel_1;
	}
	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("Sil");
			btnSil.setBounds(443, 72, 103, 29);
		}
		return btnSil;
	}
	private JButton getBtnTemizle() {
		if (btnTemizle == null) {
			btnTemizle = new JButton("Temizle");
			btnTemizle.setBounds(579, 20, 103, 29);
		}
		return btnTemizle;
	}
	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.setBounds(579, 72, 103, 29);
		}
		return btnIptal;
	}
}
