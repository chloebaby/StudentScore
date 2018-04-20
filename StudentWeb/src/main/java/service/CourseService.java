package service;

import java.util.ArrayList;
import java.util.List;

import DAOImplementation.CourseDAOImplementation;
import interfaceDAO.CourseDAO;
import model.Courses;

public class CourseService {
	private static CourseService cm = null;
	static {
		if(cm == null) {
			cm = new CourseService();
			cm.setCouDAO(new CourseDAOImplementation());
		}
	}
	CourseDAO couDAO;
	public CourseDAO getCouDAO() {
		return couDAO;
	}
	public void setCouDAO(CourseDAO couDAO) {
		this.couDAO = couDAO;
	}
	
	List<Courses> courselist = new ArrayList<Courses>();
	
	public static CourseService getInstance() {
		return cm;
	}
	private CourseService() {}
	
	
	public void createCourse(Courses cou) {
		couDAO.createCourse(cou);
	}
	
	public List<Courses> getCourses() {
		return couDAO.getCourses();
	}
	
	public List<Courses> getCourses(int pageNo, int pageSize) {
		return couDAO.getCourses(pageNo,pageSize);
	}
	
	public Courses getCourseById(String id) {
		Courses cou = new Courses();
		cou = couDAO.getCourseById(id);		
		return cou;
	}
	public void deleteCourse(String id) {
		couDAO.deleteCourse(id);
	}
	public void updateCourse(Courses cou) {
		couDAO.updateCourse(cou);
	}
	public void exportInfo(String dir) {}
	public void importInfo(String dir) {}

}
