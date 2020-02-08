package com.hokumus.course.project.ui.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.hokumus.course.project.ui.LoginFrame;
import com.hokumus.course.project.ui.MainFrameKatakulle;
import com.hokumus.course.project.utils.CourseUtils;
import javax.swing.JButton;
  
@SuppressWarnings("serial")
public class MainScreen extends JFrame{
	private JButton btnOgrenci;
	private JButton btnOgretmen;
	private JButton btnDemirbas;
	private boolean closingOpr=false;
	public MainScreen() {
		
		initialize();
	}

	private void initialize() {
		setTitle("Tan\u0131mlama Mod\u00FCl\u00FC -"+CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(getBtnOgrenci());
		getContentPane().add(getBtnOgretmen());
		getContentPane().add(getBtnDemirbas());
		setBounds(100, 100, 380, 360);
		
	}
	@Override
	public void dispose() {
		super.dispose();
		if(!closingOpr)
			new MainFrameKatakulle().setVisible(true);
		
	}
	private JButton getBtnOgrenci() {
		if (btnOgrenci == null) {
			btnOgrenci = new JButton("\u00D6\u011Frenci \u0130\u015Flemleri");
			btnOgrenci.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddStudent addstudent =new AddStudent();
					addstudent.setVisible(true);
					closingOpr=true;
					dispose();
					
				}
			});
			btnOgrenci.setBounds(94, 27, 166, 61);
		}
		return btnOgrenci;
	}
	private JButton getBtnOgretmen() {
		if (btnOgretmen == null) {
			btnOgretmen = new JButton("\u00D6\u011Fretmen \u0130\u015Flemleri");
			btnOgretmen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddTeacher addteacher =new AddTeacher();
					addteacher.setVisible(true);
					closingOpr=true;
					dispose();
				}
			});
			btnOgretmen.setBounds(94, 115, 166, 61);
		}
		return btnOgretmen;
	}
	private JButton getBtnDemirbas() {
		if (btnDemirbas == null) {
			btnDemirbas = new JButton("Demirba\u015F \u0130\u015Flemleri");
			btnDemirbas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				   AddInventory addýnventory=new AddInventory();
				   addýnventory.setVisible(true);
				   closingOpr=true;
				   dispose();
				}
			});
			btnDemirbas.setBounds(94, 211, 166, 61);
		}
		return btnDemirbas;
	}
}
