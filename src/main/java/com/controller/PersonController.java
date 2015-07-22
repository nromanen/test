package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Person;
import com.service.PersonService;

import java.util.Map;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping("/people")
	public String listPeople(Map<String, Object> map) {

		map.put("person", new Person());
		map.put("peopleList", personService.findAllPersons().iterator());
		return "peopleBS";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Transactional
	public String addPerson(@ModelAttribute("person") Person person) {

		personService.addPerson(person);

		return "redirect:/people";
	}

	@RequestMapping("/delete/{personId}")
	@Transactional
	public String deletePerson(@PathVariable("personId") Long personId) {

		personService.deletePerson(personId);

		return "redirect:/people";
	}
}