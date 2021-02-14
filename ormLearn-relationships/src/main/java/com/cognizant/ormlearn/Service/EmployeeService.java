package com.cognizant.ormlearn.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.springlearn.service.exception.DepartmentNotFoundexception;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import com.cognizant.OrmLearnRelationshipsApplication;
import com.cognizant.ormlearn.Repository.DepartmentRepository;
import com.cognizant.ormlearn.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	HashMap<Integer, Employee> employees;
	

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnRelationshipsApplication.class);

	@Transactional
	public Employee get(int id) {
		LOGGER.info("Start");
		return employeeRepository.findById(id).get();
	}

	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");
		employeeRepository.save(employee);
		LOGGER.info("End");
	}

	@Transactional
	public void addEmployee(Employee p) {
		employeeRepository.save(p);
	}

	public Employee getEmployee(int pid) throws EmployeeNotFoundException {

		Optional<Employee> p = employeeRepository.findById(pid);
		if (!p.isPresent()) {
			throw new EmployeeNotFoundException(pid + " not found");
		} else {
			return p.get();
		}
	}
	
	@Transactional
	public void updateEmployee(Employee p) throws EmployeeNotFoundException{
		Employee pp=employeeRepository.getOne(p.getId());
		if(pp==null)
			throw new EmployeeNotFoundException(p.getId()+" not found to update");
		else
		pp.setId(p.getId());
		pp.setName(p.getName());
		pp.setDepartment(p.getDepartment());
		pp.setSalary(p.getSalary());
			employeeRepository.save(pp);
	}

	public List<Employee> getAllPermanentEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	
	public double getAverageSalary(int id) throws DepartmentNotFoundexception
	{
		Department department=departmentRepository.getOne(id);
		
		
		if(department.getId()!=id) {
			throw new DepartmentNotFoundexception("Department id " + id + " does not exist");
		}
		else {
			int count = 0;
			double total = 0;
			for(Integer eid : employees.keySet()) {
				Employee einfo = employees.get(eid);
				Integer did = einfo.getId();
				if(did.equals(id)) {
					double salary = einfo.getSalary();
					count ++;
					total += salary;
				}
			}
			return total / count;
		}
	}
	
      public List<Employee> getAllEmployeesNative()
      {
    	 
    	  return employeeRepository.getAllEmployeesNative();
    	  
      }
}
