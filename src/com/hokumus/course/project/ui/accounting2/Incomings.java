package com.hokumus.course.project.ui.accounting2;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Incomings extends JFrame {
	private JMenuBar menü;
	private JMenu mnmenu;
	private JMenuItem mnýtmogrc;
	private JMenuItem mnitmfirma;
	private JMenuItem mnýtmKira;
	
	public Incomings() {
		
		initialize();
		
		
	}

	private void initialize() {
		
		setTitle("GELÝRLER");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,400 );
		getContentPane().setLayout(null);
		setJMenuBar(getMenuBar_1());
		
	}
	private JMenuBar getMenuBar_1() {
		if (menü == null) {
			menü = new JMenuBar();
			menü.add(getMnmenu());
		}
		return menü;
	}
	private JMenu getMnmenu() {
		if (mnmenu == null) {
			mnmenu = new JMenu("Men\u00FC");
			mnmenu.add(getMnýtmogrc());
			mnmenu.add(getMnitmfirma());
			mnmenu.add(getMnýtmKira());
		}
		return mnmenu;
	}
	private JMenuItem getMnýtmogrc() {
		if (mnýtmogrc == null) {
			mnýtmogrc = new JMenuItem("\u00F6\u011Frenci \u00F6deme");
		}
		return mnýtmogrc;
	}
	private JMenuItem getMnitmfirma() {
		if (mnitmfirma == null) {
			mnitmfirma = new JMenuItem("firma \u00F6deme");
		}
		return mnitmfirma;
	}
	private JMenuItem getMnýtmKira() {
		if (mnýtmKira == null) {
			mnýtmKira = new JMenuItem("kira");
		}
		return mnýtmKira;
	}
}
