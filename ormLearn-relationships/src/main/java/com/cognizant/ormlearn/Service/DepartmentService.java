package com.cognizant.ormlearn.Service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.OrmLearnRelationshipsApplication;
import com.cognizant.ormlearn.Repository.DepartmentRepository;
import com.cognizant.ormlearn.model.Department;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnRelationshipsApplication.class);
	
	@Transactional
	public Department get(int id)
	{
		LOGGER.info("Start"); 
		return departmentRepository.findById(id).get();	
	}
	
	@Transactional 
	public void save(Department employee) { 
	 LOGGER.info("Start"); 
     departmentRepository.save(employee); 
	 LOGGER.info("End"); 
	}
	
	
}
