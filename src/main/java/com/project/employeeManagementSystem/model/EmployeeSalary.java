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
 * EmployeeSalary model class contains the data of the application.
 * @author Kishore Kumar
 * @since 09/10/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_employee_salary")
public class EmployeeSalary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int salaryId;

	@Column(name = "employeeIdNumber")
	private int employeeIdNumber;

	@Column(name = "MonthlySalary")
	private Double MonthlySalary;

	@Column(name = "MonthlyMoneyCurrency")
	private String MonthlyMoneyCurrency;

	@Column(name = "MonthlyTaxes")
	private Double MonthlyTaxes;

	@Column(name = "MonthlyDeductions")
	private Double MonthlyDeductions;

	@Column(name = "MonthlyInsurances")
	private Double MonthlyInsurances;

	@Column(name = "msFromDateDay")
	private int msFromDateDay;

	@Column(name = "msFromDateMonth")
	private int msFromDateMonth;

	@Column(name = "msFromDateYear")
	private int msFromDateYear;

	@Column(name = "msToDateDay")
	private int msToDateDay;

	@Column(name = "msToDateMonth")
	private int msToDateMonth;

	@Column(name = "msToDateYear")
	private int msToDateYear;

	@Column(name = "WeeklySalary")
	private Double WeeklySalary;

	@Column(name = "WeeklyMoneyCurrency")
	private String WeeklyMoneyCurrency;

	@Column(name = "WeeklyTaxes")
	private Double WeeklyTaxes;

	@Column(name = "WeeklyDeduction")
	private Double WeeklyDeduction;

	@Column(name = "WeeklyInsurances")
	private Double WeeklyInsurances;

	@Column(name = "wsFromDateDay")
	private int wsFromDateDay;

	@Column(name = "wsFromdateMonth")
	private int wsFromDateMonth;

	@Column(name = "wsFromDateYear")
	private int wsfromDateYear;

	@Column(name = "wsToDateDay")
	private int wsToDateDay;

	@Column(name = "wsToDateMonth")
	private int wsToDateMonth;

	@Column(name = "wsToDateYear")
	private int wsToDateYear;

}
