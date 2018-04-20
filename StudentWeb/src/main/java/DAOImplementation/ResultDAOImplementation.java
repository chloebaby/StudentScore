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
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import interfaceDAO.ResultDAO;

import model.*;

public class ResultDAOImplementation implements ResultDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }
	
	public ResultDAOImplementation() {
			
		}
	
	public void createResult(Results res) {
		sessionFactory.getCurrentSession().save(res);
			
	}
	public List<Results> getResults() {		
		Query query = sessionFactory.getCurrentSession().createQuery("from Results");
		List<Results> results = (List<Results>)query.list();		
		return results;
	}
	
	public List<Results> getResults(int pageNo, int pageSize) {
		return null;
	}
	public Results getResultById(int sid,String cid) {
		Students stu = new Students();
		stu.setStudentid(sid);
		Courses cou = new Courses();
		cou.setCourseid(cid);
		Results result = (Results)sessionFactory.getCurrentSession().createQuery("from Results where student = :stu and course = :cou")
				.setParameter("stu", stu)
				.setParameter("cou", cou)
				.uniqueResult();	
		return result;
	}
	public void deleteResult(int sid,String cid) {
		Students stu = new Students();
		stu.setStudentid(sid);
		Courses cou = new Courses();
		cou.setCourseid(cid);
		Query query = sessionFactory.getCurrentSession().createQuery("delete Results r where r.student = :stu and r.course = :cou");
		query.setParameter("stu", stu).setParameter("cou", cou);
		query.executeUpdate();
	}

	
	public void updateResult(Results res) {
		sessionFactory.getCurrentSession().update(res);
			
	}
		

}