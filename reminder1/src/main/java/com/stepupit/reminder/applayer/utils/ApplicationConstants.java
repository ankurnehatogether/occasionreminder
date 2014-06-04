/**
 *
 */
package com.stepupit.reminder.applayer.utils;

import com.stepupit.reminder.dao.model.OccasionsRecord;

/**
 * @author ank
 *
 */
public interface ApplicationConstants {

	public static final String SUCCESS = "SUCCESS";
	public static final String FAILED = "FAILURE";
	public static final String REGISTRATION_SICCESS = "REGISTRATION IS SUCCESSFUL";
	public static final String REGISTRATION_FAILED = "REGISTRATION IS FAILED";
	public static final int INACTIVE_USER = 0;
	public static final int ACTIVE_USER = 1;
	public static final String DEFAULT_GROUP1 = "HOME";
	public static final String DEFAULT_GROUP2 = "OFFICE";
	public static final String DEFAULT_GROUP3 = "FRIENDS";
	public static final String DEFAULT_GROUP4 = "RELATIVES";

	public static final String DEFAULT_OCCASION1 = "BirthDay";
	public static final String DEFAULT_OCCASION2 = "ANNIVERSARY";

	OccasionsRecord occasion1 = new OccasionsRecord(ApplicationConstants.DEFAULT_OCCASION1);
	OccasionsRecord occasion2 = new OccasionsRecord(ApplicationConstants.DEFAULT_OCCASION2);

}
