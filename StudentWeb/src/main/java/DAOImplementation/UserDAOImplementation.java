package DAOImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import interfaceDAO.UserDAO;
import model.*;

public class UserDAOImplementation implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }
	
	public void createUser(Users u) {
		sessionFactory.getCurrentSession().save(u);
	}

	
	public void deleteUser(String name) {
		Users u = sessionFactory.getCurrentSession().get(Users.class, name);
		sessionFactory.getCurrentSession().delete(u);
	}

	
	public void updateUser(Users u) {
		sessionFactory.getCurrentSession().update(u);
	}
	
	public Users userCheck(String name) {
		Users u =sessionFactory.getCurrentSession().get(Users.class, name);
		sessionFactory.getCurrentSession().getTransaction().commit();
		return u;
	}

}
