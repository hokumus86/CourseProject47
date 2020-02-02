package com.hokumus.course.project.ui.student;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import com.hokumus.course.project.models.inventory.IronHead;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.IronHeadDAO;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class AddIronHead extends JFrame {
  

	private JLabel lblTanim; 
	private JTextField txtTanim;
	private JDateChooser dateZimmetTarihi;
	private JLabel lblZimmetTarih;
	private JLabel lblSüre;
	private JTextField txtSüre;
	private JButton btnKayit;
	private JButton btnIptal;
	private JLabel lblMesaj;
	private JLabel lblPersonel;
	private JTextField txtPersonel;
	private Long selectedItemId;
	

	public AddIronHead() {
		
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
		getContentPane().add(getDateZimmetTarihi());
		getContentPane().add(getLblZimmetTarih());
		getContentPane().add(getLblSüre());
		getContentPane().add(getTxtSüre());
		getContentPane().add(getBtnKayit());
		getContentPane().add(getBtnIptal());
		getContentPane().add(getLblMesaj());
		getContentPane().add(getLblPersonel());
		getContentPane().add(getTxtPersonel());
		
		
		

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
			txtTanim.setBounds(137, 55, 158, 20);
		}
		return txtTanim;
	}
	private JDateChooser getDateZimmetTarihi() {
		if (dateZimmetTarihi == null) {
			dateZimmetTarihi = new JDateChooser();
					dateZimmetTarihi.setDateFormatString("dd/MM/yyyy");
					dateZimmetTarihi.addPropertyChangeListener(new PropertyChangeListener() {
						public void propertyChange(PropertyChangeEvent evt) {
							if (dateZimmetTarihi.getDate() != null) {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

								String gun = sdf.format(dateZimmetTarihi.getDate());
								JOptionPane.showMessageDialog(AddIronHead.this, gun);

							}

						}
					});
					dateZimmetTarihi.addInputMethodListener(new InputMethodListener() {
						public void caretPositionChanged(InputMethodEvent event) {
						}

						public void inputMethodTextChanged(InputMethodEvent event) {
							dateZimmetTarihi.setDateFormatString("dd/MM/yyyy");
							JOptionPane.showMessageDialog(AddIronHead.this, dateZimmetTarihi.getDateFormatString());
						}
					});
			dateZimmetTarihi.setBounds(447, 55, 153, 20);
		}
		return dateZimmetTarihi;
	}
	private JLabel getLblZimmetTarih() {
		if (lblZimmetTarih == null) {
			lblZimmetTarih = new JLabel("Zimmet Tarihi");
			lblZimmetTarih.setFont(new Font("Arial", Font.BOLD, 12));
			lblZimmetTarih.setBounds(329, 61, 108, 14);
		}
		return lblZimmetTarih;
	}
	private JLabel getLblSüre() {
		if (lblSüre == null) {
			lblSüre = new JLabel("S\u00FCre");
			lblSüre.setFont(new Font("Arial", Font.BOLD, 12));
			lblSüre.setBounds(40, 129, 94, 14);
		}
		return lblSüre;
	}
	private JTextField getTxtSüre() {
		if (txtSüre == null) {
			txtSüre = new JTextField();
			txtSüre.setColumns(10);
			txtSüre.setBounds(137, 126, 158, 20);
		}
		return txtSüre;
	}
	private JButton getBtnKayit() {
		if (btnKayit == null) {
			btnKayit = new JButton("Kaydet");
			btnKayit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IronHeadDAO ýronheaddao = new IronHeadDAO();
					IronHead ýronhead = new IronHead();
					ýronhead.setId(selectedItemId);
					ýronhead.setAciklama(txtTanim.getText());
				    ýronhead.setZaman(new BigDecimal(txtSüre.getText()));
				    ýronhead.setTeacher(txtPersonel.getText());
				    
					if (ýronheaddao.save(ýronhead)) {
						lblMesaj.setText("Baþarýlý..!");
						
					} else
						lblMesaj.setText("Baþarýsýz..!");
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
					AddIronHead.this.dispose();
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
	private JLabel getLblPersonel() {
		if (lblPersonel == null) {
			lblPersonel = new JLabel("Personel");
			lblPersonel.setFont(new Font("Arial", Font.BOLD, 12));
			lblPersonel.setBounds(329, 126, 67, 14);
		}
		return lblPersonel;
	}
	private JTextField getTxtPersonel() {
		if (txtPersonel == null) {
			txtPersonel = new JTextField();
			txtPersonel.setColumns(10);
			txtPersonel.setBounds(447, 126, 153, 20);
		}
		return txtPersonel;
	}
}
