
package com.cognizant;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.ormlearn.Repository.StockRepository;
import com.cognizant.ormlearn.Service.DepartmentService;
import com.cognizant.ormlearn.Service.EmployeeService;
import com.cognizant.ormlearn.Service.SkillService;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.springlearn.service.exception.DepartmentNotFoundexception;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@SpringBootApplication
@ComponentScan("com.*")
public class OrmLearnRelationshipsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnRelationshipsApplication.class);
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	@Autowired
	StockRepository repository;

	@Transactional
	public List<Stock> getAllFacebook() throws ParseException {
		String sDate1="2019/09/01";
		String sDate2="2019/09/30";
		Date date;
			date = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
			Date date2=new SimpleDateFormat("yyyy/MM/dd").parse(sDate2);

		
		return repository.findByCodeAndDateBetween("FB", date, date2);
	}

	@Transactional
	public List<Stock> getAllGoogle() {
		return repository.findByCloseGreaterThan(1250);
	}

	@Transactional
	public List<Stock> highest5Trans() {
		return repository.findFirst3ByOrderByVolumeDesc();
	}

	@Transactional
	public List<Stock> lowest3Trans() {
		return repository.findFirst3ByCodeOrderByCloseAsc("NFLX");
	}

	public static void main(String[] args) throws ParseException {
		LOGGER.info("STOCK START");
		ApplicationContext context = SpringApplication.run(OrmLearnRelationshipsApplication.class, args);
		OrmLearnRelationshipsApplication application = context.getBean(OrmLearnRelationshipsApplication.class);
		List<Stock> list = application.getAllFacebook();
		for (Stock stock : list) {
			System.out.println(stock.toString());
		}

		list = application.getAllGoogle();
		for (Stock stock : list) {
			System.out.println(stock.toString());
		}

		list = application.highest5Trans();
		for (Stock stock : list) {
			System.out.println(stock.toString());
		}

		list = application.lowest3Trans();
		for (Stock stock : list) {
			System.out.println(stock.toString());
		}

		LOGGER.info("********************************EMPLOYEE START****************************");

		employeeService = (EmployeeService) context.getBean("employeeService");
		LOGGER.info("Inside main");
		System.out.println("******************************GET ID********************************");
		testGetEmployee();
		System.out.println("*********************************** GET ADD *****************************");
		testAddEmployee();
		System.out.println("******************************Update********************************");
        updateEmployee();
//        System.out.println("******************************GET ALL LAST********************************");
//		testGetAllEmployee();
        
        LOGGER.info("********************************Department START****************************");
		departmentService = (DepartmentService) context.getBean("departmentService");
		LOGGER.info("Inside main");
		System.out.println("******************************GET ID********************************");
		testGetDepartment();
		
		LOGGER.info("*****************************************SKILL Start********************************");
		skillService=(SkillService) context.getBean("skillService");
		System.out.println("******************************GET skill ID********************************");
		testAddSkillToEmployee();
		
		System.out.println("*********************************************");
		testGetAllPermanentEmployees();
		
		System.out.println("************************************************");
		testGetAllEmployeesNative();
		
		
        
	}
	
//	private static void testGetAllEmployee() {
//		LOGGER.info("Start");
//		List<Employee> Employee = service.getAllEmployee();
//		LOGGER.debug("Employee={}", Employee);
//		Employee.forEach(System.out::println);
//		LOGGER.info("End");
//	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(101);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		System.out.println("Employee Deatils ID " + employee.getId());
		System.out.println("Employee Deatils NAME " + employee.getName());
		System.out.println("Employee Deatils SALARY " + employee.getSalary());
		System.out.println("Employee Deatils DOB " + employee.getDateOfBirth());
		System.out.println("Employee Deatils " + employee.getDepartment());
		LOGGER.debug("SUCCESS");
		LOGGER.info("End");
	}

	private static void testAddEmployee() throws ParseException {
		Department dept = new Department();
		dept.setId(3);
		String sDate1="1998/12/01";
		Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		Employee employee = new Employee(105,"ram", 58965.5, false, date1, dept);
		employeeService.addEmployee(employee);
		LOGGER.debug("Employees={}", employee);
		System.out.println("Employee Deatils ID " + employee.getId());
		System.out.println("Employee Deatils NAME " + employee.getName());
		System.out.println("Employee Deatils SALARY " + employee.getSalary());
		System.out.println("Employee Deatils DOB " + employee.getDateOfBirth());
		System.out.println("Employee Deatils " + employee.getDepartment());
		LOGGER.info("End");

	}
	
	private static void updateEmployee() {
		Department dept = new Department();
		dept.setId(3);
		try {
			LOGGER.info("start");
			Employee p=employeeService.getEmployee(101);
			p.setName("Ravi");
			p.setId(108);
			p.setDepartment(dept);
			p.setSalary(58965.23);
			employeeService.updateEmployee(p);
			LOGGER.debug("Employees={}",p);
			LOGGER.info("SUCCESS");
			LOGGER.info("End");
		} catch (EmployeeNotFoundException e) {
			LOGGER.debug(e.getMessage());
		}
	}
	
	private static void testGetDepartment() {
		LOGGER.info("Start");
		Department employee = departmentService.get(1);
		LOGGER.debug("Department:{}", employee);
		LOGGER.debug("Employee:{}", employee.getId());
		System.out.println("Department Deatils ID " + employee.getId());
		System.out.println("Department Deatils NAME " + employee.getName());
		LOGGER.info("End");
	}
	
	private static void testAddSkillToEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(101);
		Skill skill=skillService.get(1);
		LOGGER.debug("Department:{}", employee);
		LOGGER.debug("Skill:{}", skill);
		System.out.println("Skill Deatils ID " + skill.getId());
		System.out.println("Skill Deatils NAME " + skill.getName());
		LOGGER.info("SUCCESS");
		LOGGER.info("End");
	}
	
	public static void testGetAllPermanentEmployees() { 
		LOGGER.info("Start"); 
		List<Employee> employees = employeeService.getAllPermanentEmployees(); 
		LOGGER.debug("Permanent Employees:{}", employees); 
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList())); 
		employees.forEach(System.out::println);
		LOGGER.info("End");
	}
	
	public static void testgetAverageSalary() throws DepartmentNotFoundexception
	{
		LOGGER.info("Start");
	    System.out.println("salary "+employeeService.getAverageSalary(1));
	    LOGGER.info("SUCCESS");
 		LOGGER.info("END");
	}
	
	public static void testGetAllEmployeesNative()
	{
		LOGGER.info("Start"); 
		List<Employee> employee = employeeService.getAllEmployeesNative(); 
		LOGGER.debug("Employees:{}", employee);
		employee.forEach(System.out::println);
		LOGGER.info("End");
	}
	
}
