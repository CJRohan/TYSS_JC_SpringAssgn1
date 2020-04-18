package com.tyss.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springmvc.beans.EmployeeDetails;
import com.tyss.springmvc.beans.Login;
import com.tyss.springmvc.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public void add(EmployeeDetails employeeDetails) {
		dao.add(employeeDetails);
	}

	@Override
	public List<EmployeeDetails> list() {
		return dao.list();
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public void edit(EmployeeDetails employeeDetails) {
		dao.edit(employeeDetails);
	}

	@Override
	public EmployeeDetails get(Integer id) {
		return dao.get(id);
	}
	
	
	
	@Override
	public Boolean validate(Login user) {
		return dao.validateLogin(user);
	}

}// End of class
