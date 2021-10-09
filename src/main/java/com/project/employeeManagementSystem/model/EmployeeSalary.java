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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_employee_salary")
public class EmployeeSalary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeIdNumber")
	private int id;
	
	@Column(name = "MonthlySalary")
	private Double MonthlySalary;
	
	@Column(name = "MonthlyMoneyCurrency")
	private Double MonthlyMoneyCurrency;
	
	@Column(name = "MonthlyTaxes")
	private Double MonthlyTaxes;
	
	@Column(name = "MonthlyDeductions")
	private Double MonthlyDeductions;
	
	@Column(name = "MonthlyInsurances")
	private Double MonthlyInsurances;
	
	@Column(name = "msFromDateDay")
	private Double msFromDateDay;
	
	@Column(name = "msFromDateYear")
	private Double msFromDateYear;
	
	@Column(name = "msToDateDay")
	private Double msToDateDay;
	
	@Column(name = "msToDateMonth")
	private Double msToDateMonth;
	
	@Column(name = "msToDateYear")
	private Double msToDateYear;
	
	@Column(name = "WeeklySalary")
	private Double WeeklySalary;
	
	@Column(name = "WeeklyMoneyCurrency")
	private Double WeeklyMoneyCurrency;
	
	@Column(name = "WeeklyTaxes")
	private Double WeeklyTaxes;
	
	@Column(name = "WeeklyDeduction")
	private Double WeeklyDeduction;
	
	@Column(name = "WeeklyInsurances")
	private Double WeeklyInsurances;
	
	@Column(name = "wsFromDateDay")
	private Double wsFromDateDay;
	
	@Column(name = "wsFromdateMonth")
	private Double wsFromDateMonth;
	
	@Column(name = "wsFromDateYear")
	private Double wsfromDateYear;
	
	@Column(name = "wsToDateDay")
	private Double wsToDateDay;
	
	@Column(name = "wsToDateMonth")
	private Double wsToDateMonth;
	
	@Column(name = "wsToDateYear")
	private Double wsToDateYear;
	
}
