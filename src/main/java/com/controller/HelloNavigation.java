package com.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.SessionDao;
import com.dao.SubjectDao;
import com.model.AcademyGroup;
import com.model.Person;
import com.model.Session;
import com.model.Subject;
import com.service.GroupService;
import com.service.PersonService;

@Controller
public class HelloNavigation {
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private PersonService personService;
	@Autowired
	private GroupService groupService;
	@Autowired 
	private SessionDao sessionDao;

	@RequestMapping("/wwelcome")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from HelloNavigation.java **********</div><br><br>";
		return new ModelAndView("wwelcome", "message", message);
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.POST)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName()
					+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg",
					"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;
	}

	@RequestMapping("/rest")
	public String rest() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from HelloNavigation.java **********</div><br><br>";
		return "rest";
	}

	@RequestMapping("/session")
	public String session(Map<String, Object> map) {

		/*
		 * map.put("person", new Person()); map.put("group", new
		 * AcademyGroup());
		 * 
		 * map.put("student", new Student()); map.put("peopleList",
		 * personService.findAllPersons().iterator());
		 */
		map.put("subjectList", subjectDao.getAll());
		map.put("studentList", personService.findAllPersons());

		Person person = new Person();
		person.setFirstName("FN Bla-Bla-Bla And One More");
		person.setLastName("lastName Bla");
		person.setMoney(2.5d);

		AcademyGroup group = new AcademyGroup();
		group.setName("newGroup (N+2)");
		groupService.addGroup(group);

		person.setGroup(group);

		//personService.addPerson(person);

		System.out.println("person" + person.getLastName() + " added");

		Subject subject = new Subject();
		subject.setName("teddstSubject 3");
		subject.setTypeOfReport("N/A");

		subjectDao.add(subject);

		Session session = new Session();
		session.setPerson(person);
		session.setSubject(subject);
		session.setMark(10);

		Set<Session> sessions = new HashSet<>();
		sessions.add(session);
		person.setSessions(sessions);

		personService.addPerson(person);

		System.out.println("person" + person.getLastName() + " added");

/*
		Person person = personService.getPerson(3L);
		Subject subject = subjectDao.getSubject(1L);
		
		Session session = new Session();
		session.setPerson(person);
		session.setSubject(subject);
		session.setMark(3);
		sessionDao.add(session);

		//Set<Session> sessions = new HashSet<>();
		//sessions.add(session);
		//person.setSessions(sessions);
		//personService.addPerson(person);
*/
		return "session";
	}
}
