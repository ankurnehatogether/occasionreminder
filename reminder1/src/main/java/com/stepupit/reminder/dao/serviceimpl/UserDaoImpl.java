package com.stepupit.reminder.dao.serviceimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stepupit.reminder.dao.model.UserRecord;
import com.stepupit.reminder.dao.service.UserDao;

@Service("userDaoService")
public class UserDaoImpl implements UserDao{

	@Autowired
	private  SessionFactory sessionFactory;

	@Override
	public List<UserRecord> getUserByEmail(String email) {

		Session session = null;
		session = this.sessionFactory.openSession();
		Query query = session.createQuery("from User where email = :email");
		query.setParameter("email", email);
		List<UserRecord> usersList = query.list();
		session.close();
		return usersList;

	}


	@Override
	public boolean save(UserRecord user) {
		Session session = null;
		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		return true;
	}


}
