package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;

public class HqlTest {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.hql.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction trnx = session.beginTransaction();
		
		  String hq = "UPDATE Product set price = :price " + "WHERE id = :id"; 
		  Query query=session.createQuery(hq);
		  query.setParameter("price", 9000l);
		  query.setParameter("id", 3l);
		  int result = query.executeUpdate();
		  System.out.println("Rows affected: " + result);
		 trnx.commit(); 
			/*
			 * trnx.begin(); String hq2= "DELETE FROM Product " + "WHERE id = :id"; Query
			 * query = session.createQuery(hq2); query.setParameter("id", 1); int result =
			 * query.executeUpdate(); System.out.println("Rows affected: " + result);
			 * trnx.commit();
			 */
	}

}
