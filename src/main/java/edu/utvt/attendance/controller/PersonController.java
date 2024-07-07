package edu.utvt.attendance.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.utvt.attendance.persistence.entities.Person;
import edu.utvt.attendance.persistence.service.PersonService;

@RestController
@RequestMapping("/api/personas")
public class PersonController {
	 @Autowired
	    private PersonService personaService;
	 
	 @GetMapping
	    public ResponseEntity<List<Person>> getAllPersonas() {
	        List<Person> personas = personaService.findAll();
	        return ResponseEntity.ok().body(personas);
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Person> getPersonaById(@PathVariable(value = "id") UUID personaId) {
	        Person persona = personaService.findById(personaId);
	        if (persona == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(persona);
	    }
	 
	 @PostMapping
	    public ResponseEntity<Person> createPersona(@RequestBody Person persona) {
	        Person createdPersona = personaService.save(persona);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdPersona);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Person> updatePersona(@PathVariable(value = "id") UUID personaId,
	                                                 @RequestBody Person personaDetails) {
	        Person updatedPersona = personaService.update(personaId, personaDetails);
	        if (updatedPersona == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(updatedPersona);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePersona(@PathVariable(value = "id") UUID personaId) {
	        personaService.deleteById(personaId);
	        return ResponseEntity.noContent().build();
	    }
}
