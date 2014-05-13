package com.stepupit.reminder.applayer.service;

import com.stepupit.reminder.web.model.Login;

public interface AuthenticationService {

	public boolean isAuthorize(Login login);

}
