package com.stepupit.reminder.dao.serviceimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.stepupit.reminder.dao.model.UserGroups;
import com.stepupit.reminder.dao.service.UserGroupService;

public class UserGroupServiceImpl implements UserGroupService{

	
	 @Autowired
	    private SessionFactory sessionFactory;
	 
	 
	@Override
	public void addGroup(UserGroups group) {
		 sessionFactory.getCurrentSession().save(group);		
	}

	@Override
	public List<UserGroups> listGroup() {
		return sessionFactory.getCurrentSession().createQuery("from UserGroups")
                .list();	}

	@Override
	public void removeGroup(Integer id) {
		UserGroups group = (UserGroups) sessionFactory.getCurrentSession().load(
				UserGroups.class, id);
        if (null != group) {
            sessionFactory.getCurrentSession().delete(group);
        }		
	}

}
