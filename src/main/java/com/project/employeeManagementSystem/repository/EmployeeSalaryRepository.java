package com.project.employeeManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeeManagementSystem.model.EmployeeBasicDetails;
import com.project.employeeManagementSystem.model.EmployeeSalary;

/*
 * EmployeeSalaryRepository extends the JpaRepository which contains all the basic CRUD operations in Salary Information module
 * @author Kishore Kumar
 * @since 09/10/2021
 */

@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary, Integer> {

	Optional<EmployeeSalary> findByemployeeIdNumber(int employee_id_number);

	void deleteByemployeeIdNumber(int employee_id_number);
}

