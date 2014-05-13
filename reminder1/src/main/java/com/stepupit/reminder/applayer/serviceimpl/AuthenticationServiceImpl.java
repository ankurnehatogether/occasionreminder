/**
 *
 */
package com.stepupit.reminder.applayer.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.stepupit.reminder.applayer.service.AuthenticationService;
import com.stepupit.reminder.dao.model.User;
import com.stepupit.reminder.dao.service.UserDao;
import com.stepupit.reminder.web.model.Login;

/**
 * @author ank
 *
 */

@Service("authService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	@Qualifier("userDao")
	UserDao userDao;

	/* (non-Javadoc)
	 * @see com.stepupit.reminder.applayer.service.AuthenticationService#isAuthorize(com.stepupit.reminder.web.model.Login)
	 */
	@Override
	public boolean isAuthorize(Login login) {
		List<User> userList = null;
		userList = this.userDao.validateIdPwd(login.getEmail(), login.getPassword());
		if(userList!= null && userList.size()>0) {
			return true;
		} else {
			return false;
		}
	}

}
