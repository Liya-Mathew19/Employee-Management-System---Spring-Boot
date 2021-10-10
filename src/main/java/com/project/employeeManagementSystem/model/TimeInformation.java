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
@Table(name = "tbl_time_information")
public class TimeInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int timeId;
	
	@Column(name = "employeeIdNumber" )
	int employeeIdNumber;
	
	@Column(name = "Workred_Hours")
	private int Workred_Hours;
	
	@Column(name = "Off_Hours")
	private int Off_Hours;
	
	@Column(name = "Days_Off")
	private int Days_Off;
	
	@Column(name = "Over_Time")
	private int Over_Time;
	
	@Column(name = "Extra_Days")
	private int Extra_Days;
	
	@Column(name = "w_From_Date_Day")
	private int w_From_Date_Day;
	
	@Column(name = "w_From_Date_Month")
	private int w_From_Date_Month;
	
	@Column(name = "w_From_Date_Year")
	private int w_From_Date_Year;
	
	@Column(name = "w_To_Date_Day")
	private int w_To_Date_Day;
	
	@Column(name = "w_To_Date_Month")
	private int w_To_Date_Month;
	
	@Column(name = "w_To_Date_Year")
	private int w_To_Date_Year;
}
