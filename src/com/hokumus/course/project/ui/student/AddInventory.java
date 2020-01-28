package com.hokumus.course.project.ui.student;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JButton;
import com.hokumus.course.project.models.inventory.Inventory;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.InventoryDAO;
import com.toedter.calendar.JDateChooser;

public class AddInventory extends JFrame {

	private JLabel lblTanim;
	private JTextField txtTanim;
	private JDateChooser dateBaslangıc;
	private JLabel lblBaslangıcTarihi;
	private JLabel lblAdres;
	private JTextField txtAdres;
	private JButton btnKayit;
	private JButton btnIptal;
	private JLabel lblMesaj;
	private JLabel lblGarantiBitisi;
	private JDateChooser dateBitis;
	private JLabel lblFiyat;
	private JTextField txtExpenses;
	private Long selectedItemId;
	

	public AddInventory() {
		
		initialize();
	}

	private void initialize() {
		
		setTitle("KAYIT " + CourseUtils.loginedUser.getUserName() + " - " + CourseUtils.loginedUser.getRole());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 655, 359);
		setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		getContentPane().add(getLblTanim());
		getContentPane().add(getTxtTanim());
		getContentPane().add(getDateBaslangıc());
		getContentPane().add(getLblBaslangıcTarihi());
		getContentPane().add(getLblAdres());
		getContentPane().add(getTxtAdres());
		getContentPane().add(getBtnKayit());
		getContentPane().add(getBtnIptal());
		getContentPane().add(getLblMesaj());
		getContentPane().add(getLblGarantiBitisi());
		getContentPane().add(getDateBitis());
		getContentPane().add(getLblFiyat());
		getContentPane().add(getTxtExpenses());
		
		
		

	}
	private JLabel getLblTanim() {
		if (lblTanim == null) {
			lblTanim = new JLabel("Tan\u0131m:");
			lblTanim.setFont(new Font("Arial", Font.BOLD, 12));
			lblTanim.setBounds(40, 61, 67, 14);
		}
		return lblTanim;
	}
	private JTextField getTxtTanim() {
		if (txtTanim == null) {
			txtTanim = new JTextField();
			txtTanim.setColumns(10);
			txtTanim.setBounds(137, 55, 158, 27);
		}
		return txtTanim;
	}
	private JDateChooser getDateBaslangıc() {
		if (dateBaslangıc == null) {
			dateBaslangıc = new JDateChooser();
			dateBaslangıc.setBounds(470, 55, 130, 20);
		}
		return dateBaslangıc;
	}
	private JLabel getLblBaslangıcTarihi() {
		if (lblBaslangıcTarihi == null) {
			lblBaslangıcTarihi = new JLabel("Garanti Ba\u015Flang\u0131c\u0131:");
			lblBaslangıcTarihi.setFont(new Font("Arial", Font.BOLD, 12));
			lblBaslangıcTarihi.setBounds(329, 61, 108, 14);
		}
		return lblBaslangıcTarihi;
	}
	private JLabel getLblAdres() {
		if (lblAdres == null) {
			lblAdres = new JLabel("Garanti S\u00FCresi:");
			lblAdres.setFont(new Font("Arial", Font.BOLD, 12));
			lblAdres.setBounds(40, 129, 94, 14);
		}
		return lblAdres;
	}
	private JTextField getTxtAdres() {
		if (txtAdres == null) {
			txtAdres = new JTextField();
			txtAdres.setColumns(10);
			txtAdres.setBounds(137, 126, 158, 20);
		}
		return txtAdres;
	}
	private JButton getBtnKayit() {
		if (btnKayit == null) {
			btnKayit = new JButton("Kaydet");
			btnKayit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InventoryDAO Inventorydao = new InventoryDAO();
					Inventory ınventory = new Inventory();
					ınventory.setId(selectedItemId);
					ınventory.setTanim(txtTanim.getText());
				    ınventory.setFiyat(new BigDecimal(txtExpenses.getText()));
				    
					if (Inventorydao.save(ınventory)) {
						lblMesaj.setText("Başarılı..!");
						
					} else
						lblMesaj.setText("Başarısız..!");
				}
			});
			btnKayit.setFont(new Font("Arial", Font.BOLD, 12));
			btnKayit.setBounds(480, 240, 129, 23);
		}
		return btnKayit;
	}
	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddInventory.this.dispose();
				}
			});
			btnIptal.setFont(new Font("Arial", Font.BOLD, 12));
			btnIptal.setBounds(322, 240, 115, 23);
		}
		return btnIptal;
	}
	private JLabel getLblMesaj() {
		if (lblMesaj == null) {
			lblMesaj = new JLabel("");
			lblMesaj.setBounds(13, 286, 616, 23);
		}
		return lblMesaj;
	}
	private JLabel getLblGarantiBitisi() {
		if (lblGarantiBitisi == null) {
			lblGarantiBitisi = new JLabel("Garanti Biti\u015Fi:");
			lblGarantiBitisi.setFont(new Font("Arial", Font.BOLD, 12));
			lblGarantiBitisi.setBounds(329, 129, 108, 14);
		}
		return lblGarantiBitisi;
	}
	private JDateChooser getDateBitis() {
		if (dateBitis == null) {
			dateBitis = new JDateChooser();
			dateBitis.setBounds(470, 129, 130, 20);
		}
		return dateBitis;
	}
	private JLabel getLblFiyat() {
		if (lblFiyat == null) {
			lblFiyat = new JLabel("Fiyat:");
			lblFiyat.setFont(new Font("Arial", Font.BOLD, 12));
			lblFiyat.setBounds(40, 190, 67, 14);
		}
		return lblFiyat;
	}
	private JTextField getTxtExpenses() {
		if (txtExpenses == null) {
			txtExpenses = new JTextField();
			txtExpenses.setColumns(10);
			txtExpenses.setBounds(137, 187, 158, 20);
		}
		return txtExpenses;
	}
}
