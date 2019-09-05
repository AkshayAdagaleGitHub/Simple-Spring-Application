package com.spring.app.ws.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.spring.app.ws.model.Person;

@Repository("PersonDAO")
public class PersonDataAccessService implements PersonDAO{

	private List<Person> DB = new ArrayList<>();
	
	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName()));
		return 0;
	}

	@Override
	public List<Person> selectAllPeople() {
		return DB;
	}

	@Override
	public Optional<Person> selectByPersonId(UUID id) {
	  return DB.stream()
			  .filter(person -> person.getId().equals(id))
			  .findFirst();
	}

	@Override
	public int deletePerson(UUID id) {
		Optional<Person> personMayBe = selectByPersonId(id);
		if(personMayBe.isPresent()) {
			DB.remove(personMayBe.get());
			return 1;
		}
		return 0;
	}

	@Override
	public int updatePerson(UUID id, Person personToUpdate) {
		return selectByPersonId(id)
				.map(person -> {
					int indexOfPersonToUpdate = DB.indexOf(person);
					if(indexOfPersonToUpdate >= 0) {
						DB.set(indexOfPersonToUpdate, new Person(id, personToUpdate.getName()));
						return 1;
					}
						return 0;						
				})
				.orElse(0);
	}
	
	
}
