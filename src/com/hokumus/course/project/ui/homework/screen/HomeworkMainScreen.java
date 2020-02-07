package com.hokumus.course.project.ui.homework.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

import com.hokumus.course.project.models.homeworks.Odev;
import com.hokumus.course.project.models.management.Groups;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;
import com.toedter.calendar.JDateChooser;

public class HomeworkMainScreen extends JFrame {
	private JButton btngoster;
	private JButton btnolustur;
	private JButton btnduzenle;
	private JButton btnsil;
	private JScrollPane scrollPane;
	private JTable tableodevler;
	private JLabel lblGrup;
	private JComboBox cmbgrup;
	private JLabel lblBalangTarihi;
	private JDateChooser dateBaslamaTrh;
	private JLabel lblBitiTarihi;
	private JDateChooser dateBitisTrh;

	private JLabel lbldevIerii;
	private JTextField txtodev;
	public HomeworkMainScreen() {
		initialize();
	}

	private void initialize() {
		setTitle("ÖDEV GÖREV -"+CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
		getContentPane().setLayout(null);
		getContentPane().add(getBtngoster());
		getContentPane().add(getBtnolustur());
		getContentPane().add(getBtnduzenle());
		getContentPane().add(getBtnsil());
		getContentPane().add(getScrollPane());
		getContentPane().add(getLblGrup());
		getContentPane().add(getCmbgrup());
		getContentPane().add(getLblBalangTarihi());
		getContentPane().add(getDateBaslamaTrh());
		getContentPane().add(getLblBitiTarihi());
		getContentPane().add(getDateBitisTrh());
	
		getContentPane().add(getLbldevIerii());
		getContentPane().add(getTxtodev());
		setBounds(350, 70, 600, 400);
		odevTablosuGoster();
		DbServicessBase<Groups> dao=new DbServicessBase<Groups>();
		List<Groups> gruplar=dao.getAllRows(new Groups());
		DefaultComboBoxModel model = new DefaultComboBoxModel(gruplar.toArray());		
		cmbgrup.setModel(model);
		switch (CourseUtils.loginedUser.getRole()) {
		case ADMIN:
			
			break;

		case GENERAL_MANAGER:
		

			break;

		case TEACHER:

		
			break;

		case STUDENT:
			
			btnolustur.setEnabled(false);
			btnduzenle.setEnabled(false);
			btnsil.setEnabled(false);
			break;

		case HUMAN_RESOURCES:

			break;

		case ACCOUNTING:

			break;

		case MANAGER:

			break;

		default:
			break;
		}
	}
	DefaultTableModel model=new DefaultTableModel();
	public void odevTablosuGoster() {
		
		
		DbServicessBase<Odev> dao=new DbServicessBase<Odev>(); 
		Odev temp=new Odev();
		List<Odev> odev_listesi=dao.getAllRows(temp);
		
		
		String [] columnNames= {"ID","GRU ADI","BAÞLANGIÇ TARÝHÝ","BÝTÝÞ TARÝHÝ","ÖÐRETMEN" , "ÖDEV ÝÇERÝÐÝ"};
		String [][] data=new String [odev_listesi.size()][columnNames.length];
		
		
		for (int i = 0; i < odev_listesi.size(); i++) {
			
			data[i][0]=odev_listesi.get(i).getId().toString();
			data[i][1]=odev_listesi.get(i).getGroups().getAdi().toString();
			data[i][2]=odev_listesi.get(i).getBslngctarihi().toString();
			data[i][3]=odev_listesi.get(i).getBtstarihi().toString();
			data[i][4]=odev_listesi.get(i).getOdev().toString();
			
			
		}
		
		model=new DefaultTableModel(data,columnNames);
		tableodevler.setModel(model);
		
		
		
	}
	private JButton getBtngoster() {
		if (btngoster == null) {
			btngoster = new JButton("\u00D6devleri G\u00F6r\u00FCnt\u00FCle");
			btngoster.setBounds(442, 113, 134, 23);
		}
		return btngoster;
	}
	private JButton getBtnolustur() {
		if (btnolustur == null) {
			btnolustur = new JButton("\u00D6dev Olu\u015Ftur");
			btnolustur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Odev> dao=new DbServicessBase<Odev>();
					Odev temp=new Odev();
					//temp.setGroups(cmbgrup.getSelectedItem().toString());
					
				}
			});
			btnolustur.setBounds(442, 79, 134, 23);
		}
		return btnolustur;
	}
	private JButton getBtnduzenle() {
		if (btnduzenle == null) {
			btnduzenle = new JButton("\u00D6devi D\u00FCzenle");
			btnduzenle.setBounds(442, 45, 134, 23);
		}
		return btnduzenle;
	}
	private JButton getBtnsil() {
		if (btnsil == null) {
			btnsil = new JButton("\u00D6devi Sil");
			btnsil.setBounds(442, 11, 134, 23);
		}
		return btnsil;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 149, 566, 202);
			scrollPane.setViewportView(getTableodevler());
		}
		return scrollPane;
	}
	private JTable getTableodevler() {
		if (tableodevler == null) {
			tableodevler = new JTable();
			tableodevler.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int row=tableodevler.getSelectedRow();
					
					
					cmbgrup.setSelectedItem(tableodevler.getValueAt(row, 1).toString());
					dateBaslamaTrh.setDateFormatString(tableodevler.getValueAt(row, 2).toString());
					dateBitisTrh.setDateFormatString(tableodevler.getValueAt(row, 3).toString());
					txtodev.setText(tableodevler.getValueAt(row, 4).toString());
		
				//	selectedeItemId = Long.valueOf(tblKurslar.getValueAt(row, 0).toString());
					
					
					
					
				}
			});
			tableodevler.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
			)
					);
		}
		return tableodevler;
	}
	private JLabel getLblGrup() {
		if (lblGrup == null) {
			lblGrup = new JLabel("Grup :");
			lblGrup.setBounds(23, 15, 67, 14);
		}
		return lblGrup;
	}
	private JComboBox getCmbgrup() {
		if (cmbgrup == null) {
			cmbgrup = new JComboBox();
			cmbgrup.setBounds(143, 12, 96, 20);
		}
		return cmbgrup;
	}
	private JLabel getLblBalangTarihi() {
		if (lblBalangTarihi == null) {
			lblBalangTarihi = new JLabel("Ba\u015Flang\u0131\u00E7 Tarihi :");
			lblBalangTarihi.setBounds(23, 44, 89, 14);
		}
		return lblBalangTarihi;
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
				//		JOptionPane.showMessageDialog(HomeworkMainScreen.this, gun);

					}

				}
			});
			dateBaslamaTrh.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}

				public void inputMethodTextChanged(InputMethodEvent event) {
					dateBaslamaTrh.setDateFormatString("dd/MM/yyyy");
					JOptionPane.showMessageDialog(HomeworkMainScreen.this, dateBaslamaTrh.getDateFormatString());
				}
			});
			dateBaslamaTrh.setBounds(143, 40, 105, 22);
		}
		return dateBaslamaTrh;
	}
	private JLabel getLblBitiTarihi() {
		if (lblBitiTarihi == null) {
			lblBitiTarihi = new JLabel("Biti\u015F Tarihi :");
			lblBitiTarihi.setBounds(23, 73, 66, 14);
		}
		return lblBitiTarihi;
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
					//	JOptionPane.showMessageDialog(HomeworkMainScreen.this, gun);

					}

				}
			});
			dateBaslamaTrh.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}

				public void inputMethodTextChanged(InputMethodEvent event) {
					dateBitisTrh.setDateFormatString("dd/MM/yyyy");
					JOptionPane.showMessageDialog(HomeworkMainScreen.this, dateBitisTrh.getDateFormatString());
				}
			});
			dateBitisTrh.setBounds(143, 69, 105, 22);
		}
		return dateBitisTrh;
	}

	private JLabel getLbldevIerii() {
		if (lbldevIerii == null) {
			lbldevIerii = new JLabel("\u00D6dev \u0130\u00E7eri\u011Fi :");
			lbldevIerii.setBounds(23, 122, 89, 14);
		}
		return lbldevIerii;
	}
	private JTextField getTxtodev() {
		if (txtodev == null) {
			txtodev = new JTextField();
			txtodev.setBounds(143, 119, 134, 20);
			txtodev.setColumns(10);
		}
		return txtodev;
	}
}
