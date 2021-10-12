package com.project.employeeManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * ContactPerson model class contains the data required to store and retrieve contact person informations
 * 
 * @author Aiswarya K S
 * @since 09.10.2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_contact_person")
public class ContactPerson {

	@Id
	@Column(name = "employeeIdNumber" )
	private int employeeIdNumber;

	@Column(name = "cFirstName")
	private String cFirstName;

	@Column(name = "cMiddleName")
	private String cMiddleName;

	@Column(name = "cLastName")
	private String cLastName;

	@Column(name = "cCellularPhone")
	private String cCellularPhone;

	@Column(name = "cHomePhone")
	private String cHomePhone;

	@Column(name = "cCity")
	private String cCity;

	@Column(name = "cAddress")
	private String cAddress;

}

