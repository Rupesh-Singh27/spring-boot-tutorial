package com.cg.springboot.tutorial.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cg.springboot.tutorial.entity.Department;
import com.cg.springboot.tutorial.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
	//MockMvc is used to perform endpoint related stuff like hitting the endpoint with porper web request 
	//or getting data with proper data format like JSON with proper status code.
	@Autowired 
	MockMvc mockMvc;
	
	@MockBean
	DepartmentService departmentService;
	
	Department department;

	@BeforeEach
	void setUp() throws Exception {
		
		department = new Department();
		department.setDepartmentCode("ME-09");
		department.setDepartmentAddress("Delhi");
		department.setDepartmentId(1L);
		department.setDepartmentName("ME");
	}

	@Test
	public void saveDepartment() throws Exception {
		
		Department inputDepartment = new Department();
		inputDepartment.setDepartmentCode("ME-09");
		inputDepartment.setDepartmentAddress("Delhi");
		inputDepartment.setDepartmentName("ME");
		
		Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\n"+
			"\t\"departmentName\":\"ME\", \n"  +
			"\t\"departmentCode\":\"ME-09\", \n"  +
			"\t\"departmentAddress\":\"Delhi\" \n" +
		"}")).andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void fetchDepartmentById() throws Exception {
		
		Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/departments/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
	}

}
