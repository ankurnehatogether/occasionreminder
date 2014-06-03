package com.stepupit.reminder.applayer.service;

import com.stepupit.reminder.web.forms.model.LoginBean;

public interface AuthenticationService {

	public boolean isAuthorize(LoginBean login);

}
