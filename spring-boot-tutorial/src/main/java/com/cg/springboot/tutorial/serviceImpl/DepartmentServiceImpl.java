package com.cg.springboot.tutorial.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboot.tutorial.entity.Department;
import com.cg.springboot.tutorial.exception.DepartmentNotFoundException;
import com.cg.springboot.tutorial.repository.DepartmentRepository;
import com.cg.springboot.tutorial.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) {
		 Optional<Department> department = departmentRepository.findById(departmentId);
		 if(!department.isPresent()) {
			 throw new DepartmentNotFoundException("No Department with ID: "+departmentId +" is present");
		 }else {
			 return department.get();
		 }
	}

	@Override
	public void deleteDepatmentById(Long depatmentId) {
		departmentRepository.deleteById(depatmentId);
	}

	@Override
	public Department updateDeparmentById(Long departmentId, Department department) {
		
		Department departmentDB = departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) && 
				!"".equalsIgnoreCase(department.getDepartmentName())) {
			departmentDB.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentCode()) && 
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
			departmentDB.setDepartmentCode(department.getDepartmentCode());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress()) && 
				!"".equalsIgnoreCase(department.getDepartmentAddress())) {
			departmentDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		return departmentRepository.save(departmentDB);
	}

	@Override
	public Department fetchDepatmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
		
	}

}
