package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import model.*;

@Entity
@Table(name="n_course")
public class Courses {
	@Id
	private String courseid;	
	private String coursename;
	private int creditnumbers;
	
	public Courses() {
		
	}
	public Courses(String courseid, String coursename, int creditnumbers) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.creditnumbers = creditnumbers;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getCreditnumbers() {
		return creditnumbers;
	}
	public void setCreditnumbers(int creditnumbers) {
		this.creditnumbers = creditnumbers;
	}
	

}
