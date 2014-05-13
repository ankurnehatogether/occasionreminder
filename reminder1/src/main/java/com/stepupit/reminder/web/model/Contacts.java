/**
 *
 */
package com.stepupit.reminder.web.model;

import java.util.List;

/**
 * @author ank
 *
 */
public class Contacts {

	private String name;

	private String email;

	private String phoneNo;

	private List<String> group;

	private String occasion;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @return the group
	 */
	public List<String> getGroup() {
		return this.group;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the occasion
	 */
	public String getOccasion() {
		return this.occasion;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return this.phoneNo;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param group
	 *            the group to set
	 */
	public void setGroup(List<String> group) {
		this.group = group;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param occasion
	 *            the occasion to set
	 */
	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
