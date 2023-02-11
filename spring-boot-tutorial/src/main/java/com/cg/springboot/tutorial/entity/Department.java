package com.cg.springboot.tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	@NotBlank(message = "Please add department name")
	/*@Length(max = 5, min = 1)
	@Size(max = 10, min = 0)
	@Email
	@Positive
	@Negative
	@PositiveOrZero
	@NegativeOrZero
	@Future
	@FutureOrPresent
	@Past
	@PastOrPresent*/
	private String departmentName;
	private String departmentCode;
	private String departmentAddress;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Long departmentId, String departmentName, String departmentCode, String departmentAddress) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentCode = departmentCode;
		this.departmentAddress = departmentAddress;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentAddress() {
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", departmentCode="
				+ departmentCode + ", departmentAddress=" + departmentAddress + "]";
	}
	
	
	
}
