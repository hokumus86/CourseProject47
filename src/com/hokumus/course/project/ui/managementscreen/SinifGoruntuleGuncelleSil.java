package com.hokumus.course.project.ui.managementscreen;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.hokumus.course.project.models.management.LessonClass;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class SinifGoruntuleGuncelleSil extends JFrame {
	private JLabel lblAd;
	private JTextField txtSinifAdi;
	private JLabel lblSinifKodu;
	private JTextField txtSinifKodu;
	private JLabel lblKapasite;
	private JTextField txtKapasite;
	private JButton btnGuncelle;
	private JScrollPane scrollPane;
	private JPanel panelArama;
	private JTextField txtArama;
	private JButton btnSil;
	private JButton btnTemizle;
	private JButton btnIptal;
	private JTable tblSiniflar;
	public SinifGoruntuleGuncelleSil() {
		initialize();
	}

	private void initialize() {
		setTitle("S\u0131n\u0131f G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil -"+CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
		setBounds(400, 150, 787, 528);
		getContentPane().setLayout(null);
		getContentPane().add(getLblAd());
		getContentPane().add(getTxtSinifAdi());
		getContentPane().add(getLblSinifKodu());
		getContentPane().add(getTxtSinifKodu());
		getContentPane().add(getLblKapasite());
		getContentPane().add(getTxtKapasite());
		getContentPane().add(getBtnGuncelle());
		getContentPane().add(getScrollPane());
		getContentPane().add(getPanelArama());
		getContentPane().add(getBtnSil());
		getContentPane().add(getBtnTemizle());
		getContentPane().add(getBtnIptal());
		getContentPane().add(getLblMesaj());
		sinifTablosuGöster();
	}
	
	
	
	
	DefaultTableModel model=new DefaultTableModel();
	private JLabel lblMesaj;
	
	public void sinifTablosuGöster() {
		
		DbServicessBase<LessonClass> dao=new DbServicessBase<LessonClass>();
		LessonClass temp=new LessonClass();
		
		List<LessonClass> sinif_listesi=dao.getAllRows(temp);
		

		String [] columnNames= {"ID","ADI","KODU","KAPASÝTE","PAZARTESÝ","SALI","ÇARÞAMBA","PERÞEMBE","CUMA","CUMARTESÝ","PAZAR"};
		String [][] data=new String[sinif_listesi.size()][columnNames.length];
		
		for (int i = 0; i <sinif_listesi.size(); i++) {
			
			
			data[i][0]=sinif_listesi.get(i).getId().toString();
			data[i][1]=sinif_listesi.get(i).getAdi().toString();
			data[i][2]=sinif_listesi.get(i).getKod().toString();
			data[i][3]=String.valueOf(sinif_listesi.get(i).getKapasite());
			

			
		}

		model=new DefaultTableModel(data,columnNames);
		tblSiniflar.setModel(model);
		
	}

	public void arama(String ara) {
		
		TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
		tblSiniflar.setRowSorter(tr);
		
		tr.setRowFilter(RowFilter.regexFilter(ara));
		
		
	}

	
	private JLabel getLblAd() {
		if (lblAd == null) {
			lblAd = new JLabel("S\u0131n\u0131f Ad\u0131:");
			lblAd.setBounds(19, 24, 105, 26);
		}
		return lblAd;
	}
	private JTextField getTxtSinifAdi() {
		if (txtSinifAdi == null) {
			txtSinifAdi = new JTextField();
			txtSinifAdi.setBounds(134, 27, 113, 20);
			txtSinifAdi.setColumns(10);
		}
		return txtSinifAdi;
	}
	private JLabel getLblSinifKodu() {
		if (lblSinifKodu == null) {
			lblSinifKodu = new JLabel("S\u0131n\u0131f Kodu:");
			lblSinifKodu.setBounds(19, 68, 78, 14);
		}
		return lblSinifKodu;
	}
	private JTextField getTxtSinifKodu() {
		if (txtSinifKodu == null) {
			txtSinifKodu = new JTextField();
			txtSinifKodu.setColumns(10);
			txtSinifKodu.setBounds(134, 65, 113, 20);
		}
		return txtSinifKodu;
	}
	private JLabel getLblKapasite() {
		if (lblKapasite == null) {
			lblKapasite = new JLabel("Kapasite:");
			lblKapasite.setBounds(19, 108, 71, 14);
		}
		return lblKapasite;
	}
	private JTextField getTxtKapasite() {
		if (txtKapasite == null) {
			txtKapasite = new JTextField();
			txtKapasite.setColumns(10);
			txtKapasite.setBounds(134, 105, 113, 20);
		}
		return txtKapasite;
	}
	private JButton getBtnGuncelle() {
		if (btnGuncelle == null) {
			btnGuncelle = new JButton("G\u00FCncelle");
			btnGuncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					DbServicessBase<LessonClass> dao=new DbServicessBase<LessonClass>();
					LessonClass yenisinif=new LessonClass();
					yenisinif.setAdi(txtSinifAdi.getText());
					yenisinif.setKod(txtSinifKodu.getText());
					yenisinif.setKapasite(Integer.valueOf(txtKapasite.getText()));
					
					if (dao.update(yenisinif)) {
						lblMesaj.setText("Sýnýf baþarý ile Güncellendi");
						sinifTablosuGöster();
					}
					else {
						lblMesaj.setText("Sýnýf Güncellenemedi");
					}
				}
			});
			btnGuncelle.setBounds(414, 13, 89, 49);
		}
		return btnGuncelle;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 184, 751, 266);
			scrollPane.setViewportView(getTblSiniflar());
		}
		return scrollPane;
	}
	private JPanel getPanelArama() {
		if (panelArama == null) {
			panelArama = new JPanel();
			panelArama.setBorder(new TitledBorder(null, "Arama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelArama.setBounds(10, 128, 674, 45);
			panelArama.setLayout(null);
			panelArama.add(getTxtArama());
		}
		return panelArama;
	}
	private JTextField getTxtArama() {
		if (txtArama == null) {
			txtArama = new JTextField();
			txtArama.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String ara=txtArama.getText().toString();
					arama(ara);
				}
			});
			txtArama.setBounds(10, 15, 654, 19);
			txtArama.setColumns(10);
		}
		return txtArama;
	}
	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("Sil");
			btnSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<LessonClass> dao=new DbServicessBase<LessonClass>();
					LessonClass silinecek_sinif=new LessonClass();
					int row=tblSiniflar.getSelectedRow();
					silinecek_sinif.setId(Long.valueOf(tblSiniflar.getValueAt(row, 0).toString()));
					silinecek_sinif.setAdi(tblSiniflar.getValueAt(row, 1).toString());
					silinecek_sinif.setKapasite(Integer.valueOf(tblSiniflar.getValueAt(row, 3).toString()));
					silinecek_sinif.setKod(tblSiniflar.getValueAt(row, 2).toString());
					if (dao.delete(silinecek_sinif)) {
						lblMesaj.setText("Sýnýf Baþarý ile Silindi");
						sinifTablosuGöster();
					}
					else {
						lblMesaj.setText("Sýnýf Baþarý ile Silinemedi");
					}
				}
			});
			btnSil.setBounds(537, 13, 89, 49);
		}
		return btnSil;
	}
	private JButton getBtnTemizle() {
		if (btnTemizle == null) {
			btnTemizle = new JButton("Temizle");
			btnTemizle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtSinifAdi.setText("");
					txtSinifKodu.setText("");
					txtKapasite.setText("");
					txtArama.setText("");
					lblMesaj.setText("");
				}
			});
			btnTemizle.setBounds(659, 13, 89, 49);
		}
		return btnTemizle;
	}
	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SinifGoruntuleGuncelleSil.this.dispose();
				}
			});
			btnIptal.setBounds(659, 68, 89, 49);
		}
		return btnIptal;
	}
	private JTable getTblSiniflar() {
		if (tblSiniflar == null) {
			tblSiniflar = new JTable();
			tblSiniflar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int row=tblSiniflar.getSelectedRow();
					
					
					txtSinifAdi.setText(tblSiniflar.getValueAt(row, 1).toString());
					txtSinifKodu.setText(tblSiniflar.getValueAt(row, 2).toString());
					txtKapasite.setText((String.valueOf(tblSiniflar.getValueAt(row, 3))));
					
				}
			});
		}
		return tblSiniflar;
	}
	private JLabel getLblMesaj() {
		if (lblMesaj == null) {
			lblMesaj = new JLabel("");
			lblMesaj.setForeground(Color.RED);
			lblMesaj.setBounds(10, 450, 751, 28);
		}
		return lblMesaj;
	}
}
