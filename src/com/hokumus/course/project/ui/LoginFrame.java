package com.hokumus.course.project.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hokumus.course.project.models.CourseUsers;
import com.hokumus.course.project.models.UserRoleTypes;
import com.hokumus.course.project.utils.CourseUtils;
import com.hokumus.course.project.utils.dao.DbServicessBase;

public class LoginFrame extends JFrame{
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JButton btnCancel;
	private JButton btnLogin;
	private JButton btnKatakulle;
	
	public LoginFrame() {
		initialize();
		buttonActionsListener();
	}
	
	private void buttonActionsListener() {
		btnKatakulle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CourseUsers temp = new CourseUsers();
				temp.setUserName("Test");
				temp.setPassword("test");
				temp.setRole(UserRoleTypes.ADMIN);
				CourseUtils.loginedUser = temp;
				new MainFrameKatakulle().setVisible(true);
				
			}
		});
		
	}

	private void initialize() {
		setTitle("Kullanýcý Giriþ Ekraný");
		setSize(400,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTxtUserName());
		getContentPane().add(getTxtPassword());
		getContentPane().add(getBtnCancel());
		getContentPane().add(getBtnLogin());
		txtUserName.setText("hokumus");
		txtPassword.setText("123");
		getContentPane().add(getBtnKatakulle());
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
			lblNewLabel.setBounds(12, 101, 153, 21);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\u015Eifre");
			lblNewLabel_1.setBounds(12, 144, 153, 21);
		}
		return lblNewLabel_1;
	}
	private JTextField getTxtUserName() {
		if (txtUserName == null) {
			txtUserName = new JTextField();
			txtUserName.setBounds(177, 100, 153, 22);
			txtUserName.setColumns(10);
		}
		return txtUserName;
	}
	private JTextField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JTextField();
			txtPassword.setBounds(177, 143, 153, 22);
			txtPassword.setColumns(10);
		}
		return txtPassword;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("\u0130ptal");
			btnCancel.setBounds(61, 206, 99, 25);
		}
		return btnCancel;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Giri\u015F");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<CourseUsers> dao = new DbServicessBase<CourseUsers>();
					CourseUsers temp = new CourseUsers();
					temp.setUserName(txtUserName.getText());
					temp.setPassword(txtPassword.getText());
					List<CourseUsers> liste = dao.search(temp);
					if(liste.size() > 0)
					{
						//JOptionPane.showMessageDialog(LoginFrame.this, "Giriþ Baþarýlý");
						CourseUtils.loginedUser = liste.get(0);
						new MainFrame().setVisible(true);
					}
						
					else {
						JOptionPane.showMessageDialog(LoginFrame.this, "Giriþ Baþarýsýz");
					}
					
				}
			});
			btnLogin.setBounds(231, 206, 99, 25);
		}
		return btnLogin;
	}
	private JButton getBtnKatakulle() {
		if (btnKatakulle == null) {
			btnKatakulle = new JButton("Transit Ge\u00E7i\u015F");
			btnKatakulle.setBounds(61, 244, 272, 25);
		}
		return btnKatakulle;
	}
}
