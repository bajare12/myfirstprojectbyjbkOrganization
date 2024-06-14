package com.tka.OrganizationSystem.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
public class Employee {
	public Employee() {
		super();
	}

	public Employee(String name, String deprtment, String status, String phoneno, double salary, Date createddtm,
			String created_by, Date updateddtm, String updatedby, String emailid, Country country) {
		super();
		this.name = name;
		this.deprtment = deprtment;
		this.status = status;
		this.phoneno = phoneno;
		this.salary = salary;
		this.createddtm = createddtm;
		this.created_by = created_by;
		this.updateddtm = updateddtm;
		this.updatedby = updatedby;
		this.emailid = emailid;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deprtment=" + deprtment + ", status=" + status
				+ ", phoneno=" + phoneno + ", salary=" + salary + ", createddtm=" + createddtm + ", created_by="
				+ created_by + ", updateddtm=" + updateddtm + ", updatedby=" + updatedby + ", emailid=" + emailid
				+ ", country=" + country + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeprtment() {
		return deprtment;
	}

	public void setDeprtment(String deprtment) {
		this.deprtment = deprtment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getCreateddtm() {
		return createddtm;
	}

	public void setCreateddtm(Date createddtm) {
		this.createddtm = createddtm;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getUpdateddtm() {
		return updateddtm;
	}

	public void setUpdateddtm(Date updateddtm) {
		this.updateddtm = updateddtm;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name ;
	String deprtment;
	String status;
	String phoneno;
	double salary;
	Date createddtm;
	String created_by;
	Date updateddtm;
	String updatedby;
	String emailid;
	
	@ManyToOne
	@JoinColumn(name ="c_id")
	Country country;
		
}
