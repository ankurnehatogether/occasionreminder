package com.stepupit.reminder.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stepupit.reminder.applayer.service.RegistrationService;
import com.stepupit.reminder.applayer.utils.ApplicationConstants;
import com.stepupit.reminder.web.forms.model.RegistrationBean;

@Controller
public class RegistrationController {

	@Autowired
	@Qualifier("registrationService")
	RegistrationService registration;

	@RequestMapping(value = "register.htm", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView mav = new ModelAndView("registration");
		return mav;
	}

	@RequestMapping(value = "register.htm", method = RequestMethod.POST)
	public ModelAndView registeruser(@ModelAttribute RegistrationBean user){
		ModelAndView mav = new ModelAndView("registration");
		String errorMsg =null;
		String output = null;
		try{
			output = this.registration.register(user);
			if(output != null){
				if(!output.isEmpty() && output.equals(ApplicationConstants.REGISTRATION_SICCESS)){
					mav.addObject("message",ApplicationConstants.REGISTRATION_SICCESS);
				} else{
					mav.addObject("message",ApplicationConstants.REGISTRATION_FAILED);
				}
			}
		}catch(Exception ex){
			errorMsg = ex.getMessage();
		}

		mav.addObject("errorMsg",errorMsg);
		return mav;
	}

}
