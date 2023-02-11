package com.cg.springboot.tutorial.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.cg.springboot.tutorial.entity.Department;

@DataJpaTest //Yeh annotation help karega data ko persist karne ke liye DB me jab tak voh method run horaha hai. 
			//Method ka execution khatam hoga toh voh dala flush hojayega DB se. 
class DepartmentRepositoryTest {

	// Note: Jiss bhi class ke liye test kar rahe hai uska object compulsory hai
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired //TestEntityManager helps to do actual basic task such as persist, flush, find etc for testing purpose without making any changes in autual DB.
	private TestEntityManager testEntityManager;
	
	@BeforeEach
	void setUp() throws Exception {
		Department department = new Department();
		department.setDepartmentCode("ME-09");
		department.setDepartmentAddress("Delhi");
		department.setDepartmentName("ME");
		
		testEntityManager.persist(department);
	}

	@Test
	public void whenFindById_thenReturnDepartment() {
		Department found = departmentRepository.findById(1L).get();
		assertEquals(found.getDepartmentName(), "ME");
	}

}
