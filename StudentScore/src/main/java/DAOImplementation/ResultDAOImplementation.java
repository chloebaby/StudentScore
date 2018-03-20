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
import org.hibernate.query.Query;

import interfaceDAO.ResultDAO;

import model.*;
import util.HibernateUtil;

public class ResultDAOImplementation implements ResultDAO{
	public ResultDAOImplementation() {
			
		}
	
	public void createResult(Results res) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(res);
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
	}

	
	public List<Results> getResults() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from Results");
		List<Results> results = (List<Results>)query.list();
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
		return results;
	}
	
	public List<Results> getResults(int pageNo, int pageSize) {
		return null;
	}

	
	public Results getResultById(long sid,String cid) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Students stu = new Students();
		stu.setStudentid(sid);
		Courses cou = new Courses();
		cou.setCourseid(cid);
		Results result = (Results)session.createQuery("from Results where student = :stu and course = :cou")
				.setParameter("stu", stu)
				.setParameter("cou", cou)
				.uniqueResult();
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
		return result;
	}

	
	public void deleteResult(long sid,String cid) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Students stu = new Students();
		stu.setStudentid(sid);
		Courses cou = new Courses();
		cou.setCourseid(cid);
		Query query = session.createQuery("delete Results r where r.student = :stu and r.course = :cou");
		query.setParameter("stu", stu).setParameter("cou", cou);
		query.executeUpdate();
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
	}

	
	public void updateResult(Results res) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(res);
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
	}

}