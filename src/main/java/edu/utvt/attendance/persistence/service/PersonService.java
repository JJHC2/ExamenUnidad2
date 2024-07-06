package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import edu.utvt.attendance.persistence.entities.Person;

public interface PersonService {
	
   public Person save(Person person);
	
	public Person update(UUID id, Person person);
	
	public List<Person> getAll();
	
	public Optional<Person> findById(UUID id);
	
	public ResponseEntity<Person> deleteById(UUID id);	
	
	public Page<Person>get(int page, Integer size);
}
