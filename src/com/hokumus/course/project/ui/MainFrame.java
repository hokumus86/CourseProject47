package com.hokumus.course.project.ui;

import javax.swing.JFrame;

import com.hokumus.course.project.models.UserRoleTypes;
import com.hokumus.course.project.utils.CourseUtils;

import javax.swing.JButton;

public class MainFrame extends JFrame {
	private JButton btnUserMngmt;
	private JButton btnTanmlamaModl;
	private JButton btnYnetimModl;
	private JButton btndevGrev;
	private JButton btnMuhasebeModl;
	private JButton btnInsanKaynaklarModl;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;

	public MainFrame() {
		initialize();
	}

	private void initialize() {
		setTitle("Dersane Projesi Ana Ekran   -" + CourseUtils.loginedUser.getUserName() + " - "
				+ CourseUtils.loginedUser.getRole());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnUserMngmt());
		getContentPane().add(getBtnTanmlamaModl());
		getContentPane().add(getBtnYnetimModl());
		getContentPane().add(getBtndevGrev());
		getContentPane().add(getBtnMuhasebeModl());
		getContentPane().add(getBtnInsanKaynaklarModl());
		getContentPane().add(getButton_5());
		getContentPane().add(getButton_6());
		getContentPane().add(getButton_7());
		setSize(857, 610);
		switch (CourseUtils.loginedUser.getRole()) {
		case ADMIN:

			break;

		case GENERAL_MANAGER:
			btnUserMngmt.setEnabled(false);

			break;
			
		case TEACHER:

			btnUserMngmt.setEnabled(false);
			btnInsanKaynaklarModl.setEnabled(false);
			btnTanmlamaModl.setEnabled(false);
			btnMuhasebeModl.setEnabled(false);
			btnYnetimModl.setEnabled(false);
			break;
			
		case STUDENT:

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

	private JButton getBtnUserMngmt() {
		if (btnUserMngmt == null) {
			btnUserMngmt = new JButton("Kullan\u0131c\u0131 Y\u00F6netimi");
			btnUserMngmt.setBounds(24, 13, 239, 128);
		}
		return btnUserMngmt;
	}

	private JButton getBtnTanmlamaModl() {
		if (btnTanmlamaModl == null) {
			btnTanmlamaModl = new JButton("Tan\u0131mlama Mod\u00FCl\u00FC");
			btnTanmlamaModl.setBounds(325, 13, 239, 128);
		}
		return btnTanmlamaModl;
	}

	private JButton getBtnYnetimModl() {
		if (btnYnetimModl == null) {
			btnYnetimModl = new JButton("Y\u00F6netim Mod\u00FCl\u00FC");
			btnYnetimModl.setBounds(580, 13, 239, 128);
		}
		return btnYnetimModl;
	}

	private JButton getBtndevGrev() {
		if (btndevGrev == null) {
			btndevGrev = new JButton("\u00D6dev G\u00F6rev");
			btndevGrev.setBounds(580, 175, 239, 128);
		}
		return btndevGrev;
	}

	private JButton getBtnMuhasebeModl() {
		if (btnMuhasebeModl == null) {
			btnMuhasebeModl = new JButton("Muhasebe Mod\u00FCl\u00FC");
			btnMuhasebeModl.setBounds(325, 175, 239, 128);
		}
		return btnMuhasebeModl;
	}

	private JButton getBtnInsanKaynaklarModl() {
		if (btnInsanKaynaklarModl == null) {
			btnInsanKaynaklarModl = new JButton("\u0130nsan Kaynaklar\u0131 Mod\u00FCl\u00FC");
			btnInsanKaynaklarModl.setBounds(24, 175, 239, 128);
		}
		return btnInsanKaynaklarModl;
	}

	private JButton getButton_5() {
		if (button_5 == null) {
			button_5 = new JButton("New button");
			button_5.setBounds(580, 338, 239, 128);
		}
		return button_5;
	}

	private JButton getButton_6() {
		if (button_6 == null) {
			button_6 = new JButton("New button");
			button_6.setBounds(325, 338, 239, 128);
		}
		return button_6;
	}

	private JButton getButton_7() {
		if (button_7 == null) {
			button_7 = new JButton("New button");
			button_7.setBounds(24, 338, 239, 128);
		}
		return button_7;
	}
}
