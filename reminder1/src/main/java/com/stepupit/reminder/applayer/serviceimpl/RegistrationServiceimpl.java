package com.stepupit.reminder.applayer.serviceimpl;

import javax.transaction.NotSupportedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.stepupit.reminder.applayer.service.RegistrationService;
import com.stepupit.reminder.applayer.utils.ApplicationConstants;
import com.stepupit.reminder.dao.model.GroupsRecord;
import com.stepupit.reminder.dao.model.UserRecord;
import com.stepupit.reminder.dao.service.GroupDao;
import com.stepupit.reminder.dao.service.OccasionDao;
import com.stepupit.reminder.dao.service.UserDao;
import com.stepupit.reminder.web.forms.model.RegistrationBean;

/**
 * @author ank
 *
 */
@Service("registrationService")
public class RegistrationServiceimpl implements RegistrationService {

	@Autowired
	@Qualifier("userDaoService")
	UserDao userDaoService;

	@Autowired
	@Qualifier("groupDaoService")
	GroupDao groupUserDaoService;

	@Autowired
	@Qualifier("occasionDaoService")
	OccasionDao occasionDaoService;

	private void assignDefaultGroupToUser(UserRecord  user) {
		GroupsRecord groupsRecord1 = new GroupsRecord(ApplicationConstants.DEFAULT_GROUP1);
		groupsRecord1.setUserid(user);
		GroupsRecord groupsRecord2 = new GroupsRecord(ApplicationConstants.DEFAULT_GROUP2);
		groupsRecord2.setUserid(user);
		GroupsRecord groupsRecord3 = new GroupsRecord(ApplicationConstants.DEFAULT_GROUP3);
		groupsRecord3.setUserid(user);
		GroupsRecord groupsRecord4 = new GroupsRecord(ApplicationConstants.DEFAULT_GROUP4);
		groupsRecord4.setUserid(user);
		this.groupUserDaoService.save(groupsRecord1);
		this.groupUserDaoService.save(groupsRecord2);
		this.groupUserDaoService.save(groupsRecord3);
		this.groupUserDaoService.save(groupsRecord4);
	}

	private void assignDefaultOccasionsToUser(UserRecord user) {
		//TODO: assign default occasions to this user
	}

	@Override
	public boolean isModelValid(Object onj) throws NotSupportedException {
		throw new NotSupportedException();
	}

	private boolean matchPassword(RegistrationBean reg) {
		return reg.getPassword().equals(reg.getRepassword());

	}

	@Override
	public boolean register(RegistrationBean reg) {
		UserRecord user = null;
		boolean result = false;
		if (matchPassword(reg)) {
			user = new UserRecord(reg.getName(), reg.getPhoneNo(),
					reg.getEmail(), reg.getPassword());
			user.setActiveuser(ApplicationConstants.INACTIVE_USER);
			// till now user is not	active so setting active code as ZERO
			result = this.userDaoService.save(user);
		} else {
			result = ApplicationConstants.FAILED;
		}
		if (result) {
			user = (this.userDaoService.getUserByEmail(reg.getEmail())).get(0);
			assignDefaultGroupToUser(user);
			assignDefaultOccasionsToUser(user);
			// TODO: send email for activation of account
			// buildnotification();
			// emailService.send(notification);
		}

		return result;
	}

}
