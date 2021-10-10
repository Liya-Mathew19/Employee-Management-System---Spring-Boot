package com.project.employeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.employeeManagementSystem.model.TimeInformation;

public interface TimeInformationRepository extends JpaRepository<TimeInformation, Integer>{

}
