package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import edu.utvt.attendance.persistence.entities.Person;

public interface PersonService {
    
	 public Person findById(UUID id);
	 public List<Person> findAll();
	 public Person save(Person persona);
	 public Person update(UUID id, Person personaDetails);
	 void deleteById(UUID id);
}
