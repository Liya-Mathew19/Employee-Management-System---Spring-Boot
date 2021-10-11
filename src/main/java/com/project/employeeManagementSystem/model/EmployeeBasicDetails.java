package com.project.employeeManagementSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * EmployeeBasicDetails model class contains the data of the application.
 * @author Liya Mathew
 * @since 08/10/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_employee_basic_details")
public class EmployeeBasicDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeIdNumber" )
	private int employeeIdNumber;

	@Column(name = "personalIdNumber" )
	private int personalIdNumber;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "middleName")
	private String middleName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "dayOfBirth")
	private int dayOfBirth;

	@Column(name = "monthOfBirth")
	private int monthOfBirth;

	@Column(name = "yearOfBirth")
	private int yearOfBirth;

	@Column(name = "cellularPhone")
	private String cellularPhone;

	@Column(name = "homePhone")
	private String homePhone;

	@Column(name = "city")
	private String city;

	@Column(name = "address")
	private String address;

	@Column(name = "postalCode")
	private String postalCode;

	@Column(name = "qualification")
	private String qualification;

	@Column(name = "currentExperience")
	private String currentExperience;

	@Column(name = "startDateDay")
	private int startDateDay;

	@Column(name = "startDateMonth")
	private int startDateMonth;

	@Column(name = "startDateYear")
	private int startDateYear;

	@Column(name = "endDateDay")
	private int endDateDay;

	@Column(name = "endDateMonth")
	private int endDateMonth;

	@Column(name = "endDateYear")
	private int endDateYear;

	@Column(name = "typeOfEmployee")
	private String typeOfEmployee;

	@Column(name = "gender")
	private String gender;

	@Column(name = "maritalStatus")
	private String maritalStatus;
	
}
