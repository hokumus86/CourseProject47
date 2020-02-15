package com.hokumus.course.project.ui.accounting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.project.models.accounting.Salarys;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.hokumus.course.project.utils.dao.SalaryDAO;
import com.toedter.calendar.JDateChooser;

public class Salary extends JFrame {
	private JDateChooser tarih2;
	private JLabel lblogtmnmaasgir;
	private JTextField txtogrtmnmaasgir;
	private JButton btnGuncelle;
	private JLabel lblprsnlmaasgir;
	private JTextField txtprsnlmaasgir;
	private Long selecteditemid;

	public Salary() {

		initialize();

	}

	private void initialize() {
		setTitle("MAAÞ");
		setBounds(300, 300, 500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblogrtmnsec = new JLabel("\u00D6\u011Fretmen Se\u00E7iniz.");
		lblogrtmnsec.setBounds(20, 0, 154, 39);
		getContentPane().add(lblogrtmnsec);

		JLabel lblpersonelsec = new JLabel("Personel Se\u00E7iniz.");
		lblpersonelsec.setBounds(198, 0, 154, 39);
		getContentPane().add(lblpersonelsec);

		JComboBox comboBoxpersonelsec = new JComboBox();
		comboBoxpersonelsec.setBounds(187, 30, 147, 31);
		getContentPane().add(comboBoxpersonelsec);
		comboBoxpersonelsec.setModel(new DefaultComboBoxModel(new String[] {"murat", "hakan","cengiz","hasan"}));

		JComboBox comboBoxogrtmnsec = new JComboBox();
		comboBoxogrtmnsec.setBounds(10, 30, 147, 31);
		getContentPane().add(comboBoxogrtmnsec);
		comboBoxogrtmnsec.setModel(new DefaultComboBoxModel(new String[] {"ahmet", "mehmet","ali","veli"}));

		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DbServicessBase<Salarys> saldao = new DbServicessBase<Salarys>();
				Salarys kaydet = new Salarys();
				
				kaydet.setOgretmen(comboBoxogrtmnsec.getSelectedItem().toString());
				kaydet.setOgretmen_maas(new BigDecimal(txtogrtmnmaasgir.getText().toString()));
				kaydet.setPersonel(comboBoxpersonelsec.getSelectedItem().toString());
				kaydet.setPersonel_maas(new BigDecimal(txtprsnlmaasgir.getText().toString()));
				kaydet.setTarih2(tarih2.getDate());
				
				if (saldao.save(kaydet)) {
					JOptionPane.showMessageDialog(Salary.this, "Kayýt Baþarýlý");
					maastablogoster();
				}
				else {
					JOptionPane.showMessageDialog(Salary.this, "Kayýt Baþarýsýz");
				}		

			}
		});
		btnKaydet.setBounds(359, 61, 115, 23);
		getContentPane().add(btnKaydet);

		tarih2 = new JDateChooser();
		tarih2.setBounds(344, 30, 130, 20);
		getContentPane().add(tarih2);

		JLabel lblTarih2 = new JLabel("Tarih");
		lblTarih2.setBounds(390, 12, 46, 14);
		getContentPane().add(lblTarih2);
		getContentPane().add(getLblogtmnmaasgir());
		getContentPane().add(getTxtogrtmnmaasgir());
		getContentPane().add(getBtnGuncelle());
		getContentPane().add(getLblprsnlmaasgir());
		getContentPane().add(getTxtprsnlmaasgir());
		getContentPane().add(getScrollPane());

		maastablogoster();

	}

	

	DefaultTableModel model = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JTable table;

	private void maastablogoster() {

		SalaryDAO saldao = new SalaryDAO();
		List<Salarys> liste = saldao.getAllRows(new Salarys());
		
		String[][] data = new String[liste.size()][6];
		String[] columns = { "ID", "ÖÐRETMEN", "ÖÐRT_MAAÞ", "PERSONEL", "PRSNL_MAAÞ", "TARÝH" };
	
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = String.valueOf(liste.get(i).getId());
			data[i][1] = liste.get(i).getOgretmen().toString();
			data[i][2] = liste.get(i).getOgretmen_maas().toString();
			data[i][3] = liste.get(i).getPersonel().toString();
			data[i][4] = liste.get(i).getPersonel_maas().toString();
			data[i][5] = liste.get(i).getTarih2().toString();
		}
		DefaultTableModel model = new DefaultTableModel(data, columns);
		table.setModel(model);

	}

	private JLabel getLblogtmnmaasgir() {
		if (lblogtmnmaasgir == null) {
			lblogtmnmaasgir = new JLabel("Maa\u015F Giriniz");
			lblogtmnmaasgir.setBounds(10, 72, 76, 14);
		}
		return lblogtmnmaasgir;
	}

	private JTextField getTxtogrtmnmaasgir() {
		if (txtogrtmnmaasgir == null) {
			txtogrtmnmaasgir = new JTextField();
			txtogrtmnmaasgir.setBounds(10, 87, 147, 20);
			txtogrtmnmaasgir.setColumns(10);
		}
		return txtogrtmnmaasgir;
	}

	private JButton getBtnGuncelle() {
		if (btnGuncelle == null) {
			btnGuncelle = new JButton("\u0130ptal");
			btnGuncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Salary.this.dispose();
				}
			});
			btnGuncelle.setBounds(359, 95, 115, 23);
		}
		return btnGuncelle;
	}

	private JLabel getLblprsnlmaasgir() {
		if (lblprsnlmaasgir == null) {
			lblprsnlmaasgir = new JLabel("Maa\u015F Griniz");
			lblprsnlmaasgir.setBounds(187, 73, 147, 14);
		}
		return lblprsnlmaasgir;
	}

	private JTextField getTxtprsnlmaasgir() {
		if (txtprsnlmaasgir == null) {
			txtprsnlmaasgir = new JTextField();
			txtprsnlmaasgir.setBounds(184, 87, 150, 20);
			txtprsnlmaasgir.setColumns(10);
		}
		return txtprsnlmaasgir;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 146, 464, 304);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
}
