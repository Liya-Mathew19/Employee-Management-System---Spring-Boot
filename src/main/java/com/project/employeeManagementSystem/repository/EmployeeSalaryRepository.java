package com.project.employeeManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeeManagementSystem.model.EmployeeSalary;


@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary, Integer> {
	
	Optional<EmployeeSalary> findBysalaryId(int salary_id);

	void deleteBysalaryId(int salary_id);
}
