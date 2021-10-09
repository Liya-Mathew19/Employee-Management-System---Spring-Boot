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

import com.project.employeeManagementSystem.model.WorkHistory;
import com.project.employeeManagementSystem.service.WorkHistoryService;

/*
 * WorkHistoryController is responsible for processing user requests.
 * @author Abhirami K P
 * @since 09/10/2021
 */

@RestController
@RequestMapping("/work")
public class WorkHistoryController {

	@Autowired
	WorkHistoryService service;

	/*
	 * getAllEmployeesWorkHistory() is used to get working history of all the employees.
	 * @return List
	 * @method GET
	 */
	@GetMapping("/workhistory")
	public ResponseEntity<List<WorkHistory>> getAllEmployeesWorkHistory() {
		try {
			List<WorkHistory> employeeWorkHistory = service.getAllEmployeesWorkHistory();
			if (employeeWorkHistory.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(employeeWorkHistory, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * getEmployeeWorkHistoryById() is used to get the working history of an employee based on employeeIdNumber
	 * @param work_id
	 * @return WorkHistory
	 * @method GET
	 */
	@GetMapping("/workhistory/{work_id}")
	public ResponseEntity<WorkHistory> getEmployeeWorkHistoryById(@PathVariable("work_id") int id) {
		try {
			Optional<WorkHistory> entity = service.getEmployeeWorkHistoryById(id);
			if (entity.isPresent()) {
				return new ResponseEntity<>(entity.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * createEmployeeWorkHistory() is used to create a new working history, if not exist / update working history of an existing employee
	 * @param employeeWork
	 * @return WorkHistory
	 * @method POST
	 */
	@PostMapping("/workhistory")
	public ResponseEntity<WorkHistory> createEmployeeWorkHistory(@RequestBody WorkHistory employeeWork) {
		try {
			return new ResponseEntity<>(service.createEmployeeWorkHistory(employeeWork), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * updateEmployeeWorkHistory() is used to update the working history of an existing employee
	 * @param employeeWork
	 * @return WorkHistory
	 * @method PUT
	 */
	@PutMapping("/workhistory")
	public ResponseEntity<WorkHistory> updateEmployeeWorkHistory(@RequestBody WorkHistory employeeWork) {
		try {
			WorkHistory entity = service.updateEmployeeWorkHistory(employeeWork);
			if (entity != null) {
				return new ResponseEntity<>(entity, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * deleteEmployeeWorkHistoryById() is used to delete the working history data of an employee based on employeeIdNumber
	 * @param id
	 * @return HttpStatus
	 * @method DELETE
	 */
	@DeleteMapping("/workhistory/{work_id}")
	public ResponseEntity<HttpStatus> deleteEmployeeWorkHistoryById(@PathVariable("work_id") int id) {
		try {
			service.deleteEmployeeWorkHistoryById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}