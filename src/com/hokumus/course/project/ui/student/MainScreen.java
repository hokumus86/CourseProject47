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
  
@SuppressWarnings("serial")
public class MainScreen extends JFrame{ 
	
	private JMenuBar menuBar;
	private JMenu mnOgrenciIslemleri;
	private JMenu mnOgretmenIslemleri;
	private JMenu mnItem;
	private JMenuItem mnOgrenciEkle;
	private JMenuItem mn�tmOgrenciG�ncelleSil;
	private JMenuItem mnOgretmenEkle;
	private JMenuItem mnOgretmenG�ncellesil;
	private JMenuItem mnInventoryEkle;
	private JMenuItem mnStokG�ncelle;
	private JButton btnGeri;
	private JMenuItem mn�tmDemirBa�Ekle;
	private JMenuItem menuItemDemirba�G�ncelle;

	
	
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
			mnOgrenciIslemleri.add(getMn�tmOgrenciG�ncelleSil());
		}
		return mnOgrenciIslemleri;
	}
	private JMenu getMnOgretmenIslemleri() {
		if (mnOgretmenIslemleri == null) {
			mnOgretmenIslemleri = new JMenu("\u00D6\u011Fretmen \u0130\u015Flemleri");
			mnOgretmenIslemleri.add(getMnOgretmenEkle());
			mnOgretmenIslemleri.add(getMnOgretmenG�ncellesil());
		}
		return mnOgretmenIslemleri;
	}
	private JMenu getMnItem() {
		if (mnItem == null) {
			mnItem = new JMenu("Demirba\u015F \u0130\u015Flemleri");
			mnItem.add(getMnInventoryEkle());
			mnItem.add(getMnStokG�ncelle());
			mnItem.add(getMn�tmDemirBa�Ekle());
			mnItem.add(getMenuItemDemirba�G�ncelle());
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
	private JMenuItem getMn�tmOgrenciG�ncelleSil() {
		if (mn�tmOgrenciG�ncelleSil == null) {
			mn�tmOgrenciG�ncelleSil = new JMenuItem("\u00D6\u011Frenci G\u00FCncelle");
			mn�tmOgrenciG�ncelleSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new ActionStudent().setVisible(true);
				}
			});
		}
		return mn�tmOgrenciG�ncelleSil;
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
	private JMenuItem getMnOgretmenG�ncellesil() {
		if (mnOgretmenG�ncellesil == null) {
			mnOgretmenG�ncellesil = new JMenuItem("\u00D6\u011Fretmen G\u00FCncelle");
			mnOgretmenG�ncellesil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new ActionTeacher().setVisible(true);
				}
			});
		}
		return mnOgretmenG�ncellesil;
	}
	private JMenuItem getMnInventoryEkle() {
		if (mnInventoryEkle == null) {
			mnInventoryEkle = new JMenuItem("Stok Ekle/Sil");
			mnInventoryEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new AddInventory().setVisible(true);
				}
			});
		}
		return mnInventoryEkle;
	}
	private JMenuItem getMnStokG�ncelle() {
		if (mnStokG�ncelle == null) {
			mnStokG�ncelle = new JMenuItem("Stok G\u00FCncelle");
			mnStokG�ncelle.setSelected(true);
			mnStokG�ncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				   new ActionInventory().setVisible(true);
				}
			});
		}
		return mnStokG�ncelle;
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

	private JMenuItem getMn�tmDemirBa�Ekle() {
		if (mn�tmDemirBa�Ekle == null) {
			mn�tmDemirBa�Ekle = new JMenuItem("Demirba\u015F Ekle");
			mn�tmDemirBa�Ekle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					   new AddIronHead().setVisible(true);
					}
				});
		}
		return mn�tmDemirBa�Ekle;
	}
	private JMenuItem getMenuItemDemirba�G�ncelle() {
		if (menuItemDemirba�G�ncelle == null) {
			menuItemDemirba�G�ncelle = new JMenuItem("Demirba\u015F G\u00FCncelle");
			menuItemDemirba�G�ncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					   new ActionIronHead().setVisible(true);
					}
				});
		}
		return menuItemDemirba�G�ncelle;
	}
}
