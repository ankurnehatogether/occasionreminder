/**
 *
 */
package com.stepupit.reminder.web.model;

/**
 * @author ank
 *
 */
public class Group {

	private String groupName;

	private int advanceDay;

	private int time;


	/**
	 * @return the advanceDay
	 */
	public int getAdvanceDay() {
		return this.advanceDay;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return this.groupName;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return this.time;
	}

	/**
	 * @param advanceDay
	 *            the advanceDay to set
	 */
	public void setAdvanceDay(int advanceDay) {
		this.advanceDay = advanceDay;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

}
