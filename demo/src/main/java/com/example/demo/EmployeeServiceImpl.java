package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	List<Employee> al=new ArrayList();
	
	
	@Override
	public Employee save(Employee emp) {
		System.out.println("Employee Id:: "+emp.getEid());
		al.add(emp);
		return emp;
	}
	
	public List<Employee> allEmployee()
	{
		return al;
	}
	
	public Employee getEmployeeBasedOnId(int eid)
	{
		return al.stream().filter(s-> s.getEid()==eid).findFirst().orElseThrow(()-> new RuntimeException("Bhag BC ") );
		
	}

	public boolean deleteEmp(Integer id) {
		Employee employeeBasedOnId = getEmployeeBasedOnId(id);
		boolean remove = al.remove(employeeBasedOnId);
		 return remove;
	}

}
