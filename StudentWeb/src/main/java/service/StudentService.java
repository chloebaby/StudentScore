package service;

import java.util.List;

import model.Students;

public interface StudentService {
	public void addStudent(Students s);
    public void updateStudent(Students s);
    public List<Students> listStudents();
    public Students getStudentById(int id);
    public void removeStudent(int id);
}
