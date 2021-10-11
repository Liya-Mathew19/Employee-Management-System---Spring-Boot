package com.project.employeeManagementSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employeeManagementSystem.model.WorkHistory;
import com.project.employeeManagementSystem.repository.WorkHistoryRepository;

/*
 * WorkHistoryServices is used to perform service tasks.
 * @author Abhirami K P
 * @since 09/10/2021
 */

@Service
@Transactional
public class WorkHistoryService {

	@Autowired
	private WorkHistoryRepository repository;

	/*
	 * getAllEmployeesWorkHistory() is used to get working history of all the employees.
	 * @return List
	 */
	public List<WorkHistory> getAllEmployeesWorkHistory() {
		List<WorkHistory> employeeWorkHistory = repository.findAll();
		if(employeeWorkHistory.size() > 0) {
			return employeeWorkHistory;
		} else {
			return new ArrayList<WorkHistory>();
		}
	}

	/*
	 * getEmployeeWorkHistoryById() is used to get the working history of an employee based on employeeIdNumber
	 * @param id
	 * @return WorkHistory
	 */
	public Optional<WorkHistory> getEmployeeWorkHistoryById(int id) {
		Optional<WorkHistory> employeeWork = repository.findByemployeeIdNumber(id);
		return employeeWork;
	}
	
	/*
	 * getEmployeeWorkHistoryByWorkId() is used to get the working history of an employee based on work id
	 * @param id
	 * @return WorkHistory
	 */
	public Optional<WorkHistory> getEmployeeWorkHistoryByWorkId(int id) {
		Optional<WorkHistory> employeeWork = repository.findByworkhistoryIdNumber(id);
		return employeeWork;
	}

	/*
	 * createEmployeeWorkHistory() is used to create a new working history, if not exist / update working history of an existing employee
	 * @param entity
	 * @return WorkHistory
	 */
	public WorkHistory createEmployeeWorkHistory(WorkHistory entity) {
		Optional<WorkHistory> employeeWork = repository.findByemployeeIdNumber(entity.getWorkhistoryIdNumber());

		if(employeeWork.isPresent()) {
			return this.updateEmployeeWorkHistory(entity);
		} else {
			entity = repository.save(entity);
			return entity;
		}
	}

	/*
	 * updateEmployeeWorkHistory() is used to update the working history of an existing employee
	 * @param entity
	 * @return WorkHistory
	 */
	public WorkHistory updateEmployeeWorkHistory(WorkHistory entity) {
		Optional<WorkHistory> employeeWork = repository.findByemployeeIdNumber(entity.getWorkhistoryIdNumber());

		if(employeeWork.isPresent()) {
			WorkHistory newEntity = employeeWork.get();
			newEntity.setEmployeeIdNumber(entity.getEmployeeIdNumber());
			newEntity.setCompanyName(entity.getCompanyName());
			newEntity.setEmployerName(entity.getEmployerName());
			newEntity.setEmployerAddress(entity.getEmployerAddress());
			newEntity.setEmployerCellularPhone(entity.getEmployerCellularPhone());
			newEntity.setEmployerOfficePhone(entity.getEmployerOfficePhone());
			newEntity.setPreviousQualification(entity.getPreviousQualification());
			newEntity.setPreviousExperience(entity.getPreviousExperience());
			newEntity.setPStartDateDay(entity.getPStartDateDay());
			newEntity.setPStartDateMonth(entity.getPStartDateMonth());
			newEntity.setPStartDateYear(entity.getPStartDateYear());
			newEntity.setPEndDateDay(entity.getPEndDateDay());
			newEntity.setPEndDateMonth(entity.getPEndDateMonth());
			newEntity.setPEndDateYear(entity.getPEndDateYear());
			newEntity = repository.save(newEntity);
			return newEntity;
		}
		else {
			entity = null;
			return entity;
		}
	} 

	/*
	 * deleteEmployeeWorkHistoryById() is used to delete the working history data of an employee based on work id
	 * @param id
	 * @return null
	 */
	public void deleteEmployeeWorkHistoryById(int id) {
		Optional<WorkHistory> employeeWork = repository.findByworkhistoryIdNumber(id);    
		if(employeeWork.isPresent()) {
			repository.deleteByworkhistoryIdNumber(id);
		}
		else {
			return;
		}

	}

}