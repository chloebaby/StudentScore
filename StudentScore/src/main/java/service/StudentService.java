package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import DAOImplementation.CourseDAOImplementation;
import DAOImplementation.StudentDAOImplementation;
import interfaceDAO.StudentDAO;
import model.Courses;
import model.Students;

public class StudentService {
	private static StudentService sm = null;
	static {
		if(sm == null) {
			sm = new StudentService();
			sm.setStuDAO(new StudentDAOImplementation());
		}
	}
	StudentDAO stuDAO;
	public StudentDAO getStuDAO() {
		return stuDAO;
	}
	public void setStuDAO(StudentDAO stuDAO) {
		this.stuDAO = stuDAO;
	}
	
	List<Students> studentlist = new ArrayList<Students>();
	
	public static StudentService getInstance() {
		return sm;
	}
	private StudentService() {}
	
	
	public void createStudent(Students stu) {
		stuDAO.createStudent(stu);
	}
	
	public List<Students> getStudents() {
		return stuDAO.getStudents();
	}
	
//	public List<Students> getStudents(int pageNo, int pageSize) {
//		return stuDAO.getStudents(pageNo,pageSize);
//	}
//	
	public Students getStudentById(long id) {
		Students stu = new Students();
		stu = stuDAO.getStudentById(id);
		return stu;
	}
	public void deleteStudent(long id) {
		stuDAO.deleteStudent(id);
	}
	public void updateStudent(Students stu) {
		stuDAO.updateStudent(stu);
	}
	public void exportInfo(String dir) {}
	public void importInfo(String dir) {}
	
	public void sendEmail(List<Students> stulist,String info,String Subject) {
		final String username = "daishshchloe3@gmail.com";
		final String password = "@SHANSHAN830316";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
       
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("daishshchloe3@gmail.com"));
			
			for(Students stu:stulist) {
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(stu.getEmail()));
					message.setSubject(Subject);
					if(info != null) {
						message.setText(info);
						Transport.send(message);
					}
					 				
		 
					System.out.println("Done");
			}			
 
		} catch (MessagingException e) {
			System.out.println("ereeur: " + e.getMessage());
		}
	}
}
