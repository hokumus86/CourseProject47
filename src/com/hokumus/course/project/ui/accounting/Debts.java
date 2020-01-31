package com.hokumus.course.project.ui.accounting;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.hokumus.course.project.models.accounting.Debt;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.toedter.calendar.JDateChooser;

public class Debts extends JFrame {
	private JTextField txtisim;
	private JTextField txtsoyad;
	private JTextField txtalinan;
	private JTextField txtkalan;
	private JDateChooser tarih1;
	
	public Debts() {
		
		initialize();
		
	}

	private void initialize() {
	
		setTitle("BOR\u00C7LAR");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().setLayout(null);
		
		JLabel lblIsim = new JLabel("\u0130sim");
		lblIsim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIsim.setBounds(23, 59, 60, 14);
		getContentPane().add(lblIsim);
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setBounds(23, 105, 60, 14);
		getContentPane().add(lblSoyad);
		
		JLabel lblAlinan = new JLabel("Al\u0131nan");
		lblAlinan.setBounds(269, 60, 60, 14);
		getContentPane().add(lblAlinan);
		
		JLabel lblKalan = new JLabel("Kalan");
		lblKalan.setBounds(269, 105, 46, 14);
		getContentPane().add(lblKalan);
		
		JLabel lblTarih1 = new JLabel("Tarih");
		lblTarih1.setBounds(23, 155, 46, 14);
		getContentPane().add(lblTarih1);
		
		txtisim = new JTextField();
		txtisim.setBounds(70, 57, 137, 20);
		getContentPane().add(txtisim);
		txtisim.setColumns(10);
		
		txtsoyad = new JTextField();
		txtsoyad.setBounds(70, 102, 137, 20);
		getContentPane().add(txtsoyad);
		txtsoyad.setColumns(10);
		
		txtalinan = new JTextField();
		txtalinan.setBounds(339, 53, 137, 20);
		getContentPane().add(txtalinan);
		txtalinan.setColumns(10);
		
		txtkalan = new JTextField();
		txtkalan.setBounds(339, 102, 137, 20);
		getContentPane().add(txtkalan);
		txtkalan.setColumns(10);
		
		
		tarih1 = new JDateChooser();
		tarih1.setBounds(70, 149, 137, 20);
		getContentPane().add(tarih1);
		
		
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DbServicessBase<Debt> dao=new DbServicessBase<Debt>();
				Debt kaydet=new Debt();
			
				kaydet.setAd(txtisim.getText());
				kaydet.setSoyad(txtsoyad.getText());
				kaydet.setAlinan(new BigDecimal(txtalinan.getText()));
				kaydet.setKalan(new BigDecimal(txtkalan.getText()));
				kaydet.setTarih1(tarih1.getDate());
				
				if (dao.save(kaydet)) {
					JOptionPane.showMessageDialog(Debts.this, "Kaydetme Ba�ar�l�");
				}
				else {
					JOptionPane.showMessageDialog(Debts.this, "Kaydetme Ba�ar�s�z");
				}
			}
		});
		btnKaydet.setBounds(70, 222, 85, 23);
		getContentPane().add(btnKaydet);
		
		JButton btntemizle = new JButton("Temizle");
		btntemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtisim.setText("");
				txtsoyad.setText("");
				txtalinan.setText("");
				txtkalan.setText("");
			}
		});
		btntemizle.setBounds(279, 222, 85, 23);
		getContentPane().add(btntemizle);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Debts.this.dispose();
			}
		});
		btnIptal.setBounds(70, 324, 85, 23);
		getContentPane().add(btnIptal);
		
		
		
		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DbServicessBase<Debt> dao=new DbServicessBase<Debt>();
				Debt guncelle=new Debt();
				
				guncelle.setAd(txtisim.getText());
				guncelle.setSoyad(txtsoyad.getText());
				guncelle.setAlinan(new BigDecimal(txtalinan.getText()));
				guncelle.setKalan(new BigDecimal(txtkalan.getText()));
				
				if (dao.update(guncelle)) {
					JOptionPane.showMessageDialog(Debts.this, "Ba�ar�yla G�ncellendi");
				}
				else {
					JOptionPane.showMessageDialog(Debts.this, "G�ncelleme Ba�ar�z");
				}
			}
		});
		btnGuncelle.setBounds(279, 324, 85, 23);
		getContentPane().add(btnGuncelle);
		
		
		
	}
	
	
}
