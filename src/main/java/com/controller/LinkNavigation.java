package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkNavigation {
	
	@RequestMapping(value="/", method=RequestMethod.GET)//  
	public ModelAndView homePage() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView indexPage() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/sec/moderation", method=RequestMethod.GET)
	public ModelAndView moderatorPage() {
		return new ModelAndView("moderation");
	}
	
	@RequestMapping(value="/admin/first", method=RequestMethod.GET)
	public ModelAndView firstAdminPage() {
		return new ModelAndView("admin-first");
	}
	
	//@Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/admin/second", method=RequestMethod.GET)
	public ModelAndView secondAdminPage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("admin-second");
		if (request.isUserInRole("ROLE_ADMIN")){
			System.out.println("Yesssss ;)");
			model.addObject("oneMoreAttribute", "attributeValue");
		}
		else{
			System.out.println("Oh, nooooo ;(");
		}
		
		 if (request instanceof SecurityContextHolderAwareRequestWrapper) {
	            SecurityContextHolderAwareRequestWrapper requestWrapper = 
	                       (SecurityContextHolderAwareRequestWrapper) request;
	            System.out.println("Oh, nooooo one more ;-(");

		 }
return model;
	
	}
}
