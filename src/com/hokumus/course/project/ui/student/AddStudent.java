package com.hokumus.course.project.ui.student;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.hokumus.course.project.models.student.Student;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.StudentDAO;
import com.toedter.calendar.JDateChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AddStudent extends JFrame {
  
	private JLabel lblAdi;
	private JTextField txtAdi; 
	private JLabel lblSoyadi;
	private JTextField txtSoyadi;
	private JDateChooser dateKayýtTarihi;
	private JLabel lblKayitTarihi;
	private JTextField txtTelNo;
	private JLabel lblTelNo;
	private JLabel lblAdres;
	private JTextField txtAdres;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JButton btnKayit;
	private JButton btnIptal;
	private JLabel lblMesaj;
	private Long selectedItemId;
	private JMenuBar menuBar;
	private JMenu mnGüncelle;
	private JMenuItem mnýtmGüncelle;

	public AddStudent() {
		
		initialize();
	}

	private void initialize() {
		
		setTitle("KAYIT " + CourseUtils.loginedUser.getUserName() + " - " + CourseUtils.loginedUser.getRole());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 330);
		setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		getContentPane().add(getLblAdi());
		getContentPane().add(getTxtAdi());
		getContentPane().add(getLblSoyadi());
		getContentPane().add(getTxtSoyadi());
		getContentPane().add(getDateKayýtTarihi());
		getContentPane().add(getLblKayitTarihi());
		getContentPane().add(getTxtTelNo());
		getContentPane().add(getLblTelNo());
		getContentPane().add(getLblAdres());
		getContentPane().add(getTxtAdres());
		getContentPane().add(getLblEmail());
		getContentPane().add(getTxtEmail());
		getContentPane().add(getBtnKayit());
		getContentPane().add(getBtnIptal());
		getContentPane().add(getLblMesaj());
		getContentPane().add(getMenuBar_1());
	
	}
	private JLabel getLblAdi() {
		if (lblAdi == null) {
			lblAdi = new JLabel("Ad\u0131 ");
			lblAdi.setFont(new Font("Arial", Font.BOLD, 12));
			lblAdi.setBounds(10, 36, 67, 14);
		}
		return lblAdi;
	}
	private JTextField getTxtAdi() {
		if (txtAdi == null) {
			txtAdi = new JTextField();
			txtAdi.setColumns(10);
			txtAdi.setBounds(87, 33, 158, 20);
		}
		return txtAdi;
	}
	private JLabel getLblSoyadi() {
		if (lblSoyadi == null) {
			lblSoyadi = new JLabel("Soyad\u0131");
			lblSoyadi.setFont(new Font("Arial", Font.BOLD, 12));
			lblSoyadi.setBounds(269, 39, 67, 14);
		}
		return lblSoyadi;
	}
	private JTextField getTxtSoyadi() {
		if (txtSoyadi == null) {
			txtSoyadi = new JTextField();
			txtSoyadi.setColumns(10);
			txtSoyadi.setBounds(346, 34, 144, 20);
		}
		return txtSoyadi;
	}
	private JDateChooser getDateKayýtTarihi() {
		if (dateKayýtTarihi == null) {
			dateKayýtTarihi = new JDateChooser();
			dateKayýtTarihi.setDateFormatString("dd/MM/yyyy");
			dateKayýtTarihi.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					if (dateKayýtTarihi.getDate() != null) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String gun = sdf.format(dateKayýtTarihi.getDate());
					}
				}
			});
			    dateKayýtTarihi.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}
				public void inputMethodTextChanged(InputMethodEvent event) {
					dateKayýtTarihi.setDateFormatString("dd/MM/yyyy");
				}
			});
			dateKayýtTarihi.setBounds(346, 90, 144, 22);
		}
		return dateKayýtTarihi;
	}
	private JLabel getLblKayitTarihi() {
		if (lblKayitTarihi == null) {
			lblKayitTarihi = new JLabel("Kay\u0131t Tarihi");
			lblKayitTarihi.setFont(new Font("Arial", Font.BOLD, 12));
			lblKayitTarihi.setBounds(269, 90, 67, 14);
		}
		return lblKayitTarihi;
	}
	private JTextField getTxtTelNo() {
		if (txtTelNo == null) {
			txtTelNo = new JTextField();
			txtTelNo.setColumns(10);
			txtTelNo.setBounds(87, 84, 158, 20);
		}
		return txtTelNo;
	}
	private JLabel getLblTelNo() {
		if (lblTelNo == null) {
			lblTelNo = new JLabel("Telefon No");
			lblTelNo.setFont(new Font("Arial", Font.BOLD, 12));
			lblTelNo.setBounds(10, 87, 67, 14);
		}
		return lblTelNo;
	}
	private JLabel getLblAdres() {
		if (lblAdres == null) {
			lblAdres = new JLabel("Adres");
			lblAdres.setFont(new Font("Arial", Font.BOLD, 12));
			lblAdres.setBounds(10, 140, 67, 14);
		}
		return lblAdres;
	}
	private JTextField getTxtAdres() {
		if (txtAdres == null) {
			txtAdres = new JTextField();
			txtAdres.setColumns(10);
			txtAdres.setBounds(87, 137, 158, 82);
		}
		return txtAdres;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
			lblEmail.setBounds(269, 140, 67, 14);
		}
		return lblEmail;
	}
	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(346, 137, 144, 20);
		}
		return txtEmail;
	}
	private JButton getBtnKayit() {
		if (btnKayit == null) {
			btnKayit = new JButton("Kaydet");
			btnKayit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentDAO studentdao = new StudentDAO();
					Student student = new Student();
					student.setId(selectedItemId);
					student.setAd(txtAdi.getText());
					student.setSoyad(txtSoyadi.getText());
					student.setMail(txtEmail.getText());
					student.setAdres(txtAdres.getText());
					student.setTel(txtTelNo.getText());
					if (studentdao.save(student)) {
						lblMesaj.setText("Baþarýlý..!");
					} else
						lblMesaj.setText("Baþarýsýz..!");
				}
			});
			btnKayit.setFont(new Font("Arial", Font.BOLD, 12));
			btnKayit.setBounds(381, 227, 91, 23);
		}
		return btnKayit;
	}
	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddStudent.this.dispose();
				}
			});
			btnIptal.setFont(new Font("Arial", Font.BOLD, 12));
			btnIptal.setBounds(269, 227, 91, 23);
		}
		return btnIptal;
	}
	private JLabel getLblMesaj() {
		if (lblMesaj == null) {
			lblMesaj = new JLabel("");
			lblMesaj.setBounds(10, 261, 514, 23);
		}
		return lblMesaj;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 534, 22);
			menuBar.add(getMnGüncelle());
		}
		return menuBar;
	}
	private JMenu getMnGüncelle() {
		if (mnGüncelle == null) {
			mnGüncelle = new JMenu("Yeni");
			mnGüncelle.add(getMnýtmGüncelle());
		}
		return mnGüncelle;
	}
	private JMenuItem getMnýtmGüncelle() {
		if (mnýtmGüncelle == null) {
			mnýtmGüncelle = new JMenuItem("\u00D6\u011Frenci G\u00FCncelle");
			mnýtmGüncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddStudent addstudent=new AddStudent();
					addstudent.setVisible(true);
					dispose();
				}
			});
		}
		return mnýtmGüncelle;
	}
}
