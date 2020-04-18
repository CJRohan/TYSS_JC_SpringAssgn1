package com.tyss.springmvc.service;

import java.util.List;

import com.tyss.springmvc.beans.EmployeeDetails;
import com.tyss.springmvc.beans.Login;

public interface EmployeeService {


	Boolean validate(Login user);

	void add(EmployeeDetails employeeDetails);

	List<EmployeeDetails> list();

	void delete(Integer id);

	void edit(EmployeeDetails employeeDetails);

	EmployeeDetails get(Integer id);
	
}
