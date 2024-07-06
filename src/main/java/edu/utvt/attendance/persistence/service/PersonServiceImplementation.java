package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.utvt.attendance.persistence.entities.Person;
import edu.utvt.attendance.persistence.repositories.PersonRepository;

@Service
public class PersonServiceImplementation implements PersonService {
	@Autowired
	private PersonRepository personrepository;
	
	@Transactional(readOnly = false)
	public Person save(Person person) {
		return this.personrepository.save(person);
	}


	@Transactional(readOnly= false)
	public Person update(UUID id, Person person) {
		Optional<Person> personOptional = null;
		personOptional = this.findById(id);
		
		if(personOptional.isPresent()) {
			
			personOptional.get().setNombre(person.getNombre());
			personOptional.get().setEdad(person.getEdad());
			personOptional.get().setCorreo(person.getCorreo());
			personOptional.get().setUniversidad(person.getUniversidad());
			personOptional.get().setBirthDate(person.getBirthDate());
			return personrepository.save(person);
			
		}
		return personOptional.orElseThrow();
	}

	@Override
	public List<Person> getAll() {
		return this.personrepository.findAll();
	}

	@Transactional(readOnly = false)
	public ResponseEntity<Person> deleteById(UUID id) {
		
		Optional<Person> personOptional = null;		
		ResponseEntity<Person> responseEntity = null;
		
		
		personOptional =  this.personrepository.findById(id);
		
		if (personOptional.isPresent()) {
			
			this.personrepository.delete(personOptional.get());
			responseEntity = ResponseEntity.noContent().build();
		} else {
			responseEntity = ResponseEntity.notFound().build();
		}
			
		
		return responseEntity;
	}

	@Override
	public Optional<Person> findById(UUID id) {
		return personrepository.findById(id);
	}

	@Override
	public Page<Person> get(int page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

}
