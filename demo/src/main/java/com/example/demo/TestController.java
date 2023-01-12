package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.jsf.FacesContextUtils;

@Controller
@ResponseBody
public class TestController {

	@GetMapping("/test")
	public String test()
	{
		return "Hello Controller";
	}
	@GetMapping("/emp/{id}/{name}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id, @PathVariable String name)
	{
		Employee e=new Employee(id, name, "iampranav12@gmail.com");
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
	@GetMapping("/param")
	public Employee getPath(@RequestParam String name, @RequestParam(required = false) String email)
	{
		Employee e=new Employee(101, name, email);
		return e;
	}

	

}

