package com.hokumus.course.project.ui.managementscreen;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.hokumus.course.project.ui.MainFrameKatakulle;
import com.hokumus.course.project.utils.CourseUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ManagementScreen extends JFrame{
	private JMenuBar menuBar;
	private JMenu mnKursIlemleri;
	private JMenu mnGrupIlemleri;
	private JMenu mnSnfIlemleri;
	private JButton btnGeri;
	private JTabbedPane panelAna;
	private JMenu mnrenciIlemleri;
	public ManagementScreen() {
		
		initialize();
	}

	private void initialize() {
		setTitle("Y\u00F6netim Mod\u00FCl\u00FC -"+CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
		getContentPane().setLayout(null);
		getContentPane().add(getMenuBar_1());
		getContentPane().add(getBtnGeri());
		getContentPane().add(getPanelAna());
		setBounds(350, 70, 904, 725);
		
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 769, 37);
			menuBar.add(getMnKursIlemleri());
			menuBar.add(getMnGrupIlemleri());
			menuBar.add(getMnSnfIlemleri());
			menuBar.add(getMnrenciIlemleri());
		}
		return menuBar;
	}
	private JMenu getMnKursIlemleri() {
		if (mnKursIlemleri == null) {
			mnKursIlemleri = new JMenu("Kurs \u0130\u015Flemleri");
			mnKursIlemleri.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					panelAna.removeAll();
					KursIslemleri kurs=new KursIslemleri();
					panelAna.add(kurs.getContentPane());
					
				}
			});
		}
		return mnKursIlemleri;
	}
	private JMenu getMnGrupIlemleri() {
		if (mnGrupIlemleri == null) {
			mnGrupIlemleri = new JMenu("Grup \u0130\u015Flemleri");
			mnGrupIlemleri.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					panelAna.removeAll();
					GrupIslemleri grup=new GrupIslemleri();
					panelAna.add(grup.getContentPane());
				}
			});
		}
		return mnGrupIlemleri;
	}
	private JMenu getMnSnfIlemleri() {
		if (mnSnfIlemleri == null) {
			mnSnfIlemleri = new JMenu("S\u0131n\u0131f \u0130\u015Flemleri");
			mnSnfIlemleri.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					panelAna.removeAll();
					SinifIslemleri sinif=new SinifIslemleri();
					panelAna.add(sinif.getContentPane());
				}
			});
		}
		return mnSnfIlemleri;
	}
	private JButton getBtnGeri() {
		if (btnGeri == null) {
			btnGeri = new JButton("Geri");
			btnGeri.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new MainFrameKatakulle().setVisible(true);
					ManagementScreen.this.dispose();
				}
			});
			btnGeri.setBounds(779, 0, 99, 37);
		}
		return btnGeri;
	}
	public  JTabbedPane getPanelAna() {
		if (panelAna == null) {
			panelAna = new JTabbedPane(JTabbedPane.TOP);
			panelAna.setBounds(10, 37, 868, 638);
		}
		return panelAna;
	}
	private JMenu getMnrenciIlemleri() {
		if (mnrenciIlemleri == null) {
			mnrenciIlemleri = new JMenu("\u00D6\u011Frenci \u0130\u015Flemleri");
		}
		return mnrenciIlemleri;
	}
}
