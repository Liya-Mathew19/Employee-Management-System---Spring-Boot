package com.project.employeeManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.employeeManagementSystem.model.TimeInformation;

/*
 * TimeInformationService extends the JpaRepository which contains all the basic CRUD operations of Time Information module
 * 
 * @author Soumayadip Nath
 * @since 10.10.2021
 */
@Repository
public interface TimeInformationRepository extends JpaRepository<TimeInformation, Integer>{
	Optional<TimeInformation> findByemployeeIdNumber(int employee_id_number);

	void deleteByemployeeIdNumber(int employee_id_number);
}
