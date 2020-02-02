package com.hokumus.course.project.ui.student;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.hokumus.course.project.models.inventory.IronHead;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.IronHeadDAO;
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
import java.math.BigDecimal;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class ActionIronHead extends JFrame {
	
	
	private JTable table; 
	private JTextField txtTanim;
	private Long selectedItemId;
	private JLabel lblMesaj;
	private JTextField txtpersonel;
	private JLabel lblPersonel;
	private JTextField txtSüre;
	private JDateChooser dateZimmetTarihi;
	private JLabel label;

	public ActionIronHead() {
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
			    txtSüre.setText(table.getValueAt(row, 2).toString());
			    txtpersonel.setText(table.getValueAt(row, 3).toString());
			}
		});
		scrollPane.setViewportView(table);
		tabloDoldur();

		JButton btnKullaniciGetir = new JButton("KAYITLI VER\u0130LER");
		btnKullaniciGetir.setBounds(10, 352, 572, 23);
		btnKullaniciGetir.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(btnKullaniciGetir);

		JLabel lblSüre = new JLabel("S\u00FCre");
		lblSüre.setFont(new Font("Arial", Font.BOLD, 12));
		lblSüre.setBounds(10, 76, 78, 14);
		getContentPane().add(lblSüre);

		JLabel lblTanim = new JLabel("Tan\u0131m");
		lblTanim.setFont(new Font("Arial", Font.BOLD, 12));
		lblTanim.setBounds(10, 24, 78, 14);
		getContentPane().add(lblTanim);

		txtTanim = new JTextField();
		txtTanim.setBounds(84, 21, 163, 20);
		txtTanim.setColumns(10);
		getContentPane().add(txtTanim);

		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.setBounds(454, 112, 110, 23);
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IronHeadDAO ýronheaddao = new IronHeadDAO();
				IronHead ýronhead = new IronHead();
				ýronhead.setId(selectedItemId);
				ýronhead.setAciklama(txtTanim.getText());
				ýronhead.setTeacher(txtpersonel.getText());
				ýronhead.setZaman(new BigDecimal(txtSüre.getText()));
			    if (ýronheaddao.update(ýronhead)) {
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
				IronHeadDAO ýronheaddao = new IronHeadDAO();
				IronHead ýronhead = new IronHead();
				ýronhead.setId(selectedItemId);
				ýronhead.setAciklama(txtTanim.getText());
				ýronhead.setTeacher(txtpersonel.getText());
				ýronhead.setZaman(new BigDecimal(txtSüre.getText()));
				if (ýronheaddao.delete(ýronhead)) {
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
		getContentPane().add(getTxtpersonel());
		getContentPane().add(getLblPersonel());
		
		txtSüre = new JTextField();
		txtSüre.setColumns(10);
		txtSüre.setBounds(84, 73, 163, 20);
		getContentPane().add(txtSüre);
		getContentPane().add(getDateZimmetTarihi());
		getContentPane().add(getLabel());
		setTitle("Dershane Uygulamasý ");

		JMenuBar menuBarKullaniciIslem = new JMenuBar();
		setJMenuBar(menuBarKullaniciIslem);

		JMenu menuKullaniciIslem = new JMenu("Yeni");
		menuBarKullaniciIslem.add(menuKullaniciIslem);

		JMenuItem menuItemKEkle = new JMenuItem("Kullan\u0131c\u0131 Ekle");
		menuItemKEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddIronHead frm = new AddIronHead();
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
		IronHeadDAO ýnventorydao = new IronHeadDAO();
		List<IronHead> liste = ýnventorydao.getAllRows(new IronHead());
		String[][] data = new String[liste.size()][4];
		String[] columns = { "Id", "Açýklama", "Personel", "Süresi",  };
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = String.valueOf(liste.get(i).getId());
			data[i][1] = liste.get(i).getAciklama();
			data[i][2] = liste.get(i).getTeacher();
			data[i][3] = liste.get(i).getZaman().toString();
			
			
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
	private JTextField getTxtpersonel() {
		if (txtpersonel == null) {
			txtpersonel = new JTextField();
			txtpersonel.setColumns(10);
			txtpersonel.setBounds(401, 73, 153, 20);
		}
		return txtpersonel;
	}
	private JLabel getLblPersonel() {
		if (lblPersonel == null) {
			lblPersonel = new JLabel("Personel");
			lblPersonel.setFont(new Font("Arial", Font.BOLD, 12));
			lblPersonel.setBounds(285, 76, 106, 14);
		}
		return lblPersonel;
	}
	private JDateChooser getDateZimmetTarihi() {
		if (dateZimmetTarihi == null) {
			dateZimmetTarihi = new JDateChooser();
			dateZimmetTarihi.setBounds(403, 21, 153, 20);
		}
		return dateZimmetTarihi;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Zimmet Tarihi");
			label.setFont(new Font("Arial", Font.BOLD, 12));
			label.setBounds(285, 27, 108, 14);
		}
		return label;
	}
}
