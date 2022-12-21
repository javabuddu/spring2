package com.nativesql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.sample.Student;

public class NativeSqlTest {

	public static void main(String[] args) {
		
		// Create Configuration
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");

				SessionFactory sessionFactory = configuration.buildSessionFactory();

				Session session = sessionFactory.openSession();
				Transaction trnx = session.beginTransaction();
				String sql="select * from student";// table ,SQL
				NativeQuery nativeQuery=session.createSQLQuery(sql);
				nativeQuery.addEntity(Student.class);
				List<Student> result=nativeQuery.getResultList();
				
			result.stream().forEach(System.out::println);
				
				
				
				
				trnx.commit();
				

	}

}
