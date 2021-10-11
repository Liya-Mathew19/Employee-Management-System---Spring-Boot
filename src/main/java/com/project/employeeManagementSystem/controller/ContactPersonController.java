package com.project.employeeManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeeManagementSystem.model.ContactPerson;
import com.project.employeeManagementSystem.service.ContactPersonService;

/*
 * ContactPersonController is responsible for processing user requests of contact informations
 * @author Liya Mathew
 * @since 09/10/2021
 */

@RestController
@RequestMapping("/api/contacts")
public class ContactPersonController {

	@Autowired
	ContactPersonService service;

	/*
	 * getAllcontacts() is used to get all the contact person informations
	 * @return List
	 * @method GET
	 */
	@GetMapping("/contact_info")
	public ResponseEntity<List<ContactPerson>> getAllcontacts() {
		try {
			List<ContactPerson> contactList = service.getAllContacts();
			if (contactList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(contactList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * getContactById() is used to get the contact information based on Employee ID
	 * @param emp_id
	 * @return ContactPerson
	 * @method GET
	 */
	@GetMapping("/contact_info_emp/{emp_id}")
	public ResponseEntity<ContactPerson> getContactById(@PathVariable("emp_id") int id) {
		try {
			Optional<ContactPerson> contact = service.getcontactById(id);
			if (contact.isPresent()) {
				return new ResponseEntity<>(contact.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * getContactById() is used to get the contact information based on contact ID
	 * @param contact_id
	 * @return ContactPerson
	 * @method GET
	 */
	@GetMapping("/contact_info_contact/{contact_id}")
	public ResponseEntity<ContactPerson> getContactByContactId(@PathVariable("contact_id") int id) {
		try {
			Optional<ContactPerson> contact = service.getcontactByContactId(id);
			if (contact.isPresent()) {
				return new ResponseEntity<>(contact.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * createContact() is used to create a new contact info if not exist / update an existing contact info
	 * @param contact
	 * @return ContactPerson
	 * @method POST
	 */
	@PostMapping("/contact_info")
	public ResponseEntity<ContactPerson> createContact(@RequestBody ContactPerson contact) {
		try {
			return new ResponseEntity<>(service.createContact(contact), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * updateContact() is used to update an existing contact info
	 * @param contact
	 * @return ContactPerson
	 * @method PUT
	 */
	@PutMapping("/contact_info")
	public ResponseEntity<ContactPerson> updateContact(@RequestBody ContactPerson contact) {
		try {
			ContactPerson entity = service.updateContact(contact);
			if (entity != null) {
				return new ResponseEntity<>(entity, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * deleteContactById() is used to delete the contact info based on Contact ID
	 * @param emp_id
	 * @return HttpStatus
	 * @method DELETE
	 */
	@DeleteMapping("/contact_info/{contact_id}")
	public ResponseEntity<HttpStatus> deleteContactById(@PathVariable("contact_id") int id) {
		try {
			service.deleteContactById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
