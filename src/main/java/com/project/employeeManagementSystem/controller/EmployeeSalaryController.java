package com.project.employeeManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeeManagementSystem.model.EmployeeSalary;
import com.project.employeeManagementSystem.service.EmployeeSalaryService;
/*
 * EmployeeSalaryController is responsible for processing user requests.
 * @author Kishore Kumar
 * @since 09/10/2021
 */

@RestController
@RequestMapping("/api/salary")
public class EmployeeSalaryController {

	@Autowired
	EmployeeSalaryService service;

	/*
	 * getAllEmployeeSalary() is used to get all the salary informations
	 * @return List
	 * @method GET
	 */
	@GetMapping("/employee_salary")
	public ResponseEntity<List<EmployeeSalary>> getAllEmployeeSalary() {
		try {
			List<EmployeeSalary> employeeList = service.getAllEmployeeSalary();
			if (employeeList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(employeeList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * getEmployeeSalaryById() is used to get the salary information based on Employee ID
	 * @param emp_id
	 * @return EmployeeSalary
	 * @method GET
	 */
	@GetMapping("/employee_salary_emp/{emp_id}")
	public ResponseEntity<EmployeeSalary> getEmployeeSalaryById(@PathVariable("emp_id") int id) {
		try {
			Optional<EmployeeSalary> entity = service.getEmployeeSalaryById(id);
			if (entity.isPresent()) {
				return new ResponseEntity<>(entity.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * getEmployeeSalaryBySalId() is used to get the salary information based on salary ID
	 * @param sal_id
	 * @return EmployeeSalary
	 * @method GET
	 */
	@GetMapping("/employee_salary_sal/{sal_id}")
	public ResponseEntity<EmployeeSalary> getEmployeeSalaryBySalId(@PathVariable("sal_id") int id) {
		try {
			Optional<EmployeeSalary> entity = service.getEmployeeSalaryBySalId(id);
			if (entity.isPresent()) {
				return new ResponseEntity<>(entity.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * createContact() is used to create a new salary info if not exist / update an existing salary info
	 * @param empsal
	 * @return EmployeeSalary
	 * @method POST
	 */
	@PostMapping("/employee_salary")
	public ResponseEntity<EmployeeSalary> createEmployeeSalary(@RequestBody EmployeeSalary empsal) {
		try {
			return new ResponseEntity<>(service.createEmployeeSalary(empsal), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * updateEmployeeSalary() is used to update an existing salary info
	 * @param empsal
	 * @return EmployeeSalary
	 * @method PUT
	 */
	@PutMapping("/employee_salary")
	public ResponseEntity<EmployeeSalary> updateEmployeeSalary(@RequestBody EmployeeSalary empsal) {
		try {
			EmployeeSalary entity = service.updateEmployeeSalary(empsal);
			if (entity != null) {
				return new ResponseEntity<>(entity, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/*
	 * deleteEmployeeSalaryById() is used to delete the salary info based on Contact ID
	 * @param emp_id
	 * @return HttpStatus
	 * @method DELETE
	 */
	@DeleteMapping("/employee_salary/{contact_id}")
	public ResponseEntity<HttpStatus> deleteEmployeeSalaryById(@PathVariable("contact_id") int id) {
		try {
			service.deleteEmployeeSalaryById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
