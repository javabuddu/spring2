package com.nativesql;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.Student;

public class NamedQuery {

	public static void main(String[] args) {
		
		// Create Configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		
		TypedQuery query = session.getNamedQuery("findAll");    
		//query.setParameter("fullName","Hibernate");   
		List<Student> ibEmployees = query.getResultList();
		
		ibEmployees.stream().forEach(System.out::println);
	
		

	}

}
