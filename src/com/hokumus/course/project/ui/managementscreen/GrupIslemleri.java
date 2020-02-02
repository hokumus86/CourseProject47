package com.hokumus.course.project.ui.managementscreen;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.project.models.management.Courses;
import com.hokumus.course.project.models.management.Days;
import com.hokumus.course.project.models.management.Groups;
import com.hokumus.course.project.models.management.KursSaatleri;
import com.hokumus.course.project.models.management.LessonClass;
import com.hokumus.course.project.models.teacher.Teacher;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;

import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GrupIslemleri extends JFrame{
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
	private JPanel panelGun;
	private JCheckBox chckbxPazartesi;
	private JCheckBox chckbxSali;
	private JCheckBox chckbxCarsamba;
	private JCheckBox chckbxPersembe;
	private JCheckBox chckbxCuma;
	private JCheckBox chckbxCumartesi;
	private JButton btnGuncelle;
	private JButton btnIptal;
	private JButton btnSil;
	private JLabel lblSaat;
	private JComboBox cmbSaat;
	private JScrollPane scrollPane;
	private JTextField txtArama;
	private JPanel panel_2;
	private JButton btnTemizle;
	private JCheckBox chckbxPazar;
	private JLabel txtMesaj;
	private JDateChooser dateBaslamaTrh;
	private JDateChooser dateBitisTrh;
	private JButton btnYeniGrupA;
	private JTable tblGruplar;
	private Long selectedItemId;
	public GrupIslemleri() {
		initialize();
	}

	private void initialize() {
		setTitle("Grup G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil  -"+CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
		setBounds(300, 3, 940, 673);
		getContentPane().setLayout(null);
		getContentPane().setName("Grup Ýþlemleri");
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
		getContentPane().add(getPanelGun());
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
		getContentPane().add(getDateBitisTrh());
		getContentPane().add(getBtnYeniGrupA());
		grupTablosuGoster();
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				DbServicessBase<Courses> dao=new DbServicessBase<Courses>();
				DbServicessBase<LessonClass> dao1=new DbServicessBase<LessonClass>();
				DbServicessBase<Teacher> dao2=new DbServicessBase<Teacher>();
				List<Teacher> ogretmenler=dao2.getAllRows(new Teacher());
				List<LessonClass> siniflar=dao1.getAllRows(new LessonClass());
				List<Courses> kurslar=dao.getAllRows(new Courses());
				DefaultComboBoxModel model = new DefaultComboBoxModel(kurslar.toArray());		
				cmbKursAdi.setModel(model);
				model = new DefaultComboBoxModel(siniflar.toArray());		
				cmbSinif.setModel(model);
				model = new DefaultComboBoxModel(ogretmenler.toArray());		
				cmbOgretmen.setModel(model);
				
				
			}
		});
		t.start();
	}
	DefaultTableModel model=new DefaultTableModel();

		public void grupTablosuGoster() {
		
		
		DbServicessBase<Groups> dao=new DbServicessBase<Groups>(); 
		Groups temp=new Groups();
		
		List<Groups> grup_listesi=dao.getAllRows(temp);
		
		
		String [] columnNames= {"ID","KURS ADI","GRUP ADI","ÖÐRETMEN","ÖÐ. SAY.","SINIF","GÜN","BAÞ.TAR.","BÝT. TAR."};
		Object [][] data=new Object [grup_listesi.size()][columnNames.length];
		
		
		for (int i = 0; i < grup_listesi.size(); i++) {
			
			data[i][0]=grup_listesi.get(i).getId().toString();
			data[i][1]=grup_listesi.get(i).getCourses().toString();
			data[i][2]=grup_listesi.get(i).getAdi().toString();
			data[i][3]=grup_listesi.get(i).getTeacher();
			data[i][4]=String.valueOf(grup_listesi.get(i).getOgrenciSayisi());
			data[i][5]=grup_listesi.get(i).getLessonClass().toString();
			//data[i][6]=grup_listesi.get(i).getDays().getName();
			data[i][7]=grup_listesi.get(i).getBaslamaTarihi().toString();
			data[i][8]=grup_listesi.get(i).getBitisTarihi().toString();
			
			
		}
		
		model=new DefaultTableModel(data,columnNames);
		tblGruplar.setModel(model);
		
		DefaultComboBoxModel modelHours = new  DefaultComboBoxModel(KursSaatleri.values());
		cmbSaat.setModel(modelHours);
		
		
		
	}
	public  Days gunSecimi() {
		Days gun=new Days();

		List<Days> gunler;
		if (chckbxPazartesi.isSelected()) {
			gun.setGun1(1);
			gun.setName("Pazartesi");
		}
		else {
			gun.setGun1(0);
		}
		if (chckbxSali.isSelected()) {
			gun.setGun2(1);
		}
		else {
			gun.setGun2(0);
		}
		if (chckbxCarsamba.isSelected()) {
			gun.setGun3(1);
		}
		else {
			gun.setGun3(0);
		}
		if (chckbxPersembe.isSelected()) {
			gun.setGun4(1);
		}
		else {
			gun.setGun4(0);
		}
		if (chckbxCuma.isSelected()) {
			gun.setGun5(1);
		}
		else {
			gun.setGun5(0);
		}
		if (chckbxCumartesi.isSelected()) {
			gun.setGun6(1);
		}
		else {
			gun.setGun6(0);
		}
		if (chckbxPazar.isSelected()) {
			gun.setGun7(1);
		}
		else {
			gun.setGun7(0);
		}
		return gun;
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
	private JLabel getLblBitiTarihi() {
		if (lblBitiTarihi == null) {
			lblBitiTarihi = new JLabel("Biti\u015F Tarihi:");
			lblBitiTarihi.setBounds(289, 118, 103, 14);
		}
		return lblBitiTarihi;
	}
	private JPanel getPanelGun() {
		if (panelGun == null) {
			panelGun = new JPanel();
			panelGun.setBorder(new TitledBorder(null, "G\u00FCn Se\u00E7imi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelGun.setBounds(402, 37, 168, 217);
			panelGun.setLayout(null);
			panelGun.add(getChckbxPazartesi());
			panelGun.add(getChckbxSali());
			panelGun.add(getChckbxCarsamba());
			panelGun.add(getChckbxPersembe());
			panelGun.add(getChckbxCuma());
			panelGun.add(getChckbxCumartesi());
			panelGun.add(getChckbxPazar());
		}
		return panelGun;
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
			scrollPane.setViewportView(getTblGruplar());
		}
		return scrollPane;
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
	private JCheckBox getChckbxPazar() {
		if (chckbxPazar == null) {
			chckbxPazar = new JCheckBox("Pazar");
			chckbxPazar.setBounds(18, 187, 97, 23);
		}
		return chckbxPazar;
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
						JOptionPane.showMessageDialog(GrupIslemleri.this, gun);

					}

				}
			});
			dateBaslamaTrh.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}

				public void inputMethodTextChanged(InputMethodEvent event) {
					dateBaslamaTrh.setDateFormatString("dd/MM/yyyy");
					JOptionPane.showMessageDialog(GrupIslemleri.this, dateBaslamaTrh.getDateFormatString());
				}
			});
			dateBaslamaTrh.setBounds(281, 67, 95, 20);
		}
		return dateBaslamaTrh;
	}
	private JDateChooser getDateBitisTrh() {
		if (dateBitisTrh == null) {
			dateBitisTrh = new JDateChooser();
			dateBitisTrh.setDateFormatString("dd/MM/yyyy");
			dateBitisTrh.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					if (dateBitisTrh.getDate() != null) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

						String gun = sdf.format(dateBitisTrh.getDate());
						JOptionPane.showMessageDialog(GrupIslemleri.this, gun);

					}

				}
			});
			dateBaslamaTrh.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}

				public void inputMethodTextChanged(InputMethodEvent event) {
					dateBitisTrh.setDateFormatString("dd/MM/yyyy");
					JOptionPane.showMessageDialog(GrupIslemleri.this, dateBitisTrh.getDateFormatString());
				}
			});
			dateBitisTrh.setBounds(281, 140, 95, 20);
		}
		return dateBitisTrh;
	}
	private JButton getBtnYeniGrupA() {
		if (btnYeniGrupA == null) {
			btnYeniGrupA = new JButton("Yeni Grup A\u00E7");
			btnYeniGrupA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					DbServicessBase<Groups> dao=new DbServicessBase<Groups>();
					Groups yenigrup=new Groups();
					yenigrup.setCourses((Courses) cmbKursAdi.getSelectedItem());
					yenigrup.setAdi(txtGrupAdi.getText());
					yenigrup.setTeacher((Teacher) getCmbOgretmen().getSelectedItem());
					yenigrup.setLessonClass((LessonClass) cmbSinif.getSelectedItem());
					yenigrup.setOgrenciSayisi(Integer.valueOf(txtOgrenciSayisi.getText()));
					yenigrup.setBaslamaTarihi(dateBaslamaTrh.getDate());
					yenigrup.setBitisTarihi(dateBitisTrh.getDate());
					
					DbServicessBase<Days> dao1=new DbServicessBase<Days>();
					yenigrup.setDays(gunSecimi());
					Days d = yenigrup.getDays();
					d.setName("Deneme");
					dao1.save(d);
					Days d1 = new Days();
					d1.setName("Deneme");
					yenigrup.setDays(dao1.search(d1).get(0));
					
					if (dao.save(yenigrup)) {
						txtMesaj.setText("Grup Baþarý ile Oluþturuldu");
						grupTablosuGoster();
						
					}
					else {
						txtMesaj.setText("Grup Oluþturulamadý");
					}
					
				}
			});
			btnYeniGrupA.setBounds(661, 154, 133, 48);
		}
		return btnYeniGrupA;
	}
	private JTable getTblGruplar() {
		if (tblGruplar == null) {
			tblGruplar = new JTable();
			tblGruplar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					int row=tblGruplar.getSelectedRow();
					
					selectedItemId = Long.valueOf(tblGruplar.getValueAt(row, 0).toString());
					cmbKursAdi.setSelectedItem(tblGruplar.getValueAt(row, 1));
					txtGrupAdi.setText(tblGruplar.getValueAt(row, 2).toString());
					cmbOgretmen.setSelectedItem(tblGruplar.getValueAt(row, 3));
					txtOgrenciSayisi.setText(tblGruplar.getValueAt(row, 4).toString());
					cmbSinif.setSelectedItem(tblGruplar.getValueAt(row, 5));
					dateBaslamaTrh.setDate(new Date((long) tblGruplar.getValueAt(row, 7)));
					dateBitisTrh.setDate(new Date((long) tblGruplar.getValueAt(row, 8)));
					
					
				}
			});
			tblGruplar.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						
					}
				));
			
		}
		return tblGruplar;
	}
}
