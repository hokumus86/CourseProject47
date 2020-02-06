package com.hokumus.course.project.ui.accounting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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

import com.hokumus.course.project.models.accounting.IncomeType;
import com.hokumus.course.project.models.accounting.Incomings;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.hokumus.course.project.utils.dao.IncomingsDAO;
import com.toedter.calendar.JDateChooser;

public class IncomeScreen extends JFrame {
	private JTable table;
	private JTextField txtId;
	private JTextField txtUcret;
	private JDateChooser dateChooser;
	private JComboBox comboBox;
	private Long secilenId;
	
	DbServicessBase<Incomings> dao = new DbServicessBase<Incomings>();
	Incomings temp = new Incomings();
	
	DbServicessBase<IncomeType> dao1 = new DbServicessBase<IncomeType>();
	public IncomeScreen() {
		setTitle("Muhasebe Gelir Ekraný");
		getContentPane().setLayout(null);
		setBounds(200, 200, 600, 500);
		JScrollPane scrollPanekizarik = new JScrollPane();
		scrollPanekizarik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUcret.setText(CourseUtils.getValue(table.getValueAt(table.getSelectedRow(), 1)));
			}
		});
		scrollPanekizarik.setBounds(10, 11, 435, 248);
		getContentPane().add(scrollPanekizarik);
		scrollPanekizarik.setViewportView(getTable_1());
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 367, 136, 22);
		getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"OGRENCI_ODEME", "FIRMA_ODEME"}));
		
		
		JButton btnYeniGelirEkle = new JButton("Yeni Gelir Ekle");
		btnYeniGelirEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp.setMiktar(new BigDecimal(Integer.parseInt(txtUcret.getText())));
				temp.setTanim(comboBox.getSelectedItem().toString());
				temp.setTarih(getDate().getDate());
				dao.save(temp);
				Doldur();
				
			}
		});
		btnYeniGelirEkle.setBounds(455, 14, 119, 53);
		getContentPane().add(btnYeniGelirEkle);
		
		JButton btnGetir = new JButton("Getir");
		btnGetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doldur();
			}
		});
		btnGetir.setBounds(455, 78, 119, 53);
		getContentPane().add(btnGetir);
		
		JButton btnGelirGuncelle = new JButton("Gelir G\u00FCncelleme");
		btnGelirGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp.setId(secilenId);
				temp.setMiktar(new BigDecimal(Integer.parseInt(txtUcret.getText())));
				temp.setTanim(comboBox.getSelectedItem().toString());
				temp.setTarih(getDate().getDate());
				dao.update(temp);
				Doldur();
			}
		});
		btnGelirGuncelle.setBounds(455, 142, 119, 53);
		getContentPane().add(btnGelirGuncelle);
		
		JButton btnCikis = new JButton("\u0130ptal");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IncomeScreen().dispose();
			}
		});
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
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilenId = Long.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
				txtUcret.setText(CourseUtils.getValue(table.getValueAt(table.getSelectedRow(), 1)));
			}
		});
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(176, 369, 156, 20);
		getContentPane().add(dateChooser);
		
		
		

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
	private JDateChooser getDate() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("dd/MM/yyyy");
			dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					if (dateChooser.getDate() != null) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

						String gun = sdf.format(dateChooser.getDate());
						JOptionPane.showMessageDialog(IncomeScreen.this, gun);
					}

				}
			});
			dateChooser.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}

				public void inputMethodTextChanged(InputMethodEvent event) {
					dateChooser.setDateFormatString("dd/MM/yyyy");
					JOptionPane.showMessageDialog(IncomeScreen.this, dateChooser.getDateFormatString());
				}
			});
			dateChooser.setBounds(281, 140, 95, 20);
		}
		return dateChooser;
	}
	
	private void Doldur() {
		IncomingsDAO incomedao = new IncomingsDAO();
		List<Incomings> liste = incomedao.getAllRows(new Incomings());
		String[][] data = new String[liste.size()][4];
		String[] columns = { "ID", "Ücretin Miktarý", "Taným", "Tarih" };
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = String.valueOf(liste.get(i).getId());
			data[i][1] = String.valueOf(liste.get(i).getMiktar());
			data[i][2] = String.valueOf(liste.get(i).getTanim());
			data[i][3] = String.valueOf(liste.get(i).getTarih());
			
			
		}
		DefaultTableModel model = new DefaultTableModel(data, columns);
		table.setModel(model);

	}

}
