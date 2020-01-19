package com.hokumus.course.project.main;

import com.hokumus.course.project.models.CourseUsers;
import com.hokumus.course.project.utils.dao.DbServicessBase;

public class Runner {
	
	public static void main(String[] args) {
		DbServicessBase<CourseUsers> dao = new DbServicessBase<CourseUsers>();
		dao.getAllRows(new CourseUsers());
	}

}
