package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl empImpl;
	// save the employee
	@PostMapping("/save")
	public Employee save(@RequestBody Employee emp)
	{
		return empImpl.save(emp);
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "Employee Controller running fine";
	}
	@GetMapping("/all")
	public List<Employee> allEmp()
	{
		return empImpl.allEmployee();
	}
	
	@RequestMapping("/get/{id}")
	public Employee getEmployeeBasedOnId(@PathVariable int id)
	{
		return empImpl.getEmployeeBasedOnId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id)
	{
		 boolean deleteEmp = empImpl.deleteEmp(id);
		 String response="";
		 if(deleteEmp)
			 response="Employee with "+id+" deleted Successfully";
		 else
			 response="Not able to delete an employee , Something Went Wrong";
		 return response;
	}
	

}
