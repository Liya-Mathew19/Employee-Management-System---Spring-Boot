package com.project.employeeManagementSystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employeeManagementSystem.model.TimeInformation;
import com.project.employeeManagementSystem.repository.TimeInformationRepository;

@Service
@Transactional
public class TimeInformationService {
	
	@Autowired
	private TimeInformationRepository repository;
	
	public List<TimeInformation> getTimeInformations() {
		return repository.findAll();
	}

	public TimeInformation getTimeInformation(Integer Id) {
		return repository.getOne(Id);
	}

	public TimeInformation addTimeInformation(TimeInformation timeinformation) {
		repository.save(timeinformation);
		return timeinformation;
	}

	public TimeInformation updateTimeInformation(TimeInformation timeinformation) {
		repository.save(timeinformation);
		return timeinformation;
	}

	public void deleteTimeInformation(Integer parseLong) {
		TimeInformation entity=repository.getOne(parseLong);
		repository.delete(entity);
	}
}
