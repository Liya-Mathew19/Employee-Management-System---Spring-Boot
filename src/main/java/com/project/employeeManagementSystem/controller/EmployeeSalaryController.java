package com.project.employeeManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/salary")
public class EmployeeSalaryController {
	
	@Autowired
	EmployeeSalaryService service;

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
	
	@GetMapping("/employee_salary/{sal_id}")
	public ResponseEntity<EmployeeSalary> getEmployeeSalaryById(@PathVariable("sal_id") int id) {
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
	
	@PostMapping("/employee_salary")
	public ResponseEntity<EmployeeSalary> createEmployeeSalary(@RequestBody EmployeeSalary empsal) {
		try {
			return new ResponseEntity<>(service.createEmployeeSalary(empsal), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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
	
	@DeleteMapping("/employee_salary/{emp_id}")
	public ResponseEntity<HttpStatus> deleteEmployeeSalaryById(@PathVariable("emp_id") int id) {
		try {
			service.deleteEmployeeSalaryById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
}
