package com.hokumus.course.project.models.managementscreen;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SinifGoruntuleGuncelleSil extends JFrame {
	private JLabel lblAd;
	private JTextField txtSinifAdi;
	private JLabel lblSinifKodu;
	private JTextField txtSinifKodu;
	private JLabel lblKapasite;
	private JTextField txtKapasite;
	private JButton btnGuncelle;
	private JButton btnIptal;
	private JPanel panel;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JPanel panelArama;
	private JTextField textField_1;
	private JTable table;
	private JButton btnSil;
	private JButton btnTemizle;
	public SinifGoruntuleGuncelleSil() {
		initialize();
	}

	private void initialize() {
		setTitle("S\u0131n\u0131f G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil");
		setBounds(400, 150, 723, 528);
		getContentPane().setLayout(null);
		getContentPane().add(getLblAd());
		getContentPane().add(getTxtSinifAdi());
		getContentPane().add(getLblSinifKodu());
		getContentPane().add(getTxtSinifKodu());
		getContentPane().add(getLblKapasite());
		getContentPane().add(getTxtKapasite());
		getContentPane().add(getBtnGuncelle());
		getContentPane().add(getBtnIptal());
		getContentPane().add(getPanel());
		getContentPane().add(getScrollPane());
		getContentPane().add(getPanelArama());
		getContentPane().add(getBtnSil());
		getContentPane().add(getBtnTemizle());
	}
	private JLabel getLblAd() {
		if (lblAd == null) {
			lblAd = new JLabel("S\u0131n\u0131f Ad\u0131:");
			lblAd.setBounds(19, 24, 105, 26);
		}
		return lblAd;
	}
	private JTextField getTxtSinifAdi() {
		if (txtSinifAdi == null) {
			txtSinifAdi = new JTextField();
			txtSinifAdi.setBounds(134, 27, 113, 20);
			txtSinifAdi.setColumns(10);
		}
		return txtSinifAdi;
	}
	private JLabel getLblSinifKodu() {
		if (lblSinifKodu == null) {
			lblSinifKodu = new JLabel("S\u0131n\u0131f Kodu:");
			lblSinifKodu.setBounds(19, 68, 78, 14);
		}
		return lblSinifKodu;
	}
	private JTextField getTxtSinifKodu() {
		if (txtSinifKodu == null) {
			txtSinifKodu = new JTextField();
			txtSinifKodu.setColumns(10);
			txtSinifKodu.setBounds(134, 65, 113, 20);
		}
		return txtSinifKodu;
	}
	private JLabel getLblKapasite() {
		if (lblKapasite == null) {
			lblKapasite = new JLabel("Kapasite:");
			lblKapasite.setBounds(19, 108, 71, 14);
		}
		return lblKapasite;
	}
	private JTextField getTxtKapasite() {
		if (txtKapasite == null) {
			txtKapasite = new JTextField();
			txtKapasite.setColumns(10);
			txtKapasite.setBounds(134, 105, 113, 20);
		}
		return txtKapasite;
	}
	private JButton getBtnGuncelle() {
		if (btnGuncelle == null) {
			btnGuncelle = new JButton("G\u00FCncelle");
			btnGuncelle.setBounds(345, 26, 89, 23);
		}
		return btnGuncelle;
	}
	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.setBounds(468, 64, 89, 23);
		}
		return btnIptal;
	}
	
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mesaj", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(304, 98, 293, 49);
			panel.setLayout(null);
			panel.add(getTextField());
		}
		return panel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setForeground(Color.RED);
			textField.setBounds(10, 18, 273, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 204, 687, 274);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JPanel getPanelArama() {
		if (panelArama == null) {
			panelArama = new JPanel();
			panelArama.setBorder(new TitledBorder(null, "Arama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelArama.setBounds(10, 150, 674, 56);
			panelArama.setLayout(null);
			panelArama.add(getTextField_1());
		}
		return panelArama;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(10, 15, 654, 30);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "SINIF ADI", "SINIF KODU", "KAPAS\u0130TE", "PAZARTES\u0130", "SALI", "\u00C7AR\u015EAMBA", "PER\u015EEMBE", "CUMA", "C.ERTES\u0130", "PAZAR"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(38);
			table.getColumnModel().getColumn(1).setPreferredWidth(65);
			table.getColumnModel().getColumn(3).setPreferredWidth(62);
			table.getColumnModel().getColumn(4).setPreferredWidth(65);
			table.getColumnModel().getColumn(5).setPreferredWidth(47);
			table.getColumnModel().getColumn(6).setPreferredWidth(66);
			table.getColumnModel().getColumn(8).setPreferredWidth(48);
			table.getColumnModel().getColumn(9).setPreferredWidth(63);
			table.getColumnModel().getColumn(10).setPreferredWidth(44);
		}
		return table;
	}
	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("Sil");
			btnSil.setBounds(468, 26, 89, 23);
		}
		return btnSil;
	}
	private JButton getBtnTemizle() {
		if (btnTemizle == null) {
			btnTemizle = new JButton("Temizle");
			btnTemizle.setBounds(345, 64, 89, 23);
		}
		return btnTemizle;
	}
}
