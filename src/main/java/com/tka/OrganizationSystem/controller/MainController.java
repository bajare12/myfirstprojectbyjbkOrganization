package com.tka.OrganizationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;
import com.tka.OrganizationSystem.service.MainService;

@RestController
@RequestMapping("api")
public class MainController {
	@Autowired
	MainService service;
	
	@PostMapping("addcountry")
	public String addcountry(@RequestBody Country c) {
		
		String msg= service.addcountry(c);
		return msg;
		
	}
	
	@PutMapping("updatecountry/{id}")
	public String updatecountry(@PathVariable int id, @RequestBody Country c)
	{
		String msg=service.updateCountry(id,c);
		return msg;
	}
	
	@DeleteMapping("deletmapping/{id}")
	public String deletePerson(@PathVariable int id)
	{
		String msg= service.deleteRecord(id);	
		return msg;
		
	}
	
	
	@GetMapping("getallrecord")
	public List<Country> getAllRecord() {

		List<Country> list= service.getAllRecord();
		return list;
	
	}
	@PostMapping("addEmployee")
	public String addEmployee(@RequestBody Employee emp) {
		String msg=service.addEmployee(emp);
		return msg;
		
	}
	
	//@("updateEmployee")
	@PutMapping("updateEmployee")
	public String updateEmployee(@RequestBody Employee emp){
		String msg=service.updateEmployee(emp);
		return msg;
		
	}
	
	@DeleteMapping("deleteEmployee")
	public String deleteEmployee(@PathVariable int id) {
	    String msg=service.deleteEmployee(id);
		 return msg;
				
	}
	@GetMapping("getAllEmployee")
	public List<Employee> getAllEmploye() {

		List<Employee> list=service.getAllEmployee();
		return list;
	 	

     }
	 @GetMapping("getPerticularEmployeebyid/{id}")
	   public Employee getPerticularEmployeebyId(@PathVariable int id){
		 Employee emp=service.getPerticularEmployeebyId(id);
		return emp;
		   
	 }
	 @GetMapping("getEmployeebyStatus/status")
	 public List<Employee> getEmployeeByStatus(@PathVariable String status)
	 {
		List <Employee> list=service.getEmployeeByStatus(status);
		return list;
		 
	 }
	 @PostMapping("login")
	 public Employee loginCheck(@RequestBody Employee emp) {
		 Employee employee=service.loginCheck(emp);
		return employee;
		
		 
	 }
	 
	 
}