package com.association.onetoone;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToOne {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		AccountEntity account = new AccountEntity();
		// Add new Employee object
				EmployeeEntity emp = new EmployeeEntity();
				emp.setEmail("demo1-user@mail.com");
				emp.setFirstName("RasSridharool");
				emp.setLastName("Sysed");
				emp.setAccount(account);
		account.setAccountNumber("123-345-65454");
		account.setEmployee(emp);
		Transaction tx=session.beginTransaction();
		session.save(emp);
		tx.commit();
		

	}

}
