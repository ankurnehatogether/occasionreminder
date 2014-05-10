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
		this.sessionFactory.getCurrentSession().save(group);
	}

	@Override
	public List<UserGroups> listGroup() {
		return this.sessionFactory.getCurrentSession().createQuery("from UserGroups")
				.list();	}

	@Override
	public void removeGroup(Integer id) {
		UserGroups group = (UserGroups) this.sessionFactory.getCurrentSession().load(
				UserGroups.class, id);
		if (null != group) {
			this.sessionFactory.getCurrentSession().delete(group);
		}
	}

}
