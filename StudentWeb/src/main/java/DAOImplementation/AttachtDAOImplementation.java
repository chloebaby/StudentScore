package DAOImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaceDAO.AttachDAO;
import model.*;

public class AttachtDAOImplementation implements AttachDAO{

	
	public List getAllResult() {
		/*	Connection conn =  null;
		List<Students> allresult = new ArrayList<Students>();	
		ResultSet rs =null;
		Courses cou = null;
		Students stu = null;
		Results res = null;
		String sql = "select s.studentid,lastname,firstname,address,city,email,semester,marks,coursename,creditnumbers from students s join results r on (s.studentid=r.studentid) join courses c on (r.courseid=c.courseid)";
		try {
			conn =  DB.getConn();
			rs=DB.executeQuery(conn, sql);
			while(rs.next()) {
				stu = new Students();
				stu.setStudentid(rs.getLong("studentid"));
				stu.setLastname(rs.getString("lastname"));
				stu.setFirstname(rs.getString("firstname"));
				stu.setAddress(rs.getString("address"));
				stu.setCity(rs.getString("city"));
				stu.setEmail(rs.getString("email"));
				
				cou = new Courses();			
				
				cou.setCoursename(rs.getString("coursename"));
				cou.setCreditnumbers(rs.getInt("creditnumbers"));
//				stu.setCourse(cou);
				
				res = new Results();
				res.setSemester(rs.getInt("semester"));
				res.setMarks(rs.getDouble("marks"));
//				stu.setResults(res);
				allresult.add(stu);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}			
		
		DB.closeRes(rs);
		DB.closeConn(conn);
		return allresult;*/
		return null;
	}

}