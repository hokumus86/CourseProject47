package com.hokumus.course.project.main;

import com.hokumus.course.project.models.CourseUsers;
import com.hokumus.course.project.utils.dao.DbServicessBase;

public class Runner {
	
	public static void main(String[] args) {
		//Utku
		//heo7
		//halilerkan�zcan
		//Omer Faruk
		//k�bra
		// Kalk�n Ey Ehl_i Vatan Dediler, Kalkt�k; Herkes Oturdu Biz Ayakta Kald�k./B.KUS
		//samet was here
		//Bi commit
		//yasin
		DbServicessBase<CourseUsers> dao = new DbServicessBase<CourseUsers>();
		dao.getAllRows(new CourseUsers());
	}

}
