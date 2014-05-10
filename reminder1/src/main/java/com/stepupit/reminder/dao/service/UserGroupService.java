
package com.stepupit.reminder.dao.service;

import java.util.List;

import com.stepupit.reminder.dao.model.UserGroups;

/**
 * @author ank
 *
 */
public interface UserGroupService {

	public void addGroup(UserGroups contact);

	public List<UserGroups> listGroup();

	public void removeGroup(Integer id);

}
