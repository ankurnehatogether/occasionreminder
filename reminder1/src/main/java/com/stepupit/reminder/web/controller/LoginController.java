package com.stepupit.reminder.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stepupit.reminder.applayer.service.AuthenticationService;
import com.stepupit.reminder.web.model.Login;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("authService")
	private AuthenticationService authService;

	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public ModelAndView getPage(@ModelAttribute Login login) {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}


	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute Login login) {
		ModelAndView mav = null;
		boolean result = this.authService.isAuthorize(login);
		if (result) {
			mav = new ModelAndView("home");
		} else {
			mav = new ModelAndView("login");
			mav.addObject("errMag", "Login Failed");
		}
		return mav;
	}
}
