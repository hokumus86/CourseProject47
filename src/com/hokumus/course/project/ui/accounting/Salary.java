package com.hokumus.course.project.ui.accounting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import com.hokumus.course.project.models.management.Groups;
import com.hokumus.course.project.models.teacher.Teacher;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Salary extends JFrame {
	private JDateChooser tarih2;
	private JTable tablemaas;
	private JLabel lblogtmnmaasgir;
	private JTextField txtogrtmnmaasgir;
	private JButton btnGuncelle;
	private JLabel lblprsnlmaasgir;
	private JTextField txtprsnlmaasgir;
	
	public Salary () {
		
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
		
		JComboBox comboBoxogrtmnsec = new JComboBox();
		comboBoxogrtmnsec.setBounds(10, 30, 147, 31);
		getContentPane().add(comboBoxogrtmnsec);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
												
			}
		});
		btnKaydet.setBounds(359, 61, 115, 23);
		getContentPane().add(btnKaydet);
		
		JScrollPane scrlpnmaastablo = new JScrollPane();
		scrlpnmaastablo.setBounds(10, 129, 464, 321);
		getContentPane().add(scrlpnmaastablo);
		scrlpnmaastablo.setLayout(null);
		scrlpnmaastablo.setViewportView(getTablemaas());
		
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
		
		maastablogoster();
		
	}
	DefaultTableModel model=new DefaultTableModel();
	private void maastablogoster() {
	
		DbServicessBase<Teacher> dao=new DbServicessBase<Teacher>(); 
		Teacher temp = new Teacher();
		
		
		List<Teacher> ogrtmn_listesi=dao.getAllRows(temp);
		
		
		String [] columnNames= {"ID", "ÖÐRETMEN", "ÖÐRT_MAAÞ", "PERSONEL", "PERSNL_MAAÞ", "TARÝH"};
		Object [][] data=new Object [ogrtmn_listesi.size()][columnNames.length];
		
		
		
			
			
			
			
		
	}

	private JTable getTablemaas() {
		if (tablemaas == null) {
			tablemaas = new JTable();
			tablemaas.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "ÖÐRETMEN", "ÖÐRT_MAAÞ", "PERSONEL", "PERSNL_MAAÞ", "TARÝH"
				}
			));
		}
		return tablemaas;
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
			btnGuncelle = new JButton("G\u00FCncelle");
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
}
