package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {

    
    public AuthFilter() {
       
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String currentURL = req.getRequestURI();
		String targetURL = currentURL.substring(currentURL.indexOf("/", 1), currentURL.length());
		HttpSession session = req.getSession(false);
		if(!targetURL.equals("/login.jsp")) {
			if(session == null || session.getAttribute("user") == null) {
				res.sendRedirect("login.jsp");
				return;
			}
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}