package com.stepupit.reminder.applayer.service;

import com.stepupit.reminder.web.forms.model.RegistrationBean;


/**
 * @author ank
 *
 */


public interface RegistrationService extends AppService{

	public boolean register(RegistrationBean user);



}
