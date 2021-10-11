package com.project.employeeManagementSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employeeManagementSystem.model.TimeInformation;
import com.project.employeeManagementSystem.repository.TimeInformationRepository;

/*
 * TimeInformationService is used to perform service tasks.
 * @author Soumayadip Nath
 * @since 10/10/2021
 */
@Service
@Transactional
public class TimeInformationService {
	
	@Autowired
	private TimeInformationRepository repository;
	
	/*
	 * getAllTimeInfo() is used to get time information of all the employees.
	 * @return List
	 */
	public List<TimeInformation> getAllTimeInfo() {
		List<TimeInformation> employeeTimeInformation = repository.findAll();
		if(employeeTimeInformation.size() > 0) {
			return employeeTimeInformation;
		} else {
			return new ArrayList<TimeInformation>();
		}
	}

	/*
	 * getEmployeeTimeInformationById() is used to get the time information of an employee based on employeeIdNumber
	 * @param id
	 * @return TimeInformation
	 */
	public Optional<TimeInformation> getEmployeeTimeInformationById(int id) {
		Optional<TimeInformation> time = repository.findByemployeeIdNumber(id);
		return time;
	}

	/*
	 * createEmployeeTimeInformation() is used to create a new time information, if not exist / update time information of an existing employee
	 * @param entity
	 * @return TimeInformation
	 */
	public TimeInformation createEmployeeTimeInformation(TimeInformation entity) {
		Optional<TimeInformation> time = repository.findByemployeeIdNumber(entity.getEmployeeIdNumber());

		if(time.isPresent()) {
			return this.updateEmployeeTimeInformation(entity);
		} else {
			entity = repository.save(entity);
			return entity;
		}
	}

	/*
	 * updateEmployeeTimeInformation() is used to update the time information of an existing employee
	 * @param entity
	 * @return TimeInformation
	 */
	public TimeInformation updateEmployeeTimeInformation(TimeInformation entity) {
		Optional<TimeInformation> time = repository.findByemployeeIdNumber(entity.getEmployeeIdNumber());

		if(time.isPresent()) {
			TimeInformation timeData = time.get();
			timeData.setEmployeeIdNumber(entity.getEmployeeIdNumber());
			timeData.setWorkred_Hours(entity.getWorkred_Hours());
			timeData.setOff_Hours(entity.getOff_Hours());
			timeData.setDays_Off(entity.getDays_Off());
			timeData.setOver_Time(entity.getOver_Time());
			timeData.setExtra_Days(entity.getExtra_Days());
			timeData.setW_From_Date_Day(entity.getW_From_Date_Day());
			timeData.setW_From_Date_Month(entity.getW_From_Date_Month());
			timeData.setW_From_Date_Year(entity.getW_From_Date_Year());
			timeData.setW_To_Date_Day(entity.getW_To_Date_Day());
			timeData.setW_To_Date_Month(entity.getW_To_Date_Month());
			timeData.setW_To_Date_Year(entity.getW_To_Date_Year());
			timeData = repository.save(timeData);
			return timeData;
		}
		else {
			entity = null;
			return entity;
		}
	} 

	/*
	 * deleteEmployeeTimeInformationById() is used to delete the time information data of an employee based on work id
	 * @param id
	 * @return null
	 */
	public void deleteEmployeeTimeInformationById(int id) {
		Optional<TimeInformation> time = repository.findByemployeeIdNumber(id);    
		if(time.isPresent()) {
			repository.deleteByemployeeIdNumber(id);
		}
		else {
			return;
		}

	}
}
