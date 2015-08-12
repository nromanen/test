package com.dao;

import java.util.List;

import com.model.Person;

public interface PersonDao {

	void insert(Person person);

	void delete(Long personID);

	List<Person> selectAll();

	Person getById(Long id);

}
