package com.cg.springboot.tutorial.service;

import java.util.List;

import com.cg.springboot.tutorial.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartments();

	public Department fetchDepartmentById(Long departmentId);

	public void deleteDepatmentById(Long depatmentId);

	public Department updateDeparmentById(Long departmentId, Department department);

	public Department fetchDepatmentByName(String departmentName);

}
