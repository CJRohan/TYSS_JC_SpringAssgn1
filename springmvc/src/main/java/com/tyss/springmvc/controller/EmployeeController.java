package com.tyss.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tyss.springmvc.beans.Login;
import com.tyss.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/getEmployeeForm")
	public String getSearchEmployeeForm() {		
		return "searchEmp";
	}// End of getSearchEmployeeForm()
	
//	@GetMapping("/getEmployee")
//	public String getEmployee(int empId, ModelMap modelMap) {
//		EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
//		
//		if (employeeInfoBean != null) {
//			modelMap.addAttribute("empInfo", employeeInfoBean);
//		} else {
//			modelMap.addAttribute("errMsg", "Employee Id " + empId + " Not Found!");
//		}
//		
//		return "searchEmp";
//	}
	
	@PostMapping("/login")
	public String login(String admin, String pass, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (service.validate(new Login(admin.trim(),pass.trim()))) {
			session.setAttribute("admin", new Login(admin,pass));
			return "welcome";
		}
				
		request.setAttribute("message", "Invalid Credentials.. Please try again!!!");
		return "login";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/list")
	public String list(HttpServletRequest request){
		request.setAttribute("employees", service.list());
		return "list";		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("admin", null);
		return "login";
	}
	
}// End of controller
