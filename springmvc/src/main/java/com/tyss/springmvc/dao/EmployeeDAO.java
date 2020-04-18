package com.tyss.springmvc.dao;

import java.util.List;

import com.tyss.springmvc.beans.EmployeeDetails;
import com.tyss.springmvc.beans.Login;

public interface EmployeeDAO {


	Boolean validateLogin(Login user);

	void add(EmployeeDetails employeeDetails);

	List<EmployeeDetails> list();

	EmployeeDetails get(Integer id);

	void delete(Integer id);

	void edit(EmployeeDetails employeeDetails);
	
}
