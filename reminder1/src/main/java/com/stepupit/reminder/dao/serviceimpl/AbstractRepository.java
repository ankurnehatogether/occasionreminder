package com.stepupit.reminder.dao.serviceimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.stepupit.reminder.dao.service.RepositoryDao;

public abstract class AbstractRepository<T>  implements RepositoryDao<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public boolean delete(T t){
		Session sess = null;
		sess = this.sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(t);
		tx.commit();
		sess.close();
		return true;
	}

	@Override
	public boolean save(T t) {
		Session sess = null;
		sess = this.sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		sess.close();
		return true;
	}
	@Override
	public boolean update(T t){
		Session sess = null;
		sess = this.sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(t);
		tx.commit();
		sess.close();
		return true;
	}

}
