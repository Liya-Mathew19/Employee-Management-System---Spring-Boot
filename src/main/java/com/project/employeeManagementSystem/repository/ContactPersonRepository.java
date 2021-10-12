package com.project.employeeManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeeManagementSystem.model.ContactPerson;

/*
 * ContactPersonRepository extends the JpaRepository which contains all the basic CRUD operations in Contact Person Information module
 * 
 * @author Aiswarya K S
 * @since 09.10.2021
 */

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Integer> {

	Optional<ContactPerson> findByemployeeIdNumber(int employee_id_number);

	void deleteByemployeeIdNumber(int employee_id_number);
}
