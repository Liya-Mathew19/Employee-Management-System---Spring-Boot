package com.project.employeeManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeeManagementSystem.model.EmployeeBasicDetails;
import com.project.employeeManagementSystem.model.TimeInformation;
import com.project.employeeManagementSystem.model.WorkHistory;

/*
 * TimeInformationService extends the JpaRepository which contains all the basic CRUD operations
 * @author Soumayadip Nath
 * @since 10/10/2021
 */
@Repository
public interface TimeInformationRepository extends JpaRepository<TimeInformation, Integer>{
	Optional<TimeInformation> findByemployeeIdNumber(int employee_id_number);

	void deleteByemployeeIdNumber(int employee_id_number);
}
