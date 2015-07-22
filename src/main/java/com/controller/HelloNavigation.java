package com.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloNavigation {
	 
	 
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
}