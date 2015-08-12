package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.PersonDao;
import com.model.Person;

@Component
@Transactional
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	@Autowired
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void addPerson(Person person) {
		getPersonDao().insert(person);
	}

	public List<Person> findAllPersons() {
		return getPersonDao().selectAll();
	}

	public void deletePerson(Long personID) {
		getPersonDao().delete(personID);
	}

	public Person getPerson(Long id) {
		return getPersonDao().getById(id);
	}

	public double getSalaries() {
		double money = 0;
		for (Person person : getPersonDao().selectAll()) {
			money += person.getMoney();
		}
		return money * 0.8;
	}

}