/**
 *
 */
package com.stepupit.reminder.applayer.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.stepupit.reminder.applayer.service.AuthenticationService;
import com.stepupit.reminder.dao.model.UserRecord;
import com.stepupit.reminder.dao.service.UserDao;
import com.stepupit.reminder.web.forms.model.LoginBean;

/**
 * @author ank
 *
 */

@Service("authService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	@Qualifier("userDao")
	UserDao userDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.stepupit.reminder.applayer.service.AuthenticationService#isAuthorize
	 * (com.stepupit.reminder.web.model.Login)
	 */
	@Override
	public boolean isAuthorize(LoginBean login) {
		boolean result = false;
		List<UserRecord> userList = null;
		if (login.getEmail() != null && login.getPassword() != null) { // TODO add apache commons and use String not empty
			userList = this.userDao.getUserByEmail(login.getEmail());

			if (userList != null && userList.size() == 1) {
				if (login.getPassword().equals(userList.get(0).getPassword())) {
					result = true;
				} else {
					result = false;
				}
			} else {
				result = false;
			}
		}
		return result;
	}

}
