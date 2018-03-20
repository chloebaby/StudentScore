package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import service.UserService;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService um = UserService.getInstance();	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("action");
		String username = request.getParameter("username");		
		Users user = new Users();			
		user = um.userCheck(username);
		if("login".equals(type)) {			
			if(user != null) {
				String password = request.getParameter("password");
				if(user.getPassword().equals(password)) {
					HttpSession session =  request.getSession(true);
					session.setAttribute("user", user);
					request.getRequestDispatcher("index.jsp").forward(request, response);					
				}else {
					request.setAttribute("faillog1", "The password isn't correct!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}				
			}else {
				request.setAttribute("faillog2", "The username isn't correct!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		if("exit".equals(type)) {
			
			HttpSession session = request.getSession(false);
			if(user != null) {
				session.removeAttribute("user");
				System.out.println("exit success");
				response.sendRedirect("login.jsp");
			}else{
				System.out.println("exit fail");
				request.setAttribute("faileexit", "exit fail!");
				String path = request.getServletPath();
				request.getRequestDispatcher(path).forward(request, response);				
			}			
					
		}

}
}
