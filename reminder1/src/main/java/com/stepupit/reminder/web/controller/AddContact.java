package com.stepupit.reminder.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stepupit.reminder.web.model.Contact;

@Controller
public class AddContact {

	
	private static final Logger logger = Logger.getLogger(AddContact.class);
	
	@RequestMapping(value = "/addContct.htm", method = RequestMethod.GET)
	public ModelAndView addContact() {
		ModelAndView model = new ModelAndView("newContact");
		logger.info("get method");
		model.addObject("message", "Spring 3 MVC Hello World");
		return model;
	}
	
	@RequestMapping(value = "/addContct.htm", method = RequestMethod.POST)
	public ModelAndView getPage(@ModelAttribute Contact contact ) {
		ModelAndView mav = new ModelAndView("newContact");
		logger.info("post  method");
		mav.addObject("message", contact.getName());
		return mav;
	}
	
}
