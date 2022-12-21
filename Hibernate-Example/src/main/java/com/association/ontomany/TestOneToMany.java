package com.association.ontomany;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToMany {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		/*BankAC account1 = new BankAC();
		account1.setAccountNumber("123-345-65454");

		BankAC account2 = new BankAC();
		account2.setAccountNumber("123-345-6542222");

		//Add new Employee object
		BusinessMan emp = new BusinessMan();
		emp.setEmail("demo-user@mail.com");
		emp.setFirstName("demo");
		emp.setLastName("user");

		Set<BankAC> accounts = new HashSet();
		accounts.add(account1);
		accounts.add(account2);

		emp.setAccounts(accounts);
		//Save Employee
		session.persist(emp);*/
		
           
            
           // Query query=session.createQuery("from BusinessMan where");
          Query query=session.createQuery("from BusinessMan");
            query.setParameter("id", 4);
            List<BusinessMan> manData=query.list();
          //  BusinessMan manData = (BusinessMan) query.uniqueResult();
         //   System.out.println("Email::::"+manData.getEmail());
           
           manData.stream().forEach((x) -> System.out.println("Email::::"+x.getEmail()));
		
		/*BusinessMan business=session.get(BusinessMan.class, 4);
		System.out.println("name :"+business.getFirstName()+business.getLastName()+"   email :"+business.getEmail());
		Set<BankAC> bankac=business.getAccounts();
		
		bankac.stream().forEach(a->{
			System.out.println("Ac:  "+a.getAccountNumber());
		});*/
		
		tx.commit();

	}

}
