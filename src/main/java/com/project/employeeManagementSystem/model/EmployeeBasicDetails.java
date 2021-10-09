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
	int employeeIdNumber;

	@Column(name = "personalIdNumber" )
	int personalIdNumber;

	@Column(name = "firstName")
	String firstName;

	@Column(name = "middleName")
	String middleName;

	@Column(name = "lastName")
	String lastName;

	@Column(name = "dayOfBirth")
	int dayOfBirth;

	@Column(name = "monthOfBirth")
	int monthOfBirth;

	@Column(name = "yearOfBirth")
	int yearOfBirth;

	@Column(name = "cellularPhone")
	String cellularPhone;

	@Column(name = "homePhone")
	String homePhone;

	@Column(name = "city")
	String city;

	@Column(name = "address")
	String address;

	@Column(name = "postalCode")
	String postalCode;

	@Column(name = "qualification")
	String qualification;

	@Column(name = "currentExperience")
	String currentExperience;

	@Column(name = "startDateDay")
	int startDateDay;

	@Column(name = "startDateMonth")
	int startDateMonth;

	@Column(name = "startDateYear")
	int startDateYear;

	@Column(name = "endDateDay")
	int endDateDay;

	@Column(name = "endDateMonth")
	int endDateMonth;

	@Column(name = "endDateYear")
	int endDateYear;

	@Column(name = "typeOfEmployee")
	String typeOfEmployee;

	@Column(name = "gender")
	String gender;

	@Column(name = "maritalStatus")
	String maritalStatus;
	
//	@OneToMany(targetEntity = ContactPerson.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "employeeIdNumber",referencedColumnName = "employeeIdNumber")
//	private List<ContactPerson> contacts;
//	
//	@OneToMany(targetEntity = WorkingHistory.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "employeeIdNumber",referencedColumnName = "employeeIdNumber")
//	private List<WorkingHistory> workHistory;
//	
	@OneToMany(targetEntity = EmployeeSalary.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeIdNumber",referencedColumnName = "employeeIdNumber")
	private List<EmployeeSalary> salary;
//	
//	@OneToMany(targetEntity = Time.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "employeeIdNumber",referencedColumnName = "employeeIdNumber")
//	private List<Time> time;
}
