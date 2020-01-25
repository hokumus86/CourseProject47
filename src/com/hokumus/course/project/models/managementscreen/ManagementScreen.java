package com.hokumus.course.project.models.managementscreen;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ManagementScreen extends JFrame{
	private JMenuBar menuBar;
	private JMenu mnKursIlemleri;
	private JMenu mnGrupIlemleri;
	private JMenu mnSnfIlemleri;
	private JMenuItem mn�tmKursAma;
	private JMenuItem mn�tmKursGncellesil;
	private JMenuItem mn�tmGrupAma;
	private JMenuItem mn�tmGrupGncellesil;
	private JMenuItem mn�tmSnfAma;
	private JMenuItem mn�tmSnfGncellesil;
	public ManagementScreen() {
		
		initialize();
	}

	private void initialize() {
		setTitle("Y\u00F6netim Mod\u00FCl\u00FC");
		getContentPane().setLayout(null);
		getContentPane().add(getMenuBar_1());
		setBounds(350, 70, 807, 586);
		
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 768, 37);
			menuBar.add(getMnKursIlemleri());
			menuBar.add(getMnGrupIlemleri());
			menuBar.add(getMnSnfIlemleri());
		}
		return menuBar;
	}
	private JMenu getMnKursIlemleri() {
		if (mnKursIlemleri == null) {
			mnKursIlemleri = new JMenu("Kurs \u0130\u015Flemleri");
			mnKursIlemleri.add(getMn�tmKursAma());
			mnKursIlemleri.add(getMn�tmKursGncellesil());
		}
		return mnKursIlemleri;
	}
	private JMenu getMnGrupIlemleri() {
		if (mnGrupIlemleri == null) {
			mnGrupIlemleri = new JMenu("Grup \u0130\u015Flemleri");
			mnGrupIlemleri.add(getMn�tmGrupAma());
			mnGrupIlemleri.add(getMn�tmGrupGncellesil());
		}
		return mnGrupIlemleri;
	}
	private JMenu getMnSnfIlemleri() {
		if (mnSnfIlemleri == null) {
			mnSnfIlemleri = new JMenu("S\u0131n\u0131f \u0130\u015Flemleri");
			mnSnfIlemleri.add(getMn�tmSnfAma());
			mnSnfIlemleri.add(getMn�tmSnfGncellesil());
		}
		return mnSnfIlemleri;
	}
	private JMenuItem getMn�tmKursAma() {
		if (mn�tmKursAma == null) {
			mn�tmKursAma = new JMenuItem("Kurs A\u00E7ma");
			mn�tmKursAma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new KursAcmaEkrani().setVisible(true);
				}
			});
		}
		return mn�tmKursAma;
	}
	private JMenuItem getMn�tmKursGncellesil() {
		if (mn�tmKursGncellesil == null) {
			mn�tmKursGncellesil = new JMenuItem("Kurs G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil");
			mn�tmKursGncellesil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new KursGoruntuleGuncelleSil().setVisible(true);
				}
			});
		}
		return mn�tmKursGncellesil;
	}
	private JMenuItem getMn�tmGrupAma() {
		if (mn�tmGrupAma == null) {
			mn�tmGrupAma = new JMenuItem("Grup A\u00E7ma");
			mn�tmGrupAma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new GrupAcmaEkrani().setVisible(true);
				}
			});
		}
		return mn�tmGrupAma;
	}
	private JMenuItem getMn�tmGrupGncellesil() {
		if (mn�tmGrupGncellesil == null) {
			mn�tmGrupGncellesil = new JMenuItem("Grup G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil");
			mn�tmGrupGncellesil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new GrupGoruntuleGuncelleSil().setVisible(true);
				}
			});
		}
		return mn�tmGrupGncellesil;
	}
	private JMenuItem getMn�tmSnfAma() {
		if (mn�tmSnfAma == null) {
			mn�tmSnfAma = new JMenuItem("S\u0131n\u0131f A\u00E7ma");
			mn�tmSnfAma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new SinifAcmaEkrani().setVisible(true);
				}
			});
		}
		return mn�tmSnfAma;
	}
	private JMenuItem getMn�tmSnfGncellesil() {
		if (mn�tmSnfGncellesil == null) {
			mn�tmSnfGncellesil = new JMenuItem("S\u0131n\u0131f G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil");
			mn�tmSnfGncellesil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new SinifGoruntuleGuncelleSil().setVisible(true);
				}
			});
		}
		return mn�tmSnfGncellesil;
	}
}
