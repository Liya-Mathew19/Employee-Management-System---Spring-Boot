package com.project.employeeManagementSystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeeManagementSystem.model.EmployeeSalary;

@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary, Integer>{
	
}


