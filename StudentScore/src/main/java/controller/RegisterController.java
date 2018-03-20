package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Results;
import service.UserService;
import model.*;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action");
		String username = "";
		String password1 = "";
		String password2 = "";
		username=request.getParameter("username");
		password1 = request.getParameter("password1");
		password2 = request.getParameter("password2");
		UserService um = UserService.getInstance();				
		String forward = "";
		HttpSession session = request.getSession();
		if(action != null && !action.equals("") && action.trim().equals("register")) {			
			if(username != null && !username.equals("")) {
				if(um.userCheck(username) == null ) {
					if(password1 != null && password2 !=null && !password1.equals("") && !password2.equals("") ) {
						if(password1.equals(password2)) {
							Users user = new Users();
							user.setUsername(username);
							user.setPassword(password1);
							um.createUser(user);
						}else {
							forward = "register.jsp";
							request.setAttribute("fail1", "Passwords are not same, please try again!");
							request.getRequestDispatcher(forward).forward(request, response);
							return;
							
						}
					}else {
						forward = "register.jsp";
						request.setAttribute("fail2", "Passwrod mustn't empty!");
						request.getRequestDispatcher(forward).forward(request, response);
						return;
					}
				}else {
					forward = "register.jsp";
					request.setAttribute("fail3", "This username has existed!");
					request.getRequestDispatcher(forward).forward(request, response);
					return;
				}
			}else{
				forward = "register.jsp";
				request.setAttribute("fail4", "Please input username!");
				request.getRequestDispatcher(forward).forward(request, response);
				return;
			}
			
		}
		
		if(action != null && !action.equals("") && action.trim().equals("modify")) {			
			if(username != null && !username.equals("")) {
				if(um.userCheck(username) != null ) {
					if(password1 != null && password2 !=null && !password1.equals("") && !password2.equals("") ) {
						if(password1.equals(password2)) {
							Users user = new Users();
							user.setUsername(username);
							user.setPassword(password1);							
							um.updateUser(user);
						}else {
							forward = "personalinfo.jsp";
							request.setAttribute("fail1", "Passwords are not same, please try again!");
							request.getRequestDispatcher(forward).forward(request, response);
							return;
							
						}
					}else {
						forward = "personalinfo.jsp";
						request.setAttribute("fail2", "Passwrod mustn't empty!");
						request.getRequestDispatcher(forward).forward(request, response);
						return;
					}
				}else {
					forward = "personalinfo.jsp";
					request.setAttribute("fail3", "This username isn't existed!");
					request.getRequestDispatcher(forward).forward(request, response);
					return;
				}
			}else{
				forward = "personalinfo.jsp";
				request.setAttribute("fail4", "Username is invalid!");
				request.getRequestDispatcher(forward).forward(request, response);
				return;
			}
			
		}
		forward = "login.jsp";	
		response.sendRedirect(forward);
	}

}
