package com.hql;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sample.Student;
import com.util.HibernateUtil;

public class HqlTest1 {

	public static void main(String[] args) {
		//Prep work
				//SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				//Session session = sessionFactory.openSession();
		
		         // Create Configuration
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");

				SessionFactory sessionFactory = configuration.buildSessionFactory();

				Session session = sessionFactory.openSession();
				
				//HQL example - Get All Employees
				Transaction tx = session.beginTransaction();
				String hql1="from Student";
				Query query = session.createQuery(hql1);
				List<Student> stuList=new ArrayList();
		
				//query.setpa
				/*
				 * stuList = query.list(); for(Student stu : stuList){
				 * System.out.println("List of Student::"+stu.getId()+","+stu.getName()+stu.
				 * getSkill()); }
				 */
				 
				
				//HQL example - Get Employee with id
				/*query = session.createQuery("from Student where id= ?0");// place holder, named parameter 
				//query.setLong("id", 1);
				query.setParameter(0, 1l);
				Student stu = (Student) query.uniqueResult();
				System.out.println("Student::"+stu.getId()+"==="+stu.getName()+"==="+stu.getSkill());
				
					//HQL pagination example
				query = session.createQuery("from Student");
				query.setFirstResult(0); //starts with 0
				//query.setFetchSize(10);// query.setMaxResults(0)
				query.setMaxResults(10);
				stuList = query.list();
				for(Student stu : stuList){
					System.out.println("Student pagination ::"+stu.getId()+"==="+stu.getName()+"==="+stu.getSkill());
				}
				
				//HQL Update Employee
				query = session.createQuery("update Student set name = :name where id = :id");
				query.setParameter("name", "Pankaj Kumar");
				query.setLong("id", 10l);
				int result = query.executeUpdate();
				System.out.println("Student Update Status="+result);

				//HQL Delete Employee, we need to take care of foreign key constraints too
				query = session.createQuery("delete from Student where id= :id");
				query.setLong("id", 4);
				int result = query.executeUpdate();
				System.out.println("Student Delete Status="+result);
				
				query = session.createQuery("delete from Employee where id= :id");
				query.setLong("id", 4);
				result = query.executeUpdate();
				System.out.println("Employee Delete Status="+result);*/
				
					//HQL Aggregate function examples
				query = session.createQuery("select count(id) from Student");
				long countOfEmp = (Long) query.uniqueResult();
				System.out.println("count of students= "+countOfEmp);
				
				/*	//HQL join examples
				query = session.createQuery("select e.name, a.city from Employee e "
						+ "INNER JOIN e.address a");
				List<Object[]> list = query.list();
				for(Object[] arr : list){
					System.out.println(Arrays.toString(arr));
				}
				
				//HQL group by and like example
				query = session.createQuery("select e.name, sum(e.salary), count(e)"
						+ " from Employee e where e.name like '%i%' group by e.name");
				List<Object[]> groupList = query.list();
				for(Object[] arr : groupList){
					System.out.println(Arrays.toString(arr));
				}
				
				//HQL order by example
				query = session.createQuery("from Employee e order by e.id desc");
				empList = query.list();
				for(Employee emp3 : empList){
					System.out.println("ID Desc Order Employee::"+emp3.getId()+","+emp3.getAddress().getCity());
				}
				*/
				//rolling back to save the test data
				tx.commit();
				//tx.rollback();
				
				//closing hibernate resources
				sessionFactory.close();
	}

}
