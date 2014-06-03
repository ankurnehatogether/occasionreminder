package com.stepupit.reminder.dao.service;

import java.util.List;

import com.stepupit.reminder.dao.model.UserRecord;

public interface UserDao {

	public List<UserRecord> getUserByEmail(String email);

	public boolean save(UserRecord user);
}
