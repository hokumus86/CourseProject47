package com.hokumus.course.project.ui.student;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import javax.swing.JButton;

import com.hokumus.course.project.models.accounting.Expenses;
import com.hokumus.course.project.models.inventory.Inventory;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.InventoryDAO;
import com.toedter.calendar.JDateChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
 
@SuppressWarnings("serial")
public class AddInventory extends JFrame {

	private JLabel lblTanim;  
	private JTextField txtTanim;
	private JDateChooser dateBaslamaTrh;
	private JLabel lblBaslang�cTarihi;
	private JLabel lblAdres;
	private JTextField txtAdres;
	private JButton btnKayit;
	private JButton btnIptal;
	private JLabel lblMesaj;
	private JLabel lblGarantiBitisi;
	private JDateChooser dateBitisTrh;
	private JLabel lblExpenses;
	private JTextField txtExpenses;
	private Long selectedItemId;
	private JMenuBar menuBar;
	private JMenu mnKullaniciG�ncelle;
	private JMenuItem mn�tmKullancGncelle;
	

	public AddInventory() {
		
		initialize();
	}

	private void initialize() {
		
		setTitle("KAYIT " + CourseUtils.loginedUser.getUserName() + " - " + CourseUtils.loginedUser.getRole());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 360);
		setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		getContentPane().add(getLblTanim());
		getContentPane().add(getTxtTanim());
		getContentPane().add(getDateBaslamaTrh());
		getContentPane().add(getLblBaslang�cTarihi());
		getContentPane().add(getLblAdres());
		getContentPane().add(getTxtAdres());
		getContentPane().add(getBtnKayit());
		getContentPane().add(getBtnIptal());
		getContentPane().add(getLblMesaj());
		getContentPane().add(getLblGarantiBitisi());
		getContentPane().add(getDateBitisTrh());
		getContentPane().add(getLblExpenses());
		getContentPane().add(getTxtExpenses());
		getContentPane().add(getMenuBar_1());
		
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
	private JDateChooser getDateBaslamaTrh() {
		if (dateBaslamaTrh == null) {
			dateBaslamaTrh = new JDateChooser();
					dateBaslamaTrh.setDateFormatString("dd/MM/yyyy");
					dateBaslamaTrh.addPropertyChangeListener(new PropertyChangeListener() {
						public void propertyChange(PropertyChangeEvent evt) {
							if (dateBaslamaTrh.getDate() != null) {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								String gun = sdf.format(dateBaslamaTrh.getDate());
							}
						}
					});
					dateBaslamaTrh.addInputMethodListener(new InputMethodListener() {
						public void caretPositionChanged(InputMethodEvent event) {
						}
						public void inputMethodTextChanged(InputMethodEvent event) {
							dateBaslamaTrh.setDateFormatString("dd/MM/yyyy");
						}
					});
			dateBaslamaTrh.setBounds(470, 55, 130, 20);
		}
		return dateBaslamaTrh;
	}
	private JLabel getLblBaslang�cTarihi() {
		if (lblBaslang�cTarihi == null) {
			lblBaslang�cTarihi = new JLabel("Garanti Ba\u015Flang\u0131c\u0131:");
			lblBaslang�cTarihi.setFont(new Font("Arial", Font.BOLD, 12));
			lblBaslang�cTarihi.setBounds(329, 61, 108, 14);
		}
		return lblBaslang�cTarihi;
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
					Inventory inventory = new Inventory();
					inventory.setId(selectedItemId);
					inventory.setTanim(txtTanim.getText());
				    inventory.setExpenses(new Expenses()); 
					if (Inventorydao.save(inventory)) {
						lblMesaj.setText("Ba�ar�l�..!");
					} else
						lblMesaj.setText("Ba�ar�s�z..!");
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
	private JDateChooser getDateBitisTrh() {
		if (dateBitisTrh == null) {
			dateBitisTrh = new JDateChooser();
			dateBitisTrh.setDateFormatString("dd/MM/yyyy");
			dateBitisTrh.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					if (dateBitisTrh.getDate() != null) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String gun = sdf.format(dateBitisTrh.getDate());
					}
				}
			});
			dateBaslamaTrh.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}
				public void inputMethodTextChanged(InputMethodEvent event) {
					dateBitisTrh.setDateFormatString("dd/MM/yyyy");
				}
			});
			dateBitisTrh.setBounds(470, 129, 130, 20);
		}
		return dateBitisTrh;
	}
	private JLabel getLblExpenses() {
		if (lblExpenses == null) {
			lblExpenses = new JLabel("Fiyat:");
			lblExpenses.setFont(new Font("Arial", Font.BOLD, 12));
			lblExpenses.setBounds(40, 190, 67, 14);
		}
		return lblExpenses;
	}
	private JTextField getTxtExpenses() {
		if (txtExpenses == null) {
			txtExpenses = new JTextField();
			txtExpenses.setColumns(10);
			txtExpenses.setBounds(137, 187, 158, 20);
		}
		return txtExpenses;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 639, 22);
			menuBar.add(getMnKullaniciG�ncelle());
		}
		return menuBar;
	}
	private JMenu getMnKullaniciG�ncelle() {
		if (mnKullaniciG�ncelle == null) {
			mnKullaniciG�ncelle = new JMenu("Yeni");
			mnKullaniciG�ncelle.add(getMn�tmKullancGncelle());
		}
		return mnKullaniciG�ncelle;
	}
	private JMenuItem getMn�tmKullancGncelle() {
		if (mn�tmKullancGncelle == null) {
			mn�tmKullancGncelle = new JMenuItem("Kullan\u0131c\u0131 G\u00FCncelle");
			mn�tmKullancGncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ActionInventory actionInventory=new ActionInventory();
					actionInventory.setVisible(true);
					dispose();
				}
			});
		}
		return mn�tmKullancGncelle;
	}
}
