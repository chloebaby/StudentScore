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
import org.hibernate.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImplementation implements StudentDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }
	
	public void createStudent(Students stu) {
		System.out.println(sessionFactory.getCurrentSession()+"***********");
		sessionFactory.getCurrentSession().save(stu);	
	}
	
	public List<Students> getStudents() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Students");
		List<Students> students = (List<Students>)query.list();		
		return students;
		
	}	
	
	public Students getStudentById(long id){
		Students stu = sessionFactory.getCurrentSession().get(Students.class, id);		
		return stu;
	}
	
	public void deleteStudent(long id) {
		Students stu = (Students)sessionFactory.getCurrentSession().get(Students.class, id);
		sessionFactory.getCurrentSession().delete(stu);
	}
	
	public void updateStudent(Students stu) {
		sessionFactory.getCurrentSession().update(stu);		
	}

}
