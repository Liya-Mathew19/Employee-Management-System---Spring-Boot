package com.project.employeeManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeeManagementSystem.model.EmployeeBasicDetails;

/*
 * EmployeeBasicDetailsRepository extends the JpaRepository which contains all the basic CRUD operations Employee Basic Details module
 * 
 * @author Liya Mathew
 * @since 08.10.2021
 */

@Repository
public interface EmployeeBasicDetailsRepository extends JpaRepository<EmployeeBasicDetails, Integer> {

	Optional<EmployeeBasicDetails> findByemployeeIdNumber(int employee_id_number);

	void deleteByemployeeIdNumber(int employee_id_number);
}
