package com.hokumus.course.project.ui.student;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.hokumus.course.project.models.teacher.Teacher;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.hokumus.course.project.utils.dao.TeacherDAO;
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

public class ActionTeacher extends JFrame {
 
	private JTable table;
	private JTextField txtEmail;
	private JTextField txtAdi;
	private JTextField txtSoyadi;
	private Long selectedItemId;
	private JLabel lblMesaj;
	private JTextField txtTelNo;

	public ActionTeacher() {
		intialize();
	}
	private void intialize() {

		setTitle("GÜNCELLE/SÝL " + CourseUtils.loginedUser.getUserName() + " - " + CourseUtils.loginedUser.getRole());
		setBounds(100, 100, 609, 492);
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
				int row = table.getSelectedRow();
				selectedItemId = Long.valueOf(table.getValueAt(row, 0).toString());
				txtEmail.setText(table.getValueAt(row, 2).toString());
				txtAdi.setText(table.getValueAt(row, 3).toString());
				txtSoyadi.setText(table.getValueAt(row, 4).toString());
				txtTelNo.setText(table.getValueAt(row, 1).toString());
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
		lblEmail.setBounds(10, 76, 78, 14);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(84, 73, 163, 20);
		txtEmail.setColumns(10);
		getContentPane().add(txtEmail);

		JLabel lblAdi = new JLabel("Ad\u0131");
		lblAdi.setFont(new Font("Arial", Font.BOLD, 12));
		lblAdi.setBounds(10, 24, 78, 14);
		getContentPane().add(lblAdi);

		txtAdi = new JTextField();
		txtAdi.setBounds(84, 21, 163, 20);
		txtAdi.setColumns(10);
		getContentPane().add(txtAdi);

		JLabel lblSoyadi = new JLabel("Soyad\u0131");
		lblSoyadi.setFont(new Font("Arial", Font.BOLD, 12));
		lblSoyadi.setBounds(285, 24, 78, 14);
		getContentPane().add(lblSoyadi);

		txtSoyadi = new JTextField();
		txtSoyadi.setBounds(373, 21, 163, 20);
		txtSoyadi.setColumns(10);
		getContentPane().add(txtSoyadi);

		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.setBounds(454, 112, 110, 23);
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherDAO teacherdao = new TeacherDAO();
				Teacher teacher = new Teacher();
				teacher.setAd(txtAdi.getText());
				teacher.setSoyad(txtSoyadi.getText());
				teacher.setMail(txtEmail.getText());
				teacher.setId(selectedItemId);
				if (teacherdao.update(teacher)) {
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
				TeacherDAO teacherdao = new TeacherDAO();
				Teacher teacher = new Teacher();
				teacher.setId(selectedItemId);
				teacher.setAd(txtAdi.getText());
				teacher.setSoyad(txtSoyadi.getText());
				teacher.setMail(txtEmail.getText());
				if (teacherdao.delete(teacher)) {
					lblMesaj.setText("Baþarýlý..!");
					tabloDoldur();
				} else
					lblMesaj.setText("Baþarýsýz..!");
			}
		});
		btnSil.setFont(new Font("Arial", Font.BOLD, 14));
		btnSil.setBounds(330, 113, 110, 23);
		getContentPane().add(btnSil);
		getContentPane().add(getLblMesaj());
		
		JLabel lblTelNo = new JLabel("Tel No");
		lblTelNo.setFont(new Font("Arial", Font.BOLD, 12));
		lblTelNo.setBounds(285, 76, 78, 14);
		getContentPane().add(lblTelNo);
		getContentPane().add(getTxtTelNo());
		setTitle("Dershane Uygulamasý ");

		JMenuBar menuBarKullaniciIslem = new JMenuBar();
		setJMenuBar(menuBarKullaniciIslem);

		JMenu menuKullaniciIslem = new JMenu("Yeni");
		menuBarKullaniciIslem.add(menuKullaniciIslem);

		JMenuItem menuItemKEkle = new JMenuItem("Kullan\u0131c\u0131 Ekle");
		menuItemKEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacher frm = new AddTeacher();
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
		TeacherDAO teacherdao = new TeacherDAO();
		List<Teacher> liste = teacherdao.getAllRows(new Teacher());
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

	private JLabel getLblMesaj() {
		if (lblMesaj == null) {
			lblMesaj = new JLabel("");
			lblMesaj.setBounds(10, 397, 573, 23);
		}
		return lblMesaj;
	}
	private JTextField getTxtTelNo() {
		if (txtTelNo == null) {
			txtTelNo = new JTextField();
			txtTelNo.setColumns(10);
			txtTelNo.setBounds(373, 73, 163, 20);
		}
		return txtTelNo;
	}
}
