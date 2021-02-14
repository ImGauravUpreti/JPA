package com.cognizant.ormlearn.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value="SELECT e FROM Employee e WHERE e.permanent = 1") 
	List<Employee> getAllPermanentEmployees(); 

}
