package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;
@Repository
public class MainDao {


	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		
		Session session= null;
		Transaction tx= null;
		String msg= null;
		
		try {
		session=factory.openSession();	
		
		tx=session.beginTransaction();
		session.persist(c);
		tx.commit();
		msg="country is added";
		}
		catch(Exception e){
			if (tx!=null)
			{
				tx.rollback();
			}
		
		}
		finally {
			if(session!=null) {
			session.close();
			}
		}
		return msg;
	}

	public String updateCountry(int id, Country c) {
		Session session= null;
		Transaction tx= null;
		String msg= null;
		
		try {
			session=factory.openSession();	
			
			tx=session.beginTransaction();
			
			Country country=session.get(Country.class,id);
			country.setCname(msg);
			session.merge(country);
			tx.commit();
			
			msg="country is updated";
			
		}
		catch(Exception e){
			if (tx!=null)
			{
				tx.rollback();
			}
		}
			finally {
				if(session!=null) {
				session.close();
				}
			}
			return msg;
					
		
	}

	public String deleteRecord(int id) {
		
		 Session session= factory.openSession();
			session.beginTransaction();
			
			Country c= 
				session.get(Country.class, id);
			
			session.remove(c);
			session.getTransaction().commit();
			session.close();
			return "Record Deleted Successfully.....";
			
		
	}

	 public List<Country> getAllRecord() {

			String hqlQuery="from Country";

			Session session= factory.openSession();
			session.beginTransaction();

			Query<Country> query= 
			session.createQuery(hqlQuery,Country.class);

			List<Country> list = query.list();

			session.getTransaction().commit();
			session.close();

			return list;

	 }

	public String addEmployee(Employee emp) {
		Session session= null;
		Transaction tx= null;
		String msg= null;
		
		try {
		session=factory.openSession();	
		
		tx=session.beginTransaction();
		session.persist(emp);
		tx.commit();
		msg="employee is added";
		}
		catch(Exception e){
			if (tx!=null)
			{
				tx.rollback();
			}
		
		}
		finally {
			if(session!=null) {
			session.close();
			}
		}
		return msg;
		
		
	}

	public String updateEmployee(Employee emp) {
		
		Session session= null;
		Transaction tx= null;
		String msg= null;
		
		try {
            session=factory.openSession();	
			
			tx=session.beginTransaction();
			Employee employee=session.get(Employee.class, emp.getId());
			employee.setName(emp.getName());
			employee.setCountry(emp.getCountry());
			employee.setCreated_by(emp.getCreated_by());
			employee.setCreateddtm(emp.getUpdateddtm());
			employee.setDeprtment(emp.getDeprtment());
			employee.setEmailid(emp.getEmailid());
			
			employee.setPhoneno(emp.getPhoneno());
			employee.setSalary(emp.getSalary());
			employee.setStatus(emp.getStatus());
			employee.setUpdatedby(emp.getUpdatedby());
			employee.setUpdateddtm(emp.getUpdateddtm());
			
			session.merge(employee);
			tx.commit();
			msg="employee updated successfully..... ";
					
		}catch (Exception e) {
			
			if(tx !=null) {
				tx.rollback();
			}
		}
		finally {
			if(session!=null) {
				session.close();
				}
			
		}
		
				return msg;
	}

	public String deleteEmployee(int id) {
		
		Session session= factory.openSession();
		session.beginTransaction();
		
		Employee c= 
			session.get(Employee.class, id);
		
		session.remove(c);
		session.getTransaction().commit();
		session.close();
		return "Record Deleted Successfully.....";
		
	}


	public List<Employee> getAllEmployee() {

		Session session= null;
		Transaction tx= null;
		List<Employee> list= null;
		String hqlquery="from Employee";
		
		try {
		session=factory.openSession();	
		
		tx=session.beginTransaction();
		
		Query <Employee> query=session.createQuery(hqlquery,Employee.class);
		list=query.list();
		tx.commit();
		}
		catch (Exception e) {
			if (tx!=null)
			{
				tx.rollback();
			}
		
		}
		finally {
			if(session!=null) {
			session.close();
			}
		}
		
		return list;
	}

	public Employee getPerticularEmployeebyId(int id) {
		
		Session session= null;
		Transaction tx= null;
		Employee emp= null;
		try {
			session=factory.openSession();	
			
			tx=session.beginTransaction();
			emp=session.get(Employee.class,id);
			tx.commit();
		}
		catch (Exception e) {
			if (tx!=null)
			{
				tx.rollback();
			}
		
		}
		finally {
			if(session!=null) {
			session.close();
			}
		}
		
		
	return emp;
	
	}

	public List<Employee> getEmployeeByStatus(String status) {
		
		Session session= null;
		Transaction tx= null;
		List<Employee> list= null;
		
				
		return null;
	}


	public Employee loginCheck(Employee emp) {
		
		Session session= null;
		Transaction tx= null;
		Employee employee= null;
		
		String hqlQuery="from Employee where emailid=:";
		try {
			 session=factory.openSession();	
			 tx=session.beginTransaction();
			 Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
			 
			 query.uniqueResult()
		}catch (Exception e) {
			if (tx!=null)
			{
				tx.rollback();
			}
			
		}
        finally {
				if(session!=null) {
				session.close();
				}
			  }
		
		
		return employee;
	}

	
	

}
