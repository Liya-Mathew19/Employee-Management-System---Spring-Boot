package com.project.employeeManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * EmployeeWorkingHistory model class contains the working history data of the employee.
 * @author Abhirami K P
 * @since 09/10/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_employee_working_history")
public class WorkHistory {

	@Id
	@Column(name = "employeeIdNumber" )
	private int employeeIdNumber;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "employerName")
	private String employerName;

	@Column(name = "employerAddress")
	private String employerAddress;

	@Column(name = "employerCellularPhone")
	private String employerCellularPhone;

	@Column(name = "employerOfficePhone")
	private String employerOfficePhone;

	@Column(name = "previousQualification")
	private String previousQualification;

	@Column(name = "previousExperience")
	private String previousExperience;

	@Column(name = "pStartDateDay")
	private int pStartDateDay;

	@Column(name = "pStartDateMonth")
	private int pStartDateMonth;

	@Column(name = "pStartDateYear")
	private int pStartDateYear;

	@Column(name = "pEndDateDay")
	private int pEndDateDay;

	@Column(name = "pEndDateMonth")
	private int pEndDateMonth;

	@Column(name = "pEndDateYear")
	private int pEndDateYear;

}