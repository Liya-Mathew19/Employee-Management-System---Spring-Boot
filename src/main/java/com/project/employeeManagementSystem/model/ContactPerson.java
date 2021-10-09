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
@Table(name = "tbl_contact_person")
public class ContactPerson {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int contactId;
	
	@Column(name = "employeeIdNumber" )
	int employeeIdNumber;
	
	@Column(name = "cFirstName")
	String cFirstName;

	@Column(name = "cMiddleName")
	String cMiddleName;

	@Column(name = "cLastName")
	String cLastName;

	@Column(name = "cCellularPhone")
	String cCellularPhone;

	@Column(name = "cHomePhone")
	String cHomePhone;

	@Column(name = "cCity")
	String cCity;

	@Column(name = "cAddress")
	String cAddress;

}

