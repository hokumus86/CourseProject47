package com.hokumus.course.project.ui.managementscreen;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView.TableRow;

import com.hokumus.course.project.models.management.Courses;
import com.hokumus.course.project.models.management.LessonClass;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KursIslemleri extends JFrame {
	private JScrollPane scrollPane;
	private JButton btnGuncelle;
	private JTable tblKurslar;
	private JLabel lblKursAd;
	private JTextField txtKursAdi;
	private JTextField txtFiyat;
	private JLabel lblFiyat;
	private JLabel lblDurum;
	private JComboBox cmbDurum;
	private JTextField txtArama;
	private JPanel panel;
	private JButton btnSil;
	private JButton btnTemizle;
	private JButton btnIptal;
	
	private Long selectedeItemId;
	public KursIslemleri() {
		initialize();
	}

	private void initialize() {
		setTitle("Kurs G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil -"+CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
		setBounds(400, 130, 871, 603);
		getContentPane().setLayout(null);
		getContentPane().setName("Kurs Ýþlemleri");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnGuncelle());
		getContentPane().add(getLblKursAd());
		getContentPane().add(getTxtKursAdi());
		getContentPane().add(getTxtFiyat());
		getContentPane().add(getLblFiyat());
		getContentPane().add(getLblDurum());
		getContentPane().add(getCmbDurum());
		getContentPane().add(getPanel());
		getContentPane().add(getBtnSil());
		getContentPane().add(getBtnTemizle());
		getContentPane().add(getBtnIptal());
		getContentPane().add(getLblMesaj());
		getContentPane().add(getBtnYeniKursAc());
		kursTablosuGoster();
	}
	DefaultTableModel model=new DefaultTableModel();
	private JLabel lblMesaj;
	private JButton btnYeniKursAc;

	public void kursTablosuGoster() {
		
		
		DbServicessBase<Courses> dao=new DbServicessBase<Courses>(); 
		Courses temp=new Courses();
		List<Courses> kurs_listesi=dao.getAllRows(temp);
		
		
		String [] columnNames= {"ID","AD","FÝYAT","DURUM"};
		String [][] data=new String [kurs_listesi.size()][columnNames.length];
		
		
		for (int i = 0; i < kurs_listesi.size(); i++) {
			
			data[i][0]=kurs_listesi.get(i).getId().toString();
			data[i][1]=kurs_listesi.get(i).getAdi();
			data[i][2]=kurs_listesi.get(i).getFiyat().toString();
			data[i][3]=kurs_listesi.get(i).getDurum();
			
			
		}
		
		model=new DefaultTableModel(data,columnNames);
		tblKurslar.setModel(model);
		
		
		
	}
	
	public void arama(String ara) {
		
		TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
		tblKurslar.setRowSorter(tr);
		
		tr.setRowFilter(RowFilter.regexFilter(ara));
		
		
		
		
		
	}
	
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 167, 817, 315);
			scrollPane.setViewportView(getTblKurslar());
		}
		return scrollPane;
	}
	private JButton getBtnGuncelle() {
		if (btnGuncelle == null) {
			btnGuncelle = new JButton(" G\u00FCncelle");
			btnGuncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					DbServicessBase<Courses> dao=new DbServicessBase<Courses>();
					Courses yenikurs=new Courses();
					
					yenikurs.setAdi(txtKursAdi.getText());
					yenikurs.setFiyat(new BigDecimal(txtFiyat.getText()));
					yenikurs.setDurum(cmbDurum.getSelectedItem().toString());
					yenikurs.setId(selectedeItemId);
					if (dao.update(yenikurs)) {
						lblMesaj.setText("Kurs Baþarý ile Güncellendi");
						kursTablosuGoster();
					}
					else {
						lblMesaj.setText("Kurs  Güncellenemedi");
					}
					
					
					
				}
			});
			btnGuncelle.setBounds(565, 17, 103, 29);
		}
		return btnGuncelle;
	}
	private JTable getTblKurslar() {
		if (tblKurslar == null) {
			tblKurslar = new JTable();
			tblKurslar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int row=tblKurslar.getSelectedRow();
					
					
					txtKursAdi.setText(tblKurslar.getValueAt(row, 1).toString());
					txtFiyat.setText(tblKurslar.getValueAt(row, 2).toString());
					cmbDurum.setSelectedItem(tblKurslar.getValueAt(row, 3));
					selectedeItemId = Long.valueOf(tblKurslar.getValueAt(row, 0).toString());
					
					
					
					
				}
			});
			tblKurslar.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					
				}
			));
		}
		return tblKurslar;
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
	private JTextField getTxtFiyat() {
		if (txtFiyat == null) {
			txtFiyat = new JTextField();
			txtFiyat.setColumns(10);
			txtFiyat.setBounds(283, 24, 86, 20);
		}
		return txtFiyat;
	}
	private JLabel getLblFiyat() {
		if (lblFiyat == null) {
			lblFiyat = new JLabel("Fiyat:");
			lblFiyat.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblFiyat.setBounds(227, 27, 46, 14);
		}
		return lblFiyat;
	}
	private JLabel getLblDurum() {
		if (lblDurum == null) {
			lblDurum = new JLabel("Durum:");
			lblDurum.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblDurum.setBounds(10, 55, 80, 14);
		}
		return lblDurum;
	}
	private JComboBox getCmbDurum() {
		if (cmbDurum == null) {
			cmbDurum = new JComboBox();
			cmbDurum.setToolTipText("\r\n");
			cmbDurum.setModel(new DefaultComboBoxModel(new String[] {"AKT\u0130F", "PAS\u0130F"}));
			cmbDurum.setBounds(103, 52, 86, 20);
		}
		return cmbDurum;
	}
	private JTextField getTxtArama() {
		if (txtArama == null) {
			txtArama = new JTextField();
			txtArama.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					
					String ara=txtArama.getText().toString();
					arama(ara);
				}
			});
			txtArama.setBounds(10, 19, 776, 26);
			txtArama.setToolTipText("Arama");
			txtArama.setColumns(10);
		}
		return txtArama;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Arama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 112, 817, 56);
			panel.setLayout(null);
			panel.add(getTxtArama());
		}
		return panel;
	}
	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("Sil");
			btnSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Courses> dao=new DbServicessBase<Courses>();
					 Courses silinicek_kurs=new Courses();
					int row=tblKurslar.getSelectedRow();
					silinicek_kurs.setId(Long.valueOf(tblKurslar.getValueAt(row, 0).toString()));
					silinicek_kurs.setAdi(tblKurslar.getValueAt(row, 1).toString());
					silinicek_kurs.setFiyat(new BigDecimal(tblKurslar.getValueAt(row, 2).toString()));
					silinicek_kurs.setDurum(tblKurslar.getValueAt(row, 3).toString());
					if (dao.delete(silinicek_kurs)) {
						lblMesaj.setText("Kurs Baþarý ile Silindi");
						kursTablosuGoster();
					}
					else {
						lblMesaj.setText("Kurs Baþarý ile Silinemedi");
					}
				}
			});
			btnSil.setBounds(575, 72, 103, 29);
		}
		return btnSil;
	}
	private JButton getBtnTemizle() {
		if (btnTemizle == null) {
			btnTemizle = new JButton("Temizle");
			btnTemizle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtKursAdi.setText("");
					txtFiyat.setText("");
					cmbDurum.addItem("");
				}
			});
			btnTemizle.setBounds(702, 20, 103, 29);
		}
		return btnTemizle;
	}
	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					KursIslemleri.this.dispose();
				}
			});
			btnIptal.setBounds(702, 72, 103, 29);
		}
		return btnIptal;
	}
	private JLabel getLblMesaj() {
		if (lblMesaj == null) {
			lblMesaj = new JLabel("");
			lblMesaj.setForeground(Color.RED);
			lblMesaj.setBounds(20, 493, 682, 27);
		}
		return lblMesaj;
	}
	private JButton getBtnYeniKursAc() {
		if (btnYeniKursAc == null) {
			btnYeniKursAc = new JButton("Yeni Kurs A\u00E7");
			btnYeniKursAc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DbServicessBase<Courses> dao=new DbServicessBase<Courses>();
					DateTimeFormatter format=DateTimeFormatter.ofPattern("d/M/yyyy");
					
					Courses temp=new Courses();
					temp.setAdi(txtKursAdi.getText());
					temp.setDurum(cmbDurum.getSelectedItem().toString());
					temp.setFiyat(new BigDecimal(txtFiyat.getText()));
					
					if (dao.save(temp)) {
						lblMesaj.setText("Kurs Baþarlý Ýle Oluþturuldu");
						kursTablosuGoster();
					}
					else {
						lblMesaj.setText("Kurs Baþarlý Ýle Oluþturulamadý");
					}

					
				}
			});
			btnYeniKursAc.setBounds(396, 41, 125, 43);
		}
		return btnYeniKursAc;
	}
}
