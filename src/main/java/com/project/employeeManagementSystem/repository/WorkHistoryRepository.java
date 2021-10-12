package com.project.employeeManagementSystem.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.employeeManagementSystem.model.WorkHistory;

/*
 * EmployeeWorkingHistoryRepository extends the JpaRepository which contains all the basic CRUD operations of work history module
 * 
 * @author Abhirami K P
 * @since 09.10.2021
 */

@Repository
public interface WorkHistoryRepository extends JpaRepository<WorkHistory, Integer> {

	Optional<WorkHistory> findByemployeeIdNumber(int employee_id_number);

	void deleteByemployeeIdNumber(int employee_id_number);
}
