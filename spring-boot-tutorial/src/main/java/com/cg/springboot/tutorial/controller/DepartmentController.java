package com.cg.springboot.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springboot.tutorial.entity.Department;
import com.cg.springboot.tutorial.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchDepartments(){
		LOGGER.info("Inside fetchDepartments of DepartmentController");
		return departmentService.fetchDepartments();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepatmentById(@PathVariable("id") Long depatmentId) {
		departmentService.deleteDepatmentById(depatmentId);
		return "Department deleted successfully";
	}
	
	@PutMapping("departments/{id}")
	public Department updateDeparmentById(@PathVariable("id") Long departmentId,
											@RequestBody Department department) {
		return departmentService.updateDeparmentById(departmentId, department);
	}
	
	@GetMapping("departments/name/{depName}")
	public Department fetchDepatmentByName(@PathVariable("depName") String departmentName) {
		return departmentService.fetchDepatmentByName(departmentName);
	}
}
