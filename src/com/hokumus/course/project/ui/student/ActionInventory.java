package com.hokumus.course.project.ui.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.project.models.inventory.Inventory;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.InventoryDAO;

@SuppressWarnings("serial") 
public class ActionInventory extends JFrame {


	private JTable table;
	private JTextField txtTanim;
	private JTextField txtgrntiSüresi;
	private Long selectedItemId;
	private JLabel lblMesaj;
	private JTextField txtkullanýmyeri;
	private JLabel lblKullanm;
	private JTextField txtFiyat;

	public ActionInventory() {
		intialize();
	}
	private void intialize() {

		setTitle("GÜNCELLE " + CourseUtils.loginedUser.getUserName() + " - " + CourseUtils.loginedUser.getRole());
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
				txtTanim.setText(table.getValueAt(row, 1).toString());
				txtgrntiSüresi.setText(table.getValueAt(row, 2).toString());
				txtkullanýmyeri.setText(table.getValueAt(row, 3).toString());
				txtFiyat.setText(table.getValueAt(row, 4).toString());
			}
		});
		scrollPane.setViewportView(table);
		tabloDoldur();

		JButton btnKullaniciGetir = new JButton("KAYITLI VER\u0130LER");
		btnKullaniciGetir.setBounds(10, 352, 572, 23);
		btnKullaniciGetir.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(btnKullaniciGetir);

		JLabel lblFiyat = new JLabel("Fiyat");
		lblFiyat.setFont(new Font("Arial", Font.BOLD, 12));
		lblFiyat.setBounds(10, 76, 78, 14);
		getContentPane().add(lblFiyat);

		JLabel lblTanim = new JLabel("Tan\u0131m");
		lblTanim.setFont(new Font("Arial", Font.BOLD, 12));
		lblTanim.setBounds(10, 24, 78, 14);
		getContentPane().add(lblTanim);

		txtTanim = new JTextField();
		txtTanim.setBounds(84, 21, 163, 20);
		txtTanim.setColumns(10);
		getContentPane().add(txtTanim);

		JLabel lblGrntiSüresi = new JLabel("Garanti S\u00FCresi");
		lblGrntiSüresi.setFont(new Font("Arial", Font.BOLD, 12));
		lblGrntiSüresi.setBounds(285, 24, 106, 14);
		getContentPane().add(lblGrntiSüresi);

		txtgrntiSüresi = new JTextField();
		txtgrntiSüresi.setBounds(401, 21, 163, 20);
		txtgrntiSüresi.setColumns(10);
		getContentPane().add(txtgrntiSüresi);

		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.setBounds(454, 112, 110, 23);
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InventoryDAO ýnventorydao = new InventoryDAO();
				Inventory ýnventory = new Inventory();
				ýnventory.setTanim(txtTanim.getText());
				ýnventory.setExpenses(txtFiyat.getText());
				ýnventory.setId(selectedItemId);
				ýnventory.setGaranti(new BigDecimal(txtFiyat.getText()));
				ýnventory.setKullaným(txtkullanýmyeri.getText());
				if (ýnventorydao.update(ýnventory)) {
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
				InventoryDAO ýnventorydao = new InventoryDAO();
				Inventory ýnventory = new Inventory();
				ýnventory.setTanim(txtTanim.getText());
				ýnventory.setExpenses(txtFiyat.getText());
				ýnventory.setId(selectedItemId);
				ýnventory.setGaranti(new BigDecimal(txtFiyat.getText()));
				ýnventory.setKullaným(txtkullanýmyeri.getText());
				if (ýnventorydao.delete(ýnventory)) {
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
		getContentPane().add(getTxtkullanýmyeri());
		getContentPane().add(getLblKullanm());
		
		txtFiyat = new JTextField();
		txtFiyat.setColumns(10);
		txtFiyat.setBounds(84, 73, 163, 20);
		getContentPane().add(txtFiyat);
		setTitle("Dershane Uygulamasý ");

		JMenuBar menuBarKullaniciIslem = new JMenuBar();
		setJMenuBar(menuBarKullaniciIslem);

		JMenu menuKullaniciIslem = new JMenu("Yeni");
		menuBarKullaniciIslem.add(menuKullaniciIslem);

		JMenuItem menuItemKEkle = new JMenuItem("Kullan\u0131c\u0131 Ekle");
		menuItemKEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddInventory frm = new AddInventory();
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
		InventoryDAO ýnventorydao = new InventoryDAO();
		List<Inventory> liste = ýnventorydao.getAllRows(new Inventory());
		String[][] data = new String[liste.size()][5];
		String[] columns = { "Id", "Taným", "Garanti Süresi", "Kullaným Yeri", "Fiyat",  };
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = String.valueOf(liste.get(i).getId());
			data[i][1] = liste.get(i).getTanim();
			data[i][2] = liste.get(i).getGaranti().toString();
			data[i][3] = liste.get(i).getKullaným();
			data[i][4] = liste.get(i).getExpenses();
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
	private JTextField getTxtkullanýmyeri() {
		if (txtkullanýmyeri == null) {
			txtkullanýmyeri = new JTextField();
			txtkullanýmyeri.setColumns(10);
			txtkullanýmyeri.setBounds(401, 73, 163, 20);
		}
		return txtkullanýmyeri;
	}
	private JLabel getLblKullanm() {
		if (lblKullanm == null) {
			lblKullanm = new JLabel("Kullan\u0131m yeri");
			lblKullanm.setFont(new Font("Arial", Font.BOLD, 12));
			lblKullanm.setBounds(285, 76, 106, 14);
		}
		return lblKullanm;
	}
}
