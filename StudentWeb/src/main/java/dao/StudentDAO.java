package dao;

import java.util.List;

import model.Students;

public interface StudentDAO {
	public void addStudent(Students s);
    public void updateStudent(Students s);
    public List<Students> listStudents();
    public Students getStudentById(int id);
    public void removeStudent(int id);
}
