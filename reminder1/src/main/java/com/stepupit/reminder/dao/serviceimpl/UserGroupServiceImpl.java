package com.stepupit.reminder.dao.serviceimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stepupit.reminder.dao.model.UserGroups;
import com.stepupit.reminder.dao.service.UserGroupService;

@Repository("UserGroupService")
public class UserGroupServiceImpl implements UserGroupService{


	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void addGroup(UserGroups group) {
		Session sess = null;
		sess = this.sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(group);
		tx.commit();
		sess.close();
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
