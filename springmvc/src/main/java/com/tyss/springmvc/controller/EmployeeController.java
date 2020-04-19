package com.tyss.springmvc.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tyss.springmvc.beans.EmployeeDetails;
import com.tyss.springmvc.beans.Login;
import com.tyss.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/login")
	public String login(String admin, String pass, HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (service.validate(new Login(admin.trim(), pass.trim()))) {
			session.setAttribute("admin", new Login(admin, pass));
			return "welcome";
		}

		request.setAttribute("message", "Invalid Credentials.. Please try again!!!");
		return "login";
	}

	@GetMapping("/welcome")
	public String welcome(String id, HttpServletRequest req) {
		if (id != null) {
			EmployeeDetails employeeDetails = null;
			try {
				employeeDetails = service.get(Integer.parseInt(id));
			} catch (Exception e) {
				req.setAttribute("message", "Enter a number please");
				return "welcome";
			}
			if (employeeDetails == null) {
				req.setAttribute("message", "ID does not exist");
				return "welcome";
			}
			req.setAttribute("employee", employeeDetails);
		}
		return "welcome";
	}

	@GetMapping("/list")
	public String list(String id, HttpServletRequest request) {
		if (id != null) {
			service.delete(Integer.parseInt(id));
		}
		request.setAttribute("employees", service.list());
		return "list";
	}

	@PostMapping("/add")
	public String add(String id, String name, String password, String mail, String dob, String joined, String deptid,
			String managerid, String designation, String salary, String mobile, String action, HttpServletRequest req) {
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName(name);
		employeeDetails.setMailid(mail);
		employeeDetails.setDob(LocalDate.parse(dob));
		employeeDetails.setJoined(LocalDate.parse(joined));
		employeeDetails.setManagerid(managerid);
		employeeDetails.setDeptid(deptid);
		employeeDetails.setDesignation(designation);
		employeeDetails.setMobile(mobile);
		employeeDetails.setSalary(salary);
		employeeDetails.setPassword(password);
		if (id == "") {
			service.add(employeeDetails);
			req.setAttribute("message", "Employee Added succesfully!!!");
		} else if (action != null || "edit".equals(action)) {
			req.setAttribute("id", id);
			req.setAttribute("password", password);
			req.setAttribute("name", name);
			req.setAttribute("mail", mail);
			req.setAttribute("dob", dob);
			req.setAttribute("joined", joined);
			req.setAttribute("deptid", deptid);
			req.setAttribute("managerid", managerid);
			req.setAttribute("designation", designation);
			req.setAttribute("salary", salary);
			req.setAttribute("mobile", mobile);		
		} else {
			employeeDetails.setEmpid(Integer.parseInt(id));
			service.edit(employeeDetails);
			req.setAttribute("message", "Employee Updated succesfully! *Add a new employee*");
		}
		return "add";
	}

	@GetMapping("/add")
	public String add() {
		return "add";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("admin", null);
		return "login";
	}

}// End of controller
