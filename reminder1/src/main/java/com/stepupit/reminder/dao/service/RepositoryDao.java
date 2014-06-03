package com.stepupit.reminder.dao.service;

public interface RepositoryDao<T> {

	public boolean delete(T t);
	public boolean get(T t);
	public boolean save(T t);
	public boolean update(T t);

}
