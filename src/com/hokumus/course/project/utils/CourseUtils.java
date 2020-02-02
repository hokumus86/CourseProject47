package com.hokumus.course.project.utils;

import com.hokumus.course.project.models.CourseUsers;

public class CourseUtils {

	
	public static CourseUsers loginedUser ;
	
	public static String getValue(Object value) {
		if(value==null) 
			return "";
		else 
			return value.toString();
	}
}
