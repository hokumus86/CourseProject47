package com.hokumus.course.project.utils.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hokumus.course.project.models.student.Student;
import com.hokumus.course.project.utils.MyHBUtil;

public class StudentDAO extends DbServicessBase<Student> {
	
	Session ss = MyHBUtil.getSessionFactory().openSession();
	Transaction tt = ss.beginTransaction();
	
	
	public List<Student> searchForGroups(Student temp) {
		List<Student> results ;
		try {
			Criteria cr = ss.createCriteria(temp.getClass());
			cr.add(Restrictions.eq("groups", temp.getGroups()));
			results =cr.list();
			tt.commit();
			return results;
		}
		catch (Exception e) {
			tt.rollback();
			e.printStackTrace();
			return null;
		}
		
		
	}
 
	
}
  