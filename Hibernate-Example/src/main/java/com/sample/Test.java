package com.sample;

//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		// Create Configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction trnx = session.beginTransaction();
		
		Course course=Course.builder().courseName("Java").fee(3000.0).build();
		Course course1=Course.builder().courseName(".net").fee(5000.0).build();
		//session.save(course);
		//session.save(course1);
		//trnx.commit();
		/*Student stu1 = Student.builder().name("kasim").skill("c++").build();
		session.save(stu1);
		trnx.commit();

		trnx.begin();
		Student stu2 = Student.builder().name("yasin").skill("python").build();
		session.save(stu2);
		trnx.commit();

		trnx.begin();
		Student stu3 = Student.builder().name("rassol").skill("java").build();
		session.save(stu3);
		trnx.commit();

		trnx.begin();
		Student stu4 = Student.builder().name("khaja").skill("c").build();
		session.save(stu4);
		trnx.commit();*/

		/*
		 * trnx.begin(); session.delete(stu4); trnx.commit();
		 */
		//trnx.begin();
		//Student student = session.get(Student.class, 2);// get()- eager , and load(), lazy 
		
		//Student stu5 = Student.builder().name("khaja").skill("c").build();
		//System.out.println("student :"+stu5);
		Student s=session.get(Student.class,8l);// select
		System.out.println("student :"+s);
		//session.evict(s);//
		session.close();
		Session s1=sessionFactory.openSession();
		Student s2=s1.get(Student.class,8l);// select first level cache , session 
		System.out.println("student :"+s2);
		//trnx.commit();

		//session.close();
		
		// persistance and save
		
		// void or object
	}

}
