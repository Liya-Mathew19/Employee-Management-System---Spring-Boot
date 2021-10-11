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

import com.project.employeeManagementSystem.model.EmployeeBasicDetails;
import com.project.employeeManagementSystem.service.EmployeeBasicDetailsService;

/*
 * EmployeeBasicDetailsController is responsible for processing user requests of employee basic details module
 * @author Liya Mathew
 * @since 08/10/2021
 */

@RestController
@RequestMapping("/api/employees")
public class EmployeeBasicDetailsController {

	@Autowired
	EmployeeBasicDetailsService service;

	/*
	 * getAllEmployees() is used to get all the employee details
	 * @return List
	 * @method GET
	 */
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeBasicDetails>> getAllEmployees() {
		//try {
			List<EmployeeBasicDetails> employeeList = service.getAllEmployees();
			if (employeeList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(employeeList, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

	/*
	 * getEmployeeById() is used to get the employee details based on employeeIdNumber
	 * @param emp_id
	 * @return EmployeeBasicDetails
	 * @method GET
	 */
	@GetMapping("/employees/{emp_id}")
	public ResponseEntity<EmployeeBasicDetails> getEmployeeById(@PathVariable("emp_id") int id) {
		try {
			Optional<EmployeeBasicDetails> entity = service.getEmployeeById(id);
			if (entity.isPresent()) {
				return new ResponseEntity<>(entity.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * createEmployee() is used to create a new employee if not exist / update an existing employee
	 * @param employee
	 * @return EmployeeBasicDetails
	 * @method POST
	 */
	@PostMapping("/employees")
	public ResponseEntity<EmployeeBasicDetails> createEmployee(@RequestBody EmployeeBasicDetails employee) {
		try {
			return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * updateEmployee() is used to update an existing employee
	 * @param employee
	 * @return EmployeeBasicDetails
	 * @method PUT
	 */
	@PutMapping("/employees")
	public ResponseEntity<EmployeeBasicDetails> updateEmployee(@RequestBody EmployeeBasicDetails employee) {
		try {
			EmployeeBasicDetails entity = service.updateEmployee(employee);
			if (entity != null) {
				return new ResponseEntity<>(entity, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/*
	 * deleteEmployeeById() is used to delete the employee data based on employeeIdNumber
	 * @param id
	 * @return HttpStatus
	 * @method DELETE
	 */
	@DeleteMapping("/employees/{emp_id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("emp_id") int id) {
		try {
			service.deleteEmployeeById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
