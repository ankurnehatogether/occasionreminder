package com.stepupit.reminder.dao.service;

import java.util.List;

import com.stepupit.reminder.dao.model.User;

public interface UserDao {

	public boolean save(User user);

	public List<User> validateIdPwd( String email, String pwd);
}
