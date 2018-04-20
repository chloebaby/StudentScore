package dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Students;
@Repository
public class StudentDAOImpl implements StudentDAO {
	
	private SessionFactory sessionfactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionfactory = sf;
	}
	@Override
	public void addStudent(Students s) {
		Session session = this.sessionfactory.getCurrentSession();
		session.save(s);

	}

	@Override
	public void updateStudent(Students s) {
		Session session = this.sessionfactory.getCurrentSession();
		session.update(s);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Students> listStudents() {
		Session session = this.sessionfactory.getCurrentSession();
		List<Students> studentlis = session.createQuery("from Students").list();
		return studentlis;
	}

	@Override
	public Students getStudentById(int id) {
		Session session = this.sessionfactory.getCurrentSession();
		Students s = session.load(Students.class, id);
		return s;
	}

	@Override
	public void removeStudent(int id) {
		Session session = this.sessionfactory.getCurrentSession();
		Students s = session.get(Students.class, id);		
		if(null != s) {
			System.out.println("************"+s.getStudentid());
			session.delete(s);
		}
	}

}
