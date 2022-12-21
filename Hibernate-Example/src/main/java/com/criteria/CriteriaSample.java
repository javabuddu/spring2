package com.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.util.HibernateUtil;

public class CriteriaSample {

	public static void main(String[] args) {
		// Create Configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		//cr.select(root);
		
	//	cr.select(root).where(cb.gt(root.), 100));
		

		Query<Employee> query = session.createQuery(cr);
		List<Employee> results = query.getResultList();
		for (Employee emp : results) {
			System.out.println(
					"ID====" + emp.getId() + "Emp Name===" + emp.getName() + "Emp salary===" + emp.getSalary());

			/*
			 * //Get All Employees Criteria criteria =
			 * session.createCriteria(Employee.class); List<Employee> empList =
			 * criteria.list(); for(Employee emp : empList){
			 * System.out.println("ID="+emp.getId()+", Zipcode="+emp.getAddress().getZipcode
			 * ()); }
			 */

			/*
			 * Criteria criteria = session.createCriteria(Address.class); List<Address>
			 * addressList = criteria.list(); for(Address address : addressList){
			 * System.out.println("ID="+address.getId()+" AddressLne="+
			 * address.getAddressLine1()+"Zipcode:"+address.getZipcode()+"City:"+address.
			 * getCity()); }
			 */

			/*
			 * // Get with ID, creating new Criteria to remove all the settings criteria =
			 * session.createCriteria(Employee.class) .add(Restrictions.eq("id", new
			 * Long(3))); Employee emp = (Employee) criteria.uniqueResult();
			 * System.out.println("Name=" + emp.getName() + ", City=" +
			 * emp.getAddress().getCity());
			 * 
			 * //Pagination Example empList = session.createCriteria(Employee.class)
			 * .addOrder(Order.desc("id")) .setFirstResult(0) .setMaxResults(2) .list();
			 * for(Employee emp4 : empList){
			 * System.out.println("Paginated Employees::"+emp4.getId()+","+emp4.getAddress()
			 * .getCity()); }
			 * 
			 * //Like example empList = session.createCriteria(Employee.class)
			 * .add(Restrictions.like("name", "%i%")) .list(); for(Employee emp4 : empList){
			 * System.out.println("Employees having 'i' in name::"+emp4.getName()+","+emp4.
			 * getAddress().getCity()); }
			 * 
			 * //Projections example long count = (Long)
			 * session.createCriteria(Employee.class) .setProjection(Projections.rowCount())
			 * .add(Restrictions.like("name", "%i%")) .uniqueResult();
			 * System.out.println("Number of employees with 'i' in name="+count);
			 * 
			 * //using Projections for sum, min, max aggregation functions double sumSalary
			 * = (Double) session.createCriteria(Employee.class)
			 * .setProjection(Projections.sum("salary")) .uniqueResult();
			 * System.out.println("Sum of Salaries="+sumSalary);
			 * 
			 * //Join example for selecting few columns criteria =
			 * session.createCriteria(Employee.class, "employee");
			 * criteria.setFetchMode("employee.address", FetchMode.JOIN);
			 * criteria.createAlias("employee.address", "address"); // inner join by default
			 * 
			 * ProjectionList columns = Projections.projectionList()
			 * .add(Projections.property("name"))
			 * .add(Projections.property("address.city")); criteria.setProjection(columns);
			 * 
			 * List<Object[]> list = criteria.list(); for(Object[] arr : list){
			 * System.out.println(Arrays.toString(arr)); }
			 * 
			 * 
			 * // Rollback transaction to avoid messing test data tx.commit();
			 */
			// closing hibernate resources
			sessionFactory.close();
		}

	}
}