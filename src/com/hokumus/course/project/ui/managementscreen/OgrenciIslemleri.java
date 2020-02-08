package com.hokumus.course.project.ui.managementscreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.management.Query;
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
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.hibernate.Session;

import com.hokumus.course.project.models.management.Courses;
import com.hokumus.course.project.models.management.Days;
import com.hokumus.course.project.models.management.Groups;
import com.hokumus.course.project.models.management.LessonClass;
import com.hokumus.course.project.models.student.Student;
import com.hokumus.course.project.models.teacher.Teacher;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.MyHBUtil;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OgrenciIslemleri extends JFrame{
	private JLabel lblKursAd;
	private JLabel lblGrupAd;
	private JButton btnGuncelle;
	private JButton btnIptal;
	private JButton btnGrupSil;
	private JScrollPane scrollPane;
	private JTextField txtArama;
	private JPanel panel_2;
	private JButton btnTemizle;
	private JDateChooser dateBitisTrh;
	private JButton btnOgrenciKaydet;
	private JScrollPane scrollPane_1;
	private JTable tblOgrenciKayitTablosu;
	private JLabel lblrencininSoyad;
	private JTextField txtOgrenciAdi;
	private JTextField txtOgrenciSoyadi;
	private JPanel pnlOgrenciBilgileri;
	private JTable tblOgrenciTablosu;
	private Long selectedStudentId;
	private String selectedStudentAdres;
	private String selectedStudentMail;
	private JLabel lblKursAd_1;
	private JComboBox cmbKursAdi;
	private JComboBox cmbGrupAdi;
	private JLabel lblTelno;
	private JTextField txtTelno;
	private JLabel txtMesaj;
	
	

	public OgrenciIslemleri() {
		initialize();
	}

	private void initialize() {
		setTitle("Grup G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil  -"+CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
		setBounds(300, 3, 940, 622);
		getContentPane().setLayout(null);
		getContentPane().setName("Öðrenci Ýþlemleri");
		getContentPane().add(getLblGrupAd());
		getContentPane().add(getBtnGuncelle());
		getContentPane().add(getBtnIptal());
		getContentPane().add(getBtnGrupSil());
		getContentPane().add(getScrollPane());
		getContentPane().add(getPanel_2());
		getContentPane().add(getBtnTemizle());
		getContentPane().add(getBtnOgrenciKaydet());
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getPnlOgrenciBilgileri());
		getContentPane().add(getLblKursAd_1());
		getContentPane().add(getCmbKursAdi());
		getContentPane().add(getCmbGrupAdi());
		getContentPane().add(getTxtMesaj());
		getContentPane().add(getBtnGrupSorgula());
		getContentPane().add(getCmbGrupSorgula());
		getContentPane().add(getLblGrup());
		ogrenciTablosuGoster();
		
		
		DbServicessBase<Courses> dao=new DbServicessBase<Courses>();
		DbServicessBase<Groups> dao1=new DbServicessBase<Groups>();
		List<Courses> kurslar=dao.getAllRows(new Courses());
		List<Groups> gruplar=dao1.getAllRows(new Groups());
		DefaultComboBoxModel model = new DefaultComboBoxModel(kurslar.toArray());	
		cmbKursAdi.setModel(model);
		 model = new DefaultComboBoxModel(gruplar.toArray());	
		cmbGrupAdi.setModel(model);
		cmbGrupSorgula.setModel(model);
		
		
		
		
	}
	
	
	DefaultTableModel model=new DefaultTableModel();
	private JButton btnGrupSorgula;
	private JComboBox cmbGrupSorgula;
	private JLabel lblGrup;
	
	public void ogrenciTablosuGoster() {
		
		
		DbServicessBase<Student> dao=new DbServicessBase<Student>(); 
		Student temp=new Student();
		List<Student> ogrenci_listesi=dao.getAllRows(temp);
		
		
		String [] columnNames= {"ID","AD","SOYAD","TEL.NO","ADRES","E-MAÝL","GRUP"};
		String [][] data=new String [ogrenci_listesi.size()][columnNames.length];
		
		
		for (int i = 0; i < ogrenci_listesi.size(); i++) {
			
			data[i][0]=CourseUtils.getValue(ogrenci_listesi.get(i).getId().toString());
			data[i][1]=CourseUtils.getValue(ogrenci_listesi.get(i).getAd());
			data[i][2]=CourseUtils.getValue(ogrenci_listesi.get(i).getSoyad());
			data[i][3]=CourseUtils.getValue(ogrenci_listesi.get(i).getTel());
			data[i][4]=CourseUtils.getValue(ogrenci_listesi.get(i).getAdres());
			data[i][5]=CourseUtils.getValue(ogrenci_listesi.get(i).getMail());
			data[i][6]=CourseUtils.getValue(ogrenci_listesi.get(i).getGroups());
			
		}
		
		model=new DefaultTableModel(data,columnNames);
		tblOgrenciTablosu.setModel(model);
	
	}
	
	public void ogrenciKayitTablosuGoster() {
	
		DbServicessBase<Student> dao=new DbServicessBase<Student>(); 
		Student temp=new Student();
		Long groupsId=((Groups)cmbGrupSorgula.getSelectedItem()).getId();
		System.out.println(groupsId);
		Groups g = new Groups();
		g.setId(groupsId);
		temp.setGroups(g);
		
		List<Student>  kayitlistesi=dao.search(temp);

		String [] columnNames= {"ID","GRUP ADI","ÖÐ. ADI","ÖÐ. SOYADI","ÖÐ. TEL.NO"};
		String [][] data=new String [kayitlistesi.size()][columnNames.length];
		
		
		for (int i = 0; i < kayitlistesi.size(); i++) {
			
			data[i][0]=CourseUtils.getValue(kayitlistesi.get(i).getId().toString());
			data[i][1]=CourseUtils.getValue(kayitlistesi.get(i).getGroups());
			data[i][2]=CourseUtils.getValue(kayitlistesi.get(i).getAd());
			data[i][3]=CourseUtils.getValue(kayitlistesi.get(i).getSoyad());
			data[i][4]=CourseUtils.getValue(kayitlistesi.get(i).getTel());
			
		}
		
		model=new DefaultTableModel(data,columnNames);
		tblOgrenciKayitTablosu.setModel(model);
		
	}
	public void arama(String ara) {
		
		TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
		tblOgrenciTablosu.setRowSorter(tr);
		
		tr.setRowFilter(RowFilter.regexFilter(ara));		
		
	}
	
	private JLabel getLblKursAd() {
		if (lblKursAd == null) {
			lblKursAd = new JLabel(" Ad\u0131: ");
			lblKursAd.setBounds(10, 32, 76, 14);
		}
		return lblKursAd;
	}
	private JLabel getLblGrupAd() {
		if (lblGrupAd == null) {
			lblGrupAd = new JLabel("Grup Ad\u0131:");
			lblGrupAd.setBounds(259, 62, 76, 14);
		}
		return lblGrupAd;
	}
	private JButton getBtnGuncelle() {
		if (btnGuncelle == null) {
			btnGuncelle = new JButton("\u00D6\u011Frenci Grubu G\u00FCncelle");
			btnGuncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DbServicessBase<Student> dao=new DbServicessBase<Student>();
					Student guncelle_ogrenci=new Student();
					guncelle_ogrenci.setId(selectedStudentId);
					guncelle_ogrenci.setAd(txtOgrenciAdi.getText());
					guncelle_ogrenci.setSoyad(txtOgrenciSoyadi.getText());
					guncelle_ogrenci.setTel(txtTelno.getText());
					guncelle_ogrenci.setMail(selectedStudentMail);
					guncelle_ogrenci.setAdres(selectedStudentAdres);
					guncelle_ogrenci.setGroups((Groups) cmbGrupAdi.getSelectedItem());
					
					if (dao.update(guncelle_ogrenci)) {
						txtMesaj.setText("Öðrenci Baþarý ile Güncellendi");
						ogrenciTablosuGoster();
					}
					else {
						txtMesaj.setText("Öðrenci Güncellenemedi");
					}
				}
			});
			btnGuncelle.setBounds(480, 11, 194, 51);
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
			btnIptal.setBounds(730, 77, 109, 48);
		}
		return btnIptal;
	}
	private JButton getBtnGrupSil() {
		if (btnGrupSil == null) {
			btnGrupSil = new JButton();
			btnGrupSil.setToolTipText("");
			btnGrupSil.setHorizontalTextPosition(SwingConstants.RIGHT);
			btnGrupSil.setText("\u00D6\u011Frencinin Grubunu Sil");
			btnGrupSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DbServicessBase<Student> dao=new DbServicessBase<Student>();
					Student cikan_ogrenci=new Student();
					cikan_ogrenci.setId(selectedStudentId);
					cikan_ogrenci.setAd(txtOgrenciAdi.getText());
					cikan_ogrenci.setSoyad(txtOgrenciSoyadi.getText());
					cikan_ogrenci.setTel(txtTelno.getText());
					cikan_ogrenci.setMail(selectedStudentMail);
					cikan_ogrenci.setAdres(selectedStudentAdres);
					cikan_ogrenci.setGroups(null);
					if (dao.update(cikan_ogrenci)) {
						txtMesaj.setText("Öðrenci Gruptan Silindi");
						ogrenciTablosuGoster();
					}
					else {
						txtMesaj.setText("Öðrenci Gruptan Silinemedi");

					}
				}
			});
			btnGrupSil.setBounds(480, 77, 194, 48);
		}
		return btnGrupSil;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 192, 832, 164);
			scrollPane.setViewportView(getTblOgrenciTablosu());
		}
		return scrollPane;
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
			txtArama.setBounds(10, 17, 426, 20);
			txtArama.setColumns(10);
		}
		return txtArama;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Arama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 136, 446, 48);
			panel_2.setLayout(null);
			panel_2.add(getTxtArama());
		}
		return panel_2;
	}
	private JButton getBtnTemizle() {
		if (btnTemizle == null) {
			btnTemizle = new JButton("Temizle");
			btnTemizle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtArama.setText("");
					txtMesaj.setText("");
					txtOgrenciAdi.setText("");
					txtOgrenciSoyadi.setText("");
					txtTelno.setText("");
					cmbGrupAdi.getModel().setSelectedItem(null);
					cmbKursAdi.getModel().setSelectedItem(null);
				}
			});
			btnTemizle.setBounds(730, 11, 112, 48);
		}
		return btnTemizle;
	}
	
	private JButton getBtnOgrenciKaydet() {
		if (btnOgrenciKaydet == null) {
			btnOgrenciKaydet = new JButton("\u00D6\u011Frenciyi Gruba Kaydet");
			btnOgrenciKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DbServicessBase<Student> dao=new DbServicessBase<Student>();
					Student temp=new Student();
					
					int row=tblOgrenciKayitTablosu.getSelectedRow();
					temp.setId(selectedStudentId);
					temp.setAd(txtOgrenciAdi.getText());
					temp.setSoyad(txtOgrenciSoyadi.getText());
					temp.setTel(txtOgrenciSoyadi.getText());
					temp.setAdres(selectedStudentAdres);
					temp.setMail(selectedStudentMail);
					temp.setGroups((Groups)cmbGrupAdi.getSelectedItem());
				
					if (dao.update(temp)) {
						txtMesaj.setText("Öðrenci Baþarý ile Kaydedildi");
						ogrenciTablosuGoster();
					}
					else {
						txtMesaj.setText("Öðrenci Kaydedilemedi");

					}
				}
			});
			btnOgrenciKaydet.setBounds(480, 136, 194, 48);
		}
		return btnOgrenciKaydet;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(20, 390, 832, 164);
			scrollPane_1.setViewportView(getTable_1_1());
		}
		return scrollPane_1;
	}
	private JTable getTable_1_1() {
		if (tblOgrenciKayitTablosu == null) {
			tblOgrenciKayitTablosu = new JTable();
		}
		return tblOgrenciKayitTablosu;
	}
	private JLabel getLblrencininSoyad() {
		if (lblrencininSoyad == null) {
			lblrencininSoyad = new JLabel(" Soyad\u0131:");
			lblrencininSoyad.setBounds(10, 57, 95, 14);
		}
		return lblrencininSoyad;
	}
	private JTextField getTxtOgrenciAdi() {
		if (txtOgrenciAdi == null) {
			txtOgrenciAdi = new JTextField();
			txtOgrenciAdi.setEnabled(false);
			txtOgrenciAdi.setBounds(75, 29, 86, 20);
			txtOgrenciAdi.setColumns(10);
		}
		return txtOgrenciAdi;
	}
	private JTextField getTxtOgrenciSoyadi() {
		if (txtOgrenciSoyadi == null) {
			txtOgrenciSoyadi = new JTextField();
			txtOgrenciSoyadi.setEnabled(false);
			txtOgrenciSoyadi.setBounds(75, 57, 86, 20);
			txtOgrenciSoyadi.setColumns(10);
		}
		return txtOgrenciSoyadi;
	}
	private JPanel getPnlOgrenciBilgileri() {
		if (pnlOgrenciBilgileri == null) {
			pnlOgrenciBilgileri = new JPanel();
			pnlOgrenciBilgileri.setBorder(new TitledBorder(null, "\u00D6\u011Frenci Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlOgrenciBilgileri.setBounds(10, 11, 218, 114);
			pnlOgrenciBilgileri.setLayout(null);
			pnlOgrenciBilgileri.add(getLblKursAd());
			pnlOgrenciBilgileri.add(getTxtOgrenciAdi());
			pnlOgrenciBilgileri.add(getLblrencininSoyad());
			pnlOgrenciBilgileri.add(getTxtOgrenciSoyadi());
			pnlOgrenciBilgileri.add(getLblTelno());
			pnlOgrenciBilgileri.add(getTxtTelno());
		}
		return pnlOgrenciBilgileri;
	}
	private JTable getTblOgrenciTablosu() {
		if (tblOgrenciTablosu == null) {
			tblOgrenciTablosu = new JTable();
			tblOgrenciTablosu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					int row=tblOgrenciTablosu.getSelectedRow();
					
					txtOgrenciAdi.setText(CourseUtils.getValue(tblOgrenciTablosu.getValueAt(row, 1).toString()));
					txtOgrenciSoyadi.setText(CourseUtils.getValue(tblOgrenciTablosu.getValueAt(row, 2).toString()));
					txtTelno.setText(CourseUtils.getValue(tblOgrenciTablosu.getValueAt(row, 3).toString()));
					selectedStudentId=Long.valueOf( tblOgrenciTablosu.getValueAt(row, 0).toString());
					selectedStudentAdres=CourseUtils.getValue(tblOgrenciTablosu.getValueAt(row, 4).toString());
					selectedStudentMail=CourseUtils.getValue(tblOgrenciTablosu.getValueAt(row, 5).toString());
					cmbGrupAdi.getModel().setSelectedItem(tblOgrenciTablosu.getValueAt(row, 6));
				}
			});
		}
		return tblOgrenciTablosu;
	}
	private JLabel getLblKursAd_1() {
		if (lblKursAd_1 == null) {
			lblKursAd_1 = new JLabel("Kurs Ad\u0131:");
			lblKursAd_1.setBounds(259, 25, 65, 14);
		}
		return lblKursAd_1;
	}
	private JComboBox getCmbKursAdi() {
		if (cmbKursAdi == null) {
			cmbKursAdi = new JComboBox();
			cmbKursAdi.setBounds(345, 25, 108, 20);
		}
		return cmbKursAdi;
	}
	private JComboBox getCmbGrupAdi() {
		if (cmbGrupAdi == null) {
			cmbGrupAdi = new JComboBox();
			cmbGrupAdi.setBounds(345, 59, 108, 20);
		}
		return cmbGrupAdi;
	}
	private JLabel getLblTelno() {
		if (lblTelno == null) {
			lblTelno = new JLabel("Tel.No:");
			lblTelno.setBounds(10, 82, 58, 14);
		}
		return lblTelno;
	}
	private JTextField getTxtTelno() {
		if (txtTelno == null) {
			txtTelno = new JTextField();
			txtTelno.setEnabled(false);
			txtTelno.setColumns(10);
			txtTelno.setBounds(75, 82, 86, 20);
		}
		return txtTelno;
	}
	private JLabel getTxtMesaj() {
		if (txtMesaj == null) {
			txtMesaj = new JLabel("");
			txtMesaj.setForeground(new Color(255, 0, 0));
			txtMesaj.setBounds(10, 552, 559, 20);
		}
		return txtMesaj;
	}
	private JButton getBtnGrupSorgula() {
		if (btnGrupSorgula == null) {
			btnGrupSorgula = new JButton("Grup Sorgula");
			btnGrupSorgula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ogrenciKayitTablosuGoster();
				}
			});
			btnGrupSorgula.setBounds(657, 367, 182, 23);
		}
		return btnGrupSorgula;
	}
	private JComboBox getCmbGrupSorgula() {
		if (cmbGrupSorgula == null) {
			cmbGrupSorgula = new JComboBox();
			cmbGrupSorgula.setBounds(541, 367, 109, 20);
		}
		return cmbGrupSorgula;
	}
	private JLabel getLblGrup() {
		if (lblGrup == null) {
			lblGrup = new JLabel("Grup:");
			lblGrup.setBounds(480, 371, 56, 14);
		}
		return lblGrup;
	}
}
