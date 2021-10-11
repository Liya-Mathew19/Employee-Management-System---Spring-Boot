package com.project.employeeManagementSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employeeManagementSystem.model.EmployeeSalary;
import com.project.employeeManagementSystem.repository.EmployeeSalaryRepository;

/*
 * EmployeeSalaryService is used to perform service tasks of Salary Information module
 * @author Kishore Kumar
 * @since 09/10/2021
 */
@Service
@Transactional
public class EmployeeSalaryService {

	@Autowired
	private EmployeeSalaryRepository employeeSalaryRepository;

	/*
	 * getAllEmployeeSalary() is used to get all the employee salary details
	 * @return List
	 */
	public List<EmployeeSalary> getAllEmployeeSalary(){
		List<EmployeeSalary> employeeList = employeeSalaryRepository.findAll();
		if(employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<EmployeeSalary>();
		}
	}

	/*
	 * getEmployeeSalaryById() is used to get the salary details based on the Employee ID
	 * @param id
	 * @return EmployeeSalary
	 */
	public Optional<EmployeeSalary> getEmployeeSalaryById(int id) {
		Optional<EmployeeSalary> empsal = employeeSalaryRepository.findByemployeeIdNumber(id);
		return empsal;
	}
	
	/*
	 * getEmployeeSalaryBySalId() is used to get the salary details based on the salary ID
	 * @param id
	 * @return EmployeeSalary
	 */
	public Optional<EmployeeSalary> getEmployeeSalaryBySalId(int id) {
		Optional<EmployeeSalary> empsal = employeeSalaryRepository.findBysalaryId(id);
		return empsal;
	}

	/*
	 * createEmployeeSalary() is used to create a new salary info if not exist / update an existing salary info
	 * @param entity
	 * @return EmployeeSalary
	 */
	public EmployeeSalary createEmployeeSalary(EmployeeSalary entity) {
		Optional<EmployeeSalary> empsal = employeeSalaryRepository.findByemployeeIdNumber(entity.getSalaryId());

		if(empsal.isPresent()) {
			return this.updateEmployeeSalary(entity);
		}else {
			entity = employeeSalaryRepository.save(entity);
			return entity;
		}
	}

	/*
	 * updateEmployeeSalary() update an existing salary info
	 * @param entity
	 * @return EmployeeSalary
	 */
	public EmployeeSalary updateEmployeeSalary(EmployeeSalary entity) {
		Optional<EmployeeSalary> empsal = employeeSalaryRepository.findByemployeeIdNumber(entity.getSalaryId());

		if(empsal.isPresent()) {
			EmployeeSalary newEntity = empsal.get();
			newEntity.setEmployeeIdNumber(entity.getEmployeeIdNumber());
			newEntity.setMonthlySalary(entity.getMonthlySalary());
			newEntity.setMonthlyMoneyCurrency(entity.getMonthlyMoneyCurrency());
			newEntity.setMonthlyTaxes(entity.getMonthlyTaxes());
			newEntity.setMonthlyDeductions(entity.getMonthlyDeductions());
			newEntity.setMonthlyInsurances(entity.getMonthlyInsurances());
			newEntity.setMsFromDateDay(entity.getMsFromDateDay());
			newEntity.setMsFromDateMonth(entity.getMsFromDateMonth());
			newEntity.setMsFromDateYear(entity.getMsFromDateYear());
			newEntity.setMsToDateDay(entity.getMsToDateDay());
			newEntity.setMsToDateMonth(entity.getMsToDateDay());
			newEntity.setMsToDateYear(entity.getMsToDateYear());
			newEntity.setWeeklySalary(entity.getWeeklySalary());
			newEntity.setWeeklyMoneyCurrency(entity.getWeeklyMoneyCurrency());
			newEntity.setWeeklyTaxes(entity.getWeeklyTaxes());
			newEntity.setWeeklyDeduction(entity.getWeeklyDeduction());
			newEntity.setWeeklyInsurances(entity.getWeeklyInsurances());
			newEntity.setWsFromDateDay(entity.getWsFromDateDay());
			newEntity.setWsFromDateMonth(entity.getWsFromDateMonth());
			newEntity.setWsfromDateYear(entity.getWsToDateYear());
			newEntity.setWsToDateDay(entity.getWsToDateDay());
			newEntity.setWsToDateMonth(entity.getWsToDateMonth());
			newEntity.setWsToDateYear(entity.getWsToDateYear());
			return newEntity;
		}
		else {
			entity = null;

			return entity;
		}
	}

	/*
	 * deleteEmployeeSalaryById() is used to delete the salary info based on Employee ID
	 * @param id
	 * @return null
	 */
	public void deleteEmployeeSalaryById(int id) {
		Optional<EmployeeSalary> empsal = employeeSalaryRepository.findBysalaryId(id);
		if(empsal.isPresent()) {
			employeeSalaryRepository.deleteBysalaryId(id);
		}
		else {
			return;
		}

	}
}