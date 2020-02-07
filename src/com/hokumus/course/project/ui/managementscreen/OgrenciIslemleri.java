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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

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

public class OgrenciIslemleri extends JFrame{
	private JLabel lblKursAd;
	private JLabel lblGrupAd;
	private JButton btnGuncelle;
	private JButton btnIptal;
	private JButton btnSil;
	private JScrollPane scrollPane;
	private JTextField txtArama;
	private JPanel panel_2;
	private JButton btnTemizle;
	private JLabel txtMesaj;
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
		getContentPane().add(getBtnSil());
		getContentPane().add(getScrollPane());
		getContentPane().add(getPanel_2());
		getContentPane().add(getBtnTemizle());
		getContentPane().add(getTxtMesaj());
		getContentPane().add(getBtnOgrenciKaydet());
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getPnlOgrenciBilgileri());
		getContentPane().add(getLblKursAd_1());
		getContentPane().add(getCmbKursAdi());
		getContentPane().add(getCmbGrupAdi());
		ogrenciTablosuGoster();
		
		
		DbServicessBase<Courses> dao=new DbServicessBase<Courses>();
		List<Courses> kurslar=dao.getAllRows(new Courses());
		DefaultComboBoxModel model = new DefaultComboBoxModel(kurslar.toArray());	
		cmbKursAdi.setModel(model);
		DbServicessBase<Groups> dao1=new DbServicessBase<Groups>();
		List<Groups> gruplar=dao1.getAllRows(new Groups());
		 model = new DefaultComboBoxModel(gruplar.toArray());	
		cmbGrupAdi.setModel(model);
		getContentPane().add(getLblMesaj());
	}
	
	
	DefaultTableModel model=new DefaultTableModel();
	private JLabel lblTelno;
	private JTextField txtTelno;
	private JLabel lblMesaj;
	
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
			data[i][6]=CourseUtils.getValue(ogrenci_listesi.get(i).getGroups().getAdi().toString());
		
			
			
		}
		
		model=new DefaultTableModel(data,columnNames);
		tblOgrenciTablosu.setModel(model);
		
		
		
	}
	
	public void ogrenciKayitTablosuGoster() {
		
		
		DbServicessBase<Student> dao=new DbServicessBase<Student>(); 
		Student temp=new Student();
		List<Student> kayitlistesi=dao.getAllRows(temp);
		
		
		String [] columnNames= {"ID","KURS ADI","GRUP ADI","ÖÐ. ADI","ÖÐ. SOYADI","ÖÐ. TEL.NO"};
		String [][] data=new String [kayitlistesi.size()][columnNames.length];
		
		
		for (int i = 0; i < kayitlistesi.size(); i++) {
			
			data[i][0]=CourseUtils.getValue(kayitlistesi.get(i).getId().toString());
			data[i][1]=CourseUtils.getValue(kayitlistesi.get(i).getGroups().getCourses().getAdi().toString());
			data[i][2]=CourseUtils.getValue(kayitlistesi.get(i).getGroups().getAdi().toString());
			data[i][3]=CourseUtils.getValue(kayitlistesi.get(i).getAd().toString());
			data[i][4]=CourseUtils.getValue(kayitlistesi.get(i).getSoyad().toString());
			data[i][5]=CourseUtils.getValue(kayitlistesi.get(i).getTel().toString());
			
		}
		
		model=new DefaultTableModel(data,columnNames);
		tblOgrenciKayitTablosu.setModel(model);
		
		
		
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
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 207, 832, 164);
			scrollPane.setViewportView(getTblOgrenciTablosu());
		}
		return scrollPane;
	}
	private JTextField getTxtArama() {
		if (txtArama == null) {
			txtArama = new JTextField();
			txtArama.setBounds(10, 24, 543, 20);
			txtArama.setColumns(10);
		}
		return txtArama;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Arama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(260, 149, 595, 55);
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
	
	private JButton getBtnOgrenciKaydet() {
		if (btnOgrenciKaydet == null) {
			btnOgrenciKaydet = new JButton("\u00D6\u011Frenci Kaydet");
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
						lblMesaj.setText("Öðrenci Baþarý ile Kaydedildi");
						ogrenciKayitTablosuGoster();
						ogrenciTablosuGoster();
					}
					else {
						lblMesaj.setText("Öðrenci Kaydedilemedi");

					}
				}
			});
			btnOgrenciKaydet.setBounds(290, 90, 133, 48);
		}
		return btnOgrenciKaydet;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 382, 842, 152);
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
			lblrencininSoyad.setBounds(10, 85, 95, 14);
		}
		return lblrencininSoyad;
	}
	private JTextField getTxtOgrenciAdi() {
		if (txtOgrenciAdi == null) {
			txtOgrenciAdi = new JTextField();
			txtOgrenciAdi.setBounds(75, 29, 86, 20);
			txtOgrenciAdi.setColumns(10);
		}
		return txtOgrenciAdi;
	}
	private JTextField getTxtOgrenciSoyadi() {
		if (txtOgrenciSoyadi == null) {
			txtOgrenciSoyadi = new JTextField();
			txtOgrenciSoyadi.setBounds(75, 82, 86, 20);
			txtOgrenciSoyadi.setColumns(10);
		}
		return txtOgrenciSoyadi;
	}
	private JPanel getPnlOgrenciBilgileri() {
		if (pnlOgrenciBilgileri == null) {
			pnlOgrenciBilgileri = new JPanel();
			pnlOgrenciBilgileri.setBorder(new TitledBorder(null, "\u00D6\u011Frenci Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlOgrenciBilgileri.setBounds(10, 11, 218, 166);
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
			cmbKursAdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					DbServicessBase<Groups> dao=new DbServicessBase<Groups>();
					Courses kurs=(Courses) cmbKursAdi.getModel().getSelectedItem();
					Long id=kurs.getId();
					
					String hql="from Groups where course_id=:id";
				
				
					DefaultComboBoxModel<Groups> model=new DefaultComboBoxModel<Groups>();
					//List<Groups> kurslar=dao.getAllRows(temp);
					cmbGrupAdi.setModel(model);
					
				}
			});
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
			lblTelno.setBounds(10, 127, 58, 14);
		}
		return lblTelno;
	}
	private JTextField getTxtTelno() {
		if (txtTelno == null) {
			txtTelno = new JTextField();
			txtTelno.setColumns(10);
			txtTelno.setBounds(75, 124, 86, 20);
		}
		return txtTelno;
	}
	private JLabel getLblMesaj() {
		if (lblMesaj == null) {
			lblMesaj = new JLabel("");
			lblMesaj.setForeground(new Color(255, 0, 0));
			lblMesaj.setBounds(10, 545, 559, 27);
		}
		return lblMesaj;
	}
}
