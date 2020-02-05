package com.hokumus.course.project.ui.accounting;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.project.models.accounting.Debt;
import com.hokumus.course.project.models.student.Student;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.hokumus.course.project.utils.dao.DebtsDAO;
import com.hokumus.course.project.utils.dao.StudentDAO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Viewdebt extends JFrame {
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnSil;
	private JButton btnGncelle;
	private JLabel lblAd;
	private JLabel lblSoyad;
	private JLabel lblTarih;
	private JLabel lblAlnan;
	private JLabel lblKalan;
	private JTextField txtad;
	private JTextField txtsoyad;
	private JTextField txtalnan;
	private JTextField txtkalan;
	private Long selecteditemid;
	private JButton btnBorlularGetir;
	
	public Viewdebt() {
		initialize();
		
	}

	private void initialize() {
		setTitle("Fatura Görüntüle");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnSil());
		getContentPane().add(getBtnGncelle());
		getContentPane().add(getLblAd());
		getContentPane().add(getLblSoyad());
		getContentPane().add(getLblTarih());
		getContentPane().add(getLblAlnan());
		getContentPane().add(getLblKalan());
		getContentPane().add(getTxtad());
		getContentPane().add(getTxtsoyad());
		getContentPane().add(getTxtalnan());
		getContentPane().add(getTxtkalan());
		getContentPane().add(getBtnBorlularGetir());
		
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 181, 464, 269);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					selecteditemid = Long.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
					txtad.setText(CourseUtils.getValue(table.getValueAt(table.getSelectedRow(), 1)));
					txtsoyad.setText(CourseUtils.getValue(table.getValueAt(table.getSelectedRow(), 2)));
					txtalnan.setText(CourseUtils.getValue(table.getValueAt(table.getSelectedRow(), 3)));
					txtkalan.setText(CourseUtils.getValue(table.getValueAt(table.getSelectedRow(), 4)));	
						
				}
			});
			scrollPane.setViewportView(table);
			faturatablosu();
			table.setModel(new DefaultTableModel(new Object[][] {}, 
					new String[] { "ID", "AD", "SOYAD","ALINAN","KALAN", "TARÝH" }) {
				
				
			});

			

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] {  });

			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
		return table;

			
		}
		return table;
	}
	private void faturatablosu() {
		DebtsDAO debtdao = new DebtsDAO();
		List<Debt> liste = debtdao.getAllRows(new Debt());
		String[][] data = new String[liste.size()][5];
		String[] columns = { "ID", "AD", "SOYAD", "ALINAN", "KALAN" };
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = String.valueOf(liste.get(i).getId());
			data[i][1] = liste.get(i).getAd();
			data[i][2] = liste.get(i).getSoyad();
			data[i][3] = liste.get(i).getAlinan().toString();
			data[i][4] = liste.get(i).getKalan().toString();
			
			
		}
		DefaultTableModel model = new DefaultTableModel(data, columns);
		table.setModel(model);
		
	}

	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("S\u0130L");
			btnSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					DbServicessBase<Debt> debtdao = new DbServicessBase<Debt>();
					Debt sil = new Debt();
					sil.setId(selecteditemid);
					sil.setAd(txtad.getText());
					sil.setSoyad(txtsoyad.getText());
					sil.setAlinan(new BigDecimal(txtalnan.getText().toString()));
					sil.setKalan(new BigDecimal(txtkalan.getText().toString()));
					
					if (debtdao.delete(sil)) {
						JOptionPane.showMessageDialog(Viewdebt.this, " baþarýlý");
						faturatablosu();
						
					} else
						JOptionPane.showMessageDialog(Viewdebt.this, " baþarýsýz");
				}
			});
			btnSil.setBounds(284, 45, 112, 23);
		}
		return btnSil;
	}
	private JButton getBtnGncelle() {
		if (btnGncelle == null) {
			btnGncelle = new JButton("G\u00DCNCELLE");
			btnGncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					DebtsDAO debtdao = new DebtsDAO();
					Debt guncelle = new Debt();
					guncelle.setAd(txtad.getText());
					guncelle.setSoyad(txtsoyad.getText());
					guncelle.setAlinan(new BigDecimal(txtalnan.getText().toString()));
					guncelle.setKalan(new BigDecimal(txtkalan.getText().toString()));
					guncelle.setId(selecteditemid);
					
					if (debtdao.update(guncelle)) {
						JOptionPane.showMessageDialog(Viewdebt.this, " baþarýlý");
						faturatablosu();
						
					} else
						JOptionPane.showMessageDialog(Viewdebt.this, " baþarýsýz");
					
				}
			});
			btnGncelle.setBounds(284, 92, 112, 23);
		}
		return btnGncelle;
	}
	private JLabel getLblAd() {
		if (lblAd == null) {
			lblAd = new JLabel("Ad");
			lblAd.setBounds(10, 11, 46, 14);
		}
		return lblAd;
	}
	private JLabel getLblSoyad() {
		if (lblSoyad == null) {
			lblSoyad = new JLabel("Soyad");
			lblSoyad.setBounds(10, 45, 46, 14);
		}
		return lblSoyad;
	}
	private JLabel getLblTarih() {
		if (lblTarih == null) {
			lblTarih = new JLabel("Tarih");
			lblTarih.setBounds(10, 149, 46, 14);
		}
		return lblTarih;
	}
	private JLabel getLblAlnan() {
		if (lblAlnan == null) {
			lblAlnan = new JLabel("Al\u0131nan");
			lblAlnan.setBounds(10, 81, 46, 14);
		}
		return lblAlnan;
	}
	private JLabel getLblKalan() {
		if (lblKalan == null) {
			lblKalan = new JLabel("Kalan");
			lblKalan.setBounds(10, 112, 46, 14);
		}
		return lblKalan;
	}
	private JTextField getTxtad() {
		if (txtad == null) {
			txtad = new JTextField();
			txtad.setBounds(80, 8, 86, 20);
			txtad.setColumns(10);
		}
		return txtad;
	}
	private JTextField getTxtsoyad() {
		if (txtsoyad == null) {
			txtsoyad = new JTextField();
			txtsoyad.setBounds(80, 46, 86, 20);
			txtsoyad.setColumns(10);
		}
		return txtsoyad;
	}
	private JTextField getTxtalnan() {
		if (txtalnan == null) {
			txtalnan = new JTextField();
			txtalnan.setBounds(80, 78, 86, 20);
			txtalnan.setColumns(10);
		}
		return txtalnan;
	}
	private JTextField getTxtkalan() {
		if (txtkalan == null) {
			txtkalan = new JTextField();
			txtkalan.setBounds(80, 109, 86, 20);
			txtkalan.setColumns(10);
		}
		return txtkalan;
	}
	private JButton getBtnBorlularGetir() {
		if (btnBorlularGetir == null) {
			btnBorlularGetir = new JButton("Bor\u00E7lular Getir");
			btnBorlularGetir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					faturatablosu();
				}
			});
			btnBorlularGetir.setBounds(284, 140, 112, 23);
		}
		return btnBorlularGetir;
	}
}
