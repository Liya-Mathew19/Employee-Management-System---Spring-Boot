package com.project.employeeManagementSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employeeManagementSystem.model.ContactPerson;
import com.project.employeeManagementSystem.repository.ContactPersonRepository;
/*
 * ContactPersonService is used to perform service tasks of Contact Person Information module
 * @author Liya Mathew
 * @since 09/10/2021
 */
@Service
@Transactional
public class ContactPersonService {

	@Autowired
	ContactPersonRepository repository;

	/*
	 * getAllContacts() is used to get all the employee contact person details
	 * @return List
	 */
	public List<ContactPerson> getAllContacts(){
		List<ContactPerson> contactList = repository.findAll();
		if(contactList.size() > 0) {
			return contactList;
		} else {
			return new ArrayList<ContactPerson>();
		}
	}

	/*
	 * getcontactById() is used to get the contact details based on the Employee ID
	 * @param id
	 * @return ContactPerson
	 */
	public Optional<ContactPerson> getcontactById(int id) {
		Optional<ContactPerson> contact = repository.findByemployeeIdNumber(id);
		return contact;
	}
	
	/*
	 * getcontactByContactId() is used to get the contact details based on the contact ID
	 * @param id
	 * @return ContactPerson
	 */
	public Optional<ContactPerson> getcontactByContactId(int id) {
		Optional<ContactPerson> contact = repository.findBycontactId(id);
		return contact;
	}

	/*
	 * createContact() is used to create a new contact info if not exist / update an existing contact info
	 * @param entity
	 * @return ContactPerson
	 */
	public ContactPerson createContact(ContactPerson entity) {
		Optional<ContactPerson> contact = repository.findByemployeeIdNumber(entity.getContactId());

		if(contact.isPresent()) {
			return this.updateContact(entity);
		} else {
			entity = repository.save(entity);
			return entity;
		}
	} 

	/*
	 * updateContact() update an existing contact info
	 * @param entity
	 * @return ContactPerson
	 */
	public ContactPerson updateContact(ContactPerson entity) {
		Optional<ContactPerson> contact = repository.findByemployeeIdNumber(entity.getContactId());

		if(contact.isPresent()) {
			ContactPerson contactEntity = contact.get();
			contactEntity.setEmployeeIdNumber(entity.getEmployeeIdNumber());
			contactEntity.setCFirstName(entity.getCFirstName());
			contactEntity.setCMiddleName(entity.getCMiddleName());
			contactEntity.setCLastName(entity.getCLastName());
			contactEntity.setCCellularPhone(entity.getCCellularPhone());
			contactEntity.setCHomePhone(entity.getCHomePhone());
			contactEntity.setCCity(entity.getCCity());
			contactEntity.setCAddress(entity.getCAddress());
			contactEntity = repository.save(contactEntity);
			return contactEntity;
		}
		else {
			entity = null;
			return entity;
		}
	} 

	/*
	 * deleteContactById() is used to delete the contact info based on Employee ID
	 * @param id
	 * @return null
	 */
	public void deleteContactById(int id){
		Optional<ContactPerson> contact = repository.findByemployeeIdNumber(id);    
		if(contact.isPresent()) {
			repository.deleteBycontactId(id);
		}
		else {
			return;
		}
	}
}
