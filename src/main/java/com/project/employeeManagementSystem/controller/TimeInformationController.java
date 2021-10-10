package com.project.employeeManagementSystem.controller;

import java.util.List;

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

import com.project.employeeManagementSystem.model.TimeInformation;
import com.project.employeeManagementSystem.service.TimeInformationService;

@RestController
@RequestMapping("/time")
public class TimeInformationController {
	
	@Autowired
	private TimeInformationService myService;

	//get the Time Information
	@GetMapping("/TimeInformations")
	public List<TimeInformation> getTimeInformations(){
		return this.myService.getTimeInformations();
	}


	//get the Single Employee Time Information
	@GetMapping("/TimeInformations/{Id}")
	public TimeInformation getTimeInformation(@PathVariable String Id) {
		return this.myService.getTimeInformation(Integer.parseInt(Id));
	}


	//add Time Infomration
	@PostMapping("/TimeInformations")
	public TimeInformation addTimeInformation(@RequestBody TimeInformation timeInformation) {
		return this.myService.addTimeInformation(timeInformation);	
	}

	//update Time Information using Put request
	@PutMapping("/TimeInformations")
	public TimeInformation updateTimeInformation(@RequestBody TimeInformation timeInformation) {
		return this.myService.updateTimeInformation(timeInformation);
	}

	//delete the Time Information
	@DeleteMapping("/TimeInformations/{Id}")
	public ResponseEntity<HttpStatus> deleteTimeInformation(@PathVariable String Id){
		try {
			this.myService.deleteTimeInformation(Integer.parseInt(Id));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
