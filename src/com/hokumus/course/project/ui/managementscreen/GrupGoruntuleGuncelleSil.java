package com.hokumus.course.project.ui.managementscreen;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.project.utils.CourseUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GrupGoruntuleGuncelleSil extends JFrame{
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
	private JTextField txtBaslamaTarihi;
	private JLabel lblBitiTarihi;
	private JTextField txtBitisTarihi;
	private JPanel panel;
	private JCheckBox chckbxPazartesi;
	private JCheckBox chckbxSali;
	private JCheckBox chckbxCarsamba;
	private JCheckBox chckbxPersembe;
	private JCheckBox chckbxCuma;
	private JCheckBox chckbxCumartesi;
	private JButton btnGuncelle;
	private JButton btnIptal;
	private JTextField txtMesaj;
	private JPanel panel_1;
	private JButton btnSil;
	private JLabel lblSaat;
	private JComboBox cmbSaat;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtArama;
	private JPanel panel_2;
	private JButton btnTemizle;
	private JCheckBox chckbxPazar;
	public GrupGoruntuleGuncelleSil() {
		initialize();
	}

	private void initialize() {
		setTitle("Grup G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil  -"+CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
		setBounds(300, 3, 940, 731);
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
		getContentPane().add(getTxtBaslamaTarihi());
		getContentPane().add(getLblBitiTarihi());
		getContentPane().add(getTxtBitisTarihi());
		getContentPane().add(getPanel());
		getContentPane().add(getBtnGuncelle());
		getContentPane().add(getBtnIptal());
		getContentPane().add(getPanel_1());
		getContentPane().add(getBtnSil());
		getContentPane().add(getLblSaat());
		getContentPane().add(getCmbSaat());
		getContentPane().add(getScrollPane());
		getContentPane().add(getPanel_2());
		getContentPane().add(getBtnTemizle());
	}
	private JLabel getLblKursAd() {
		if (lblKursAd == null) {
			lblKursAd = new JLabel("Kurs Ad\u0131:");
			lblKursAd.setBounds(21, 37, 76, 14);
		}
		return lblKursAd;
	}
	private JComboBox getCmbKursAdi() {
		if (cmbKursAdi == null) {
			cmbKursAdi = new JComboBox();
			cmbKursAdi.setToolTipText("");
			cmbKursAdi.setBounds(129, 34, 103, 20);
		}
		return cmbKursAdi;
	}
	private JLabel getLblGrupAd() {
		if (lblGrupAd == null) {
			lblGrupAd = new JLabel("Grup Ad\u0131:");
			lblGrupAd.setBounds(21, 73, 76, 14);
		}
		return lblGrupAd;
	}
	private JTextField getTxtGrupAdi() {
		if (txtGrupAdi == null) {
			txtGrupAdi = new JTextField();
			txtGrupAdi.setBounds(129, 70, 103, 20);
			txtGrupAdi.setColumns(10);
		}
		return txtGrupAdi;
	}
	private JLabel getLblretmen() {
		if (lblretmen == null) {
			lblretmen = new JLabel("\u00D6\u011Fretmen:");
			lblretmen.setBounds(21, 107, 76, 14);
		}
		return lblretmen;
	}
	private JComboBox getCmbOgretmen() {
		if (cmbOgretmen == null) {
			cmbOgretmen = new JComboBox();
			cmbOgretmen.setBounds(129, 101, 103, 20);
		}
		return cmbOgretmen;
	}
	private JLabel getLblrenciSays() {
		if (lblrenciSays == null) {
			lblrenciSays = new JLabel("\u00D6\u011Frenci Say\u0131s\u0131:");
			lblrenciSays.setBounds(21, 140, 101, 14);
		}
		return lblrenciSays;
	}
	private JTextField getTxtOgrenciSayisi() {
		if (txtOgrenciSayisi == null) {
			txtOgrenciSayisi = new JTextField();
			txtOgrenciSayisi.setColumns(10);
			txtOgrenciSayisi.setBounds(129, 137, 103, 20);
		}
		return txtOgrenciSayisi;
	}
	private JLabel getLblSnf() {
		if (lblSnf == null) {
			lblSnf = new JLabel("S\u0131n\u0131f:");
			lblSnf.setBounds(21, 171, 76, 14);
		}
		return lblSnf;
	}
	private JComboBox getCmbSinif() {
		if (cmbSinif == null) {
			cmbSinif = new JComboBox();
			cmbSinif.setBounds(129, 168, 103, 20);
		}
		return cmbSinif;
	}
	private JLabel getLblBalamaTarihi() {
		if (lblBalamaTarihi == null) {
			lblBalamaTarihi = new JLabel("Ba\u015Flama Tarihi:");
			lblBalamaTarihi.setBounds(289, 37, 103, 14);
		}
		return lblBalamaTarihi;
	}
	private JTextField getTxtBaslamaTarihi() {
		if (txtBaslamaTarihi == null) {
			txtBaslamaTarihi = new JTextField();
			txtBaslamaTarihi.setColumns(10);
			txtBaslamaTarihi.setBounds(286, 62, 116, 20);
		}
		return txtBaslamaTarihi;
	}
	private JLabel getLblBitiTarihi() {
		if (lblBitiTarihi == null) {
			lblBitiTarihi = new JLabel("Biti\u015F Tarihi:");
			lblBitiTarihi.setBounds(289, 118, 103, 14);
		}
		return lblBitiTarihi;
	}
	private JTextField getTxtBitisTarihi() {
		if (txtBitisTarihi == null) {
			txtBitisTarihi = new JTextField();
			txtBitisTarihi.setColumns(10);
			txtBitisTarihi.setBounds(289, 137, 116, 20);
		}
		return txtBitisTarihi;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "G\u00FCn Se\u00E7imi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(426, 27, 168, 217);
			panel.setLayout(null);
			panel.add(getChckbxPazartesi());
			panel.add(getChckbxSali());
			panel.add(getChckbxCarsamba());
			panel.add(getChckbxPersembe());
			panel.add(getChckbxCuma());
			panel.add(getChckbxCumartesi());
			panel.add(getChckbxPazar());
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
	private JButton getBtnGuncelle() {
		if (btnGuncelle == null) {
			btnGuncelle = new JButton("G\u00FCncelle");
			btnGuncelle.setBounds(657, 25, 108, 38);
		}
		return btnGuncelle;
	}
	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GrupGoruntuleGuncelleSil.this.dispose();
				}
			});
			btnIptal.setBounds(785, 92, 108, 38);
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
			panel_1.setBounds(611, 171, 303, 57);
			panel_1.setLayout(null);
			panel_1.add(getTxtMesaj());
		}
		return panel_1;
	}
	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("Sil");
			btnSil.setBounds(657, 92, 108, 38);
		}
		return btnSil;
	}
	private JLabel getLblSaat() {
		if (lblSaat == null) {
			lblSaat = new JLabel("Saat:");
			lblSaat.setBounds(21, 212, 46, 14);
		}
		return lblSaat;
	}
	private JComboBox getCmbSaat() {
		if (cmbSaat == null) {
			cmbSaat = new JComboBox();
			cmbSaat.setBounds(129, 209, 103, 20);
		}
		return cmbSaat;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 356, 904, 325);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "KURS ADI", "GRUP ADI", "\u00D6\u011ERETMEN", "\u00D6\u011ERENC\u0130 SAYISI", "SINIF", "G\u00DCN", "SAAT", "BA\u015ELANGI\u00C7 TAR\u0130H\u0130", "B\u0130T\u0130\u015E TAR\u0130H\u0130"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					true, true, true, true, true, true, true, true, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setPreferredWidth(84);
			table.getColumnModel().getColumn(3).setPreferredWidth(78);
			table.getColumnModel().getColumn(4).setPreferredWidth(103);
			table.getColumnModel().getColumn(5).setPreferredWidth(98);
			table.getColumnModel().getColumn(6).setPreferredWidth(73);
			table.getColumnModel().getColumn(7).setPreferredWidth(85);
			table.getColumnModel().getColumn(8).setPreferredWidth(105);
			table.getColumnModel().getColumn(9).setPreferredWidth(80);
		}
		return table;
	}
	private JTextField getTxtArama() {
		if (txtArama == null) {
			txtArama = new JTextField();
			txtArama.setBounds(10, 19, 841, 33);
			txtArama.setColumns(10);
		}
		return txtArama;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Arama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 287, 872, 63);
			panel_2.setLayout(null);
			panel_2.add(getTxtArama());
		}
		return panel_2;
	}
	private JButton getBtnTemizle() {
		if (btnTemizle == null) {
			btnTemizle = new JButton("Temizle");
			btnTemizle.setBounds(785, 25, 103, 38);
		}
		return btnTemizle;
	}
	private JCheckBox getChckbxPazar() {
		if (chckbxPazar == null) {
			chckbxPazar = new JCheckBox("Pazar");
			chckbxPazar.setBounds(18, 187, 97, 23);
		}
		return chckbxPazar;
	}
}
