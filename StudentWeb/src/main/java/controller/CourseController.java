package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Courses;
import service.CourseService;

/**
 * Servlet implementation class Course
 */
@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT="course.jsp";
	private static String LIST ="courselist.jsp";
	private CourseService cm;
	String forward="";
	
	public CourseController() {
		super();
		cm = CourseService.getInstance();
	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		Courses cou = new Courses();
		if(action != null && action.trim().equals("edit")){
			forward = INSERT_OR_EDIT;
			String id = request.getParameter("courseid");
			cou = cm.getCourseById(id);
			request.setAttribute("course", cou);
		}else if(action != null && action.trim().equals("delete")){
			String id = request.getParameter("courseid");
			cou = cm.getCourseById(id);
			forward = LIST;
			cm.deleteCourse(id);
			request.setAttribute("courses", cm.getCourses());
		}else if(action != null && action.trim().equals("listcourse")) {
			forward = LIST;
			request.setAttribute("courses", cm.getCourses());
		}else {
			forward = INSERT_OR_EDIT;
		}
		request.getRequestDispatcher(forward).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("courseid");
		Courses cou = new Courses();		
		cou.setCourseid(request.getParameter("courseid"));
		cou.setCoursename(request.getParameter("coursename"));
		cou.setCreditnumbers(Integer.valueOf(request.getParameter("creditnumbers"))); 		
		if(cm.getCourseById(id)!=null && cm.getCourseById(id).getCourseid().equals(id)) {
			cm.updateCourse(cou);
		}else {
			cm.createCourse(cou);
		}
		
		request.setAttribute("courses", cm.getCourses());
		request.getRequestDispatcher(LIST).forward(request, response);
		
	}

}
