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

import com.project.employeeManagementSystem.model.TimeInformation;
import com.project.employeeManagementSystem.service.TimeInformationService;

/*
 * TimeInformationController is responsible for processing user requests.
 * @author Soumayadip Nath
 * @since 10/10/2021
 */

@RestController
@RequestMapping("/api/time")
public class TimeInformationController {
	
	@Autowired
	private TimeInformationService myService;

	/*
	 * getAllTimeInfo() is used to get time information of all the employees.
	 * @return List
	 * @method GET
	 */
	@GetMapping("/timeInfo")
	public ResponseEntity<List<TimeInformation>> getAllTimeInfo() {
		try {
			List<TimeInformation> employeeTimeInformation = myService.getAllTimeInfo();
			if (employeeTimeInformation.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(employeeTimeInformation, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * getEmployeeTimeInformationById() is used to get the time information of an employee based on employeeIdNumber
	 * @param emp_id
	 * @return TimeInformation
	 * @method GET
	 */
	@GetMapping("/timeInfo_emp/{emp_id}")
	public ResponseEntity<TimeInformation> getEmployeeTimeInformationById(@PathVariable("emp_id") int id) {
		try {
			Optional<TimeInformation> entity = myService.getEmployeeTimeInformationById(id);
			if (entity.isPresent()) {
				return new ResponseEntity<>(entity.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * getEmployeeTimeInformationById() is used to get the time information of an employee based on work id
	 * @param time_id
	 * @return TimeInformation
	 * @method GET
	 */
	@GetMapping("/timeInfo_time/{time_id}")
	public ResponseEntity<TimeInformation> getEmployeeTimeInformationByWorkId(@PathVariable("time_id") int id) {
		try {
			Optional<TimeInformation> entity = myService.getEmployeeTimeInformationByTimeId(id);
			if (entity.isPresent()) {
				return new ResponseEntity<>(entity.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * createEmployeeTimeInformation() is used to create a new time information, if not exist / update time information of an existing employee
	 * @param employeeWork
	 * @return TimeInformation
	 * @method POST
	 */
	@PostMapping("/timeInfo")
	public ResponseEntity<TimeInformation> createEmployeeTimeInformation(@RequestBody TimeInformation empTime) {
		try {
			return new ResponseEntity<>(myService.createEmployeeTimeInformation(empTime), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * updateEmployeeTimeInformation() is used to update the time information of an existing employee
	 * @param employeeWork
	 * @return TimeInformation
	 * @method PUT
	 */
	@PutMapping("/timeInfo")
	public ResponseEntity<TimeInformation> updateEmployeeTimeInformation(@RequestBody TimeInformation empTime) {
		try {
			TimeInformation entity = myService.updateEmployeeTimeInformation(empTime);
			if (entity != null) {
				return new ResponseEntity<>(entity, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * deleteEmployeeTimeInformationById() is used to delete the time information data of an employee based on employeeIdNumber
	 * @param id
	 * @return HttpStatus
	 * @method DELETE
	 */
	@DeleteMapping("/timeInfo/{time_id}")
	public ResponseEntity<HttpStatus> deleteEmployeeTimeInformationById(@PathVariable("time_id") int id) {
		try {
			myService.deleteEmployeeTimeInformationById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
