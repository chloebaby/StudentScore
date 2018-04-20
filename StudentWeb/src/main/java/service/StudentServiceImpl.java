package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.StudentDAO;
import model.Students;
@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	@Transactional
	public void addStudent(Students s) {
		studentDAO.addStudent(s);
	}

	@Transactional
	public void updateStudent(Students s) {
		studentDAO.updateStudent(s);
	}

	@Transactional
	public List<Students> listStudents() {		
		return studentDAO.listStudents();
	}

	@Transactional
	public Students getStudentById(int id) {		
		return studentDAO.getStudentById(id);
	}

	@Transactional
	public void removeStudent(int id) {
		studentDAO.removeStudent(id);
	}

}
