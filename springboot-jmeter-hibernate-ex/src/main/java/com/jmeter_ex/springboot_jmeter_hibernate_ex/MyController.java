package com.jmeter_ex.springboot_jmeter_hibernate_ex;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	EmployeeRepository erepo;
	@RequestMapping("/testing")
	public String testing()
	{
		return "this is JMeter test only";
		// hii
		
	}
	@PostMapping("/post")
	public Employee post(@RequestBody Employee employee)
	{
		return erepo.save(employee);
	}
	@GetMapping("/getbyall")
	public List<Employee> getbyall()
	{
		return erepo.findAll();
	}
	@GetMapping("/getby/{id}")
	public Optional<Employee> getbyid(@PathVariable int id)
	{
		return erepo.findById(id);
	}
	@DeleteMapping("/del/{id}")
	public String del(@PathVariable int id )
	{
		erepo.deleteById(id);
		return "data delete for" +id;
	}
	@PutMapping("/put/{id}")
	public Employee put(@PathVariable int id,@RequestBody  Employee employee)
	{
		Employee emp=erepo.findById(id).get();
		emp.setAge(employee.getAge());
		emp.setCity(employee.getCity());
		emp.setCountry(employee.getCountry());
		emp.setName(employee.getName());
		erepo.save(emp);
		return emp;
	}
	@PatchMapping("/patch/{id}")
	public Employee patch(@PathVariable int id,@RequestBody  Employee employee)
	{
		Employee emp=erepo.findById(id).get();
		emp.setAge(employee.getAge());
		emp.setCity(employee.getCity());
		emp.setCountry(employee.getCountry());
		emp.setName(employee.getName());
		erepo.save(emp);
		return emp;
	}


}
