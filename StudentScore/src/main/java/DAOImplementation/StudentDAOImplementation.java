package DAOImplementation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import interfaceDAO.StudentDAO;
import model.*;
import util.HibernateUtil;
import org.hibernate.query.*;

public class StudentDAOImplementation implements StudentDAO{
			
	public void createStudent(Students stu) {
		Session session  = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		try {
			if(!tr.isActive()) {
				tr = session.beginTransaction();
			}
			session.save(stu);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tr == null && tr.isActive()) {
				tr.rollback();
			}
		}
	}

	
	public List<Students> getStudents() {
		Session session  = HibernateUtil.getSession();
		session.beginTransaction();	
		Query query = session.createQuery("from Students");
		List<Students> students = (List<Students>)query.list();
		session.getTransaction().commit();
		return students;
		
	}
	
//	public List<Students> getStudents(int pageNo, int pageSize) {
//		
//	}
//
	
	public Students getStudentById(long id){
		Session session  = HibernateUtil.getSession();
		session.beginTransaction();
		Students stu = session.get(Students.class, id);
		session.getTransaction().commit();
		return stu;
	}

	
	public void deleteStudent(long id) {
		Session session  = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		try {
			if(!tr.isActive()) {
				tr = session.beginTransaction();
			}
		Students stu = (Students)session.get(Students.class, id);
		session.delete(stu);
		session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			if(tr == null && tr.isActive()) {
				tr.rollback();
			}
		}
	}

	
	public void updateStudent(Students stu) {
		Session session  = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		try {
			if(!tr.isActive()) {
				tr = session.beginTransaction();	
			}
			session.update(stu);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tr == null && tr.isActive()) {
				tr.rollback();
			}
			
		}
	}

}
