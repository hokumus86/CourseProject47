package com.hokumus.course.project.main;

import com.hokumus.course.project.models.CourseUsers;
import com.hokumus.course.project.models.UserRoleTypes;
import com.hokumus.course.project.ui.LoginFrame;
import com.hokumus.course.project.utils.dao.DbServicessBase;

public class Runner {

	public static void main(String[] args) {
//		DbServicessBase<CourseUsers> dao = new DbServicessBase<CourseUsers>();
//		
//		CourseUsers temp = new CourseUsers();
//		temp.setUserName("hokumus");
//		temp.setPassword("123");
//		temp.setRole(UserRoleTypes.ADMIN);
//		dao.save(temp);

		new LoginFrame().setVisible(true);
	}

}
