package com.stepupit.reminder.applayer.serviceimpl;

import javax.transaction.NotSupportedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.stepupit.reminder.applayer.service.RegistrationService;
import com.stepupit.reminder.applayer.utils.ApplicationConstants;
import com.stepupit.reminder.dao.model.User;
import com.stepupit.reminder.dao.service.UserDao;

/**
 * @author ank
 *
 */
@Service("registrationService")
public class RegistrationServiceimpl  implements RegistrationService{

	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	@Override
	public boolean isModelValid(Object onj) throws NotSupportedException{
		throw new NotSupportedException();
	}

	@Override
	public String register(com.stepupit.reminder.web.model.User user) {

		User userdao = new User(user.getName(), user.getPhoneNo(), user.getEmail(), user.getPwd());
		boolean result =this.userDao.save(userdao);
		if (result){
			return ApplicationConstants.SICCESS;
		}else{
			return ApplicationConstants.FAILED;
		}

	}

}
