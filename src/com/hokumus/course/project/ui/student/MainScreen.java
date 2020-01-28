package com.hokumus.course.project.ui.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.hokumus.course.project.ui.MainFrameKatakulle;
import com.hokumus.course.project.utils.CourseUtils;
  
public class MainScreen extends JFrame{
	private JMenuBar menuBar;
	private JMenu mnOgrenciIslemleri;
	private JMenu mnOgretmenIslemleri;
	private JMenu mnItem;
	private JMenuItem mnOgrenciEkle;
	private JMenuItem mnýtmOgrenciGüncelleSil;
	private JMenuItem mnOgretmenEkle;
	private JMenuItem mnOgretmenGüncellesil;
	private JMenuItem mnEkleSil;
	private JMenuItem mnGüncelle;
	private JButton btnGeri;
	
	
	public MainScreen() {
		
		initialize();
	}

	private void initialize() {
		setTitle("Tan\u0131mlama Mod\u00FCl\u00FC -"+CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
		getContentPane().setLayout(null);
		getContentPane().add(getMenuBar_1());
		getContentPane().add(getBtnGeri());
		setBounds(350, 70, 807, 586);
		
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 691, 37);
			menuBar.add(getMnOgrenciIslemleri());
			menuBar.add(getMnOgretmenIslemleri());
			menuBar.add(getMnItem());
		}
		return menuBar;
	}
	private JMenu getMnOgrenciIslemleri() {
		if (mnOgrenciIslemleri == null) {
			mnOgrenciIslemleri = new JMenu("\u00D6\u011Frenci \u0130\u015Flemleri");
			mnOgrenciIslemleri.add(getMnOgrenciEkle());
			mnOgrenciIslemleri.add(getMnýtmOgrenciGüncelleSil());
		}
		return mnOgrenciIslemleri;
	}
	private JMenu getMnOgretmenIslemleri() {
		if (mnOgretmenIslemleri == null) {
			mnOgretmenIslemleri = new JMenu("\u00D6\u011Fretmen \u0130\u015Flemleri");
			mnOgretmenIslemleri.add(getMnOgretmenEkle());
			mnOgretmenIslemleri.add(getMnOgretmenGüncellesil());
		}
		return mnOgretmenIslemleri;
	}
	private JMenu getMnItem() {
		if (mnItem == null) {
			mnItem = new JMenu("Demirba\u015F \u0130\u015Flemleri");
			mnItem.add(getMnEkleSil());
			mnItem.add(getMnGüncelle());
		}
		return mnItem;
	}
	private JMenuItem getMnOgrenciEkle() {
		if (mnOgrenciEkle == null) {
			mnOgrenciEkle = new JMenuItem("\u00D6\u011Frenci Ekle");
			mnOgrenciEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new AddStudent().setVisible(true);
				}
			});
		}
		return mnOgrenciEkle;
	}
	private JMenuItem getMnýtmOgrenciGüncelleSil() {
		if (mnýtmOgrenciGüncelleSil == null) {
			mnýtmOgrenciGüncelleSil = new JMenuItem("\u00D6\u011Frenci G\u00FCncelle");
			mnýtmOgrenciGüncelleSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new ActionStudent().setVisible(true);
				}
			});
		}
		return mnýtmOgrenciGüncelleSil;
	}
	private JMenuItem getMnOgretmenEkle() {
		if (mnOgretmenEkle == null) {
			mnOgretmenEkle = new JMenuItem("\u00D6\u011Fretmen Ekle");
			mnOgretmenEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new AddTeacher().setVisible(true);
				}
			});
		}
		return mnOgretmenEkle;
	}
	private JMenuItem getMnOgretmenGüncellesil() {
		if (mnOgretmenGüncellesil == null) {
			mnOgretmenGüncellesil = new JMenuItem("\u00D6\u011Fretmen G\u00FCncelle");
			mnOgretmenGüncellesil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new ActionTeacher().setVisible(true);
				}
			});
		}
		return mnOgretmenGüncellesil;
	}
	private JMenuItem getMnEkleSil() {
		if (mnEkleSil == null) {
			mnEkleSil = new JMenuItem("Ekle/Sil");
			mnEkleSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new AddInventory().setVisible(true);
				}
			});
		}
		return mnEkleSil;
	}
	private JMenuItem getMnGüncelle() {
		if (mnGüncelle == null) {
			mnGüncelle = new JMenuItem("G\u00FCncelle");
			mnGüncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
		}
		return mnGüncelle;
	}
	private JButton getBtnGeri() {
		if (btnGeri == null) {
			btnGeri = new JButton("Geri");
			btnGeri.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new MainFrameKatakulle().setVisible(true);
					MainScreen.this.dispose();
				}
			});
			btnGeri.setBounds(692, 0, 99, 37);
		}
		return btnGeri;
	}
}
