package com.spring.app.ws.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.spring.app.ws.model.Person;

public interface PersonDAO {

	int insertPerson(UUID id, Person person);
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
	List<Person> selectAllPeople(); 
	
	Optional<Person> selectByPersonId(UUID id);
	
	int deletePerson(UUID id);
	
	int updatePerson(UUID id, Person person);
}
