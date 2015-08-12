package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import com.model.AcademyGroup;
import com.model.Person;
import com.model.StudentDto;
import com.service.GroupService;
import com.service.PersonService;

import java.util.Map;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private GroupService groupService;

	
	@RequestMapping("/people")
	public String listPeople(Map<String, Object> map) {

		map.put("person", new Person());
		map.put("group", new AcademyGroup());
		
		map.put("student", new StudentDto());
		map.put("peopleList", personService.findAllPersons().iterator());
		map.put("groupList", groupService.getAll());
		
		return "peopleBS";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Transactional
//	public String addPerson(@ModelAttribute("person") Person person) {
public String addPerson(@ModelAttribute("student") StudentDto student){
		Person p = student.getPerson();
		//student.getGroupName();
		//groupService.getByName(student.getGroupName());
		System.out.println(student.getGroupName());
		AcademyGroup group = //groupService.getByName(student.getGroupName());
		groupService.getGroup(student.getGroupId());
		System.out.println(group.getName());
		//group=groupService.getGroup(22L);
		p.setGroup(group);
		personService.addPerson(p);
		//groupService.addGroup(student.getGroup());

		return "redirect:/people";
	}

	@RequestMapping("/delete/{personId}")
	@Transactional
	public String deletePerson(@PathVariable("personId") Long personId) {

		personService.deletePerson(personId);

		return "redirect:/people";
	}
}