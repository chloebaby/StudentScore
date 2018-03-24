package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Students;
import service.StudentService;


/**
 * Servlet implementation class Course
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT="student.jsp";
	private static String LIST ="studentlist.jsp";
	private StudentService sm;
	String forward="";
	
	public StudentController() {
		super();
		sm = StudentService.getInstance();
	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");		
		Students stu = new Students();
		if(action != null && action.trim().equals("edit")){
			forward = INSERT_OR_EDIT;
			long id = Long.valueOf(request.getParameter("studentid"));
			stu = sm.getStudentById(id);
			request.setAttribute("student", stu);
			request.getRequestDispatcher(forward).forward(request, response);
		}else if(action != null && action.trim().equals("delete")){
			long id = Long.valueOf(request.getParameter("studentid"));
			stu = sm.getStudentById(id);
			forward = LIST;
			sm.deleteStudent(id);
			request.setAttribute("students", sm.getStudents());
			request.getRequestDispatcher(forward).forward(request, response);
		}else if(action != null && action.trim().equals("liststudent")) {
			forward = LIST;
			request.setAttribute("students", sm.getStudents());
			request.getRequestDispatcher(forward).forward(request, response);
		}else if(action != null && action.trim().equals("send")) {
			String temp =request.getParameter("sendmess");
			forward = LIST;
			String info = "";
			String subTitle="";
			info = request.getParameter("message");
			subTitle = request.getParameter("subtitle");
			sm.sendEmail(sm.getStudents(),info,subTitle);
			response.sendRedirect(forward);
		}
		else {
			forward = INSERT_OR_EDIT;
			request.getRequestDispatcher(forward).forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String stuid = request.getParameter("studentid");
		Students stu = new Students();
		stu.setLastname(request.getParameter("lastname"));;
		stu.setFirstname(request.getParameter("firstname")); 
		stu.setAddress(request.getParameter("address"));
		stu.setCity(request.getParameter("city"));
		stu.setEmail(request.getParameter("email"));
		if(stuid != null && !stuid.trim().equals("")) {
			long id = Long.valueOf(stuid);
			stu.setStudentid(id);
			sm.updateStudent(stu);
		}else {
			sm.createStudent(stu);
		}
		
		request.setAttribute("students", sm.getStudents());
		request.getRequestDispatcher(LIST).forward(request, response);
		
	}

}
