/**
 *
 */
package com.stepupit.reminder.web.model;

/**
 * @author ank
 *
 */
public class User {

	private String name;

	private String phoneNo;

	private String email;

	private String pwd;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return this.phoneNo;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return this.pwd;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @param pwd
	 *            the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
