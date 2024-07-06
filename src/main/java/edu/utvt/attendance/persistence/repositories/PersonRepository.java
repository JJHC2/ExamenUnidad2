package edu.utvt.attendance.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.attendance.persistence.entities.Person;

public interface PersonRepository extends JpaRepository<Person, UUID> {

}
