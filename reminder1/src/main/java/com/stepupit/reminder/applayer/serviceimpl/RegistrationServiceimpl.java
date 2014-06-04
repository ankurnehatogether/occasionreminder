package com.stepupit.reminder.applayer.serviceimpl;

import javax.transaction.NotSupportedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.stepupit.reminder.applayer.service.RegistrationService;
import com.stepupit.reminder.applayer.utils.ApplicationConstants;
import com.stepupit.reminder.dao.model.GroupsRecord;
import com.stepupit.reminder.dao.model.OccasionsRecord;
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
		GroupsRecord groupsRecord1 = new GroupsRecord(ApplicationConstants.DEFAULT_GROUP1,user);
		GroupsRecord groupsRecord2 = new GroupsRecord(ApplicationConstants.DEFAULT_GROUP2,user);
		GroupsRecord groupsRecord3 = new GroupsRecord(ApplicationConstants.DEFAULT_GROUP3,user);
		GroupsRecord groupsRecord4 = new GroupsRecord(ApplicationConstants.DEFAULT_GROUP4,user);
		this.groupUserDaoService.save(groupsRecord1);
		this.groupUserDaoService.save(groupsRecord2);
		this.groupUserDaoService.save(groupsRecord3);
		this.groupUserDaoService.save(groupsRecord4);

	}

	private void assignDefaultOccasionsToUser(UserRecord user) {
		OccasionsRecord record1 = new OccasionsRecord(ApplicationConstants.DEFAULT_OCCASION1,user);
		OccasionsRecord record2 = new OccasionsRecord(ApplicationConstants.DEFAULT_OCCASION2,user);
		this.occasionDaoService.save(record1);
		this.occasionDaoService.save(record2);
	}

	private void initializeUserFacitilies(UserRecord user) {
		assignDefaultGroupToUser(user);
		assignDefaultOccasionsToUser(user);
	}

	@Override
	public boolean isModelValid(Object onj) throws NotSupportedException {
		throw new NotSupportedException();
	}

	private boolean matchPassword(RegistrationBean reg) {
		return reg.getPassword().equals(reg.getRepassword());

	}

	@Override
	public String register(RegistrationBean reg) {
		UserRecord user = null;
		boolean isSaved = false;
		String result=null;
		if (matchPassword(reg)) {
			user = new UserRecord(reg.getName(), reg.getPhoneNo(),
					reg.getEmail(), reg.getPassword());
			user.setActiveuser(ApplicationConstants.INACTIVE_USER);
			// till now user is not	active so setting active code as ZERO
			isSaved= this.userDaoService.save(user);
			if(isSaved){
				result = ApplicationConstants.SUCCESS;
				initializeUserFacitilies(user);
				user = (this.userDaoService.getUserByEmail(reg.getEmail())).get(0);
				// TODO: send email for activation of account asynchronously
				// buildnotification();
				// emailService.send(notification);
			}else{
				result = ApplicationConstants.FAILED;
			}
		} else {
			result = ApplicationConstants.FAILED;
		}

		return result;
	}

}
