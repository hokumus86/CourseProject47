package com.hokumus.course.project.ui.accounting;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.project.models.accounting.Incomings;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class IncomeScreen extends JFrame {
	private JTable table;
	private JTextField txtId;
	private JTextField txtUcret;
	private JTextField txtTanim;
	private JTextField txtTarih;
	DbServicessBase<Incomings> dao = new DbServicessBase<Incomings>();
	Incomings temp = new Incomings();

	public IncomeScreen() {
		getContentPane().setLayout(null);
		setBounds(200, 200, 600, 500);
		JScrollPane scrollPanekizarik = new JScrollPane();
		scrollPanekizarik.setBounds(10, 11, 435, 248);
		getContentPane().add(scrollPanekizarik);
		scrollPanekizarik.setViewportView(getTable_1());
		
		JButton btnYeniGelirEkle = new JButton("Yeni Gelir Ekle");
		btnYeniGelirEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp.setMiktar(Integer.parseInt(txtUcret.getText()));
				temp.setTanim(txtTanim.getText());
				temp.setTarih(txtTarih.getText());
				dao.save(temp);
				
			}
		});
		btnYeniGelirEkle.setBounds(455, 14, 119, 53);
		getContentPane().add(btnYeniGelirEkle);
		
		JButton btnGelirSil = new JButton("Varolan Geliri Sil");
		btnGelirSil.setBounds(455, 78, 119, 53);
		getContentPane().add(btnGelirSil);
		
		JButton btnGelirGuncelle = new JButton("Gelir G\u00FCncelleme");
		btnGelirGuncelle.setBounds(455, 142, 119, 53);
		getContentPane().add(btnGelirGuncelle);
		
		JButton btnCikis = new JButton("\u0130ptal");
		btnCikis.setBounds(455, 206, 119, 53);
		getContentPane().add(btnCikis);
		
		txtId = new JTextField();
		txtId.setText("Otomatik Verilecektir");
		txtId.setEditable(false);
		txtId.setBounds(10, 310, 156, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtUcret = new JTextField();
		txtUcret.setColumns(10);
		txtUcret.setBounds(176, 310, 156, 20);
		getContentPane().add(txtUcret);
		
		txtTanim = new JTextField();
		txtTanim.setColumns(10);
		txtTanim.setBounds(10, 369, 156, 20);
		getContentPane().add(txtTanim);
		
		txtTarih = new JTextField();
		txtTarih.setColumns(10);
		txtTarih.setBounds(176, 369, 156, 20);
		getContentPane().add(txtTarih);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 285, 48, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblcretinMiktar = new JLabel("\u00DCcretin Miktar\u0131");
		lblcretinMiktar.setBounds(176, 285, 136, 14);
		getContentPane().add(lblcretinMiktar);
		
		JLabel lblTanm = new JLabel("Tan\u0131m");
		lblTanm.setBounds(10, 344, 136, 14);
		getContentPane().add(lblTanm);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setBounds(176, 344, 136, 14);
		getContentPane().add(lblTarih);

	}

	private JTable getTable_1() {
			table = new JTable();
			table.setModel(new DefaultTableModel(new Object[][] {}, 
					new String[] { "ID", "Ücretin Miktarý", "Taným", "Tarih" }) {
			});

			

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] { temp.getId(), temp.getMiktar(), temp.getTanim(), temp.getTarih() });

			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
		return table;

	}
}
