package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.utvt.attendance.persistence.entities.Person;
import edu.utvt.attendance.persistence.repositories.PersonRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonServiceImplementation implements PersonService {
	 @Autowired
	    private PersonRepository personaRepository;

	@Override
	public Person findById(UUID id) {
		return personaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Person> findAll() {
		 return personaRepository.findAll();
	}

	@Override
	public Person save(Person persona) {
		  return personaRepository.save(persona);
	}

	 @Override
	    public Person update(UUID id, Person personaDetails) {
	        Person persona = personaRepository.findById(id).orElse(null);
	        if (persona != null) {
	            persona.setNombre(personaDetails.getNombre());
	            persona.setEdad(personaDetails.getEdad());
	            persona.setUniversidad(personaDetails.getUniversidad());
	            persona.setCorreo(personaDetails.getCorreo());
	            persona.setFechaNacimiento(personaDetails.getFechaNacimiento());
	            return personaRepository.save(persona);
	        }
	        return null;
	    }

	 @Override
	    public void deleteById(UUID id) {
	        personaRepository.deleteById(id);
	    }

}
