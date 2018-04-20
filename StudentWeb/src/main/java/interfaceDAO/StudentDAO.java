package interfaceDAO;

import java.util.List;

import model.Students;

public interface StudentDAO {
	void createStudent(Students stu);
	List<Students> getStudents();
	//List<Students> getStudents(int pageNo, int pageSize);
	Students getStudentById(long id);
    void deleteStudent(long id);
    void updateStudent(Students s);
    

}
