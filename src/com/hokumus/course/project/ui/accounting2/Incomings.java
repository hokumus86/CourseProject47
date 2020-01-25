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
	private JMenuBar men�;
	private JMenu mnmenu;
	private JMenuItem mn�tmogrc;
	private JMenuItem mnitmfirma;
	private JMenuItem mn�tmKira;
	
	public Incomings() {
		
		initialize();
		
		
	}

	private void initialize() {
		
		setTitle("GEL�RLER");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,400 );
		getContentPane().setLayout(null);
		setJMenuBar(getMenuBar_1());
		
	}
	private JMenuBar getMenuBar_1() {
		if (men� == null) {
			men� = new JMenuBar();
			men�.add(getMnmenu());
		}
		return men�;
	}
	private JMenu getMnmenu() {
		if (mnmenu == null) {
			mnmenu = new JMenu("Men\u00FC");
			mnmenu.add(getMn�tmogrc());
			mnmenu.add(getMnitmfirma());
			mnmenu.add(getMn�tmKira());
		}
		return mnmenu;
	}
	private JMenuItem getMn�tmogrc() {
		if (mn�tmogrc == null) {
			mn�tmogrc = new JMenuItem("\u00F6\u011Frenci \u00F6deme");
		}
		return mn�tmogrc;
	}
	private JMenuItem getMnitmfirma() {
		if (mnitmfirma == null) {
			mnitmfirma = new JMenuItem("firma \u00F6deme");
		}
		return mnitmfirma;
	}
	private JMenuItem getMn�tmKira() {
		if (mn�tmKira == null) {
			mn�tmKira = new JMenuItem("kira");
		}
		return mn�tmKira;
	}
}
