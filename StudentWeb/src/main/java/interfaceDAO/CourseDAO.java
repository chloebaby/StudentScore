package interfaceDAO;

import java.util.List;

import model.Courses;

public interface CourseDAO {
	void createCourse(Courses c);
	List<Courses> getCourses();
	List<Courses> getCourses(int pageNo, int pageSize);
	Courses getCourseById(String id);
    void deleteCourse(String id);
    void updateCourse(Courses cou);

}
