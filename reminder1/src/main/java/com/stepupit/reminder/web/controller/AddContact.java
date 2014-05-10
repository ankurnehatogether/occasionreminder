package com.stepupit.reminder.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stepupit.reminder.dao.model.UserGroups;
import com.stepupit.reminder.dao.service.UserGroupService;

@Controller
public class AddContact {

	@Autowired
	@Qualifier("UserGroupService")
	private UserGroupService userGroupService;
	private static final Logger logger = Logger.getLogger(AddContact.class);

	@RequestMapping(value = "/addContct.htm", method = RequestMethod.GET)
	public ModelAndView addContact() {
		ModelAndView model = new ModelAndView("newContact");
		AddContact.logger.info("get method");
		model.addObject("message", "Spring 3 MVC Hello World");
		return model;
	}

	@RequestMapping(value = "/addContct.htm", method = RequestMethod.POST)
	public ModelAndView getPage(@ModelAttribute UserGroups group ) {
		ModelAndView mav = new ModelAndView("newContact");
		AddContact.logger.info("post  method");
		this.userGroupService.addGroup(group);
		mav.addObject("message", group.getGrpName());
		return mav;
	}

}
