package test;

import java.sql.Timestamp;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.jupiter.api.Test;




class TestStudent {
	private static SessionFactory sf;
	
	@Test
	public  void testSchema() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
 
	}
	/*
	@Test
	public void testSave() {
		sf = HibernateUtil.getSessionFactory();
		Students stu = new Students();
		stu.setLastname("a");
		stu.setLastname("b");
		stu.setAddress("saint-croix");
		stu.setCity("montreal");
		stu.setEmail("@222.com");
		
		Courses cou = new Courses();
		cou.setCourseid("AAAAAAA");
		cou.setCoursename("JAVA");
		cou.setCreditnumbers(4);
		
		Results res = new Results();
		res.setMarks(66);
		res.setSemester(102);
		res.setCreationdate(new Timestamp(System.currentTimeMillis()));
		
		Set<Courses> courses = new HashSet<Courses>();
		courses.add(cou);
		stu.setCourses(courses);
		
		Set<Results> results = new HashSet<Results>();
		results.add(res);
		stu.setResults(results);
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(stu);
		tx.commit();
		session.close();
		sf.close();
	}*/
}
