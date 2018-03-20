package DAOImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import interfaceDAO.UserDAO;
import model.*;
import util.HibernateUtil;

public class UserDAOImplementation implements UserDAO{
	
	
	public void createUser(Users u) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
	}

	
	public void deleteUser(String name) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Users u = session.get(Users.class, name);
		session.delete(u);
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
	}

	
	public void updateUser(Users u) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(u);
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
	}
	
	public Users userCheck(String name) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Users u =session.get(Users.class, name);
		session.getTransaction().commit();
		HibernateUtil.getSession().close();
		return u;
	}

}
