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
	private JMenuItem mnýtmKursAma;
	private JMenuItem mnýtmKursGncellesil;
	private JMenuItem mnýtmGrupAma;
	private JMenuItem mnýtmGrupGncellesil;
	private JMenuItem mnýtmSnfAma;
	private JMenuItem mnýtmSnfGncellesil;
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
			mnKursIlemleri.add(getMnýtmKursAma());
			mnKursIlemleri.add(getMnýtmKursGncellesil());
		}
		return mnKursIlemleri;
	}
	private JMenu getMnGrupIlemleri() {
		if (mnGrupIlemleri == null) {
			mnGrupIlemleri = new JMenu("Grup \u0130\u015Flemleri");
			mnGrupIlemleri.add(getMnýtmGrupAma());
			mnGrupIlemleri.add(getMnýtmGrupGncellesil());
		}
		return mnGrupIlemleri;
	}
	private JMenu getMnSnfIlemleri() {
		if (mnSnfIlemleri == null) {
			mnSnfIlemleri = new JMenu("S\u0131n\u0131f \u0130\u015Flemleri");
			mnSnfIlemleri.add(getMnýtmSnfAma());
			mnSnfIlemleri.add(getMnýtmSnfGncellesil());
		}
		return mnSnfIlemleri;
	}
	private JMenuItem getMnýtmKursAma() {
		if (mnýtmKursAma == null) {
			mnýtmKursAma = new JMenuItem("Kurs A\u00E7ma");
			mnýtmKursAma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new KursAcmaEkrani().setVisible(true);
				}
			});
		}
		return mnýtmKursAma;
	}
	private JMenuItem getMnýtmKursGncellesil() {
		if (mnýtmKursGncellesil == null) {
			mnýtmKursGncellesil = new JMenuItem("Kurs G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil");
			mnýtmKursGncellesil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new KursGoruntuleGuncelleSil().setVisible(true);
				}
			});
		}
		return mnýtmKursGncellesil;
	}
	private JMenuItem getMnýtmGrupAma() {
		if (mnýtmGrupAma == null) {
			mnýtmGrupAma = new JMenuItem("Grup A\u00E7ma");
			mnýtmGrupAma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new GrupAcmaEkrani().setVisible(true);
				}
			});
		}
		return mnýtmGrupAma;
	}
	private JMenuItem getMnýtmGrupGncellesil() {
		if (mnýtmGrupGncellesil == null) {
			mnýtmGrupGncellesil = new JMenuItem("Grup G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil");
			mnýtmGrupGncellesil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new GrupGoruntuleGuncelleSil().setVisible(true);
				}
			});
		}
		return mnýtmGrupGncellesil;
	}
	private JMenuItem getMnýtmSnfAma() {
		if (mnýtmSnfAma == null) {
			mnýtmSnfAma = new JMenuItem("S\u0131n\u0131f A\u00E7ma");
			mnýtmSnfAma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new SinifAcmaEkrani().setVisible(true);
				}
			});
		}
		return mnýtmSnfAma;
	}
	private JMenuItem getMnýtmSnfGncellesil() {
		if (mnýtmSnfGncellesil == null) {
			mnýtmSnfGncellesil = new JMenuItem("S\u0131n\u0131f G\u00F6r\u00FCnt\u00FCle/G\u00FCncelle/Sil");
			mnýtmSnfGncellesil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new SinifGoruntuleGuncelleSil().setVisible(true);
				}
			});
		}
		return mnýtmSnfGncellesil;
	}
}
