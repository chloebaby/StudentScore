package model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="w_result")
public class Results {
	private int id;
	private int semester;
	private double marks;
	private Timestamp creationdate;
	private Students student;
	private Courses course;
	public Results() {}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(columnDefinition="int default 0") 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne()
	@JoinColumn(name="student_id")
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
	@ManyToOne
	@JoinColumn(name="course_id")
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	
	
	public Results(long studentid, String courseid, int semester, double marks, Timestamp creationdate) {
		super();		
		this.semester = semester;
		this.marks = marks;
		this.creationdate = creationdate;
	}
	
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Column(columnDefinition="timestamp")
	public Timestamp getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Timestamp creationdate) {
		this.creationdate = creationdate;
	}
}
