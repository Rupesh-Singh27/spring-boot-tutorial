package com.cg.springboot.tutorial.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.springboot.tutorial.entity.Department;
import com.cg.springboot.tutorial.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	
	// Note: Jiss bhi class ke liye test kar rahe hai uska object compulsory hai
	@Autowired
	private DepartmentService departmentService;
	
	//DepartmentService aage departmentRepository ko call karega isliye departmentRepository ko mock kiya hai
	@MockBean
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Department department = new Department();
		department.setDepartmentId(1L);
		department.setDepartmentCode("IT-09");
		department.setDepartmentAddress("Mumbai");
		department.setDepartmentName("IT");
		
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
				.thenReturn(department);
	}

	@Test
	@DisplayName("Get Valid Department for Valid Department Name")
//	@Disabled this annotation is used to disable/skip the particular test method
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName = "IT";
		Department found = departmentService.fetchDepatmentByName(departmentName);
		assertEquals(departmentName, found.getDepartmentName());
	}
	
	

}
