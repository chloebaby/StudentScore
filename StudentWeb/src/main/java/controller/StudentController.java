package controller;

import java.util.Map;

import org.junit.runner.Request;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import interfaceDAO.StudentDAO;
import model.Students;
import service.StudentService;

@Controller
public class StudentController {
	
	private StudentService stuService;
	@Autowired(required=true)
	@Qualifier("studentService")
	public void setStudentService(StudentService studentService) {
		this.stuService = studentService;
	}
	@ModelAttribute
	public void getStudent(@RequestParam(value="studentid",required=false)Integer id,Map<String,Object> map) {
		if(id != null) {
			Students s = stuService.getStudentById(id);		
			map.put("student", s);
		}		
	}
	@RequestMapping(value="/student",method = RequestMethod.GET)
	public String studentForm(Model model) {
		model.addAttribute("student",new Students());
		return "student";
	}
	@RequestMapping(value="/student", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Students s) {
		stuService.addStudent(s);
		return "redirect:/studentlist";
	}
	@RequestMapping(value="/studentlist", method = RequestMethod.GET)
	public String listStudents(Model model) {
		model.addAttribute("students",stuService.listStudents());
		return "studentlist";
	}
	@RequestMapping(value="/remove/{id}",method=RequestMethod.DELETE)
	public String removeStudent(@PathVariable("id")Integer id) {
		stuService.removeStudent(id);
		return "redirect:/studentlist";
	}
	@RequestMapping("/studentupdate")
	public String updateStudent(Students s) {
		stuService.updateStudent(s);
		return "redirect:/studentlist";
	}
	
	
}
