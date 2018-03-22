package test;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import DAOImplementation.CourseDAOImplementation;
import DAOImplementation.ResultDAOImplementation;
import DAOImplementation.StudentDAOImplementation;
import model.*;

public class TestResult {

	public static void main(String[] args) {
		Students stu = new Students();
		stu.setLastname("a");
		stu.setLastname("b");
		stu.setAddress("saint-croix");
		stu.setCity("montreal");
		stu.setEmail("@222.com");
		
		
		Courses cou = new Courses();
		cou.setCourseid("AAAAAAA");
		cou.setCoursename("JAVA");
		cou.setCreditnumbers(4);
		
		Results res = new Results();
		res.setMarks(66);
		res.setSemester(102);
		res.setCreationdate(new Timestamp(System.currentTimeMillis()));
		
		Set<Courses> courses = new HashSet<Courses>();
		courses.add(cou);
		stu.setCourses(courses);
		
		
		Set<Results> results = new HashSet<Results>();
		results.add(res);
		stu.setResults(results);
		
		Set<Students> students = new HashSet<Students>();
		students.add(stu);
		res.setCourse(cou);
		res.setStudent(stu);
		

		StudentDAOImplementation sDAOI = new StudentDAOImplementation();
		sDAOI.createStudent(stu);
		System.out.println("*********************"+res.getCreationdate());
		
		CourseDAOImplementation cDAOI = new CourseDAOImplementation();
		cDAOI.createCourse(cou);		
		
		ResultDAOImplementation rDAOI = new ResultDAOImplementation();		
		rDAOI.createResult(res);
		
		Results r = rDAOI.getResultById(res.getStudent().getStudentid(), res.getCourse().getCourseid());

		
		System.out.println("*********************"+r.getCreationdate());

	}

}
