package listener;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {
	
	
    public ContextListener() {
    }

	
    public void contextDestroyed(ServletContextEvent event)  { 
    }

	
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext sc = event.getServletContext();
    	
    	String custServEmail = sc.getInitParameter("custServEmail");
    	sc.setAttribute("custServEmail",custServEmail);
    	
    	GregorianCalendar currentDate = new GregorianCalendar();
    	int currentYear = currentDate.get(Calendar.YEAR);
    	sc.setAttribute("currentYear", currentYear);
    	
    	//export
    	String productsPath = sc.getRealPath("/WEB-INF/students.txt");
    	sc.setAttribute("productsPath", productsPath);
    	
    	
    }
	
}
