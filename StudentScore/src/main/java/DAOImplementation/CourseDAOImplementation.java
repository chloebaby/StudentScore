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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import interfaceDAO.CourseDAO;
import model.Courses;
import model.Students;
import util.HibernateUtil;

public class CourseDAOImplementation implements CourseDAO{
	
	public CourseDAOImplementation() {
			
		}
	
	public void createCourse(Courses cou) {
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();
		session.save(cou);
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
	}
	
	public List<Courses> getCourses() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from Courses");
		List<Courses> courses = query.list();
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
		return courses;
	}
	
	public List<Courses> getCourses(int pageNo, int pageSize){
		
		return null;
	}

	public Courses getCourseById(String id) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Courses course = (Courses)session.get(Courses.class, id);
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
		return course;
	}

	public void deleteCourse(String id) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Courses course = session.get(Courses.class, id);
		session.delete(course);
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
	}
		
	public void updateCourse(Courses cou) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(cou);
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
	}
	
	/*
	public void exportInfo(String dir) {
		File listperson =  new File(dir);
		List<Courses> exc= new ArrayList<Courses>();
		PrintWriter out=null;
		if(!listperson.exists()) {	
			try {
				out = new PrintWriter(
					  new BufferedWriter(
					  new FileWriter(listperson)));
				exc=findAll();
				for(Courses c:exc) {
				out.print(c.getCourseid()+";"+c.getCoursename()+";"+c.getCreditnumbers()+";"+"\r\n");
				}
			}catch (IOException e) {				
				e.printStackTrace();
			}			
			}
			out.close();
			
	}
	
	public void importInfo(String dir) {
		File listerson = new File(dir);
		char[] flush = new char[2048];
		PreparedStatement preparedStatement=null;
		int len;	
		try {
			Reader fr = new FileReader(listerson);
			if (-1 != (len = fr.read(flush))) {
				String[] str = new String(flush, 0, len).replace("\r\n", "").split(";");
				for (int i = 0; i < str.length; i=i+3) {
					preparedStatement = connection.prepareStatement("insert into courses(courseid,coursename,creditnumbers) values (?,?,?)");
					preparedStatement.setString(1, str[i]);
					preparedStatement.setString(2, str[i+1]);
					preparedStatement.setInt(3, str[i+2]);
					preparedStatement.executeUpdate();
					connection.commit();
					preparedStatement.close();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/



}
