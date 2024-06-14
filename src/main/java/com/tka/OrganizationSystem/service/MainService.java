package com.tka.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tka.OrganizationSystem.dao.MainDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class MainService {
	@Autowired
	MainDao dao;
	
	public String addcountry(Country c)
	{
		String msg=dao.addCountry(c);
				if(Objects.isNull(msg))
				{
					msg="Country is added";
				}
				return msg;
	}

	public String updateCountry(int id, Country c) {
		String msg=dao.updateCountry(id,c);
	
		return msg;
	}

	public String deleteRecord(int id) {
		String msg= dao.deleteRecord(id);
		return msg;
		
	}

	public List<Country> getAllRecord() {
			List<Country> list= dao.getAllRecord();
			return list;

	}

	public String addEmployee(Employee emp) {
		String msg=dao.addEmployee(emp);
		if(Objects.isNull(msg))
		{
			msg="Employee is added";
		}
		return msg;
	}

	public String updateEmployee(Employee emp) {
		String msg= dao.updateEmployee(emp);
		if(Objects.isNull(msg))
		{
			msg="Employee is added";
		}
		return msg;
	}

	public String deleteEmployee(int id) {
		
		String msg= dao.deleteEmployee(id);
		if(Objects.isNull(msg))
		{
			msg="Employee is not deleted";
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> list= dao.getAllEmployee();
		return list;

		
	}

	public Employee getPerticularEmployeebyId(int id) {
		  Employee emp=dao.getPerticularEmployeebyId(id);
		if(Objects.isNull(emp))
		{
			emp= null;
		}
		
		return emp;
	}

	public List<Employee> getEmployeeByStatus(String status) {
		
		List<Employee> list=dao.getEmployeeByStatus(status);
		if(Objects.isNull(list))
		{
			list= null;
		}
		return list;
	}

	//public Employee checkValidEmployee(Employee emp) {
		
		//Employee employee=dao.checkValidEmployee(emp);
		
		//return emp;
	//}

	public Employee loginCheck(Employee emp) {
		Employee e=dao.loginCheck(emp);
		HashMap map= new HashMap();
		if(Objects.isNull(e))
		{
			map.put("msg","Invalid User");
			map.put("user","e");
			
		}else {
			map.put("msg","valid User");
			map.put("user","e");
		}
		return emp;
		
	}
	

}
