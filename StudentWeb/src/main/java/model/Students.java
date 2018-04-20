package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="w_student")
public class Students {	
	private int studentid;
	private String lastname;
	private String firstname;
	private String address;
	private String city;
	private String email;
	
	private Set<Courses> courses = new HashSet<Courses>();	
	private Set<Results> results = new HashSet<Results>();
	
	@ManyToMany(cascade=CascadeType.ALL)	
	@JoinTable(name="w_result",
			joinColumns= {@JoinColumn(name="student_id",referencedColumnName="studentid")},
			inverseJoinColumns={@JoinColumn(name="course_id",referencedColumnName="courseid")})
	public Set<Courses> getCourses() {
		return courses;
	}
	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
	public Set<Results> getResults() {
		return results;
	}
	public void setResults(Set<Results> results) {
		this.results = results;
	}
	public Students() {
		
	}
	public Students(int studentid, String lastname, String firstname, String address, String city,String email) {
		super();
		this.studentid = studentid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.address = address;
		this.city = city;
		this.email=email;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
