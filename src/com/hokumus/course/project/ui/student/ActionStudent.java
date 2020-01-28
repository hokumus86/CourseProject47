package com.hokumus.course.project.ui.student;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.hokumus.course.project.models.student.Student;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.hokumus.course.project.utils.dao.StudentDAO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActionStudent extends JFrame { 

	private JTable table;
	private JTextField txtEmail;
	private JTextField txtAdi;
	private JTextField txtSoyadi;
	private Long selectedItemId;
	private JLabel lblMesaj;
	private JTextField txtTelNo;


	public ActionStudent() {
		intialize();
	}

	private void intialize() {
		setTitle("GÜNCELLE " + CourseUtils.loginedUser.getUserName()+ " - " + CourseUtils.loginedUser.getRole());
		setBounds(100, 100, 609, 477);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBackground(Color.BLACK);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 572, 179);
		getContentPane().add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedItemId = Long.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
				txtEmail.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				txtAdi.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				txtSoyadi.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				txtTelNo.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			}
		});
		scrollPane.setViewportView(table);
		tabloDoldur();

		JButton btnKullaniciGetir = new JButton("Kullan\u0131c\u0131lar\u0131 Getir");
		btnKullaniciGetir.setBounds(10, 352, 572, 23);
		btnKullaniciGetir.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(btnKullaniciGetir);

		JLabel lblEmail = new JLabel("Email   ");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmail.setBounds(10, 73, 78, 14);
		getContentPane().add(lblEmail);
		txtEmail = new JTextField();
		txtEmail.setBounds(64, 70, 192, 20);
		txtEmail.setColumns(10);
		getContentPane().add(txtEmail);

		JLabel lblAdi = new JLabel("Ad\u0131");
		lblAdi.setFont(new Font("Arial", Font.BOLD, 12));
		lblAdi.setBounds(10, 27, 78, 14);
		getContentPane().add(lblAdi);
		txtAdi = new JTextField();
		txtAdi.setBounds(64, 24, 192, 20);
		txtAdi.setColumns(10);
		getContentPane().add(txtAdi);

		JLabel lblSoyadi = new JLabel("Soyad\u0131");
		lblSoyadi.setFont(new Font("Arial", Font.BOLD, 12));
		lblSoyadi.setBounds(300, 27, 78, 14);
		getContentPane().add(lblSoyadi);
		txtSoyadi = new JTextField();
		txtSoyadi.setBounds(374, 24, 154, 20);
		txtSoyadi.setColumns(10);
		getContentPane().add(txtSoyadi);

		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.setBounds(454, 112, 110, 23);
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDAO studentdao = new StudentDAO();
				Student student = new Student();
				student.setAd(txtAdi.getText());
				student.setSoyad(txtSoyadi.getText());
				student.setMail(txtEmail.getText());
				student.setId(selectedItemId);
				student.setTel(txtTelNo.getText());
				if (studentdao.update(student)) {
					lblMesaj.setText("Baþarýlý..!");
					tabloDoldur();
				} else
					lblMesaj.setText("Baþarýsýz..!");
			}
		});
		getContentPane().add(btnGuncelle);
		btnGuncelle.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbServicessBase<Student> studentdao=new DbServicessBase<Student>();
				Student student = new Student();
				student.setId(selectedItemId);
				student.setAd(txtAdi.getText());
				student.setSoyad(txtSoyadi.getText());
				student.setMail(txtEmail.getText());
				student.setTel(txtTelNo.getText());
				if (studentdao.delete(student)) {
					lblMesaj.setText("Baþarýlý..!");
					tabloDoldur();
				} else
					lblMesaj.setText("Baþarýsýz..!");
				
			}
		});
		btnSil.setFont(new Font("Arial", Font.BOLD, 14));
		btnSil.setBounds(330, 113, 110, 23);
		getContentPane().add(btnSil);
		
		JLabel lblMesaj = new JLabel("");
		lblMesaj.setBounds(10, 397, 573, 23);
		getContentPane().add(lblMesaj);
		
		JLabel lblTelNo = new JLabel("Tel No");
		lblTelNo.setFont(new Font("Arial", Font.BOLD, 12));
		lblTelNo.setBounds(300, 70, 78, 14);
		getContentPane().add(lblTelNo);
		
		txtTelNo = new JTextField();
		txtTelNo.setColumns(10);
		txtTelNo.setBounds(374, 67, 154, 20);
		getContentPane().add(txtTelNo);
		setTitle("Dershane Uygulamasý ");

		JMenuBar menuBarKullaniciIslem = new JMenuBar();
		setJMenuBar(menuBarKullaniciIslem);

		JMenu menuKullaniciIslem = new JMenu("Yeni");
		menuBarKullaniciIslem.add(menuKullaniciIslem);

		JMenuItem menuItemKEkle = new JMenuItem("Kullan\u0131c\u0131 Ekle");
		menuItemKEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent frm = new AddStudent();
				frm.setVisible(true);
			}
		});
		menuKullaniciIslem.add(menuItemKEkle);
		btnKullaniciGetir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tabloDoldur();

			}
		});
	}

	private void tabloDoldur() {
		StudentDAO studentdao = new StudentDAO();
		List<Student> liste = studentdao.getAllRows(new Student());
		String[][] data = new String[liste.size()][7];
		String[] columns = { "Id", "Adý", "Soyadý", "Tel No", "Kayýt Tarihi", "E-Mail", "Adres" };
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = String.valueOf(liste.get(i).getId());
			data[i][1] = liste.get(i).getAd();
			data[i][2] = liste.get(i).getSoyad();
			data[i][3] = liste.get(i).getTel();
			data[i][4] = String.valueOf(liste.get(i).getKayitTarihi());
			data[i][5] = liste.get(i).getMail();
			data[i][6] = liste.get(i).getAdres();

		}
		DefaultTableModel model = new DefaultTableModel(data, columns);
		table.setModel(model);

	}
}
