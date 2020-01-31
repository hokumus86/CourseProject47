package com.hokumus.course.project.ui.managementscreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.project.models.management.Courses;
import com.hokumus.course.project.models.management.Days;
import com.hokumus.course.project.models.management.LessonClass;
import com.hokumus.course.project.models.teacher.Teacher;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.toedter.calendar.JDateChooser;

public class OgrenciIslemleri extends JFrame{
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
	private JButton btnGuncelle;
	private JButton btnIptal;
	private JButton btnSil;
	private JLabel lblSaat;
	private JComboBox cmbSaat;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtArama;
	private JPanel panel_2;
	private JButton btnTemizle;
	private JLabel txtMesaj;
	private JDateChooser dateBaslamaTrh;
	private JDateChooser dateBitisTrh;
	private JButton btnYeniGrupA;
	public OgrenciIslemleri() {
		initialize();
	}

	private void initialize() {
		setTitle("Grup G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil  -"+CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
		setBounds(300, 3, 940, 673);
		getContentPane().setLayout(null);
		getContentPane().setName("Öðrenci Ýþlemleri");
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
		getContentPane().add(getBtnGuncelle());
		getContentPane().add(getBtnIptal());
		getContentPane().add(getBtnSil());
		getContentPane().add(getLblSaat());
		getContentPane().add(getCmbSaat());
		getContentPane().add(getScrollPane());
		getContentPane().add(getPanel_2());
		getContentPane().add(getBtnTemizle());
		getContentPane().add(getTxtMesaj());
		getContentPane().add(getDateBaslamaTrh());
		getContentPane().add(getBtnYeniGrupA());
		
	}
	
	private JLabel getLblKursAd() {
		if (lblKursAd == null) {
			lblKursAd = new JLabel("\u00D6\u011Frenci Ad\u0131: ");
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
	private JButton getBtnGuncelle() {
		if (btnGuncelle == null) {
			btnGuncelle = new JButton("G\u00FCncelle");
			btnGuncelle.setBounds(594, 25, 108, 38);
		}
		return btnGuncelle;
	}
	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GrupIslemleri grup=new GrupIslemleri();
					ManagementScreen manager=new ManagementScreen();
					manager.getPanelAna().remove(grup);
				}
			});
			btnIptal.setBounds(734, 95, 108, 38);
		}
		return btnIptal;
	}
	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("Sil");
			btnSil.setBounds(594, 95, 108, 38);
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
			scrollPane.setBounds(10, 301, 832, 284);
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
			txtArama.setBounds(10, 24, 801, 20);
			txtArama.setColumns(10);
		}
		return txtArama;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Arama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(17, 252, 825, 55);
			panel_2.setLayout(null);
			panel_2.add(getTxtArama());
		}
		return panel_2;
	}
	private JButton getBtnTemizle() {
		if (btnTemizle == null) {
			btnTemizle = new JButton("Temizle");
			btnTemizle.setBounds(734, 25, 103, 38);
		}
		return btnTemizle;
	}
	private JLabel getTxtMesaj() {
		if (txtMesaj == null) {
			txtMesaj = new JLabel("");
			txtMesaj.setBounds(10, 609, 521, 21);
		}
		return txtMesaj;
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
						JOptionPane.showMessageDialog(OgrenciIslemleri.this, gun);

					}

				}
			});
			dateBaslamaTrh.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}

				public void inputMethodTextChanged(InputMethodEvent event) {
					dateBaslamaTrh.setDateFormatString("dd/MM/yyyy");
					JOptionPane.showMessageDialog(OgrenciIslemleri.this, dateBaslamaTrh.getDateFormatString());
				}
			});
			dateBaslamaTrh.setBounds(281, 67, 95, 20);
		}
		return dateBaslamaTrh;
	}
	
	private JButton getBtnYeniGrupA() {
		if (btnYeniGrupA == null) {
			btnYeniGrupA = new JButton("Yeni Grup A\u00E7");
			btnYeniGrupA.setBounds(661, 154, 133, 48);
		}
		return btnYeniGrupA;
	}

}
