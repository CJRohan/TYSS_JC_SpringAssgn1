package com.tyss.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.springmvc.beans.EmployeeDetails;
import com.tyss.springmvc.beans.Login;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void add(EmployeeDetails employeeDetails) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(employeeDetails);

		entityTransaction.commit();

		entityManager.close();
	}

	@Override
	public List<EmployeeDetails> list() {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TypedQuery<EmployeeDetails> query = entityManager.createQuery("from EmployeeDetails", EmployeeDetails.class);
		List<EmployeeDetails> employeeDetails = query.getResultList();

		entityManager.close();

		return employeeDetails;
	}
	
	@Override
	public EmployeeDetails get(Integer id) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EmployeeDetails employeeDetails = entityManager.find(EmployeeDetails.class, id);

		entityManager.close();

		return employeeDetails;
	}

	@Override
	public void delete(Integer id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Query query = entityManager.createQuery("delete from EmployeeDetails where empid = " + id);
		query.executeUpdate();

		entityTransaction.commit();

		entityManager.close();

	}

	@Override
	public void edit(EmployeeDetails employeeDetails) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Query query = entityManager.createQuery("update EmployeeDetails set name = '" + employeeDetails.getName()
				+ "', mailid = '" + employeeDetails.getMailid() + "', password = '" + employeeDetails.getPassword()
				+ "', dob = '" + employeeDetails.getDob() + "', joined = '" + employeeDetails.getJoined()
				+ "', deptid = '" + employeeDetails.getDeptid() + "', managerid = '" + employeeDetails.getManagerid()
				+ "', designation = '" + employeeDetails.getDesignation() + "', salary = '" + employeeDetails.getSalary()
				+ "', mobile = '" + employeeDetails.getMobile() +"' where empid = '" + employeeDetails.getEmpid() + "'");
		query.executeUpdate();

		entityTransaction.commit();

		entityManager.close();
	}
	
	
	@Override
	public Boolean validateLogin(Login user) {
		return user.getAdmin().equalsIgnoreCase("chandan") && user.getPassword().equalsIgnoreCase("thankyou");
	}

}// End of class
