package com.hokumus.course.project.ui.student;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.hokumus.course.project.models.student.Student;
import com.hokumus.course.project.utils.dao.StudentDao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddAction extends JFrame { //??????

	private JTable table;
	private JTextField txtKullaniciAdi;
	private JTextField txtEmail;
	private JTextField txtAdi;
	private JTextField txtSoyadi;

	public AddAction() {
		intialize();
	}

	private void intialize() {
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
				txtKullaniciAdi.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				txtEmail.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				txtAdi.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				txtSoyadi.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
			}
		});
		scrollPane.setViewportView(table);
		tabloDoldur();

		JButton btnKullaniciGetir = new JButton("Kullan\u0131c\u0131lar\u0131 Getir");
		btnKullaniciGetir.setBounds(10, 352, 572, 23);
		btnKullaniciGetir.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(btnKullaniciGetir);

		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setBounds(124, 21, 141, 20);
		getContentPane().add(txtKullaniciAdi);
		txtKullaniciAdi.setColumns(10);

		JLabel lblKullaniciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131   *");
		lblKullaniciAdi.setFont(new Font("Arial", Font.BOLD, 12));
		lblKullaniciAdi.setBounds(10, 24, 93, 14);
		getContentPane().add(lblKullaniciAdi);

		JLabel lblEmail = new JLabel("Email   *");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmail.setBounds(287, 24, 78, 14);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(383, 21, 154, 20);
		txtEmail.setColumns(10);
		getContentPane().add(txtEmail);

		JLabel lblAdi = new JLabel("Ad\u0131");
		lblAdi.setFont(new Font("Arial", Font.BOLD, 12));
		lblAdi.setBounds(10, 70, 78, 14);
		getContentPane().add(lblAdi);

		txtAdi = new JTextField();
		txtAdi.setBounds(124, 67, 141, 20);
		txtAdi.setColumns(10);
		getContentPane().add(txtAdi);

		JLabel lblSoyadi = new JLabel("Soyad\u0131");
		lblSoyadi.setFont(new Font("Arial", Font.BOLD, 12));
		lblSoyadi.setBounds(287, 70, 78, 14);
		getContentPane().add(lblSoyadi);

		txtSoyadi = new JTextField();
		txtSoyadi.setBounds(383, 70, 154, 20);
		txtSoyadi.setColumns(10);
		getContentPane().add(txtSoyadi);

		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.setBounds(383, 112, 154, 23);
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDao studentdao = new StudentDao();
				Student student = new Student();
				student.setAd(txtAdi.getText());
				student.setSoyad(txtSoyadi.getText());
				student.setMail(txtEmail.getText());
				if (studentdao.update(student)) {
					JOptionPane.showMessageDialog(AddAction.this, "Kay�t Ba�ar�l�..!");
				} else
					JOptionPane.showMessageDialog(AddAction.this, "Kay�t Ba�ar�s�z..!");
			}
		});
		getContentPane().add(btnGuncelle);
		btnGuncelle.setFont(new Font("Arial", Font.BOLD, 14));
		setTitle("Dershane Uygulamas� ");

		JMenuBar menuBarKullaniciIslem = new JMenuBar();
		setJMenuBar(menuBarKullaniciIslem);

		JMenu menuKullaniciIslem = new JMenu("Yeni");
		menuBarKullaniciIslem.add(menuKullaniciIslem);

		JMenuItem menuItemKEkle = new JMenuItem("Kullan\u0131c\u0131 Ekle");
		menuItemKEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUsers frm = new AddUsers();
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
		StudentDao studentdao = new StudentDao();
		List<Student> liste = studentdao.getAllRows(new Student());
		String[][] data = new String[liste.size()][7];
		String[] columns = { "Id", "Ad�", "Soyad�", "Tel No", "Kay�t Tarihi", "E-Mail", "Adres" };
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
