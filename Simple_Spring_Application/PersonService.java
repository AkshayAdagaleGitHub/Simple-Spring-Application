package com.spring.app.ws.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.app.ws.dao.PersonDAO;
import com.spring.app.ws.model.Person;

@Service
public class PersonService {

	private final PersonDAO personDAO;
	
	@Autowired
	public PersonService(@Qualifier("PersonDAO") PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	public int addPerson(Person person) {
		return personDAO.insertPerson(person);
	}
	
	public List<Person> getAllPeople(){
		return personDAO.selectAllPeople();
	}
	
	public Optional<Person> getPersonById(UUID id){
		return personDAO.selectByPersonId(id);
	}
	
	public int deletePerson(UUID id) {
		return personDAO.deletePerson(id);
	}
	
	public int updatePerson(UUID id, Person person) {
		return personDAO.updatePerson(id, person);
	}
	
}
