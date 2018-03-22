package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import service.CourseService;
import service.ResultService;
import service.StudentService;


@WebServlet("/ResultController")
public class ResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT="result.jsp";
	private static String LIST ="resultlist.jsp";
	private ResultService rm;
	private StudentService sm;
	private CourseService cm;
	String forward="";
	
	public ResultController() {
		super();
		rm = ResultService.getInstance();
		sm = StudentService.getInstance();
		cm = CourseService.getInstance();
	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		Results res = new Results();
		if(action != null && action.trim().equals("edit")){
			forward = INSERT_OR_EDIT;
			long sid = Long.valueOf(request.getParameter("studentid"));
			String cid = request.getParameter("courseid");
			res = rm.getResultById(sid, cid);
			request.setAttribute("result", res);
			request.setAttribute("students", sm.getStudents());
			request.setAttribute("courses", cm.getCourses());
		}else if(action != null && action.trim().equals("delete")){
			long sid = Long.valueOf(request.getParameter("studentid"));
			String cid = request.getParameter("courseid");
			res = rm.getResultById(sid, cid);
			forward = LIST;
			rm.deleteResult(sid, cid);
			request.setAttribute("results", rm.getResults());
		}else if(action != null && action.trim().equals("listresult")) {
			forward = LIST;
			request.setAttribute("results", rm.getResults());
			
		}else {
			forward = INSERT_OR_EDIT;
			request.setAttribute("students", sm.getStudents());
			request.setAttribute("courses", cm.getCourses());
		}
		request.getRequestDispatcher(forward).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("studentid");
		String cid = request.getParameter("courseid");
		Results res = new Results();
		Students stu = new Students();
		Courses cou = new Courses();		
		stu.setStudentid(Long.valueOf(sid));
		cou.setCourseid(cid);		
		res.setStudent(stu);
		res.setCourse(cou);
		res.setSemester(Integer.valueOf(request.getParameter("semester")));
		res.setMarks(Double.valueOf(request.getParameter("marks")));
		String creationdate = request.getParameter("creationdate");
		creationdate = creationdate.replace("T", "");
		StringBuffer sb = new StringBuffer(); 
		creationdate = sb.append(creationdate).insert(10," ").append(":00").toString();
		res.setCreationdate(Timestamp.valueOf(creationdate));
		if(sid !=null && !sid.trim().equals("") && cid !=null && cid.trim().equals("")) {
			rm.updateResult(res);
		}else {
			rm.createResult(res);
		}
		
		request.setAttribute("results", rm.getResults());		
		request.getRequestDispatcher(LIST).forward(request, response);
		
	}

}
