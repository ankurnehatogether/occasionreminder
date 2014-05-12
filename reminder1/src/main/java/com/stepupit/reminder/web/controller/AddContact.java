package com.stepupit.reminder.web.controller;

import org.springframework.stereotype.Controller;

@Controller
public class AddContact {

	/*@Autowired
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
	}*/

}
