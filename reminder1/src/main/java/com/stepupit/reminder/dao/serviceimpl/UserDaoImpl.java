package com.stepupit.reminder.dao.serviceimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stepupit.reminder.dao.model.User;
import com.stepupit.reminder.dao.service.UserDao;

@Service("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private  SessionFactory sessionFactory;

	@Override
	public boolean save(User user) {
		Session session = null;
		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public List<User> validateIdPwd(String email, String pwd) {
		Session session = null;
		session = this.sessionFactory.openSession();
		Query query = session.createQuery("from User where email = :email  and password = :password");
		query.setParameter("email", email);
		query.setParameter("password", pwd);
		List<User> list = query.list();
		session.close();
		return list;
	}

}
